<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Create Quiz</title>
    <link href="css/styles.css" media="screen" rel="stylesheet">
    <script type="text/javascript">
        function validate_form() {
            if (document.CreateForm.quizName == null) {
                alert('You must enter quiz name.');
                return false;
            }
        }
    </script>
</head>
<body>
<form name="CreateForm" method="POST" action="controller" onsubmit="return validate_form ( );">
    <input type="hidden" name="command" value="create_quiz"/>
    Choose subject: <br/>
    <%--<select>
        <c:forEach var="subject" items="${subjectList}">
            <option value="${subject.subjectName}">${subject.subjectName}</option>
        </c:forEach>
    </select>--%>
    <table align="center" border="1">
        <tr bgcolor="#9841C4">
            <td align="center"><strong>Subject</strong></td>
        </tr>
        <c:forEach var="sub" items="${subjectList}">
            <tr>
                <td><c:out value="${sub.subjectName}"/></td>
                <td><input type="radio" name="subject" value="${sub.id}"/><br></td>
            </tr>
        </c:forEach>
    </table>
    <br/>
    Enter quiz name: <br/>
    <input type="text" name="quizName" value="" class="input" placeholder="Quiz 1" required="required"/> <br/>
    <br/>
    Choose questions:
    <table align="center" border="1">
        <tr bgcolor="#9841C4">
            <td align="center"><strong>ID</strong></td>
            <td align="center"><strong>Question number</strong></td>
            <td align="center"><strong>Question</strong></td>
            <td align="center"><strong>Quiz ID</strong></td>
        </tr>
        <c:forEach var="q" items="${questionList}">
            <tr>
                    <td><c:out value="${q.id}"/></td>
                <td><c:out value="${q.questionNumber}"/></td>
                <td><c:out value="${q.question}"/></td>
                <td><c:out value="${q.quizId}"/></td>
                <td><input type="radio" name="question" value="${q.id}"/><br></td>
            </tr>
        </c:forEach>
    </table>
    ${registrationMessage}
    ${errorUserExsists}
    ${errorDatabase}
    <br/>
    <input type="submit" class="button" value="Create quiz"/> <br/>
    <a href="controller?command=go_back_to_tutor">Go back</a><br/>
    <a href="controller?command=logout">Logout</a><br/>
</form>
</body>
</html>


