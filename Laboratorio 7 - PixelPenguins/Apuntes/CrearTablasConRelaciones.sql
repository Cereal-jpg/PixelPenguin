-- Créditos: ChatGPT

-- Relación 1 a Muchos

	CREATE TABLE Clientes (
		id INT AUTO_INCREMENT PRIMARY KEY,
		nombre VARCHAR(100),
		email VARCHAR(100)
	);

	CREATE TABLE Pedidos (
		id INT AUTO_INCREMENT PRIMARY KEY,
		fecha DATE,
		cliente_id INT,
		-- Definimos la clave foránea para la relación con la tabla Clientes
		CONSTRAINT fk_cliente
			FOREIGN KEY (cliente_id) 
			REFERENCES Clientes(id)
			ON DELETE CASCADE
	);


-- Relación Muchos a Muchos

	CREATE TABLE Estudiantes (
		id INT AUTO_INCREMENT PRIMARY KEY,
		nombre VARCHAR(100)
	);

	CREATE TABLE Cursos (
		id INT AUTO_INCREMENT PRIMARY KEY,
		nombre VARCHAR(100)
	);

	-- Tabla intermedia para la relación muchos a muchos
	CREATE TABLE Estudiantes_Cursos (
		estudiante_id INT,
		curso_id INT,
		PRIMARY KEY (estudiante_id, curso_id),
		-- Claves foráneas que referencian a las tablas Estudiantes y Cursos
		CONSTRAINT fk_estudiante
			FOREIGN KEY (estudiante_id)
			REFERENCES Estudiantes(id)
			ON DELETE CASCADE,
		CONSTRAINT fk_curso
			FOREIGN KEY (curso_id)
			REFERENCES Cursos(id)
			ON DELETE CASCADE
	);


-- Uno a muchos (opcional)

	CREATE TABLE Clientes (
		id INT AUTO_INCREMENT PRIMARY KEY,
		nombre VARCHAR(100),
		email VARCHAR(100)
	);

	CREATE TABLE Pedidos (
		id INT AUTO_INCREMENT PRIMARY KEY,
		fecha DATE,
		cliente_id INT NULL,  -- Relación opcional
		CONSTRAINT fk_cliente
			FOREIGN KEY (cliente_id)
			REFERENCES Clientes(id)
			ON DELETE SET NULL
	);

-- Muchos a muchos (opcional)

	CREATE TABLE Estudiantes (
		id INT AUTO_INCREMENT PRIMARY KEY,
		nombre VARCHAR(100)
	);

	CREATE TABLE Cursos (
		id INT AUTO_INCREMENT PRIMARY KEY,
		nombre VARCHAR(100)
	);

	-- Tabla intermedia con claves foráneas opcionales
	CREATE TABLE Estudiantes_Cursos (
		estudiante_id INT NULL,  -- Relación opcional
		curso_id INT NULL,       -- Relación opcional
		PRIMARY KEY (estudiante_id, curso_id),
		CONSTRAINT fk_estudiante
			FOREIGN KEY (estudiante_id)
			REFERENCES Estudiantes(id)
			ON DELETE SET NULL,
		CONSTRAINT fk_curso
			FOREIGN KEY (curso_id)
			REFERENCES Cursos(id)
			ON DELETE SET NULL
	);

-- Relación Uno a Uno

	CREATE TABLE Usuarios (
		id INT AUTO_INCREMENT PRIMARY KEY,
		nombre VARCHAR(100),
		email VARCHAR(100)
	);

	CREATE TABLE Perfiles (
		id INT AUTO_INCREMENT PRIMARY KEY,
		usuario_id INT UNIQUE,  -- Clave foránea única para asegurar la relación uno a uno
		direccion VARCHAR(255),
		telefono VARCHAR(20),
		-- Definimos la clave foránea con la restricción UNIQUE
		CONSTRAINT fk_usuario
			FOREIGN KEY (usuario_id)
			REFERENCES Usuarios(id)
			ON DELETE CASCADE
	);

-- Relación uno a Uno (usando mismo PK)
	
	CREATE TABLE Usuarios (
		id INT AUTO_INCREMENT PRIMARY KEY,
		nombre VARCHAR(100),
		email VARCHAR(100)
	);

	CREATE TABLE Perfiles (
		usuario_id INT PRIMARY KEY,  -- También es clave primaria
		direccion VARCHAR(255),
		telefono VARCHAR(20),
		-- Clave foránea hacia la tabla Usuarios
		CONSTRAINT fk_usuario
			FOREIGN KEY (usuario_id)
			REFERENCES Usuarios(id)
			ON DELETE CASCADE
	);
	
-- Relación Uno a Uno (opcional) : se puede hacer que la clave foránea acepte valores NULL

	CREATE TABLE Perfiles (
		id INT AUTO_INCREMENT PRIMARY KEY,
		usuario_id INT UNIQUE NULL,  -- Relación opcional
		direccion VARCHAR(255),
		telefono VARCHAR(20),
		CONSTRAINT fk_usuario
			FOREIGN KEY (usuario_id)
			REFERENCES Usuarios(id)
			ON DELETE SET NULL
	);


	
-- Tablas de clases que son hijas de otras

	-- Tabla de la clase padre
	CREATE TABLE Vehiculos (
		id INT AUTO_INCREMENT PRIMARY KEY,
		marca VARCHAR(100),
		modelo VARCHAR(100)
	);

	-- Tabla de la clase hija Auto
	CREATE TABLE Autos (
		id INT PRIMARY KEY,       -- Referencia a Vehiculos(id)
		puertas INT,
		CONSTRAINT fk_auto_vehiculo
			FOREIGN KEY (id)
			REFERENCES Vehiculos(id)
			ON DELETE CASCADE
	);

	-- Tabla de la clase hija Moto
	CREATE TABLE Motos (
		id INT PRIMARY KEY,       -- Referencia a Vehiculos(id)
		cilindrada INT,
		CONSTRAINT fk_moto_vehiculo
			FOREIGN KEY (id)
			REFERENCES Vehiculos(id)
			ON DELETE CASCADE
	);

