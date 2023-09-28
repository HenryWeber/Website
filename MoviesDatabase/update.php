<?php
// Include config file
require_once "config.php";
 
// Define vars and init
$title = $genre = $yearMade = $rating = "";
$title_err = $genre_err = $yearMade_err = $rating_err = "";
 
// Form Data
if(isset($_POST["id"]) && !empty($_POST["id"])){  
    // Get hidden input value
    $id = $_POST["id"];
    // Validate title
    $input_title = trim($_POST["title"]);
    if(empty($input_title)){
        $title_err = "Please enter a title.";
    } else{
        $title = $input_title;
    }
    
    // Validate genre genre
    $input_genre = trim($_POST["genre"]);
    if(empty($input_genre)){
        $genre_err = "Please enter a genre.";     
    } else{
        $genre = $input_genre;
    }
    
    // Validate yearMade
    $input_yearMade = trim($_POST["yearMade"]);
    if(empty($input_yearMade)){
        $yearMade_err = "Please enter the yearMade amount.";     
    } else{
        $yearMade = $input_yearMade;
    }

        // Validate rating
        $input_rating = trim($_POST["rating"]);
        if(empty($input_rating)){
            $rating_err = "Please enter the rating amount.";     
        } else{
            $rating = $input_rating;
        }

    // Check if empty
    if(empty($title_err) && empty($genre_err) && empty($yearMade_err) && empty($rating_err)){
        // Prepare an update statement
        $sql = "UPDATE movies SET title=?, genre=?, yearMade=?, rating=? WHERE id=?";
         
        if($stmt = mysqli_prepare($link, $sql)){
            // Make stmt
            mysqli_stmt_bind_param($stmt, "ssssi", $param_title, $param_genre, $param_yearMade, $param_rating, $param_id);
            
            // Set params
            $param_title = $title;
            $param_genre = $genre;
            $param_yearMade = $yearMade;
            $param_rating = $rating;
            $param_id = $id;
            
            // Attempt to exec stmt
            if(mysqli_stmt_execute($stmt)){
                //Redirect to landing pg
                header("location: landing.php");
                exit();
            } else{
                echo "Please try again later, error.";
            }
        }
         
        // Close stmt
        mysqli_stmt_close($stmt);
    }
    
    // Close connec
    mysqli_close($link);
} else{
    // id check
    if(isset($_GET["id"]) && !empty(trim($_GET["id"]))){
        
        // URL parameter
        $id =  trim($_GET["id"]);
        
        // stmt
        $sql = "SELECT * FROM movies WHERE id = ?";
        if($stmt = mysqli_prepare($link, $sql)){
            // Make stmt
            mysqli_stmt_bind_param($stmt, "i", $param_id);
            
            // Set param
            $param_id = $id;
            
            // Run stmt
            if(mysqli_stmt_execute($stmt)){
                $result = mysqli_stmt_get_result($stmt);
    
                if(mysqli_num_rows($result) == 1){
                    /* Fetch result row as an associative array*/
                    $row = mysqli_fetch_array($result, MYSQLI_ASSOC);
                    
                    // Retrieve values
                    $title = $row["title"];
                    $genre = $row["genre"];
                    $yearMade = $row["yearMade"];
                    $rating = $row["rating"];
                } else{
                    // Redirect to error pg
                    header("location: error.php");
                    exit();
                }
                
            } else{
                echo "Please try again later, error";
            }
        }
        
        // Close stmt
        mysqli_stmt_close($stmt);
        
        // Close connec
        mysqli_close($link);
    }  else{
        //Redirect to error pg
        header("location: error.php");
        exit();
    }
}
?>
 
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Update Record</title>
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
  <a href="datastructures.html">Guessing Game</a>
</div>
    <div class="">
                    <h2 class="pageName">Update Record</h2>
                    <p>Submit to update the movie record.</p>
                    
                    <!--Form formatting-->
                    <form action="<?php echo htmlspecialchars($_SERVER['REQUEST_URI']); ?>" method="post">
                        <div class="form-group">
                            <label>Title</label>
                            <input type="text" name="title" value="<?php echo $title; ?>">
                        </div>
                        <div class="form-group">
                            <label>Genre</label>
                            <input type="text" name="genre" value="<?php echo $genre; ?>">
                        </div>
                        <div class="form-group">
                            <label>Year</label>
                            <input type="text" name="yearMade" value="<?php echo $yearMade; ?>">
                        </div>
                        <div class="form-group">
                            <label>Rating</label>
                            <input type="text" name="rating" value="<?php echo $rating; ?>">
                        </div>             
                        <!--Keep id hidden from users on site-->           
                        <input type="hidden" name="id" value="<?php echo $id; ?>"/>
                        <!--Buttons-->
                        <input type="submit"  class="button" value="Submit">
                        <a href="landing.php" class="button">Cancel</a>
                    </form>

    <!-- Footer -->
    <div class="footer">
        <h2>Thank you for your time!</h2>
    </div>

</body>
</html>