package com.jonak.model;

// import default
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;
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

    /**
     * find user by id
     *
     * @param id
     * @return
     * @throws SQLException
     */
    public static User find(int id) throws SQLException
    {
        User user = new User();
        MySQLDatabase db = new MySQLDatabase();

        String  _tableName = "user",
                _fieldName = "*";
        ArrayList   _fields = new ArrayList(),
                    _types  = new ArrayList(),
                    _values = new ArrayList();
        _fields.add("id"); _types.add("int"); _values.add(id);

        ResultSet _rs = db.executeSelectQuery( _tableName, _fieldName, _fields, _types, _values);

        if( _rs.next() ) {
            user = User.setData( _rs );
        } else {
            user = null;
        }

        return user;
    }

    // login a user
    public static User checkLogin( String email, String password ) throws SQLException
    {
        // init vars
        User user = new User();
        MySQLDatabase db = new MySQLDatabase();

        // hash the password
        String hash_password = Hash.md5( password );
        System.out.println(hash_password);

        // init default values
        String  _tableName = "user",
                _fieldName = "*";
        ArrayList   _fields = new ArrayList(),
                _types  = new ArrayList(),
                _values = new ArrayList();

        // set values
        _fields.add("email");       _types.add("String");   _values.add( email );
        _fields.add("password");    _types.add("String");   _values.add( hash_password ); // ??

        // get result
        ResultSet _rs = db.executeSelectQuery( _tableName, _fieldName, _fields, _types, _values );

        // check result
        if( _rs.next() ) {
            user = User.setData( _rs );
        } else {
            user = null;
        }

        // return
        return user;
    }

    public static User getUser() throws SQLException
    {
        User user = new User();
        MySQLDatabase db = new MySQLDatabase();


        String  _tableName = "user",
                _fieldName = "*";
        ArrayList   _fields = new ArrayList(),
                _types  = new ArrayList(),
                _values = new ArrayList();
        _fields.add("email"); _types.add("String"); _values.add(ServletActionContext.getRequest().getParameter("email"));

        ResultSet _rs = db.executeSelectQuery( _tableName, _fieldName, _fields, _types, _values);

        if( _rs.next() ) {
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
            user.setCreatedAt(_rs.getInt("created_at"));
            System.out.println(user.getId());
        } else {
            user = null;
        }

        return user;
    }

    public static User getUserId() throws SQLException
    {
        User user = new User();
        MySQLDatabase db = new MySQLDatabase();


        String  _tableName = "user",
                _fieldName = "*";
        ArrayList   _fields = new ArrayList(),
                _types  = new ArrayList(),
                _values = new ArrayList();
        _fields.add("keyValue"); _types.add("String"); _values.add(ServletActionContext.getRequest().getParameter("key"));

        ResultSet _rs = db.executeSelectQuery( _tableName, _fieldName, _fields, _types, _values);

        if( _rs.next() ) {
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
            user.setCreatedAt(_rs.getInt("created_at"));
            System.out.println(user.getId());
        } else {
            user = null;
        }

        return user;
    }


    // sets user data
    private static User setData( ResultSet _rs ) throws SQLException
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
        user.setCreatedAt(_rs.getInt("created_at"));

        return user;
    }
}
