<?php

 if($_SERVER['REQUEST_METHOD']=='POST')
 { 
	//Getting values  
	$id = $_POST['id']; 
	$name = $_POST['name']; 
	$username = $_POST['username']; 
	$password = $_POST['password']; 
	$email = $_POST['email'];  
	
	//importing database connection script  
	require_once('dbConnect.php');  
	
	//Creating sql query  
	$sql = "UPDATE TanderUser SET name = '$name', username = '$username', password = '$password', email = '$email' WHERE id = $id;";  
	
	//Updating database table  
	if(mysqli_query($con,$sql))
	{ 
		echo 'User Updated Successfully'; 
	}
	else
	{
		echo 'Could Not Update user Try Again'; 
	}  //closing connection  
	
	mysqli_close($con); 
 }
?>