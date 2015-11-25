<?php

 if($_SERVER['REQUEST_METHOD']=='POST')
 { 
	$username = $_POST['username'];  
	$online = $_POST['online'];  
	 
	require_once('dbConnect.php');  
	
	$sql = "UPDATE TanderUsers SET online = '$online' WHERE username = '$username'";  
	 
	if(mysqli_query($con,$sql))
	{ 
		echo "success";
	}
	else
	{
		echo 'ERROR updating the Data Base'; 
	} 
	
	mysqli_close($con); 
 }
?>