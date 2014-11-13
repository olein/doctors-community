package com.jonak.controller;
import com.jonak.lib.Emailer;
import com.jonak.lib.MySQLDatabase;
import com.jonak.lib.SessionLib;
import com.jonak.model.Configuration;
import com.jonak.model.ConfigurationModel;

//import java.sql.SQLException;
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
 * Created by Fahim on 13/11/2014.
 */
public class ConfigurationController extends BaseController
{
    public Vector<Configuration> messages = new Vector<Configuration>();

    public String add() throws SQLException
    {
        Configuration configuration = new Configuration();
        configuration.setKey(ServletActionContext.getRequest().getParameter("key"));
        configuration.setValue(ServletActionContext.getRequest().getParameter("value"));
        configuration.save();
        return this.SUCCESS;
    }

    public String viewConfiguration() throws SQLException
    {
        // this is how we will be using
        // get the user with id 1
        ResultSet rs = Configuration.find(0); //get result using user id

        if( rs != null ) {

            while( rs.next() ) {
                Configuration configuration = new Configuration();
                configuration.setKey(rs.getString(2));
                configuration.setValue(rs.getString(3));

                configuration.setUpdate("update_configuration.action?id=" + rs.getInt(1)); //set update link
                configuration.setDelete("delete_configuration.action?id="+ rs.getInt(1)); //set delete link
                messages.add(configuration); //add result to vector
            }
        }
        return this.SUCCESS;
    }

    public String setContentID() throws SQLException
    {
        SessionLib.set("ContentID", ServletActionContext.getRequest().getParameter("id")); //set content ID
        return this.SUCCESS;
    }

    public String update() throws SQLException
    {
        Configuration configuration = Configuration.find();
        if(ServletActionContext.getRequest().getParameter("key").length()>0) {
            configuration.setKey(ServletActionContext.getRequest().getParameter("key")); // reset title
        }

        if(ServletActionContext.getRequest().getParameter("value").length()>0) {
            configuration.setValue(ServletActionContext.getRequest().getParameter("value")); //reset description
        }

        configuration.update(SessionLib.get("ContentID")); //update content using content ID
        return this.SUCCESS;
    }

    public String delete() throws SQLException
    {
        Configuration configuration = new Configuration();
        configuration.delete();
        return this.SUCCESS;
    }

    public Vector<Configuration> getMessages() {
        return messages;
    }

    public void setMessages(Vector<Configuration> messages) {
        this.messages = messages;
    }
}
