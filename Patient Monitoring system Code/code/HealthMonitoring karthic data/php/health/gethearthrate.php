<?php
    
    if(isset($_REQUEST['patientid']))
       {
       $con = mysql_connect("localhost","root","password");
       if (!$con)
       {
       die('Could not connect: ' . mysql_error());
       }
       mysql_select_db("healthmonitoring", $con);
       
       $pid = $_REQUEST['patientid'];
       
       $result = mysql_query("SELECT v FROM heartratemaster WHERE patient_id = '$pid' order by datetime") or die('Errant query:');
       
       
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