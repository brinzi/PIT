/**
 * Chat screen functions
 */

$(window).load(
		function() {

			for ( var friend in myFriends) {
				loadFriend(myFriends[friend]);
			}

			function loadFriend(friend) {
				$("#friendList").append(
						$("<div class=\"panel-body\" id=\"friendTab\"></div>")
								.text(friend));
			}

			var socket = new WebSocket("ws://localhost:8080/socket");

			socket.onopen = function(event) {

				console.log('Connection open!');

			};

			socket.onmessage = function(event) {
				console.log('event.data');
				addText(event.data);
			};

			function addText(e) {
				console.log(e);
				if (isMyMsg(e)) {
					$("#display").append($("<p class=\"Msg\" ></p>").text(e));
				} else {
					$("#display").append(
							$("<p class=\"Msg\" id=\"recvMsg\"></p>").text(e));
				}
				$("#userInput").val("");

			}

			function sendText() {

				var msg = formatText();
				msg += $("#userInput").val();
				socket.send(msg);

			}
			function formatText() {
				var date = new Date();

				var text = u;
				text += "[" + date.getDate() + "." + (date.getMonth() + 1)
						+ "." + date.getFullYear() + ":" + date.getHours()
						+ ":" + date.getMinutes() + ":" + date.getSeconds()
						+ "]: ";
				return text;

			}

			function isMyMsg(e) {
				var i = e.indexOf("[");
				var user = e.slice(0, i);

				if (user == u)
					return true;

				return false;

			}

			$("#send").click(function(e) {
				sendText();

			});

			$("#userInput").keypress(function(e) {

				if (e.which == 13) {
					e.preventDefault();
					sendText();

				}
			});

		});