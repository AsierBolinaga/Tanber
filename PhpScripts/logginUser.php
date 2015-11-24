<?php
 if($_SERVER['REQUEST_METHOD']=='POST')
 {
	 $username = $_POST['username']; 
	 $password = $_POST['password'];
	   
	 require_once('dbConnect.php');
 
	 $sql = "SELECT * FROM TanderUsers WHERE username='$username' and password='$password'";
	 
	 $check = mysqli_fetch_array(mysqli_query($con,$sql));
	 
	 if(isset($check))
	 {
		 echo "successfully logged";
	 }
	 else
	 {
		 echo "Invalid Username or Password";
	 }
 }
 else
 {
	 echo "error try again";
 }
?>