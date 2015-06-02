/**
 * 	Chat screen functions
 */


$(function (){

	
	var socket= new WebSocket("ws://localhost:8080/SocialMediaChat/socket");
	
	socket.onopen = function(event){
		
		console.log('Connection open!');
		
	};
	
	socket.onmessage = function(event) {
		console.log('event.data');
		addText(event.data);
	} ;
	
	
	function addText(e){
		
		$("#display").append( $("<p id=\"sentMsg\"></p>").text(e));
		$("#userInput").val("");

	}
	
	function sendText() {
		var msg=$("#userInput").val();

		socket.send(msg);
		
	}
	
	$("#send").click(function(e) {
		sendText();
		
	});
		
		
	$("#userInput").keypress(function(e){
	
		if(e.which == 13) {
			e.preventDefault();
			sendText();
	     
	    }
	});	
	
	
	
});