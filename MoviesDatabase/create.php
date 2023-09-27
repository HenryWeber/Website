
<?php

// Config file
require_once "config.php";
 
// Define and initialize variables
$title = $genre = $yearMade = $rating = "";
$title_err = $genre_err = $yearMade_err  = $rating_err= "";
 
// Will commense when form is submitted
if($_SERVER["REQUEST_METHOD"] == "POST"){
    
    // Validate title
    $input_title = trim($_POST["title"]);
    if(empty($input_title)){
        $title_err = "Please enter a title.";
    } else{
        $title = $input_title;
    }
    
    // Validate genre
    $input_genre = trim($_POST["genre"]);
    if(empty($input_genre)){
        $genre_err = "Please enter an genre.";     
    } else{
        $genre = $input_genre;
    }
    
    // Validate year
    $input_yearMade = trim($_POST["yearMade"]);
    if(empty($input_yearMade)){
        $yearMade_err = "Please enter the year amount.";     
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
    

    // Check if inputs are empty
    if(empty($title_err) && empty($genre_err) && empty($yearMade_err) && empty($rating_err)){
        // Prepare an insert statement
        $sql = "INSERT INTO movies (title, genre, yearMade, rating) VALUES (?,?,?,?)";
        
         
        if($stmt = mysqli_prepare($link, $sql)){
            

            // Bind variables to the prepared statement as parameters
            mysqli_stmt_bind_param($stmt,"ssss", $param_title, $param_genre, $param_yearMade, $param_rating);
            // Set parameters
            $param_title = $title;
            $param_genre = $genre;
            $param_yearMade = $yearMade;
            $param_rating = $rating;
            
            //Attempt to exec the stmt
            if(mysqli_stmt_execute($stmt)){
                //If successful, go to main page
                header("location: landing.php");
                exit();
            } else{
                echo "Oops! Something went wrong. Please try again later.";
            }
        }
        // Close stmt
        mysqli_stmt_close($stmt);
    }
        
    
    // Close connec
    mysqli_close($link);
}
?>
 
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Create Record</title>
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

                    
                    <!--'Current' page header-->
                    <h2 class="pageName">Create Record</h2>
                    <p>Please fill this form and submit to add movie record to the database.</p>
                    <form action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"]); ?>" method="post">
                    <!--Form formatting-->
                    <div class="form-group">
                            <label>Title</label>
                            <input type="text" name="title" class="form-control " value="<?php echo $title; ?>">
                        </div>
                        <div class="form-group">
                            <label>Genre</label>
                            <input type="text" name="genre" class="form-control" value="<?php echo $genre; ?>">                           
                        </div>
                        <div class="form-group">
                            <label>Year</label>
                            <input type="text" name="yearMade" class="form-control" value="<?php echo $yearMade; ?>">                           
                        </div>
                        <div class="form-group">
                            <label>Rating</label>
                            <input type="text" name="rating" class="form-control" value="<?php echo $rating; ?>">                           
                        </div>
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