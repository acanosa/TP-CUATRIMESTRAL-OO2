CREATE DATABASE  IF NOT EXISTS `tpCuatrimestralMapeo` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `tpCuatrimestralMapeo`;
-- MySQL dump 10.13  Distrib 5.6.17, for Win32 (x86)
--
-- Host: localhost    Database: tpCuatrimestralMapeo
-- ------------------------------------------------------
-- Server version	5.6.22-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cliente` (
  `idCliente` int(11) NOT NULL AUTO_INCREMENT,
  `dni` mediumtext NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `apellido` varchar(45) NOT NULL,
  `borrado` tinyint(1) NOT NULL,
  PRIMARY KEY (`idCliente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `estadia`
--

DROP TABLE IF EXISTS `estadia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `estadia` (
  `idEstadia` int(11) NOT NULL AUTO_INCREMENT,
  `fechaCheckIn` date NOT NULL,
  `fechaCheckOut` date NOT NULL,
  `fechaPedido` date NOT NULL,
  `facturado` tinyint(1) NOT NULL DEFAULT '0',
  `idticketConsumo` int(11) NOT NULL,
  `idPromocion` int(11) DEFAULT NULL,
  `idCliente` int(11) NOT NULL,
  `idEstadoEstadia` int(11) NOT NULL,
  PRIMARY KEY (`idEstadia`),
  KEY `fk_Estadia_Promocion1_idx` (`idPromocion`),
  KEY `fk_Estadia_Cliente1_idx` (`idCliente`),
  KEY `fk_Estadia_EstadoEstadia1_idx` (`idEstadoEstadia`),
  CONSTRAINT `fk_Estadia_Cliente1` FOREIGN KEY (`idCliente`) REFERENCES `cliente` (`idCliente`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Estadia_EstadoEstadia1` FOREIGN KEY (`idEstadoEstadia`) REFERENCES `estadoestadia` (`idEstadoEstadia`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Estadia_Promocion1` FOREIGN KEY (`idPromocion`) REFERENCES `promocion` (`idPromocion`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estadia`
--

LOCK TABLES `estadia` WRITE;
/*!40000 ALTER TABLE `estadia` DISABLE KEYS */;
/*!40000 ALTER TABLE `estadia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `estadiaxhabitacion`
--

DROP TABLE IF EXISTS `estadiaxhabitacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `estadiaxhabitacion` (
  `idEstadia` int(11) NOT NULL,
  `idHabitacion` int(11) NOT NULL,
  PRIMARY KEY (`idEstadia`,`idHabitacion`),
  KEY `fk_Estadia_has_Habitacion_Habitacion1_idx` (`idHabitacion`),
  KEY `fk_Estadia_has_Habitacion_Estadia1_idx` (`idEstadia`),
  CONSTRAINT `fk_Estadia_has_Habitacion_Estadia1` FOREIGN KEY (`idEstadia`) REFERENCES `estadia` (`idEstadia`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Estadia_has_Habitacion_Habitacion1` FOREIGN KEY (`idHabitacion`) REFERENCES `habitacion` (`idHabitacion`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estadiaxhabitacion`
--

LOCK TABLES `estadiaxhabitacion` WRITE;
/*!40000 ALTER TABLE `estadiaxhabitacion` DISABLE KEYS */;
/*!40000 ALTER TABLE `estadiaxhabitacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `estadoestadia`
--

DROP TABLE IF EXISTS `estadoestadia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `estadoestadia` (
  `idEstadoEstadia` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(45) NOT NULL,
  PRIMARY KEY (`idEstadoEstadia`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estadoestadia`
--

LOCK TABLES `estadoestadia` WRITE;
/*!40000 ALTER TABLE `estadoestadia` DISABLE KEYS */;
/*!40000 ALTER TABLE `estadoestadia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `factura`
--

DROP TABLE IF EXISTS `factura`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `factura` (
  `idFactura` int(11) NOT NULL AUTO_INCREMENT,
  `fecha` date NOT NULL,
  `total` float NOT NULL,
  `pagado` tinyint(1) NOT NULL DEFAULT '0',
  `idEstadia` int(11) NOT NULL,
  PRIMARY KEY (`idFactura`),
  KEY `fk_Factura_Estadia1_idx` (`idEstadia`),
  CONSTRAINT `fk_Factura_Estadia1` FOREIGN KEY (`idEstadia`) REFERENCES `estadia` (`idEstadia`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `factura`
--

LOCK TABLES `factura` WRITE;
/*!40000 ALTER TABLE `factura` DISABLE KEYS */;
/*!40000 ALTER TABLE `factura` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `habitacion`
--

DROP TABLE IF EXISTS `habitacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `habitacion` (
  `idHabitacion` int(11) NOT NULL AUTO_INCREMENT,
  `capacidadMaxima` int(11) NOT NULL,
  `disponible` tinyint(1) NOT NULL,
  `precioNoche` float NOT NULL,
  `precioTemporada` float NOT NULL,
  `idTipoHabitacion` int(11) NOT NULL,
  PRIMARY KEY (`idHabitacion`),
  KEY `fk_Habitacion_TipoHabitacion1_idx` (`idTipoHabitacion`),
  CONSTRAINT `fk_Habitacion_TipoHabitacion1` FOREIGN KEY (`idTipoHabitacion`) REFERENCES `tipohabitacion` (`idTipoHabitacion`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `habitacion`
--

LOCK TABLES `habitacion` WRITE;
/*!40000 ALTER TABLE `habitacion` DISABLE KEYS */;
/*!40000 ALTER TABLE `habitacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `itemfactura`
--

DROP TABLE IF EXISTS `itemfactura`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `itemfactura` (
  `idItemFactura` int(11) NOT NULL AUTO_INCREMENT,
  `detalle` varchar(45) NOT NULL,
  `importe` float NOT NULL,
  `cantidad` int(11) NOT NULL,
  `idFactura` int(11) NOT NULL,
  PRIMARY KEY (`idItemFactura`),
  KEY `fk_ItemFactura_Factura1_idx` (`idFactura`),
  CONSTRAINT `fk_ItemFactura_Factura1` FOREIGN KEY (`idFactura`) REFERENCES `factura` (`idFactura`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `itemfactura`
--

LOCK TABLES `itemfactura` WRITE;
/*!40000 ALTER TABLE `itemfactura` DISABLE KEYS */;
/*!40000 ALTER TABLE `itemfactura` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `login`
--

DROP TABLE IF EXISTS `login`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `login` (
  `usuario` varchar(45) NOT NULL,
  `clave` varchar(45) DEFAULT NULL,
  `privilegio` smallint(6) DEFAULT NULL,
  `idUsuario` int(11) NOT NULL,
  `idCliente` int(11) NOT NULL,
  PRIMARY KEY (`usuario`),
  KEY `fk_Login_Usuario1_idx` (`idUsuario`),
  KEY `fk_Login_Cliente1_idx` (`idCliente`),
  CONSTRAINT `fk_Login_Cliente1` FOREIGN KEY (`idCliente`) REFERENCES `cliente` (`idCliente`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Login_Usuario1` FOREIGN KEY (`idUsuario`) REFERENCES `usuario` (`idUsuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `login`
--

LOCK TABLES `login` WRITE;
/*!40000 ALTER TABLE `login` DISABLE KEYS */;
/*!40000 ALTER TABLE `login` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `promocion`
--

DROP TABLE IF EXISTS `promocion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `promocion` (
  `idPromocion` int(11) NOT NULL AUTO_INCREMENT,
  `fechaInicio` date NOT NULL,
  `fechaFin` date NOT NULL,
  `descuento` double NOT NULL,
  PRIMARY KEY (`idPromocion`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `promocion`
--

LOCK TABLES `promocion` WRITE;
/*!40000 ALTER TABLE `promocion` DISABLE KEYS */;
/*!40000 ALTER TABLE `promocion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `recibo`
--

DROP TABLE IF EXISTS `recibo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `recibo` (
  `idRecibo` int(11) NOT NULL AUTO_INCREMENT,
  `fecha` date NOT NULL,
  `importe` double NOT NULL,
  `formaPago` varchar(45) NOT NULL,
  `idFactura` int(11) NOT NULL,
  PRIMARY KEY (`idRecibo`),
  KEY `fk_Recibo_Factura1_idx` (`idFactura`),
  CONSTRAINT `fk_Recibo_Factura1` FOREIGN KEY (`idFactura`) REFERENCES `factura` (`idFactura`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recibo`
--

LOCK TABLES `recibo` WRITE;
/*!40000 ALTER TABLE `recibo` DISABLE KEYS */;
/*!40000 ALTER TABLE `recibo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ticketconsumo`
--

DROP TABLE IF EXISTS `ticketconsumo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ticketconsumo` (
  `idTicketConsumo` int(11) NOT NULL AUTO_INCREMENT,
  `descrpcion` varchar(45) NOT NULL,
  `precio` float NOT NULL,
  `fechaDePago` date NOT NULL,
  `idEstadia` int(11) NOT NULL,
  PRIMARY KEY (`idTicketConsumo`),
  KEY `fk_TicketConsumo_Estadia1_idx` (`idEstadia`),
  CONSTRAINT `fk_TicketConsumo_Estadia1` FOREIGN KEY (`idEstadia`) REFERENCES `estadia` (`idEstadia`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ticketconsumo`
--

LOCK TABLES `ticketconsumo` WRITE;
/*!40000 ALTER TABLE `ticketconsumo` DISABLE KEYS */;
/*!40000 ALTER TABLE `ticketconsumo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ticketlimpieza`
--

DROP TABLE IF EXISTS `ticketlimpieza`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ticketlimpieza` (
  `idTicketLimpieza` int(11) NOT NULL AUTO_INCREMENT,
  `realizado` varchar(45) NOT NULL,
  `fecha` date NOT NULL,
  `idTipoLimpieza` int(11) NOT NULL,
  `usuario` varchar(45) NOT NULL,
  PRIMARY KEY (`idTicketLimpieza`),
  KEY `fk_TicketLimpieza_TipoLimpieza1_idx` (`idTipoLimpieza`),
  KEY `fk_TicketLimpieza_Login1_idx` (`usuario`),
  CONSTRAINT `fk_TicketLimpieza_Login1` FOREIGN KEY (`usuario`) REFERENCES `login` (`usuario`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_TicketLimpieza_TipoLimpieza1` FOREIGN KEY (`idTipoLimpieza`) REFERENCES `tipolimpieza` (`idTipoLimpieza`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ticketlimpieza`
--

LOCK TABLES `ticketlimpieza` WRITE;
/*!40000 ALTER TABLE `ticketlimpieza` DISABLE KEYS */;
/*!40000 ALTER TABLE `ticketlimpieza` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ticketmantenimiento`
--

DROP TABLE IF EXISTS `ticketmantenimiento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ticketmantenimiento` (
  `idTicketMantenimiento` int(11) NOT NULL AUTO_INCREMENT,
  `fechaGeneracion` date NOT NULL,
  `lugar` varchar(45) NOT NULL,
  `problema` varchar(45) NOT NULL,
  `observacion` varchar(45) NOT NULL,
  `reparado` tinyint(1) NOT NULL DEFAULT '0',
  `fechaInicio` date NOT NULL,
  `fechaFinalizacion` date DEFAULT NULL,
  `usuario` varchar(45) NOT NULL,
  PRIMARY KEY (`idTicketMantenimiento`),
  KEY `fk_TicketMantenimiento_Login1_idx` (`usuario`),
  CONSTRAINT `fk_TicketMantenimiento_Login1` FOREIGN KEY (`usuario`) REFERENCES `login` (`usuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ticketmantenimiento`
--

LOCK TABLES `ticketmantenimiento` WRITE;
/*!40000 ALTER TABLE `ticketmantenimiento` DISABLE KEYS */;
/*!40000 ALTER TABLE `ticketmantenimiento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipohabitacion`
--

DROP TABLE IF EXISTS `tipohabitacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipohabitacion` (
  `idTipoHabitacion` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(45) NOT NULL,
  `precioTemporadaBaja` float NOT NULL,
  `precioTemporadaAlta` float NOT NULL,
  PRIMARY KEY (`idTipoHabitacion`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipohabitacion`
--

LOCK TABLES `tipohabitacion` WRITE;
/*!40000 ALTER TABLE `tipohabitacion` DISABLE KEYS */;
/*!40000 ALTER TABLE `tipohabitacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipolimpieza`
--

DROP TABLE IF EXISTS `tipolimpieza`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipolimpieza` (
  `idTipoLimpieza` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(45) NOT NULL,
  PRIMARY KEY (`idTipoLimpieza`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipolimpieza`
--

LOCK TABLES `tipolimpieza` WRITE;
/*!40000 ALTER TABLE `tipolimpieza` DISABLE KEYS */;
/*!40000 ALTER TABLE `tipolimpieza` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipousuario`
--

DROP TABLE IF EXISTS `tipousuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipousuario` (
  `idTipoUsuario` int(11) NOT NULL AUTO_INCREMENT,
  `tipo` varchar(45) NOT NULL,
  PRIMARY KEY (`idTipoUsuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipousuario`
--

LOCK TABLES `tipousuario` WRITE;
/*!40000 ALTER TABLE `tipousuario` DISABLE KEYS */;
/*!40000 ALTER TABLE `tipousuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario` (
  `idUsuario` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `apellido` varchar(45) NOT NULL,
  `dni` int(11) NOT NULL,
  `baja` tinyint(1) DEFAULT NULL,
  `idTipoUsuario` int(11) NOT NULL,
  PRIMARY KEY (`idUsuario`),
  KEY `fk_Usuario_TipoUsuario_idx` (`idTipoUsuario`),
  CONSTRAINT `fk_Usuario_TipoUsuario` FOREIGN KEY (`idTipoUsuario`) REFERENCES `tipousuario` (`idTipoUsuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-05-04  0:17:06
