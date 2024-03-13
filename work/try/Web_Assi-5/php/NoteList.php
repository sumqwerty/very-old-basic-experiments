<?php
    session_start();
    ob_start();
    $title = 'Note List Page';

    require_once 'session_check.php';
    require_once 'connect.php';

    $user_ID = $_SESSION['user_ID'];
    $note_ID = $_SESSION['note_ID'];
    $note_ID = 6;
    $query="SELECT note.note_ID, note.note_title, note.create_date, note.last_contribution, role.user_role 
    FROM note LEFT JOIN role 
    ON (note.note_ID = role.note_ID) 
    LEFT JOIN user
    ON (role.user_ID = user.user_ID)
    WHERE role.user_ID='$user_ID' AND (role.user_role = 'owner' OR role.user_role = 'contributor')
    ORDER BY create_date DESC";
    $result = $con->query($query);
    
    $htmlCreatedNotes = "";
    $htmlContrbdNotes = "";

    if ($result->num_rows > 0)
        while($row = $result->fetch_assoc()){

            $query="SELECT COUNT(contribution.contribution_ID) as noOfCons 
            FROM note LEFT JOIN contribution
            ON (note.note_ID = contribution.note_ID)
            WHERE note.note_ID='".$row['note_ID']."'";
            $result1 = $con->query($query);

            if ($row['user_role'] == 'owner')
                $htmlCreatedNotes = $htmlCreatedNotes.'<div class="clearLeft">
                <a class="listA" href="setSessionVarForVN.php?note='.$row['note_ID'].'">
                <div class="listName">'.$row['note_title'].'</div></a>
                <div class="listDate">'.$row['create_date'].'</div>
                <div class="listNoOfCon">'.$row['last_contribution'].'</div>
                <div class="listLCDate">'.$result1->fetch_assoc()['noOfCons'].'</div>
                </div>';
            else if ($row['user_role'] == 'contributor')
                $htmlContrbdNotes = $htmlContrbdNotes.'
                <div class="clearLeft">
                    <a class="listA" href="setSessionVarForVN.php?note='.$row['note_ID'].'">
                    <div class="listName">'.$row['note_title'].'</div></a>
                    <div class="listDate">'.$row['create_date'].'</div>
                    <div class="listNoOfCon">'.$result1->fetch_assoc()['noOfCons'].'</div>
                    <div class="listLCDate">'.$row['last_contribution'].'</div>
                </div>';
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
        <!-- Note list for owner notes  -->
        <div class="note">
            <div>
                <div class="head">NOTES CREATED</div>
                <div class="headName">Name</div>
                <div class="headDate">Date</div>
                <div class="headNoOfCon">Total Contributions</div>
                <div class="headLastConDate">Last Contributions</div>
            </div>
            <?php
                echo $htmlCreatedNotes;
            ?>
        </div>
        <!-- Notes that user has access too -->
        <div class="note">
            <div>
                <div class="head">NOTES AVAILABLE</div>
                <div class="headName">Name</div>
                <div class="headDate">Date</div>
                <div class="headNoOfCon">Total Contributions</div>
                <div class="headLastConDate">Last Contributions</div>
            </div>
            <?php
                echo $htmlContrbdNotes;
            ?>
        </div>
        <div class="spaceThirty"></div>
        <div class="spaceThirty"></div>
        <div class="spaceThirty"></div>
        <div class="spaceThirty"></div>
        <div class="spaceThirty"></div>
    </body>
</html>   

<?php
?>