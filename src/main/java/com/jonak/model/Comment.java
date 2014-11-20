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
public class Comment extends CommentModel
{
    public static ResultSet find() throws SQLException
    {

        MySQLDatabase db = new MySQLDatabase();

        String  _tableName = "comment",
                _fieldName = "*";
        ArrayList _fields = new ArrayList(),
                _types  = new ArrayList(),
                _values = new ArrayList();

        _fields.add("content_id");_types.add("int");_values.add(Integer.parseInt(ServletActionContext.getRequest().getParameter("content_id"))); //find current user

        ResultSet rs = db.executeSelectQuery( _tableName, _fieldName, _fields, _types, _values); //search experience using content id

        return rs;
    }

    public static Comment find(int id) throws SQLException
    {

        MySQLDatabase db = new MySQLDatabase();
        Comment comment = new Comment();
        String  _tableName = "comment",
                _fieldName = "*";
        ArrayList   _fields = new ArrayList(),
                _types  = new ArrayList(),
                _values = new ArrayList();

        _fields.add("id");            _types.add("int");            _values.add(id); //find content using id

        ResultSet rs = db.executeSelectQuery( _tableName, _fieldName, _fields, _types, _values); //search using content id
        if( rs != null ) {

            if( rs.next() ) {

                comment.setId(rs.getInt(1));
                comment.setUser_id(rs.getInt(3));
                comment.setContent_id((rs.getInt(2)));
                comment.setContent(rs.getString(4));
                comment.setParent_id(rs.getInt(5));
                comment.setCreated_at(rs.getInt(6));
            }
        }
        return comment;
    }
}
