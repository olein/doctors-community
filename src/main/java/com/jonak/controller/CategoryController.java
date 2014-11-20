package com.jonak.controller;

import com.jonak.lib.MySQLDatabase;
import com.jonak.lib.SessionLib;
import com.jonak.lib.Tools;
import com.jonak.model.Category;
import com.jonak.model.CategoryModel;
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
import java.util.Date;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;

import com.jonak.model.Speciality;
import com.opensymphony.xwork2.ActionContext;
import org.apache.struts2.ServletActionContext;
import java.text.SimpleDateFormat;
import java.util.*;
/**
 * Created by Fahim on 11/11/2014.
 */
public class CategoryController extends BaseController
{
    public Vector<Category> dataOut = new Vector<Category>();
    public Vector<Speciality> specialities = new Vector<Speciality>();

    //get category list
    public String setCategory() throws Exception
    {

        dataOut = Category.findAllCategory();

        return this.SUCCESS;
    }

    //add new category
    public String addCategory() throws Exception
    {
        Category category = new Category();

        category.setName(ServletActionContext.getRequest().getParameter("name"));
        category.setDetail(ServletActionContext.getRequest().getParameter("detail"));
        category.setParent_id(Integer.parseInt(ServletActionContext.getRequest().getParameter("parent_id")));
        int timestamp = Tools.getTimeStamp();
        category.setCreated_at(timestamp);
        category.save(); //add category
        return this.SUCCESS;
    }

    //view all category
    public String viewAllCategory() throws Exception
    {
        // this is how we will be using
        // get the user with id 1

        dataOut = Category.findAllCategory(); //get result using user id

        return this.SUCCESS;
    }

    //update category
    public String updateCategory() throws Exception
    {
        Category category = Category.findByID( 1 );

            if (ServletActionContext.getRequest().getParameter("parent_id").length() > 0) {
                category.setParent_id(Integer.parseInt(ServletActionContext.getRequest().getParameter("parent_id"))); // reset title
            }
            else{
                category.setParent_id(category.getParent_id());
            }

            if (ServletActionContext.getRequest().getParameter("namenew").length() > 0) {
                category.setName(ServletActionContext.getRequest().getParameter("namenew"));  //reset description
            }
            else{
                category.setName(category.getName());
            }

            if (ServletActionContext.getRequest().getParameter("detail").length() > 0) {
                category.setDetail(ServletActionContext.getRequest().getParameter("detail")); //reset description
            }
            else{
                category.setDetail(category.getDetail());
            }
            category.setCreated_at(category.getCreated_at());
            category.setId(category.getId());
            category.save();
            Tools.redirect("show_category");
            return this.SUCCESS;
    }
    //delete category
    public String deleteCategory() throws Exception
    {
        Category category = new Category();
        category.delete(); //delete
        //redirect to view
        Tools.redirect("show_category");
        return this.SUCCESS;
    }

    public String addSpeciality() throws Exception, ParseException
    {
        String data[] = ServletActionContext.getRequest().getParameterValues("speciality[]");
        for(int i=0;i<data.length;i++) {
            Speciality speciality = new Speciality();
            speciality.setUser_id(SessionLib.getUserID());
            speciality.setCategory_id(Integer.parseInt(data[i]));
            speciality.save(); //add speciality
        }
        return this.SUCCESS;
    }

    public String viewSpeciality() throws Exception
    {
        // this is how we will be using
        // get the user with id 1
        SessionLib.set("ContentID",0);
        ResultSet rs = Speciality.find(SessionLib.getUserID()); //get result using user id

        if( rs != null ) {

            while( rs.next() ) {
                Speciality speciality = new Speciality();
                speciality.setId(rs.getInt(1));
                speciality.setUser_id(rs.getInt(3));
                speciality.setCategory_id(rs.getInt(2));
               // speciality.setCategory_name(Category.find(speciality.getCategory_id()));
                speciality.setDelete("delete_speciality?id="+ rs.getInt(1)); //set delete link
                specialities.add(speciality); //add result to vector
            }
        }
        return this.SUCCESS;
    }

    public String deleteSpeciality() throws Exception
    {
        Speciality speciality = new Speciality();
        speciality.delete(); //delete
        return this.SUCCESS;
    }

    public CategoryController()
    {
        super();
    }

    public Vector<Category> getDataOut() {
        return dataOut;
    }

    public void setDataOut(Vector<Category> dataOut) {
        this.dataOut = dataOut;
    }


    public Vector<Speciality> getSpecialities() {
        return specialities;
    }

    public void setSpecialities(Vector<Speciality> specialities) {
        this.specialities = specialities;
    }
}
