package com.jonak.model;

import com.jonak.lib.MySQLDatabase;
import com.jonak.lib.SessionLib;
import com.jonak.lib.Tools;
import com.jonak.model.UserModel;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Vector;

/**
 * Created by Fahim on 11/12/2014.
 */
public class Search
{
    public static Vector<User> dataOut = new Vector<User>();
    public static Vector<Content> heathTips = new Vector<Content>();

    public static Vector findByName(String name) throws Exception
    {
        MySQLDatabase db = new MySQLDatabase();

        String  _tableName = "user",
                _fieldName = "*",
                _filter = "";
        ArrayList _fields = new ArrayList(),
                _types  = new ArrayList(),
                _values = new ArrayList();

        ResultSet rs = db.executeSelectQuery( _tableName, _fieldName, _fields, _types, _values, _filter);

        if( rs != null ) {
            dataOut.clear();
            while( rs.next() ) {
                if (rs.getInt("type") < 4) {
                    if (rs.getString(4).contains(name) || rs.getString(5).contains(name)) {
                        User user = new User();
                        user.setId(rs.getInt(1));
                        user.setEmail(rs.getString(2));
                        user.setFirstName(rs.getString(4));
                        user.setLastName(rs.getString(5));
                        user.setAddress(rs.getString(6));
                        user.setDistrict(rs.getString(7));
                        dataOut.add(user); //add result to vector
                    }
                }
            }
        }
        return dataOut;
    }

    public static Vector findByLocation(String district) throws Exception
    {
        MySQLDatabase db = new MySQLDatabase();

        String  _tableName = "user",
                _fieldName = "*",
                _filter = "";
        ArrayList _fields = new ArrayList(),
                _types  = new ArrayList(),
                _values = new ArrayList();

        ResultSet rs = db.executeSelectQuery( _tableName, _fieldName, _fields, _types, _values, _filter);

        if( rs != null ) {
            dataOut.clear();
            while( rs.next() ) {
                if (rs.getInt("type") < 4) {
                    if (rs.getString(6).contains(district) || rs.getString(7).contains(district)) {
                        User user = new User();
                        user.setId(rs.getInt(1));
                        user.setEmail(rs.getString(2));
                        user.setFirstName(rs.getString(4));
                        user.setLastName(rs.getString(5));
                        user.setAddress(rs.getString(6));
                        user.setDistrict(rs.getString(7));
                        dataOut.add(user); //add result to vector
                    }
                }
            }
        }
        return dataOut;
    }
    public static Vector findByKeyWord(String keyWord) throws Exception
    {
        MySQLDatabase db = new MySQLDatabase();

        String  _tableName = "user",
                _fieldName = "*",
                _filter = "";
        ArrayList _fields = new ArrayList(),
                _types  = new ArrayList(),
                _values = new ArrayList();

        ResultSet rs = db.executeSelectQuery( _tableName, _fieldName, _fields, _types, _values, _filter);

        if( rs != null ) {
            dataOut.clear();
            while( rs.next() ) {
                if (rs.getInt("type") < 4) {
                    if (rs.getString(2).contains(keyWord) || rs.getString(4).contains(keyWord)
                            || rs.getString(6).contains(keyWord) || rs.getString(7).contains(keyWord)
                            || rs.getString(5).contains(keyWord)) {
                        User user = new User();
                        user.setId(rs.getInt(1));
                        user.setEmail(rs.getString(2));
                        user.setFirstName(rs.getString(4));
                        user.setLastName(rs.getString(5));
                        user.setAddress(rs.getString(6));
                        user.setDistrict(rs.getString(7));
                        dataOut.add(user); //add result to vector
                    }
                }
            }
        }
        return dataOut;
    }
    public static Vector findBySpeciality(int speciality) throws Exception
    {
        MySQLDatabase db = new MySQLDatabase();

        String  _tableName = "category_user_relation",
                _fieldName = "*",
                _filter = "";
        ArrayList _fields = new ArrayList(),
                _types  = new ArrayList(),
                _values = new ArrayList();

        ResultSet rs = db.executeSelectQuery( _tableName, _fieldName, _fields, _types, _values, _filter);

        if( rs != null ) {
            dataOut.clear();
            while( rs.next() ) {
                if(speciality==rs.getInt(2))
                {
                    User user = User.findById(rs.getInt(3));
                    dataOut.add(user); //add result to vector
                }
            }
        }
        return dataOut;
    }

    public static Vector getHealthTips() throws Exception {
        MySQLDatabase db = new MySQLDatabase();

        String _tableName = "content",
                _fieldName = "*",
                _filter = " order by created_at desc limit 3";
        ArrayList _fields = new ArrayList(),
                _types = new ArrayList(),
                _values = new ArrayList();


        _fields.add("type");        _types.add("int");        _values.add(6);
        ResultSet rs = db.executeSelectQuery(_tableName, _fieldName, _fields, _types, _values, _filter); //search experience using content id
        if (rs != null) {
            heathTips.clear();
            while (rs.next()) {
                Content content = new Content();
                content.setId(rs.getInt(1));
                content.setUser_id(rs.getInt(2));
                content.setTitle(rs.getString(3));
                content.setDescription(rs.getString(4));
                content.setDate(Tools.getDate(rs.getInt(10)));

                ContentCategory contentCategory = ContentCategory.findByContentID(rs.getInt(1));
                if (contentCategory != null) {
                    content.setCategory_name(Category.getCategoryName(contentCategory.getCategory_id()));
                } else {
                    content.setCategory_name("not specified");
                }
                heathTips.add(content); //add result to vector
            }
        }
        return heathTips;
    }
}
