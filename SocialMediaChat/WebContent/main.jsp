<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">

<link rel="stylesheet" type="text/css" href="css/mainStyle.css">
<link rel="stylesheet" type="text/css" href="css/formStyles.css">
<link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.min.css">


<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="scripts/transitionScript.js"></script>
<script src="scripts/chatMethods.js"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>


<title>MainPage</title>
</head>
<body>

	
<nav class="navbar navbar-default">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">SocialChat</a>
    </div>
    <div>
      <ul class="nav navbar-nav">
        <li class="active"><a href="#">Home</a></li>
        <li><a href="#">Page 1</a></li>
        <li><a href="#">Page 2</a></li> 
        <li><a href="#">Page 3</a></li> 
      </ul>
    </div>
  </div>
</nav>

		<div class="header">

			<p class="currentUser">Welcome, ${currentUser.name }</p>
			<script>
				var u = "${currentUser.email }";
			</script>
			<%
				
			%>
		</div>

		<div class="navi">

			<ul class="navigation_bar">

				<li id="changeNew">New</li>
				<li>Politic</li>
				<li id="changeCars">Cars</li>
				<li>Social ..</li>

			</ul>


		</div>

		<div class="content">

			<div class="topics" id="new">

				<div class="topic">
					<p>New stuff</p>
				</div>

				<div class="topic">
					<p>New stuff</p>
				</div>
				<div class="topic">
					<p>New stuff</p>
				</div>
				<div class="topic">
					<p>New stuff</p>
				</div>

			</div>


			<div class="topics" id="cars">


				<div class="topic">
					<p>Topics about cars</p>
				</div>

				<div class="topic">
					<p>Topics about cars</p>
				</div>
				<div class="topic">
					<p>Topics about cars</p>
				</div>
				<div class="topic">
					<p>Topics about cars</p>
				</div>

			</div>
		</div>
		<div class="chat">
			<h1>Live discussions</h1>

			<div id="display"></div>

			<form action="">
				<input id="userInput" type="text" name="textArea"
					placeholder="Text " autocomplete="off"> <input
					class="subimt" id="send" type="button" name="commit" value="Send">
			</form>
		</div>




		<div class="footer">THERE WILL BE A FOOTER HERE</div>

</body>
</html>