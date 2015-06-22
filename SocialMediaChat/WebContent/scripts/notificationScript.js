/**
 * 
 */


function sendFriendRequest(user){
	console.log(user);
	
	$.ajax({
		type : "post",
		url : "NotificationServlet",
		data : "sendTo=" +user+","+u,
		success : function() {
			
				console.log("send friend request");			
			}
						
	
	});
	
}

$(window).load(function (){
	

	for ( var notification in not) {
		if(not[notification].type!="Pending"){
			$("#userInfo").append(
					$("<div class=\"panel-body notificationTab\" id=\"notificationTab\"></div>").text(not[notification].type +":"+not[notification].from));
			$("#notificationTab").append("<span class=\" glyphicon glyphicon-ok\"></span>");
			$("#notificationTab").append("<span class=\" glyphicon glyphicon-remove\"></span>");
		}
		else
			$("#userInfo").append(
					$("<div class=\"panel-body notificationTab\" id=\"notificationTab\"></div>")
						.text(not[notification].type +": friend request to  "+not[notification].to));
			
	}
	 
	
	
});
