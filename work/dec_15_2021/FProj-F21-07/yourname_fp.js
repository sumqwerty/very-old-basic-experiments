if(sessionStorage.getItem("memory") == null){
    sessionStorage.setItem("memory","");
}
function getRandom(min, max) {
    return Math.floor(Math.random()*(max - min + 1))+min;
}

// change operation button colors
let operationBttns = document.getElementsByClassName("opr");
for(let i=0; i<operationBttns.length; ++i){
    let r = getRandom(50,255);
    let g = getRandom(20,255);
    let b = getRandom(0,255);
    // my choice is to go with a random color because fixed colors are no fun, so random colors
    operationBttns[i].style.backgroundColor = "rgb("+r+","+g+","+b+")";
}

// change number button colors to blue
let inptBttns = document.getElementsByClassName("inpt");
for(let i=0; i<inptBttns.length; ++i){
    inptBttns[i].style.color = "blue";
}

let equal = document.getElementById("eql");
equal.style.backgroundColor="#008000";
equal.style.color="blue";

// Change the background colour of clear “C” button, to black. Also the font colour to white
let clear = document.getElementById("clr");
clear.style.backgroundColor = "black";
clear.style.color = "white";

// adding MS, MC, MR
let bttnContainer = document.querySelector(".buttonsF17");

let ms = document.createElement("button");
ms.type = "button";
ms.id = "ms";
ms.classList.add("btF17");
ms.classList.add("btn-grey");
ms.innerHTML="MS";
ms.style.backgroundColor = "grey";
ms.style.color = "white";
bttnContainer.insertBefore(ms,clear);

let mc = document.createElement("button");
mc.type = "button";
mc.id = "mc";
mc.classList.add("btF17");
mc.classList.add("btn-grey");
mc.innerHTML="MC";
mc.style.backgroundColor = "grey";
mc.style.color = "white";
bttnContainer.insertBefore(mc,clear);

let mr = document.createElement("button");
mr.type = "button";
mr.id = "mr";
mr.classList.add("btF17");
mr.classList.add("btn-grey");
mr.innerHTML="MR";
mr.style.backgroundColor = "grey";
mr.style.color = "white";
bttnContainer.insertBefore(mr,clear);

let screen = document.getElementById("screen");
let overWrite = false;
let oldColor = "";

bttnContainer.addEventListener("click",function(event){
    if(event.target.id == "eql"){
        if(screen.value=="")
        {
            screen.value="Please enter a value";
            overWrite = true;
        }
        screen.value = eval(screen.value);
    }
    else if(event.target.id == "clr")screen.value = "";
    else if(event.target.id == "ms")sessionStorage.setItem("memory",screen.value);
    else if(event.target.id == "mc")sessionStorage.setItem("memory","");
    else if(event.target.id == "mr")screen.value = sessionStorage.getItem("memory");
    else{
        if(overWrite)screen.value="";
        overWrite = false;
        screen.value = screen.value + event.target.dataset.num;
    }
});


function onMouseEnter(event){
    oldColor = event.target.style.backgroundColor; 
    event.target.style.backgroundColor = "red";
}

function onMouseLeave(event){
    console.log();
    event.target.style.backgroundColor = oldColor;
}


allBttns = document.getElementsByTagName("button");

for(let i=0; i<allBttns.length; ++i){
    allBttns[i].addEventListener("mouseenter",onMouseEnter);
    allBttns[i].addEventListener("mouseleave",onMouseLeave);
}


