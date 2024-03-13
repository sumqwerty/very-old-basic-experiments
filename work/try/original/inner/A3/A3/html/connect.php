<?php
    $servername = "localhost";
    $username = "qwerty";
    $password = "qwerty123";
    $dataBase = "noteTaking";
    
    $con = new mysqli($servername, $username, $password);
    mysqli_select_db($con,$dataBase);
    if ($con->connect_error){
        echo "<script>alert('Database Connection failed $con->connect_error');</script>";
    }
?>