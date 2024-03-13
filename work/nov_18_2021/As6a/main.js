"use strict";
/*
	WEB 230 Spring 2020
	Assignment 6a
	{your name here}
*/

let gameOver = false;

const wins = [
[0, 1, 2],
[3, 4, 5],
[6, 7, 8],
[0, 3, 6],
[1, 4, 7],
[2, 5, 8],
[0, 4, 8],
[2, 4, 6]
];




function checkWin(player){
	
	let grid = Array.from(squares, function(square) {
		return square.classList.contains(player);
	});

	for (let win of wins) {
		if (grid[win[0]] && grid[win[1]] && grid[win[2]]) {
			for (let sq of win) {
			// Add code here to set background color to 'lightgreen'.
			// `sq` is the index of the TD
				squares[sq].style.backgroundColor = 'lightgreen';
			}
			return true;
		}
	}
	return false;
}

function evntHandler(event)
{

	let currID = document.getElementsByClassName("current-player")[0].id;
	console.log(currID);

	let target = event.target;
	if(target.classList.length == 0 && !gameOver) // to check if the block is empty and if the game is not over
	{

		let sign;

		if(currID == 'X')sign = "X-marker";
		else sign = "O-marker";

		target.classList.add(sign);
		if(checkWin(sign))
		{
			gameOver = true;
			let winner ;
			if(currID == 'X')winner = "Player X";
			else winner="Player O";
			alert(winner+" is the winner !!");
		}

		playerX.classList.toggle('current-player');
		playerO.classList.toggle('current-player');
	}

}

function newGame(event)
{
	gameOver = false;
	playerX.classList.add("current-player");
	playerO.classList.remove("current-player");

	for(let i=0; i<squares.length; ++i)
	{
		squares[i].className = "";
		squares[i].style.backgroundColor = '';

	}

}


let playerX = document.getElementById("X");
playerX.classList.add("current-player");

let playerO = document.getElementById("O");



let table = document.getElementsByTagName("table")[0];
let squares = [];

// new game event handler
let newG = document.getElementsByTagName('input')[0];
newG.addEventListener("click",newGame);





for(let i=0; i<table.rows.length; ++i)
{
	for(let j=0; j<table.rows[i].cells.length; ++j)
	{
		let temp = table.rows[i].cells[j];
		squares.push(temp);
		temp.addEventListener("click", evntHandler);
	}
}