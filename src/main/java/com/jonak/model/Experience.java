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
    public static Vector<Experience> dataOut = new Vector<Experience>();

    public static Vector findByUserID(int userId) throws SQLException
    {
        MySQLDatabase db = new MySQLDatabase();

        String  _tableName = "experience",
                _fieldName = "*",
                _filter = "";
        ArrayList   _fields = new ArrayList(),
                _types  = new ArrayList(),
                _values = new ArrayList();
        _fields.add("user_id"); _types.add("int"); _values.add(userId);

        ResultSet rs = db.executeSelectQuery( _tableName, _fieldName, _fields, _types, _values, _filter); //search using user id

        if( rs != null ) {
            dataOut.clear();
            while( rs.next() ) {
                Experience exp = new Experience();
                exp.setId(rs.getInt("id"));
                exp.setUserId(rs.getInt("user_id"));
                exp.setTitle(rs.getString("title"));
                exp.setDescription(rs.getString("description"));
                dataOut.add(exp);
            }
        }
        return dataOut;

    }

    public static Experience findExperienceByID( int id ) throws Exception
    {
        Experience exp = new Experience();
        MySQLDatabase db = new MySQLDatabase();

        String  _tableName = "experience",
                _fieldName = "*",
                _filter = "";
        ArrayList   _fields = new ArrayList(),
                _types  = new ArrayList(),
                _values = new ArrayList();

        _fields.add("id"); _types.add("int"); _values.add( id );

        ResultSet rs = db.executeSelectQuery( _tableName, _fieldName, _fields, _types, _values, _filter); //search experience using content id
        if( rs.next() ) {
            exp.setId(rs.getInt(1));
            System.out.println("Content id: " + exp.getId());
            exp.setUserId(rs.getInt("user_id"));
            exp.setTitle(rs.getString("title"));
            exp.setDescription(rs.getString("description"));

        } else {
            exp = null;
        }
        return exp;
    }
}
