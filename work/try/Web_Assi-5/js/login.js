// Action on clicking login buttons
let loginBtn = document.getElementById("loginBtn");
loginBtn.onclick = ev => {
    var formEle = document.forms[0].getElementsByTagName("input");
    
    let error = false;
    let emailSpan = document.getElementById("emailTipText");
    let passSpan = document.getElementById("passwordTipText");
    resetTip(emailSpan);
    resetTip(passSpan);
    
    var email = formEle[0].value;
    if(email==""){
        emailSpan.innerHTML = "Empty";
        showTip(emailSpan);
        error = true;
    }
    else if(! /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(email)){
        emailSpan.innerHTML = "Invalid email";
        showTip(emailSpan);
        error = true;
    }
    var password = formEle[1].value
    if(password.length == 0){
        passSpan.innerHTML = "Empty";
        showTip(passSpan);
        error = true;
    }
    else if(password.length<6){
        passSpan.innerHTML = "Min Length 6";
        showTip(passSpan);
        error = true;
    }
    else if(password.includes(' ')){
        passSpan.innerHTML = "No spaces allowed";
        showTip(passSpan);
        error = true;
    }

    if(!error){
        document.forms[0].submit();
    }
};

// jQuerry Transitions
$(document).ready(function() {
    $('#passwordField').hover(function() {
        $('#passwordTipText').css('transition', '1s');
        $('#passwordTipText').css('opacity', '0');
    });
    $('#emailField').hover(function() {
        $('#emailTipText').css('transition', '1s');
        $('#emailTipText').css('opacity', '0');
    });
});