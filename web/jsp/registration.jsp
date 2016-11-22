<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Registration</title>
    <link href="css/styles.css" media="screen" rel="stylesheet">
    <script type="text/javascript">

        function validate_form ( )
        {
            var email = document.RegistrationForm.login.value;
            var atpos = email.indexOf("@");
            var dotpos = email.lastIndexOf(".");

            var pass1 = document.RegistrationForm.password.value;
            var pass2 = document.RegistrationForm.confirmpassword.value;

            if (atpos < 1 || ( dotpos - atpos < 2 ))
            {

                alert("Please enter correct email");
                document.RegistrationForm.login.focus() ;
                return false;
            }
            if (pass1 != pass2){
                alert("Passwords are not equal!");
                return false;
            }
            return( true );
        }

    </script>

</head>
<body>

<form name="RegistrationForm" method="POST" action="controller" onsubmit="return validate_form ( );">
    <br/>
    <input type="hidden" name="command" value="registration"/>
    Join <br/>
    <input type="email" name="login" value="" class="input" placeholder="E-mail" required="required"/><br/>
    <input type="password" name="password" value="" class="input" placeholder="Password" required="required"/> <br/>
    <input type="password" name="confirmpassword" value="" class="input" placeholder="Confirm password" required="required"/> <br/>
    <input type="text" name="name" value="" class="input" placeholder="Name" required="required"/> <br/>
    <input type="text" name="surname" value="" class="input" placeholder="Surname" required="required"/>
    <br/>
    ${registrationMessage}
    ${errorUserExsists}
    <br/>
    <input type="submit" class="button" value="Create my account"/> <br/>
    Already have an account? <a href="controller?command=return">Log in.</a>
</form>



</body>
</html>
