<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>file upload</title>
</head>
<body>
<h2>file upload</h2>
<form action="user/upload" method="post" enctype="multipart/form-data" id="uploadForm">
    <label>Upload your file
        <%--<input  type="text" name="txtIn" id="txtIn" />--%>
        <input type="file" name="uploadFile" id="uploadFile" />
    </label>
    <input type="submit" value="Upload"/>
</form>

<script type="text/javascript" src="assets/vendor/jquery/dist/jquery.js"></script>
<script type="text/javascript">
    /*$(document).ready(function(){

        $("form#uploadForm").submit(function(e){
            e.preventDefault();
            console.log( "upload form submitted" );
            var ajaxURL = $(this).attr("action");
            $.ajax({
                type: 'POST',
                url: ajaxURL,
                data: { uploadFile: $("#uploadFile").val(), txtIn: $("#txtIn").val() },
                success: function(data){
//                $('.panel-body').text(data);
                    console.log("hey lenin");
                    console.log(data);

                }
            });
            console.log( "ajax complete" );
            return false;
        });
    });*/
</script>

</body>
</html>
