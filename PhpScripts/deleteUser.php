<?php  
 //Getting Id 
 $id = $_GET['id'];  
 
 //Importing database 
 require_once('dbConnect.php');  
 
 //Creating sql query 
 $sql = "DELETE FROM TanderUser WHERE id=$id;";  
 
 //Deleting record in database  
 if(mysqli_query($con,$sql))
 { 
	echo 'User Deleted Successfully'; 
 }
 else
 { 
	echo 'Could Not Delete user Try Again'; 
 }  
 
 //closing connection 
 mysqli_close($con);
?>