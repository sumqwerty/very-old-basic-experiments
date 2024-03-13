<?php
	$db_host = "localhost";
	$db_user = "username"; 	// your MySQL username
	$db_pwd = "password"; 	// your MySQL password
	$db_db = "database";		// your MySQL database (= your username)
	$chars = "utf8mb4";

	$attr = "mysql:host=$db_host;dbname=$db_db;charset=$chars";
	$opts = [
		PDO::ATTR_ERRMODE				=> PDO::ERRMODE_EXCEPTION,
		PDO::ATTR_DEFAULT_FETCH_MODE	=> PDO::FETCH_ASSOC,
		PDO::ATTR_EMULATE_PREPARES		=> false
	];
?>