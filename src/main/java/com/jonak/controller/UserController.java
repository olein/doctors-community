package com.jonak.controller;

// import custom
import com.jonak.model.User;
import com.jonak.model.UserModel;

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
import org.apache.struts2.ServletActionContext;
import java.text.SimpleDateFormat;
import java.util.*;
// import default

/**
 * user controller
 */
public class UserController extends BaseController {



    public Vector<User> messages = new Vector<User>();
    public UserController(){ super(); }

    public String test() throws SQLException
    {
        // this is how we will be using
        // get the user with id 1
        User user = User.find( 1 );

        if( user != null ) {
            System.out.printf( "Name: %s %s\n", user.getFirstName(), user.getLastName() );
            System.out.printf( "Email: %s \n", user.getEmail() );
            System.out.printf( "Address: %s \n", user.getAddress() );
            messages.add(user);
        } else {
            System.out.printf( "No user found!" );
        }
        return this.SUCCESS;
    }

    public String register() throws SQLException, ParseException
    {
        User nuser = new User();
        nuser.setEmail(ServletActionContext.getRequest().getParameter("email"));
        nuser.setPassword(ServletActionContext.getRequest().getParameter("password"));
        nuser.setFirstName(ServletActionContext.getRequest().getParameter("firstName"));
        nuser.setLastName(ServletActionContext.getRequest().getParameter("lastName"));
        nuser.setAddress(ServletActionContext.getRequest().getParameter("address"));
        nuser.setDistrict(ServletActionContext.getRequest().getParameter("district"));
        String month = ServletActionContext.getRequest().getParameter("month");
        String day = ServletActionContext.getRequest().getParameter("day");
        String year = ServletActionContext.getRequest().getParameter("year");

        String date_of_birth = month+"-"+day+"-"+year;
        DateFormat formatter = new SimpleDateFormat("MM-dd-yyyy");
        Date date = (Date)formatter.parse(date_of_birth);
        int timestamp = (int)date.getTime()/1000;
        System.out.println(timestamp);
        nuser.setDateOfBirth(timestamp);

        if(ServletActionContext.getRequest().getParameter("gender").equals("male"))
        {
            nuser.setGender(1);
        }
        if(ServletActionContext.getRequest().getParameter("gender").equals("female"))
        {
            nuser.setGender(2);
        }

        if(ServletActionContext.getRequest().getParameter("type").equals("Doctor"))
        {
            nuser.setType(2);
        }
        if(ServletActionContext.getRequest().getParameter("type").equals("Patient"))
        {
            nuser.setType(3);
        }
        nuser.setLastLoginAt(0);
        if(ServletActionContext.getRequest().getParameter("allow_message").equals("Yes"))
        {
            nuser.setAllowMessage(1);
        }
        if(ServletActionContext.getRequest().getParameter("allow_message").equals("No"))
        {
            nuser.setAllowMessage(3);
        }
        nuser.setStatus(1);
        Date date1 = new Date();
        timestamp = (int) date.getTime()/1000;
        nuser.setCreatedAt(timestamp);

        nuser.save();

        return this.SUCCESS;
    }



    public Vector<User> getMessages() {
        return messages;
    }

    public void setMessages(Vector<User> messages) {
        this.messages = messages;
    }
}

