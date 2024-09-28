CREATE TABLE persona{
	id_persona INT AUTO_INCREMENT,
	nombre_completo VARCHAR(50),
	DNI VARCHAR(50),
	fecha_nacimiento DATE,
	edad INT,
	genero char,
	PRIMARY KEY(id_persona)
}ENGINE=InnoDB;

--InnoDB soporta llaves foráneas y mantiene la integridad referencial entre tablas,
--asegurando que las relaciones sean consistentes.

CREATE TABLE area{
	id_area INT AUTO_INCREMENT,
	nombre VARCHAR(100),
	PRIMARY KEY(id_area)
}ENGINE=InnoDB;

CREATE TABLE empleado{
	id_empleado int,
	fid_area int,
	cargo VARCHAR(100),
	sueldo DECIMAL(10,2),
	PRIMARY KEY(id_empleado),
	FOREIGN KEY(id_empleado) REFERENCES persona(id_persona),
	FOREIGN KEY(fid_area) REFERENCES area(id_area),
}ENGINE=InnoDB;