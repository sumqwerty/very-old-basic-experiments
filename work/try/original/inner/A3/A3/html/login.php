<?php
    if($_SERVER["REQUEST_METHOD"] == "POST"){
        try{
            session_destroy();
            session_start();
            $email=$_POST['Uname'];
            $pass=$_POST['Pass'];
            $query="SELECT * FROM user WHERE email='$email'";
            $result = $con->query($query);
            if($result->num_rows == 1){
                $query="SELECT * FROM user WHERE email='$email' AND password='$pass'";
                $result = $con->query($query);
                if ($result->num_rows == 1){
                    $_SESSION['username'] = $email;
                    $_SESSION['user_ID'] = $result->fetch_assoc()['user_ID'];
                    header('location:NoteList.php?mnl=LIS');
                    exit();
                }
                else
                    echo "<script>document.getElementById('passwordTipText').innerHTML = 'Wrong Password';
                    showTip(document.getElementById('passwordTipText'));</script>";
            }
            else{
                echo "<script>document.getElementById('emailTipText').innerHTML = 'Email Not Found';
                showTip(document.getElementById('emailTipText'));</script>";
            }
        }

        //catch exception
        catch(Exception $e) {
            $err = $e->getMessage();
            echo "<script>alert('Internal server error: $err');</script>";
        }
    }
?>