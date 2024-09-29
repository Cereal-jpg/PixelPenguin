-- Eliminado de las Tablas
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
    FOREIGN KEY (fid_area) REFERENCES area(id_area)
)ENGINE=innodb;
-- Registro de algunas areas
INSERT INTO area(nombre,activo) VALUES('Gerencia',1);
INSERT INTO area(nombre,activo) VALUES('Contabilidad',1);
INSERT INTO area(nombre,activo) VALUES('Finanzas',1);
-- Eliminar los Procedimientos Almacenados
DROP PROCEDURE IF EXISTS INSERTAR_EMPLEADO;
DROP PROCEDURE IF EXISTS MODIFICAR_EMPLEADO;
DROP PROCEDURE IF EXISTS ELIMINAR_EMPLEADO;
DROP PROCEDURE IF EXISTS LISTAR_EMPLEADOS;
DROP PROCEDURE IF EXISTS INSERTAR_AREA;
DROP PROCEDURE IF EXISTS MODIFICAR_AREA;
DROP PROCEDURE IF EXISTS ELIMINAR_AREA;
DROP PROCEDURE IF EXISTS LISTAR_AREAS;
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