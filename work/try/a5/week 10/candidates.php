<?php
	session_start();

	if (!isset($_SESSION["voter_id"])) {
		header("Location: index.php");
		exit();
	} else {

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

    <div class="top"><p><i class="fas fa-person-booth"></i> CSSS Online Elections<span class="loggedIn floatRight">logged in as<br/>Orland 
      <i class="fas fa-sign-out-alt"></i></span></p></div>

    <div class="left"></div>

    <div class="main">
      <div class="position">

	  		<p class="positionTitle"><i class="fas fa-vote-yea"></i> Election for President <span class="floatRight">open for voting between March 15 - 31, 2022</span></p>

	  		<div class="candidate">

	  			<p class="candidateName"><i class="fa fa-user-circle"></i> Candidate One</p>

          <p class="candidateImage"><img class="image" src="candidates/TestCandidate1.jpg" alt="image of Candidate One" /></p>
          <p class="candidateStatement">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed sit amet ligula varius, porttitor ex et, vestibulum velit. Cras tincidunt lorem id leo vulputate, ut semper elit euismod. Interdum et malesuada fames ac ante ipsum primis in faucibus. Sed laoreet convallis egestas. Suspendisse metus est, consequat sed commodo vitae, tincidunt sit amet tortor. In eu lobortis nibh. Sed quis pellentesque magna. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae; Nunc et lobortis diam. Praesent efficitur orci eu augue maximus, nec tincidunt nisl egestas.</p>
          <p class="candidateVote"><button>vote</button></p>

	  		</div>

        <div class="candidate">

	  			<p class="candidateName"><i class="fa fa-user-circle"></i> Candidate Two</p>

          <p class="candidateImage"><img class="image" src="candidates/TestCandidate1.jpg" alt="image of Candidate Two" /></p>
          <p class="candidateStatement">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed sit amet ligula varius, porttitor ex et, vestibulum velit. Cras tincidunt lorem id leo vulputate, ut semper elit euismod. Interdum et malesuada fames ac ante ipsum primis in faucibus. Sed laoreet convallis egestas. Suspendisse metus est, consequat sed commodo vitae, tincidunt sit amet tortor. In eu lobortis nibh. Sed quis pellentesque magna. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae; Nunc et lobortis diam. Praesent efficitur orci eu augue maximus, nec tincidunt nisl egestas.</p>
          <p class="candidateVote"><button>vote</button></p>

	  		</div>

	  		

	  	</div>


      <div class="position">

	  		<p class="positionTitle"><i class="fas fa-vote-yea"></i> Election for Vice President <span class="floatRight">open for voting between April 1 - 15, 2022</span></p>

	  		<div class="candidate">

	  			<p class="candidateName"><i class="fa fa-user-circle"></i> Candidate Three</p>

          <p class="candidateImage"><img class="image" src="candidates/TestCandidate1.jpg" alt="image of Candidate Three" /></p>
          <p class="candidateStatement">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed sit amet ligula varius, porttitor ex et, vestibulum velit. Cras tincidunt lorem id leo vulputate, ut semper elit euismod. Interdum et malesuada fames ac ante ipsum primis in faucibus. Sed laoreet convallis egestas. Suspendisse metus est, consequat sed commodo vitae, tincidunt sit amet tortor. In eu lobortis nibh. Sed quis pellentesque magna. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae; Nunc et lobortis diam. Praesent efficitur orci eu augue maximus, nec tincidunt nisl egestas.</p>
          <p class="candidateVote"><button>vote</button></p>

	  		</div>

        <div class="candidate">

	  			<p class="candidateName"><i class="fa fa-user-circle"></i> Candidate Four</p>

          <p class="candidateImage"><img class="image" src="candidates/TestCandidate1.jpg" alt="image of Candidate Four" /></p>
          <p class="candidateStatement">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed sit amet ligula varius, porttitor ex et, vestibulum velit. Cras tincidunt lorem id leo vulputate, ut semper elit euismod. Interdum et malesuada fames ac ante ipsum primis in faucibus. Sed laoreet convallis egestas. Suspendisse metus est, consequat sed commodo vitae, tincidunt sit amet tortor. In eu lobortis nibh. Sed quis pellentesque magna. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae; Nunc et lobortis diam. Praesent efficitur orci eu augue maximus, nec tincidunt nisl egestas.</p>
          <p class="candidateVote"><button>vote</button></p>

	  		</div>

	  		

	  	</div>

    </div>

    <div class="right"></div>

    <div class="bottom"></div>

  </body>

</html>