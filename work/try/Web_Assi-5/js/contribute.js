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

let addConBtn = document.getElementById("addContribution");
addConBtn.onclick = ev => {
    var noteText = document.getElementById("noteContrText").innerHTML;
    if(noteText.length != 0 && noteText.length < 1501 && noteText != "Text here"){
        document.getElementById("noteTextInput").value = noteText;
        document.forms[0].submit();
    }
};