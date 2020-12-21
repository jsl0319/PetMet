window.addEventListener("load", function(){
    var main = document.querySelector(".main");
    var addBtn = main.querySelector(".addBtn");
    var tbody = main.querySelector(".list-table tbody")
    
    // 행 추가
    addBtn.onclick = function(){
        var tr = '<td></td> \
                    <td class="col-l"><input name="new-name" type="text""></td> \
                    <td class="col-m"></td> \
                    <td></td>';

        tbody.insertAdjacentHTML('beforeend', tr);
    }

    // 수정 이벤트 발생 시
    tbody.addEventListener("change", function(e){
        if(e.target.name != "new-name" && e.target.name != "del"){
            e.target.name = "changed";
            e.target.previousElementSibling.name = "changed-id";
        }
    })
});