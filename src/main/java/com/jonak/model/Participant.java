package com.jonak.model;

import com.jonak.lib.MySQLDatabase;
import com.jonak.lib.SessionLib;
import org.apache.struts2.ServletActionContext;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Fahim on 15/11/2014.
 */
public class Participant extends ParticipantModel
{
    public static ResultSet find() throws SQLException {
        User user = new User();
        MySQLDatabase db = new MySQLDatabase();

        String _tableName = "user",
                _fieldName = "*",
                _filter = " limit 1 ";
        ArrayList _fields = new ArrayList(),
                _types = new ArrayList(),
                _values = new ArrayList();
        _fields.add("type");        _types.add("int");        _values.add(2);

        ResultSet rs = db.executeSelectQuery(_tableName, _fieldName, _fields, _types, _values, _filter );
        return rs;
    }

    public static ResultSet findParticipants() throws SQLException
    {

        MySQLDatabase db = new MySQLDatabase();

        String  _tableName = "participant",
                _fieldName = "*",
                _filter = "";
        ArrayList   _fields = new ArrayList(),
                _types  = new ArrayList(),
                _values = new ArrayList();

        _fields.add("content_id");_types.add("int");_values.add(Integer.parseInt(ServletActionContext.getRequest().getParameter("content_id"))); //find current user

        ResultSet rs = db.executeSelectQuery( _tableName, _fieldName, _fields, _types, _values, _filter ); //search experience using content id

        return rs;
    }
}
