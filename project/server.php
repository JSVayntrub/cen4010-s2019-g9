<?php

session_start();

$username = "";
$email    = "";

$info = array(); 
$error = array();

$db = mysqli_connect('localhost', 'cen4010fal19_g09', '0mq9AdsJQn', 'cen4010fal19_g09');
    
if (isset($_POST['registerUser'])) 
{
    $email = mysqli_real_escape_string($db, $_POST['email']);
    $username = mysqli_real_escape_string($db, $_POST['username']);
    $userPassword = mysqli_real_escape_string($db, $_POST['password']);
    $userConfirmedPassword = mysqli_real_escape_string($db, $_POST['confirmedPassword']);
    $accountType = '';
    
    $accountTypeButtons = $_POST['accountType'];
    switch($accountTypeButtons)
    {
        case "Student":
        $accountType = "Student";
        break;
        case "Staff":
        $accountType = "Staff";
        break;
        case "Teacher":
        $accountType = "Teacher";
        break;
        default: die("Invalid type!");   
    }
    
    if (empty($email)) { array_push($error, "Email is required."); }
    if (empty($username)) { array_push($error, "Username is required."); }
    if (empty($userPassword)) { array_push($error, "Password is required."); }
    if ($userPassword != $userConfirmedPassword){ array_push($error, "Please make sure that your passwords match."); }
    
    $user_check_query = "SELECT * FROM User WHERE Email='$email' OR Username='$username' LIMIT 1";
    $result = mysqli_query($db, $user_check_query);
    $user = mysqli_fetch_assoc($result);
    
    if ($user)
    {
        if ($user['email'] === $email) 
        {
            array_push($error, "Email already exists.");
        }
        
        if ($user['username'] === $username) 
        {
            array_push($error, "Username already exists.");
        }
    }
    
    if (count($error) == 0) 
    {
        $password = password_hash($userPassword, PASSWORD_BCRYPT);
        $query = "INSERT INTO User (Username, Password,Email, Account_Type) 
  			  VALUES('$username', '$password', '$email', '$accountType')";
        mysqli_query($db, $query);
        $successMessage = $username . " is now registered as a " . $accountType;
        array_push($info, $successMessage); 
        
        $_SESSION['username'] = $username;
        $_SESSION['success'] = "You are now logged in";
        header('location: member.php');
    }
}

if (isset($_POST['loginUser']))
{
    $username = mysqli_real_escape_string($db, $_POST['username']);
    $password = mysqli_real_escape_string($db, $_POST['password']);

    if (empty($username)) { array_push($error, "Username is required."); }
    if (empty($password)) { array_push($error, "Password is required"); }

    if (count($error) == 0) 
    {
        $query = "SELECT * FROM User WHERE Username='$username'";
        $results = mysqli_query($db, $query);
        
        if (mysqli_num_rows($results) == 1) 
        {
            $user = mysqli_fetch_assoc($results);
            if (password_verify($password,$user['Password']))
            {
                $_SESSION['username'] = $username;
                $_SESSION['success'] = "You are now logged in";
                header('location: member.php');
            }
            else
            {
                array_push($error, "Username/password is incorrect.");
            }
        }
        else 
        {
  		    array_push($error, "Username/password is incorrect.");
        }
  }
}

if (isset($_POST['upload'])) 
{
    echo "called";
    $image = $_FILES['image']['name'];
  	$image_text = mysqli_real_escape_string($db, $_POST['image_text']);
    $currentuser = $_SESSION['username'];
  	$target = "images/".basename($image);
    $postType = '';
    
    $postTypeButtons = $_POST['postType'];
    switch($postTypeButtons)
    {
        case "Status":
        $postType = "Status";
        break;
        case "Issue":
        $postType = "Issue";
        break;
        default: die("Invalid type!");   
    }

  	$sql = "INSERT INTO Posts (IMGpath, Text, Username, Post_Type) VALUES ('$image', '$image_text', '$currentuser' , '$postType')";
  	mysqli_query($db, $sql);
      
  	if (move_uploaded_file($_FILES['image']['tmp_name'], $target)) { $msg = "Image uploaded successfully"; }
    else { $msg = "Failed to upload image"; }
}

if(isset($_POST['delete']) and is_numeric($_POST['delete']))
{
    $postToBeDeletedID = $_POST['delete'];
    $sql = "DELETE FROM Posts WHERE ID = '$postToBeDeletedID'";
    mysqli_query($db, $sql); 
}

?>