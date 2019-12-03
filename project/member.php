<?php include('server.php') ?>
<!DOCTYPE html>
<html>
<head>
    <!-- Global site tag (gtag.js) - Google Analytics -->
<script async src="https://www.googletagmanager.com/gtag/js?id=UA-153664042-1"></script>
<script>
  window.dataLayer = window.dataLayer || [];
  function gtag(){dataLayer.push(arguments);}
  gtag('js', new Date());

  gtag('config', 'UA-153664042-1');
</script>

  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">
<title>Member Area</title>
    
  <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
  <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">
  <link href="https://fonts.googleapis.com/css?family=Lato:400,700,400italic,700italic" rel="stylesheet" type="text/css">
  <link href="css/styles.css" rel="stylesheet">
<style type="text/css">
   #content{
   	width: 50%;
   	margin: 20px auto;
   	border: 0px solid #cbcbcb;
   }
   form{
   	width: 50%;
   	margin: 20px auto;
   }
   form div{
   	margin-top: 5px;
   }
   #img_div{
   	width: 80%;
   	padding: 5px;
   	margin: 15px auto;
   	border: 5px solid #CC0000;
   }
   #img_div:after{
   	content: "";
   	display: block;
   	clear: both;
   }
   img{
   	float: CENTER;
   	margin: 5px;
   	width: 90%;
   	height: 140px;
   }
</style>
</head>
<body>
<nav class="navbar navbar-expand-lg bg-secondary text-uppercase fixed-top" id="mainNav">
    <div class="container">
      <a class="navbar-brand js-scroll-trigger" href="index.php">Campus Times</a>
      <button class="navbar-toggler navbar-toggler-right text-uppercase font-weight-bold bg-primary text-white rounded" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
        Menu
        <i class="fas fa-bars"></i>
      </button>
      <div class="collapse navbar-collapse" id="navbarResponsive">
        <ul class="navbar-nav ml-auto">
          <li class="nav-item mx-0 mx-lg-1">
            <a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger" href="index.php">Logout</a>
          </li>

        </ul>
      </div>
    </div>
  </nav>
    
  <header class="masthead bg-primary text-white text-center">
    <div class="container d-flex align-items-center flex-column">
      <h2 class="page-section-heading text-center text-uppercase text-secondary mb-0">Members Area</h2>
      <div class="divider-custom">
        <div class="divider-custom-line"></div>
        <div class="divider-custom-icon">
          <i class="fas fa-star"></i>
        </div>
        <div class="divider-custom-line"></div>
      </div>
      <div class="container">
      <div class="row">
        <div class="col-lg-8 mx-auto">
            <form method="POST" action="member.php" enctype="multipart/form-data">
  	<input type="hidden" name="size" value="1000000">
  	<div>
  	  <input type="file" name="image" accept="image/*">
  	</div>
  	<div>
      <textarea 
      	id="text" 
      	cols="40" 
      	rows="4" 
      	name="image_text" 
      	placeholder="Please post your update."></textarea>
  	</div>
                <div>
                    <input type="radio" name="postType" value="Status" checked> Status
                <input type="radio" name="postType" value="Issue"> Issue 
                </div>
  	<div>
  		<button class="btn btn-primary btn-xl" type="submit" name="upload">POST</button>
  	</div>
  </form>
<div id="content">
  <?php
    $result = mysqli_query($db, "SELECT *
FROM `Posts`
ORDER BY `Posts`.`ID` DESC");
    while ($row = mysqli_fetch_array($result)) 
    {
        echo "<div id='img_div'>";
        if ($row['IMGpath'] !== '')
        {
            echo "<img src='images/".$row['IMGpath']."' >";
        }
        echo "<p id='text'>".$row['Text']. " - " .$row['Username']. " - " .$row['Post_Type']."</p>";
        if($row['Username'] == $_SESSION['username'])
        {
            echo "<form method='POST' action='member.php' enctype='multipart/form-dat'>";
            echo "<button class='btn btn-primary btn-l' type='submit' name='delete' value='".$row['ID']."'>Delete</button>";
            echo "</form>";
        }
        echo "</div>";
    }
  ?>
</div>


    </div></div></div></div></header>
    <script src="vendor/jquery/jquery.min.js"></script>
  <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
  <script src="vendor/jquery-easing/jquery.easing.min.js"></script>
  <script src="js/jqBootstrapValidation.js"></script>
  <script src="js/contact_me.js"></script>
  <script src="js/freelancer.min.js"></script>
</body>
</html>