<?php

if(isset($_POST["id"]) && !empty($_POST["id"])){
    // Include config file
    require_once "config.php";
    
    // Make stmt
    $sql = "DELETE FROM movies WHERE id = ?";
    
    if($stmt = mysqli_prepare($link, $sql)){
        // make stmt
        mysqli_stmt_bind_param($stmt, "i", $param_id);
        
        // Set params
        $param_id = trim($_POST["id"]);
        
        // Attempt to run stmt
        if(mysqli_stmt_execute($stmt)){
            // Redirect to landing
            header("location: landing.php");
            exit();
        } else{
            echo "Oops! Something went wrong. Please try again later.";
        }
    }
     
    // Close stmt
    mysqli_stmt_close($stmt);
    
    // Close connec
    mysqli_close($link);
} else{
    // Check if id exists
    if(empty(trim($_GET["id"]))){
        // error msg
        header("location: error.php");
        exit();
    }
}
?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Delete Record</title>
    <link rel="stylesheet" href="landing_style.css"></link>
    <link rel="stylesheet" href="style.css"></link>
    
</head>
<body style="background: #1abc9c;">
    <!-- Header -->
<div class="header">
  <h1>Henry Weber's Website/Portfolio</h1>
  
</div>

<!-- Navigation Bar -->
<div class="navbar">
  <a href="index.html">Home</a>
  <a href="weather.html">Weather Application</a>
  <a href="login.html">Login Profile</a>
  <a href="landing.php">Movie Database</a>
  <a href="datastructures.html">Guessing Game</a>
</div>


                    <h2 class="pageName">Delete Record</h2>
                    <!--Form formatting-->
                    <form action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"]); ?>" method="post">
                        <div class="alert alert-danger">
                            <input type="hidden" name="id" value="<?php echo trim($_GET["id"]); ?>"/>
                            <p style="text-align:center;">Are you sure you want to delete this movie record?</p>
                            <p>
                                <input type="submit" value="Yes" class="button">
                                <a href="landing.php" class="button">No</a>
                            </p>
                        </div>
                    </form>


        <!-- Footer -->
        <div class="footer">
        <h2>Thank you for your time!</h2>
    </div>
</body>
</html>