package com.jonak.controller;

import com.jonak.lib.SessionLib;
import com.jonak.lib.Tools;
import com.jonak.model.Search;

/**
 * Created by Fahim on 11/12/2014.
 */
public class SearchController extends BaseController
{
    public SearchController()
    {
        super();
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
}
