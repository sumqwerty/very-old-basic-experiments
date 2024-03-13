CREATE TABLE noteTaking.user (
		user_ID INT NOT NULL AUTO_INCREMENT ,
		screen_name VARCHAR(150) NOT NULL ,
		email VARCHAR(150) NOT NULL ,
		img_URL VARCHAR(200) NOT NULL ,
		password VARCHAR(100) NOT NULL ,
		PRIMARY KEY (user_ID)
    );

    CREATE TABLE noteTaking.note (
        note_ID INT NOT NULL AUTO_INCREMENT ,
        create_date DATE NOT NULL ,
        note_title VARCHAR(300) NOT NULL ,
        last_contribution DATE NOT NULL,
        PRIMARY KEY (note_ID)
    );

    CREATE TABLE noteTaking.role (
        role_ID INT NOT NULL AUTO_INCREMENT ,
        user_ID INT NOT NULL ,
        note_ID INT NOT NULL ,
        user_role VARCHAR(50) NOT NULL ,
        PRIMARY KEY (role_ID)
    );

    CREATE TABLE noteTaking.contribution (
        contribution_ID INT NOT NULL AUTO_INCREMENT ,
        role_ID INT NOT NULL ,
        note_ID INT NOT NULL ,
        contribution_date DATE NOT NULL ,
        contribution_text VARCHAR(1550) NOT NULL ,
        PRIMARY KEY (contribution_ID)
    );

    ALTER TABLE role ADD CONSTRAINT role_ibfk_1 FOREIGN KEY (user_ID) REFERENCES user(user_ID) ON DELETE RESTRICT ON UPDATE RESTRICT;
    ALTER TABLE role ADD CONSTRAINT role_ibfk_2 FOREIGN KEY (note_ID) REFERENCES note(note_ID) ON DELETE RESTRICT ON UPDATE RESTRICT;


    ALTER TABLE contribution ADD CONSTRAINT contribution_ibfk_1 FOREIGN KEY (note_ID) REFERENCES note(note_ID) ON DELETE RESTRICT ON UPDATE RESTRICT;
    ALTER TABLE contribution ADD CONSTRAINT contribution_ibfk_2 FOREIGN KEY (role_ID) REFERENCES role(role_ID) ON DELETE RESTRICT ON UPDATE RESTRICT;