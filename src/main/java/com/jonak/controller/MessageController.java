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

import com.jonak.model.Message;
import com.jonak.model.Speciality;
import com.opensymphony.xwork2.ActionContext;
import org.apache.struts2.ServletActionContext;
import java.text.SimpleDateFormat;
import java.util.*;
/**
 * Created by Fahim on 13/11/2014.
 */
public class MessageController extends BaseController
{
    public MessageController()
    {
        super();
    }
    public Vector<Message> messages = new Vector<Message>();

    public String setToUser() throws SQLException
    {

        //SessionLib.set("ContentID",0);
        ResultSet rs = Message.getUser(); //get category list

        if( rs != null ) {

            while( rs.next() ) {
                Message message = new Message();
                message.setTo_user_id(rs.getInt(1));
                message.setUser_name(rs.getString(4) + " " + rs.getString(5)); //set user name values
                messages.add(message); //add result to vector
            }
        }
        return this.SUCCESS;
    }

    public String add() throws SQLException, ParseException
    {
        Message message = new Message();

        message.setTo_user_id(Integer.parseInt(ServletActionContext.getRequest().getParameter("to_user_id")));
        message.setFrom_user_id(SessionLib.getId());
        message.setMsg(ServletActionContext.getRequest().getParameter("msg"));
        int timestamp = (int) (new Date().getTime()/1000);
        message.setCreated_at(timestamp);
        message.save(); //add message
        return this.SUCCESS;
    }

    public String viewMessages() throws SQLException
    {
        // this is how we will be using
        // get the user with id 1
        SessionLib.set("ContentID",0);
        ResultSet rs = Message.find(); //get result using user id

        if( rs != null ) {

            while( rs.next() ) {
                Message message = new Message();
                message.setId(rs.getInt(1));
                message.setTo_user_id(rs.getInt(3));
                message.setUser_name(Message.getUserName(rs.getInt(3)));
                message.setMsg(rs.getString(4));
                int d = (rs.getInt(5));
                Date date = new Date(((long)d)*1000L);
                message.setDate(date);
                message.setUpdate("update_message?id=" + rs.getInt(1)); //set update link
                message.setDelete("delete_message?id=" + rs.getInt(1)); //set delete link
                messages.add(message); //add result to vector
            }
        }
        return this.SUCCESS;
    }

    public String delete() throws SQLException
    {
        Message message = new Message();
        message.delete(); //delete
        return this.SUCCESS;
    }

    public Vector<Message> getMessages() {
        return messages;
    }

    public void setMessages(Vector<Message> messages) {
        this.messages = messages;
    }


}
