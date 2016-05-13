-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema TPCuatrimestral
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema TPCuatrimestral
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `TPCuatrimestral` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
-- -----------------------------------------------------
-- Schema tpcuatrimestralmapeo
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema tpcuatrimestralmapeo
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `tpcuatrimestralmapeo` DEFAULT CHARACTER SET utf8 ;
USE `TPCuatrimestral` ;

-- -----------------------------------------------------
-- Table `TPCuatrimestral`.`Promocion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `TPCuatrimestral`.`Promocion` (
  `idPromocion` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `fechaInicio` DATE NOT NULL COMMENT '',
  `fechaFin` DATE NOT NULL COMMENT '',
  `descuento` FLOAT NOT NULL COMMENT '',
  PRIMARY KEY (`idPromocion`)  COMMENT '')
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `TPCuatrimestral`.`Login`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `TPCuatrimestral`.`Login` (
  `idLogin` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `usuario` VARCHAR(45) NOT NULL COMMENT '',
  `clave` VARCHAR(45) NULL COMMENT '',
  `privilegio` SMALLINT NULL COMMENT '',
  PRIMARY KEY (`idLogin`)  COMMENT '')
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `TPCuatrimestral`.`Cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `TPCuatrimestral`.`Cliente` (
  `idCliente` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `dni` MEDIUMTEXT NOT NULL COMMENT '',
  `nombre` VARCHAR(45) NOT NULL COMMENT '',
  `apellido` VARCHAR(45) NOT NULL COMMENT '',
  `borrado` TINYINT(1) NOT NULL COMMENT '',
  `idLogin` INT NOT NULL COMMENT '',
  PRIMARY KEY (`idCliente`)  COMMENT '',
  INDEX `fk_Cliente_Login1_idx` (`idLogin` ASC)  COMMENT '',
  CONSTRAINT `fk_Cliente_Login1`
    FOREIGN KEY (`idLogin`)
    REFERENCES `TPCuatrimestral`.`Login` (`idLogin`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `TPCuatrimestral`.`EstadoEstadia`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `TPCuatrimestral`.`EstadoEstadia` (
  `idEstadoEstadia` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `descripcion` VARCHAR(45) NOT NULL COMMENT '',
  PRIMARY KEY (`idEstadoEstadia`)  COMMENT '')
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `TPCuatrimestral`.`Estadia`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `TPCuatrimestral`.`Estadia` (
  `idEstadia` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `fechaCheckIn` DATE NOT NULL COMMENT '',
  `fechaCheckOut` DATE NOT NULL COMMENT '',
  `fechaPedido` DATE NOT NULL COMMENT '',
  `facturado` TINYINT(1) NOT NULL DEFAULT 0 COMMENT '',
  `idticketConsumo` INT NOT NULL COMMENT '',
  `idPromocion` INT NULL COMMENT '',
  `idCliente` INT NOT NULL COMMENT '',
  `idEstadoEstadia` INT NOT NULL COMMENT '',
  PRIMARY KEY (`idEstadia`)  COMMENT '',
  INDEX `fk_Estadia_Promocion1_idx` (`idPromocion` ASC)  COMMENT '',
  INDEX `fk_Estadia_Cliente1_idx` (`idCliente` ASC)  COMMENT '',
  INDEX `fk_Estadia_EstadoEstadia1_idx` (`idEstadoEstadia` ASC)  COMMENT '',
  CONSTRAINT `fk_Estadia_Promocion1`
    FOREIGN KEY (`idPromocion`)
    REFERENCES `TPCuatrimestral`.`Promocion` (`idPromocion`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Estadia_Cliente1`
    FOREIGN KEY (`idCliente`)
    REFERENCES `TPCuatrimestral`.`Cliente` (`idCliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Estadia_EstadoEstadia1`
    FOREIGN KEY (`idEstadoEstadia`)
    REFERENCES `TPCuatrimestral`.`EstadoEstadia` (`idEstadoEstadia`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `TPCuatrimestral`.`TicketConsumo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `TPCuatrimestral`.`TicketConsumo` (
  `idTicketConsumo` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `descrpcion` VARCHAR(45) NOT NULL COMMENT '',
  `precio` FLOAT NOT NULL COMMENT '',
  `fechaDePago` DATE NOT NULL COMMENT '',
  `idEstadia` INT NOT NULL COMMENT '',
  PRIMARY KEY (`idTicketConsumo`)  COMMENT '',
  INDEX `fk_TicketConsumo_Estadia1_idx` (`idEstadia` ASC)  COMMENT '',
  CONSTRAINT `fk_TicketConsumo_Estadia1`
    FOREIGN KEY (`idEstadia`)
    REFERENCES `TPCuatrimestral`.`Estadia` (`idEstadia`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `TPCuatrimestral`.`TipoLimpieza`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `TPCuatrimestral`.`TipoLimpieza` (
  `idTipoLimpieza` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `descripcion` VARCHAR(45) NOT NULL COMMENT '',
  PRIMARY KEY (`idTipoLimpieza`)  COMMENT '')
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `TPCuatrimestral`.`TicketLimpieza`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `TPCuatrimestral`.`TicketLimpieza` (
  `idTicketLimpieza` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `realizado` VARCHAR(45) NOT NULL COMMENT '',
  `fecha` DATE NOT NULL COMMENT '',
  `idTipoLimpieza` INT NOT NULL COMMENT '',
  `idLogin` INT NOT NULL COMMENT '',
  PRIMARY KEY (`idTicketLimpieza`)  COMMENT '',
  INDEX `fk_TicketLimpieza_TipoLimpieza1_idx` (`idTipoLimpieza` ASC)  COMMENT '',
  INDEX `fk_TicketLimpieza_Login1_idx` (`idLogin` ASC)  COMMENT '',
  CONSTRAINT `fk_TicketLimpieza_TipoLimpieza1`
    FOREIGN KEY (`idTipoLimpieza`)
    REFERENCES `TPCuatrimestral`.`TipoLimpieza` (`idTipoLimpieza`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_TicketLimpieza_Login1`
    FOREIGN KEY (`idLogin`)
    REFERENCES `TPCuatrimestral`.`Login` (`idLogin`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `TPCuatrimestral`.`TicketMantenimiento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `TPCuatrimestral`.`TicketMantenimiento` (
  `idTicketMantenimiento` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `fechaGeneracion` DATE NOT NULL COMMENT '',
  `lugar` VARCHAR(45) NOT NULL COMMENT '',
  `problema` VARCHAR(45) NOT NULL COMMENT '',
  `observacion` VARCHAR(45) NOT NULL COMMENT '',
  `reparado` TINYINT(1) NOT NULL DEFAULT 0 COMMENT '',
  `fechaInicio` DATE NOT NULL COMMENT '',
  `fechaFinalizacion` DATE NULL COMMENT '',
  `idLogin` INT NOT NULL COMMENT '',
  PRIMARY KEY (`idTicketMantenimiento`)  COMMENT '',
  INDEX `fk_TicketMantenimiento_Login1_idx` (`idLogin` ASC)  COMMENT '',
  CONSTRAINT `fk_TicketMantenimiento_Login1`
    FOREIGN KEY (`idLogin`)
    REFERENCES `TPCuatrimestral`.`Login` (`idLogin`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `TPCuatrimestral`.`TipoHabitacion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `TPCuatrimestral`.`TipoHabitacion` (
  `idTipoHabitacion` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `descripcion` VARCHAR(45) NOT NULL COMMENT '',
  `precioTemporadaBaja` FLOAT NOT NULL COMMENT '',
  `precioTemporadaAlta` FLOAT NOT NULL COMMENT '',
  PRIMARY KEY (`idTipoHabitacion`)  COMMENT '')
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `TPCuatrimestral`.`Habitacion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `TPCuatrimestral`.`Habitacion` (
  `idHabitacion` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `capacidadMaxima` INT NOT NULL COMMENT '',
  `disponible` TINYINT(1) NOT NULL COMMENT '',
  `precioNoche` FLOAT NOT NULL COMMENT '',
  `precioTemporada` FLOAT NOT NULL COMMENT '',
  `idTipoHabitacion` INT NOT NULL COMMENT '',
  PRIMARY KEY (`idHabitacion`)  COMMENT '',
  INDEX `fk_Habitacion_TipoHabitacion1_idx` (`idTipoHabitacion` ASC)  COMMENT '',
  CONSTRAINT `fk_Habitacion_TipoHabitacion1`
    FOREIGN KEY (`idTipoHabitacion`)
    REFERENCES `TPCuatrimestral`.`TipoHabitacion` (`idTipoHabitacion`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `TPCuatrimestral`.`Factura`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `TPCuatrimestral`.`Factura` (
  `idFactura` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `fecha` DATE NOT NULL COMMENT '',
  `total` FLOAT NOT NULL COMMENT '',
  `pagado` TINYINT(1) NOT NULL DEFAULT 0 COMMENT '',
  `idEstadia` INT NOT NULL COMMENT '',
  PRIMARY KEY (`idFactura`)  COMMENT '',
  INDEX `fk_Factura_Estadia1_idx` (`idEstadia` ASC)  COMMENT '',
  CONSTRAINT `fk_Factura_Estadia1`
    FOREIGN KEY (`idEstadia`)
    REFERENCES `TPCuatrimestral`.`Estadia` (`idEstadia`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `TPCuatrimestral`.`ItemFactura`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `TPCuatrimestral`.`ItemFactura` (
  `idItemFactura` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `detalle` VARCHAR(45) NOT NULL COMMENT '',
  `importe` FLOAT NOT NULL COMMENT '',
  `cantidad` INT NOT NULL COMMENT '',
  `idFactura` INT NOT NULL COMMENT '',
  PRIMARY KEY (`idItemFactura`)  COMMENT '',
  INDEX `fk_ItemFactura_Factura1_idx` (`idFactura` ASC)  COMMENT '',
  CONSTRAINT `fk_ItemFactura_Factura1`
    FOREIGN KEY (`idFactura`)
    REFERENCES `TPCuatrimestral`.`Factura` (`idFactura`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `TPCuatrimestral`.`TipoUsuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `TPCuatrimestral`.`TipoUsuario` (
  `idTipoUsuario` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `tipo` VARCHAR(45) NOT NULL COMMENT '',
  PRIMARY KEY (`idTipoUsuario`)  COMMENT '')
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `TPCuatrimestral`.`Usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `TPCuatrimestral`.`Usuario` (
  `idUsuario` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `nombre` VARCHAR(45) NOT NULL COMMENT '',
  `apellido` VARCHAR(45) NOT NULL COMMENT '',
  `dni` INT NOT NULL COMMENT '',
  `usuario` VARCHAR(45) NOT NULL COMMENT '',
  `clave` VARCHAR(45) NOT NULL COMMENT '',
  `baja` TINYINT(1) NOT NULL DEFAULT 0 COMMENT '',
  `idTipoUsuario` INT NOT NULL COMMENT '',
  `idLogin` INT NOT NULL COMMENT '',
  PRIMARY KEY (`idUsuario`)  COMMENT '',
  INDEX `fk_Usuario_TipoUsuario_idx` (`idTipoUsuario` ASC)  COMMENT '',
  INDEX `fk_Usuario_Login1_idx` (`idLogin` ASC)  COMMENT '',
  CONSTRAINT `fk_Usuario_TipoUsuario`
    FOREIGN KEY (`idTipoUsuario`)
    REFERENCES `TPCuatrimestral`.`TipoUsuario` (`idTipoUsuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Usuario_Login1`
    FOREIGN KEY (`idLogin`)
    REFERENCES `TPCuatrimestral`.`Login` (`idLogin`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `TPCuatrimestral`.`EstadiaxHabitacion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `TPCuatrimestral`.`EstadiaxHabitacion` (
  `idEstadia` INT NOT NULL COMMENT '',
  `idHabitacion` INT NOT NULL COMMENT '',
  PRIMARY KEY (`idEstadia`, `idHabitacion`)  COMMENT '',
  INDEX `fk_Estadia_has_Habitacion_Habitacion1_idx` (`idHabitacion` ASC)  COMMENT '',
  INDEX `fk_Estadia_has_Habitacion_Estadia1_idx` (`idEstadia` ASC)  COMMENT '',
  CONSTRAINT `fk_Estadia_has_Habitacion_Estadia1`
    FOREIGN KEY (`idEstadia`)
    REFERENCES `TPCuatrimestral`.`Estadia` (`idEstadia`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Estadia_has_Habitacion_Habitacion1`
    FOREIGN KEY (`idHabitacion`)
    REFERENCES `TPCuatrimestral`.`Habitacion` (`idHabitacion`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `TPCuatrimestral`.`Recibo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `TPCuatrimestral`.`Recibo` (
  `idRecibo` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `fecha` DATE NOT NULL COMMENT '',
  `importe` FLOAT NOT NULL COMMENT '',
  `formaPago` VARCHAR(45) NOT NULL COMMENT '',
  `idFactura` INT NOT NULL COMMENT '',
  PRIMARY KEY (`idRecibo`)  COMMENT '',
  INDEX `fk_Recibo_Factura1_idx` (`idFactura` ASC)  COMMENT '',
  CONSTRAINT `fk_Recibo_Factura1`
    FOREIGN KEY (`idFactura`)
    REFERENCES `TPCuatrimestral`.`Factura` (`idFactura`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

USE `tpcuatrimestralmapeo` ;

-- -----------------------------------------------------
-- Table `tpcuatrimestralmapeo`.`cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tpcuatrimestralmapeo`.`cliente` (
  `idCliente` INT(11) NOT NULL AUTO_INCREMENT COMMENT '',
  `dni` MEDIUMTEXT NOT NULL COMMENT '',
  `nombre` VARCHAR(45) NOT NULL COMMENT '',
  `apellido` VARCHAR(45) NOT NULL COMMENT '',
  `borrado` TINYINT(1) NOT NULL COMMENT '',
  PRIMARY KEY (`idCliente`)  COMMENT '')
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `tpcuatrimestralmapeo`.`estadia`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tpcuatrimestralmapeo`.`estadia` (
  `idEstadia` INT(11) NOT NULL AUTO_INCREMENT COMMENT '',
  `fechaCheckIn` DATE NOT NULL COMMENT '',
  `fechaCheckOut` DATE NOT NULL COMMENT '',
  `fechaPedido` DATE NOT NULL COMMENT '',
  `facturado` TINYINT(1) NOT NULL DEFAULT '0' COMMENT '',
  `idticketConsumo` INT(11) NOT NULL COMMENT '',
  PRIMARY KEY (`idEstadia`)  COMMENT '')
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `tpcuatrimestralmapeo`.`estadoestadia`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tpcuatrimestralmapeo`.`estadoestadia` (
  `idEstadoEstadia` INT(11) NOT NULL AUTO_INCREMENT COMMENT '',
  `descripcion` VARCHAR(45) NOT NULL COMMENT '',
  PRIMARY KEY (`idEstadoEstadia`)  COMMENT '')
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `tpcuatrimestralmapeo`.`factura`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tpcuatrimestralmapeo`.`factura` (
  `idFactura` INT(11) NOT NULL AUTO_INCREMENT COMMENT '',
  `fecha` DATE NOT NULL COMMENT '',
  `total` FLOAT NOT NULL COMMENT '',
  `pagado` TINYINT(1) NOT NULL DEFAULT '0' COMMENT '',
  PRIMARY KEY (`idFactura`)  COMMENT '')
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `tpcuatrimestralmapeo`.`habitacion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tpcuatrimestralmapeo`.`habitacion` (
  `idHabitacion` INT(11) NOT NULL AUTO_INCREMENT COMMENT '',
  `capacidadMaxima` INT(11) NOT NULL COMMENT '',
  `disponible` TINYINT(1) NOT NULL COMMENT '',
  `precioNoche` FLOAT NOT NULL COMMENT '',
  `precioTemporada` FLOAT NOT NULL COMMENT '',
  PRIMARY KEY (`idHabitacion`)  COMMENT '')
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `tpcuatrimestralmapeo`.`itemfactura`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tpcuatrimestralmapeo`.`itemfactura` (
  `idItemFactura` INT(11) NOT NULL AUTO_INCREMENT COMMENT '',
  `detalle` VARCHAR(45) NOT NULL COMMENT '',
  `importe` FLOAT NOT NULL COMMENT '',
  `cantidad` INT(11) NOT NULL COMMENT '',
  PRIMARY KEY (`idItemFactura`)  COMMENT '')
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `tpcuatrimestralmapeo`.`login`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tpcuatrimestralmapeo`.`login` (
  `idLogin` INT(11) NOT NULL AUTO_INCREMENT COMMENT '',
  `usuario` VARCHAR(45) NOT NULL COMMENT '',
  `clave` VARCHAR(45) NULL DEFAULT NULL COMMENT '',
  `privilegio` SMALLINT(6) NULL DEFAULT NULL COMMENT '',
  PRIMARY KEY (`idLogin`)  COMMENT '')
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `tpcuatrimestralmapeo`.`promocion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tpcuatrimestralmapeo`.`promocion` (
  `idPromocion` INT(11) NOT NULL AUTO_INCREMENT COMMENT '',
  `fechaInicio` DATE NOT NULL COMMENT '',
  `fechaFin` DATE NOT NULL COMMENT '',
  `descuento` FLOAT NOT NULL COMMENT '',
  PRIMARY KEY (`idPromocion`)  COMMENT '')
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `tpcuatrimestralmapeo`.`recibo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tpcuatrimestralmapeo`.`recibo` (
  `idRecibo` INT(11) NOT NULL AUTO_INCREMENT COMMENT '',
  `fecha` DATE NOT NULL COMMENT '',
  `importe` FLOAT NOT NULL COMMENT '',
  `formaPago` VARCHAR(45) NOT NULL COMMENT '',
  PRIMARY KEY (`idRecibo`)  COMMENT '')
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `tpcuatrimestralmapeo`.`ticketconsumo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tpcuatrimestralmapeo`.`ticketconsumo` (
  `idTicketConsumo` INT(11) NOT NULL AUTO_INCREMENT COMMENT '',
  `descrpcion` VARCHAR(45) NOT NULL COMMENT '',
  `precio` FLOAT NOT NULL COMMENT '',
  `fechaDePago` DATE NOT NULL COMMENT '',
  PRIMARY KEY (`idTicketConsumo`)  COMMENT '')
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `tpcuatrimestralmapeo`.`ticketlimpieza`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tpcuatrimestralmapeo`.`ticketlimpieza` (
  `idTicketLimpieza` INT(11) NOT NULL AUTO_INCREMENT COMMENT '',
  `realizado` VARCHAR(45) NOT NULL COMMENT '',
  `fecha` DATE NOT NULL COMMENT '',
  PRIMARY KEY (`idTicketLimpieza`)  COMMENT '')
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `tpcuatrimestralmapeo`.`ticketmantenimiento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tpcuatrimestralmapeo`.`ticketmantenimiento` (
  `idTicketMantenimiento` INT(11) NOT NULL AUTO_INCREMENT COMMENT '',
  `fechaGeneracion` DATE NOT NULL COMMENT '',
  `lugar` VARCHAR(45) NOT NULL COMMENT '',
  `problema` VARCHAR(45) NOT NULL COMMENT '',
  `observacion` VARCHAR(45) NOT NULL COMMENT '',
  `reparado` TINYINT(1) NOT NULL DEFAULT '0' COMMENT '',
  `fechaInicio` DATE NOT NULL COMMENT '',
  `fechaFinalizacion` DATE NULL DEFAULT NULL COMMENT '',
  PRIMARY KEY (`idTicketMantenimiento`)  COMMENT '')
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `tpcuatrimestralmapeo`.`tipohabitacion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tpcuatrimestralmapeo`.`tipohabitacion` (
  `idTipoHabitacion` INT(11) NOT NULL AUTO_INCREMENT COMMENT '',
  `descripcion` VARCHAR(45) NOT NULL COMMENT '',
  `precioTemporadaBaja` FLOAT NOT NULL COMMENT '',
  `precioTemporadaAlta` FLOAT NOT NULL COMMENT '',
  PRIMARY KEY (`idTipoHabitacion`)  COMMENT '')
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `tpcuatrimestralmapeo`.`tipolimpieza`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tpcuatrimestralmapeo`.`tipolimpieza` (
  `idTipoLimpieza` INT(11) NOT NULL AUTO_INCREMENT COMMENT '',
  `descripcion` VARCHAR(45) NOT NULL COMMENT '',
  PRIMARY KEY (`idTipoLimpieza`)  COMMENT '')
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `tpcuatrimestralmapeo`.`tipousuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tpcuatrimestralmapeo`.`tipousuario` (
  `idTipoUsuario` INT(11) NOT NULL AUTO_INCREMENT COMMENT '',
  `tipo` VARCHAR(45) NOT NULL COMMENT '',
  PRIMARY KEY (`idTipoUsuario`)  COMMENT '')
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `tpcuatrimestralmapeo`.`usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tpcuatrimestralmapeo`.`usuario` (
  `idUsuario` INT(11) NOT NULL AUTO_INCREMENT COMMENT '',
  `nombre` VARCHAR(45) NOT NULL COMMENT '',
  `apellido` VARCHAR(45) NOT NULL COMMENT '',
  `dni` INT(11) NOT NULL COMMENT '',
  `usuario` VARCHAR(45) NOT NULL COMMENT '',
  `clave` VARCHAR(45) NOT NULL COMMENT '',
  `baja` TINYINT(1) NOT NULL DEFAULT '0' COMMENT '',
  `idTipoUsuario` INT(11) NOT NULL COMMENT '',
  PRIMARY KEY (`idUsuario`)  COMMENT '')
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
