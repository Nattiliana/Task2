<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<html>

<head><title>Index</title></head>

<body>

<jsp:forward page="/jsp/login.jsp"/>

</body>
</html>

<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<sql:query var="users" dataSource="jdbc/TestDB">
    select email, name, surname from users
</sql:query>

<html>
<head>
    <title>DB Test</title>
</head>
<body>

<h2>Results</h2>

<table border="1">
    <!-- column headers -->
    <tr>
        <c:forEach var="columnName" items="${users.columnNames}">
            <th><c:out value="${columnName}"/></th>
        </c:forEach>
    </tr>
    <!-- column data -->
    <c:forEach var="row" items="${users.rowsByIndex}">
        <tr>
            <c:forEach var="column" items="${row}">
                <td><c:out value="${column}"/></td>
            </c:forEach>
        </tr>
    </c:forEach>
</table>

</body>
</html>--%>
