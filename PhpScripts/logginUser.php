<?php
 if($_SERVER['REQUEST_METHOD']=='POST')
 {
	 $username = $_POST['username']; 
	 $password = $_POST['password'];
	   
	 require_once('dbConnect.php');
 
	 $sql = "SELECT * FROM TanderUsers WHERE username='$username' and password='$password'";
	 
	 $r = mysqli_fetch_array(mysqli_query($con,$sql));
	   
	 $result = array(); 
	 
	 array_push($result,array("id"=>$r['id']));
	 
	 if(isset($r))
	 {
		 echo json_encode(array('result'=>$result));
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