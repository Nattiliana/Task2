<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Welcome</title>
    <link href="css/styles.css" media="screen" rel="stylesheet">
</head>
<body>
<h2>Welcome, ${user.name} ${user.surname} (admin)</h2>
<h3>This is quiz system. Choose option:</h3>
<a href="controller?command=create_quiz">Create quiz</a><br/>
<a href="controller?command=delete_quiz">Delete quiz</a><br/>
<a href="controller?command=go_to_tutor_stat">Get students statistics</a><br/>
<a href="controller?command=logout">Logout</a><br/>
</body>
</html>
