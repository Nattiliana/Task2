<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Quiz</title>
    <link href="css/styles.css" media="screen" rel="stylesheet">
</head>
<body>
<form name="AnswerForm" method="POST" action="controller">
    <input type="hidden" name="command" value="show_quiz"/>
    <table align="center" border="1">
        <tr bgcolor="#9841C4">
            <td align="center"><strong>Quiz Name</strong></td>
            <td align="center"><strong>Subject ID</strong></td>
        </tr>
        <c:forEach var="quiz" items="${quizList}">
            <tr>
                <td><c:out value="${quiz.quizName}"/></td>
                <td><c:out value="${quiz.subjectId}"/></td>
                <td><input type="radio" name="questionInQuiz" value="${quiz.id}" checked/><br></td>
            </tr>
        </c:forEach>
    </table>
    <br/>
    <input type="submit" class="button" value="Next"/> <br/>
    <a href="controller?command=go_back_to_student">Go back</a><br/>
    <a href="controller?command=logout">Logout</a><br/>
</form>
</body>
</html>
