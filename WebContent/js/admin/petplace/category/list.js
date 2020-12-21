window.addEventListener("load", function() {
	var main = document.querySelector(".main");
	var addBtn = main.querySelector(".addBtn");
	var tbody = main.querySelector(".list-table tbody")

	var index = 5;
	var ev = "even";
	// 행 추가
	addBtn.onclick = function() {
		if (index % 2 == 0) {
			index++;
			ev = "even";
		}
		else {
			index++;
			ev = "";
		}
		var tr = '  <tr class=' + ev + '> \
					<td></td> \
                    <td><input name="new-name" type="text""></td> \
                    <td></td> \
                    <td></td> \
					<td></td> \
					</tr>';
		tbody.insertAdjacentHTML('afterbegin', tr);
	}

	// 수정 이벤트 발생 시
	tbody.addEventListener("change", function(e) {
		if (e.target.name != "new-name" && e.target.name != "del") {
			e.target.name = "changed";
			e.target.previousElementSibling.name = "changed-id";
		}
	})

});