<%@ page import="com.jonak.lib.*" %>
<%@ page import="java.util.*" %>
<%
    int t;
    String s;
    Date d;

    t = Tools.getTimeStamp();
    out.println("get time stamp: " + t);

    t = Tools.getTimeStamp("29/11/2014");
    out.println("get time stamp(str): " + t);

    t = Tools.getTimeStamp("29-11-2014", "dd-MM-yyy");
    out.println("get time stamp(str): " + t);

    s = Tools.getDate();
    out.println("get date: " + s);

    d = new Date();
    s = Tools.getDate(d);
    out.println("get date: " + s);

    s = Tools.getDate(d, "MMM dd yyy");
    out.println("get date: " + s);
%>