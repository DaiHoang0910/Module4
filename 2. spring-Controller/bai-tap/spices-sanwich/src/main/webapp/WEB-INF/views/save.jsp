<%--
  Created by IntelliJ IDEA.
  User: theon
  Date: 16/12/2024
  Time: 2:56 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Danh sách gia vị bạn đã chọn:</h1>
<ul>
    <c:forEach var="item" items="${condiment}">
        <li>${item}</li>
    </c:forEach>
</ul>
</body>
</html>
