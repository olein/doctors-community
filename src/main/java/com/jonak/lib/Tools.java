package com.jonak.lib;

// import defaults
import org.apache.struts2.ServletActionContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by lenin on 11/19/14.
 */
public class Tools {

    // get the request parameter
    public static String get(String name)
    {
        HttpServletRequest request = ServletActionContext.getRequest();
        return request.getParameter( name );
    }

    // redirects to a location
    public static void redirect( String url ) throws Exception
    {
        HttpServletResponse response = ServletActionContext.getResponse();

        try {
            response.sendRedirect( url );
        } catch (Exception ex) {
            throw new RuntimeException("error redirecting: "+ex.getMessage());
        }
    }
}
