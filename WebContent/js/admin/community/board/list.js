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
});