package com.jonak.controller;

import com.jonak.lib.SessionLib;
import com.jonak.lib.Tools;
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
    //public Vector<User> dataOut = new Vector<User>();
    public Vector<Participant> output = new Vector<Participant>();

    public String setUserList() throws Exception
    {
        dataOut = Participant.find(); //get user list
        return this.SUCCESS;
    }

    public void saveParticipant() throws Exception
    {
        String data[] = ServletActionContext.getRequest().getParameterValues("participants[]");
        for(int i=0;i<data.length;i++) {
            Participant participant = new Participant();
            participant.setContent_id(Integer.parseInt(SessionLib.get("ContentId")));
            participant.setUser_id(Integer.parseInt(data[i]));
            participant.setActive(1);
            participant.save(); //add speciality
            String red = "participants?id="+SessionLib.get("ContentId");
            Tools.redirect(red);
        }
    }

    public String viewParticipant() throws Exception
    {
        // this is how we will be using
        // get the user with id 1

        // type 1
        SessionLib.set("ContentID",0);
//        ResultSet rs = Participant.findParticipants(); //get result using user id
//        Vector p = Participant.findParticipants(); //get result using user id

        /*if( rs != null ) {

            while( rs.next() ) {
                Participant participant = new Participant();
                participant.setId(rs.getInt(1));
                participant.setContent_id(rs.getInt(2));
                // participant.setUser_name(Message.getUserName(rs.getInt(3)));
                if(rs.getInt(4)==1) {
                    participant.setStatus("Active");
                }
                else{participant.setStatus("Request pending");}
                participant.setDelete("delete_participant?id=" + rs.getInt(1)); //set delete link
                output.add(participant); //add result to vector
            }
        }*/
        /* end of type 1 */

        // type 2
        //SessionLib.set("ContentID",0);
        output = Participant.findParticipants();
        SessionLib.set("ContentId",Tools.get("id"));
        /* end of type 2 */

        return this.SUCCESS;
    }

    public void deleteParticipant() throws Exception
    {
        Participant participant = new Participant();
        participant.delete(); //delete
        Tools.redirect("participants?id="+SessionLib.get("ContentId"));
    }

    public Vector<Participant> getOutput() {
        return output;
    }

    public void setOutput(Vector<Participant> output) {
        this.output = output;
    }

}
