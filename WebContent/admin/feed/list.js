window.addEventListener("load", function() {
	var main = document.querySelector("#main");
	var section = main.querySelector(".main-section");
	var tbody = section.querySelector("tbody");
	var pager = section.querySelector(".pager");
	
	// 1페이지 로드
	load();
	
	pager.onclick = function(event){
		event.preventDefault();
		
		var pager = parseInt(envet.target.innerText);
		load(pager);
	}
	
	function load(page){
		
		//------페이지 초기화
		if(page==undefined)
			page = 1;
		
		//-------요청 객체 생성
		var request = new XMLHttpRequest();
		
		request.onload = function(){
			
			tbody.innerText = "";
			
			//----------요청한 결과값 담기
			var views = JSON.parse(request.responseText);
			
			//-----------결과값 담을 태그와 테디터를 데이터 수만큼 생성
			for(var i =0; i<views.length; i++){
				var v = views[i];
				
				var tr = '<tr> \
	                        <td>'+v.num+'</td> \
	                        <td><a href="detail.html">'+v.feedId+'</a></td> \
	                        <td>'+v.repoCnt+'</td> \
	                        <td>'+v.action+'</td> \
	                     </tr>';
			//----------생성한 객체를 노드 뒤에 연결한다.
			tbody.insertAdjacentElement('beforeend',tr);
			}
		}
		
		//----------페이지 요청
		request.open("GET", "/api/feed/list?p="+page, true);
	    request.send();
	}
});