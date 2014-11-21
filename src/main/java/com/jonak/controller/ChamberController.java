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
        chamber.setUserId(1);
        chamber.setAddress(Tools.get("address"));
        chamber.setTelephone(Tools.get("telephone"));
        chamber.setVisitingHour(Tools.get("visitingHour"));
        chamber.setVisitingDays(Tools.get("visitingDays"));
        chamber.setFees(Tools.get("fees"));

        //add chamber
        chamber.save();
        return this.SUCCESS;
    }
    //view user chambers
    public String viewUserChamber() throws Exception
    {
        //get result using user id
        //dataOut = Chamber.findByUserID(SessionLib.getUserID());

        dataOut = Chamber.findByUserID(1);

        return this.SUCCESS;
    }

    //update chamber details
    public void updateUserChamber() throws Exception
    {
        //find chamber by id
        String address = Tools.get("address"),
               telephone = Tools.get("telephone"),
               visitingHour = Tools.get("visitingHour"),
               visitingDays = Tools.get("visitingDays"),
               fees = Tools.get("fees");

        //chamber id needs to be put in the session
        Chamber chamber = Chamber.findByID( 1 );
        //update values
        if( ! chamber.getAddress().equals( address ) ) { chamber.setAddress(address); }
        if( ! chamber.getTelephone().equals( telephone ) ) { chamber.setTelephone(telephone); }
        if( ! chamber.getVisitingHour().equals( visitingHour ) ) { chamber.setVisitingHour(visitingHour); }
        if( ! chamber.getVisitingDays().equals( visitingDays ) ) { chamber.setVisitingDays(visitingDays); }
        if( ! chamber.getFees().equals( fees ) ) { chamber.setFees( fees ); }

        //update chamber
        chamber.save();
        Tools.redirect("show_user_chamber");
    }
    //fix delete chamber, id needed
    public String deleteChamber() throws SQLException
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
