console.log("event handlers and registration loaded");

/* event handler function for the username field
*/
function validateUsername (event) {
    console.log("verify as a username: " + event.target.value);
    let error = document.getElementById(event.target.id + "Error");
    let help = document.getElementById(event.target.id + "Help");

    if (checkUsername(event.target.value)) {
        console.log ("username is valid");
        error.style.display = "none";
        help.style.display = "inline";
    } else {
        console.log ("username is not valid");
        error.style.display = "inline";
        help.style.display = "none";
    }
    
}

function checkUsername (username) {
    let usernameRegEx = /^[\w.]+@uregina.ca$/i;
    if (usernameRegEx.test(username)){
        return true;
    } else {
        return false;
    }
}

/* event handler function for the password field
*/
function validatePassword (event) {
    console.log("verify as a password: " + event.target.value);

    let errorLength = document.getElementById(event.target.id + "ErrorLength");
    let errorFormat = document.getElementById(event.target.id + "ErrorFormat");
    let help = document.getElementById(event.target.id + "Help");

    let noErrors = true;

    if (checkPasswordLength (event.target.value)) {
        // password length is okay
        errorLength.classList.add("hideMe");
    } else {
        console.log ("password is too short");
        errorLength.classList.remove("hideMe");
        noErrors = false;
    }
    
    if (checkPasswordFormat (event.target.value)) {
        // password format is okay
        errorFormat.classList.add("hideMe");
    } else {
        console.log ("the password does not contain any symbols");
        errorFormat.classList.remove("hideMe");
        noErrors = false;
    }

    if (noErrors) {
        help.classList.remove("hideMe");
    } else {
        help.classList.add("hideMe");
    }
    
}

function checkPasswordLength (passwordValue) {
    if (passwordValue.length < 8) {
        return false;
    } else {
        return true;
    }
}
function checkPasswordFormat (passwordValue) {
    let nwcRegEx = /[^\w]/;
    let positionInPasswordValue = passwordValue.search(nwcRegEx);
    if (positionInPasswordValue < 0) {
        return false;
    } else {
        return true;
    }
}

/* event handler function for the form
*/
function validateForm (event) {
    // get the username and password
    var username = document.getElementById("username");
    let password = document.getElementById("password");
    
    // validate all the form fields
    if (checkUsername(username.value) && checkPasswordLength(password.value) && checkPasswordFormat(password.value)) {
        // no errors
    } else {
        console.log ("at least one of the form elements is not valid");
        event.preventDefault();
    }

}

/* event registration
*/
let username = document.getElementById("username");
username.addEventListener("blur", validateUsername);

let password = document.getElementById("password");
password.addEventListener("blur", validatePassword);

let theForm = document.getElementById("theForm");
theForm.addEventListener("submit", validateForm);
