package com.jonak.lib;

import com.jonak.lib.MySQLDatabase;

import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * Created by lenin on 11/22/14.
 */
public class Configuration {

    private static String _tableName = "configuration";
    private static String _fieldName = "*";
    // set a configuration
    public static void set( String name, String value) throws Exception
    {
        // db instance
        MySQLDatabase db = new MySQLDatabase();

        // prepare fields
        ArrayList _fields = new ArrayList(),
                _types  = new ArrayList(),
                _values = new ArrayList();

        _fields.add("name"); _types.add("String"); _values.add( name );
        _fields.add("value"); _types.add("String"); _values.add( value );

        // check if the name is already saved
        int id = Configuration.getID( name );

        if( id == 0 ) {
            // add
            db.executeInsertQuery( _tableName, _fields, _types, _values );
            db.closeConnection();
        } else {
            // update
            db.executeUpdateQuery( _tableName, _fields, _types, _values, id );
            db.closeConnection();
        }
    }

    // get a configuration
    public static String get( String name ) throws Exception
    {
        // db instance
        MySQLDatabase db = new MySQLDatabase();

        // prepare fields
        String value = "";
        ArrayList _fields = new ArrayList(),
                _types  = new ArrayList(),
                _values = new ArrayList();
        _fields.add("name"); _types.add("String"); _values.add( name );

        ResultSet _rs = db.executeSelectQuery( _tableName, _fieldName, _fields, _types, _values);

        if( _rs.next() ) {
            value = _rs.getString("value");
        } else {
            value = null;
        }

        return value;
    }

    public static int getID( String name ) throws Exception
    {
        // db instance
        MySQLDatabase db = new MySQLDatabase();

        int id = 0;
        ArrayList _fields = new ArrayList(),
                _types  = new ArrayList(),
                _values = new ArrayList();
        _fields.add("name"); _types.add("String"); _values.add( name );

        ResultSet _rs = db.executeSelectQuery( _tableName, _fieldName, _fields, _types, _values);

        if( _rs.next() ) {
            id = _rs.getInt("id");
        }

        return id;
    }

    // remove a configuration
    public static void remove( String name ) throws Exception
    {
        // db instance
        MySQLDatabase db = new MySQLDatabase();

        int id = Configuration.getID( name );

        if( id > 0 ) {
            db.executeDeleteQuery( _tableName, id );
            db.closeConnection();
        }
    }
}
