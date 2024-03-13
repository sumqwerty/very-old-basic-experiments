function moveUserData(userid,email){
    document.getElementById("user_ID").value = userid;
    document.getElementById("userListBtn").innerHTML = email;
}
function moveNoteData(noteid,notetitle){
    document.getElementById("note_ID").value = noteid;
    document.getElementById("noteListBtn").innerHTML = notetitle;
}

let updateBtn = document.getElementById("updateBtn");
updateBtn.onclick = ev => {
    let error = false;
    
    if(document.getElementById("userListBtn").innerHTML == "User List"){
        alert("Please Select User");
        error = true;
    }
    else if(document.getElementById("noteListBtn").innerHTML == "Note List"){
        alert("Please Select Note");
        error = true;
    }
    else if(!(document.getElementById("revoke").checked || document.getElementById("grant").checked)){
        alert("Please Select Atleast one Access");
        error = true;
    }
    
    if(!error){
        document.forms[0].submit();
    }
};