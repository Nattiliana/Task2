<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Welcome</title>
    <link href="css/styles.css" media="screen" rel="stylesheet">
</head>
<body>
<h2>Welcome, ${user.name} ${user.surname} (student)</h2>  <a href="controller?command=update">Update profile</a><br/>
${updateMessage}
<h3>This is quiz system. Choose option:</h3>
<a href="controller?command=show_quiz">Find available quiz</a><br/>
<a href="controller?command=GO_TO_STUDENT_STAT">Get statistics</a><br/>
<a href="controller?command=logout">Logout</a><br/>
</body>
</html>