<?php session_start(); ?>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Login Form</title>
        <link rel="stylesheet" type="text/css" href="../css/style.css">
        <script src="../js/scripts.js"></script>
        <meta charset="utf-8"/>
    </head>
    <body>
        <!-- Menu bar items -->
        <div class="menubar">
            <a class="barItem">Log in</a>
            <a class="barItem" href="SignupPage.html">Sign up</a>
            <a class="barItem" href="NoteList.html">Notes</a>
            <a class="barItem" href="createNote.html">Create</a>
            <a class="barItem" href="contribute.html">View</a>
            <a class="barItem" href="Access.html">Access</a>
        </div>
        <div class="login">
            <form action="<?php echo htmlentities($_SERVER['PHP_SELF']); ?>" id="login" method="POST">
                <!-- Login fields -->
                <h2>LOGIN</h2>
                <div class="lineDiv"></div>
                <div class="inputName"><b>Username:</b></div>
                <!-- Username input -->
                <div class = "tipFieldContainer">
                    <input type="email" name="Uname" class="inField" id="emailField" placeholder="Username" value="<?php if($_SERVER["REQUEST_METHOD"] == "POST") echo $_POST['Uname'] ?>>
                    <span class="tipText" id="emailTipText">Invalid Email</span>
                </div>
                <div class="spaceThirty"></div>
                <div class="inputName"><b>Password:</b></div>
                <!-- password field -->
                <div class = "tipFieldContainer">
                    <input type="password" name="Pass" class="inField" id="passwordField" placeholder="Password" value="<?php if($_SERVER["REQUEST_METHOD"] == "POST") echo $_POST['Pass'] ?>>
                    <span class="tipText" id="passwordTipText">Invalid Password</span>
                </div>
            </form>
            <div class="spaceThirty"></div>
            <div class="spaceThirty"></div>
            <div class="lineDiv"></div>
            <input type="button" name="log" id="loginBtn" class="logBtn" value="Log In">
            <div class="spaceThirty"></div>
        </div>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="../js/login.js"></script>

    </body>
</html>

<?php
    $title = 'Login Page';
    require_once 'connect.php';
    require_once 'login.php';
    if($_SERVER["REQUEST_METHOD"] == "GET"){
        $srd=$_GET['srd'];
        if($srd == 'SUS'){
            echo '<script>alert("User Creation Successful")</script>';
        }
        else if($srd == 'LIF'){
            echo '<script>alert("Please Login")</script>';
        }
        else if($srd == 'KSO'){
            session_destroy();
            session_start();
        }
    }
?>