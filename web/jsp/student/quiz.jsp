<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Quiz</title>
    <link href="css/styles.css" media="screen" rel="stylesheet">
    <script type="text/javascript">
        function validate_form() {
            if (!document.AnswerForm.checkbox.checked) {
                alert('You must choose at least one question.');
                return false;
            }
        }
    </script>
</head>
<body>
<form name="AnswerForm" method="POST" action="controller" onsubmit="return validate_form ( );">
    <table align="center" border="1">
        <tr bgcolor="#9841C4">
            <td align="center"><strong>If chosen </strong></td>
            <td align="center"><strong>ID</strong></td>
            <td align="center"><strong>Question</strong></td>
            <td align="center"><strong>Quiz ID</strong></td>
            <td align="center"><strong>Question number</strong></td>
        </tr>
        <c:forEach var="q" items="${questionList}">
            <tr>
                <td><input type="checkbox" name="checkbox"><BR></td>
                <td><c:out value="${q.id}"/></td>
                <td><c:out value="${q.question}"/></td>
                <td><c:out value="${q.quizId}"/></td>
                <td><c:out value="${q.questionNumber}"/></td>
            </tr>
        </c:forEach>
    </table>
    ${errorDatabase}
    <br/>
    <input type="submit" class="button" value="Answer"/> <br/>
    <a href="controller?command=go_back_to_student">Go back</a><br/>
    <a href="controller?command=logout">Logout</a><br/>
</form>
</body>
</html>
