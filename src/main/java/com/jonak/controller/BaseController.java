package com.jonak.controller;

import java.util.Map;

/**
 * Created by lenin on 11/5/14.
 */
public class BaseController {
    protected String SUCCESS;
    protected String ERROR;
    public Map sessionValue;

    public BaseController()
    {
        this.SUCCESS = "success";
        this.ERROR = "error";
    }

    public Map getSessionValue() {
        return sessionValue;
    }

    public void setSessionValue(Map sessionValue) {
        this.sessionValue = sessionValue;
    }

}
