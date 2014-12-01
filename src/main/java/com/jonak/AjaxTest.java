package com.jonak;

import java.io.IOException;

import com.jonak.lib.Tools;
import org.apache.struts2.ServletActionContext;


import org.json.simple.JSONObject;

import javax.servlet.http.HttpServletResponse;

import com.opensymphony.xwork2.ActionSupport;

public class AjaxTest extends ActionSupport {

    private String name = null;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String loadData() throws Exception
    {
        int i=0;

        if(i > 0) {
            HttpServletResponse response = ServletActionContext.getResponse();

            JSONObject obj = new JSONObject();

            obj.put("1", "Georgia");
            obj.put("2", "Utah");
            obj.put("3", "Texas");
            obj.put("4", "New Jersey");

            response.setHeader("content-type", "application/json");
            String jsonText = obj.toString();
            response.getWriter().write(jsonText);
            response.flushBuffer();
            return "success";
        }else {
            return "success";
        }
    }

}

