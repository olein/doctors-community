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
import com.jonak.lib.Tools;
import com.jonak.model.CategoryModel;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionContext;
/**
 * Created by Fahim on 11/11/2014.
 */
public class Category extends CategoryModel
{
    private static Vector<Category> dataOut = new Vector<Category>();
    public static String getCategoryName(int id) throws SQLException
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

    public static Vector findAllCategory() throws Exception
    {

        MySQLDatabase db = new MySQLDatabase();

        String  _tableName = "category",
                _fieldName = "*";
        ArrayList   _fields = new ArrayList(),
                _types  = new ArrayList(),
                _values = new ArrayList();

        ResultSet rs = db.executeSelectQuery( _tableName, _fieldName, _fields, _types, _values); //search experience using content id

        while( rs.next() ) {
            Category category = new Category();
            category.setId(rs.getInt(1));
            category.setName(rs.getString(2));
            category.setDetail(rs.getString(3));
            category.setParent_id(rs.getInt(4));
            category.setParent_name(Category.getCategoryName(rs.getInt(4)));
            Date date = Tools.getDate(rs.getInt(5));
            category.setDate(date);

            dataOut.add(category); //add result to vector
        }

        return dataOut;
    }

    public static Category findByID(int id) throws Exception
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
        if( rs.next() ) {
            category.setId(rs.getInt(1));
            category.setName(rs.getString(2));
            category.setDetail(rs.getString(3));
            category.setParent_id(rs.getInt(4));
            category.setCreated_at(rs.getInt(5));
            }
        return category;
    }

    public Vector<Category> getDataOut() {
        return dataOut;
    }

    public void setDataOut(Vector<Category> dataOut) {
        this.dataOut = dataOut;
    }
}
