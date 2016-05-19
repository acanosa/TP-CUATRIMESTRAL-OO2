-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema tpcuatrimestral
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema tpcuatrimestral
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `tpcuatrimestral` DEFAULT CHARACTER SET utf8 ;
USE `tpcuatrimestral` ;

-- -----------------------------------------------------
-- Table `tpcuatrimestral`.`login`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tpcuatrimestral`.`login` (
  `idLogin` INT(11) NOT NULL AUTO_INCREMENT,
  `usuario` VARCHAR(45) NOT NULL,
  `clave` VARCHAR(45) NULL DEFAULT NULL,
  `privilegio` SMALLINT(6) NULL DEFAULT NULL,
  PRIMARY KEY (`idLogin`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `tpcuatrimestral`.`cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tpcuatrimestral`.`cliente` (
  `idCliente` INT(11) NOT NULL AUTO_INCREMENT,
  `dni` MEDIUMTEXT NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `apellido` VARCHAR(45) NOT NULL,
  `borrado` TINYINT(1) NOT NULL,
  `idLogin` INT(11) NOT NULL,
  PRIMARY KEY (`idCliente`),
  INDEX `fk_cliente_login1_idx` (`idLogin` ASC),
  CONSTRAINT `fk_cliente_login1`
    FOREIGN KEY (`idLogin`)
    REFERENCES `tpcuatrimestral`.`login` (`idLogin`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `tpcuatrimestral`.`estadoestadia`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tpcuatrimestral`.`estadoestadia` (
  `idEstadoEstadia` INT(11) NOT NULL AUTO_INCREMENT,
  `descripcion` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idEstadoEstadia`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `tpcuatrimestral`.`promocion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tpcuatrimestral`.`promocion` (
  `idPromocion` INT(11) NOT NULL AUTO_INCREMENT,
  `fechaInicio` DATE NOT NULL,
  `fechaFin` DATE NOT NULL,
  `descuento` FLOAT NOT NULL,
  PRIMARY KEY (`idPromocion`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `tpcuatrimestral`.`estadia`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tpcuatrimestral`.`estadia` (
  `idEstadia` INT(11) NOT NULL AUTO_INCREMENT,
  `fechaCheckIn` DATE NOT NULL,
  `fechaCheckOut` DATE NOT NULL,
  `fechaPedido` DATE NOT NULL,
  `facturado` TINYINT(1) NOT NULL DEFAULT '0',
  `idticketConsumo` INT(11) NOT NULL,
  `idPromocion` INT(11) NULL DEFAULT NULL,
  `idCliente` INT(11) NOT NULL,
  `idEstadoEstadia` INT(11) NOT NULL,
  PRIMARY KEY (`idEstadia`),
  INDEX `fk_Estadia_Promocion1_idx` (`idPromocion` ASC),
  INDEX `fk_Estadia_Cliente1_idx` (`idCliente` ASC),
  INDEX `fk_Estadia_EstadoEstadia1_idx` (`idEstadoEstadia` ASC),
  CONSTRAINT `fk_Estadia_Cliente1`
    FOREIGN KEY (`idCliente`)
    REFERENCES `tpcuatrimestral`.`cliente` (`idCliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Estadia_EstadoEstadia1`
    FOREIGN KEY (`idEstadoEstadia`)
    REFERENCES `tpcuatrimestral`.`estadoestadia` (`idEstadoEstadia`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Estadia_Promocion1`
    FOREIGN KEY (`idPromocion`)
    REFERENCES `tpcuatrimestral`.`promocion` (`idPromocion`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `tpcuatrimestral`.`tipohabitacion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tpcuatrimestral`.`tipohabitacion` (
  `idTipoHabitacion` INT(11) NOT NULL AUTO_INCREMENT,
  `descripcion` VARCHAR(45) NOT NULL,
  `precioTemporadaBaja` FLOAT NOT NULL,
  `precioTemporadaAlta` FLOAT NOT NULL,
  PRIMARY KEY (`idTipoHabitacion`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `tpcuatrimestral`.`habitacion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tpcuatrimestral`.`habitacion` (
  `idHabitacion` INT(11) NOT NULL AUTO_INCREMENT,
  `capacidadMaxima` INT(11) NOT NULL,
  `disponible` TINYINT(1) NOT NULL,
  `precioNoche` FLOAT NOT NULL,
  `idTipoHabitacion` INT(11) NOT NULL,
  PRIMARY KEY (`idHabitacion`),
  INDEX `fk_Habitacion_TipoHabitacion1_idx` (`idTipoHabitacion` ASC),
  CONSTRAINT `fk_Habitacion_TipoHabitacion1`
    FOREIGN KEY (`idTipoHabitacion`)
    REFERENCES `tpcuatrimestral`.`tipohabitacion` (`idTipoHabitacion`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `tpcuatrimestral`.`estadiaxhabitacion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tpcuatrimestral`.`estadiaxhabitacion` (
  `idEstadia` INT(11) NOT NULL,
  `idHabitacion` INT(11) NOT NULL,
  PRIMARY KEY (`idEstadia`, `idHabitacion`),
  INDEX `fk_Estadia_has_Habitacion_Habitacion1_idx` (`idHabitacion` ASC),
  INDEX `fk_Estadia_has_Habitacion_Estadia1_idx` (`idEstadia` ASC),
  CONSTRAINT `fk_Estadia_has_Habitacion_Estadia1`
    FOREIGN KEY (`idEstadia`)
    REFERENCES `tpcuatrimestral`.`estadia` (`idEstadia`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Estadia_has_Habitacion_Habitacion1`
    FOREIGN KEY (`idHabitacion`)
    REFERENCES `tpcuatrimestral`.`habitacion` (`idHabitacion`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `tpcuatrimestral`.`factura`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tpcuatrimestral`.`factura` (
  `idFactura` INT(11) NOT NULL AUTO_INCREMENT,
  `fecha` DATE NOT NULL,
  `total` FLOAT NOT NULL,
  `pagado` TINYINT(1) NOT NULL DEFAULT '0',
  `idEstadia` INT(11) NOT NULL,
  PRIMARY KEY (`idFactura`),
  INDEX `fk_Factura_Estadia1_idx` (`idEstadia` ASC),
  CONSTRAINT `fk_Factura_Estadia1`
    FOREIGN KEY (`idEstadia`)
    REFERENCES `tpcuatrimestral`.`estadia` (`idEstadia`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `tpcuatrimestral`.`itemfactura`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tpcuatrimestral`.`itemfactura` (
  `idItemFactura` INT(11) NOT NULL AUTO_INCREMENT,
  `detalle` VARCHAR(45) NOT NULL,
  `importe` FLOAT NOT NULL,
  `cantidad` INT(11) NOT NULL,
  `idFactura` INT(11) NOT NULL,
  PRIMARY KEY (`idItemFactura`),
  INDEX `fk_ItemFactura_Factura1_idx` (`idFactura` ASC),
  CONSTRAINT `fk_ItemFactura_Factura1`
    FOREIGN KEY (`idFactura`)
    REFERENCES `tpcuatrimestral`.`factura` (`idFactura`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `tpcuatrimestral`.`recibo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tpcuatrimestral`.`recibo` (
  `idRecibo` INT NOT NULL,
  `fecha` DATE NOT NULL,
  `importe` FLOAT NOT NULL,
  `formaPago` VARCHAR(45) NOT NULL,
  `idFactura` INT(11) NOT NULL,
  PRIMARY KEY (`idRecibo`),
  INDEX `fk_Recibo_Factura1_idx` (`idFactura` ASC),
  CONSTRAINT `fk_Recibo_Factura1`
    FOREIGN KEY (`idFactura`)
    REFERENCES `tpcuatrimestral`.`factura` (`idFactura`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `tpcuatrimestral`.`ticketconsumo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tpcuatrimestral`.`ticketconsumo` (
  `idTicketConsumo` INT(11) NOT NULL AUTO_INCREMENT,
  `descrpcion` VARCHAR(45) NOT NULL,
  `precio` FLOAT NOT NULL,
  `fechaDePago` DATE NOT NULL,
  `idEstadia` INT(11) NOT NULL,
  PRIMARY KEY (`idTicketConsumo`),
  INDEX `fk_TicketConsumo_Estadia1_idx` (`idEstadia` ASC),
  CONSTRAINT `fk_TicketConsumo_Estadia1`
    FOREIGN KEY (`idEstadia`)
    REFERENCES `tpcuatrimestral`.`estadia` (`idEstadia`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `tpcuatrimestral`.`tipolimpieza`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tpcuatrimestral`.`tipolimpieza` (
  `idTipoLimpieza` INT(11) NOT NULL AUTO_INCREMENT,
  `descripcion` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idTipoLimpieza`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `tpcuatrimestral`.`ticketlimpieza`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tpcuatrimestral`.`ticketlimpieza` (
  `idTicketLimpieza` INT(11) NOT NULL AUTO_INCREMENT,
  `realizado` VARCHAR(45) NOT NULL,
  `fecha` DATE NOT NULL,
  `idLogin` INT(11) NOT NULL,
  `idTipoLimpieza` INT(11) NOT NULL,
  PRIMARY KEY (`idTicketLimpieza`),
  INDEX `fk_TicketLimpieza_Login1_idx` (`idLogin` ASC),
  INDEX `fk_ticketlimpieza_tipolimpieza1_idx` (`idTipoLimpieza` ASC),
  CONSTRAINT `fk_TicketLimpieza_Login1`
    FOREIGN KEY (`idLogin`)
    REFERENCES `tpcuatrimestral`.`login` (`idLogin`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ticketlimpieza_tipolimpieza1`
    FOREIGN KEY (`idTipoLimpieza`)
    REFERENCES `tpcuatrimestral`.`tipolimpieza` (`idTipoLimpieza`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `tpcuatrimestral`.`ticketmantenimiento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tpcuatrimestral`.`ticketmantenimiento` (
  `idTicketMantenimiento` INT(11) NOT NULL AUTO_INCREMENT,
  `fechaGeneracion` DATE NOT NULL,
  `lugar` VARCHAR(45) NOT NULL,
  `problema` VARCHAR(45) NOT NULL,
  `observacion` VARCHAR(45) NOT NULL,
  `reparado` TINYINT(1) NOT NULL DEFAULT '0',
  `fechaInicio` DATE NOT NULL,
  `fechaFinalizacion` DATE NULL DEFAULT NULL,
  `idLogin` INT(11) NOT NULL,
  PRIMARY KEY (`idTicketMantenimiento`),
  INDEX `fk_TicketMantenimiento_Login1_idx` (`idLogin` ASC),
  CONSTRAINT `fk_TicketMantenimiento_Login1`
    FOREIGN KEY (`idLogin`)
    REFERENCES `tpcuatrimestral`.`login` (`idLogin`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `tpcuatrimestral`.`tipousuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tpcuatrimestral`.`tipousuario` (
  `idTipoUsuario` INT(11) NOT NULL AUTO_INCREMENT,
  `tipo` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idTipoUsuario`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `tpcuatrimestral`.`usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tpcuatrimestral`.`usuario` (
  `idUsuario` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `apellido` VARCHAR(45) NOT NULL,
  `dni` INT(11) NOT NULL,
  `baja` TINYINT(1) NOT NULL DEFAULT '0',
  `idLogin` INT(11) NOT NULL,
  `idTipoUsuario` INT(11) NOT NULL,
  PRIMARY KEY (`idUsuario`),
  INDEX `fk_usuario_login1_idx` (`idLogin` ASC),
  INDEX `fk_usuario_tipousuario1_idx` (`idTipoUsuario` ASC),
  CONSTRAINT `fk_usuario_login1`
    FOREIGN KEY (`idLogin`)
    REFERENCES `tpcuatrimestral`.`login` (`idLogin`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_usuario_tipousuario1`
    FOREIGN KEY (`idTipoUsuario`)
    REFERENCES `tpcuatrimestral`.`tipousuario` (`idTipoUsuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
