document.getElementById("svg").addEventListener('click',function (e){
    var svg =document.getElementById("svg");
    var HTMLPoint = svg.createSVGPoint();
    HTMLPoint.x = e.clientX;
    HTMLPoint.y = e.clientY;
    var SVGPoint = HTMLPoint.matrixTransform(svg.getScreenCTM().inverse());
    var cx=SVGPoint.x;
    var cy=SVGPoint.y;
    var r_value=$('.r_value').val();
    var regExp = new RegExp("^(-?(?:(?:\\d+|\\d*\\.\\d+)(?:[e][+|-]?\\d+)?))+");
    if (regExp.test(r_value)&&r_value>2&&r_value<5){
        document.getElementById("point").setAttribute("cx",String(cx));
        document.getElementById("point").setAttribute("cy",String(cy));
        document.getElementById("point").setAttribute("r","3");
        var x_value=(cx-150)*r_value/100;
        var y_value=((150-cy)*r_value/100).toFixed();
        let form_data = "y_value=" + encodeURIComponent(y_value)+"&x_value=" + encodeURIComponent(x_value)+"&r_value=" + encodeURIComponent(r_value);
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
    }
    else{
        alert("Действие невозможно! Введите валидное значение для R");
    }
});