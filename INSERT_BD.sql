INSERT INTO `tpcuatrimestralmapeo`.`habitacion` (`capacidadMaxima`, `disponible`, `precioNoche`, `precioTemporada`) VALUES ('2', '0', '100', '1200');
INSERT INTO `tpcuatrimestralmapeo`.`habitacion` (`capacidadMaxima`, `disponible`, `precioNoche`, `precioTemporada`) VALUES ('1', '0', '300', '4000');
INSERT INTO `tpcuatrimestralmapeo`.`habitacion` (`capacidadMaxima`, `disponible`, `precioNoche`, `precioTemporada`) VALUES ('4', '0', '600', '6000');
INSERT INTO `tpcuatrimestralmapeo`.`habitacion` (`capacidadMaxima`, `disponible`, `precioNoche`, `precioTemporada`) VALUES ('2', '0', '250', '3000');
INSERT INTO `tpcuatrimestralmapeo`.`habitacion` (`capacidadMaxima`, `disponible`, `precioNoche`, `precioTemporada`) VALUES ('1', '0', '500', '5000');
INSERT INTO `tpcuatrimestralmapeo`.`habitacion` (`capacidadMaxima`, `disponible`, `precioNoche`, `precioTemporada`) VALUES ('4', '0', '180', '3000');
INSERT INTO `tpcuatrimestralmapeo`.`habitacion` (`capacidadMaxima`, `disponible`, `precioNoche`, `precioTemporada`) VALUES ('2', '0', '600', '6500');
INSERT INTO `tpcuatrimestralmapeo`.`habitacion` (`capacidadMaxima`, `disponible`, `precioNoche`, `precioTemporada`) VALUES ('4', '0', '250', '2300');
INSERT INTO `tpcuatrimestralmapeo`.`habitacion` (`capacidadMaxima`, `disponible`, `precioNoche`, `precioTemporada`) VALUES ('1', '0', '1000', '8500');
INSERT INTO `tpcuatrimestralmapeo`.`habitacion` (`capacidadMaxima`, `disponible`, `precioNoche`, `precioTemporada`) VALUES ('2', '0', '550', '4800');

-- tipos de usuario 1: admin 2: limpieza 3: mantenimiento 4: cliente
INSERT INTO `tpcuatrimestral`.`tipousuario` (`tipo`) VALUES ('admin');
INSERT INTO `tpcuatrimestral`.`tipousuario` (`tipo`) VALUES ('empleadoLimpieza');
INSERT INTO `tpcuatrimestral`.`tipousuario` (`tipo`) VALUES ('empleadoMantenimiento');
INSERT INTO `tpcuatrimestral`.`tipousuario` (`tipo`) VALUES ('cliente');

-- usuario
INSERT INTO `tpcuatrimestral`.`usuario` (`nombre`, `apellido`, `dni`, `usuario`, `clave`, `baja`, `idTipoUsuario`, `idLogin`) VALUES ('Alejandro', 'Canosa', '38701487', 'canosa', '123', '0', '1', '1');

-- login para usuario
INSERT INTO `tpcuatrimestral`.`login` (`usuario`, `clave`, `privilegio`) VALUES ('canosa', '123', '1');
