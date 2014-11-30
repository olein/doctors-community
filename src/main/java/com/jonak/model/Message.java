package com.jonak.model;
import java.lang.reflect.Array;
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
    public static String tableName = "message";

    // find messages
    public static Vector find(ArrayList fields, ArrayList types, ArrayList values, String filter) throws Exception
    {
        Vector messages = new Vector();
        MySQLDatabase db = new MySQLDatabase();

        int i, size = fields.size();
        String  _tableName = "message", _fieldName = "*";

        ResultSet rs = db.executeSelectQuery( _tableName, _fieldName, fields, types, values, filter);

        if( rs.next() ) {
            do {
                Message msg = new Message();
                msg.setId( rs.getInt("id") );
                msg.setFromUserId( rs.getInt("from_user_id") );
                msg.setToUserId( rs.getInt("to_user_id") );
                msg.setMsg( rs.getString("msg") );
                msg.setCreated_at( rs.getInt("created_at") );
                msg.clear();
                messages.add( msg );
            } while( rs.next() );
        } else {
            messages = null;
        }

        return messages;
    }

    // find all with custom where & filters
    public static Vector findAll( String where, ArrayList values, String filter ) throws Exception
    {
        Vector messages = new Vector();
        MySQLDatabase db = new MySQLDatabase();

        String  sql = " select * from " + Message.tableName + " ";

        if( ! where.isEmpty() ) {
            sql += where;
        }

        if( ! filter.isEmpty() ) {
            sql += filter;
        }

        ResultSet rs = db.executeSelectQuery( sql, values );

        if( rs.next() ) {
            do {
                Message msg = new Message();
                msg.setId( rs.getInt("id") );
                msg.setFromUserId( rs.getInt("from_user_id") );
                msg.setToUserId( rs.getInt("to_user_id") );
                msg.setMsg( rs.getString("msg") );
                msg.setCreated_at( rs.getInt("created_at") );
                msg.clear();
                messages.add( msg );
            } while( rs.next() );
        } else {
            messages = null;
        }

        return messages;
    }

    // get single message by id
    public static Message findById( int id ) throws Exception
    {
        Message message = new Message();
        MySQLDatabase db = new MySQLDatabase();

        String  _tableName = "message",
                _fieldName = "*",
                _filter = " limit 1 ";
        ArrayList   _fields = new ArrayList(),
                    _types  = new ArrayList(),
                    _values = new ArrayList();

        _fields.add("id");            _types.add("int");            _values.add( id ); //find current user

        ResultSet rs = db.executeSelectQuery( _tableName, _fieldName, _fields, _types, _values, _filter); //search experience using content id

        if( rs.next() ) {
            message = Message.setData( rs );
        } else {
            message = null;
        }

        return message;
    }



    // sets message data
    private static Message setData( ResultSet rs ) throws Exception
    {
        Message message = new Message();
        message.setId( rs.getInt("id") );
        message.setFromUserId(rs.getInt("from_user_id"));
        message.setToUserId(rs.getInt("to_user_id"));
        message.setMsg(rs.getString("msg"));
        message.setCreated_at(rs.getInt("created_at"));
        message.clear();
        return message;
    }
}
