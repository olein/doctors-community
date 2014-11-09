package com.jonak.controller;

import com.jonak.lib.MySQLDatabase;
import com.jonak.lib.SessionLib;
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

    public Vector<Experience> messages = new Vector<Experience>();

    public ExperienceController(){ super(); }

    public String create() throws SQLException, ParseException
    {
        Experience exp = new Experience();
        exp.setUser_id(SessionLib.getId());
        exp.setTitle(ServletActionContext.getRequest().getParameter("title"));
        exp.setDescription(ServletActionContext.getRequest().getParameter("description"));
        exp.save();
        return this.SUCCESS;
    }

    public String viewExperience() throws SQLException
    {
        // this is how we will be using
        // get the user with id 1
        ResultSet rs = Experience.find(SessionLib.getId()); //get result using user id

        if( rs != null ) {

            while( rs.next() ) {
                Experience exp = new Experience();
                exp.setId(rs.getInt(1));
                exp.setUser_id(rs.getInt(2));
                exp.setTitle(rs.getString(3));
                exp.setDescription(rs.getString(4));
                messages.add(exp); //add result to vector
            }
        }
        return this.SUCCESS;
    }

    public Vector<Experience> getMessages() {
        return messages;
    }

    public void setMessages(Vector<Experience> messages) {
        this.messages = messages;
    }


}
