package com.jonak.lib;

// import defaults
import org.apache.struts2.ServletActionContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by lenin on 11/19/14.
 */
public class Tools {
    // protected ;
    // protected ;
    public static String get(String name)
    {
        HttpServletRequest request = ServletActionContext.getRequest();
        return request.getParameter( name );
    }

    public static void redirect( String url ) throws Exception
    {
        HttpServletResponse response = ServletActionContext.getResponse();
        response.sendRedirect( url );
    }
}
