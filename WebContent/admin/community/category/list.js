window.addEventListener("load", function(){
    var main = document.querySelector(".main");
    var addBtn = main.querySelector(".addBtn");
    var tbody = main.querySelector(".list-table tbody")
    var trs = tbody.querySelectorAll("tr");

    addBtn.onclick = function(){
        var tr = document.createElement("tr");
        tr.innerHTML = '<td></td><td class="col-l"><input name="new-name" type="text""></td><td class="col-m"></td><td></td>';
        tbody.append(tr);
    }
});