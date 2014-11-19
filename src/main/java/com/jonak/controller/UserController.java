package com.jonak.controller;

// import custom
import com.jonak.lib.Emailer;
import com.jonak.lib.SessionLib;
import com.jonak.lib.Tools;
import com.jonak.model.User;

// import default
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Vector;
import org.apache.struts2.ServletActionContext;
import java.text.SimpleDateFormat;
import java.util.*;


/**
 * user controller
 */
public class UserController extends BaseController
{
    public Vector<User> dataOut = new Vector<User>();

    public UserController(){ super(); }

    // test method
    public String test() throws SQLException
    {
        // this is how we will be using
        // get the user with id 1
        User user = User.find( 1 );

        if( user != null ) {
            System.out.printf( "Name: %s %s\n", user.getFirstName(), user.getLastName() );
            System.out.printf( "Email: %s \n", user.getEmail() );
            System.out.printf( "Address: %s \n", user.getAddress() );
            this.dataOut.add(user);
        } else {
            System.out.printf( "No user found!" );
        }
        return this.SUCCESS;
    }

    // new user register
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
        nuser.setGender(Integer.parseInt(ServletActionContext.getRequest().getParameter("gender")));
        nuser.setType(Integer.parseInt(ServletActionContext.getRequest().getParameter("type")));
        nuser.setLastLoginAt(0);
        nuser.setAllowMessage(Integer.parseInt(ServletActionContext.getRequest().getParameter("allow_message")));
        nuser.setStatus(1);
        Date date1 = new Date();
        timestamp = (int) date.getTime()/1000;
        nuser.setCreatedAt(timestamp);
        nuser.setToken("");

        nuser.save();

        return this.SUCCESS;
    }

    // user login
    public void loginProcess() throws Exception
    {
        // get params data
        String  email = Tools.get("email"),
                password = Tools.get("password");

        // check login
        User user = User.checkLogin(email, password);

        // if user login set session
        if( user != null ) {
            SessionLib.set("user_id", user.getId() );
            SessionLib.set("isLogin", "true" );
            // redirect to profile page
            Tools.redirect("dashboard");
        } else {
            // redirect with error
            Tools.redirect("login?invalid=true");
        }
    }

    // logout process
    public void logoutProcess() throws Exception
    {
        // if user login then unset session
        if( SessionLib.isLogin() ) {
            SessionLib.unset("user_id");
            SessionLib.unset("isLogin");
        }

        // redirect user to login page
        Tools.redirect("login?logout=true");
    }

    // view profile
    public String viewProfile() throws Exception
    {
        // get current user
        int user_id = SessionLib.getUserID();
        User user = User.find( user_id );

        // add the user in data out
        this.dataOut.clear();
        this.dataOut.add( user );

        // return success
        return this.SUCCESS;
    }

    // save profile
    public void saveProfile() throws Exception
    {
        // get the request parameters
        String  email = Tools.get("email"),
                password = Tools.get("password"),
                firstName = Tools.get("firstName"),
                lastName = Tools.get("lastName"),
                address = Tools.get("address"),
                district = Tools.get("district");

        String  strDateOfBirth = Tools.get("dateOfBirth"),
                strGender = Tools.get("gender"),
                strType = Tools.get("type"),
                strAllowMessage = Tools.get("allowMessage"),
                strStatus = Tools.get("status");

        int     dateOfBirth = Tools.getTimeStamp( strDateOfBirth ),
                gender = Integer.parseInt( strGender ),
                type = ( strType != null ) ? Integer.parseInt( strType ) : -1,
                allowMessage = Integer.parseInt( strAllowMessage ),
                status = ( strStatus != null ) ? Integer.parseInt( strStatus ) : -1;

        // get user
        int user_id = SessionLib.getUserID();
        User user = User.find( user_id );

        // check email
        if( ! user.getEmail().equals( email ) ) { user.setEmail( email ); }

        // check password
        if( ! password.isEmpty() ) { user.setPassword( password ); }

        // check firstname
        if( ! user.getFirstName().equals( firstName ) ) { user.setFirstName( firstName ); }

        // check lastname
        if( ! user.getLastName().equals( lastName ) ) { user.setLastName( lastName ); }

        // check address
        if( ! user.getAddress().equals( address ) ) { user.setAddress( address ); }

        // check district
        if( ! user.getDistrict().equals( district ) ) { user.setDistrict( district ); }

        // check date of birth
        if( user.getDateOfBirth() != dateOfBirth ) { user.setDateOfBirth( dateOfBirth ); }

        // check gender
        if( user.getGender() != gender ) { user.setGender( gender ); }

        // check type
        if( type >= 0 && user.getType() != type ) { user.setType( type ); }

        // check allow message
        if( user.getAllowMessage() != allowMessage ) { user.setAllowMessage( allowMessage ); }

        // check status
        if( status >= 0 && user.getStatus() != status ) { user.setStatus( status ); }

        // save user
        user.save();

        // redirect to profile page with success message
        Tools.redirect("profile?update=true");
    }

    public String forgetPassword() throws SQLException,ParseException
    {
        User nuser = User.getUser(); //get user id
        Date date = new Date();
        int timeStamp = (int) (date.getTime() / 1000); //generate key value
        //nuser.setKey(Integer.toString(timeStamp));  //set key value
        nuser.save();
        Emailer.sendEmail(timeStamp); //send email to user
        return this.SUCCESS;
    }

    public String findUser() throws Exception
    {
        User nuser = User.getUserId(); //get user id
        SessionLib.set("id", nuser.getId()); // saved id in the session
        return this.SUCCESS;
    }

    public String setPassword() throws Exception
    {
        int id = SessionLib.getUserID();
        User nuser = User.find( id );
        nuser.setPassword(ServletActionContext.getRequest().getParameter("password")); // reset password
        //nuser.setKey("1"); //reset key value
        nuser.save();
        return this.SUCCESS;
    }

    public String noReset() throws SQLException
    {
        User nuser = User.getUserId();
        //nuser.setKey("1"); //reset generated key
        nuser.save();
        return this.SUCCESS;
    }

    /// getter for data out
    public Vector<User> getDataOut() {
        return this.dataOut;
    }

    /// setter for data out
    public void setDataOut(Vector<User> users) {
        this.dataOut = users;
    }
}

