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

    public String setCategory() throws SQLException
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

    public String viewCategory() throws SQLException
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

    public String setContentID() throws SQLException
    {
        setCategory();
        SessionLib.set("ContentID", ServletActionContext.getRequest().getParameter("id")); //set content ID
        return this.SUCCESS;
    }

    public String update() throws SQLException
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

        category.update(SessionLib.get("ContentID")); //update content using content ID
        return this.SUCCESS;
    }

    public String delete() throws SQLException
    {
        Category category = new Category();
        category.delete(); //delete
        return this.SUCCESS;
    }

    public Vector<Category> getMessages() {
        return messages;
    }

    public void setMessages(Vector<Category> messages) {
        this.messages = messages;
    }
}
