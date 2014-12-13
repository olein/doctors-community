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
    public CategoryController()
    {
        super();
    }

    public Vector<Category> dataOut = new Vector<Category>();
    public Vector<Category> categoryList = new Vector<Category>();
    public Vector<Speciality> specialities = new Vector<Speciality>();

    // view all medical fields
    public String viewMedicalFields() throws Exception
    {
        Vector mFields = Category.findCategory();
        this.dataOut = mFields;
        return this.SUCCESS;
    }

    // save medical field
    public void saveMedicalField() throws Exception
    {
        // get params
        String  strId = Tools.get("id"),
                strName = Tools.get("name"),
                strParentId = Tools.get("parentId"),
                strDetail = Tools.get("detail");

        int     intId = Tools.toInt(strId),
                intParentId = Tools.toInt(strParentId);

        Category category;

        // new or update??
        if( intId > 0 ) {
            category = Category.findById( intId );
        } else {
            category = new Category();
        }

        // save
        category.setName( strName );
        category.setParentId(intParentId);
        category.setDetail(strDetail);
        if( intId <= 0 ) {
            category.setCreatedAt(Tools.getTimeStamp());
        }
        category.save();

        // redirect
        if( intId > 0 ) {
            Tools.redirect("medical-fields?update=true");
        } else {
            Tools.redirect("medical-fields?addnew=true");
        }
    }

    // delete medical field
    public void deleteMedicalField() throws Exception
    {
        // get params
        String strId = Tools.get("id");
        int intId = Tools.toInt(strId);

        // get fields & delete it
        if( intId > 0 ) {
            Category cat = Category.findById( intId );
            cat.delete();

            // redirect
            Tools.redirect("medical-fields?delete=true");
        } else {
            // redirect
            Tools.redirect("medical-fields");
        }
    }

    public String setCategory() throws Exception
    {
        SessionLib.set("id",0);
        categoryList = Category.findCategory(); //get category list
        return this.SUCCESS;
    }

    public void saveCategory() throws Exception, ParseException
    {
        Category category = new Category();

        String  name = Tools.get("name"),
                detail = Tools.get("detail");
        int     parentId = Integer.parseInt(Tools.get("parentId"));

        if(Integer.parseInt(SessionLib.get("id"))>0) {
//            category = Category.findCategoryByID(Integer.parseInt(SessionLib.get("id")));

            if (!category.getName().equals(name)) {  category.setName(name); }
            if( ! category.getDetail().equals(detail) ) { category.setDetail(detail); }
            if(  category.getParentId()!=( parentId ) ) { category.setParentId(parentId); }
//            category.setCreatedAt(category.getCreatedAt());
            SessionLib.unset("id");
        }
        else{
            category.setName( name );
            category.setDetail( detail );
            category.setParentId( parentId );
            category.setCreatedAt( Tools.getTimeStamp());
        }

        category.save(); //add category
        Tools.redirect("category");
    }

    public String viewAllCategory() throws Exception
    {
        // this is how we will be using
        // get the user with id
        this.dataOut.clear();
        SessionLib.set("id",0);
        dataOut = Category.findCategory();
        return this.SUCCESS;
    }

    public String viewCategory() throws Exception
    {
        // this is how we will be using
        // get the user with id 1
        dataOut.clear();
        int id = Integer.parseInt(Tools.get("id"));
//        Category category = Category.findCategoryByID(id);
//        dataOut.add(category);
        categoryList = Category.findCategory();
        SessionLib.set("id",id);
        return this.SUCCESS;
    }

    public void deleteCategory() throws Exception
    {
        Category category = new Category();
        category.delete(); //delete
        SessionLib.unset("id");
        Tools.redirect("category");
    }

    public void saveSpeciality() throws Exception, ParseException
    {
        String data[] = ServletActionContext.getRequest().getParameterValues("speciality[]");
        for(int i=0;i<data.length;i++) {
            Speciality speciality = new Speciality();
            speciality.setUserId(SessionLib.getUserID());
            speciality.setCategoryId(Integer.parseInt(data[i]));
            speciality.save(); //add speciality
        }
        Tools.redirect("interest-area");
    }

    public String viewSpeciality() throws Exception
    {
        // this is how we will be using
        // get the user with id 1
        specialities = Speciality.findSpeciality(SessionLib.getUserID()); //get result using user id
        return this.SUCCESS;
    }

    public void deleteSpeciality() throws Exception
    {
        Speciality speciality = new Speciality();
        speciality.delete(); //delete
        Tools.redirect("interest-area");
    }
    public Vector<Category> getDataOut() {
        return dataOut;
    }


    public Vector<Speciality> getSpecialities() {
        return specialities;
    }

    public void setSpecialities(Vector<Speciality> specialities) {
        this.specialities = specialities;
    }
}
