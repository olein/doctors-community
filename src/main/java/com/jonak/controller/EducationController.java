package com.jonak.controller;

import java.sql.SQLException;
import java.util.Vector;

import com.jonak.lib.SessionLib;
import com.jonak.lib.Tools;
import com.jonak.model.Education;
import org.apache.struts2.ServletActionContext;

/**
 * Created by Fahim on 10/11/2014.
 */
public class EducationController extends BaseController
{
    public Vector<Education> dateOut = new Vector<Education>();
    public EducationController()
    {
        super();
    }

    //add user education
    public void saveEducation() throws Exception
    {
        Education education = new Education();
        education.setUser_id( SessionLib.getUserID() );

        String  degree = Tools.get("degree"),
                institute = Tools.get("institute"),
                result = Tools.get("result");

        if(SessionLib.get("id")!=null)
        {
            education = Education.findEducationByID(Integer.parseInt(SessionLib.get("id")));

            if( ! education.getDegree().equals( degree ) ) { education.setDegree(degree); }
            if( ! education.getInstitute().equals( institute ) ) { education.setInstitute(institute); }
            if( ! education.getResult().equals( result ) ) { education.setResult(result); }
            SessionLib.unset("id");
        }
        else {
            education.setDegree(degree);
            education.setInstitute(institute);
            education.setResult(result);
        }
        //save education
        education.save();
        Tools.redirect("education");
    }
    //view education by user id
    public String viewAllEducation() throws Exception
    {
        // this is how we will be using
        // get the user with id
        this.dateOut.clear();
        dateOut = Education.findByUserID(SessionLib.getUserID());
        return this.SUCCESS;
    }

    public String viewEducation() throws Exception
    {
        // this is how we will be using
        // get the user with id 1
        this.dateOut.clear();
        int id = Integer.parseInt(Tools.get("id"));
        Education education = Education.findEducationByID( id );
        dateOut.add(education);
        SessionLib.set("id",id);
        return this.SUCCESS;
    }


    //delete education
    public void deleteEducation() throws Exception
    {
        Education education = Education.findEducationByID(Tools.toInt(Tools.get("id")));
        //delete
        education.delete();
        SessionLib.unset("id");
        Tools.redirect("education");
    }
    public Vector<Education> getDateOut() {
        return dateOut;
    }

    public void setDateOut(Vector<Education> dateOut) {
        this.dateOut = dateOut;
    }
}
