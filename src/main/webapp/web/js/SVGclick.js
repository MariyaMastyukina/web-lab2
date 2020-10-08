document.getElementById("svg").addEventListener('click', function (e) {
    console.log("click");
    var svg = document.getElementById("svg");
    var HTMLPoint = svg.createSVGPoint();
    HTMLPoint.x = e.clientX;
    HTMLPoint.y = e.clientY;
    var SVGPoint = HTMLPoint.matrixTransform(svg.getScreenCTM().inverse());
    var cx = SVGPoint.x;
    var cy = SVGPoint.y;
    var r_value = $('.r_value').val();
    var regExp = new RegExp("^(-?(?:(?:\\d+|\\d*\\.\\d+)(?:[e][+|-]?\\d+)?))+");
    console.log(checkY(((150 - cy) * r_value / 100).toFixed()) + " y check");
    if (checkX(((cx - 150) * r_value / 100)) && checkY(((150 - cy) * r_value / 100).toFixed()) && regExp.test(r_value) && checkR(r_value)) {
        document.getElementById("point").setAttribute("cx", String(cx));
        document.getElementById("point").setAttribute("cy", String(cy));
        document.getElementById("point").setAttribute("r", "3");
        let x_value = (cx - 150) * r_value / 100;
        let y_value = ((150 - cy) * r_value / 100).toFixed();
        let form_data = "y_value=" + encodeURIComponent(y_value) + "&x_value=" + encodeURIComponent(x_value) + "&r_value=" + encodeURIComponent(r_value);
        send(form_data);
    } else {
        alert("Действие невозможно! Введите валидное значение для R");
    }
});