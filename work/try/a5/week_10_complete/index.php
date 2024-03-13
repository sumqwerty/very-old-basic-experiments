<?php
    require_once("db.php");
    $error = "";
    $username = "";

    // check to see if the form was submitted
    if ($_SERVER["REQUEST_METHOD"] == "POST") {

        // get the username and password and check that they aren't empty
        $username = trim($_POST["username"]);
        $password = trim($_POST["password"]);
        
        if (strlen($username) > 0 && strlen($password) > 0) {
           
            // load the database
            try{
                $db = new PDO($attr, $db_user, $db_pwd, $opts);
            } catch (PDOException $e) {
                throw new PDOException($e->getMessage(), (int)$e->getCode());
            }
          
            // verify the username/password
            $q = "SELECT voter_id, first_name, last_name FROM Voters WHERE email = '$username' AND password = '$password'";

            // print ($q);
            
            $result = $db->query($q);
            
            if ($result->rowCount() > 0) {
                
                // login successful
                session_start();
                $row = $result->fetch();
                $_SESSION["voter_id"] = $row["voter_id"];
                $_SESSION["first_name"] = $row["first_name"];
                $_SESSION["last_name"] = $row["last_name"];

                //print ($_SESSION["voter_id"]);

                $db = null;
                header("Location: candidates.php");
                exit();

            } else {
                
                // login unsuccessful
                $error = ("The username/password combination was incorrect.");
            
            }
        } else {
            
            $error = ("You must enter a non-blank username/password combination to login.");
        }

    }
?>
<!DOCTYPE html>
<html>

  <head>
    <meta charset="utf-8" />
    <title>CSSS Online Elections</title>
    <link rel="stylesheet" type="text/css" href="style/overall.css" />
  </head>

  <body class="gridContainer">

    <div class="top"><p>CSSS Online Elections</p></div>

    <div class="left"></div>

    <div class="main">
      <p>Login below to vote in the CSSS Online Elections. Note that only students who are registered in Computer Science courses at the University of Regina are eligible to vote.</p>
      <p class="serverError"><?=$error?></p>
      <form method="POST" action="" id="theForm" >
        <p>Username: <input type="text" name="username" id="username" value="<?=$username?>"/>
          <span id="usernameHelp" class="help">* your email address is your username</span>
          <span id="usernameError" class="error hideMe">* the username is not correctly formatted as a uregina.ca email address</span>
        </p>

        <p>Password: <input type="password" name="password" id="password" /> 
          <span id="passwordHelp" class="help">* 8 characters, at least one symbol</span>
          <span id="passwordErrorLength" class="error hideMe">* the password is too short</span>
          <span id="passwordErrorFormat" class="error hideMe">* the password must have symbols</span>
        </p>

        <p><input type="submit" value="Login"/></p>
      </form>
    </div>

    <div class="right"></div>

    <div class="bottom"></div>
    <script type="text/javascript" src="js/check4errors.js"></script>
  </body>

</html>