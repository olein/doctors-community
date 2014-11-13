package com.jonak.model;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import java.util.Vector;

// import custom
import com.jonak.lib.MySQLDatabase;
import com.jonak.lib.SessionLib;
import com.jonak.model.CategoryModel;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionContext;
/**
 * Created by Fahim on 13/11/2014.
 */
public class Message extends MessageModel
{
    public static ResultSet getUser() throws SQLException
    {

        MySQLDatabase db = new MySQLDatabase();

        String  _tableName = "user",
                _fieldName = "*";
        ArrayList   _fields = new ArrayList(),
                _types  = new ArrayList(),
                _values = new ArrayList();

            _fields.add("allow_message");            _types.add("int");            _values.add(1); //get user who allowed messages

        ResultSet rs = db.executeSelectQuery( _tableName, _fieldName, _fields, _types, _values); //search experience using content id

        return rs;
    }

    public static ResultSet find() throws SQLException
    {

        MySQLDatabase db = new MySQLDatabase();

        String  _tableName = "message",
                _fieldName = "*";
        ArrayList   _fields = new ArrayList(),
                _types  = new ArrayList(),
                _values = new ArrayList();

        _fields.add("from_user_id");            _types.add("int");            _values.add(SessionLib.getId()); //find current user

        ResultSet rs = db.executeSelectQuery( _tableName, _fieldName, _fields, _types, _values); //search experience using content id

        return rs;
    }

    public static String getUserName(int user_id) throws SQLException
    {
        MySQLDatabase db = new MySQLDatabase();
        Message message = new Message();
        String  _tableName = "user",
                _fieldName = "*";
        ArrayList   _fields = new ArrayList(),
                _types  = new ArrayList(),
                _values = new ArrayList();
        _fields.add("id"); _types.add("int"); _values.add(user_id);

        ResultSet rs = db.executeSelectQuery( _tableName, _fieldName, _fields, _types, _values); //search using user id
        if(rs.next()) {
            message.setUser_name(rs.getString(4) + " " + rs.getString(5)); //get user name
        }
        return message.getUser_name();
    }
}
