-- Eliminado de las Tablas
DROP TABLE IF EXISTS linea_orden_pedido;
DROP TABLE IF EXISTS producto_presentacion;
DROP TABLE IF EXISTS producto;
DROP TABLE IF EXISTS presentacion;
DROP TABLE IF EXISTS orden_pedido;
DROP TABLE IF EXISTS cliente;
DROP TABLE IF EXISTS empleado;
DROP TABLE IF EXISTS area;
DROP TABLE IF EXISTS persona;
-- Creación de las Tablas
CREATE TABLE persona(
	id_persona INT AUTO_INCREMENT,
    nombre_completo VARCHAR(150),
    DNI VARCHAR(8),
    fecha_nacimiento DATE,
    edad INT,
    genero CHAR,
    PRIMARY KEY(id_persona)
)ENGINE=innodb;
CREATE TABLE area(
	id_area INT AUTO_INCREMENT,
    nombre VARCHAR(100),
	activo TINYINT,
    PRIMARY KEY(id_area)
)ENGINE=innodb;
CREATE TABLE empleado(
	id_empleado INT,
    fid_area INT,
    cargo VARCHAR(100),
    sueldo DECIMAL(10,2),
	activo TINYINT,
    PRIMARY KEY(id_empleado),
    FOREIGN KEY(id_empleado) REFERENCES persona(id_persona),
    FOREIGN KEY (fid_area) REFERENCES area(id_area)
)ENGINE=innodb;
CREATE TABLE cliente(
	id_cliente INT,
	categoria VARCHAR(10),
	linea_credito DECIMAL(10,2),
    activo TINYINT,
	PRIMARY KEY(id_cliente),
	FOREIGN KEY (id_cliente) REFERENCES persona(id_persona)
)ENGINE=innodb;
CREATE TABLE orden_pedido(
	id_orden_pedido INT AUTO_INCREMENT,
    fid_cliente INT,
    fid_empleado INT,
	fecha DATE,
    total DECIMAL(10,2),
    activo TINYINT,
    PRIMARY KEY(id_orden_pedido),
    FOREIGN KEY(fid_cliente) REFERENCES cliente(id_cliente),
    FOREIGN KEY(fid_empleado) REFERENCES empleado(id_empleado)
)ENGINE=innodb;
CREATE TABLE producto(
	id_producto INT AUTO_INCREMENT,
    nombre VARCHAR(100),
    PRIMARY KEY(id_producto)
)ENGINE=innodb;
CREATE TABLE presentacion(
	id_presentacion INT AUTO_INCREMENT,
    unidad_medida VARCHAR(100),
    PRIMARY KEY(id_presentacion)
)ENGINE=innodb;
CREATE TABLE producto_presentacion(
	id_producto_presentacion INT AUTO_INCREMENT,
    fid_producto INT,
    fid_presentacion INT,
    precio DECIMAL(10,2),
    activo TINYINT,
    PRIMARY KEY(id_producto_presentacion),
    FOREIGN KEY(fid_producto) REFERENCES producto(id_producto),
    FOREIGN KEY(fid_presentacion) REFERENCES presentacion(id_presentacion)
)ENGINE=innodb;
CREATE TABLE linea_orden_pedido(
	id_linea_orden_pedido INT AUTO_INCREMENT,
    fid_orden_pedido INT,
    fid_producto_presentacion INT,
    cantidad INT,
    subtotal DECIMAL(10,2),
    activo TINYINT,
    PRIMARY KEY(id_linea_orden_pedido),
    FOREIGN KEY(fid_orden_pedido) REFERENCES orden_pedido(id_orden_pedido),
    FOREIGN KEY(fid_producto_presentacion) REFERENCES producto_presentacion(id_producto_presentacion)
)ENGINE=innodb;
-- Registro de algunas areas
INSERT INTO area(nombre,activo) VALUES('GERENCIA',1);
INSERT INTO area(nombre,activo) VALUES('CONTABILIDAD',1);
INSERT INTO area(nombre,activo) VALUES('FINANZAS',1);
-- Eliminar los Procedimientos Almacenados
DROP PROCEDURE IF EXISTS INSERTAR_EMPLEADO;
DROP PROCEDURE IF EXISTS MODIFICAR_EMPLEADO;
DROP PROCEDURE IF EXISTS ELIMINAR_EMPLEADO;
DROP PROCEDURE IF EXISTS LISTAR_EMPLEADOS;
DROP PROCEDURE IF EXISTS INSERTAR_AREA;
DROP PROCEDURE IF EXISTS MODIFICAR_AREA;
DROP PROCEDURE IF EXISTS ELIMINAR_AREA;
DROP PROCEDURE IF EXISTS LISTAR_AREAS;
DROP PROCEDURE IF EXISTS LISTAR_EMPLEADOS_X_NOMBRE;
DROP PROCEDURE IF EXISTS INSERTAR_CLIENTE;
DROP PROCEDURE IF EXISTS LISTAR_CLIENTES_X_NOMBRE_DNI;
DROP PROCEDURE IF EXISTS INSERTAR_PRESENTACION;
DROP PROCEDURE IF EXISTS INSERTAR_PRODUCTO;
DROP PROCEDURE IF EXISTS INSERTAR_PRODUCTO_PRESENTACION;
DROP PROCEDURE IF EXISTS LISTAR_PRODUCTOS_PRESENTACION_X_NOMBRE;
DROP PROCEDURE IF EXISTS INSERTAR_ORDEN_PEDIDO;
DROP PROCEDURE IF EXISTS INSERTAR_LINEA_ORDEN_PEDIDO;
-- Procedimientos Almacenados
DELIMITER $
CREATE PROCEDURE INSERTAR_EMPLEADO(
	OUT _id_empleado INT,
    IN _fid_area INT,
    IN _nombre_completo VARCHAR(150),
    IN _DNI VARCHAR(8),
    IN _fecha_nacimiento DATE,
    IN _edad INT,
    IN _genero CHAR,
    IN _cargo VARCHAR(100),
    IN _sueldo DECIMAL(10,2)
)
BEGIN
	INSERT INTO persona(nombre_completo,DNI,fecha_nacimiento,
    edad,genero) VALUES(_nombre_completo,_DNI,_fecha_nacimiento,
    _edad,_genero);
    SET _id_empleado = @@last_insert_id;
    INSERT INTO empleado(id_empleado,fid_area,cargo,sueldo,
    activo) VALUES(_id_empleado,_fid_area,_cargo,_sueldo,1);
END$
CREATE PROCEDURE MODIFICAR_EMPLEADO(
	IN _id_empleado INT,
    IN _fid_area INT,
    IN _nombre_completo VARCHAR(150),
    IN _DNI VARCHAR(8),
    IN _fecha_nacimiento DATE,
    IN _edad INT,
    IN _genero CHAR,
    IN _cargo VARCHAR(100),
    IN _sueldo DECIMAL(10,2)
)
BEGIN
	UPDATE persona SET nombre_completo = _nombre_completo, DNI = _DNI,fecha_nacimiento = _fecha_nacimiento, edad = _edad, genero = _genero WHERE id_persona = _id_empleado;
    UPDATE empleado SET fid_area = _fid_area, cargo = _cargo, sueldo = _sueldo WHERE id_empleado = _id_empleado;
END$
CREATE PROCEDURE ELIMINAR_EMPLEADO(
	IN _id_empleado INT
)
BEGIN
	UPDATE empleado SET activo = 0 WHERE id_empleado = _id_empleado;
END$
CREATE PROCEDURE LISTAR_EMPLEADOS()
BEGIN
	SELECT p.id_persona, p.nombre_completo, p.DNI, p.fecha_nacimiento, p.edad, p.genero, e.cargo, e.sueldo, a.id_area, a.nombre as nombre_area FROM persona p INNER JOIN empleado e ON p.id_persona = e.id_empleado INNER JOIN area a ON e.fid_area = a.id_area WHERE e.activo = 1;
END$
CREATE PROCEDURE INSERTAR_AREA(
	OUT _id_area INT,
	IN _nombre VARCHAR(100)
)
BEGIN
	INSERT INTO area(nombre,activo) VALUES(_nombre,1);
	SET _id_area = @@last_insert_id;
END$
CREATE PROCEDURE MODIFICAR_AREA(
	IN _id_area INT,
	IN _nombre VARCHAR(100)
)
BEGIN
	UPDATE area SET nombre = _nombre WHERE id_area = _id_area;
END$
CREATE PROCEDURE ELIMINAR_AREA(
	IN _id_area INT
)
BEGIN
	UPDATE area SET activo = 0 WHERE id_area = _id_area;
END$
CREATE PROCEDURE LISTAR_AREAS()
BEGIN
	SELECT id_area, nombre FROM area WHERE activo = 1;
END$
CREATE PROCEDURE LISTAR_EMPLEADOS_X_NOMBRE(
	IN _nombre VARCHAR(150)
)
BEGIN
	SELECT p.id_persona, p.nombre_completo, p.DNI, p.fecha_nacimiento, p.edad, p.genero, e.cargo, e.sueldo, a.id_area, a.nombre as nombre_area FROM persona p INNER JOIN empleado e ON p.id_persona = e.id_empleado INNER JOIN area a ON e.fid_area = a.id_area WHERE e.activo = 1 AND (p.nombre_completo LIKE CONCAT('%',_nombre,'%'));
END$
CREATE PROCEDURE INSERTAR_CLIENTE(
	OUT _id_cliente INT,
    IN _nombre_completo VARCHAR(150),
    IN _DNI VARCHAR(8),
    IN _fecha_nacimiento DATE,
    IN _edad INT,
    IN _genero CHAR,
    IN _categoria VARCHAR(10),
    IN _linea_credito DECIMAL(10,2)
)
BEGIN
	INSERT INTO persona(nombre_completo,DNI,fecha_nacimiento,edad,genero) VALUES(_nombre_completo,_DNI,_fecha_nacimiento,_edad,_genero);
	SET _id_cliente = @@last_insert_id;
	INSERT INTO cliente(id_cliente,categoria,linea_credito,activo) VALUES(_id_cliente,_categoria,_linea_credito,1);
END$
CREATE PROCEDURE LISTAR_CLIENTES_X_NOMBRE_DNI(
	IN _nombreDNI VARCHAR(150)
)
BEGIN
	SELECT p.id_persona, p.nombre_completo, p.DNI, p.fecha_nacimiento, p.edad, p.genero, c.categoria, c.linea_credito FROM persona p INNER JOIN cliente c ON p.id_persona = c.id_cliente WHERE (p.nombre_completo LIKE CONCAT('%',_nombreDNI,'%')) OR (p.DNI LIKE CONCAT('%',_nombreDNI,'%'));
END$
CREATE PROCEDURE INSERTAR_PRESENTACION(
	OUT _id_presentacion INT,
	IN _unidad_medida VARCHAR(100)
)
BEGIN
	INSERT INTO presentacion(unidad_medida) VALUES(_unidad_medida);
    SET _id_presentacion = @@last_insert_id;
END$
CREATE PROCEDURE INSERTAR_PRODUCTO(
	OUT _id_producto INT,
    IN _nombre VARCHAR(100)
)
BEGIN
	INSERT INTO producto(nombre) VALUES(_nombre);
    SET _id_producto = @@last_insert_id;
END$
CREATE PROCEDURE INSERTAR_PRODUCTO_PRESENTACION(
	OUT _id_producto_presentacion INT,
    IN _fid_producto INT,
    IN _fid_presentacion INT,
    IN _precio DECIMAL(10,2)
)
BEGIN
	INSERT INTO producto_presentacion(fid_producto,fid_presentacion,precio,activo) VALUES(_fid_producto,_fid_presentacion,_precio,1);
    SET _id_producto_presentacion = @@last_insert_id;
END$
CREATE PROCEDURE LISTAR_PRODUCTOS_PRESENTACION_X_NOMBRE(
	_nombre VARCHAR(100)
)
BEGIN
	SELECT pp.id_producto_presentacion, prod.id_producto, prod.nombre, pres.id_presentacion, pres.unidad_medida, pp.precio FROM producto_presentacion pp INNER JOIN producto prod ON pp.fid_producto = prod.id_producto INNER JOIN presentacion pres ON pres.id_presentacion = pp.fid_presentacion WHERE prod.nombre LIKE CONCAT('%',_nombre,'%') AND activo = 1;
END$
CREATE PROCEDURE INSERTAR_ORDEN_PEDIDO(
	OUT _id_orden_pedido INT,
    IN _fid_cliente INT,
    IN _total DECIMAL(10,2)
)
BEGIN
	INSERT INTO orden_pedido(fid_cliente,fecha,total,activo) VALUES(_fid_cliente,CURDATE(),_total,1);
    SET _id_orden_pedido = @@last_insert_id;
END$
CREATE PROCEDURE INSERTAR_LINEA_ORDEN_PEDIDO(
	OUT _id_linea_orden_pedido INT,
    IN _fid_orden_pedido INT,
    IN _fid_producto_presentacion INT,
    IN _cantidad INT,
    IN _subtotal DECIMAL(10,2)
)
BEGIN
	INSERT INTO linea_orden_pedido(fid_orden_pedido,fid_producto_presentacion,cantidad,subtotal,activo) VALUES(_fid_orden_pedido,_fid_producto_presentacion,_cantidad,_subtotal,1);
	SET _id_linea_orden_pedido = @@last_insert_id;
END$
DELIMITER ;
-- Se insertan los empleados
CALL INSERTAR_EMPLEADO(@id,2,'Karla Stephany Sanchez Santisteban','29881209','1994-05-02',27,'F','Contadora',1500.00);
-- Se insertan los clientes
CALL INSERTAR_CLIENTE(@idCliente1,'Juan Arenas Iparraguirre','33620929','1984-10-09',37,'M','VIP',3700.00);
-- Se insertan los productos
CALL INSERTAR_PRODUCTO(@idProducto1,'GASEOSA INKA KOLA');
CALL INSERTAR_PRODUCTO(@idProducto2,'GASEOSA COCA COLA');
CALL INSERTAR_PRODUCTO(@idProducto3,'DETERGENTE LIQUIDO BOLIVAR');
CALL INSERTAR_PRODUCTO(@idProducto4,'LAVAVAJILLAS EN PASTA LIMON SAPOLIO');
-- Se insertan las presentaciones
CALL INSERTAR_PRESENTACION(@idPresentacion1,'500 ML');
CALL INSERTAR_PRESENTACION(@idPresentacion2,'1.5 LT');
CALL INSERTAR_PRESENTACION(@idPresentacion3,'940 ML');
CALL INSERTAR_PRESENTACION(@idPresentacion4,'900 GR');
-- Se insertar los productos presentacion
CALL INSERTAR_PRODUCTO_PRESENTACION(@idProdPres1,@idProducto1,@idPresentacion1,2.70);
CALL INSERTAR_PRODUCTO_PRESENTACION(@idProdPres2,@idProducto2,@idPresentacion2,5.90);
CALL INSERTAR_PRODUCTO_PRESENTACION(@idProdPres3,@idProducto3,@idPresentacion3,16.00);
CALL INSERTAR_PRODUCTO_PRESENTACION(@idProdPres4,@idProducto4,@idPresentacion4,6.10);
-- Se inserta una venta
CALL INSERTAR_ORDEN_PEDIDO(@idPedido1,@idCliente1,53.40);
-- Se inserta detalle_venta
CALL INSERTAR_LINEA_ORDEN_PEDIDO(@id,@idPedido1,@idProdPres1,2,5.40);
CALL INSERTAR_LINEA_ORDEN_PEDIDO(@id,@idPedido1,@idProdPres3,3,48.00);