
CREATE SCHEMA IF NOT EXISTS `bdnominas` DEFAULT CHARACTER SET utf8 ;
USE `bdnominas` ;

CREATE TABLE IF NOT EXISTS tbl_empleados (
	empid INT NOT NULL AUTO_INCREMENT,
	empnombre VARCHAR(45) NOT NULL,
        empsueldo VARCHAR(40) NOT NULL,
  	empestado VARCHAR(45) NOT NULL,
  	empdias VARCHAR(40) NOT NULL,
        empcargo VARCHAR(45) NOT NULL,
  	empdepart VARCHAR(40) NOT NULL,
	PRIMARY KEY (empid) )
ENGINE = InnoDB CHARACTER SET = latin1;

CREATE TABLE IF NOT EXISTS tbl_departamentos (
	deparid INT NOT NULL AUTO_INCREMENT,
	deparnombre VARCHAR(45) NOT NULL,
        deparestado VARCHAR(40) NOT NULL,
	PRIMARY KEY (deparid))
ENGINE = InnoDB CHARACTER SET = latin1;

CREATE TABLE IF NOT EXISTS tbl_cargo (
	carid INT NOT NULL AUTO_INCREMENT,
	carnombre VARCHAR(45) NOT NULL,
        carestatus VARCHAR(40) NOT NULL,
	PRIMARY KEY (carid))
ENGINE = InnoDB CHARACTER SET = latin1;


CREATE TABLE IF NOT EXISTS tbl_concepto (
	concepid INT NOT NULL AUTO_INCREMENT,
	concepnombre VARCHAR(45) NOT NULL,
    concepefecto VARCHAR(5) NOT NULL,
	concepestado VARCHAR(10) NOT NULL,
	concepvalor VARCHAR(10) NOT NULL, 
	PRIMARY KEY (concepid))
ENGINE = InnoDB CHARACTER SET = latin1;

CREATE TABLE IF NOT EXISTS tbl_asignacion (
	aid INT NOT NULL AUTO_INCREMENT,
	anombre VARCHAR(45) NOT NULL,
        aconcepto VARCHAR(50) NOT NULL,
	avigss VARCHAR(50) NOT NULL,
	avisr VARCHAR(50) NOT NULL,
	avotros VARCHAR(50) NOT NULL,
	avalor VARCHAR(45) NOT NULL,
	PRIMARY KEY (aid))
ENGINE = InnoDB CHARACTER SET = latin1;

CREATE TABLE IF NOT EXISTS tbl_generacion (
	geid INT NOT NULL AUTO_INCREMENT,
	geinicial DATE,
	gefinal DATE,
	genombre VARCHAR(45) NOT NULL,
        geconcepto VARCHAR(50) NOT NULL,
	geigss VARCHAR(50) NOT NULL,
	geisr VARCHAR(50) NOT NULL,
	geotros VARCHAR(50) NOT NULL,
	gevalor VARCHAR(45) NOT NULL,
	PRIMARY KEY (geid))
ENGINE = InnoDB CHARACTER SET = latin1;

