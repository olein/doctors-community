package com.jonak.model;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Vector;

// import custom
import com.jonak.lib.MySQLDatabase;
import com.jonak.lib.SessionLib;
import com.jonak.model.ConfigurationModel;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionContext;
/**
 * Created by Fahim on 13/11/2014.
 */
public class Configuration extends ConfigurationModel
{
    public static ResultSet find(int id) throws SQLException
    {
        MySQLDatabase db = new MySQLDatabase();

        String  _tableName = "configuration",
            _fieldName = "*";
        ArrayList   _fields = new ArrayList(),
            _types  = new ArrayList(),
            _values = new ArrayList();
        if(id>0) {
            _fields.add("id");        _types.add("int");        _values.add(id);
        }
        ResultSet rs = db.executeSelectQuery( _tableName, _fieldName, _fields, _types, _values); //search using user id
        return rs;
    }
    public static Configuration find() throws Exception
    {
        Configuration configuration = new Configuration();
        MySQLDatabase db = new MySQLDatabase();

        String  _tableName = "configuration",
                _fieldName = "*";
        ArrayList   _fields = new ArrayList(),
                _types  = new ArrayList(),
                _values = new ArrayList();
        _fields.add("id"); _types.add("int"); _values.add(SessionLib.get("ContentID"));

        ResultSet rs = db.executeSelectQuery( _tableName, _fieldName, _fields, _types, _values); //search experience using content id
        if( rs.next() ) {
            configuration.setId(rs.getInt(1));
            configuration.setKey(rs.getString(2));
            configuration.setValue(rs.getString(3));
        } else {
            configuration = null;
        }
        return configuration;
    }

}
