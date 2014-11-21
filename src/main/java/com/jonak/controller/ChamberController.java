package com.jonak.controller;

import com.jonak.lib.MySQLDatabase;
import com.jonak.lib.SessionLib;
import com.jonak.lib.Tools;
import com.jonak.model.Chamber;
import com.jonak.model.ChamberModel;
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
import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;

import com.opensymphony.xwork2.ActionContext;
import org.apache.struts2.ServletActionContext;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Fahim on 10/11/2014.
 */
public class ChamberController extends BaseController
{
    public ChamberController()
    {
        super();
    }

    public Vector<Chamber> dataOut = new Vector<Chamber>();

    //add new user
    public String addNewChamber() throws Exception
    {
        Chamber chamber = new Chamber();
        //chamber.setUser_id( SessionLib.getUserID() );
        chamber.setUser_id( 1 );
        chamber.setAddress(ServletActionContext.getRequest().getParameter("address"));
        chamber.setTelephone(ServletActionContext.getRequest().getParameter("telephone"));
        chamber.setVisiting_hour(ServletActionContext.getRequest().getParameter("visiting_hour"));
        chamber.setVisiting_days(ServletActionContext.getRequest().getParameter("visiting_days"));
        chamber.setFees(ServletActionContext.getRequest().getParameter("fees"));

        //add chamber
        chamber.save();
        return this.SUCCESS;
    }


    public String viewAllChambers() throws Exception
    {
        // get all chamber
        // add them in vector

        return this.SUCCESS;
    }

    public String viewChamber() throws Exception
    {
        //get result using user id
        //dataOut = Chamber.findByUserID(SessionLib.getUserID());

        dataOut = Chamber.findByUserID(1);

        return this.SUCCESS;
    }

    //update chamber details
    public String updateUserChamber() throws Exception
    {
        //find chamber by id
        Chamber chamber = Chamber.findByID(1);
        if(ServletActionContext.getRequest().getParameter("address").length()>0) {
            chamber.setAddress(ServletActionContext.getRequest().getParameter("address")); // reset title
        }

        if(ServletActionContext.getRequest().getParameter("telephone").length()>0) {
            chamber.setTelephone(ServletActionContext.getRequest().getParameter("telephone"));  //reset description
        }

        if(ServletActionContext.getRequest().getParameter("visiting_hour").length()>0) {
            chamber.setVisiting_hour(ServletActionContext.getRequest().getParameter("visiting_hour")); //reset description
        }

        if(ServletActionContext.getRequest().getParameter("visiting_days").length()>0) {
            chamber.setVisiting_days(ServletActionContext.getRequest().getParameter("visiting_days")); //reset description
        }

        if(ServletActionContext.getRequest().getParameter("fees").length()>0) {
            chamber.setFees(ServletActionContext.getRequest().getParameter("fees")); //reset description
        }
        //update chamber
        chamber.save();
        Tools.redirect("show_user_chamber");
        return this.SUCCESS;
    }
    //delete chamber
    public String delete() throws SQLException
    {
        Chamber chamber = new Chamber();
        //delete chamber
        chamber.delete();
        return this.SUCCESS;
    }
    public void setdataOut(Vector<Chamber> dataOut) {
        this.dataOut = dataOut;
    }
    public Vector<Chamber> getdataOut() {
        return dataOut;
    }
}
