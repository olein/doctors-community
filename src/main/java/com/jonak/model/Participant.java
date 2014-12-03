package com.jonak.model;

import com.jonak.lib.MySQLDatabase;
import com.jonak.lib.SessionLib;
import com.jonak.lib.Tools;
import org.apache.struts2.ServletActionContext;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

/**
 * Created by Fahim on 15/11/2014.
 */
public class Participant extends ParticipantModel
{
    public static Vector<User> dataOut = new Vector<User>();
    public static Vector<Participant> output = new Vector<Participant>();
    public static Vector find() throws Exception {
        User user = new User();
        MySQLDatabase db = new MySQLDatabase();

        String _tableName = "user",
                _fieldName = "*",
                _filter = "";
        ArrayList _fields = new ArrayList(),
                _types = new ArrayList(),
                _values = new ArrayList();


        ResultSet rs = db.executeSelectQuery(_tableName, _fieldName, _fields, _types, _values, _filter );


        if( rs != null ) {
            dataOut.clear();
            while( rs.next() ) {
                if(rs.getInt(10)<4) {
                    user = new User();
                    user.setId(rs.getInt(1));
                    user.setFirstName(rs.getString(4)); //set parent category values
                    user.setLastName(rs.getString(5));
                    dataOut.add(user); //add result to vector
                }
            }
        }
        return dataOut;

    }

    public static Vector findParticipants() throws Exception
    {
        MySQLDatabase db = new MySQLDatabase();

        String  _tableName = "participant",
                _fieldName = "*",
                _filter = "";
        ArrayList   _fields = new ArrayList(),
                _types  = new ArrayList(),
                _values = new ArrayList();

        _fields.add("content_id");_types.add("int");_values.add(Integer.parseInt(Tools.get("id"))); //find current user

        ResultSet rs = db.executeSelectQuery( _tableName, _fieldName, _fields, _types, _values, _filter ); //search experience using content id

        if( rs != null ) {
            output.clear();
            while( rs.next() ) {
                Participant participant = new Participant();
                participant.setId(rs.getInt(1));
                participant.setContent_id(rs.getInt(2));
                participant.setUser_id(rs.getInt(3));
                User user = User.findById(participant.getUser_id());
                participant.setUser_name(user.getFirstName()+" "+user.getLastName());
                if(rs.getInt(4)==1) {
                    participant.setStatus("Active");
                }
                else{participant.setStatus("Left Board");}

                output.add(participant); //add result to vector
            }
        }
        return output;
    }
}
