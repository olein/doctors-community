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
import com.jonak.model.ContentModel;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionContext;

import javax.xml.transform.Result;

/**
 * Created by Fahim on 14/11/2014.
 */
public class Content extends ContentModel
{
    public static Vector<Content> dataOut = new Vector<Content>();

    public static Vector findByType( int type ) throws Exception
    {
        MySQLDatabase db = new MySQLDatabase();
        Vector contents = new Vector();

        String sql = " select * from content where type=? ";
        ArrayList values = new ArrayList();
        values.add(6);

        ResultSet rs = db.executeSelectQuery( sql, values );

        if( rs != null ) {

            while( rs.next() ) {
                Content content = new Content();
                content.setId(rs.getInt(1));
                content.setUser_id(rs.getInt(2));
                content.setTitle(rs.getString(3));
                content.setDescription(rs.getString(4));
                content.setDate(Tools.getDate(rs.getInt(10)));

                ContentCategory contentCategory  = ContentCategory.findByContentID(rs.getInt(1));
                if(contentCategory!=null)
                {
                    content.setCategory_name(Category.getCategoryName(contentCategory.getCategory_id()));
                }
                else
                {
                    content.setCategory_name("not specified");
                }
                contents.add(content); //add result to vector
            }
        }

        return contents;
    }

    public static Vector findAllContent() throws Exception
    {

        MySQLDatabase db = new MySQLDatabase();

        String  _tableName = "content",
                _fieldName = "*",
                _filter = " order by created_at desc ";
        ArrayList   _fields = new ArrayList(),
                _types  = new ArrayList(),
                _values = new ArrayList();

        _fields.add("user_id");         _types.add("int");            _values.add(SessionLib.getUserID()); //find current user
        _fields.add("type");            _types.add("int");            _values.add(Integer.parseInt(Tools.get("type")));
        ResultSet rs = db.executeSelectQuery( _tableName, _fieldName, _fields, _types, _values, _filter); //search experience using content id
        if( rs != null ) {
            dataOut.clear();
            while( rs.next() ) {
                Content content = new Content();
                content.setId(rs.getInt(1));
                content.setUser_id(rs.getInt(2));
                content.setTitle(rs.getString(3));
                content.setDescription(rs.getString(4));
                content.setDate(Tools.getDate(rs.getInt(10)));

                ContentCategory contentCategory  = ContentCategory.findByContentID(rs.getInt(1));
                if(contentCategory!=null)
                {
                    content.setCategory_name(Category.getCategoryName(contentCategory.getCategory_id()));
                }
                else
                {
                    content.setCategory_name("not specified");
                }
                dataOut.add(content); //add result to vector
            }
        }
        return dataOut;
    }

    public static Vector findAllParticipatedContent() throws Exception
    {

        MySQLDatabase db = new MySQLDatabase();

        String  _tableName = "participant",
                _fieldName = "*",
                _filter = "";
        ArrayList   _fields = new ArrayList(),
                _types  = new ArrayList(),
                _values = new ArrayList();

        String  tableName = "content",
                fieldName = "*",
                filter = " order by id desc ";
        ArrayList   fields = new ArrayList(),
                types  = new ArrayList(),
                values = new ArrayList();

        _fields.add("user_id");            _types.add("int");            _values.add(SessionLib.getUserID()); //find current user
        ResultSet rs = db.executeSelectQuery( _tableName, _fieldName, _fields, _types, _values, _filter); //search experience using content id

        if( rs != null ) {
            dataOut.clear();
            while( rs.next() ) {
                fields.add("id");            types.add("int");            values.add(rs.getInt(2));
                fields.add("type");            types.add("int");            values.add(Tools.toInt(Tools.get("type")));
                ResultSet rs2 = db.executeSelectQuery( tableName, fieldName, fields, types, values, filter);
                while (rs2.next()) {
                    Content content = new Content();
                    content.setId(rs2.getInt(1));
                    content.setUser_id(rs2.getInt(2));
                    content.setTitle(rs2.getString(3));
                    content.setDescription(rs2.getString(4));
                    content.setDate(Tools.getDate(rs2.getInt(10)));

                    ContentCategory contentCategory = ContentCategory.findByContentID(rs2.getInt(1));
                    if (contentCategory != null) {
                        content.setCategory_name(Category.getCategoryName(contentCategory.getCategory_id()));
                    } else {
                        content.setCategory_name("not specified");
                    }
                    dataOut.add(content); //add result to vector
                }
                fields.clear();
                types.clear();
                values.clear();
            }
        }
        return dataOut;
    }


    public static Vector findAllPublicContent() throws Exception
    {

        MySQLDatabase db = new MySQLDatabase();

        String  _tableName  = "content",
                _fieldName  = "*",
                _filter     = " order by created_at desc ";
        ArrayList   _fields = new ArrayList(),
                _types  = new ArrayList(),
                _values = new ArrayList();

        //_fields.add("user_id");            _types.add("int");            _values.add(SessionLib.getUserID()); //find current user
        _fields.add("type");            _types.add("int");            _values.add(Integer.parseInt(Tools.get("type")));
        _fields.add("privacy");            _types.add("int");            _values.add(2);
        ResultSet rs = db.executeSelectQuery( _tableName, _fieldName, _fields, _types, _values, _filter); //search experience using content id
        if( rs != null ) {
            dataOut.clear();
            while( rs.next() ) {
                Content content = new Content();
                content.setId(rs.getInt(1));
                content.setUser_id(rs.getInt(2));
                content.setTitle(rs.getString(3));
                content.setDescription(rs.getString(4));
                content.setDate(Tools.getDate(rs.getInt(10)));

                System.out.println("Content id: " + content.getId());
                ContentCategory contentCategory  = ContentCategory.findByContentID(rs.getInt(1));
                if(contentCategory!=null)
                {
                    content.setCategory_name(Category.getCategoryName(contentCategory.getCategory_id()));
                }
                else
                {
                    content.setCategory_name("not specified");
                }
                dataOut.add(content); //add result to vector
            }
        }
        return dataOut;
    }

    public static Content findByID(int id) throws Exception
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
                content.setDate(Tools.getDate(rs.getInt(10)));
                ContentCategory contentCategory  = ContentCategory.findByContentID(rs.getInt(1));
                if(contentCategory!=null)
                {
                    content.setCategory_name(Category.getCategoryName(contentCategory.getCategory_id()));
                    content.setCategoryId(contentCategory.getCategory_id());
                }
                else
                {
                    content.setCategory_name("not specified");
                }
            }
        }

        return content;
    }

    public static Vector findAllUndiscussedContent() throws Exception
    {

        MySQLDatabase db = new MySQLDatabase();

        String  _tableName  = "content",
                _fieldName  = "*",
                _filter     = " order by created_at desc ";
        ArrayList   _fields = new ArrayList(),
                _types  = new ArrayList(),
                _values = new ArrayList();
        _fields.add("comment_counter");            _types.add("int");            _values.add(0);
        _fields.add("type");            _types.add("int");            _values.add(Integer.parseInt(Tools.get("type")));
        ResultSet rs = db.executeSelectQuery( _tableName, _fieldName, _fields, _types, _values, _filter);
        if( rs != null ) {
            dataOut.clear();
            while( rs.next() ) {
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
                dataOut.add(content);
            }
        }
        return dataOut;
    }

    public static Vector findAllTopContent() throws Exception
    {

        MySQLDatabase db = new MySQLDatabase();

        String  _tableName  = "content",
                _fieldName  = "*",
                _filter     = " order by comment_counter desc ";
        ArrayList   _fields = new ArrayList(),
                _types  = new ArrayList(),
                _values = new ArrayList();

        //_fields.add("user_id");            _types.add("int");            _values.add(SessionLib.getUserID()); //find current user
        _fields.add("type");            _types.add("int");            _values.add(Integer.parseInt(Tools.get("type")));
        _fields.add("privacy");            _types.add("int");            _values.add(2);
        ResultSet rs = db.executeSelectQuery( _tableName, _fieldName, _fields, _types, _values, _filter); //search experience using content id
        if( rs != null ) {
            dataOut.clear();
            while( rs.next() ) {
                Content content = new Content();
                content.setId(rs.getInt(1));
                content.setUser_id(rs.getInt(2));
                content.setTitle(rs.getString(3));
                content.setDescription(rs.getString(4));
                content.setDate(Tools.getDate(rs.getInt(10)));

                ContentCategory contentCategory  = ContentCategory.findByContentID(rs.getInt(1));
                if(contentCategory!=null)
                {
                    content.setCategory_name(Category.getCategoryName(contentCategory.getCategory_id()));
                }
                else
                {
                    content.setCategory_name("not specified");
                }
                dataOut.add(content); //add result to vector
            }
        }
        return dataOut;
    }


    public static Vector findByKeyWord() throws Exception
    {

        MySQLDatabase db = new MySQLDatabase();

        String  _tableName = "content",
                _fieldName = "*",
                _filter = " order by created_at desc ";
        ArrayList   _fields = new ArrayList(),
                _types  = new ArrayList(),
                _values = new ArrayList();

        //_fields.add("user_id");            _types.add("int");            _values.add(SessionLib.getUserID()); //find current user
        _fields.add("type");            _types.add("int");            _values.add(Integer.parseInt(Tools.get("type")));
        _fields.add("privacy");            _types.add("int");            _values.add(2);
        ResultSet rs = db.executeSelectQuery( _tableName, _fieldName, _fields, _types, _values, _filter);
        if( rs != null ) {
            dataOut.clear();
            while( rs.next() ) {
                Content content = new Content();
                content.setId(rs.getInt(1));
                content.setUser_id(rs.getInt(2));
                content.setTitle(rs.getString(3));
                content.setDescription(rs.getString(4));
                content.setDate(Tools.getDate(rs.getInt(10)));
                if(content.getTitle().contains(Tools.get("searchWord")) | content.getDescription().contains(Tools.get("searchWord"))) {
                    ContentCategory contentCategory  = ContentCategory.findByContentID(rs.getInt(1));
                    if(contentCategory!=null)
                    {
                        content.setCategory_name(Category.getCategoryName(contentCategory.getCategory_id()));
                    }
                    else
                    {
                        content.setCategory_name("not specified");
                    }
                    dataOut.add(content); //add result to vector
                }
            }
        }
        return dataOut;
    }

    public static Vector findByCategory() throws Exception
    {

        MySQLDatabase db = new MySQLDatabase();

        String  _tableName = "content",
                _fieldName = "*",
                _filter = " order by created_at desc ";
        ArrayList   _fields = new ArrayList(),
                _types  = new ArrayList(),
                _values = new ArrayList();

        _fields.add("type");            _types.add("int");            _values.add(Integer.parseInt(Tools.get("type")));
        _fields.add("privacy");            _types.add("int");            _values.add(2);
        ResultSet rs = db.executeSelectQuery( _tableName, _fieldName, _fields, _types, _values, _filter);
        if( rs != null ) {
            dataOut.clear();
            while( rs.next() ) {
                Content content = new Content();
                content.setId(rs.getInt(1));
                content.setUser_id(rs.getInt(2));
                content.setTitle(rs.getString(3));
                content.setDescription(rs.getString(4));
                content.setDate(Tools.getDate(rs.getInt(10)));
                ContentCategory contentCategory  = ContentCategory.findByContentID(rs.getInt(1));
                if(contentCategory!=null && contentCategory.getCategory_id()==Integer.parseInt(Tools.get("categoryId")))
                {
                    content.setCategory_name(Category.getCategoryName(contentCategory.getCategory_id()));
                    dataOut.add(content); //add result to vector
                }
            }
        }
        return dataOut;
    }
    public Vector<Content> getDataOut() {
        return dataOut;
    }

    public void setDataOut(Vector<Content> dataOut) {
        this.dataOut = dataOut;
    }

}
