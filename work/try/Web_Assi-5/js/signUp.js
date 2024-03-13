// jQuerry Transitions
$(document).ready(function() {
    $('#fNameField').hover(function() {
        $('#fNameTipText').css('transition', '1s');
        $('#fNameTipText').css('opacity', '0');
    });
    $('#lNameField').hover(function() {
        $('#lNameTipText').css('transition', '1s');
        $('#lNameTipText').css('opacity', '0');
    });
    $('#emailField').hover(function() {
        $('#emailTipText').css('transition', '1s');
        $('#emailTipText').css('opacity', '0');
    });
    $('#passwordField').hover(function() {
        $('#passwordTipText').css('transition', '1s');
        $('#passwordTipText').css('opacity', '0');
    });
    $('#passRepeatField').hover(function() {
        $('#passwordRepTipText').css('transition', '1s');
        $('#passwordRepTipText').css('opacity', '0');
    });
});

// Get dafual user image src
var userIconSrc;
function getDefaultImageSrc(){
    userIconSrc = document.getElementById("userImg").src;
}

// Button Onclick  Action
let signUpBtn = document.getElementById("signUpBtn");
signUpBtn.onclick = ev => {
    var formEle = document.forms[0].getElementsByTagName("input");
    
    let error = false;
    let fNameSpan = document.getElementById("fNameTipText");
    let lNameSpan = document.getElementById("lNameTipText");
    let emailSpan = document.getElementById("emailTipText");
    let passSpan  = document.getElementById("passwordTipText");
    let passRepSpan = document.getElementById("passwordRepTipText");
    let imgSpan = document.getElementById("imgTipText");
    resetTip(fNameSpan);
    resetTip(lNameSpan);
    resetTip(emailSpan);
    resetTip(passSpan);
    resetTip(passRepSpan);
    resetTip(imgSpan);
    
    var fName = formEle[1].value
    if(fName.length == 0){
        fNameSpan.innerHTML = "Required";
        showTip(fNameSpan);
        error = true;
    }
    else if(! /^[a-zA-Z]+$/.test(fName)){
        fNameSpan.innerHTML = "Only Alphabets allowed";
        showTip(fNameSpan);
        error = true;
    }
    
    var lName = formEle[2].value
    if(lName.length == 0){
        lNameSpan.innerHTML = "Required";
        showTip(lNameSpan);
        error = true;
    }
    else if(! /^[a-zA-Z]+$/.test(lName)){
        lNameSpan.innerHTML = "Only Alphabets allowed";
        showTip(lNameSpan);
        error = true;
    }
    
    let email = formEle[3].value;
    if(email.length == 0){
        emailSpan.innerHTML = "Required";
        showTip(emailSpan);
        error = true;
    }
    else if(email==""){
        emailSpan.innerHTML = "Empty";
        showTip(emailSpan);
        error = true;
    }
    else if(! /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(email)){
        emailSpan.innerHTML = "Invalid email";
        showTip(emailSpan);
        error = true;
    }
    
    var password = formEle[4].value
    var passwordRep = formEle[5].value
    if(password.length == 0){
        passSpan.innerHTML = "Required";
        showTip(passSpan);
        error = true;
    }
    else if(password.length<6){
        passSpan.innerHTML = "Min length 6";
        showTip(passSpan);
        error = true;
    }
    else if(! /[^0-9a-z]/gi.test(password)){
        passSpan.innerHTML = "atleast one speacil charecter needed";
        showTip(passSpan);
        error = true;
    }
    if(passwordRep.length == 0){
        passRepSpan.innerHTML = "Required";
        showTip(passRepSpan);
        error = true;
    }
    else if(password != passwordRep){
        passRepSpan.innerHTML = "Password Don't match";
        showTip(passRepSpan);
        error = true;
    }
    
    if(document.getElementById("userImg").src == userIconSrc){
        showTip(imgSpan);
        error = true;
    }

    // document.getElementById("urlInput").value =  document.getElementById("userImg").src;

    if(!error){
        document.forms[0].submit();
    }

};

//Image Update 
window.addEventListener('load', function() {
    document.getElementById("imgUploadBtn").addEventListener('change', function() {
        if (this.files && this.files[0]) {
            var img = document.getElementById("userImg");
            img.onload = () => {
                URL.revokeObjectURL(img.src);
            }
            img.src = URL.createObjectURL(this.files[0]);
        }
    });
});

var input = document.getElementById("imgUploadBtn");
var selectedFile;
input.addEventListener('change', updateImageDisplay);
function updateImageDisplay() {
    if(input.files.length==0) {
        input.files = selectedFile;
   }
   else {
       selectedFile = input.files;
   }
}