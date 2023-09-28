<?php
// Start session
session_start();
// Not logged in, go to login pg
if (!isset($_SESSION['loggedin'])) {
	header('Location: login.html');
	exit;
}
$DATABASE_HOST = 'localhost';
$DATABASE_USER = 'henrifiw_user';
$DATABASE_PASS = 'MyTestingPassword10!';
$DATABASE_NAME = 'henrifiw_phplogin';
$con = mysqli_connect($DATABASE_HOST, $DATABASE_USER, $DATABASE_PASS, $DATABASE_NAME);
if (mysqli_connect_errno()) {
	exit('Failed to connect to MySQL: ' . mysqli_connect_error());
}
// Get the results from the database.
$stmt = $con->prepare('SELECT password, email FROM accounts WHERE id = ?');
// Use account ID to get the account info.
$stmt->bind_param('i', $_SESSION['id']);
$stmt->execute();
$stmt->bind_result($password, $email);
$stmt->fetch();
$stmt->close();
?>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>Profile Page</title>
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
				<a href="logout.php" class="button">Logout</a>
			</div>			

			<h2>Profile Page</h2>
			<div>
				<p>Your account details are the following:</p>
				<table>
					<tr>
						<td>Username:</td>
						<td><?=$_SESSION['name']?></td>
					</tr>
					<tr>
						<td>Password:</td>
						<td><?=$password?></td>
					</tr>
					<tr>
						<td>Email:</td>
						<td><?=$email?></td>
					</tr>
				</table>
			</div>
	</div>
				<!-- Footer -->
				<div class="footer">
					<h2>Thank you for your time!</h2>
			  	</div>
</body>
</html>