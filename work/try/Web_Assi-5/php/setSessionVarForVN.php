<?php
    session_start();
    if($_SERVER["REQUEST_METHOD"] == "GET"){
        $_SESSION['note_ID'] = $_GET['note'];
        header("location:contribute.php");
    }
?>