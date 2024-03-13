/*Include a comment at the beginning of the JavaScript file that includes your name, student
number, assignment name, and the date.*/
'use strict';


let form = document.querySelector("form");

let firstName = form.elements.namedItem("firstName");

let togglePasswd = form.elements.namedItem("show");

let submitBttn = form.elements.namedItem("send");

let accept = form.elements.namedItem("accept");

let readySubmit = true; // variable to prevent submission when password is shown

document.getElementsByTagName("body")[0].onload = function(){ // fire the event whent the page loads 
    
    if(localStorage.getItem("firstName") != null){ // fill first name if its stored in the localStorage
        firstName.value = localStorage.getItem("firstName");
        changeBgColor();
    }

    let passwd = form.elements.namedItem("password");
    passwd.value = "monkey"; // setting password to "monkey"

    let favCity = form.elements.namedItem("city");
    favCity.value = "New York"; // setting fav city to "New York"

    form.elements.namedItem("comment").value = "";
}


function changeBgColor(){ // seting name intput field background
    if(firstName.value.length >= 5) firstName.style.backgroundColor = "green"; // set the color to green when name length is greater than 5
    else firstName.style.backgroundColor = ""; // remove the color when name length is smaller than  5
}


firstName.addEventListener("input", changeBgColor);// seting name intput field background


firstName.addEventListener("change", function(event){ // save name in localstorage
    localStorage.setItem("firstName",firstName.value);
});

togglePasswd.addEventListener("click", function(event){ // show or hide password
    let passwd = form.elements.namedItem("password");
    if(passwd.type == "password"){
        passwd.type="text";
        event.target.innerHTML = "Hide";
        readySubmit = false;
    }
    else{
        passwd.type="password";
        event.target.innerHTML = "Show";
        readySubmit = true;
    } 
});

accept.addEventListener("click", function(event){ // toggle submit button when "i accept" check box is selected
    if(event.target.checked){
        submitBttn.disabled = false;
    }
    else submitBttn.disabled = true;
});


form.addEventListener("submit", function(event) { // when form is submitted 
    
    // getting selected text from the textarea if any
    let txtarea = form.elements.namedItem("comment");
    let start = txtarea.selectionStart;
    let finish = txtarea.selectionEnd;
    let sel = txtarea.value.substring(start, finish);
    

    if(!form.elements.namedItem("food")[1].checked){ // checking if selected food is 'Apple' or not
        alert("You should like Apple and choose 'Apple' as you favourite food");
        event.preventDefault();
    }

    if(sel.length > 0){
        alert("Why have you selected '"+sel+"' from the text area?");
        event.preventDefault();
    }

    if(!readySubmit)event.preventDefault(); // if password is shown do not submit

}, true);




