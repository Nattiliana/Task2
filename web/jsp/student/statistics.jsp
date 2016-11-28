<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Statistics</title>
    <link href="css/styles.css" media="screen" rel="stylesheet">
</head>
<body>
<h2>Welcome, ${user.name} ${user.surname}</h2>
        <h3>Amount of right answers: ${answers}</h3>
<a href="controller?command=go_back_to_student">Go back</a><br/>
<a href="controller?command=logout">Logout</a><br/>
</body>
</html>
