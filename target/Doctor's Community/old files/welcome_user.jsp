<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<html>
<head></head>
<body>
<h1>Struts 2 Hello World Example</h1>

    Welcome to Profile, <s:property value="sessionValue.id"/><br/>

    <a href="<s:url action="add_profile" />" >Add profile</a>
    <a href="<s:url action="show_experience" />" >Show profile</a>
    <a href="<s:url action="add_education" />" >Add Education</a>
    <a href="<s:url action="show_education" />" >Show education</a>
    <a href="<s:url action="add_chamber" />" >Add Chamber</a>
    <a href="<s:url action="show_chamber" />" >Show Chamber Detail</a>
</body>
</html>