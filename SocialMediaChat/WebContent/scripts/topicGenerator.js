$(window).load(
		function() {
			var topics="";
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
								'<div id = ' + topics[topic].id
										+ ' class = well> <p><h1>'
										+ topics[topic].title + '</h1></p><p>' + topics[topic].content + 
										'</p>' +
										'</div id=' + (topics[topic].id + "topic" ) +
										'</div>')
					}
					change("#topicContainer",cur);
				},
				error: function( xhr, status, error){
					console.log("error");
					var err = eval("(" + xhr.responseText + ")");
					  alert(err.Message);
				}
				
			})

		});