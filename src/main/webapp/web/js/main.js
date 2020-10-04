let form = $("#form");
let x_value = $(".x_value");
let r_value = $(".r_value");
let submit_button = $("#submit_button");
let y_group = $('input[name = y_value]');
let reset_button = $("#reset_button");
// let regExpR = new RegExp("^4\.[1-9]*"); need to fix
// let regExpY = new RegExp("^3\.[1-9]*");
// let regExpYNeg = new RegExp("^-5\.[1-9]*");
let default_table = $("#result_table");
submit_button.click((e) => {
    /* if (...) !odz

     else */

    e.preventDefault();
    let form_data;
    for (let i = 0; i < y_group.length; i++) {
        if (y_group[i].checked) {
            form_data = "x_value=" + encodeURIComponent(x_value.val()) + "&y_value=" + encodeURIComponent(y_group[i].value)
                + "&r_value=" + encodeURIComponent(r_value.val());
        }
    }
    $.ajax(({
        type: 'POST',
        url: 'control',
        data: form_data,
        success: function (e) {
            console.log("success");
        },
        error: function (e) {
            console.log("error");
        }
    }));
});

