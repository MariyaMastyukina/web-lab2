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
<header>
    <br>
    Танковский К.О. и Мастюкина М. В. Лабораторная по веб-программированию №2 Вариант: 2639
</header>
<table>
    <tr>
        <td>
            <table width="70%" id="result">
                <tr>
                    <th width="10%">X</th>
                    <th width="10%">Y</th>
                    <th width="10%">R</th>
                    <th width="16.7%">Current Time</th>
                    <th width="16.7%">Execution Time</th>
                    <th width="16.7%">Hit Result</th>
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
                <button type="button" id="back_button" onclick="window.location.href='index.jsp'">На главную страницу
                </button>
            </form>
        </td>
    </tr>
</table>
</body>
</html>