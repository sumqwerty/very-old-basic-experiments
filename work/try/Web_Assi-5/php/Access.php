<?php
    session_start();
    ob_start();
    $title = 'Note Access Page';

    $directLink = true;
    require_once 'session_check.php';
    require_once 'connect.php';
    if($_SERVER["REQUEST_METHOD"] == "GET"){
        if ($_GET['apm'] == 'ATN')
            $directLink = false;
    }
    if($_SERVER["REQUEST_METHOD"] == "POST"){
        if (isset($_POST['directLink']))
            $directLink = false;
    }
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
        <div class="login">
        <form action="<?php echo htmlentities($_SERVER['PHP_SELF']); ?>" id="access" method="POST">
                <h2>ACCESS</h2>
                <div class="lineDiv"></div>
                <div class="inputName"><b>Username:</b></div>
                <!-- List of availiable users -->
                <div class="dropDown">
                    <button type="button" id="userListBtn" class="dropDBtn">User List</button>
                    <div class="dropDContent">
                        <?php
                            $user_ID = $_SESSION['user_ID'];
                            
                            if($directLink){
                                $query = "SELECT email,user_ID FROM user WHERE user_ID != '$user_ID'";
                                $result = $con->query($query);

                                if ($result->num_rows > 0)
                                    while($row = $result->fetch_assoc())
                                        echo '<div onclick="moveUserData(\''.$row['user_ID'].'\',\''.$row['email'].'\')" id="user_'.$row['user_ID'].'" class="dItem">'.$row['email'].'</div>';
                            }
                            else{
                                $note_ID = $_SESSION['note_ID'];
                                $query = "SELECT * FROM user WHERE user_ID != '$user_ID'";
                                $result = $con->query($query);
                                
                                if ($result->num_rows > 0)
                                while($row = $result->fetch_assoc()){
                                    $query = "SELECT * FROM role WHERE note_ID = '$note_ID' AND user_ID = '".$row['user_ID']."'";
                                    $result1 = $con->query($query);
                                    if ($result1->num_rows > 0)
                                        echo '<div onclick="moveUserData(\''.$row['user_ID'].'\',\''.$row['email'].'\')" id="user_'.$row['user_ID'].'" class="dItem">'.$row['screen_name'].' ... '.$row['email'].' ... '.$result1->fetch_assoc()['user_role'].' <img class="conMakeImg" src="'.$row['img_URL'].'" alt="User img"></div>';
                                    else
                                        echo '<div onclick="moveUserData(\''.$row['user_ID'].'\',\''.$row['email'].'\')" id="user_'.$row['user_ID'].'" class="dItem">'.$row['screen_name'].' ... '.$row['email'].' ... None <img class="conMakeImg" src="'.$row['img_URL'].'" alt="User img"></div>';
                                }


                
                            }
                        ?>
                    </div>
                </div>
                <div class="clear"></div>
                <div class="spaceThirty"></div>
                <?php

                    if($directLink){
                        echo '<div class="inputName"><b>Note:</b></div>
                        <div class="dropDown">
                            <button type="button" id="noteListBtn" class="dropDBtn">Note List</button>
                            <div class="dropDContent">';
                            

                                $query="SELECT note.note_ID, note.note_title
                                FROM note LEFT JOIN role 
                                ON (note.note_ID = role.note_ID)
                                WHERE role.user_ID='$user_ID' AND (role.user_role = 'owner')
                                ORDER BY create_date DESC";
                                $result = $con->query($query);

                                if ($result->num_rows > 0)
                                    while($row = $result->fetch_assoc())
                                        echo '<div onclick="moveNoteData(\''.$row['note_ID'].'\',\''.$row['note_title'].'\')" class="dItem">'.$row['note_title'].'</div>';
                                

                            
                        echo '</div>
                        </div>
                        <div class="clear"></div>
                        <div class="spaceThirty"></div>';
                    }
                ?>
                <div class="inputName"><b>Access:</b></div>
                <!-- check box for grant or revoke access -->
                <input class="cBox" type="radio" id="grant" value="grant" name="access">
                <label class="cBoxLabel"> Grant Access </label>
                <input class="clear cBox" type="radio" id="revoke" value="revoke" name="access">
                <label class="cBoxLabel"> Revoke Access</label>
                <div class="clear"></div>
                <div class="spaceThirty"></div>
                <div class="lineDiv"></div>
                <!-- update access right button -->
                <input class="logBtn" type="button" value="Update" id="updateBtn">
                <div class="spaceThirty"></div>
                <input type="hidden" id="user_ID" name="user_ID" value="">
                <?php
                    if ($directLink)
                        echo '<input type="hidden" id="note_ID" name="note_ID" value="">';
                    else
                        echo '<input type="hidden" id="noteListBtn" name="directLink" value="notDirect">';

                ?>
            </form>
            <a href="Access.php?apm=ATN">For current note</a>
        </div>
        <div class="spaceThirty"></div>
        <div class="spaceThirty"></div>
        
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="../js/access.js"></script>
    </body>
</html>   

<?php
    if($_SERVER["REQUEST_METHOD"] == "POST"){
        try{
            $access=$_POST['access'];
            $userid=$_POST['user_ID'];
    
            if ($directLink)
                $noteid=$_POST['note_ID'];
            else
                $noteid=$_SESSION['note_ID'];
            
            if($access == "grant")
                $access='contributor';
            else if ($access == "revoke")
                $access='none';
            
                
            $query="SELECT * FROM role WHERE note_ID='$noteid' AND user_ID='$userid'";
            $result = $con->query($query);
            
            if($result->num_rows > 0){
                $role_ID = $result->fetch_assoc()['role_ID'];
                $query="UPDATE role SET user_role = 'contributor' WHERE role.role_ID = '$role_ID'";
                $con->query($query);
                echo "<script>alert('Access Updated Successfully');</script>";
            }
            else{
                $query="INSERT INTO role (user_role, user_ID, note_ID) VALUES ('$access','$userid','$noteid')";
                $con->query($query);
                echo "<script>alert('Access Granted Successfully');</script>";
            }

            if ($directLink)
                header("location:Access.php");
            else
                header("location:Access.php?apm=ATN");
            
        }

        //catch exception
        catch(Exception $e) {
            $err = $e->getMessage();
            echo "<script>alert('Internal server error: $err');</script>";
        }
    }
?>