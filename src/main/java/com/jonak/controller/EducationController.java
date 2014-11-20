package com.jonak.controller;

import java.sql.SQLException;
import java.util.Vector;

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
    public String addEducation() throws Exception
    {
        Education education = new Education();
        //education.setUser_id( SessionLib.getUserID() );
        education.setUser_id( 1 );
        education.setDegree(ServletActionContext.getRequest().getParameter("degree"));
        education.setInstitute(ServletActionContext.getRequest().getParameter("institute"));
        education.setResult(ServletActionContext.getRequest().getParameter("result"));
        //save education
        education.save();
        return this.SUCCESS;
    }
    //view education by user id
    public String viewEducation() throws Exception
    {
        // this is how we will be using
        // get the user with id 1
        this.dateOut.clear();
        dateOut = Education.findByUserID(1);
        return this.SUCCESS;
    }
    //update education
    public String updateEducation() throws Exception
    {
        //find by using content id
        Education education = Education.findByID( 1 );
        if(ServletActionContext.getRequest().getParameter("degree").length()>0) {
            education.setDegree(ServletActionContext.getRequest().getParameter("degree")); // reset title
        }

        if(ServletActionContext.getRequest().getParameter("institute").length()>0) {
            education.setInstitute(ServletActionContext.getRequest().getParameter("institute"));  //reset description
        }

        if(ServletActionContext.getRequest().getParameter("result").length()>0) {
            education.setResult(ServletActionContext.getRequest().getParameter("result")); //reset description
        }
        education.save();
        Tools.redirect("show_user_education");
        return this.SUCCESS;
    }
    //delete education
    public String deleteEducation() throws Exception
    {
        Education education = new Education();
        //delete
        education.delete();
        Tools.redirect("show_user_education");
        return this.SUCCESS;
    }
    public Vector<Education> getDateOut() {
        return dateOut;
    }

    public void setDateOut(Vector<Education> dateOut) {
        this.dateOut = dateOut;
    }
}
