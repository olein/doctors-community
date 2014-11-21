<%@ page import="com.jonak.lib.*" %>
<%@ page import="java.util.*" %>
<%
//    Configuration.set("fahim", "fahad");
//    Configuration.set("lenin", "updated");
    out.println(Configuration.get("lenin")+" deleted");
    Configuration.remove("lenin");
%>