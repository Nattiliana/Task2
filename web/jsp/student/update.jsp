<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Update</title>
    <link href="css/styles.css" media="screen" rel="stylesheet">
    <script type="text/javascript">
        function validate_form ( )
        {
            var pass1 = document.UpdateForm.password.value;
            var pass2 = document.UpdateForm.confirmpassword.value;

            if (pass1 != pass2){
                alert("Passwords are not equal!");
                return false;
            }
            return( true );
        }
    </script>
</head>
<body>
<h2>Welcome, ${user.name} ${user.surname}</h2>
<form name="UpdateForm" method="POST" action="controller" onsubmit="return validate_form ( );">
    <br/>
    <input type="hidden" name="command" value="update"/>
    Enter new values: <br/>
    <input type="hidden" name="login" value="${user.login}" class="input"/><br/>
    <input type="email" name="login" value="${user.login}" class="input" disabled/><br/>
    <input type="text" name="name" value="${user.name}" class="input" placeholder="Name" required="required"/> <br/>
    <input type="text" name="surname" value="${user.surname}" class="input" placeholder="Surname" required="required"/>
    <%--<input type="password" name="password_new" value="" class="input" placeholder="New Password" required="required"/> <br/>--%>
    <br/>
    Enter password and confirm it to continue: <br/>
    <input type="password" name="password" value="" class="input" placeholder="Password" required="required"/> <br/>
    <input type="password" name="confirmpassword" value="" class="input" placeholder="Confirm password" required="required"/> <br/>
    <br/>
    ${registrationMessage}
    ${errorLoginOrPassword}
    ${errorDatabase}
    <br/>
    <input type="submit" class="button" value="Update my account"/> <br/>
    Already update an account? <a href="controller?command=go_back_to_student">Go back.</a>
</form>
</body>
</html>

