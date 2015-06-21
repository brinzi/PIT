/**
 * 
 */


function sendFriendRequest(user){
	console.log(user);
	
	$.ajax({
		type : "post",
		url : "NotificationServlet",
		data : "input=" +user,
		success : function() {
			
				console.log("send friend request");			
			}
						
	
	});
	
}
