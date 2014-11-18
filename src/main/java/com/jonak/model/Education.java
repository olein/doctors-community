package com.jonak.model;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Vector;

// import custom
import com.jonak.lib.MySQLDatabase;
import com.jonak.lib.SessionLib;
import com.jonak.model.EducationModel;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionContext;
/**
 * Created by Fahim on 10/11/2014.
 */
public class Education extends EducationModel
{
    public static ResultSet find(int user_id) throws SQLException
    {
        MySQLDatabase db = new MySQLDatabase();

        String  _tableName = "education",
                _fieldName = "*";
        ArrayList   _fields = new ArrayList(),
                _types  = new ArrayList(),
                _values = new ArrayList();
        _fields.add("user_id"); _types.add("int"); _values.add(user_id);

        ResultSet rs = db.executeSelectQuery( _tableName, _fieldName, _fields, _types, _values); //search using user id
        return rs;
    }
    public static Education find() throws Exception
    {
        Education education = new Education();
        MySQLDatabase db = new MySQLDatabase();

        String  _tableName = "education",
                _fieldName = "*";
        ArrayList   _fields = new ArrayList(),
                _types  = new ArrayList(),
                _values = new ArrayList();
        int contentId = Integer.parseInt( SessionLib.get("ContentID") );
        _fields.add("id"); _types.add("int"); _values.add( contentId );

        ResultSet rs = db.executeSelectQuery( _tableName, _fieldName, _fields, _types, _values); //search experience using content id
        if( rs.next() ) {
            education.setId(rs.getInt(1));
            education.setUser_id(rs.getInt("user_id"));
            education.setDegree(rs.getString("degree"));
            education.setInstitute(rs.getString("institute"));
            education.setResult((rs.getString("result")));
        } else {
            education = null;
        }
        return education;
    }
}
