CREATE DATABASE  `BD` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `BD`;

-- -----------------------------------------------------
-- Table `bd`.`university`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bd`.`university` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;

-- -----------------------------------------------------
-- Table `bd`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bd`.`user` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `createdat` DATETIME(6) NULL DEFAULT NULL,
  `enabled` BIT(1) NULL DEFAULT NULL,
  `password` VARCHAR(60) NOT NULL,
  `updatedat` DATETIME(6) NULL DEFAULT NULL,
  `username` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;

CREATE UNIQUE INDEX `UK_sb8bbouer5wak8vyiiy4pf2bx` ON `bd`.`user` (`username` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `bd`.`user_role`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bd`.`user_role` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `createdat` DATETIME(6) NULL DEFAULT NULL,
  `role` VARCHAR(100) NOT NULL,
  `updatedat` DATETIME(6) NULL DEFAULT NULL,
  `user_id` BIGINT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;

CREATE UNIQUE INDEX `UKscfpive7aa0o9savdwmxmnaij` ON `bd`.`user_role` (`role` ASC, `user_id` ASC) VISIBLE;

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'2011-12-18 12:31:00',true,"$2a$04$Yk0vgSLvzkt.xbhzHsUlzesCtHaIZVgkeyvO4Fz/cEXz7z3DoNJ4G",'2011-12-18 12:31:00',"administrador"),(2,'2011-12-18 12:31:00',true,"$2a$04$2ZNl3bn6ZrfptHThI4G0Ze8TVnQDCzt99tiHf4BfNWA6MV6gGrlpO",'2011-12-18 12:31:00',"alumno"),(3,'2011-12-18 12:31:00',true,"$2a$04$WDCq2Au//I/sNhDTFJG.We26XDtKPdbObSqJaj1qgrSyXwS5mF1PS",'2011-12-18 12:31:00',"docente");
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

SELECT *FROM user;

LOCK TABLES `user_role` WRITE;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` VALUES (1, '2011-12-18 12:31:00', 'ROLE_ADMIN', '2011-12-18 12:31:00',1),(2, '2012-12-15 12:21:00', 'ROLE_USER', '2011-12-15 12:21:00',2),(3, '2012-12-15 12:21:00', 'ROLE_ADMIN', '2011-12-15 12:22:00',3);
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
UNLOCK TABLES;

SELECT *FROM user_role;