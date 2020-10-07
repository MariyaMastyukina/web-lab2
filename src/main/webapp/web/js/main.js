let x_value = $(".x_value");
let r_value = $(".r_value");
let y_value=0;
let submit_button = $("#submit_button");
let y_group = $('input[name = y_value]');
let reset_button = $("#reset_button");
let regExp = new RegExp("^(-?(?:(?:\\d+|\\d*\\.\\d+)(?:[e][+|-]?\\d+)?))+");
let default_table = document.querySelector("#result").innerHTML;
submit_button.click((e) => {
    //Checking odz is done
    e.preventDefault();
    if (checkODZ()) {
        let form_data;
        for (let i = 0; i < y_group.length; i++) {
            if (y_group[i].checked) {
                form_data = "y_value=" + encodeURIComponent(y_group[i].value);
                y_value=y_group[i].value;
            }
        }
        if (x_value.val() !== "") {
            form_data += "&x_value=" + encodeURIComponent(x_value.val());
        }
        if (r_value.val() !== "") {
            form_data += "&r_value=" + encodeURIComponent(r_value.val());
        }
        var cx=x_value.val()/r_value.val()*100+150;
        var cy=150-y_value/r_value.val()*100;
        alert(cx+" "+cy);
        document.getElementById("point").setAttribute("cx",String(cx));
        document.getElementById("point").setAttribute("cy",String(cy));
        document.getElementById("point").setAttribute("r","3");
        console.log(form_data);
        $.ajax(({
            type: 'POST',
            url: 'control',
            data: form_data + "&reset=" + encodeURIComponent(localStorage.getItem("reset_flag")),
            success: function (e) {
                console.log("success");
                console.log(e.toString());
                localStorage.setItem("reset_flag", "false");
                if (e.toString().includes("<html>") || e.toString().includes("error")) {
                    // say to user that he didnt choose x or r
                } else {
                    document.querySelector("#result").innerHTML = e.toString();
                    saveUpdateTable(e.toString());
                }

            },
            error: function (e) {
                console.log("error");
                alert("error");
                //TODO error handler
            }
        }));
    } // else { ??? }
});

function checkX() {
    return regExp.test(x_value.val()) && x_value.val() > -3 && x_value.val() < 5;
}

function checkR() {
    return regExp.test(r_value.val()) && r_value.val() > 2 && r_value.val() < 5;
}

function checkODZ() {
    //the alert needs to be changed to something
    if (!checkX()) alert("Введены некорректные значения для параметра Х");
    if (!checkR()) alert("Введены некорректные значения для параметра R");
    return checkR() && checkX();
}

function saveUpdateTable(table) {
    localStorage.setItem("current_table", table);
}

reset_button.click(e => {
    e.preventDefault();
    document.getElementById("point").setAttribute("r","0");
    document.getElementById("result").innerHTML = default_table;
    localStorage.setItem("current_table", default_table);
    localStorage.setItem("reset_flag", "true");
});
if (window.performance) {
    document.getElementById("result").innerHTML = localStorage.getItem("current_table");
}
