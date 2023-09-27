<?php
// Check existence of id parameter before processing further
if(isset($_GET["id"]) && !empty(trim($_GET["id"]))){
    // Include config file
    require_once "config.php";
    
    // Prepare a select statement
    $sql = "SELECT * FROM movies WHERE id = ?";
    
    if($stmt = mysqli_prepare($link, $sql)){
        // Bind variables to the prepared statement as parameters
        mysqli_stmt_bind_param($stmt, "i", $param_id);
        
        // Set parameters
        $param_id = trim($_GET["id"]);
        
        // Attempt to execute the prepared statement
        if(mysqli_stmt_execute($stmt)){
            $result = mysqli_stmt_get_result($stmt);
    
            if(mysqli_num_rows($result) == 1){
                /* Fetch result row as an associative array. Since the result set
                contains only one row, we don't need to use while loop */
                $row = mysqli_fetch_array($result, MYSQLI_ASSOC);
                
                // Retrieve individual field value
                $title = $row["title"];
                $genre = $row["genre"];
                $year = $row["yearMade"];
                $rating = $row["rating"];
            } else{
                // URL doesn't contain valid id parameter. Redirect to error page
                header("location: error.php");
                exit();
            }
            
        } else{
            echo "Oops! Something went wrong. Please try again later.";
        }
    }
     
    // Close statement
    mysqli_stmt_close($stmt);
    
    // Close connection
    mysqli_close($link);
} else{
    // URL doesn't contain id parameter. Redirect to error page
    header("location: error.php");
    exit();
}
?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>View Record</title>
    <link rel="stylesheet" href="style.css"></link>
    <link rel="stylesheet" href="landing_style.css"></link>
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
</div>


                    <h2 class="pageName">View Record</h2>
                    
                    <table>
                        <tbody>
                            <tr>
                                <td>Title</td>
                                <td><?php echo $row["title"]; ?></td>
                            </tr>
                            <tr>
                                <td>Genre</td>
                                <td><?php echo $row["genre"]; ?></td> 
                            </tr>
                            <tr>
                                <td>Year</td>
                                <td><?php echo $row["yearMade"]; ?></td>
                            </tr>
                            <tr>
                                <td>Rating</td>
                                <td><?php echo $row["rating"]; ?></td>
                            </tr>
                        </tbody>
                    </table>

                    <p><a href="landing.php" class="button">Back</a></p>

        <!-- Footer -->
        <div class="footer">
        <h2>Thank you for your time!</h2>
    </div>

</body>
</html>