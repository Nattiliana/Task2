<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Statistics</title>
    <link href="css/styles.css" media="screen" rel="stylesheet">
</head>
<body>
<form name="stat" method="POST" action="controller">
<table align="center" border="1">
    <tr bgcolor="#9841C4">
        <td align="center"><strong>Student login</strong></td>
        <td align="center"><strong>Amount of right answers</strong></td>
    </tr>
    <c:forEach var="list" items="${registrationList}">
        <tr>
            <td><c:out value="${list.student}"/></td>
            <td><c:out value="${list.amountOfRightAnswers}"/></td>
        </tr>
    </c:forEach>
</table>
<a href="controller?command=go_back_to_tutor">Go back</a><br/>
<a href="controller?command=logout">Logout</a><br/>
    </form>
</body>
</html>
