window.addEventListener("load", function () {
	
	var section = document.querySelector(".body");
	  var request = new window.XMLHttpRequest();
        request.onload = function () {
            var board = JSON.parse(request.responseText);
           
            for (var i = 0; i < board.length; i++) {
				var b = board[i];
				console.log(b);
                var tr = '<tr> \
                            <td>'+b.id+'</td> \
                            <td>'+b.title+'</td> \
                            <td><a href="">'+b.writerId+'</a></td> \
                            <td>'+b.cmtCnt+'</td> \
                            <td>'+b.hit+'</td> \
                            <td>'+b.regDate+'</td> \
                        </tr>';

                tbody.insertAdjacentHTML('beforeend', tr);
            }
        }
        request.open("GET", "/api/board/list", true);
        request.send();

	
	
	});
