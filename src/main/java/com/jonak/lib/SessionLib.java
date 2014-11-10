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
    public static void set(String key, String value)
    {

        session.put(key, value);
    }
    //set session int type value
    public static void set(String key, int value)
    {

        session.put(key, Integer.toString(value));
    }
    // checked for login
    public static boolean isLogin()
    {
        String result = (String) session.get("login");
        if(result.equals("true"))
        {
            return true;
        }
        else{
            return false;
        }
    }
    //get user id
    public static int getId()
    {
        String result = (String) session.get("id");
        return Integer.parseInt(result);
    }

    public static int get(String value)
    {
        String result = (String) session.get(value);
        return Integer.parseInt(result);
    }
}
