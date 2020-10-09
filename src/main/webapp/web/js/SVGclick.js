document.getElementById("svg").addEventListener('click', function (e) {
    console.log("click");
    let svg = document.getElementById("svg");
    let HTMLPoint = svg.createSVGPoint();
    HTMLPoint.x = e.clientX;
    HTMLPoint.y = e.clientY;
    let SVGPoint = HTMLPoint.matrixTransform(svg.getScreenCTM().inverse());
    let cx = SVGPoint.x;
    let cy = SVGPoint.y;
    let r_value = $('.r_value').val();
    let regExp = new RegExp("^(-?(?:(?:\\d+|\\d*\\.\\d+)(?:[e][+|-]?\\d+)?))+");
    console.log(checkY(((150 - cy) * r_value / 100).toFixed()) + " y check");
    if (regExp.test(r_value) && checkR(r_value)) {
        document.getElementById("point").setAttribute("cx", String(cx));
        document.getElementById("point").setAttribute("cy", String(cy));
        document.getElementById("point").setAttribute("r", "3");
        let x_value = (cx - 150) * r_value / 100;
        let y_value = ((150 - cy) * r_value / 100).toFixed();
        let form_data = "y_value=" + encodeURIComponent(y_value) + "&x_value=" + encodeURIComponent(x_value) + "&r_value=" + encodeURIComponent(r_value);
        send(form_data);
    } else {
        showModalWindow("Действие невозможно! Введите валидное значение для R");
    }
});