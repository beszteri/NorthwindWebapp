<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: beszteri
  Date: 2019.05.24.
  Time: 15:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="task4" method="post">
    <input type="text" name="company" value="company name">
    <input type="submit" value="filter">
</form>
<table>
    <thead>
    <tr>
        <th>Company</th>
        <th>order_id</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var = "t4q" items="${task4Result}">
        <tr>
            <td><c:out value="${t4q.company}"></c:out> </td>
            <td><c:out value="${t4q.order:id}"></c:out> </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
