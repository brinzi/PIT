/**
 * 	Chat screen functions
 */




$(function (){

	function addText(){
		var msg=$("#userInput").val();
		$("#display").append( $("<p id=\"sentMsg\"></p>").text(msg));
		$("#userInput").val("");

	}
	
	$("#send").click(function(e) {
		e.preventDefault();
		addText();
	});
		
		
	$("#userInput").keypress(function(e){
	
		if(e.which == 13) {
			e.preventDefault();
	       addText();
	    }
	});	
	
	
	
});