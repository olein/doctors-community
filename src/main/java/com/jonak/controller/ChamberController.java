package com.jonak.controller;

import com.jonak.lib.MySQLDatabase;
import com.jonak.lib.SessionLib;
import com.jonak.model.Chamber;
import com.jonak.model.ChamberModel;
import java.sql.*;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;

import com.opensymphony.xwork2.ActionContext;
import org.apache.struts2.ServletActionContext;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Fahim on 10/11/2014.
 */
public class ChamberController extends BaseController
{
    public ChamberController()
    {
        super();
    }

    public Vector<Chamber> messages = new Vector<Chamber>();

    public String add() throws Exception
    {
        Chamber chamber = new Chamber();
        chamber.setUser_id( SessionLib.getUserID() );
        chamber.setAddress(ServletActionContext.getRequest().getParameter("address"));
        chamber.setTelephone(ServletActionContext.getRequest().getParameter("telephone"));
        chamber.setVisiting_hour(ServletActionContext.getRequest().getParameter("visiting_hour"));
        chamber.setVisiting_days(ServletActionContext.getRequest().getParameter("visiting_days"));
        chamber.setFees(ServletActionContext.getRequest().getParameter("fees"));
        chamber.save(); //add chamber
        return this.SUCCESS;
    }

    public String viewChamber() throws Exception
    {
        // this is how we will be using
        // get the user with id 1
        ResultSet rs = Chamber.find( SessionLib.getUserID() ); //get result using user id

        if( rs != null ) {

            while( rs.next() ) {
                Chamber chamber = new Chamber();
                chamber.setId(rs.getInt(1));
                chamber.setUser_id(rs.getInt(2));
                chamber.setAddress(rs.getString(3));
                chamber.setTelephone(rs.getString(4));
                chamber.setVisiting_hour(rs.getString(5));
                chamber.setVisiting_days(rs.getString(6));
                chamber.setFees(rs.getString(7));
                chamber.setUpdate("update_chamber?id=" + rs.getInt(1)); //set update link
                chamber.setDelete("delete_chamber?id="+ rs.getInt(1)); //set delete link
                messages.add(chamber); //add result to vector
            }
        }
        return this.SUCCESS;
    }

    public String setContentID() throws SQLException
    {
        SessionLib.set("ContentID", ServletActionContext.getRequest().getParameter("id")); //set content ID
        return this.SUCCESS;
    }

    public String update() throws Exception
    {
        Chamber chamber = Chamber.find();
        if(ServletActionContext.getRequest().getParameter("address").length()>0) {
            chamber.setAddress(ServletActionContext.getRequest().getParameter("address")); // reset title
        }

        if(ServletActionContext.getRequest().getParameter("telephone").length()>0) {
            chamber.setTelephone(ServletActionContext.getRequest().getParameter("telephone"));  //reset description
        }

        if(ServletActionContext.getRequest().getParameter("visiting_hour").length()>0) {
            chamber.setVisiting_hour(ServletActionContext.getRequest().getParameter("visiting_hour")); //reset description
        }

        if(ServletActionContext.getRequest().getParameter("visiting_days").length()>0) {
            chamber.setVisiting_days(ServletActionContext.getRequest().getParameter("visiting_days")); //reset description
        }

        if(ServletActionContext.getRequest().getParameter("fees").length()>0) {
            chamber.setFees(ServletActionContext.getRequest().getParameter("fees")); //reset description
        }

        // chamber.update(SessionLib.get("ContentID")); //update content using content ID
        return this.SUCCESS;
    }

    public String delete() throws SQLException
    {
        Chamber chamber = new Chamber();
        chamber.delete(); //delete chamber
        return this.SUCCESS;
    }
    public void setMessages(Vector<Chamber> messages) {
        this.messages = messages;
    }
    public Vector<Chamber> getMessages() {
        return messages;
    }
}
