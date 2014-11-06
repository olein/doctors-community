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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;
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

        // NOW your TASK is to find a way to send this "user" object
        // to front jsp file so we can show it
        // instead of console out :)

        return this.SUCCESS;
    }

    public Vector<User> getMessages() {
        return messages;
    }

    public void setMessages(Vector<User> messages) {
        this.messages = messages;
    }
}

