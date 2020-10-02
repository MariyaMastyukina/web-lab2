<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <link rel="stylesheet" href="web/style/main.css">
    <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <title>First JSP</title>
</head>
<body>
<h1> Hello world</h1>
<% java.util.Date now = new java.util.Date();
    String s = "Текущая дата: " + now;
%>
<%= s%>
<script src="js/main.js"></script>
</body>
</html>