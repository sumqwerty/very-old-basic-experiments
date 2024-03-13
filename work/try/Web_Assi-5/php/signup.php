<?php
    if($_SERVER["REQUEST_METHOD"] == "POST"){
        try{
            $fname=$_POST['fname'];
            $lname=$_POST['lname'];
            $email=$_POST['Uname'];
            $pass=$_POST['Pass'];

            $target_dir = "../uploadedImg/";
            $target_file = $target_dir. basename($_FILES["userImg"]["name"]);
            $uploadOk = 1;

            if (file_exists($target_file)) {
                $uploadOk = 0;
                echo "<script>alert('Sorry, file already exists.');</script>";
            }

            if ($_FILES["userImg"]["size"] > 2000000) {
                $uploadOk = 0;
                echo "<script>alert('Sorry, your file is too large.');</script>";
            }

            if ($uploadOk == 0){
                echo "<script>alert('Sorry, your file was not uploaded.');</script>";
            }
            else{
                if (!move_uploaded_file($_FILES["userImg"]["tmp_name"], $target_file)) {
                    $uploadOk = 0;
                    echo "<script>alert('Sorry, there was an error uploading your file.');</script>";
                }
            }
            // $eoo = $_FILES;
            // echo "<div><pre>"; print_r($eoo);echo "</pre></div>";
            
            if ($uploadOk != 0) {
                $query="select * from user where email='$email'";
                $result = $con->query($query);
                $sname = $fname.' '.$lname;

                if($result->num_rows == 1){
                    header('location:SignupPage.php?err=UAT');
                }
                else{
                    $reg= "insert into user(screen_name, email, img_URL, password) values('$sname','$email','$target_file','$pass')";	
                    mysqli_query($con,$reg);

                    session_destroy();
                    session_start();
                    header('location:loginPage.php?srd=SUS');
                    exit();
                }
            }
        }

        //catch exception
        catch(Exception $e) {
            $err = $e->getMessage();

            header("location:SignupPage.php?err='$err'");
        }
    }
?>