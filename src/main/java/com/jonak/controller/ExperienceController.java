package com.jonak.controller;

import com.jonak.lib.MySQLDatabase;
import com.jonak.lib.SessionLib;
import com.jonak.lib.Tools;
import com.jonak.model.Experience;
import com.jonak.model.ExperienceModel;
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
 * Created by Fahim on 09/11/2014.
 */
public class ExperienceController extends BaseController
{
    //public Vector<Experience> dataOut = new Vector<Experience>();

    public ExperienceController(){ super(); }

    public void saveExperience() throws Exception
    {
        Experience exp = new Experience();
        exp.setUserId(SessionLib.getUserID());

        String  title = Tools.get("title"),
                description = Tools.get("description");

        if(SessionLib.get("id")!=null) {
            System.out.println("id new:"+SessionLib.get("id"));
            exp = Experience.findExperienceByID(Integer.parseInt(SessionLib.get("id")));

            if (!exp.getTitle().equals(title)) { exp.setTitle(title);  }
            if (!exp.getDescription().equals(description)) { exp.setDescription(description);  }
            SessionLib.unset("id");
        }
        else {
            exp.setTitle(title);
            exp.setDescription(description);
        }

        exp.save(); //add experience
        Tools.redirect("experience");
    }

    public String viewAllExperience() throws Exception
    {
        // this is how we will be using
        // get the user with id
        dataOut.clear();
        dataOut = Experience.findByUserID(SessionLib.getUserID());
        return this.SUCCESS;
    }

    public String viewExperience() throws Exception
    {
        // this is how we will be using
        // get the experience with id
        int id = Integer.parseInt(Tools.get("id"));
        Experience exp = Experience.findExperienceByID( id );
        dataOut.add(exp);
        SessionLib.set("id",id);
        System.out.println(id);
        return this.SUCCESS;
    }

    public void deleteExperience() throws Exception
    {
        Experience exp = Experience.findExperienceByID(Tools.toInt(Tools.get("id")));
        exp.delete();
        SessionLib.unset("id");
        Tools.redirect("experience");
    }

    public Vector<Experience> getDataOut() {
        return dataOut;
    }


}
