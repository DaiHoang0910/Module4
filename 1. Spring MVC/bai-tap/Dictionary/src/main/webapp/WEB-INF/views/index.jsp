<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>English-Vietnamese Dictionary</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
          integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <style>
        .result {
            margin-top: 20px;
            font-size: 1.2rem;
            color: green;
        }

        .not-found {
            margin-top: 20px;
            font-size: 1.2rem;
            color: red;
        }
    </style>
</head>
<body>
<div class="container mt-5">
    <h1>English-Vietnamese Dictionary</h1>
    <form method="post" action="/search" class="mt-4">
        <div class="form-group">
            <label for="keyword">Enter a word in English:</label>
            <input type="text" class="form-control" id="keyword" name="keyword" required>
        </div>
        <button type="submit" class="btn btn-primary">Search</button>
    </form>
    
    <c:if test="${not empty word}">
        <div class="result">
            <h2>Result:</h2>
            <p><b>${key}</b> means <b>${word}</b> in Vietnamese.</p>
        </div>
    </c:if>

    <c:if test="${word == 'Not found'}">
        <div class="not-found">
            <h2>Word not found!</h2>
            <p>The word "<b>${key}</b>" is not available in the dictionary.</p>
        </div>
    </c:if>
</div>
</body>
</html>
