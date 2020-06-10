<?php
    
    if(isset($_REQUEST['pid']))
       {
       $con = mysql_connect("mysql304.ixwebhosting.com","tech2re_root","Welcome123");
       if (!$con)
       {
       die('Could not connect: ' . mysql_error());
       }
       mysql_select_db("tech2re_remotehealth", $con);
       
      
       $result = mysql_query("TRUNCATE Table `heartratemaster`") or die('Errant query:');
	   $result = mysql_query("TRUNCATE Table `stressmaster`") or die('Errant query:');
	   $result = mysql_query("TRUNCATE Table `tempmaster`") or die('Errant query:');
      
	}




?>