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
    public void saveChamber() throws Exception
    {
        Chamber chamber = new Chamber();
        chamber.setUserId(SessionLib.getUserID());
        //get parameter values
        String  name = Tools.get("name"),
                address = Tools.get("address"),
                telephone = Tools.get("telephone"),
                visitingHour = Tools.get("visitingHour"),
                visitingDays = Tools.get("visitingDays"),
                fees = Tools.get("fees");

        //chamber id needs to be put in the session
        if(SessionLib.get("id")!=null)
        {
            chamber = Chamber.findChamberByID(Integer.parseInt(SessionLib.get("id")));
            if( ! chamber.getName().equals( name ) ) { chamber.setName(name); }
            if( ! chamber.getAddress().equals( address ) ) { chamber.setAddress(address); }
            if( ! chamber.getTelephone().equals( telephone ) ) { chamber.setTelephone(telephone); }
            if( ! chamber.getVisitingHour().equals( visitingHour ) ) { chamber.setVisitingHour(visitingHour); }
            if( ! chamber.getVisitingDays().equals( visitingDays ) ) { chamber.setVisitingDays(visitingDays); }
            if( ! chamber.getFees().equals( fees ) ) { chamber.setFees( fees ); }
        }
        else{
            chamber.setName(name);
            chamber.setAddress(address);
            chamber.setTelephone(telephone);
            chamber.setVisitingHour(visitingHour);
            chamber.setVisitingDays(visitingDays);
            chamber.setFees( fees );
        }

        //add chamber
        chamber.save();
        Tools.redirect("chambers");
    }


    public String viewAllChambers() throws Exception
    {
        // get all chamber
        // add them in vector
        dataOut.clear();
        dataOut = Chamber.findAllChamber();
        System.out.println(dataOut.size());
        return this.SUCCESS;
    }

    public String viewChamber() throws Exception
    {
        //get result using user id
        //dataOut = Chamber.findByUserID(SessionLib.getUserID());
        Chamber chamber;
        int id = Integer.parseInt(Tools.get("id"));
        chamber = Chamber.findChamberByID(id);
        dataOut.add(chamber);
        SessionLib.set("id",id);
        return this.SUCCESS;
    }


    //fix delete chamber, id needed
    public void deleteChamber() throws Exception
    {
        Chamber chamber = new Chamber();
        //delete chamber
        chamber.delete();
        Tools.redirect("chambers");
    }
    public void setdataOut(Vector<Chamber> dataOut) {
        this.dataOut = dataOut;
    }
    public Vector<Chamber> getdataOut() {
        return dataOut;
    }
}
