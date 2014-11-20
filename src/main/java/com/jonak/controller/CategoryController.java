package com.jonak.controller;

import com.jonak.lib.MySQLDatabase;
import com.jonak.lib.SessionLib;
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
    public CategoryController()
    {
        super();
    }

    public Vector<Category> messages = new Vector<Category>();
    public Vector<Speciality> specialities = new Vector<Speciality>();

    public String setCategory() throws Exception
    {

        SessionLib.set("ContentID",0);
        ResultSet rs = Category.find(); //get category list

        if( rs != null ) {

            while( rs.next() ) {
                Category category = new Category();
                category.setId(rs.getInt(1));
                category.setName(rs.getString(2)); //set parent category values
                messages.add(category); //add result to vector
            }
        }
        return this.SUCCESS;
    }

    public String add() throws SQLException, ParseException
    {
        Category category = new Category();

        category.setName(ServletActionContext.getRequest().getParameter("name"));
        category.setDetail(ServletActionContext.getRequest().getParameter("detail"));
        category.setParent_id(Integer.parseInt(ServletActionContext.getRequest().getParameter("parent_id")));
        int timestamp = (int) (new Date().getTime()/1000);
        category.setCreated_at(timestamp);
        category.save(); //add category
        return this.SUCCESS;
    }

    public String viewCategory() throws Exception
    {
        // this is how we will be using
        // get the user with id 1
        SessionLib.set("ContentID",0);
        ResultSet rs = Category.find(); //get result using user id

        if( rs != null ) {

            while( rs.next() ) {
                Category category = new Category();
                category.setId(rs.getInt(1));
                category.setName(rs.getString(2));
                category.setDetail(rs.getString(3));
                category.setParent_id(rs.getInt(4));
                category.setCategory_name(Category.find(rs.getInt(4)));
                category.setCreated_at(rs.getInt(5));
                int d = (rs.getInt(5));
                Date date = new Date(((long)d)*1000L);
                category.setDate(date);
                category.setUpdate("update_category?id=" + rs.getInt(1)); //set update link
                category.setDelete("delete_category?id="+ rs.getInt(1)); //set delete link
                messages.add(category); //add result to vector
            }
        }
        return this.SUCCESS;
    }

    public String setContentID() throws Exception
    {
        setCategory();
        SessionLib.set("ContentID", ServletActionContext.getRequest().getParameter("id")); //set content ID
        return this.SUCCESS;
    }

    public String update() throws Exception
    {
        ResultSet rs = Category.find();
        Category category = new Category();
        if(rs.next()) {
            if (ServletActionContext.getRequest().getParameter("parent_id").length() > 0) {
                category.setParent_id(Integer.parseInt(ServletActionContext.getRequest().getParameter("parent_id"))); // reset title
            }
            else{
                category.setParent_id(rs.getInt(4));
            }

            if (ServletActionContext.getRequest().getParameter("namenew").length() > 0) {
                category.setName(ServletActionContext.getRequest().getParameter("namenew"));  //reset description
            }
            else{
                category.setName(rs.getString(2));
            }

            if (ServletActionContext.getRequest().getParameter("detail").length() > 0) {
                category.setDetail(ServletActionContext.getRequest().getParameter("detail")); //reset description
            }
            else{
                category.setDetail(rs.getString(3));
            }
            category.setCreated_at(rs.getInt(5));
            category.setId(rs.getInt(1));
        }

        //category.update(Integer.parseInt(SessionLib.get("ContentID"))); //update content using content ID
        return this.SUCCESS;
    }

    public String delete() throws Exception
    {
        Category category = new Category();
        category.delete(); //delete
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
                speciality.setCategory_name(Category.find(speciality.getCategory_id()));
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

    public Vector<Category> getMessages() {
        return messages;
    }

    public void setMessages(Vector<Category> messages) {
        this.messages = messages;
    }

    public Vector<Speciality> getSpecialities() {
        return specialities;
    }

    public void setSpecialities(Vector<Speciality> specialities) {
        this.specialities = specialities;
    }
}
