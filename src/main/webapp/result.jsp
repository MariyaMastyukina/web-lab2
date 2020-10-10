<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html lang="ru">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link rel="stylesheet" href="web/style/main.css">
    <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <title>Lab 2</title>
</head>
<body>
<table>
    <tr class="header" width="100%">
        <td>
            <p>
                Танковский К.О. и Мастюкина М.В.
                <br>
                Лабораторная по веб-программированию №2
                <br>
                Вариант: 2639
            </p>
        </td>
    </tr>
    <tr>
        <td>
            <table width="100%" id="result">
                <tr>
                    <th>X</th>
                    <th>Y</th>
                    <th>R</th>
                    <th>Current Time</th>
                    <th>Execution Time</th>
                    <th>Hit Result</th>
                </tr>
                <c:forEach var="table_row" items="${applicationScope.get(pageContext.session.id)}">
                    ${table_row}
                </c:forEach>

            </table>
        </td>
    </tr>
    <tr>
        <td>
            <form>
                <button type="button" id="back_button" onclick="window.location.href='index.jsp'">Back
                </button>
            </form>
        </td>
    </tr>
</table>
</body>
</html>