<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Quiz</title>
    <link href="css/styles.css" media="screen" rel="stylesheet">
</head>
<body>
<table border="1">
    <tr bgcolor="#CCCCCC">
        <td align="center"><strong>ID</strong></td>
        <td align="center"><strong>Subject</strong></td>
    </tr>
    <c:forEach var="subject" items="${subjectsList}">
        <tr>
            <td><c:out value="${subject.id}" /></td>
            <td><c:out value="${subject.subjectName}" /></td>
        </tr>
    </c:forEach>
</table>
${errorDatabase}
<a href="controller?command=go_back_to_student">Go back</a><br/>
<a href="controller?command=logout">Logout</a><br/>
</body>
</html>
