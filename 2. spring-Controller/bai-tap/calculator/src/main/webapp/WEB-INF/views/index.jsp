<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Calculator</title>
    <style>
        .error {
            color: red;
            font-weight: bold;
        }
        .result {
            color: green;
            font-weight: bold;
        }
    </style>
</head>
<body>
<h1>Simple Calculator</h1>
<form action="calculate" method="get">
    <label for="number1">Number 1:</label>
    <input type="number" step="any" name="number1" id="number1" value="${number1}" required>
    <br><br>

    <label for="number2">Number 2:</label>
    <input type="number" step="any" name="number2" id="number2" value="${number2}" required>
    <br><br>

    <label for="calculation">Operation:</label>
    <select name="calculation" id="calculation">
        <option value="Addition(+)" ${calculator == 'Addition(+)' ? 'selected' : ''}>Addition (+)</option>
        <option value="Subtraction(-)" ${calculator == 'Subtraction(-)' ? 'selected' : ''}>Subtraction (-)</option>
        <option value="Multiplication(X)" ${calculator == 'Multiplication(X)' ? 'selected' : ''}>Multiplication (X)</option>
        <option value="Division(/)" ${calculator == 'Division(/)' ? 'selected' : ''}>Division (/)</option>
    </select>
    <br><br>

    <button type="submit">Calculate</button>
</form>

<hr>

<c:if test="${not empty error}">
    <div class="error">
        <p>${error}</p>
    </div>
</c:if>

<c:if test="${empty error}">
    <div class="result">
        <p>Result: ${number1} and ${number2} with operation "${calculator}" = ${result}</p>
    </div>
</c:if>
</body>
</html>
