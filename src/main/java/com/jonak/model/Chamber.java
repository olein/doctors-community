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
}
