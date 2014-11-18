<%@ include file="./template/_header.jsp" %>

<h1>Struts 2 Hello World Example</h1>
<s:form action="Welcome">
    <s:textfield name="username" label="Username"/>
    <s:password name="password" label="Password"/>
    <s:submit/>
</s:form>

<%@ include file="./template/_footer.jsp" %>