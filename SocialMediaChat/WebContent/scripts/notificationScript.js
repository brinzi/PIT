/**
 * 
 */


function sendFriendRequest(user){
	console.log(user);
	
	$.ajax({
		type : "post",
		url : "NotificationServlet",
		data : "input=" +user,
		data : "data=" + user + "," + u + "," + notid + ",rejectRequest",
		dataType:"text",
		success : function() {
			
				console.log("send friend request");			
			}
						
	
	});
	
}

$(window).load(function (){
	

	console.log(not[0]);
	
function initNotifications() {
	console.log(not + "Notification current state");

	$("#userInfo").find(".friendRequest").remove();

	for ( var notification in not) {
		console.log(not[notification]);
		if (not[notification].type != "Pending") {
			loadFriendRequestNotification(not[notification]);

		} else {
			loadPendingNotification(not[notification]);

		}
	}
	$(".friendRequest")
			.append(
					"<span class=\" glyphicon glyphicon-ok\" onclick='acceptFriendRequest($(this).parent().data(\"user\"),$(this).parent().data(\"notid\")); $(this).closest(\"div\").fadeOut((300, function() { $(this).remove(); })) '></span>");
	$(".friendRequest").append(
			"<span class=\" glyphicon glyphicon-remove\" onclick='rejectFriendRequest($(this).parent().data(\"user\"),$(this).parent().data(\"notid\")); $(this).closest(\"div\").fadeOut((300, function() { $(this).remove(); }))'></span>");

}

$(window).load(function() {

	initNotifications();

});
