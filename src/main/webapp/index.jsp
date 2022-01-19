<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login Account</title>
<link href="https://fonts.googleapis.com/css?family=ZCOOL+XiaoWei"
	rel="stylesheet">
<link href="css/style.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<div class="container">
		<div class="box">
			<img class="avatar" src="img/login-user.png">
			<h1>Login Account</h1>
			<form action="login" method="post">
				<p>Username</p>
				<input type="text" placeholder="Username" name="login" required>
				<p>Password</p>
				<input type="password" placeholder="Password" name="password"
					required> <input type="submit" value="Login"> 
					<a href="#">Forget Password?</a><br> 
					<a href="register.jsp">Create New Account</a>
			</form>
		</div>
	</div>
</body>
</html>

