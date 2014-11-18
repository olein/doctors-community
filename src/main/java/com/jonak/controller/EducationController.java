package com.jonak.controller;

import com.jonak.lib.MySQLDatabase;
import com.jonak.lib.SessionLib;
import com.jonak.model.Education;
import com.jonak.model.EducationModel;
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
public class EducationController extends BaseController
{
    public EducationController()
    {
        super();
    }

    public Vector<Education> getMessages() {
        return messages;
    }

    public String add() throws SQLException, ParseException
    {
        Education education = new Education();
        education.setUser_id(SessionLib.get("user_id"));
        education.setDegree(ServletActionContext.getRequest().getParameter("degree"));
        education.setInstitute(ServletActionContext.getRequest().getParameter("institute"));
        education.setResult(ServletActionContext.getRequest().getParameter("result"));
        education.save(); //add education
        return this.SUCCESS;
    }

    public String viewEducation() throws SQLException
    {
        // this is how we will be using
        // get the user with id 1
        ResultSet rs = Education.find(SessionLib.get("user_id")); //get result using user id

        if( rs != null ) {

            while( rs.next() ) {
                Education education = new Education();
                education.setId(rs.getInt(1));
                education.setUser_id(rs.getInt(2));
                education.setDegree(rs.getString(3));
                education.setInstitute(rs.getString(4));
                education.setResult(rs.getString(5));
                education.setUpdate("update_education?id=" + rs.getInt(1)); //set update link
                education.setDelete("delete_education?id="+ rs.getInt(1)); //set delete link
                messages.add(education); //add result to vector
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
        Education education = Education.find();
        if(ServletActionContext.getRequest().getParameter("degree").length()>0) {
            education.setDegree(ServletActionContext.getRequest().getParameter("degree")); // reset title
        }

        if(ServletActionContext.getRequest().getParameter("institute").length()>0) {
            education.setInstitute(ServletActionContext.getRequest().getParameter("institute"));  //reset description
        }

        if(ServletActionContext.getRequest().getParameter("result").length()>0) {
            education.setResult(ServletActionContext.getRequest().getParameter("result")); //reset description
        }

        education.update(SessionLib.get("ContentID")); //update content using content ID
        return this.SUCCESS;
    }

    public String delete() throws SQLException
{
    Education education = new Education();
    education.delete(); //delete
    return this.SUCCESS;
}

    public void setMessages(Vector<Education> messages) {
        this.messages = messages;
    }

    public Vector<Education> messages = new Vector<Education>();



}
