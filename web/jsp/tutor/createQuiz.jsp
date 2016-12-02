<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Create Quiz</title>
    <link href="css/styles.css" media="screen" rel="stylesheet">
    <script type="text/javascript">
        function validate_form() {
            if (document.CreateForm.name == null) {
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
    <table align="center" border="1">
        <tr bgcolor="#9841C4">
            <td align="center"><strong>Subject</strong></td>
            <td align="center"><strong>Subject ID</strong></td>
        </tr>
        <c:forEach var="sub" items="${subjectList}">
            <tr>
                <td><c:out value="${sub.subjectName}"/></td>
                <td><c:out value="${sub.id}"/></td>
                <td><input type="radio" name="subject" value="${sub.id}"/><br></td>
            </tr>
        </c:forEach>
    </table>
    <br/>
    Enter quiz name: <br/>
    <input type="text" name="name" value="" class="input" placeholder="Quiz name" required="required"/> <br/>
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
    ${errorEmptyChoice}
    ${errorEmptyList}
    <br/>
    <input type="submit" class="button" value="Create quiz"/> <br/>
</form>
<a href="controller?command=go_back_to_tutor">Go back</a><br/>
<a href="controller?command=logout">Logout</a><br/>
</body>
</html>


