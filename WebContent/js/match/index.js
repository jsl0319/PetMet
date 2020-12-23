window.addEventListener("load", function () {

    var viewImg = document.querySelector(".main1 .container");
    var backC = document.querySelector(".main1");
    
 
    viewImg.transition= "transform 500ms ease-in-out";
    var backs = ["url('../images/index1.jpg') no-repeat center",
                "url('../images/index2.png') no-repeat top",
                "url('../images/index3.jpg') no-repeat center",
                "url('../images/index4.jpg') no-repeat center"];
    var backsColor = ["beige"];
    viewImg.style.background=backs[0];
    backC.style.background ="beige";
    viewImg.style.backgroundSize="cover";
    var i=0;
    setInterval(function () {

        i++;
        i=i%4;
        viewImg.style.background=backs[i];
        viewImg.style.backgroundSize="cover";
        
        
    }, 3000);
});