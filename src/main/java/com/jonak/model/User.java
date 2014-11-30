package com.jonak.model;

// import default
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Vector;

import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionContext;

// import custom
import com.jonak.lib.MySQLDatabase;
import com.jonak.lib.SessionLib;
import com.jonak.lib.Hash;
import com.jonak.model.UserModel;

/**
 * Created by lenin on 11/5/14.
 */
public class User extends UserModel
{

    // returns user display name by id
    public static String getDisplayName( int id ) throws Exception
    {
        User user = User.findById( id );
        String displayName = (user.getFirstName()+" "+user.getLastName());
//        System.out.println(id+": "+displayName);
        return displayName;
    }

    // find user by id
    public static User findById(int id) throws Exception
    {
        User user = new User();
        MySQLDatabase db = new MySQLDatabase();

        String  _tableName = "user",
                _fieldName = "*",
                _filter = " limit 1 ";
        ArrayList   _fields = new ArrayList(),
                    _types  = new ArrayList(),
                    _values = new ArrayList();
        _fields.add("id"); _types.add("int"); _values.add(id);

        ResultSet _rs = db.executeSelectQuery( _tableName, _fieldName, _fields, _types, _values, _filter);

        if( _rs.next() ) {
            user = User.setData( _rs );
        } else {
            user = null;
        }

        return user;
    }

    // login a user
    public static User checkLogin( String email, String password ) throws Exception
    {
        // init vars
        User user;
        MySQLDatabase db = new MySQLDatabase();

        // hash the password
        String hash_password = Hash.md5( password );
        System.out.println(hash_password);

        // init default values
        String  _tableName = "user",
                _fieldName = "*",
                _filter = " limit 1 ";
        ArrayList   _fields = new ArrayList(),
                _types  = new ArrayList(),
                _values = new ArrayList();

        // set values
        _fields.add("email");       _types.add("String");   _values.add( email );
        _fields.add("password");    _types.add("String");   _values.add( hash_password ); // ??

        // get result
        ResultSet _rs = db.executeSelectQuery( _tableName, _fieldName, _fields, _types, _values, _filter );

        // check result
        if( _rs.next() ) {
            user = User.setData( _rs );
        } else {
            user = null;
        }

        // return
        return user;
    }

    // find user by email
    public static User findByEmail( String email ) throws Exception
    {
        User user = new User();
        MySQLDatabase db = new MySQLDatabase();

        String  _tableName = "user",
                _fieldName = "*",
                _filter = " limit 1 ";
        ArrayList   _fields = new ArrayList(),
                _types  = new ArrayList(),
                _values = new ArrayList();
        _fields.add("email"); _types.add("String"); _values.add( email );

        ResultSet _rs = db.executeSelectQuery( _tableName, _fieldName, _fields, _types, _values, _filter );

        if( _rs.next() ) {
            user = User.setData( _rs );
        } else {
            user = null;
        }

        return user;
    }

    // sets user data
    private static User setData( ResultSet _rs ) throws Exception
    {
        User user = new User();
        user.setId(_rs.getInt("id"));
        user.setEmail(_rs.getString("email"));
        user.setPassword(_rs.getString("password"));
        user.setFirstName(_rs.getString("first_name"));
        user.setLastName(_rs.getString("last_name"));
        user.setAddress(_rs.getString("address"));
        user.setDistrict(_rs.getString("district"));
        user.setDateOfBirth(_rs.getInt("date_of_birth"));
        user.setGender(_rs.getInt("gender"));
        user.setType(_rs.getInt("type"));
        user.setLastLoginAt(_rs.getInt("last_login_at"));
        user.setAllowMessage(_rs.getInt("allow_message"));
        user.setStatus(_rs.getInt("status"));
        user.setToken(_rs.getString("token"));
        user.setCreatedAt(_rs.getInt("created_at"));
        user.clear();
        return user;
    }
}
