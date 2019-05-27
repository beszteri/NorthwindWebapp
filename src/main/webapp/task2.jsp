<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: beszteri
  Date: 2019.05.24.
  Time: 14:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="task2" method="post">
    <input type="number" name="numberOfProducts">
    <input type="submit" value="filter">
</form>
<table>
    <thead>
        <tr>
            <th>Company</th>
            <th>NumberOfProducts</th>
        </tr>
    </thead>
    <tbody>
    <c:forEach var = "t2q" items="${task2Result}">
        <tr>
            <td><c:out value="${t2q.company}"></c:out> </td>
            <td><c:out value="${t2q.numberOfProducts}"></c:out></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
