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
public class ContentCategory extends ContentCategoryModel
{
    // set content category
    public static void set( int content_id, int category_id  ) throws Exception
    {
        ContentCategory contentCategory = new ContentCategory();
        contentCategory.setContent_id( content_id );
        contentCategory.setCategory_id( category_id );
        contentCategory.save();
    }

    //get last content id
    public static int getID() throws SQLException
    {
        MySQLDatabase db = new MySQLDatabase();

        String  _tableName = "content",
                _fieldName = "*",
                _filter = "";
        ArrayList   _fields = new ArrayList(),
                _types  = new ArrayList(),
                _values = new ArrayList();

        //_fields.add("user_id");            _types.add("int");            _values.add(SessionLib.getId()); //find current user

        ResultSet rs = db.executeSelectQuery( _tableName, _fieldName, _fields, _types, _values, _filter ); //search experience using content id
        rs.afterLast();
        while (rs.previous()) {
            int id = rs.getInt("id");
            return id;
        }
        return 0;
    }
    //find using content_id
    public static ContentCategory findByContentID(int content_id) throws Exception
    {
        MySQLDatabase db = new MySQLDatabase();

        String  _tableName = "category_content_relation",
                _fieldName = "*",
                _filter = "";

        ArrayList   _fields = new ArrayList(),
                _types  = new ArrayList(),
                _values = new ArrayList();
        _fields.add("content_id"); _types.add("int"); _values.add(content_id);

        ResultSet rs = db.executeSelectQuery( _tableName, _fieldName, _fields, _types, _values, _filter ); //search using user id

        ContentCategory contentCategory = new ContentCategory();
        while(rs.next()) {
            contentCategory.setContent_id(rs.getInt(3));
            contentCategory.setCategory_id(rs.getInt(2));
            contentCategory.setId(rs.getInt(1));
            contentCategory.clear();
            return contentCategory;
        }
        return contentCategory;
    }
}
