<?php
    
    if(isset($_REQUEST['pid']))
       {
       $con = mysql_connect("mysql304.ixwebhosting.com","tech2re_root","Welcome123");
       if (!$con)
       {
       die('Could not connect: ' . mysql_error());
       }
       mysql_select_db("tech2re_remotehealth", $con);
       
       $pid = $_REQUEST['pid'];
	   $t = $_GET["t"];
	   $s = $_GET["s"];
	   $h = $_GET["h"];
       
       $result = mysql_query("INSERT INTO `heartratemaster` (`patient_id`,`v`) VALUES ('$pid','$h')") or die('Errant query:');
	   
	   $result = mysql_query("INSERT INTO `stressmaster` (`patient_id`,`v`) VALUES ('$pid','$s')") or die('Errant query:');
	   
	   $result = mysql_query("INSERT INTO `tempmaster` (`patient_id`,`v`) VALUES ('$pid','$t')") or die('Errant query:');
       
       
 }




?>