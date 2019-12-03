<?php include('server.php') ?>
<!DOCTYPE html>
<html lang="en">

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

  <title>Campus Times</title>

  <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
  <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">
  <link href="https://fonts.googleapis.com/css?family=Lato:400,700,400italic,700italic" rel="stylesheet" type="text/css">
  <link href="css/styles.css" rel="stylesheet">

</head>

<body id="page-top">

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
            <a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger" href="login.php">Login</a>
          </li>
          <li class="nav-item mx-0 mx-lg-1">
            <a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger" href="register.php">Register</a>
          </li>
        </ul>
      </div>
    </div>
  </nav>

  <header class="masthead bg-primary text-white text-center">

    <div class="container d-flex align-items-center flex-column">
      <h2 class="page-section-heading text-center text-uppercase text-secondary mb-0">Register</h2>
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
          <form name="registerUser" action="register.php" method="post">
            <div class="control-group">
              <div class="form-group floating-label-form-group controls mb-0 pb-2">
                <label>Email:</label>
                <input class="form-control" name="email" type="text" placeholder="Email">
            </div>
                
            <div class="control-group">
              <div class="form-group floating-label-form-group controls mb-0 pb-2">
                <label>Username:</label>
                <input class="form-control" name="username" type="text" placeholder="Username">
            </div>

            <div class="control-group">
              <div class="form-group floating-label-form-group controls mb-0 pb-2">
                <label>Password:</label>
                <input class="form-control" name="password" type="password" placeholder="Password">
              </div>
            </div>

            <div class="control-group">
              <div class="form-group floating-label-form-group controls mb-0 pb-2">
                <label>Confirm Password:</label>
                <input class="form-control" name="confirmedPassword" type="password" placeholder="Confirm Password">
              </div>
            </div>

            <div class="control-group">
              <div class="form-group floating-label-form-group controls mb-0 pb-2">
                <label>Account Type:</label>
                <input type="radio" name="accountType" value="Student" checked> Student
                <input type="radio" name="accountType" value="Staff"> Staff   
                <input type="radio" name="accountType" value="Teacher"> Teacher  
              </div>
            </div>

            <br>

            <?php include('info.php') ?>
            <?php include('error.php') ?>
            <div class="form-group">
              <button type="submit" class="btn btn-primary btn-xl" name="registerUser">Register</button>
            </div>

          </form>
        </div>
      </div>
    </div>
    </div>
  </header>


  <script src="vendor/jquery/jquery.min.js"></script>
  <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
  <script src="vendor/jquery-easing/jquery.easing.min.js"></script>
  <script src="js/jqBootstrapValidation.js"></script>
  <script src="js/contact_me.js"></script>
  <script src="js/freelancer.min.js"></script>

</body>
</html>
