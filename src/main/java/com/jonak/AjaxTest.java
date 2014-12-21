package com.jonak;

import java.io.IOException;

import com.jonak.lib.Tools;
import org.apache.struts2.ServletActionContext;


import org.json.simple.JSONObject;

import javax.servlet.http.HttpServletResponse;

import com.opensymphony.xwork2.ActionSupport;

public class AjaxTest extends ActionSupport {

    public void loadData() throws Exception
    {
        String name = Tools.get("name");

        JSONObject obj = new JSONObject();

        obj.put("1", "Georgia");
        obj.put("2", "Utah");
        obj.put("3", "Texas");
        obj.put("4", "New Jersey");
        obj.put("5", name);

//        Tools.response.setHeader("content-type", "application/json");
//        String jsonText = obj.toString();
//        Tools.response.getWriter().write(jsonText);
//        Tools.response.flushBuffer();

        Tools.ajaxResponse( obj );
    }
}

