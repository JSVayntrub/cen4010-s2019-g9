<?php  if (count($error) > 0) : ?>
  <div id="error" class='alert alert-danger'>
  	<?php foreach ($error as $error) : ?>
  	  <p><?php echo $error ?></p>
  	<?php endforeach ?>
  </div>
<?php  endif ?>