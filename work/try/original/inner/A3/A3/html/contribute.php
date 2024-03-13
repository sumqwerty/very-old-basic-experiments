<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Notes Web</title>
        <link rel="stylesheet" type="text/css" href="../css/style.css">
        <meta charset="utf-8"/>
    </head>
    <body>
        <!-- Menu bar items -->
        <div class="menubar">
            <a class="barItem" href="loginPage.html">Log in</a>
            <a class="barItem" href="SignupPage.html">Sign up</a>
            <a class="barItem" href="NoteList.html">Notes</a>
            <a class="barItem" href="createNote.html">Create</a>
            <a class="barItem">View</a>
            <a class="barItem" href="Access.html">Access</a>
        </div>
        <!-- Note View -->
        <div class="note">
            <div class="head"><b>VIEW NOTE</b></div>
            <div class="conMakeData">
                <div class="noteName">Note Name</div>
                <div class="noteName">Date</div>
                <div class="noteName">Creater Name</div>
            </div>
            <!-- Auther of note -->
            <img class="makeImg" src="../img/user.png" alt="User img">
            <div class="clearLeft"></div>
            <div class="lineDiv"></div>
            <!-- Initial contribution by the auther -->
            <div class="noteText"><p class="noteTextArea">Orignal Text here</p></div>
            <!-- Auher of contribution -->
            <div class="noteTextConAuth">
                <div class="conMakeImgDiv"><img class="conMakeImg" src="../img/user.jpg" alt="User img"></div>
                <div>Contrebuter Name 1</div>
                <br>
                <div>Contribution Date 1</div>
            </div>
            <!-- Contribution text here -->
            <div class="noteText"><p class="noteTextAreaSmall">Contribution 1 Text here</p></div>
            <div class="noteTextConAuth">
                <div class="conMakeImgDiv"><img class="conMakeImg" src="../img/user.jpg" alt="User img"></div>
                <div>Contrebuter Name 2</div>
                <br>
                <div>Contribution Date 2</div>
            </div>
            <div class="noteText"><p class="noteTextAreaSmall">Contribution 2 Text here</p></div>
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
        <input type="button" class="creatBtn" value="Update Note">
        <!-- Go to grant / revoke access page -->
        <input type="button" class="creatBtn" value="Access Rights" onclick="window.location.href='Access.html'">
        <div class="spaceThirty"></div>
        <div class="spaceThirty"></div>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="../js/contribute.js"></script>
    </body>
</html>