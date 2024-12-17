<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Currency Converter</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
          integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <style>
        .result {
            margin-top: 20px;
            font-size: 1.5rem;
            font-weight: bold;
            color: green;
        }
    </style>
</head>
<body>
<div class="container">
    <h1 class="mt-5">Currency Converter (USD to VND)</h1>
    <form class="form-inline mt-4" action="convert" method="post">
        <div class="form-group mx-sm-3 mb-2">
            <label for="usd" class="sr-only">Amount in USD</label>
            <input type="number" class="form-control" id="usd" name="usd" placeholder="Enter USD" required />
        </div>
        <button type="submit" class="btn btn-primary mb-2">Convert</button>
    </form>

    <c:if test="${not empty vnd}">
        <div class="result">
            <p>${usd} USD = ${vnd} VND</p>
        </div>
    </c:if>
</div>
</body>
</html>
