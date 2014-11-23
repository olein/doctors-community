package com.jonak.model;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

// import custom
import com.jonak.lib.MySQLDatabase;
import com.jonak.lib.SessionLib;

/**
 * Created by Fahim on 10/11/2014.
 */
public class Education extends EducationModel
{
    private static Vector<Education> dateOutToController = new Vector<Education>();

    public static Vector findByUserID(int user_id) throws SQLException
    {
        MySQLDatabase db = new MySQLDatabase();

        String  _tableName = "education",
                _fieldName = "*";
        ArrayList   _fields = new ArrayList(),
                _types  = new ArrayList(),
                _values = new ArrayList();
        _fields.add("user_id"); _types.add("int"); _values.add(user_id);

        ResultSet rs = db.executeSelectQuery( _tableName, _fieldName, _fields, _types, _values); //search using user id
        dateOutToController.clear();
        while ( rs.next() ) {
            Education education = new Education();
            education.setId(rs.getInt( "id" ));
            education.setUser_id(rs.getInt("user_id"));
            education.setDegree(rs.getString("degree"));
            education.setInstitute(rs.getString("institute"));
            education.setResult((rs.getString("result")));
            //add to vector to send result to controller
            dateOutToController.add(education);
        }
        return dateOutToController;
    }
    public static Education findEducationByID(int id) throws Exception
    {
        Education education = new Education();
        MySQLDatabase db = new MySQLDatabase();

        String  _tableName = "education",
                _fieldName = "*";
        ArrayList   _fields = new ArrayList(),
                _types  = new ArrayList(),
                _values = new ArrayList();

        _fields.add("id"); _types.add("int"); _values.add( id );

        ResultSet rs = db.executeSelectQuery( _tableName, _fieldName, _fields, _types, _values); //search experience using content id
        if( rs.next() ) {
            education.setId(rs.getInt("id"));
            education.setUser_id(rs.getInt("user_id"));
            education.setDegree(rs.getString("degree"));
            education.setInstitute(rs.getString("institute"));
            education.setResult((rs.getString("result")));
        } else {
            education = null;
        }
        return education;
    }
    public Vector<Education> getDateOutToController() {
        return dateOutToController;
    }

    public void setDateOutToController(Vector<Education> dateOutToController) {
        this.dateOutToController = dateOutToController;
    }

}
