<?php
session_start();
session_destroy();
// Redirect to the login pg:
header('Location: login.html');
?>