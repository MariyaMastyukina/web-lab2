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
<table id="main_table" width="100%" height="100%">
    <tr class="header" width="100%">
        <td colspan="2">
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
        <td width="60%" id="text_block">
            <form method="post" class="form" id="form">
                <div>
                    <p class="values">X value</p>
                    <input type="text" value="" autocomplete="off" placeholder="Enter X value (-3..5)"
                           class="text_input x_value" name="x_value" id="X">
                    <p class="values">Y value</p>
                    <table border="1" id="radio_buttons">
                        <tr>
                            <td class="radio">
                                <input type="radio" checked="checked" name="y_value"
                                       value="-5" id="radio1" class="radio_input"> <label for="radio1"
                                                                                          class="radio_label">-5</label> </input>
                            </td>
                            <td class="radio">
                                <input type="radio" value="-4" name="y_value" class="radio_input" id="radio2"> <label
                                    for="radio2" class="radio_label">-4</label> </input>
                            </td>
                            <td class="radio">
                                <input type="radio" value="-3" name="y_value" class="radio_input" id="radio3"> <label
                                    for="radio3" class="radio_label">-3</label></input>
                            </td>
                        </tr>
                        <tr>
                            <td class="radio">
                                <input type="radio" value="-2" name="y_value" class="radio_input" id="radio4"><label
                                    for="radio4" class="radio_label">-2</label></input>
                            </td>
                            <td class="radio">
                                <input type="radio" value="-1" name="y_value" class="radio_input" id="radio5"><label
                                    for="radio5" class="radio_label">-1</label></input>
                            </td>
                            <td class="radio">
                                <input type="radio" value="0" name="y_value" class="radio_input" id="radio6"><label
                                    for="radio6" class="radio_label">0</label></input>
                            </td>
                        </tr>
                        <tr>
                            <td class="radio">
                                <input type="radio" value="1" name="y_value" class="radio_input" id="radio7"><label
                                    for="radio7" class="radio_label">1</label></input>
                            </td>
                            <td class="radio">
                                <input type="radio" value="2" name="y_value" class="radio_input" id="radio8"><label
                                    for="radio8" class="radio_label">2</label></input>
                            </td>
                            <td class="radio">
                                <input type="radio" value="3" name="y_value" class="radio_input" id="radio9"><label
                                    for="radio9" class="radio_label">3</label></input>
                            </td>
                        </tr>
                    </table>
                    <p class="values">R value</p>
                    <input type="text" value="" autocomplete="off" placeholder="Enter R coordinate (2..5)"
                           class="text_input r_value" name="r_value" required id="R">
                    <div id="buttons">
                        <button type="submit" id="submit_button">Submit</button>
                        <button type="button" id="reset_button">Reset</button>
                    </div>
                </div>
            </form>
        </td>
        <td align="center">
            <svg height="300" width="300" xmlns="http://www.w3.org/2000/svg" class="coordinate_axes" id="svg">
                <line stroke="black" x1="0" x2="300" y1="150" y2="150"></line>
                <line stroke="black" x1="150" x2="150" y1="0" y2="300"></line>
                <polygon fill="black" points="150,0 144,15 156,15" stroke="black"></polygon>
                <polygon fill="black" points="300,150 285,156 285,144" stroke="black"></polygon>

                <line stroke="black" x1="200" x2="200" y1="155" y2="145"></line>
                <line stroke="black" x1="250" x2="250" y1="155" y2="145"></line>

                <line stroke="black" x1="50" x2="50" y1="155" y2="145"></line>
                <line stroke="black" x1="100" x2="100" y1="155" y2="145"></line>

                <line stroke="black" x1="145" x2="155" y1="100" y2="100"></line>
                <line stroke="black" x1="145" x2="155" y1="50" y2="50"></line>

                <line stroke="black" x1="145" x2="155" y1="200" y2="200"></line>
                <line stroke="black" x1="145" x2="155" y1="250" y2="250"></line>

                <text fill="black" x="195" y="140">R/2</text>
                <text fill="black" x="252" y="140">R</text>

                <text fill="black" x="40" y="140">-R</text>
                <text fill="black" x="90" y="140">-R/2</text>

                <text fill="black" x="160" y="105">R/2</text>
                <text fill="black" x="288" y="140">X</text>
                <text fill="black" x="160" y="45">R</text>

                <text fill="black" x="160" y="205">-R/2</text>
                <text fill="black" x="160" y="265">-R</text>

                <text fill="black" x="160" y="10">Y</text>

                <polygon fill="#808000" fill-opacity="0.3" points="150,100 150,150 100,150" stroke="#808000"></polygon>

                <polygon fill="#808000" fill-opacity="0.3" points="150,150 200,150 200,50 150,50"
                         stroke="#808000"></polygon>
                <path d="M 100 150 A 50 50, 90, 0, 0, 150 200 L 150 150 Z" fill="#808000" fill-opacity="0.3"
                      stroke="#808000"></path>
                <circle fill="black" fill-opacity="0.3" stroke="black" cx="150" cy="150" r="0" id="point"></circle>
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
    <tr class="footer" width="100%">
        <td colspan="2">
            <br>
            Университет ИТМО, 2020
            <br>
            г. Санкт-Петербург
            <br>
            <a href="https://github.com/lastnightinparis/web_2/tree/Kir/src/main"><img
                    src="web/resources/github_PNG66.png"
                    alt="github"
                    width="100" height="100"></a>
        </td>
    </tr>
</table>
<div id="myModal" class="modal">
    <div class="modal-content">
        <span class="close">&times;</span>
        <p id="span_text">Вы ввели некорректные данные</p>
    </div>
</div>

<script src="web/js/main.js"></script>
<script src="web/js/SVGclick.js"></script>
</body>
</html>