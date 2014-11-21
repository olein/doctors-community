package com.jonak.controller;

// import custom
import com.jonak.lib.Emailer;
import com.jonak.lib.Hash;
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
        timestamp = (int) (new Date().getTime()/1000);
        nuser.setCreatedAt(timestamp);
        nuser.setToken("");

        nuser.save();

        return this.SUCCESS;
    }

    // user login
    public void processLogin() throws Exception
    {
        // get params data
        String  email = Tools.get("email"),
                password = Tools.get("password");

        // check login
        User user = User.checkLogin(email, password);

        // if user login set session
        if( user != null ) {
            SessionLib.set("user_id", Integer.toString( user.getId() ) );
            SessionLib.set("isLogin", "true" );
            // redirect to profile page
            Tools.redirect("dashboard");
        } else {
            // redirect with error
            Tools.redirect("login?invalid=true");
        }
    }

    // logout process
    public void processLogout() throws Exception
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
        User user = User.findById(user_id);

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
                gender = Integer.parseInt(strGender),
                type = ( strType != null ) ? Integer.parseInt( strType ) : -1,
                allowMessage = (strAllowMessage!= null && strAllowMessage.equals("allow")) ? 1 : 0,
                status = ( strStatus != null ) ? Integer.parseInt( strStatus ) : -1;

        // get user
        int user_id = SessionLib.getUserID();
        User user = User.findById(user_id);

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
        if( user.getDateOfBirth(true) != dateOfBirth ) { user.setDateOfBirth( dateOfBirth ); }

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

    // process forget password
    public void processForgetPassword() throws Exception
    {
        // get params
        String email = Tools.get("email");
        // get user
        User user = User.findByEmail(email);
//        User user = User.find(1);

        // valid email
        if( user != null) {
            // generate token
            int timeStamp = Tools.getTimeStamp();
            String token = Hash.md5( Integer.toString( timeStamp ) ).substring(0, 7);

            // set token
            user.setToken( token );
            user.save();

            // make mail tempalte
            String msg = "<p>Hello <b>"+user.getFirstName()+" "+user.getLastName()+"</b><p>";
            msg += "<p>Someone requested to change your password. Please click the following link to reset your password<p>";
            msg += "<div><a href=\"http://localhost:7005/DoctorCommunity/user/reset-password?token="+user.getToken()+"&email="+user.getEmail()+"\">Reset Password</a></div>";
            msg += "<p>If this wasn't you <a href=\"http://localhost:7005/DoctorCommunity/user/cancel-reset?token="+user.getToken()+"&email="+user.getEmail()+"\">Click Here</a> to cancel reset request.</p>";
            msg += "<hr>";
            msg += "<p>Regards<br><b>Doctor's Community Team</b></p>";

            // send token to user
            Emailer mail = new Emailer();
            mail.setTo( user.getEmail() );
            mail.setSubject( "No-Reply! Password Reset Request." );
            mail.setBody( msg );
            mail.send();

            Tools.redirect("forget-password?confirm=true");
        } else { // invalid email
            Tools.redirect("forget-password?confirm=false");
        }

    }

    // check reset token & email
    public String resetPassword() throws Exception
    {
        // get params
        String  token = Tools.get("token"),
                email = Tools.get("email");

        // verify token
        User user = User.findByEmail( email );

        if( user != null && user.getToken().equals( token ) ) {
            return this.SUCCESS;
        } else {
            // invalid request
            return  this.ERROR;
        }
    }

    // process reset password
    public void processResetPassword() throws Exception
    {
        // get params
        String  token = Tools.get("token"),
                email = Tools.get("email"),
                password = Tools.get("password"),
                confpassword = Tools.get("confpassword");

        // check password vs confpassword
        if( password.equals( confpassword ) && ! token.isEmpty() && ! email.isEmpty() ) {
            // get user
            User user = User.findByEmail( email );

            // again varify token
            if( user != null && user.getToken().equals( token ) ) {
                // reset the password
                user.setPassword( password );
                // remove token
                user.setToken("");
                // save
                user.save();

                // redirect to confirm page
                Tools.redirect("confirm-reset?confirm=true");
            } else {
                // redirect to invalid page
                Tools.redirect("reset-password?confirm=false");
            }
        } else {
            // redirect to error page
            Tools.redirect("confirm-reset?confirm=false");
        }
    }

    public String processCancelReset() throws Exception
    {
        // get params
        String token = Tools.get("token"),
                email = Tools.get("email");

        // get user
        User user = User.findByEmail(email);

        // verify token
        if( user != null && user.getToken().equals(token) ) {
            // remove token
            user.setToken("");
            user.save();

            return this.SUCCESS;
        } else {
            // invalid token
            return this.ERROR;
        }
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

