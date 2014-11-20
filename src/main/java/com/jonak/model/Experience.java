package com.jonak.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Vector;

// import custom
import com.jonak.lib.MySQLDatabase;
import com.jonak.lib.SessionLib;
import com.jonak.model.ExperienceModel;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionContext;

/**
 * Created by Fahim on 09/11/2014.
 */
public class Experience extends ExperienceModel
{
    private static Vector<Experience> dataOut = new Vector<Experience>();

    public static Vector findByUserID(int user_id) throws SQLException
    {

        MySQLDatabase db = new MySQLDatabase();

        String  _tableName = "experience",
                _fieldName = "*";
        ArrayList   _fields = new ArrayList(),
                _types  = new ArrayList(),
                _values = new ArrayList();
        _fields.add("user_id"); _types.add("int"); _values.add(user_id);

        ResultSet rs = db.executeSelectQuery( _tableName, _fieldName, _fields, _types, _values); //search using user id

        while ( rs.next() ) {
            Experience exp = new Experience();
            exp.setId(rs.getInt(1));
            exp.setUser_id(rs.getInt("user_id"));
            exp.setTitle(rs.getString("title"));
            exp.setDescription(rs.getString("description"));
            dataOut.add(exp);
        }
        return dataOut;
    }

    public static Experience findByID( int id) throws Exception
    {
        Experience exp = new Experience();
        MySQLDatabase db = new MySQLDatabase();

        String  _tableName = "experience",
                _fieldName = "*";
        ArrayList   _fields = new ArrayList(),
                _types  = new ArrayList(),
                _values = new ArrayList();

        _fields.add("id"); _types.add("int"); _values.add( id );

        ResultSet rs = db.executeSelectQuery( _tableName, _fieldName, _fields, _types, _values); //search experience using content id
        if( rs.next() ) {
            exp.setId(rs.getInt(1));
            exp.setUser_id(rs.getInt("user_id"));
            exp.setTitle(rs.getString("title"));
            exp.setDescription(rs.getString("description"));

        } else {
            exp = null;
        }
        return exp;
    }
    public static Vector<Experience> getDataOut() {
        return dataOut;
    }

    public static void setDataOut(Vector<Experience> dataOut) {
        Experience.dataOut = dataOut;
    }

}
