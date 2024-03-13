// jQuerry transitions
$(document).ready(function() {
    $('#noteName').hover(function() {
        $('#nateTitleTipText').css('transition', '1s');
        $('#nateTitleTipText').css('opacity', '0');
    });

    var noteNameField = $('#noteName');
    noteNameField.focus(function() {
        if(noteNameField.html() == "Title") noteNameField.html("");
    }).blur(function(){
        if(noteNameField.html() == "") noteNameField.html("Title");
    });

    var noteTextField = $("#noteText");
    noteTextField.focus(function() {
        if(noteTextField.html() == "Text here") noteTextField.html("");
    }).blur(function(){
        if(noteTextField.html() == "") noteTextField.html("Text here");
    });
});

// Action on clicking create button
let createBtn = document.getElementById("createBtn");
createBtn.onclick = ev => {
    var noteTitleSpan = document.getElementById("nateTitleTipText");
    resetTip(noteTitleSpan);

    var noteTitle = document.getElementById("noteName").innerHTML;
    if(noteTitle.length == 0 || noteTitle == "Title"){
        noteTitleSpan.innerHTML = "Title Required";
        showTip(noteTitleSpan);
    }
    else if(noteTitle.length > 256){
        noteTitleSpan.innerHTML = "Title too long, Max length 256";
        showTip(noteTitleSpan);
    }
};