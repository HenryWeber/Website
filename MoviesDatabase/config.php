<?php
// DB creds
define('DB_SERVER', 'localhost');
define('DB_USERNAME', 'henrifiw_user');
define('DB_PASSWORD', 'MyTestingPassword10!');
define('DB_NAME', 'henrifiw_movies');
 
// Attempt to conn to DB
$link = mysqli_connect(DB_SERVER, DB_USERNAME, DB_PASSWORD, DB_NAME);
 
// Check connec
if($link === false){
    die("ERROR: Could not connect. " . mysqli_connect_error());
}


?>