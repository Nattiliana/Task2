<%--
  Created by IntelliJ IDEA.
  User: Nataly
  Date: 11.11.2016
  Time: 15:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head><title>Registration</title></head>
<body>
<form name="RegistrationForm" method="POST" action="controller">
    <input type="hidden" name="command" value="registration"/>
    Enter login, password, name, surname: <br/>
    <br/>Login:<br/>
    <input type="text" name="login" value=""/>
    <br/>Password:<br/>
    <input type="password" name="password" value=""/>
    <br/>Name:<br/>
    <input type="text" name="name" value=""/>
    <br/>Surname:<br/>
    <input type="text" name="surname" value=""/>
    <br/>
    ${errorLoginPassMessage}
    <br/>
    ${wrongAction}
    <br/>
    ${nullPage}
    <br/>
    <input type="submit" value="Sign up"/>
    <a href="controller?command=return">Go back to login page</a>
</form>

</body>
</html>
