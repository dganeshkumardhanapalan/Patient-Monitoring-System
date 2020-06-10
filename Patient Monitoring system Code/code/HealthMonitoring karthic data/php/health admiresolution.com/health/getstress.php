<?php
    
    if(isset($_REQUEST['patientid']))
       {
       $con = mysql_connect("mysql304.ixwebhosting.com","tech2re_root","Welcome123");
       if (!$con)
       {
       die('Could not connect: ' . mysql_error());
       }
       mysql_select_db("tech2re_remotehealth", $con);
       
       $pid = $_REQUEST['patientid'];
       
       $result = mysql_query("SELECT v FROM stressmaster WHERE patient_id = '$pid' order by datetime") or die('Errant query:');
       
       
       while($row = mysql_fetch_assoc($result))
       {
       $output[]=$row;
       
       }
       
       print(json_encode($output));
       
       mysql_close($con);
       }
    else
       {
       $output = "not found";
       print(json_encode($output));
       }




?>