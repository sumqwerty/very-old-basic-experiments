<?php session_start(); ob_start(); ?>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Notes Web</title>
        <meta charset="utf-8"/>
        <link rel="stylesheet" type="text/css" href="../css/style.css">
        <script src="../js/scripts.js"></script>
    </head>
    <body onload="getDefaultImageSrc()">
        
        <?php
            if($_SERVER["REQUEST_METHOD"] == "GET"){
                $err=$_GET['err'];
                if($err == 'UAT'){
                    echo '<script>alert("Username Already Taken")</script>';
                }
                else if ($err != ""){
                    echo "<script>alert(\"Error ocuured: '$err'\")</script>";
                }
            }
        ?>
        
        <?php
            include("header.php");
        ?>
        <div class="login">
            <h2>SIGN UP</h2>
            <div class="lineDiv"></div> 
            <div class="spaceThirty"></div>
            <form action="<?php echo htmlentities($_SERVER['PHP_SELF']); ?>" id="signup" method="POST" enctype="multipart/form-data">
                <div class="tipFieldContainer">
                    <img id="userImg" class="userImg" alt="user image" src="../img/userIcon.png">
                    <span class="tipText imgSpanPosition" id="imgTipText">Image required</span>
                    <div class="imgBtnContainer">
                        <img class="imgIcon" alt="img icon" src="../img/pictureIcon.png">
                        <input type="file" id="imgUploadBtn" class="imgUploadBtn" name="userImg" accept="image/*">
                    </div>
                </div>
                <div class="spaceThirty"></div>
                <div class="spaceThirty"></div>
                <div class="inputName"><b>First Name:</b></div>
                <div class="tipFieldContainer">
                    <input type="text" id="fNameField" name="fname" class="inField" placeholder="Username">
                    <span class="tipText" id="fNameTipText">Invalid Email</span>
                </div>
                <div class="spaceThirty"></div>
                <div class="inputName"><b>Last Name:</b></div>
                <div class="tipFieldContainer">
                    <input type="text" id="lNameField" name="lname" class="inField" placeholder="Username">
                    <span class="tipText" id="lNameTipText">Invalid Email</span>
                </div>
                <div class="spaceThirty"></div>
                <div class="inputName"><b>Username:</b></div>
                <div class="tipFieldContainer">
                    <input type="email" id="emailField" name="Uname" class="inField" placeholder="email">
                    <span class="tipText" id="emailTipText">Invalid Email</span>
                </div>
                <div class="spaceThirty"></div>
                <div class="inputName"><b>Password:</b></div>
                <div class="tipFieldContainer">
                    <input type="Password" id="passwordField" name="Pass" class="inField" placeholder="Password">
                    <span class="tipText" id="passwordTipText">Invalid Email</span>
                </div>
                <div class="spaceThirty"></div>
                <div class="inputName"><b>Repeat Password:</b></div>
                <div class="tipFieldContainer">
                    <input type="Password" id="passRepeatField" name="rPass" class="inField" placeholder="Repeat Password">
                    <span class="tipText" id="passwordRepTipText">Invalid Email</span>
                </div>
            </form>
            <div class="spaceThirty"></div>
            <div class="spaceThirty"></div>
            <div class="lineDiv"></div> 
            <input id="signUpBtn" type="button" name="signup" class="logBtn" value="Sign Up">
            <div class="spaceThirty"></div>
        </div>
        <div class="spaceThirty"></div>
        
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="../js/signUp.js"></script>
    </body>
</html>

<?php
    $title = 'User SignUp Page';
    require_once 'connect.php';
    require_once 'signup.php';
?>