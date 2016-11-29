<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Delete User</title>
    <link href="css/styles.css" media="screen" rel="stylesheet">
</head>
<body>
<form name="DeleteUserForm" method="post" action="controller">
    <input type="hidden" name="command" value="delete_user" />
    Choose user to delete:
    <table align="center" border="1">
        <tr bgcolor="#9841C4">
            <td align="center"><strong>Username</strong></td>
        </tr>
        <c:forEach var="user" items="${userList}">
            <tr>
                <td><c:out value="${user.login}"/></td>
                <td><input type="radio" name="toDeleteUser" value="${user.login}"/><br></td>
            </tr>
        </c:forEach>
    </table>
    ${errorDatabase}
    ${errorEmptyChoice}
    ${errorEmptyList}
    <br/>
    <input type="submit" class="button" value="Delete user"/> <br/>
    <a href="controller?command=go_back_to_tutor">Go back</a><br/>
    <a href="controller?command=logout">Logout</a><br/>
</form>
</body>
</html>