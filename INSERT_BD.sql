-- tipohabitacion

INSERT INTO `tpcuatrimestral`.`tipohabitacion` (`descripcion`, `precioTemporadaBaja`, `precioTemporadaAlta`) VALUES ('vip', '5000', '10000');
INSERT INTO `tpcuatrimestral`.`tipohabitacion` (`descripcion`, `precioTemporadaBaja`, `precioTemporadaAlta`) VALUES ('normal', '300', '6000');


-- habitacion
INSERT INTO `tpcuatrimestral`.`habitacion` (`capacidadMaxima`, `disponible`, `precioNoche`,`idTipoHabitacion`) VALUES ('2', '0', '100',2);
INSERT INTO `tpcuatrimestral`.`habitacion` (`capacidadMaxima`, `disponible`, `precioNoche`,`idTipoHabitacion`) VALUES ('1', '0', '300',2);
INSERT INTO `tpcuatrimestral`.`habitacion` (`capacidadMaxima`, `disponible`, `precioNoche`,`idTipoHabitacion`) VALUES ('4', '0', '600',2);
INSERT INTO `tpcuatrimestral`.`habitacion` (`capacidadMaxima`, `disponible`, `precioNoche`,`idTipoHabitacion`) VALUES ('2', '0', '250',2);
INSERT INTO `tpcuatrimestral`.`habitacion` (`capacidadMaxima`, `disponible`, `precioNoche`,`idTipoHabitacion`) VALUES ('1', '0', '500',1);
INSERT INTO `tpcuatrimestral`.`habitacion` (`capacidadMaxima`, `disponible`, `precioNoche`,`idTipoHabitacion`) VALUES ('4', '0', '180',2);
INSERT INTO `tpcuatrimestral`.`habitacion` (`capacidadMaxima`, `disponible`, `precioNoche`,`idTipoHabitacion`) VALUES ('2', '0', '600',2);
INSERT INTO `tpcuatrimestral`.`habitacion` (`capacidadMaxima`, `disponible`, `precioNoche`,`idTipoHabitacion`) VALUES ('4', '0', '250',2);
INSERT INTO `tpcuatrimestral`.`habitacion` (`capacidadMaxima`, `disponible`, `precioNoche`,`idTipoHabitacion`) VALUES ('1', '0', '1000',1);
INSERT INTO `tpcuatrimestral`.`habitacion` (`capacidadMaxima`, `disponible`, `precioNoche`,`idTipoHabitacion`) VALUES ('2', '0', '550',2);

-- tipos de usuario 1: admin 2: limpieza 3: mantenimiento 4: cliente
INSERT INTO `tpcuatrimestral`.`tipousuario` (`tipo`) VALUES ('admin');
INSERT INTO `tpcuatrimestral`.`tipousuario` (`tipo`) VALUES ('empleadoLimpieza');
INSERT INTO `tpcuatrimestral`.`tipousuario` (`tipo`) VALUES ('empleadoMantenimiento');
INSERT INTO `tpcuatrimestral`.`tipousuario` (`tipo`) VALUES ('cliente');

-- login para usuario
INSERT INTO `tpcuatrimestral`.`login` (`usuario`, `clave`, `privilegio`) VALUES ('canosa', '123', '1');
insert into `tpcuatrimestral`.`login` (`usuario`, `clave`, `privilegio`) VALUES ('cliente', '123', '4');
INSERT INTO `tpcuatrimestral`.`login` (`usuario`, `clave`, `privilegio`) VALUES ('mucama', '345', '2');
INSERT INTO `tpcuatrimestral`.`login` (`usuario`, `clave`, `privilegio`) VALUES ('emp', '567', '3');


-- usuario
INSERT INTO `tpcuatrimestral`.`usuario` (`nombre`, `apellido`, `dni`, `baja`, `idTipoUsuario`, `idLogin`) VALUES ('Alejandro', 'Canosa', '38701487','0', '1', '1');

