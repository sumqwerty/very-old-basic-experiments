<?php
    if (!isset($_SESSION['user_ID'])){
        echo "<script>alert('erooooor');</script>";
        header("location:loginPage.php?srd=LIF");
        exit;
    }
?>