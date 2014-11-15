package com.jonak.controller;

import com.jonak.lib.SessionLib;
import com.jonak.model.Participant;
import com.jonak.model.User;
import org.apache.struts2.ServletActionContext;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Vector;
import com.jonak.model.Message;

/**
 * Created by Fahim on 15/11/2014.
 */
public class ParticipantController extends BaseController
{
    public Vector<User> messages = new Vector<User>();
    public Vector<Participant> output = new Vector<Participant>();
    public String setUserList() throws SQLException
    {
        ResultSet rs = Participant.find(); //get user list
            if( rs != null ) {
                while( rs.next() ) {
                    User user = new User();
                    user.setId(rs.getInt(1));
                    user.setFirstName(rs.getString(4)); //set parent category values
                    user.setLastName(rs.getString(5));
                    user.setKey(rs.getString(4)+" "+rs.getString(5));
                    messages.add(user); //add result to vector
                }
            }
        SessionLib.set("ContentID", ServletActionContext.getRequest().getParameter("content_id")); //set content ID
        return this.SUCCESS;
    }

    public String add() throws SQLException
    {
        String data[] = ServletActionContext.getRequest().getParameterValues("participants[]");
        for(int i=0;i<data.length;i++) {
            Participant participant = new Participant();
            participant.setContent_id(SessionLib.get("ContentID"));
            participant.setUser_id(Integer.parseInt(data[i]));
            participant.setActive(0);
            participant.save(); //add speciality
        }

        return this.SUCCESS;
    }

    public String viewParticipant() throws SQLException
    {
        // this is how we will be using
        // get the user with id 1
        SessionLib.set("ContentID",0);
        ResultSet rs = Participant.findParticipants(); //get result using user id

        if( rs != null ) {

            while( rs.next() ) {
                Participant participant = new Participant();
                participant.setId(rs.getInt(1));
                participant.setContent_id(rs.getInt(2));
                participant.setUser_name(Message.getUserName(rs.getInt(3)));
                if(rs.getInt(4)==1) {
                    participant.setStatus("Active");
                }
                else{participant.setStatus("Request pending");}
                participant.setDelete("delete_participant?id=" + rs.getInt(1)); //set delete link
                output.add(participant); //add result to vector
            }
        }
        return this.SUCCESS;
    }

    public String delete() throws SQLException
    {
        Participant participant = new Participant();
        participant.delete(); //delete
        return this.SUCCESS;
    }

    public Vector<User> getMessages() {
        return messages;
    }

    public void setMessages(Vector<User> messages) {
        this.messages = messages;
    }

    public Vector<Participant> getOutput() {
        return output;
    }

    public void setOutput(Vector<Participant> output) {
        this.output = output;
    }

}
