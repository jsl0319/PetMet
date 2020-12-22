window.addEventListener("load", function() {

	var mapContainer = document.getElementById('map'), // 지도를 표시할 div  
		mapOption = {
			center: new kakao.maps.LatLng(37.567296, 127.010574), // 지도의 중심좌표
			level: 10 // 지도의 확대 레벨
		}; // 공원3을 기준으로 함

	var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다

	var request = new window.XMLHttpRequest();

	var positions = [];

	request.onload = function() {

		var pp = JSON.parse(request.responseText);

		var positions = [];

		for (var i = 0; i < pp.length; i++) {
			var ppLatLng = pp[i].location.split(',');
			var Lat = ppLatLng[0];
			var Lng = ppLatLng[1];
			
			var position = {
				content: '<div>' + pp[i].name + '</div>',
				latlng: new kakao.maps.LatLng(Lat, Lng)
			};
			
			positions.push(position);
		}
		
		for (var i = 0; i < positions.length; i++) {
			// 마커를 생성합니다
			var marker = new kakao.maps.Marker({
				map: map, // 마커를 표시할 지도
				position: positions[i].latlng // 마커의 위치
			});

			// 마커에 표시할 인포윈도우를 생성합니다 
			var infowindow = new kakao.maps.InfoWindow({
				content: positions[i].content // 인포윈도우에 표시할 내용
			});

			// 마커에 mouseover 이벤트와 mouseout 이벤트를 등록합니다
			// 이벤트 리스너로는 클로저를 만들어 등록합니다 
			// for문에서 클로저를 만들어 주지 않으면 마지막 마커에만 이벤트가 등록됩니다
			kakao.maps.event.addListener(marker, 'mouseover', makeOverListener(map, marker, infowindow));
			kakao.maps.event.addListener(marker, 'mouseout', makeOutListener(infowindow));
		}
	}

	// 인포윈도우를 표시하는 클로저를 만드는 함수입니다 
	function makeOverListener(map, marker, infowindow) {
		return function() {
			infowindow.open(map, marker);
		};
	}

	// 인포윈도우를 닫는 클로저를 만드는 함수입니다 
	function makeOutListener(infowindow) {
		return function() {
			infowindow.close();
		};
	}

	request.open("GET", "/api/petplace/list", true);
	request.send();

});