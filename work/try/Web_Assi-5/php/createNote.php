<?php
    session_start();
    ob_start();
?>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Notes Web</title>
        <link rel="stylesheet" type="text/css" href="../css/style.css">
        <script src="../js/scripts.js"></script>
        <meta charset="utf-8"/>
    </head>
    <body>
        <?php
            include("header.php");
        ?>
        <!-- Note area -->
        <div class="note">
            <div class="head"><b>CREATE NOTE</b></div>
            <!-- NOte title area -->
            <div class="noteNameContainer">
                <div class = "tipFieldContainer">
                    <p id="noteName" class="noteName" contenteditable="true">Title</p>
                    <span class="tipText largeSpan" id="noteTitleTipText">Title</span>
                </div>
            </div>
            <!-- Note text area -->
            <div class="spaceThirty"></div>
        </div>
        <br>
        <div class="spaceThirty"></div>
        <form action="<?php echo htmlentities($_SERVER['PHP_SELF']); ?>" id="create" method="POST">
            <input type="hidden" id="titleinput" name="titleInput" value="">
        </form>
        <input type="button" id="createBtn" name="createNote" class="creatBtn" value="Create Note">
        <div class="spaceThirty"></div>
        <div class="spaceThirty"></div>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="../js/createNote.js"></script>
    </body>
</html>

<?php
    $title = 'Create Note Page';

    require_once 'session_check.php';
    require_once 'connect.php';

    if($_SERVER["REQUEST_METHOD"] == "POST"){
        try{
            $title=$_POST['titleInput'];
            $query="SELECT * FROM note WHERE note_title ='$title'";
            $result = $con->query($query);
            if($result->num_rows > 0){
                echo "<script>document.getElementById('noteTitleTipText').innerHTML = 'Title Already Taken';
                showTip(document.getElementById('noteTitleTipText'));</script>";
            }
            else{
                $date = date("Y/m/d");
                $crt= "INSERT INTO note (note_title, create_date) VALUES ('$title','$date')";
                $con->query($crt);
                $query="SELECT * FROM note WHERE note_title ='$title'";
                $result = $con->query($query);
                $_SESSION['note_ID'] = $result->fetch_assoc()['note_ID'];
                $user_ID = $_SESSION['user_ID'];
                $note_ID = $_SESSION['note_ID'];
                $crt= "INSERT INTO role (user_role, user_ID, note_ID) VALUES ('owner','$user_ID','$note_ID')";
                $con->query($crt);
                header('location:NoteList.php?mnl=NCS');
                exit();
            }
        }

        //catch exception
        catch(Exception $e) {
            $err = $e->getMessage();

            header("location:SignupPage.php?err='$err'");
        }
    }
?>