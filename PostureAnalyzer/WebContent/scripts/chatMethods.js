/**
 * Chat screen functions
 */
function getCookie(cname) {
	var name = cname + "=";
	var ca = document.cookie.split(';');
	for (var i = 0; i < ca.length; i++) {
		var c = ca[i];
		while (c.charAt(0) == ' ')
			c = c.substring(1);
		if (c.indexOf(name) == 0)
			return c.substring(name.length, c.length);
	}
	return "";
}

function loadFriend(friend, friendId) {
	$("#friendList").append(
			$(
					"<div class=\"panel-body friendTab\" id=\"friendTab\" data-userid="
							+ friendId + "></div>").text(friend));
}

function addText(e) {

	var user = isMyMsg(e);
	console.log(e+"asdasdas");
	if (user == 1) {
		console.log("true");
		$("#" + activeChatWindow).append(
				$("<p class=\"Msg\" ></p>").text(e.value));
	} else {
		if (openChatWindows.length == 0) {
			$('#chat').slideDown();

		}
		if (!windowIsOpened(user.id)) {
			console.log("Added window with id "+ user.id);
			appendChatWindowTab(false, user.name, user.id);
			appendChatWindow(false, user.name, user.id);
			$('#' + user.name + 'Tab').trigger('click');
			
		}
		$("#" + activeChatWindow).append(
				$("<p class=\"Msg\" id=\"recvMsg\"></p>").text(e.value));

	}
	$("#userInput").val("");

}

function sendText(user) {

	var msg = formatText();
	var c= getCookie("userId");
	msg += $("#userInput").val();
	var obj = {
		type : 1,
		from: c,
		to :[$("#" + user).data("userid")],
		value : msg
	};
	console.log("Sending "+  JSON.stringify(obj));
	socket.send(JSON.stringify(obj));

}
function formatText() {
	var date = new Date();

	var text = u;
	text += "[" + date.getDate() + "." + (date.getMonth() + 1) + "."
			+ date.getFullYear() + ":" + date.getHours() + ":"
			+ date.getMinutes() + ":" + date.getSeconds() + "]: ";
	return text;

}

function isMyMsg(e) {

	var msg = "" + e.value;
	console.log(e.value+ "a");
	var user = msg.slice(0, msg.indexOf("["));
	console.log(user + "        " + u);
	if (user == u)
		return 1;

	var obj = {
		id : e.from,
		name : user
	};
	return obj;

}

function openNewConnection() {
	socket = new WebSocket("ws://localhost:8080/socket");

	function makeConnectionParameters() {
		console.log( getCookie("userId"));
		return getCookie("userId");
	}

	socket.onopen = function(event) {
		console.log("Connection is open");
		var obj = {
			type : 0,
			to:[],
			value : makeConnectionParameters()
		};
		socket.send(JSON.stringify(obj));

	};

	socket.onmessage = function(event) {
		console.log("This works");
		var x = event.data;
		console.log(x);
		console.log(eval("(" + x + ")"));

		addText(eval("(" + x + ")"));
	};
	

}

$(window).load(

function() {
	openNewConnection();

	for ( var friend in myFriends) {
		console.log("hello");
		loadFriend(myFriends[friend], friend);
	}
	;
	$("#send").click(function(e) {
		sendText(activeChatWindow);

	});

	$("#userInput").keypress(function(e) {

		if (e.which == 13) {
			e.preventDefault();
			sendText(activeChatWindow);
		}

	});

});
