<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link rel="stylesheet" href="web/style/main.css">
    <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <title>Lab 2</title>
</head>
<body>
<header>
    <br>
    Танковский К.О. и Мастюкина М.В. Лабораторная по веб-программированию №2 Вариант: 2639
</header>
<table>
    <tr>
        <td width="60%">
            <form method="post" class="form" id="form">
                <div>
                    <p>X value</p>
                    <input type="text" value="" autocomplete="off" placeholder="Enter X value"
                           class="text_input x_value" name="x_value">
                    <br>
                    <p>R value</p>
                    <input type="text" value="" autocomplete="off" placeholder="Enter R coordinate"
                           class="text_input r_value" name="r_value" required>
                    <br>
                    <p>Y value</p>
                    <table border="1">
                        <tr>
                            <td>
                                <input type="radio" checked="checked" name="y_value"
                                       value="-5"> -5 </input>
                            </td>
                            <td>
                                <input type="radio" value="-4" name="y_value"> -4 </input>
                            </td>
                            <td>
                                <input type="radio" value="-3" name="y_value">-3</input>
                            </td>
                        </tr>
                        <br>
                        <tr>
                            <td>
                                <input type="radio" value="-2" name="y_value">-2</input>
                            </td>
                            <td>
                                <input type="radio" value="-1" name="y_value">-1</input>
                            </td>
                            <td>
                                <input type="radio" value="0" name="y_value">0</input>
                            </td>
                        </tr>
                        <br>
                        <tr>
                            <td>
                                <input type="radio" value="1" name="y_value">1</input>
                            </td>
                            <td>
                                <input type="radio" value="2" name="y_value">2</input>
                            </td>
                            <td>
                                <input type="radio" value="3" name="y_value">3</input>
                            </td>
                        </tr>
                    </table>
                    <button type="submit" id="submit_button">Submit</button>
                    <button type="button" id="reset_button">Reset</button>
                </div>
            </form>
        </td>
        <td align="center">
            <svg height="300" width="300" xmlns="http://www.w3.org/2000/svg" class="coordinate_axes">
                <line stroke="white" x1="0" x2="300" y1="150" y2="150"></line>
                <line stroke="white" x1="150" x2="150" y1="0" y2="300"></line>
                <polygon fill="white" points="150,0 144,15 156,15" stroke="white"></polygon>
                <polygon fill="white" points="300,150 285,156 285,144" stroke="white"></polygon>

                <line stroke="white" x1="200" x2="200" y1="155" y2="145"></line>
                <line stroke="white" x1="250" x2="250" y1="155" y2="145"></line>

                <line stroke="white" x1="50" x2="50" y1="155" y2="145"></line>
                <line stroke="white" x1="100" x2="100" y1="155" y2="145"></line>

                <line stroke="white" x1="145" x2="155" y1="100" y2="100"></line>
                <line stroke="white" x1="145" x2="155" y1="50" y2="50"></line>

                <line stroke="white" x1="145" x2="155" y1="200" y2="200"></line>
                <line stroke="white" x1="145" x2="155" y1="250" y2="250"></line>

                <text fill="white" x="195" y="140">R/2</text>
                <text fill="white" x="252" y="140">R</text>

                <text fill="white" x="40" y="140">-R</text>
                <text fill="white" x="90" y="140">-R/2</text>

                <text fill="white" x="160" y="105">R/2</text>
                <text fill="white" x="288" y="140">X</text>
                <text fill="white" x="160" y="45">R</text>

                <text fill="white" x="160" y="205">-R/2</text>
                <text fill="white" x="160" y="265">-R</text>

                <text fill="white" x="160" y="10">Y</text>

                <polygon fill="black" fill-opacity="0.3" points="150,100 150,150 100,150" stroke="black"></polygon>

                <polygon fill="black" fill-opacity="0.3" points="150,150 200,150 200,50 150,50"
                         stroke="black"></polygon>
                <path d="M 100 150 A 50 50, 90, 0, 0, 150 200 L 150 150 Z" fill="black" fill-opacity="0.3"
                      stroke="black"></path>

            </svg>
        </td>
    </tr>
    <tr>
        <td colspan="2" id="result_table">
            <table width="70%" id="result">
                <tr>
                    <th width="10%">X</th>
                    <th width="10%">Y</th>
                    <th width="10%">R</th>
                    <th width="16.7%">Current Time</th>
                    <th width="16.7%">Execution Time</th>
                    <th width="16.7%">Hit Result</th>
                </tr>
            </table>
        </td>
    </tr>
</table>
<div>
    <div>
        <span class="error_window">&times;</span>
        <p>Вы ввели некорректные данные</p>
    </div>
</div>
<footer>
    <br>
    Университет ИТМО, 2020
    <br>
    г. Санкт-Петербург
    <br>
    <a href="https://github.com/lastnightinparis/web_2/tree/Kir/src/main"><img src="web/resources/github_PNG66.png"
                                                                               alt="github"
                                                                               width="100" height="100"></a>
</footer>
<script src="web/js/main.js"></script>
</body>
</html>