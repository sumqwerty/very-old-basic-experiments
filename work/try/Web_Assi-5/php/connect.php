<?php
    $servername = "localhost";
    $username = "qwerty";
    $password = "qwerty123";
    $dataBase = "noteTaking";
    
    $connect = new mysqli($servername, $username, $password);
    mysqli_select_db($connect,$dataBase);
    if ($connect->connect_error){
        echo "<script>alert('Database Connection failed $connect->connect_error');</script>";
    }
?>