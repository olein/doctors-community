package com.jonak.controller;
import com.jonak.lib.MySQLDatabase;
import com.jonak.lib.SessionLib;

import com.jonak.model.CategoryModel;
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
import java.util.Date;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;

import com.jonak.model.Content;
import com.jonak.model.Speciality;
import com.opensymphony.xwork2.ActionContext;
import org.apache.struts2.ServletActionContext;
import java.text.SimpleDateFormat;
import java.util.*;
/**
 * Created by Fahim on 14/11/2014.
 */
public class ContentController extends BaseController
{
    public ContentController()
    {
        super();
    }
    public Vector<Content> messages = new Vector<Content>();

    public String add() throws SQLException, ParseException
    {
        Content content = new Content();

        content.setUser_id(SessionLib.getId());
        content.setTitle(ServletActionContext.getRequest().getParameter("title"));
        content.setDescription(ServletActionContext.getRequest().getParameter("description"));
        content.setType(1);
        content.setPrivacy(Integer.parseInt(ServletActionContext.getRequest().getParameter("privacy")));
        content.setAllow_comment(Integer.parseInt(ServletActionContext.getRequest().getParameter("allow_comment")));
        content.setComment_counter(0);
        content.setParent_id(0);
        int timestamp = (int) (new Date().getTime()/1000);
        content.setCreated_at(timestamp);
        content.save(); //add content
        return this.SUCCESS;
    }

    public String viewContent() throws SQLException
    {
        // this is how we will be using
        // get the user with id 1
        SessionLib.set("ContentID",0);
        ResultSet rs = Content.find(); //get result using user id

        if( rs != null ) {

            while( rs.next() ) {
                Content content = new Content();
                content.setId(rs.getInt(1));
                content.setUser_id(rs.getInt(2));
                content.setTitle(rs.getString(3));
                content.setDescription(rs.getString(4));
                int d = (rs.getInt(10));
                Date date = new Date(((long)d)*1000L);
                content.setDate(date);
                content.setUpdate("update_content?id=" + rs.getInt(1)); //set update link
                content.setDelete("delete_content?id=" + rs.getInt(1)); //set delete link
                messages.add(content); //add result to vector
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
        Content content = Content.find(SessionLib.get("ContentID"));
        if(ServletActionContext.getRequest().getParameter("title").length()>0) {
            content.setTitle(ServletActionContext.getRequest().getParameter("title")); // reset title
        }

        if(ServletActionContext.getRequest().getParameter("description").length()>0) {
            content.setDescription(ServletActionContext.getRequest().getParameter("description"));  //reset description
        }

        if(ServletActionContext.getRequest().getParameter("privacy").length()>0) {
            content.setPrivacy(Integer.parseInt(ServletActionContext.getRequest().getParameter("privacy"))); //reset description
        }

        if(ServletActionContext.getRequest().getParameter("allow_comment").length()>0) {
            content.setPrivacy(Integer.parseInt(ServletActionContext.getRequest().getParameter("allow_comment"))); //reset description
        }
        content.setUser_id(content.getUser_id());
        content.setParent_id(content.getParent_id());
        content.setComment_counter(content.getComment_counter());
        content.setCreated_at(content.getCreated_at());
        content.setType(content.getType());

        content.update(SessionLib.get("ContentID")); //update content using content ID
        return this.SUCCESS;
    }

    public String delete() throws SQLException
    {
        Content content = new Content();
        content.delete(); //delete
        return this.SUCCESS;
    }

    public Vector<Content> getcontents() {
        return messages;
    }

    public void setcontents(Vector<Content> messages) {
        this.messages = messages;
    }



}
