package com.jonak.controller;

import com.jonak.lib.Configuration;
import com.jonak.lib.SessionLib;
import com.jonak.lib.Tools;
import com.jonak.model.*;

import java.util.Vector;

/**
 * Created by Fahim on 11/12/2014.
 */
public class SearchController extends BaseController
{
    public static Vector<Education> educations = new Vector<Education>();
    public static Vector<Experience> experiences = new Vector<Experience>();
    public static Vector<Chamber> chambers = new Vector<Chamber>();
    public static Vector<Speciality> specialities = new Vector<Speciality>();
    public static Vector<Category> categoryList = new Vector<Category>();
    public static Vector<Content> healthTips = new Vector<Content>();
    private String siteName;

    public SearchController()
    {
        super();
    }

    public String setIndex() throws Exception
    {
        SessionLib.set("id",0);
        categoryList = Category.findCategory();
        siteName = Configuration.get("siteTitle");
        healthTips = Search.getHealthTips();
        return SUCCESS;
    }
    public String SearchByName() throws Exception
    {
        String name = Tools.get("name");
        dataOut = Search.findByName( name );
        return SUCCESS;
    }
    public String SearchByLocation() throws Exception
    {
        String district = Tools.get("district");
        dataOut = Search.findByLocation( district );
        return SUCCESS;
    }
    public String SearchByKeyWord() throws Exception
    {
        String keyWord = Tools.get("key-word");
        dataOut = Search.findByKeyWord(keyWord);
        return SUCCESS;
    }
    public String SearchBySpeciality() throws Exception
    {
        int speciality = Tools.toInt(Tools.get("speciality"));
        dataOut = Search.findBySpeciality(speciality);
        return SUCCESS;
    }
    public String viewProfile() throws Exception
    {
        int id = Tools.toInt(Tools.get("id"));
        User user = User.findById(id);
        dataOut.add(user);
        educations = Education.findByUserID(id);
        chambers = Chamber.findByUserID(id);
        experiences = Experience.findByUserID(id);
        specialities = Speciality.findSpeciality(id);
        return SUCCESS;
    }

    public static Vector<Experience> getExperiences() {
        return experiences;
    }

    public static void setExperiences(Vector<Experience> experiences) {
        SearchController.experiences = experiences;
    }

    public static Vector<Education> getEducations() {
        return educations;
    }

    public static void setEducations(Vector<Education> educations) {
        SearchController.educations = educations;
    }

    public static Vector<Chamber> getChambers() {
        return chambers;
    }

    public static void setChambers(Vector<Chamber> chambers) {
        SearchController.chambers = chambers;
    }

    public static Vector<Speciality> getSpecialities() {
        return specialities;
    }

    public static void setSpecialities(Vector<Speciality> specialities) {
        SearchController.specialities = specialities;
    }

    public static Vector<Category> getCategoryList() {
        return categoryList;
    }

    public static void setCategoryList(Vector<Category> categoryList) {
        SearchController.categoryList = categoryList;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public static Vector<Content> getHealthTips() {
        return healthTips;
    }

    public static void setHealthTips(Vector<Content> healthTips) {
        SearchController.healthTips = healthTips;
    }
}
