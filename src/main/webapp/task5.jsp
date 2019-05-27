<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: beszteri
  Date: 2019.05.24.
  Time: 15:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="task5" method="post">
    <input type="text" name="product_name" value="product name">
    <input type="submit" value="filter">
</form>
<table>
    <thread>
        <tr>
            <th>company_name</th>
            <th>product_name</th>
            <th>unit_price</th>
        </tr>
    </thread>
    <tbody>
    <c:forEach var = "t5q" items="${task5Result}">
        <tr>
            <td><c:out value="${t5q.company_name}"></c:out></td>
            <td><c:out value="${t5q.product_name}"></c:out></td>
            <td><c:out value="${t5q.unit_price}"></c:out></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>