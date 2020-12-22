window.addEventListener("load", function() {

	var tbody = document.querySelector("tbody");

	var request = new XMLHttpRequest();
	request.onload = function() {

		tbody.innerHTML = "";

		var matchInfoes = JSON.parse(request.responseText);

		for (var i = 0; i < matchInfoes.length; i++) {
			var m = matchInfoes[i];

			console.log(m); //key:id  값:24
			
			var tr = '<tr> \
                            <td>'+ m.id + '</td> \
                            <td>'+ m.masterNickname + '(' + m.masterGender + ')</td> \
                            <td><a href="">'+ m.name + '</a></td> \
                            <td>'+ m.gender + '</td> \
                            <td>'+ m.neut + '</td> \
                            <td>'+ m.character + '</td> \
                            <td>'+ m.kind + '</td> \
                            <td>'+ m.address + '</td> \
                            <td>'+ m.regDate + '</td> \
                        </tr>';

			tbody.insertAdjacentHTML('beforeend', tr);

		}
	};

	request.open("GET", "/api/match/list", true);
	request.send();

});





