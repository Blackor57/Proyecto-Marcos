let items = document.getElementsByClassName("list__item");
let boxLeft = document.getElementById("list1");
let boxCenter = document.getElementById("list2");
let boxRight = document.getElementById("list3");


for (item of items) {

    item.addEventListener("dragstart", function(e) {
        let selected = e.target;

        boxLeft.addEventListener("dragover", function(e){
            e.preventDefault();
        });
        boxLeft.addEventListener("drop", function(e){
            boxLeft.appendChild(selected);
            selected = null;
        });

        boxCenter.addEventListener("dragover", function(e){
            e.preventDefault();
        });
        boxCenter.addEventListener("drop", function(e){
            boxCenter.appendChild(selected);
            selected = null;
        });

        boxRight.addEventListener("dragover", function(e){
            e.preventDefault();
        });
        boxRight.addEventListener("drop", function(e){
            boxRight.appendChild(selected);
            selected = null;
        });

    });

}
