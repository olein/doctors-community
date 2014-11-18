package com.jonak.controller;

// import default
import org.apache.struts2.ServletActionContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * Created by lenin on 11/5/14.
 */
public class BaseController {
    protected String SUCCESS;
    protected String ERROR;
    public Map sessionValue;

    protected HttpServletRequest request;
    protected HttpServletResponse response;

    public BaseController()
    {
        // set messages
        this.SUCCESS = "success";
        this.ERROR = "error";

        // set servlet action
        this.request = ServletActionContext.getRequest();
        this.response = ServletActionContext.getResponse();
    }

    public Map getSessionValue() {
        return sessionValue;
    }

    public void setSessionValue(Map sessionValue) {
        this.sessionValue = sessionValue;
    }

}
