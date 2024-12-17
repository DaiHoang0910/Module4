<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <title>Mail Configuration</title>
</head>
<body>
<h1>Settings</h1>
<c:if test="${not empty message}">
    <p style="color:green;">${message}</p>
</c:if>

<form:form modelAttribute="config" method="post">

    <label>Languages:</label>
    <form:select path="language">
        <form:option value="English" label="English"/>
        <form:option value="Vietnamese" label="Vietnamese"/>
        <form:option value="Japanese" label="Japanese"/>
        <form:option value="Chinese" label="Chinese"/>
    </form:select>
    <br><br>

    <label>Page Size:</label>
    <form:select path="pageSize">
        <form:options items="${{5, 10, 15, 25, 50, 100}}"/>
    </form:select>
    <br><br>

    <label>Spams filter:</label>
    <form:checkbox path="spamFilter"/> Enable spams filter
    <br><br>

    <label>Signature:</label><br>
    <form:textarea path="signature" rows="4" cols="30"/>
    <br><br>

    <input type="submit" value="Update"/>
</form:form>
</body>
</html>
