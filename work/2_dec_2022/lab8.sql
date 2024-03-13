-- CREATE DATABASE IF IT DOES NOT EXIST
CREATE DATABASE IF NOT EXISTS lab8;

-- SELECT OUR DATABASE FOR USE
USE lab8;

-- DROP TABLE IF IT EXISTS
DROP TABLE IF EXISTS `employee`;

-- DROP TABLE IF IT ALREADY EXISTS
DROP TABLE IF EXISTS `departments`;

-- CREATE PRIMARY TABLE
CREATE TABLE `departments` (
    deptID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    deptName VARCHAR(64),
    deptDesc VARCHAR(128)
);


-- CREATE CHILD TABLE (will be missing FOREIGN KEY and FOREIGN KEY RELATIONSHIP)
CREATE TABLE `employee` (
    empID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    empFName VARCHAR(64),
    empLName VARCHAR(64),
    deptID INT NOT NULL
);

-- INSERT RECORDS INTO DEPARTMENT TABLE
INSERT INTO `departments`(deptName,deptDesc)
VALUES ('HR','Human Resources'),
    ('AR', 'Accounts Receivables'),
    ('AP', 'Account Payables'),
    ('IT', 'Information Technology'),
    ('Payroll', 'Payroll');

-- INSERT INTO THE EMPLOYEE TABLE
INSERT INTO `employee`(empFName,empLName,deptID)
VALUES ('Bob','Loblaw',1),
    ('Jane','Doe',1),
    ('John','Doe',2),
    ('Jonny','Smith',3),
    ('Jason','Pichie',4),
    ('Sammy','Bucks',5),
    ('Billy','Dolla',5);
    
-- 2 ALTER the child table, include the FOREIGN KEY constraint
ALTER TABLE `employee` ADD CONSTRAINT FK_employee FOREIGN KEY (deptID) REFERENCES departments(deptID);


-- 3 Create a STORED PROCEDURE that will declare two INT variables. Then it will add the two variables together with a SELECT statement. Use and ALIAS for the column name
DELIMITER //
CREATE PROCEDURE `AddVariables`()
BEGIN
	DECLARE vr1,vr2 INT DEFAULT 1;
	SELECT vr1+vr2 AS Addition; 
END //
DELIMITER ;

-- 4 Create a STORED PROCEDURE that is a SELECT that displays the employee first name, last name, and department description, order it by department description
DELIMITER //
CREATE PROCEDURE `ShowEmpInfo`()
BEGIN
	SELECT e.empFName, e.empLName, d.deptDesc FROM `employee` e, `departments` d WHERE e.deptID=d.deptID order by d.deptDesc;
END //
DELIMITER ;


-- 5 Create a STORED PROCEDURE that will require an input parameter of type VARCHAR(64).Use this parameter in a WHERE clause to filter records. You choose what columns to display.
DELIMITER //
CREATE PROCEDURE `DetailsOf`(vrbl VARCHAR(64))
BEGIN
	SELECT e.empFName as 'First Name', e.empLName as 'Last Name', e.deptID as 'Department ID', d.deptDesc as 'Department' FROM `employee` e, `departments` d WHERE e.deptID=d.deptID and e.empFName like vrbl;
END //
DELIMITER ;


