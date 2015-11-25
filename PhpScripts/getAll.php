<?php 
 require_once('dbConnect.php');  
 
 $sql = "SELECT * FROM TanderUsers"; 
 
 $r = mysqli_query($con,$sql);  
   
 $result = array(); 
  
 while($row = mysqli_fetch_array($r))
 {  
	array_push($result,array(
	"username"=>$row['username'],
	"online"=>$row[online],
	)); 
 }  
  
 echo json_encode(array('result'=>$result)); 

 mysqli_close($con);
?>