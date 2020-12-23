window.addEventListener("load", function() {

	function searchParam(key) {
		return new URLSearchParams(location.search).get(key);
	}

	var id = searchParam('id');
	

	var request = new window.XMLHttpRequest();
	
	request.onload = function() {

		var location = JSON.parse(request.responseText);

		var mapContainer = document.getElementById('map'); // 지도를 표시할 div 
		var	mapOption = {
			center: new kakao.maps.LatLng(location.longitude, location.latitude), // 지도의 중심좌표
			level: 3 // 지도의 확대 레벨
		};

		var map = new kakao.maps.Map(mapContainer, mapOption);

		var marker = new kakao.maps.Marker({
			// 지도 중심좌표에 마커를 생성
			position: map.getCenter()
		});

		marker.setMap(map);
		// ㅎㅎ
		
	}

	request.open("GET", "/api/petplace/detail?id=" + id, true);
	request.send();

});