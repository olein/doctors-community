package com.jonak.controller;
import com.jonak.lib.MySQLDatabase;
import com.jonak.lib.SessionLib;

import com.jonak.model.*;

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
    public Vector<Category> output = new Vector<Category>();

   /* public String setCategory() throws Exception
    {

        SessionLib.set("ContentID",0);
        ResultSet rs = Category.findCategory(); //get category list

        if( rs != null ) {

            while( rs.next() ) {
                Category category = new Category();
                category.setId(rs.getInt(1));
                category.setName(rs.getString(2)); //set parent category values
                output.add(category); //add result to vector
            }
        }
        return this.SUCCESS;
    } */

    public String add() throws Exception, ParseException
    {
        Content content = new Content();

        content.setUser_id(SessionLib.getUserID());
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

        ContentCategory contentCategory = new ContentCategory();
        contentCategory.setContent_id(ContentCategory.getID());
        contentCategory.setCategory_id(Integer.parseInt(ServletActionContext.getRequest().getParameter("category_id")));
        contentCategory.save(); //set content category

        Participant participant = new Participant();
        participant.setContent_id(ContentCategory.getID());
        participant.setUser_id(SessionLib.getUserID());
        participant.setActive(1);
        participant.save();
        return this.SUCCESS;
    }

    public String viewContent() throws Exception
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
                content.setAdd_participant("add_participant?content_id=" + rs.getInt(1));
                content.setShow_participant("show_participant?content_id=" + rs.getInt(1));
                content.setComments("all_comment?content_id=" + rs.getInt(1));
                ResultSet rset = ContentCategory.find(rs.getInt(1));
                if(rset.next())
                {
                    //content.setCategory_name(Category.find(rset.getInt(2)));
                }
                else
                {
                    content.setCategory_name("not specified");
                }
                messages.add(content); //add result to vector
            }
        }
        return this.SUCCESS;
    }

    public String setContentID() throws Exception
    {
        //this.setCategory(); //set content types
        SessionLib.set("ContentID", ServletActionContext.getRequest().getParameter("id")); //set content ID
        return this.SUCCESS;
    }

    public String update() throws Exception
    {
        Content content = Content.find(Integer.parseInt(SessionLib.get("ContentID")));
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
       // content.update(Integer.parseInt(SessionLib.get("ContentID"))); //update content using content ID

        if(Integer.parseInt(ServletActionContext.getRequest().getParameter("category_id"))>0) //check if it needs update
        {
            ContentCategory contentCategory = new ContentCategory();
            ResultSet rs = ContentCategory.find(Integer.parseInt(SessionLib.get("ContentID")));
            contentCategory.setContent_id(Integer.parseInt(SessionLib.get("ContentID")));
            contentCategory.setCategory_id(Integer.parseInt(ServletActionContext.getRequest().getParameter("category_id")));
            if(rs.next())
            {
                contentCategory.setId(rs.getInt(1));
                //contentCategory.update(rs.getInt(1)); //update content category
            }
        }
        return this.SUCCESS;
    }

    public String delete() throws SQLException
    {
        Content content = new Content();
        //content.delete(); //delete
        return this.SUCCESS;
    }

    public Vector<Content> getcontents() {
        return messages;
    }

    public void setcontents(Vector<Content> messages) {
        this.messages = messages;
    }

    public Vector<Category> getOutput() {
        return output;
    }

    public void setOutput(Vector<Category> output) {
        this.output = output;
    }


}
