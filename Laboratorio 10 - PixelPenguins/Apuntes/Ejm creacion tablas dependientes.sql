DROP TABLE IF EXISTS empleado;
DROP TABLE IF EXISTS area;
DROP TABLE IF EXISTS persona;
DROP PROCEDURE IF EXISTS INSERTAR_EMPLEADO;

CREATE TABLE persona(
	id_persona INT AUTO_INCREMENT,
	nombre_completo VARCHAR(50),
	DNI VARCHAR(50),
	fecha_nacimiento DATE,
	edad INT,
	genero char,
	PRIMARY KEY(id_persona)
)ENGINE=InnoDB;

CREATE TABLE area(
	id_area INT AUTO_INCREMENT,
	nombre VARCHAR(100),
    activo TINYINT,
	PRIMARY KEY(id_area)
)ENGINE=InnoDB;

CREATE TABLE empleado(
	id_empleado int, -- el autoincrement ya lo tiene del padre
    -- FK de area
	fid_area int,
	cargo VARCHAR(100),
	sueldo DECIMAL(10,2),
    activo TINYINT,
	PRIMARY KEY(id_empleado),
	FOREIGN KEY(id_empleado) REFERENCES persona(id_persona),
	FOREIGN KEY(fid_area) REFERENCES area(id_area)
)ENGINE=InnoDB;
 