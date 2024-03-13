<?php
	session_start();

	if (!isset($_SESSION["voter_id"])) {
		header("Location: index.php");
		exit();
	} else {

    // connect to the database
    require_once("db.php");
    try{
      $db = new PDO($attr, $db_user, $db_pwd, $opts);
    } catch (PDOException $e) {
      throw new PDOException($e->getMessage(), (int)$e->getCode());
    }

    // verify the username/password
    $q = "SELECT Positions.position_id, Positions.position, Positions.open_dt, Positions.close_dt, Candidates.candidate_id, Candidates.last_name, Candidates.first_name, Candidates.img_URL, Candidates.statement, COUNT(Votes.vote_id) as vote_count
    FROM Candidates LEFT JOIN Positions 
      ON (Candidates.position_id = Positions.position_id)
    LEFT JOIN Votes 
      ON (Candidates.candidate_id = Votes.candidate_id)
    GROUP BY Candidates.candidate_id;";

    // print ($q);

    $result = $db->query($q);

    // issue the query to collect all of the position and candidate information

	}

?>
<!DOCTYPE html>
<html>

  <head>
    <meta charset="utf-8" />
    <title>Candidates List</title>
    <link rel="stylesheet" type="text/css" href="style/overall.css" />

    <script src="https://kit.fontawesome.com/74c13a3bb2.js" crossorigin="anonymous"></script>
  </head>

  <Body class="gridContainer">

    <div class="top"><p><i class="fas fa-person-booth"></i> CSSS Online Elections<span class="loggedIn floatRight">logged in as<br/><?=$_SESSION["first_name"]?> 
      <a href="logout.php"><i class="fas fa-sign-out-alt"></i></a></span></p></div>

    <div class="left"></div>

    <div class="main">

<?php

  while ($row = $result->fetch()) {

    // this still needs the logic to detect if the position has changed
    // if it is the same, we do not need to repeat the position header info
    // if it is new (save what it was in a variable and compare to what it is), then we need to print the position header info

?>
      <div class="position">

	  		<p class="positionTitle"><i class="fas fa-vote-yea"></i> Election for <?=$row["position"]?> <span class="floatRight">open for voting from <?=date_format(date_create($row["open_dt"]), "M j, Y H:i")?> - <?=date_format(date_create($row["close_dt"]), "M j, Y H:i")?></span></p>

	  		<div class="candidate">

	  			<p class="candidateName"><i class="fa fa-user-circle"></i> <?=$row["first_name"]?> <?=$row["last_name"]?></p>

          <p class="candidateImage"><img class="image" src="<?=$row["img_URL"]?>" alt="image of Candidate One" /></p>
          <p class="candidateStatement"><?=$row["statement"]?></p>
          <p class="candidateVote"><button>vote</button></p>

	  		</div>

	  	</div>
<?php
  }
?>

    </div>

    <div class="right"></div>

    <div class="bottom"></div>

  </body>

</html>