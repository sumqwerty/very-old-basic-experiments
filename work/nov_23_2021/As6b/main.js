'use strict';
/*
	WEB 230 Spring 2020
	Assignment 6b
	{your name here}
*/

let lst = document.getElementsByTagName("ul")[0]; // list element
let plus = document.getElementById("add-item"); // "+" button
let inpt = document.getElementById("new-item-text"); // input field


function addItem()
{
	// creating cross span
	let innerSpan = document.createElement("span");
	innerSpan.classList.add("remove");

	// creating li
	let newItem = document.createElement("li");
	newItem.classList.add("todo-item");
	newItem.textContent = inpt.value;

	// adding span to li
	newItem.appendChild(innerSpan);
	// adding li to the list
	lst.appendChild(newItem);

	// clear the input box after adding the element to the list
	inpt.value = "";
}

function eventHandler(event)
{
	let trgt = event.target;
	console.log(trgt.tagName);
	if(trgt.tagName == "LI")
	{
		trgt.classList.add("completed");
	}
	else if(trgt.tagName == "SPAN")
	{
		let parentLI = trgt.parentNode;
		parentLI.parentNode.removeChild(parentLI);
	}
}


function addNewClick(event)
{
	console.log("clicked");
	addItem();
}

function addNewPressed(event)
{
	if(event.key == "Enter") // add new item only when enter is pressed
	{
		console.log("pressed");
		addItem();
	}
}


// adding event listeners
lst.addEventListener("click",eventHandler);
plus.addEventListener("click",addNewClick);
inpt.addEventListener("keydown",addNewPressed);

