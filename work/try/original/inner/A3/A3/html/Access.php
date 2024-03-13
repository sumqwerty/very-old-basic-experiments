<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Notes Web</title>
        <link rel="stylesheet" type="text/css" href="../css/style.css">
        <meta charset="utf-8"/>
    </head>
    <body>
        <div class="menubar">
            <a class="barItem" href="loginPage.html">Log in</a>
            <a class="barItem" href="SignupPage.html">Sign up</a>
            <a class="barItem" href="NoteList.html">Notes</a>
            <a class="barItem" href="createNote.html">Create</a>
            <a class="barItem" href="contribute.html">View</a>
            <a class="barItem">Access</a>
        </div>
        <div class="login">
            <form id="login" method="get">
                <h2>ACCESS</h2>
                <div class="lineDiv"></div>
                <div class="inputName"><b>Username:</b></div>
                <!-- List of availiable users -->
                <div class="dropDown">
                    <button class="dropDBtn">User List</button>
                    <div class="dropDContent">
                        <div class="dItem">User 1</div>
                        <div class="dItem">User 2</div>
                        <div class="dItem">User 3</div>
                    </div>
                </div>
                <div class="clear"></div>
                <div class="spaceThirty"></div>
                <!-- list of availabe notes -->
                <div class="inputName"><b>Note:</b></div>
                <div class="dropDown">
                    <button class="dropDBtn">Note List</button>
                    <div class="dropDContent">
                        <div class="dItem">Note 1</div>
                        <div class="dItem">Note 2</div>
                        <div class="dItem">Note 3</div>
                    </div>
                </div>
                <div class="clear"></div>
                <div class="spaceThirty"></div>
                <div class="inputName"><b>Access:</b></div>
                <!-- check box for grant or revoke access -->
                <input class="cBox" type="checkbox" id="grant">
                <label class="cBoxLabel"> Grant Access </label>
                <input class="clear cBox" type="checkbox" id="revoke">
                <label class="cBoxLabel"> Revoke Access</label>
                <div class="clear"></div>
                <div class="spaceThirty"></div>
                <div class="lineDiv"></div>
                <!-- update access right button -->
                <input class="logBtn" type="submit" value="Update">
                <div class="spaceThirty"></div>
            </form>
        </div>
        <div class="spaceThirty"></div>
        <div class="spaceThirty"></div>
    </body>
</html>   
