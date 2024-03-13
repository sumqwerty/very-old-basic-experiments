<?php
    if($_SERVER["REQUEST_METHOD"] == "POST"){
        try{
            $title=$_POST['noteTextInput'];
            $user_ID = $_SESSION['user_ID'];
            $note_ID = $_SESSION['note_ID'];
            $query="SELECT * FROM role WHERE note_ID ='$note_ID' AND user_ID = '$user_ID'";
            $result = $con->query($query);
            // echo "<script>alert('$result->num_rows');</script>";
            if($result->num_rows == 0){
                $query= "INSERT INTO role (user_ID, note_ID, user_role) VALUES ('$user_ID','$note_ID','contributor')";
                $con->query($query);
                $query="SELECT role_ID FROM role WHERE note_ID ='$note_ID' AND user_ID = '$user_ID'";
                $result = $con->query($query);
            }
            $role_ID = $result->fetch_assoc()['role_ID'];
            $date = date("Y/m/d");
            $conText = $_POST['noteTextInput'];
            // echo "<script>alert('date $date context $conText roleid $role_ID noteid $note_ID');</script>";
            $query= "INSERT INTO contribution (role_ID, note_ID, contribution_date, contribution_text) VALUES ('$role_ID','$note_ID','$date','$conText')";
            $con->query($query);
            $query= "UPDATE note SET last_contribution = '$date' WHERE note.note_ID = '$note_ID'";
            $con->query($query);

            header("location:contribute.php");
            
        }

        //catch exception
        catch(Exception $e) {
            $err = $e->getMessage();
            echo "<script>alert(\"Error ocuured: '$err'\")</script>";
        }
    }
?>