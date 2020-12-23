window.addEventListener("load", function(){
    var main = document.querySelector(".main");
    var tbody = main.querySelector(".list-table tbody")

    // 수정 이벤트 발생 시
    tbody.addEventListener("change", function(e){
        if(e.target.name != "del"){
            e.target.name = "changed";
            e.target.previousElementSibling.name = "changed-id";
        }
    })

    var path = window.location.pathname.split("/");
    var board = path.includes("board");
    var list = path.includes("list");
    var reported = path.includes("reported");
    var active = document.querySelector(".aside nav input");

});