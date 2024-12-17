<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: theon
  Date: 16/12/2024
  Time: 2:56 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Chọn gia vị</title>
</head>
<body>
<h1>Vui lòng chọn gia vị</h1>
<c:if test="${not empty errorMessage}">
    <div style="color: red;">
        <b>${errorMessage}</b>
    </div>
</c:if>
<form method="get" action="save">
    <td><input type="checkbox" name="condiment" value="Lettuce">Lettuce</td>
    <td><input type="checkbox" name="condiment" value="Tomato">Tomato</td>
    <td><input type="checkbox" name="condiment" value="Mustard">Mustard</td>
    <td><input type="checkbox" name="condiment" value="Sprouts">Sprouts</td></br>
    <hr>
    <td><input type="submit" value="save"></td>
</form>
</body>
</html>
