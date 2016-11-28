<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Quiz</title>
    <link href="css/styles.css" media="screen" rel="stylesheet">
    <script type="text/javascript">
        function validate_form() {
            if (!document.AnswerForm.radio.checked) {
                alert('You must choose at least one question.');
                return false;
            }
        }
    </script>
</head>
<body>
<form name="AnswerForm" method="POST" action="controller" onsubmit="return validate_form ( );">
    <input type="hidden" name="command" value="show_quiz_next" />
    <table align="center" border="1">
        <tr bgcolor="#9841C4">
            <td align="center"><strong>ID</strong></td>
            <td align="center"><strong>Number</strong></td>
            <td align="center"><strong>Question</strong></td>
        </tr>
            <c:forEach var="question" items="${questionList}">
            <tr>
                <td><input type="radio" name="qId" value="${question.id}"/><br></td>
                <td><c:out value="${question.questionNumber}"/></td>
                <td><c:out value="${question.question}"/></td>
            </tr>
            <c:forEach var="ans" items="${answerList}">
                <tr>
                    <td><c:out value="${ans.answer}"/></td>
                    <td><input type="radio" name="answer" value="${ans.id}"/><br></td>
                </tr>
            </c:forEach>
        </c:forEach>
    </table>
    ${errorDatabase}
    <br/>
    <input type="submit" class="button" value="Next"/> <br/>
    <a href="controller?command=go_back_to_student">Go back</a><br/>
    <a href="controller?command=logout">Logout</a><br/>
</form>
</body>
</html>
