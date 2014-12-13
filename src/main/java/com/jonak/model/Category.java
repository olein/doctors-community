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
    public static Vector<Category> dataOut = new Vector<Category>();

//    public static Category findCategoryByID(int id) throws Exception
//    {
//        MySQLDatabase db = new MySQLDatabase();
//        Category category = new Category();
//        String  _tableName = "category",
//                _fieldName = "*",
//                _filter = " limit 1 ";
//        ArrayList   _fields = new ArrayList(),
//                _types  = new ArrayList(),
//                _values = new ArrayList();
//        _fields.add("id"); _types.add("int"); _values.add(id);
//
//
//        ResultSet rs = db.executeSelectQuery( _tableName, _fieldName, _fields, _types, _values, _filter );
//
//        dataOut.clear();
//        if( rs.next() ) {
//            category.setId(rs.getInt("id"));
//            category.setName(rs.getString("name")); //set parent category values
//            category.setDetail(rs.getString("detail"));
//            category.setParentId(rs.getInt("parent_id"));
//            if(category.getParentId()>0) {
//                String name = category.getCategoryName(category.getParentId());
//                category.setCategoryName( name );
//            }
//            category.setCreatedAt(rs.getInt("created_at"));
//            category.setDate(Tools.getDate(category.getCreatedAt()));
//
//        }
//        return category;
//    }


    //

    // get name by id
    public static String getNameById( int id ) throws Exception
    {
        Category cat = Category.findById( id );
        return cat.getName();
    }

    // find category by id
    public static Category findById( int id ) throws Exception
    {
        MySQLDatabase db = new MySQLDatabase();
        Category category = new Category();

        String  sql = " select * from category where id=? ";
        ArrayList _values = new ArrayList();
        _values.add( id );

        ResultSet rs = db.executeSelectQuery( sql, _values);

        if( rs != null ) {
            while( rs.next() ) {
                category.setId(rs.getInt("id"));
                category.setName(rs.getString("name"));
                category.setDetail(rs.getString("detail"));
                category.setParentId(rs.getInt("parent_id"));
                category.setCreatedAt(rs.getInt("created_at"));
                category.clear();
            }
        } else {
            category = null;
        }

        return category;
    }

    // list all category
    public static Vector findCategory() throws Exception
    {
        MySQLDatabase db = new MySQLDatabase();

        String  sql = " select * from category ";
        ArrayList _values = new ArrayList();

        ResultSet rs = db.executeSelectQuery( sql, _values);

        if( rs != null ) {
            dataOut.clear();
            while( rs.next() ) {
                Category category = new Category();
                category.setId(rs.getInt("id"));
                category.setName(rs.getString("name"));
                category.setDetail(rs.getString("detail"));
                category.setParentId(rs.getInt("parent_id"));
                category.setCreatedAt(rs.getInt("created_at"));
                category.clear();
                dataOut.add(category); //add result to vector
            }
        }
        return dataOut;
    }

    public static String getCategoryName(int id) throws Exception
    {
        MySQLDatabase db = new MySQLDatabase();
        Category category = new Category();
        String  _tableName = "category",
                _fieldName = "*",
                _filter = "";
        ArrayList   _fields = new ArrayList(),
                _types  = new ArrayList(),
                _values = new ArrayList();
        _fields.add("id"); _types.add("int"); _values.add(id);

        ResultSet rs = db.executeSelectQuery( _tableName, _fieldName, _fields, _types, _values, _filter);

        if( rs.next() ) {
            category.setId(rs.getInt("id"));
            category.setName(rs.getString("name")); //set parent category values
        }
        return category.getName();
    }

    public Vector<Category> getDataOut() {
        return dataOut;
    }

    public void setDataOut(Vector<Category> dataOut) {
        this.dataOut = dataOut;
    }
}
