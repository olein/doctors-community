<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Ajax Example in Struts 1e</title>
    <script src="assets/vendor/jquery/dist/jquery.min.js"></script>
    <script type="text/javascript">

//		$("form#testForm").submit(
			function fn() {

				$.ajax({
					type: "POST",
					url: "ajaxtest",
					data: {name: $("#name").val()},
					success: function(response){
						console.log(response);
					},
					error: function(e){
						alert('Error: ' + e);
					}
				});
			}

//		);
    </script>
</head>
<body>

<%--<form method="post" action="ajaxtest" id="testForm">--%>
	<input name="name" id="name" value="" type="text">
	<input type="button" value="Send" onclick="fn()">
<%--</form>--%>

<div id="response">

</div>

</body>
</html>