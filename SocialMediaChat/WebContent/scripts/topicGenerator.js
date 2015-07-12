$(window).load(
		function() {
			var topics="", comments="";
			$.ajax({
				type : "POST",
				dataType: "json",
				url : "GetPosts",
				contentType: "application/json; charset=utf-8",
				success : function( result ) {
					$("#topicContainer").empty();
					topics = eval(result);
					//topics = $.parseJSON( result ); 
					for ( var topic in topics) {
						console.log(topics[topic].title);
						$("#topicContainer").append(
								'<div id='+topics[topic].id+'>'
										+'<div id = ' + topics[topic].id+'content'
										+ ' class = well> <p><h1>'
										+ topics[topic].title + '</h1></p><p>'
										+ topics[topic].content
										+'</p>'
										+'</div>'
										+'<div id='+topics[topic].id+'comments>'
										+'<form class="form-horizontal" method="POST" action=AddComment>'
										+'<textarea class="form-control" name="commentText" rows="1"></textarea>'
										+'<button type="submit" class="btn btn-primary">Submit</button></form>'
										+'</div>'
										+'</div>')
					}
					change("#topicContainer",cur);
				},
				error: function( xhr, status, error){
					console.log("error");
					var err = eval("(" + xhr.responseText + ")");
					  alert(err.Message);
				}
				
			})
			
	/*		$.ajax({
				type : "POST",
				dataType: "json",
				url : "GetComments",
				contentType: "application/json; charset=utf-8",
				success : function( result ) {
					comments = eval(result);
					//topics = $.parseJSON( result ); 
					for ( var comment in comments) {
						console.log(comments[comment].title);
						$("#topicContainer").append(
								'<div id = ' + comments[comment].id
										+ ' class = well> '
										+ comments[comment].content
										+'</p>'
										+'</div id=' + (comments[comment].topicId + "topic" )
										+'</div>')
					}
					change(comments[comment].topicId,cur);
				},
				error: function( xhr, status, error){
					console.log("error");
					var err = eval("(" + xhr.responseText + ")");
					  alert(err.Message);
				}
				
			})
*/
		});