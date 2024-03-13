// jQuerry transitions
$(document).ready(function() {
    $('#noteName').hover(function() {
        $('#noteTitleTipText').css('transition', '1s');
        $('#noteTitleTipText').css('opacity', '0');
    });

    var noteNameField = $('#noteName');
    noteNameField.focus(function() {
        if(noteNameField.html() == "Title") noteNameField.html("");
    }).blur(function(){
        if(noteNameField.html() == "") noteNameField.html("Title");
    });

    $('#titleInput').val('');
});

// Action on clicking create button
let createBtn = document.getElementById("createBtn");
createBtn.onclick = ev => {
    
    let error = false;
    var noteTitleSpan = document.getElementById("noteTitleTipText");
    resetTip(noteTitleSpan);

    var noteTitle = document.getElementById("noteName").innerHTML;
    if(noteTitle.length == 0 || noteTitle == "Title"){
        noteTitleSpan.innerHTML = "Title Required";
        showTip(noteTitleSpan);
        error = true;
    }
    else if(noteTitle.length > 256){
        noteTitleSpan.innerHTML = "Title too long, Max length 256";
        showTip(noteTitleSpan);
        error = true;
    }

    document.getElementById("titleinput").value = noteTitle;
    if(!error){
        document.forms[0].submit();
    }
};