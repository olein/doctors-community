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
 * Created by Fahim on 11/11/2014.
 */
public class Category extends CategoryModel
{
    public static String find(int id) throws SQLException
    {
        MySQLDatabase db = new MySQLDatabase();
        Category category = new Category();
        String  _tableName = "category",
                _fieldName = "*";
        ArrayList   _fields = new ArrayList(),
                _types  = new ArrayList(),
                _values = new ArrayList();
        _fields.add("id"); _types.add("int"); _values.add(id);

        ResultSet rs = db.executeSelectQuery( _tableName, _fieldName, _fields, _types, _values); //search using user id
        while( rs.next() ) {
            category.setName(rs.getString(2));
        }
        return category.getName();
    }

    public static ResultSet find() throws SQLException
    {

        MySQLDatabase db = new MySQLDatabase();

        String  _tableName = "category",
                _fieldName = "*";
        ArrayList   _fields = new ArrayList(),
                _types  = new ArrayList(),
                _values = new ArrayList();
        if(SessionLib.get("ContentID")>0) {
            _fields.add("id");
            _types.add("int");
            _values.add(SessionLib.get("ContentID"));
        }
        ResultSet rs = db.executeSelectQuery( _tableName, _fieldName, _fields, _types, _values); //search experience using content id

        return rs;
    }
}
