<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: beszteri
  Date: 2019.05.24.
  Time: 14:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="task1" method="post">
    <input type="text" name="company" value="company name">
    <input type="submit" value="filter">
</form>
<table>
    <thread>
        <tr>
            <th>Product</th>
            <th>Company</th>
        </tr>
    </thread>
    <tbody>
    <c:forEach var = "t1q" items="${task1Result}">
        <tr>
            <td><c:out value="${t1q.product}"></c:out> </td>
            <td><c:out value="${t1q.company}"></c:out></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
