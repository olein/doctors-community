package com.jonak.lib;

// import defaults
import com.opensymphony.xwork2.ActionContext;
import org.apache.struts2.ServletActionContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by lenin on 11/19/14.
 */
public class Tools {

    public static HttpServletRequest request = ServletActionContext.getRequest();
    public static HttpServletResponse response = ServletActionContext.getResponse();

    // get the request parameter
    public static String get(String name) throws Exception
    {
        HttpServletRequest request = ServletActionContext.getRequest();
        if( request.getParameterMap().containsKey( name ) ) {
            return request.getParameter(name);
        } else {
            return null;
        }
    }

    // redirects to a location
    public static void redirect( String url ) throws Exception
    {
        HttpServletResponse response = ServletActionContext.getResponse();

        try {
            response.sendRedirect(url);
        } catch (Exception ex) {
            throw new RuntimeException("error redirecting: "+ex.getMessage());
        }
    }

    // get current action name
    public static String getCurrentPage() throws Exception
    {
        String actionName = ActionContext.getContext().getName();
        return actionName;
    }

    // get current date in time stamp
    public static int getTimeStamp() throws Exception
    {
        Date currentDate = new Date();
        int timeStamp = (int) (currentDate.getTime() / 1000);

        return timeStamp;
    }

    // get time stamp from string date
    public static int getTimeStamp( String strDate ) throws Exception
    {
        DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        Date theDate = (Date)formatter.parse( strDate );
        int timeStamp = (int) ( theDate.getTime() / 1000 );

        return timeStamp;
    }

    // get time stamp from string date
    public static int getTimeStamp( String strDate, String format ) throws Exception
    {
        DateFormat formatter = new SimpleDateFormat( format );
        Date theDate = (Date)formatter.parse( strDate );
        int timeStamp = (int) ( theDate.getTime() / 1000 );

        return timeStamp;
    }

    // get date
    public static Date getDate( ) throws Exception
    {
        Date currentDate = new Date();

        return currentDate;
    }


    // get date
    public static Date getDate( int timeStamp ) throws Exception
    {
        Date currentDate = new Date( (long) timeStamp * 1000 );

        return currentDate;
    }
}
