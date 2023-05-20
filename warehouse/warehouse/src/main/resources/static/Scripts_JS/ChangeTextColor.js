const btn = document.getElementById('qwe')

btn.addEventListener('click', function master(){
    var master = document.getElementsByClassName("display-4 fw-normal");
    master[0].setAttribute("style", " color: red; font: bold;");
})