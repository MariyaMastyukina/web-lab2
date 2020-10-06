let x_value = $(".x_value");
let r_value = $(".r_value");
let submit_button = $("#submit_button");
let y_group = $('input[name = y_value]');
let reset_button = $("#reset_button");
// let regExpR = new RegExp("^4\.[1-9]*"); need to fix
// let regExpY = new RegExp("^3\.[1-9]*");
// let regExpYNeg = new RegExp("^-5\.[1-9]*");
let regExp = new RegExp("^(-?(?:(?:\\d+|\\d*\\.\\d+)(?:[e][+|-]?\\d+)?))+");
let default_table = $("#result").innerHTML;
submit_button.click((e) => {
    /* if (...) !odz

     else */
    //Checking odz is done
    e.preventDefault();
    if (checkODZ()) {
        let form_data;
        for (let i = 0; i < y_group.length; i++) {
            if (y_group[i].checked) {
                form_data = "y_value=" + encodeURIComponent(y_group[i].value);
            }
        }
        form_data += "&x_value=" + encodeURIComponent(x_value.val());
        form_data += "&r_value=" + encodeURIComponent(r_value.val());
        console.log(form_data);
        $.ajax(({
            type: 'POST',
            url: 'control',
            data: form_data,
            success: function (e) {
                console.log("success");
                console.log(e.toString());
                if (e.toString().includes("<html>") || e.toString().includes("error")) {
                    // say to user that he didnt choose x or r
                } else {
                    document.querySelector("#result").innerHTML = e.toString();
                    saveUpdateTable(e.toString());
                }

            },
            error: function (e) {
                console.log("error");
                //TODO error handler
            }
        }));
    }
});

function checkX() {
    return regExp.test(x_value.val()) && x_value.val() > -3 && x_value.val() < 5;
}

function checkR() {
    return regExp.test(r_value.val())&& r_value.val() > 2 && r_value.val() < 5;
}

function checkODZ() {
    if (!checkX()) alert("Введены некорректные значения для параметра Х");
    if (!checkR()) alert("Введены некорректные значения для параметра R");
    return checkR() && checkX();
}

// maybe you know how to make the reset_button better...
let table_header = '<table width="70%/" id="result"><tr><th width="10%">X</th><th width="10%">Y</th><th width="10%">R</th><th width="16.7%">Current Time</th><th width="16.7%">Execution Time</th><th width="16.7%">Hit Result</th></tr></table>';

function saveUpdateTable(table) {
    localStorage.setItem("current_table", table);
}

reset_button.click(e => {
    e.preventDefault();
    document.getElementById("result").innerHTML = table_header;
    localStorage.removeItem("current_table");
});
if (window.performance) {
    document.getElementById("result").innerHTML = localStorage.getItem("current_table");
}
