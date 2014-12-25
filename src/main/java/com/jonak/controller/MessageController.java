package com.jonak.controller;
import com.jonak.lib.MySQLDatabase;
import com.jonak.lib.SessionLib;
import com.jonak.model.User;
import org.json.simple.*;

import com.jonak.lib.Tools;
import com.jonak.model.CategoryModel;

import java.io.PrintWriter;
import java.io.StringWriter;
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

    // view message
    public String viewMessages() throws Exception
    {
        // get params
        String  action = Tools.get("action"),
                strFuid = Tools.get("fuid");
        int fuid = (strFuid == null) ? 0 : Integer.parseInt(strFuid);

        // prepare params
        int id = SessionLib.getUserID();
        String _filter = " group by from_user_id order by created_at desc ";
        ArrayList   _fields = new ArrayList(),
                    _types  = new ArrayList(),
                    _values = new ArrayList();

        _fields.add("to_user_id");
        _types.add("int");
        _values.add(id);

        // get all inbox msg
        Vector inboxMsg = Message.find(_fields, _types, _values, _filter);
        this.dataOut.clear();
        this.dataOut.add(inboxMsg);

        // if not selected current user
        // make the first inbox msg selected
        if( fuid <= 0 && inboxMsg.size() > 0) {
            Message msg = Message.class.cast( inboxMsg.get(0) );
            fuid = msg.getFromUserId();
        }

        // prepare params
        _fields.clear();
        _types.clear();
        _values.clear();

        String  where = " where ( from_user_id=? and to_user_id=? ) or ( from_user_id=? and to_user_id=? ) ",
                filter = " order by created_at desc ";
        _values.add(fuid);
        _values.add(id);
        _values.add(id);
        _values.add(fuid);

        // get msg history of current user
        Vector allMsg = Message.findAll( where, _values, filter );

        this.dataOut.add( allMsg );
        this.dataOut.add( fuid );

        return this.SUCCESS;
    }

    // new message OR save message
    public void saveMessage() throws Exception
    {
        // get params
        String  ajax = Tools.get("ajax"),
                strToUserId = Tools.get("toUserId"),
                strFromUserId = Tools.get("fromUserId"),
                msg = Tools.get("msg");
        System.out.println(ajax+" "+strToUserId+" "+strFromUserId+" "+msg);

        // parse data
        int toUserId = Tools.toInt( strToUserId ),
            fromUserId = Tools.toInt( strFromUserId );

        // save message
        Message message = new Message();
        message.setCreated_at( Tools.getTimeStamp() );
        message.setToUserId( toUserId );
        message.setFromUserId( fromUserId );
        message.setMsg(msg);
        message.save();

        // return message
        if( ajax != null && ajax.equals("1")) {
            // ajax response
            System.out.println(ajax);
            JSONObject response = new JSONObject();
            response.put("result", "ok");
            response.put("displayname", User.getDisplayName( toUserId ) );
            response.put("profilePic", "http://placehold.it/64");

            Tools.ajaxResponse( response );
        } else {
            // redirect to to page
            Tools.redirect("messages?action=view&fuid="+toUserId);
        }

    }

    // delete a single msg
    public void delete() throws Exception
    {
        // get params
        String  action = Tools.get("action"),
                strMid = Tools.get("id");

        int strFuid=0;

        int mid = ( strMid != null ) ? Tools.toInt(strMid) : 0;

        // if action is delete & given a valid id
        // delete it
        if( action.equals("delete") && mid > 0 ) {
            Message message = Message.findById( mid );
            strFuid = message.getToUserId();
            message.delete(); //delete
        }

        // redirect to view page
        Tools.redirect("messages?action=view&fuid="+strFuid);
    }
}
