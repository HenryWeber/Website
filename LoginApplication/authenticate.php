<?php
session_start();
// Connec info
$DATABASE_HOST = 'localhost';
$DATABASE_USER = 'henrifiw_user';
$DATABASE_PASS = 'MyTestingPassword10!';
$DATABASE_NAME = 'henrifiw_phplogin';
// Attempt to connec
$con = mysqli_connect($DATABASE_HOST, $DATABASE_USER, $DATABASE_PASS, $DATABASE_NAME);
if ( mysqli_connect_errno() ) {
	// Display specific error
	exit('Could not connect to MySQL DB: ' . mysqli_connect_error());
}
//Check if the data exists(isset()).
if ( !isset($_POST['username'], $_POST['password']) ) {
	// Empty inputs
	exit('Please enter the username and password (one or more may be empty)');
}
// Prepare our SQL, preparing the SQL statement will prevent SQL injection.
if ($stmt = $con->prepare('SELECT id, password FROM accounts WHERE username = ?')) {
	// Bind params s = string, i = int
	$stmt->bind_param('s', $_POST['username']);
	$stmt->execute();
	// Check if account exists in DB
	$stmt->store_result();
	
    
    if ($stmt->num_rows > 0) {
        $stmt->bind_result($id, $password);
        $stmt->fetch();

        //use password_hash in registration file to store the hashed passwords
        if (password_verify($_POST['password'], $password)) { //password encryption method
            
            // Create sessions, so we know the user is logged in, they basically act like cookies but remember the data ON THE SERVER.
            session_regenerate_id();//session_regenerate_id() helps prevent session hijacking while it regens the user's session ID that is stored on the server and as a cookie in the browser.
            $_SESSION['loggedin'] = TRUE;
            $_SESSION['name'] = $_POST['username'];
            $_SESSION['id'] = $id;
            header('Location: home.php');
        } else {
            // Wrong password
            echo 'Incorrect username and/or password!';
        }
    } else {
        // Wrong username
        echo 'Incorrect username and/or password!';
    }
    $stmt->close();
}
?>