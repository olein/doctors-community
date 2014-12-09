package com.jonak.lib;

import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;
import com.opensymphony.xwork2.ActionContext;

import javax.servlet.http.HttpSession;

/**
 * Created by Fahim on 06/11/2014.
 */
public class SessionLib
{
//    static Map session = ActionContext.getContext().getSession();
    static HttpSession session = ServletActionContext.getRequest().getSession(true);

    //set session string type value
    public static void set( String key, String value ) throws Exception
    {
        try{
            session.setAttribute( key, value );
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }

    //set session int type value
    public static void set( String key, int value ) throws Exception
    {
        try {
            String valueNew = Integer.toString(value);
            session.setAttribute( key, valueNew );
        } catch (Exception ex) {
            throw new RuntimeException("error setting session: "+ ex.getMessage());
        }
    }

    //set session int type value
    public static void unset( String key)
    {
        session.removeAttribute(key);
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
        if( session.getAttribute( key ) != null )
            return (String) session.getAttribute( key );
        else
            return null;
    }

    // get user id
    public static int getUserID() throws Exception
    {
        String result = (String) SessionLib.get( "user_id" );
        if( result == null)
            return 0;
        return Integer.parseInt( result );
    }
}
