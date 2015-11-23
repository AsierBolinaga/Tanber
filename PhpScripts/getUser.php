<?php
	$username = $_POST['username'];
	$password = $_POST['password'];
	 
	require_once('dbConnect.php');
	$sql = "SELECT * FROM TanderUsers WHERE username='$username' and password='$password'";

	$res = mysqli_query($con,$sql);
	
	$result = array();
	$row = mysqli_fetch_array($res);

	if(isset($row))
	{
		array_push($result,array(
			"name"=>$row['name'],
			"username"=>$row['username'],
			"email"=>$row['email']
			));
		echo json_encode(array('result'=>$result));
	}
	else	
	{
		echo "Invalid Username or Password";
	}
	
	mysqli_close($con);
?>