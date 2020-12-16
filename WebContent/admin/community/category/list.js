window.addEventListener("load", function(){
    console.log("dddddd");
    var main = document.querySelector(".main");
    var addBtn = main.querySelector(".addBtn");

    addBtn.onclick = function(){
        console.log("click");
    }
});