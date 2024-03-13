CREATE USER 'qwerty'@'localhost' IDENTIFIED BY 'qwerty123';
GRANT ALL PRIVILEGES ON * . * TO 'qwerty'@'localhost';
FLUSH PRIVILEGES;

create database if not exists College;
use College;
create table Students
(
	studentID int PRIMARY KEY,
	firstName varchar(50),
	lastName varchar(50),
	DOB date,
	email varchar(200),
	mid1score int,
	mid2score int,
	assign1score int,
	assign2score int,
	assign3score int,
	assign4score int,
	assign5score int,
	finalScore int,
	finalGrade varchar(3)
);


insert into Students values
	(1,'James','Milner',STR_TO_DATE('1986-01-04','%Y-%m-%d'),'James01Milner@gmail.com',77,88,81,92,96,84,77,84,'A-'),
	(2,'Andy','Robertson',STR_TO_DATE('1994-03-11','%Y-%m-%d'),'Andy03Robertson@algomail.com',82,96,72,85,96,42,58,80,'A-'),
	(3,'Jordan','Henderson',STR_TO_DATE('1990-06-17','%Y-%m-%d'),'Jordan06Henderson@algomail.com',71,79,92,85,64,53,25,69,'C+'),
	(4,'Harvey','Elliot',STR_TO_DATE('2003-04-04','%Y-%m-%d'),'Harvey04Elliot@algomail.com',53,69,66,45,32,25,21,49,'F'),
	(5,'Roberto','Firmino',STR_TO_DATE('1991-10-02','%Y-%m-%d'),'Roberto10Firmino@algomail.com',25,53,64 ,53,82,71,21,49,'F'),
	(6,'Conor'  ,'Bradley',STR_TO_DATE('2003-07-09','%Y-%m-%d'),'Conor07Bradley@algomail.com'  ,55,94,75 ,89,95,54,96,78,'B+');