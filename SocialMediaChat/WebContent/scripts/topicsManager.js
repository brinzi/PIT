/* generate topics */

$(document).ready(

function() {

	$.ajax ({
		type: "GET",
		url: "topics",
		dataType: "json",
	
		success: function(data){
			$("#topicsContainer").append("<h1></h1>").text("asdasdA");
			console.log("should have written!");
		}
	});
}

)