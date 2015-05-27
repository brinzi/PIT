<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/loginStyle.css">
<link rel="stylesheet" type="text/css" href="css/formStyles.css">
<title>Welcome</title>
</head>


<body>


<div class="container">
  <div class="login">
    <h1>Login</h1>
    <form method="GET" action="logIn">
      <p><input type="text" name="login" value="" placeholder="Username "></p>
      <p><input type="password" name="password" value="" placeholder="Password"></p>
      <p class="submit">
      			<input type="submit" name="commit" value="Register" >
      			<input type="submit" name="commit" value="Login" ></p>
    </form>
  </div>
  
  
  <div class="logo">
		<img src="./Images/logo.png" >
  </div>
  
</div>

</body>
</html>