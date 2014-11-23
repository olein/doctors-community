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
import com.jonak.model.ContentModel;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionContext;
/**
 * Created by Fahim on 14/11/2014.
 */
public class Content extends ContentModel
{
    public static ResultSet find() throws Exception
    {

        MySQLDatabase db = new MySQLDatabase();

        String  _tableName = "content",
                _fieldName = "*",
                _filter = " limit 1 ";
        ArrayList   _fields = new ArrayList(),
                _types  = new ArrayList(),
                _values = new ArrayList();

        _fields.add("user_id");            _types.add("int");            _values.add(SessionLib.getUserID()); //find current user

        ResultSet rs = db.executeSelectQuery( _tableName, _fieldName, _fields, _types, _values, _filter ); //search experience using content id

        return rs;
    }

    public static Content find(int id) throws SQLException
    {

        MySQLDatabase db = new MySQLDatabase();
        Content content = new Content();
        String  _tableName = "content",
                _fieldName = "*",
                _filter = " limit 1 ";
        ArrayList   _fields = new ArrayList(),
                _types  = new ArrayList(),
                _values = new ArrayList();

        _fields.add("id");            _types.add("int");            _values.add(id); //find content using id

        ResultSet rs = db.executeSelectQuery( _tableName, _fieldName, _fields, _types, _values, _filter ); //search using content id
        if( rs != null ) {

            if( rs.next() ) {

                content.setId(rs.getInt(1));
                content.setUser_id(rs.getInt(2));
                content.setTitle(rs.getString(3));
                content.setDescription(rs.getString(4));
                content.setType(rs.getInt(5));
                content.setPrivacy(rs.getInt(6));
                content.setAllow_comment(rs.getInt(7));
                content.setComment_counter(rs.getInt(8));
                content.setParent_id(rs.getInt(9));
                content.setCreated_at(rs.getInt(10));
            }
        }
        return content;
    }
}
