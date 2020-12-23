window.addEventListener("load", function() {
	
	//var section = document.querySelector("#list")
	var tbody = document.querySelector("tbody");
	
	

	
	
		var request = new XMLHttpRequest();
		 request.onload = function(){ 
			tbody.innerHTML = "";
			var matchInfo = JSON.parse(request.responseText);
			
			
			
			for(var i=0; i<matchInfo.length;i++){
				
				
				var n = matchInfo[i].neut;
				
				if(n == 1){
					n = "O"
				}
				else{
					n= "X"
					}
					
					console.log(n);
				
				
				var tr = '<tr> \
				<td>'+matchInfo[i].id+'</td> \
				 			<td>'+matchInfo[i].masterGender+'</td> \
						<td>'+matchInfo[i].name+'</td> \
						<td>'+matchInfo[i].gender+'</td> \
						<td>'+n+'</td> \
						<td>'+matchInfo[i].character+'</td> \
						<td>'+matchInfo[i].kind+'</td> \
						<td>'+matchInfo[i].address+'</td> \
						<td>'+matchInfo[i].regDate+'</td> \
						<tr>';
						tbody.insertAdjacentHTML('beforeend', tr);
			}
			
			
	}
	
  request.open("GET","/api/match/list",true)
		
        request.send();
	
});