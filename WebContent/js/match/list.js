window.addEventListener("load", function() {
    var tbody = document.querySelector("tbody");
    var detailM;
    var even = "even";
    var request = new window.XMLHttpRequest();
        request.onload = function () {
            var matchInfoes = JSON.parse(request.responseText);
            detailM = matchInfoes;
            for (var i = 0; i < matchInfoes.length; i++) {
				var m = matchInfoes[i];
              
                
                var tr = '<tr class="'+(i%2==1?"even":"")+'"> \
                            <td>'+m.id+'</td> \
                            <td>'+m.masterNickname+'(' +(m.masterGender=="1"?"남":"여") + ')</td> \
                            <td><a href="">'+m.name+'</a></td> \
                            <td>'+(m.gender=="1"?"남":"여")+'</td> \
                            <td>'+(m.neut=="1"?"O":"X")+'</td> \
                            <td>'+m.character+'</td> \
                            <td>'+m.kind+'</td> \
                            <td>'+m.address+'</td> \
                            <td>'+m.regDate+'</td> \
                        </tr>';

                tbody.insertAdjacentHTML('beforeend', tr);
            }
        }
        request.open("GET", "/api/match/list", true);
        request.send();

    tbody.onclick = function(e) {
        e.preventDefault();
        for( var i=0; i<detailM.length; i++){
           
            if(e.target.innerText == detailM[i].name){
                e.preventDefault();
                var dm = detailM[i];
                
                var addTr = '<tr class="detail-table"> \
                            <td rowspan="2" style="width:200px; height:200px;"> \
                            <img src="/static/dog/2020/12/'+dm.files+'"</td> \
                            <th colspan="2">몸무게</th> \
                            <td colspan="2"><a href="">'+dm.weight+'kg</a></td> \
                            <th>생일</th> \
                            <td colspan="2">'+dm.birth+'</td> \
                            <td><input type="button" value="신청"></td> \
                             </tr> \
                            <tr class="detail-table content"> \
                            <th colspan="2">희망 사항</td> \
                            <td colspan="6">'+dm.matchContent+'</td> \
                             </tr>';
                var addTrTag = e.target.parentElement.parentElement;
                console.log(addTrTag);
                addTrTag.insertAdjacentHTML('afterend',addTr);
                return;
                
            }
            
        }
    }

});