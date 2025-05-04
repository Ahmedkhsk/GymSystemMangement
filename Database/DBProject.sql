-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema GymSystem
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `GymSystem` ;

-- -----------------------------------------------------
-- Schema GymSystem
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `GymSystem` DEFAULT CHARACTER SET utf8 ;
SHOW WARNINGS;
USE `GymSystem` ;

-- -----------------------------------------------------
-- Table `Trainer`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Trainer` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `Trainer` (
  `TrainerID` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `age` INT NULL,
  `phone` VARCHAR(45) NULL,
  `salary` FLOAT NULL,
  `speciality` VARCHAR(45) NULL,
  PRIMARY KEY (`TrainerID`))
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `Receptionist`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Receptionist` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `Receptionist` (
  `ReceptionistID` INT NOT NULL AUTO_INCREMENT,
  `ReceptionistName` VARCHAR(45) NULL,
  `ReceptionistPassword` VARCHAR(45) NULL,
  PRIMARY KEY (`ReceptionistID`))
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `Package`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Package` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `Package` (
  `PackageID` INT NOT NULL AUTO_INCREMENT,
  `Type` VARCHAR(45) NULL,
  `Duration` INT NULL,
  `packageFee` FLOAT NULL,
  PRIMARY KEY (`PackageID`))
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `Equipment`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Equipment` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `Equipment` (
  `EquipmentID` INT NOT NULL AUTO_INCREMENT,
  `EquipmentName` VARCHAR(45) NULL,
  `targetMuscle` VARCHAR(45) NULL,
  PRIMARY KEY (`EquipmentID`))
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `Trainee`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Trainee` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `Trainee` (
  `TraineeID` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `age` INT NULL,
  `phone` VARCHAR(45) NULL,
  `weight` FLOAT NULL,
  `height` FLOAT NULL,
  `goal` VARCHAR(45) NULL,
  `startDate` VARCHAR(100) NULL,
  `endDate` VARCHAR(100) NULL,
  `PackageID` INT NOT NULL,
  `TrainerID` INT NOT NULL,
  PRIMARY KEY (`TraineeID`))
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Data for table `Trainer`
-- -----------------------------------------------------
START TRANSACTION;
USE `GymSystem`;
INSERT INTO `Trainer` (`TrainerID`, `name`, `age`, `phone`, `salary`, `speciality`) VALUES (1, 'Shawky', 30, '011232345', 5000, 'Cardio');
INSERT INTO `Trainer` (`TrainerID`, `name`, `age`, `phone`, `salary`, `speciality`) VALUES (2, 'Omar', 20, '012234556', 4000, 'Physique');

COMMIT;


-- -----------------------------------------------------
-- Data for table `Receptionist`
-- -----------------------------------------------------
START TRANSACTION;
USE `GymSystem`;
INSERT INTO `Receptionist` (`ReceptionistID`, `ReceptionistName`, `ReceptionistPassword`) VALUES (1, 'Ahmed', 'Khaled');

COMMIT;


-- -----------------------------------------------------
-- Data for table `Package`
-- -----------------------------------------------------
START TRANSACTION;
USE `GymSystem`;
INSERT INTO `Package` (`PackageID`, `Type`, `Duration`, `packageFee`) VALUES (1, 'Silver', 3, 1000);
INSERT INTO `Package` (`PackageID`, `Type`, `Duration`, `packageFee`) VALUES (2, 'Gold', 6, 1500);

COMMIT;


-- -----------------------------------------------------
-- Data for table `Equipment`
-- -----------------------------------------------------
START TRANSACTION;
USE `GymSystem`;
INSERT INTO `Equipment` (`EquipmentID`, `EquipmentName`, `targetMuscle`) VALUES (1, 'Treadmill', 'Cardiovascular, Legs');
INSERT INTO `Equipment` (`EquipmentID`, `EquipmentName`, `targetMuscle`) VALUES (2, 'Dumbbells', 'Arms, Shoulders, Chest, Back');
INSERT INTO `Equipment` (`EquipmentID`, `EquipmentName`, `targetMuscle`) VALUES (3, 'Barbell Bench Press', 'Chest, Shoulders, Triceps');
INSERT INTO `Equipment` (`EquipmentID`, `EquipmentName`, `targetMuscle`) VALUES (4, 'Leg Press Machine', 'Quadriceps, Hamstrings, Glutes');

COMMIT;


-- -----------------------------------------------------
-- Data for table `Trainee`
-- -----------------------------------------------------
START TRANSACTION;
USE `GymSystem`;
INSERT INTO `Trainee` (`TraineeID`, `name`, `age`, `phone`, `weight`, `height`, `goal`, `startDate`, `endDate`, `PackageID`, `TrainerID`) VALUES (1, 'Disha', 20, '01123134', 60, 170, 'Increse Weight', '12/11', '03/11', 1, 1);

COMMIT;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
