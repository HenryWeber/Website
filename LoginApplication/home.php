<?php
// We need to use sessions, so you should always start sessions using the below code.
session_start();
// If the user is not logged in redirect to the login page...
if (!isset($_SESSION['loggedin'])) {//The isset() function will check if a particular variable is declared and therefore prevent such errors from occurring, especially when dealing with HTTP methods.
	header('Location: login.html');
	exit;
}
?>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>Login Project</title>
		<link href="style.css" rel="stylesheet" type="text/css">
		<link href="login_style.css" rel="stylesheet" type="text/css">
	</head>
	<body>
		
	<div class="wrapper">
        <!-- Header -->
        <div class="header">
          <h1>Login Project</h1>
        </div>
	    <!-- Navigation Bar -->
		<div class="navbar">
			<a href="profile.php" class="button">Profile</a>
			<a href="logout.php"  class="button">Logout</a>
        </div>
		
			<h2>Home Page</h2>
			<p>Welcome back, <?=$_SESSION['name']?>!</p>
		
	</div>
	    <!-- Footer -->
		<div class="footer">
          <h2>Thank you for your time!</h2>
        </div>


		

	</body>
</html>