// jQuerry Transitions
$(document).ready(function() {
    var noteContrText = $('#noteContrText');
    noteContrText.focus(function() {
        if(noteContrText.html() == "Text here") noteContrText.html("");
    }).blur(function(){
        if(noteContrText.html() == "") noteContrText.html("Text here");
    });
});

// Dynamic Counter
function countNumbers(ele){
    var count = ele.innerHTML.length;
    countField = document.getElementById("textCountField");
    countField.innerHTML = count +"/1500";
    if(count>1500) countField.style.color = 'red';
    else if (countField.style.color == 'red') countField.style.color = 'black';
}