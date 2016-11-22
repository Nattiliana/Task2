<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Delete Quiz</title>
    <link href="css/styles.css" media="screen" rel="stylesheet">
</head>
<body>
<form name="DeleteQuizForm" method="post" action="controller">
    <table align="center" border="1">
        <tr bgcolor="#9841C4">
            <td align="center"><strong>If chosen </strong></td>
            <td align="center"><strong>ID</strong></td>
            <td align="center"><strong>Quiz Name</strong></td>
            <td align="center"><strong>Subject ID</strong></td>
        </tr>
        <c:forEach var="q" items="${quizList}">
            <tr>
                <td><input type="radio" name="deleteId" value="${q.id}" checked><BR></td>
                <td><c:out value="${q.id}"/></td>
                <td><c:out value="${q.quizName}"/></td>
                <td><c:out value="${q.subjectId}"/></td>
            </tr>
        </c:forEach>
    </table>
    ${errorDatabase}
    <br/>
    <input type="submit" class="button" value="Delete quiz"/> <br/>
    <a href="controller?command=go_back_to_tutor">Go back</a><br/>
    <a href="controller?command=logout">Logout</a><br/>
</form>
</body>
</html>
