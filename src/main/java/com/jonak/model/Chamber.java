package com.jonak.model;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Vector;

// import custom
import com.jonak.lib.MySQLDatabase;
import com.jonak.lib.SessionLib;
import com.jonak.model.ChamberModel;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionContext;
/**
 * Created by Fahim on 10/11/2014.
 */
public class Chamber extends ChamberModel
{
    public static ResultSet find(int user_id) throws SQLException
    {
        MySQLDatabase db = new MySQLDatabase();

        String  _tableName = "chamber_detail",
                _fieldName = "*";
        ArrayList   _fields = new ArrayList(),
                _types  = new ArrayList(),
                _values = new ArrayList();
        _fields.add("user_id"); _types.add("int"); _values.add(user_id);

        ResultSet rs = db.executeSelectQuery( _tableName, _fieldName, _fields, _types, _values); //search using user id
        return rs;
    }

    public static Chamber find() throws SQLException
    {
        Chamber chamber = new Chamber();
        MySQLDatabase db = new MySQLDatabase();

        String  _tableName = "chamber_detail",
                _fieldName = "*";
        ArrayList   _fields = new ArrayList(),
                _types  = new ArrayList(),
                _values = new ArrayList();
        _fields.add("id"); _types.add("int"); _values.add(SessionLib.get("ContentID")); //find using contentID

        ResultSet rs = db.executeSelectQuery( _tableName, _fieldName, _fields, _types, _values); //search experience using content id
        if( rs.next() ) {
            chamber.setId(rs.getInt(1));
            chamber.setUser_id(rs.getInt("user_id"));
            chamber.setAddress(rs.getString(3));
            chamber.setTelephone(rs.getString(4));
            chamber.setVisiting_hour((rs.getString(5)));
            chamber.setVisiting_days((rs.getString(6)));
            chamber.setFees((rs.getString(7)));
        } else {
            chamber = null;
        }
        return chamber;
    }
}
