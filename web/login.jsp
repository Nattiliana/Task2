<%@ page session="true" language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Login</title>
    <link href="css/styles.css" media="screen" rel="stylesheet">
</head>
<body>

<form name="loginForm" method="POST" action="controller">
    <br/>
    <input type="hidden" name="command" value="login"/>
    Enter login and password: <br/>
    <input type="text" name="login" value="" class="input" placeholder="E-mail" required="required"/> <br/>
    <input type="password" name="password" value="" class="input" placeholder="Password" required="required"/>
    <br/>
    ${errorLoginOrPassword}
    ${errorDatabase}
    ${wrongAction}
    ${nullPage}
    <br/>
    <input type="submit" class="button" value="Let me in!"/> <br/>
    Don‘t have a profile? <a href="controller?command=go_to_registration">Sign up for free</a>
</form>

</body>
</html>