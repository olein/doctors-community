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
import com.jonak.model.SpecialityModel;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionContext;
/**
 * Created by Fahim on 12/11/2014.
 */
public class Speciality extends SpecialityModel
{
    public static Vector<Speciality> specialities = new Vector<Speciality>();

    public static Vector findSpeciality(int userId) throws Exception
    {
        MySQLDatabase db = new MySQLDatabase();
        Category category = new Category();
        String  _tableName = "category_user_relation",
                _fieldName = "*",
                _filter = "";
        ArrayList   _fields = new ArrayList(),
                _types  = new ArrayList(),
                _values = new ArrayList();
        _fields.add("user_id"); _types.add("int"); _values.add(userId);


        ResultSet rs = db.executeSelectQuery( _tableName, _fieldName, _fields, _types, _values, _filter);
        if( rs != null ) {
            specialities.clear();
            while( rs.next() ) {
                Speciality speciality = new Speciality();
                speciality.setId(rs.getInt("id"));
                speciality.setUserId(rs.getInt("user_id"));
                speciality.setCategoryId(rs.getInt("category_id"));
                speciality.setCategoryName(Category.getCategoryName(speciality.getCategoryId()));
                specialities.add(speciality); //add result to vector
            }
        }
        return specialities;
    }
}
