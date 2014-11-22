package com.jonak.controller;

// import default
import java.util.Map;
import java.util.Vector;

/**
 * Created by lenin on 11/5/14.
 */
public class BaseController {
    protected String SUCCESS;
    protected String ERROR;

    public Vector dataOut = new Vector();

    public BaseController()
    {
        // set messages
        this.SUCCESS = "success";
        this.ERROR = "error";
    }

    public Vector getDataOut() {
        return dataOut;
    }

    public void setDataOut(Vector dataOut) {
        this.dataOut = dataOut;
    }
}
