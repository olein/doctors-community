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
    private static Vector<Chamber> dataOut = new Vector<Chamber>();

    public static Vector findAllChamber() throws SQLException
    {
        MySQLDatabase db = new MySQLDatabase();

        String  _tableName = "chamber_detail",
                _fieldName = "*",
                _filter = "";
        ArrayList   _fields = new ArrayList(),
                _types  = new ArrayList(),
                _values = new ArrayList();

        ResultSet rs = db.executeSelectQuery( _tableName, _fieldName, _fields, _types, _values, _filter);
        if( rs != null ) {
            dataOut.clear();
            while (rs.next()) {
                Chamber chamber = new Chamber();
                chamber.setId(rs.getInt("id"));
                chamber.setUserId(rs.getInt("user_id"));
                chamber.setName(rs.getString("name"));
                chamber.setAddress(rs.getString("address"));
                chamber.setTelephone(rs.getString("telephone"));
                chamber.setVisitingHour(rs.getString("visiting_hour"));
                chamber.setVisitingDays(rs.getString("visiting_days"));
                chamber.setFees(rs.getString("fees"));
                chamber.clear();
                //add result to vector
                dataOut.add(chamber);
            }
        }
        return dataOut;
    }

    public static Chamber findChamberByID(int id) throws Exception
    {
        Chamber chamber = new Chamber();
        MySQLDatabase db = new MySQLDatabase();

        String  _tableName = "chamber_detail",
                _fieldName = "*",
                _filter = "";
        ArrayList   _fields = new ArrayList(),
                _types  = new ArrayList(),
                _values = new ArrayList();

        _fields.add("id"); _types.add("int"); _values.add( id ); //find using ID

        ResultSet rs = db.executeSelectQuery( _tableName, _fieldName, _fields, _types, _values, _filter);
        if( rs.next() ) {
            chamber = Chamber.setData(rs);
            return chamber;
        } else {
            chamber = null;
        }
        return chamber;
    }
    //find chamber by user id
    //user id must be available in session
    public static Vector findByUserID(int user_id) throws SQLException
    {
        MySQLDatabase db = new MySQLDatabase();

        String  _tableName = "chamber_detail",
                _fieldName = "*",
                _filter = " limit 1 ";
        ArrayList   _fields = new ArrayList(),
                _types  = new ArrayList(),
                _values = new ArrayList();
        _fields.add("user_id"); _types.add("int"); _values.add(user_id);

        ResultSet rs = db.executeSelectQuery( _tableName, _fieldName, _fields, _types, _values, _filter);
        if( rs != null ) {
            dataOut.clear();
            while (rs.next()) {
                Chamber chamber = new Chamber();
                chamber.setId(rs.getInt("id"));
                chamber.setUserId(rs.getInt("user_id"));
                chamber.setName(rs.getString("name"));
                chamber.setAddress(rs.getString("address"));
                chamber.setTelephone(rs.getString("telephone"));
                chamber.setVisitingHour(rs.getString("visiting_hour"));
                chamber.setVisitingDays(rs.getString("visiting_days"));
                chamber.setFees(rs.getString("fees"));
                chamber.clear();
                //add result to vector
                dataOut.add(chamber);
            }
        }
        return dataOut;
    }

    public static Vector findByID(int id) throws Exception
    {
        Chamber chamber = new Chamber();
        MySQLDatabase db = new MySQLDatabase();

        String  _tableName = "chamber_detail",
                _fieldName = "*",
                _filter = " limit 1 ";
        ArrayList   _fields = new ArrayList(),
                _types  = new ArrayList(),
                _values = new ArrayList();

        _fields.add("id"); _types.add("int"); _values.add( id ); //find using ID

        ResultSet rs = db.executeSelectQuery( _tableName, _fieldName, _fields, _types, _values, _filter );
        if( rs.next() ) {
            chamber = Chamber.setData(rs);
            dataOut.add(chamber);
            return dataOut;
        } else {
            chamber = null;
        }
        return dataOut;
    }

    private static Chamber setData( ResultSet rs ) throws SQLException
    {
        Chamber chamber = new Chamber();
        chamber.setId(rs.getInt("id"));
        chamber.setUserId(rs.getInt("user_id"));
        chamber.setName(rs.getString("name"));
        chamber.setAddress(rs.getString("address"));
        chamber.setTelephone(rs.getString("telephone"));
        chamber.setVisitingHour(rs.getString("visiting_hour"));
        chamber.setVisitingDays(rs.getString("visiting_days"));
        chamber.setFees(rs.getString("fees"));
        chamber.clear();
        return chamber;
    }

    public void setdataOut(Vector<Chamber> dataOut) {
        this.dataOut = dataOut;
    }
    public Vector<Chamber> getdataOut() {
        return dataOut;
    }
}
