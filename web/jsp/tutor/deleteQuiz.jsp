<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Delete Quiz</title>
    <link href="css/styles.css" media="screen" rel="stylesheet">
</head>
<body>
<form name="DeleteQuizForm" method="post" action="controller">
    <input type="hidden" name="command" value="delete_quiz" />
    Choose quiz to delete:
    <table align="center" border="1">
        <tr bgcolor="#9841C4">
            <td align="center"><strong>Quiz Name</strong></td>
            <td align="center"><strong>Subject</strong></td>
        </tr>
        <c:forEach var="quiz" items="${quizList}">
            <tr>
                <td><c:out value="${quiz.quizName}"/></td>
                <td><c:out value="${quiz.subjectName}"/></td>
                <td><input type="checkbox" name="toDelete" value="${quiz.id}"/><br></td>
            </tr>
        </c:forEach>
    </table>
    ${errorEmptyChoice}
    ${errorEmptyList}
    <br/>
    <input type="submit" class="button" value="Delete quiz"/> <br/>
    <a href="controller?command=go_back_to_tutor">Go back</a><br/>
    <a href="controller?command=logout">Logout</a><br/>
</form>
</body>
</html>
