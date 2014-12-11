package com.jonak.controller;

import com.jonak.lib.Configuration;
import com.jonak.lib.Tools;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by lenin on 12/11/14.
 */
public class SettingsController extends BaseController {

    public void saveSettings() throws Exception
    {
        // get params
        String  siteTitle = Tools.get("siteTitle"),
                siteURL = Tools.get("siteURL"),
                adminEmail = Tools.get("adminEmail"),
                uploadDir = Tools.get("uploadDir");

        // save configs
        Configuration.set( "siteTitle",     siteTitle );
        Configuration.set( "siteURL",       siteURL );
        Configuration.set( "adminEmail",    adminEmail );
        Configuration.set( "uploadDir",     uploadDir );

        // return
        Tools.redirect( "settings?update=true" );
    }
}
