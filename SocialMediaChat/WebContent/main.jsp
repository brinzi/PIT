<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">


<link rel="stylesheet" type="text/css" href="css/mainStyle.css">
<link rel="stylesheet" type="text/css" href="css/formStyles.css">
<link rel="stylesheet" type="text/css"
	href="bootstrap/css/bootstrap.min.css">

<link rel="stylesheet" type="text/css" href="css/bootstrap.css">



<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="scripts/transitionScript.js"></script>
<script src="scripts/chatMethods.js"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>
<script>
	var u = "${currentUser.name }";
</script>


<title>MainPage</title>
</head>
<body>


	<div class="container-fluid">
		<nav class="navbar navbar-default" style="margin:0">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">SocialChat</a>
			</div>
			<div>
				<ul class="nav navbar-nav">
					<li class="active"><a href="#">Home</a></li>
					<li id="changeNew"><a href="#">Page 1</a></li>
					<li id="changeCars"><a href="#">Page 2</a></li>
					<li><a href="#">Page 3</a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li><a href="#">${currentUser.name }, log out</a></li>

				</ul>
			</div>
		</div>
		</nav>




		<div class="container-fluid ">

			<div class="topics col-md-8" id="new">

				<div class="well topic">
					<p>Topics about new</p>
				</div>


				<div class="well topic">
					<p>Topics about new</p>
				</div>
				<div class="well topic">
					<p>Topics about new</p>
				</div>
				<div class="well topic">
					<p>Topics about new</p>
				</div>
				<div class="well topic">
					<p>Topics about new</p>
				</div>

			</div>


			<div class="col-md-8 topics" id="cars">


				<div class="well topic">
					<p>Topics about cars</p>
				</div>

				<div class="well topic">
					<p>Topics about cars</p>
				</div>
				<div class="well topic">
					<p>Topics about cars</p>
				</div>
				<div class="well topic">
					<p>Topics about cars</p>
				</div>


			</div>

			<div class="col-md-4 chat">
				<h1>Live discussions</h1>

				<div id="display"></div>

				<form action="">
					<input id="userInput" type="text" name="textArea"
						placeholder="Text " autocomplete="off"> <input
						class="subimt" id="send" type="button" name="commit" value="Send">
				</form>
			</div>
		</div>




		<div class="footer">THERE WILL BE A FOOTER HERE</div>
	</div>

</body>
</html>