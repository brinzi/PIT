<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>	
<meta charset="ISO-8859-1">

<link rel="stylesheet" type="text/css" href="css/mainStyle.css">
<link rel="stylesheet" type="text/css" href="css/formStyles.css">


<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="scripts/transitionScript.js"></script>





<title>MainPage</title>
</head>
<body>

<div class="container">


	<div class="header">
			
			
		</div>
		
		<div class="navi">
		
			<ul class= "navigation_bar">
 			
				<li id="changeNew">New</li>
				<li>Politic</li>
				<li id="changeCars">Cars </li>
				<li>Social .. </li>
				
			</ul>
			
			
		</div>

		<div class= "content">
		
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
		
		
			<div class= "topics"  id="cars">
		
	
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
			
			<div  class="display">
			
			
			</div>
			
			<form method="post" action="">
					<p><input type="text" name="textArea" value="" placeholder="Text "></p>
					<p class="submit"><input type="submit" name="commit" value="Send"></p>
			</form>
		</div>			
			
		

		
		<div class="footer">
			THERE WILL BE A FOOTER HERE
		</div>
</div>		
</body>
</html>