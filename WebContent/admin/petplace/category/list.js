window.addEventListener("load", function(){
    var section = document.getElementById("section");
    var categoryDetail5 = section.getElementsByClassName("category5")[0];
    var categoryDetail4 = section.getElementsByClassName("category4")[0];
    var categoryDetail3 = section.getElementsByClassName("category3")[0];
    var categoryDetail2 = section.getElementsByClassName("category2")[0];
    var categoryDetail1 = section.getElementsByClassName("category1")[0];

    var win;

    categoryDetail5.onclick = function(){
        win = open("detail.html", "_black", "width=400px, height=300px")
    };

    categoryDetail4.onclick = function(){
        win = open("detail.html", "_black", "width=400px, height=300px")
    };

    categoryDetail3.onclick = function(){
        win = open("detail.html", "_black", "width=400px, height=300px")
    };

    categoryDetail2.onclick = function(){
        win = open("detail.html", "_black", "width=400px, height=300px")
    };

    categoryDetail1.onclick = function(){
        win = open("detail.html", "_black", "width=400px, height=300px")
    };

})