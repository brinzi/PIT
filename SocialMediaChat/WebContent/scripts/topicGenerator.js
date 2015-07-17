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
						var media="";
						
						if( topics[topic].fileName.search(".gif")!=-1 || topics[topic].fileName.search(".jpg")!=-1 || topics[topic].fileName.search(".png")!=-1 )
							media = "<img src="+'"'+topics[topic].fileName+'" id="topicImage" >';
						else if(topics[topic].fileName.search(".webm")!=-1 || topics[topic].fileName.search(".mp4")!=-1 || topics[topic].fileName.search(".ogg")!=-1)
							media= "<video src="+'"'+topics[topic].fileName+'" id="topicImage" type="video" controls>';
						console.log(topics[topic].fileName);
						$("#topicContainer").append(
								'<div id='+ topics[topic].id+' >'
										+'<div id ="topic"'
										+ ' class = "well topic" data-comments="'+ topics[topic].id +'comments"> <p><h1>'
										+ topics[topic].title + '</h1></p>'
										+ media
										+"</img><p>"
										+ topics[topic].content+""
										+'</p>'
										+'</div>'
										+'<div id='+topics[topic].id+'comments'+' style="display:none;">'
										+'<button type="normal" id="slideUpButton" data-comments="'+ topics[topic].id +'comments"></button><br/>'
										+'<form class="form-horizontal" id="commentForm" method="POST" action=AddComment>'
										+'<input type="hidden" name="topic-id" value='+topics[topic].id+'></input>'
										+'<input type="hidden" name="user-id" value='+getCookie("userId")+'></input>'
										+'<textarea id='+topics[topic].id+' class="form-control" name="content" rows="1" style="resize:none; width:80%;"></textarea>'
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
			
			$.ajax({
				type : "POST",
				dataType: "json",
				url : "GetComments",
				contentType: "application/json; charset=utf-8",
				success : function( result ) {
					comments = eval(result);
					//topics = $.parseJSON( result ); 
					for ( var comment in comments) {
						console.log(comments[comment].title);
						$("#"+comments[comment].topicId+"comments").append(
								'<p>'+ comments[comment].content+'</p>')
					}
					//change(comments[comment].topicId,cur);
				},
				error: function( xhr, status, error){
					console.log("error");
					var err = eval("(" + xhr.responseText + ")");
					  alert(err.Message);
				}
				
			})

		});