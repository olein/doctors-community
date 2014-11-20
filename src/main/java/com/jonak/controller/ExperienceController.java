package com.jonak.controller;

import com.jonak.lib.MySQLDatabase;
import com.jonak.lib.SessionLib;
import com.jonak.lib.Tools;
import com.jonak.model.Experience;
import com.jonak.model.ExperienceModel;
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
 * Created by Fahim on 09/11/2014.
 */
public class ExperienceController extends BaseController
{

    public Vector<Experience> dataOut = new Vector<Experience>();

    public ExperienceController(){ super(); }

    public String createNewExperience() throws Exception
    {
        Experience exp = new Experience();
        //exp.setUser_id( SessionLib.getUserID() );
        exp.setUser_id( 1 );
        exp.setTitle(ServletActionContext.getRequest().getParameter("title"));
        exp.setDescription(ServletActionContext.getRequest().getParameter("description"));
        exp.save(); //add experience
        return this.SUCCESS;
    }

    public String viewExperience() throws Exception
    {
        // this is how we will be using
        // get the user with id 1
        dataOut = Experience.findByUserID(1); //get result using user id
        return this.SUCCESS;
    }

    public String updateExperience() throws Exception
    {
        Experience exp = Experience.findByID(1);
        if(ServletActionContext.getRequest().getParameter("title").length()>0) {
            exp.setTitle(ServletActionContext.getRequest().getParameter("title")); // reset title
        }

        if(ServletActionContext.getRequest().getParameter("description").length()>0) {
            exp.setDescription(ServletActionContext.getRequest().getParameter("description")); //reset description
        }

        exp.save();
        Tools.redirect("show_experience");
        return this.SUCCESS;
    }

    public String deleteExperience() throws Exception
    {
        Experience exp = new Experience();
        exp.delete();
        Tools.redirect("show_experience");
        return this.SUCCESS;
    }

    /*public Vector<Experience> getMessages() {
        //return messages;
        return 0;
    }*/

    public void setMessages(Vector<Experience> messages) {
        //this.messages = messages;
    }




}
