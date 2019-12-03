<?php  if (count($info) > 0) : ?>
  <div id="success" class='alert alert-success'>
  	<?php foreach ($info as $info) : ?>
  	  <p><?php echo $info ?></p>
  	<?php endforeach ?>
  </div>
<?php  endif ?>