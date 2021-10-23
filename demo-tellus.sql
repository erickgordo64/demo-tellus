CREATE SCHEMA IF NOT EXISTS `demo` DEFAULT CHARACTER SET utf8 ;
USE `demo` ;

-- -----------------------------------------------------
-- Table `demo`.`rol`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `demo`.`rol` (
  `idrol` INT NOT NULL AUTO_INCREMENT,
  `tipo_rol` VARCHAR(45) NULL,
  PRIMARY KEY (`idrol`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `demo`.`usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `demo`.`usuario` (
  `idusuario` INT NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(45) NULL,
  `password` VARCHAR(10) NULL,
  `username` VARCHAR(45) NULL,
  `firstname` VARCHAR(45) NULL,
  `rol_idrol` INT NOT NULL,
  PRIMARY KEY (`idusuario`),
  INDEX `fk_usuario_rol_idx` (`rol_idrol` ASC) VISIBLE,
  CONSTRAINT `fk_usuario_rol`
    FOREIGN KEY (`rol_idrol`)
    REFERENCES `demo`.`rol` (`idrol`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `demo`.`institucion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `demo`.`institucion` (
  `idinstitucion` INT NOT NULL AUTO_INCREMENT,
  `nombre_institucion` VARCHAR(45) NULL,
  PRIMARY KEY (`idinstitucion`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `demo`.`detalle_donacion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `demo`.`detalle_donacion` (
  `iddetalle_donacion` INT NOT NULL AUTO_INCREMENT,
  `donacion` VARCHAR(45) NULL,
  `fecha` VARCHAR(45) NULL,
  `usuario_idusuario` INT NOT NULL,
  `institucion_idinstitucion` INT NOT NULL,
  PRIMARY KEY (`iddetalle_donacion`),
  INDEX `fk_detalle_donacion_usuario1_idx` (`usuario_idusuario` ASC) VISIBLE,
  INDEX `fk_detalle_donacion_institucion1_idx` (`institucion_idinstitucion` ASC) VISIBLE,
  CONSTRAINT `fk_detalle_donacion_usuario1`
    FOREIGN KEY (`usuario_idusuario`)
    REFERENCES `demo`.`usuario` (`idusuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_detalle_donacion_institucion1`
    FOREIGN KEY (`institucion_idinstitucion`)
    REFERENCES `demo`.`institucion` (`idinstitucion`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
