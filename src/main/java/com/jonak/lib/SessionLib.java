package com.jonak.lib;

import java.util.Map;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;
import com.opensymphony.xwork2.ActionContext;
/**
 * Created by Fahim on 06/11/2014.
 */
public class SessionLib
{
    static Map session = ActionContext.getContext().getSession();

    //set session string type value
    public static void set( String key, String value ) throws Exception
    {
        try{
            session.put( key, value );
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }

    //set session int type value
    public static void set( String key, int value ) throws Exception
    {
        try {
            session.put( key, Integer.toString( value ) );
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }

    //set session int type value
    public static void unset( String key)
    {
        if( session.containsKey( key ) ) {
            session.remove(key);
        }
    }

    // checked for login
    public static boolean isLogin() throws Exception
    {
        String result = SessionLib.get("isLogin");
        if( result != null && result.equals("true") ) {
            return true;
        } else {
            return false;
        }
    }

    // get session data
    public static String get( String key ) throws Exception
    {
        String result = null;
        if( session.containsKey( key ) ) {
            result =  (String) session.get( key );
        }
        return result;
    }

    // get user id
    public static int getUserID() throws Exception
    {
        String result = "0";
        if( session.containsKey( "user_id" ) ) {
            result =  (String) session.get( "user_id" );
        }
        return Integer.parseInt( result );
    }

    // get current page
    public static String getCurrentPage() throws Exception
    {
        String result = "";
        if( session.containsKey( "current_page" ) ) {
            result =  (String) session.get( "current_page" );
        }
        return result;
    }
}
