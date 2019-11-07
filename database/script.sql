-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema punto_venta
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema punto_venta
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `punto_venta` DEFAULT CHARACTER SET utf8 ;
USE `punto_venta` ;

-- -----------------------------------------------------
-- Table `punto_venta`.`usuarios`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `punto_venta`.`usuarios` (
  `idusuarios` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NULL,
  `apellidos` VARCHAR(45) NULL,
  `direccion` VARCHAR(45) NULL,
  `telefono` VARCHAR(45) NULL,
  PRIMARY KEY (`idusuarios`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `punto_venta`.`categorias`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `punto_venta`.`categorias` (
  `idcategorias` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NULL,
  PRIMARY KEY (`idcategorias`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `punto_venta`.`productos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `punto_venta`.`productos` (
  `idproductos` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NULL,
  `precio` FLOAT NULL,
  `categorias_idcategorias` INT NOT NULL,
  PRIMARY KEY (`idproductos`),
    FOREIGN KEY (`categorias_idcategorias`)
    REFERENCES `punto_venta`.`categorias` (`idcategorias`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `punto_venta`.`nota_cabecera`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `punto_venta`.`nota_cabecera` (
  `idnota_cabecera` INT NOT NULL AUTO_INCREMENT,
  `total` FLOAT NULL,
  `usuarios_idusuarios` INT NOT NULL,
  PRIMARY KEY (`idnota_cabecera`),
    FOREIGN KEY (`usuarios_idusuarios`)
    REFERENCES `punto_venta`.`usuarios` (`idusuarios`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `punto_venta`.`nota_detalle`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `punto_venta`.`nota_detalle` (
  `idnota_detalle` INT NOT NULL AUTO_INCREMENT,
  `cantidad` INT NULL,
  `precio` VARCHAR(45) NULL,
  `nota_cabecera_idnota_cabecera` INT NOT NULL,
  `productos_idproductos` INT NOT NULL,
  PRIMARY KEY (`idnota_detalle`),
    FOREIGN KEY (`nota_cabecera_idnota_cabecera`)
    REFERENCES `punto_venta`.`nota_cabecera` (`idnota_cabecera`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
    FOREIGN KEY (`productos_idproductos`)
    REFERENCES `punto_venta`.`productos` (`idproductos`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
