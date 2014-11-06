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
    Map session = ActionContext.getContext().getSession();

    public void setString(String key, String value)
    {

        session.put(key, value);
    }

    public void setInt(String key, int value)
    {

        session.put(key, Integer.toString(value));
    }

    public String isLogin()
    {
        String result = (String) session.get("login");
        return result;
    }
    public int getId()
    {
        String result = (String) session.get("id");
        return Integer.parseInt(result);
    }
}
