package com.jonak.controller;
import com.jonak.lib.MySQLDatabase;
import com.jonak.lib.SessionLib;

import com.jonak.lib.Tools;
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

    public Vector<Category> output = new Vector<Category>();
    public Vector<Comment> comment = new Vector<Comment>();

    public String setCategory() throws Exception
    {

        SessionLib.set("id",0);
        output = Category.findCategory(); //get category list
        return this.SUCCESS;
    }

    public void saveContent() throws Exception, ParseException {
        Content content = new Content();
        ContentCategory contentCategory = new ContentCategory();

        String  title = Tools.get("title"),
                description = Tools.get("description"),
                privacy = Tools.get("privacy"),
                type = Tools.get("type"),
                allowComment = Tools.get("allow_comment"),
                categoryId = Tools.get("categoryId");


        if(Integer.parseInt(SessionLib.get("id"))>0)
        {
            content = Content.findContentByID(Integer.parseInt(SessionLib.get("id")));
            if( ! content.getTitle().equals( title ) ) { content.setTitle(title); }
            if( ! content.getDescription().equals(description) ) { content.setDescription(description); }
            if(  content.getType()!=( Integer.parseInt(type) ) ) { content.setType( Integer.parseInt(type )); }
            if(  content.getPrivacy()!=( Integer.parseInt(privacy) ) ) { content.setPrivacy(Integer.parseInt(privacy)); }
            if(  content.getAllow_comment()!=( Integer.parseInt(allowComment) ) ) { content.setAllow_comment(Integer.parseInt(allowComment)); }
            content.save();

            contentCategory = ContentCategory.findByContentID(Integer.parseInt(SessionLib.get("id")));
            contentCategory.setContent_id(contentCategory.getContent_id());
            contentCategory.setCategory_id(Integer.parseInt(categoryId ));
            contentCategory.save();
            SessionLib.unset("id");
        }
        else{
            content.setUser_id(SessionLib.getUserID());
            content.setTitle(title);
            content.setDescription(description);
            content.setType(Integer.parseInt(type));
            content.setPrivacy(Integer.parseInt(privacy));
            content.setAllow_comment(Integer.parseInt(allowComment));
            content.setComment_counter(0);
            content.setParent_id(0);
            content.setCreated_at(Tools.getTimeStamp());
            content.save();

            contentCategory.setContent_id(ContentCategory.getID());
            contentCategory.setCategory_id(Integer.parseInt( categoryId ));
            contentCategory.save();
        }

        if(Integer.parseInt(type)==1)
        {
            Participant participant = new Participant();
            participant.setContent_id(ContentCategory.getID());
            participant.setUser_id(SessionLib.getUserID());
            participant.setActive(1);
            participant.save();
            Tools.redirect("my-board?type=1");
        }
        if(Integer.parseInt(type)==2)
        {
            Tools.redirect("my-patient-case?type=2");
        }
        if(Integer.parseInt(type)==3)
        {
            Tools.redirect("my-discussion?type=3");
        }
        if(Integer.parseInt(type)==4)
        {
            Tools.redirect("my-patient-question?type=4");
        }
        if(Integer.parseInt(type)==5)
        {
            Tools.redirect("my-article?type=5");
        }
        if(Integer.parseInt(type)==6)
        {
            Tools.redirect("my-health-tips?type=6");
        }
    }

    public String viewAllContent() throws Exception
    {
        // this is how we will be using
        // get the user with id 1
        dataOut = Content.findAllContent(); //get result using user id
        System.out.println("size is: "+dataOut.size());
        return this.SUCCESS;
    }
    public String viewAllParticipatedContent() throws Exception
    {
        // this is how we will be using
        // get the user with id 1
        dataOut = Content.findAllParticipatedContent(); //get result using user id
        System.out.println("size is: "+dataOut.size());
        return this.SUCCESS;
    }

    public String viewAllPublicContent() throws Exception
    {
        // this is how we will be using
        // get the user with id
        SessionLib.set("id",0);
        output = Category.findCategory();
        dataOut = Content.findAllPublicContent(); //get result using user id
        System.out.println("size is: "+dataOut.size());
        return this.SUCCESS;
    }

    public String viewContent() throws Exception
    {
        // this is how we will be using
        // get the user with id 1
        SessionLib.set("id",0);
        Content content = Content.findContentByID(Integer.parseInt(Tools.get("id"))); //get result using user id
        dataOut.add(content);
        output = Category.findCategory();
        SessionLib.set("id", content.getId());
        return this.SUCCESS;
    }

    public String viewDetail() throws Exception
    {
        // this is how we will be using
        // get the user with id 1
        SessionLib.set("id",0);
        Content content = Content.findContentByID(Integer.parseInt(Tools.get("id"))); //get result using user id
        dataOut.add(content);
        comment = Comment.find();
        SessionLib.set("id", content.getId());
        return this.SUCCESS;
    }

    public String viewAllUndiscussedContent() throws Exception
    {
        // this is how we will be using
        // get the user with id 1
        dataOut = Content.findAllUndiscussedContent(); //get result using user id
        return this.SUCCESS;
    }

    public void deleteContent() throws Exception
    {
        Content content = new Content();
        content.delete(); //delete
        SessionLib.unset("id");
        int type = Integer.parseInt(Tools.get("type"));
        if(type==1)
        {
            Tools.redirect("my-board?type=1");
        }
        if(type==2)
        {
            Tools.redirect("my-patient-case?type=2");
        }
        if(type==3)
        {
            Tools.redirect("my-discussion?type=3");
        }
        if(type==4)
        {
            Tools.redirect("my-patient-question?type=4");
        }
        if(type==5)
        {
            Tools.redirect("my-article?type=5");
        }
        if(type==6)
        {
            Tools.redirect("my-health-tips?type=6");
        }
    }

    public String searchByCategory() throws Exception
    {
        // this is how we will be using
        // get the user with id 1

        dataOut = Content.findByCategory(); //get result using user id
        return this.SUCCESS;
    }

    public String searchByKeyWord() throws Exception
    {
        // this is how we will be using
        // get the user with id 1

        dataOut = Content.findByKeyWord(); //get result using user id
        return this.SUCCESS;
    }

    public Vector<Content> getcontents() {
        return dataOut;
    }

    public void setcontents(Vector<Content> dataOut) {
        this.dataOut = dataOut;
    }

    public Vector<Category> getOutput() {
        return output;
    }

    public void setOutput(Vector<Category> output) {
        this.output = output;
    }


}
