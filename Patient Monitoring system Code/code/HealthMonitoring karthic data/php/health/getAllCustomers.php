<?php

$con = mysql_connect("localhost","root","password");
if (!$con)
  {
  die('Could not connect: ' . mysql_error());
  }
mysql_select_db("healthmonitoring", $con);

$result = mysql_query("SELECT * FROM heartratemaster");

while($row = mysql_fetch_assoc($result))
  {
	$output[]=$row;
  }

print(json_encode($output));

mysql_close($con);


?>