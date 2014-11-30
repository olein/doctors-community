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
        String _filter = " group by from_user_id order by created_at asc ";
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
        if( fuid <= 0) {
            Message msg = Message.class.cast(inboxMsg.get(0));
            fuid = msg.getFromUserId();
        }

        // prepare params
        _fields.clear();
        _types.clear();
        _values.clear();

        String  where = " where ( from_user_id=? and to_user_id=? ) or ( from_user_id=? and to_user_id=? ) ",
                filter = " order by created_at asc ";
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

    // delete a single msg
    public String delete() throws Exception
    {
        // get params
        String  action = Tools.get("action"),
                strFuid = Tools.get("fuid"),
                strMid = Tools.get("mid");

        int mid = ( strMid != null ) ? Integer.parseInt( strMid ) : 0;

        // if action is delete & given a valid id
        // delete it
        if( action.equals("delete") && mid > 0 ) {
            Message message = Message.findById( mid );
            message.delete(); //delete
        }

        // redirect to view page
        Tools.redirect("messages?action=view&fuid="+strFuid);

        return this.SUCCESS;
    }
}
