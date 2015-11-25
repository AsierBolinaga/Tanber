<?php
if($_SERVER['REQUEST_METHOD']=='POST')
{
	 $username = $_POST['username']; 
	 $password = $_POST['password']; 
	 $email = $_POST['email'];  
	 $online = $_POST['online'];

	 if($username == '' || $password == '' || $email == '')
	 { 
		echo 'please fill all values'; 
	 }
	 else
	 { 
		require_once('dbConnect.php'); 
		$sql = "SELECT * FROM TanderUsers WHERE email='$email'";  
		$check = mysqli_fetch_array(mysqli_query($con,$sql));  
		if(isset($check))
		{ 
			echo 'This email is already registered in Tander.'; 
		}
		else
		{
			$sql = "SELECT * FROM TanderUsers WHERE username='$username'";  
			$check = mysqli_fetch_array(mysqli_query($con,$sql)); 
			if(isset($check))
			{ 
				echo 'The user name is already in use.'; 
			}
			else
			{
				$sql = "INSERT INTO TanderUsers (username,password,email,online) VALUES ('$username','$password','$email','$online')"; 
				if(mysqli_query($con,$sql))
				{ 
					echo 'successfully registered'; 
				}
				else
				{ 
					echo 'oops! Please try again!'; 
				}
			} 
		} 
		mysqli_close($con); 
	 }
 }
?>

