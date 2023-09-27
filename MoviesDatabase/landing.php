<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Dashboard</title>
    <link rel="stylesheet" href="style.css"></link>
    <link rel="stylesheet" href="landing_style.css"></link>
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

    <script>
        $(document).ready(function(){
            $('[data-toggle="tooltip"]').tooltip();   
        });
    </script>
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
                    <!--Top of 'current' page-->
                    <div class="pageName">
                        <h2>Movie Details</h2>
                    </div>    
                    <a href="create.php" class="createButton"><b>Add New Movie</b></a>
                
                    <div class="wrapper"> 
                    <?php
                    
                    // Attempt to connect to DB
                    require_once "config.php";
                   
                    //Attempt to run MySQL query in DB
                    $sql = "SELECT * FROM movies";
                    if($result = mysqli_query($link, $sql)){
                        if(mysqli_num_rows($result) > 0){
                            echo '<table>';
                                echo "<thead>";
                                    echo "<tr>";
                                        echo "<th>ID</th>";
                                        echo "<th>Title</th>";
                                        echo "<th>Genre</th>";
                                        echo "<th>Year</th>";
                                        echo "<th>Rating</th>";
                                        echo "<th>View</th>";
                                        echo "<th>Update</th>";
                                        echo "<th>Delete</th>";
                                    echo "</tr>";
                                echo "</thead>";
                                echo "<tbody>";
                                while($row = mysqli_fetch_array($result)){
                                    echo "<tr>";
                                        echo "<td>" . $row['id'] . "</td>";
                                        echo "<td>" . $row['title'] . "</td>";
                                        echo "<td>" . $row['genre'] . "</td>";
                                        echo "<td>" . $row['yearMade'] . "</td>";
                                        echo "<td>" . $row['rating'] . "</td>";
                                    
                                        
                                            echo "<td>" . '<a href="read.php?id='. $row['id'] .'" class="viewButton" title="View Record">View Record</a>' . "</td>";
                                            echo "<td>" . '<a href="update.php?id='. $row['id'] .'" class="updateButton" title="Update Record">Update Record</a>' . "</td>";
                                            echo "<td>" . '<a href="delete.php?id='. $row['id'] .'" class="deleteButton" title="Delete Record">Delete Record</a>' . "</td>";
                                        
                                    echo "</tr>";
                                }
                                echo "</tbody>";                            
                            echo "</table>";

                            // Free result set
                            mysqli_free_result($result);
                        } else{
                            echo 'No records were found.';
                        }
                    } else{
                        echo "Oops! Something went wrong. Please try again later.";
                    }
 
                    // Close connection
                    mysqli_close($link);
                    ?>
                    </div>
    
    <!-- Footer -->
    <div class="footer">
        <h2>Thank you for your time!</h2>
    </div>

</body>
</html>