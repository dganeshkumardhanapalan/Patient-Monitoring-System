<?php
    
    if(isset($_REQUEST['pid']))
       {
       $con = mysql_connect("localhost","root","password");
       if (!$con)
       {
       die('Could not connect: ' . mysql_error());
       }
       mysql_select_db("healthmonitoring", $con);
       
       $pid = $_REQUEST['pid'];
	   $dip = $_GET["did"];
	   $des = $_GET["desc"];
       
       $result = mysql_query("INSERT INTO `descmaster` (`patient_id`,`doctor_id`, `description`) VALUES ('$pid','$dip','$des')") or die('Errant query:');
       
       
 }




?>