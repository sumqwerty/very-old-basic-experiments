<?php
    session_start();
    ob_start();
    
    $title = 'Contribution Page';
    
    require_once 'session_check.php';
    require_once 'connect.php';
    require_once 'contribution.php';
?>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Notes Web</title>
        <link rel="stylesheet" type="text/css" href="../css/style.css">
        <meta charset="utf-8"/>
    </head>
    <body>
        <?php
            include("header.php");
        ?>
        <!-- Note View -->
        <div class="note">
            <div class="head"><b>VIEW NOTE</b></div>
            <?php
                $user_ID = $_SESSION['user_ID'];
                $note_ID = $_SESSION['note_ID'];
                // echo "<script>alert('$note_ID');</script>";
                $query="SELECT user.screen_name, user.img_URL, note.note_title, note.create_date 
                FROM note LEFT JOIN role 
                ON (note.note_ID = role.note_ID) 
                LEFT JOIN user
                ON (role.user_ID = user.user_ID)
                WHERE note.note_ID='$note_ID' AND role.user_role = 'owner'";
                $result = $con->query($query)->fetch_assoc();
                $screen_name = $result['screen_name'];
                $img_URL = $result['img_URL'];
                $note_title = $result['note_title'];
                $date = $result['create_date'];
                // echo '<script>alert("SN: '.$screen_name.'    imgURL: '.$img_URL.'    title: '.$note_title.'    date: '.$date.'");</script>';
                echo '<div class="conMakeData">
                    <div class="noteName"><b>Note Title: </b>'.$note_title.'</div>
                    <div class="noteName"><b>Creaded By: </b>'.$screen_name.'</div>
                    <div class="noteName"><b>Created On: </b>'.$date.'</div>
                </div>
                <!-- Auther of note -->
                <img class="makeImg" src="'.$img_URL.'" alt="User img">';

                $query="SELECT contribution.contribution_text, contribution.contribution_date, user.screen_name, user.img_URL 
                FROM contribution LEFT JOIN role 
                ON (contribution.role_ID = role.role_ID) 
                LEFT JOIN user
                ON (role.user_ID = user.user_ID)
                WHERE contribution.note_ID='$note_ID'
                ORDER BY contribution_date ASC";
                $result = $con->query($query);

                
                if ($result->num_rows > 0){
                    while($row = $result->fetch_assoc()){
                        echo '<div class="clearLeft"></div>
                        <div class="lineDiv"></div>
                        <!-- Auher of contribution -->
                        <div class="noteTextConAuth">
                        <div class="conMakeImgDiv"><img class="conMakeImg" src="'.$row['img_URL'].'" alt="User img"></div>
                        <div>'.$row['screen_name'].'</div>
                        <br>
                        <div>'.$row['contribution_date'].'</div>
                        </div>
                        <!-- Contribution text here -->
                        <div class="noteText"><p class="noteTextAreaSmall">'.$row['contribution_text'].'</p></div>';
                    }
                }
                else
                    echo '<div class="clearLeft"></div>
                        <div class="lineDiv"></div>
                        <div class="noteText"><p class="noteTextAreaSmall">No contribution has been made to this note yet.</p></div>';
            ?>
        </div>

        <!-- Make contribution to note -->
        <div class="note">
            <div class="head"><b>MAKE CONTREBUTION</b></div>
                <div class="noteText">
                    <div class="textCount" id="textCountField">0/1500</div>
                    <p contenteditable="true" onkeyup="countNumbers(this)" class="noteTextArea" id="noteContrText">Text here</p>
                </div>
        </div>
        <br>
        <!-- Upload contribution button -->
        <form action="<?php echo htmlentities($_SERVER['PHP_SELF']); ?>" id="contributionForm" method="POST">
            <input type="hidden" id="noteTextInput" name="noteTextInput" value="">
        </form>
        <!-- Go to grant / revoke access page -->
        <input type="button" class="creatBtn" value="Update Note" id="addContribution">
        <input type="button" class="creatBtn" value="Access Rights" onclick="window.location.href='Access.php?apm=ATN'">
        <div class="spaceThirty"></div>
        <div class="spaceThirty"></div>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="../js/contribute.js"></script>
    </body>
</html>

<?php
// if($_SERVER["REQUEST_METHOD"] == "GET"){
// }
?>