-- -----------------------------------------------------
-- Schema DiabetesRecord
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `DiabetesRecord`;

-- -----------------------------------------------------
-- Schema DiabetesRecord
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `DiabetesRecord` DEFAULT CHARACTER SET utf8 COLLATE utf8_bin;
USE `DiabetesRecord`;

-- -----------------------------------------------------
-- Create/Update user for `DiabetesRecord`
-- if you are using any other version than MySQL 8+ you might have to remove this creation and do it manually
-- -----------------------------------------------------
-- DROP USER IF EXISTS cst8288@localhost;
CREATE USER IF NOT EXISTS 'cst8288'@'localhost' IDENTIFIED BY '8288';
GRANT ALL ON `DiabetesRecord`.* TO 'cst8288'@'localhost';

-- -----------------------------------------------------
-- Table `DiabetesRecord`.`EntryType`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `DiabetesRecord`.`EntryType` (
  `Id` INT NOT NULL AUTO_INCREMENT,
  `EntryType` NVARCHAR(255) NOT NULL,
  `Version` INT NOT NULL default 1,
  `Created` DATETIME NOT NULL default now(),
  PRIMARY KEY (`Id`),
  UNIQUE INDEX `Id_UNIQUE` (`Id` ASC) ,
  UNIQUE INDEX `EntryType_UNIQUE` (`EntryType` ASC) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `DiabetesRecord`.`Account`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `DiabetesRecord`.`Account` (
  `Id` INT NOT NULL,
  `Name` NVARCHAR(100) NOT NULL,
  `YearOfBirth` INT NOT NULL,
  `Weight` DECIMAL(5,2) NOT NULL,
  `Version` INT NOT NULL default 1,
  `Created` DATETIME NOT NULL default now(),
  PRIMARY KEY (`Id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `DiabetesRecord`.`GlucoseValue`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `DiabetesRecord`.`GlucoseValue` (
  `Id` INT NOT NULL AUTO_INCREMENT,
  `EntryTypeId` INT NULL,
  `AccountId` INT NOT NULL,
  `GlucoseValue` DECIMAL(5,2) NOT NULL,
  `TakenAt` DATETIME NOT NULL,
  `Version` INT NOT NULL default 1,
  `Created` DATETIME NOT NULL default now(),
  PRIMARY KEY (`Id`),
  UNIQUE INDEX `Id_UNIQUE` (`Id` ASC) ,
  INDEX `fk_GlucoseValue_EntryType_idx` (`EntryTypeId` ASC) ,
  INDEX `fk_GlucoseValue_Account1_idx` (`AccountId` ASC) ,
  CONSTRAINT `fk_GlucoseValue_EntryType`
    FOREIGN KEY (`EntryTypeId`)
    REFERENCES `DiabetesRecord`.`EntryType` (`Id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_GlucoseValue_Account1`
    FOREIGN KEY (`AccountId`)
    REFERENCES `DiabetesRecord`.`Account` (`Id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `DiabetesRecord`.`Food`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `DiabetesRecord`.`Food` (
  `Id` INT NOT NULL AUTO_INCREMENT,
  `Name` NVARCHAR(255) NOT NULL,
  `GlycemicIndex` INT NULL,
  `Description` NVARCHAR(255) NULL,
  `Version` INT NOT NULL default 1,
  `Created` DATETIME NOT NULL default now(),
  PRIMARY KEY (`Id`),
  UNIQUE INDEX `Id_UNIQUE` (`Id` ASC) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `DiabetesRecord`.`Meal`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `DiabetesRecord`.`Meal` (
  `GlucoseValueId` INT NOT NULL,
  `FoodId` INT NOT NULL,
  PRIMARY KEY (`GlucoseValueId`, `FoodId`),
  INDEX `fk_GlucoseValue_has_Food_Food1_idx` (`FoodId` ASC) ,
  INDEX `fk_GlucoseValue_has_Food_GlucoseValue1_idx` (`GlucoseValueId` ASC) ,
  CONSTRAINT `fk_GlucoseValue_has_Food_GlucoseValue1`
    FOREIGN KEY (`GlucoseValueId`)
    REFERENCES `DiabetesRecord`.`GlucoseValue` (`Id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_GlucoseValue_has_Food_Food1`
    FOREIGN KEY (`FoodId`)
    REFERENCES `DiabetesRecord`.`Food` (`Id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `DiabetesRecord`.`Security`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `DiabetesRecord`.`Security` (
  `Id` INT NOT NULL,
  `AccountId` INT NOT NULL,
  `IsAdmin` TINYINT NOT NULL,
  `Username` NVARCHAR(100) NOT NULL,
  `Password` NVARCHAR(100) NOT NULL,
  `Version` INT NOT NULL default 1,
  `Created` DATETIME NOT NULL default now(),
  PRIMARY KEY (`Id`),
  INDEX `fk_Security_Account1_idx` (`AccountId` ASC) ,
  UNIQUE INDEX `username_UNIQUE` (`Username` ASC) ,
  UNIQUE INDEX `AccountId_UNIQUE` (`AccountId` ASC) ,
  CONSTRAINT `fk_Security_Account1`
    FOREIGN KEY (`AccountId`)
    REFERENCES `DiabetesRecord`.`Account` (`Id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Insert to table `DiabetesRecord`.`account`
-- -----------------------------------------------------
INSERT INTO `diabetesrecord`.`account` (`Id`, `Name`, `YearOfBirth`, `Weight`) VALUES ('1', 'Shawn E.', '1900', '100.00');
INSERT INTO `diabetesrecord`.`account` (`Id`, `Name`, `YearOfBirth`, `Weight`) VALUES ('2','John D.', '1911', '111');

-- -----------------------------------------------------
-- Insert to table `DiabetesRecord`.`security`
-- -----------------------------------------------------
INSERT INTO `diabetesrecord`.`security` (`Id`, `AccountId`, `IsAdmin`, `Username`, `Password`) VALUES ('1', '1', '1', 'cst8288', '8288');
INSERT INTO `diabetesrecord`.`security` (`Id`, `AccountId`, `IsAdmin`, `Username`, `Password`) VALUES ('2', '2', '0', 'John', 'pass');

-- -----------------------------------------------------
-- Insert to table `DiabetesRecord`.`entrytype`
-- -----------------------------------------------------
INSERT INTO `diabetesrecord`.`entrytype` (`Id`, `EntryType`) VALUES ( '1', 'Fasting');
INSERT INTO `diabetesrecord`.`entrytype` (`Id`, `EntryType`) VALUES ( '2', 'Bedtime');
INSERT INTO `diabetesrecord`.`entrytype` (`Id`, `EntryType`) VALUES ( '3', 'Before Meal');
INSERT INTO `diabetesrecord`.`entrytype` (`Id`, `EntryType`) VALUES ( '4', 'After Meal');
INSERT INTO `diabetesrecord`.`entrytype` (`Id`, `EntryType`) VALUES ( '5', 'Other');

-- -----------------------------------------------------
-- Insert to table `DiabetesRecord`.`food`
-- -----------------------------------------------------
INSERT INTO `diabetesrecord`.`food` (`Id`, `Name`, `GlycemicIndex`, `Description`) VALUES ( '1', 'White Bread', '71', 'Home Made low suger');
INSERT INTO `diabetesrecord`.`food` (`Id`, `Name`, `GlycemicIndex`, `Description`) VALUES ( '2', 'Cream Cheese', '27', 'Philadelphia Cream Cheese');
INSERT INTO `diabetesrecord`.`food` (`Id`, `Name`, `GlycemicIndex`, `Description`) VALUES ( '3', 'Yogurt', '36', '9% Fat');
INSERT INTO `diabetesrecord`.`food` (`Id`, `Name`, `GlycemicIndex`, `Description`) VALUES ( '4', 'Tuna', '0', 'Tonnino Tuna Ventresca');
INSERT INTO `diabetesrecord`.`food` (`Id`, `Name`, `GlycemicIndex`, `Description`) VALUES ( '5', 'Salmon', '0', 'Fresh catch');
INSERT INTO `diabetesrecord`.`food` (`Id`, `Name`, `GlycemicIndex`, `Description`) VALUES ( '6', 'Rice', '60', 'Jasmine Aged Gold');
INSERT INTO `diabetesrecord`.`food` (`Id`, `Name`, `GlycemicIndex`, `Description`) VALUES ( '7', 'Lentile', '28', 'Brown');
INSERT INTO `diabetesrecord`.`food` (`Id`, `Name`, `GlycemicIndex`, `Description`) VALUES ( '8', 'Potato', '60', 'Russet Roasted');

-- -----------------------------------------------------
-- Insert to table `DiabetesRecord`.`glucosevalue`
-- -----------------------------------------------------
INSERT INTO `diabetesrecord`.`glucosevalue` (`Id`, `EntryTypeId`, `AccountId`, `GlucoseValue`, `TakenAt`) VALUES ('1', '1', '2', '5.1', now());
INSERT INTO `diabetesrecord`.`glucosevalue` (`Id`, `EntryTypeId`, `AccountId`, `GlucoseValue`, `TakenAt`) VALUES ('2', '3', '2', '4.8', now());
INSERT INTO `diabetesrecord`.`glucosevalue` (`Id`, `EntryTypeId`, `AccountId`, `GlucoseValue`, `TakenAt`) VALUES ('3', '4', '2', '6.2', now());
INSERT INTO `diabetesrecord`.`glucosevalue` (`Id`, `EntryTypeId`, `AccountId`, `GlucoseValue`, `TakenAt`) VALUES ('4', '3', '2', '6.8', now());
INSERT INTO `diabetesrecord`.`glucosevalue` (`Id`, `EntryTypeId`, `AccountId`, `GlucoseValue`, `TakenAt`) VALUES ('5', '4', '2', '7.2', now());
INSERT INTO `diabetesrecord`.`glucosevalue` (`Id`, `EntryTypeId`, `AccountId`, `GlucoseValue`, `TakenAt`) VALUES ('6', '2', '2', '6.5', now());

-- -----------------------------------------------------
-- Insert to table `DiabetesRecord`.`meal`
-- -----------------------------------------------------
INSERT INTO `diabetesrecord`.`meal` (`GlucoseValueId`, `FoodId`) VALUES ('3', '1');
INSERT INTO `diabetesrecord`.`meal` (`GlucoseValueId`, `FoodId`) VALUES ('3', '2');
INSERT INTO `diabetesrecord`.`meal` (`GlucoseValueId`, `FoodId`) VALUES ('5', '6');
INSERT INTO `diabetesrecord`.`meal` (`GlucoseValueId`, `FoodId`) VALUES ('5', '7');
INSERT INTO `diabetesrecord`.`meal` (`GlucoseValueId`, `FoodId`) VALUES ('5', '5');
