window.addEventListener("load", function(){
    var gSection = document.querySelector(".graph");
    var canvas = gSection.querySelector("canvas");
    var ctx = canvas.getContext('2d');
    
    ctx.strokeStyle = "#BBB"; 

    // y축
    ctx.beginPath();
    ctx.moveTo(0, 0);
    ctx.lineTo(0, 370);
    ctx.stroke();

    // 도움선
    ctx.beginPath();
    ctx.moveTo(0, 100);
    ctx.lineTo(600, 100);
    ctx.stroke();

    ctx.beginPath();
    ctx.moveTo(0, 200);
    ctx.lineTo(600, 200);
    ctx.stroke();

    ctx.beginPath();
    ctx.moveTo(0, 300);
    ctx.lineTo(600, 300);
    ctx.stroke();

    // x축
    ctx.beginPath();
    ctx.moveTo(0, 370);
    ctx.lineTo(600, 370);
    ctx.stroke();

    var request = new window.XMLHttpRequest();
    request.onload = function () {
        var jsons = JSON.parse(request.responseText);
        var matchInfo = jsons[0]
        var review = jsons[1]

        // for(var i=0; i < matchInfo.length; i++){
        //     var m = matchInfo[i];
        //     var x = 50 + i*110;
        //     var y = 370 - m.dogId * 100;
        //     var width = 50;
        //     var height = m.dogId * 100;

        //     ctx.fillStyle = '#e7708d';
        //     ctx.fillRect(x, y, width, height);

        //     ctx.fillStyle = 'black';
        //     ctx.font = '20px arial';
        //     ctx.fillText(m.name, x, 390);
        // }

        for(var i=0; i < review.length; i++){
            var r = review[i];
            var x = 50 + i*110;
            var y = 370 - r.id * 30;
            var width = 50;
            var height = r.id * 30;

            ctx.fillStyle = '#ddd';
            ctx.fillRect(x, 0, width, 370);

            ctx.fillStyle = '#e7708d';
            ctx.fillRect(x, y, width, height);

            ctx.fillStyle = 'black';
            ctx.font = '20px arial';
            ctx.fillText(r.memberName, x, 390);
        }
    }

    request.open("GET", "/api/index", true);
    request.send();

});
