<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: beszteri
  Date: 2019.05.24.
  Time: 15:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="task3" method="post">
    <input type="text" name="company" value="company name">
    <input type="submit" value="filter">
</form>
<table>
    <thead>
        <tr>
            <th>Company</th>
        </tr>
    </thead>
    <tbody>
    <c:forEach var = "t3q" items="${task3Result}">
        <tr>
            <td><c:out value="${t3q.company}"></c:out> </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
