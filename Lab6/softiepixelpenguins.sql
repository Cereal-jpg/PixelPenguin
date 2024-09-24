
CREATE TABLE ROL (
	idRol INT PRIMARY KEY,
    nombre VARCHAR(20) NOT NULL
);

CREATE TABLE Usuario (
	dni INT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    fechaNacimiento DATE NOT NULL,
    direccion VARCHAR(255) NOT NULL,
    email VARCHAR(100) NOT NULL,
    sexo VARCHAR(10) NOT NULL,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(100) NOT NULL,
    rol INT NOT NULL,
    institucion INT NOT NULL,
    FOREIGN KEY (insitucion) REFERENCES Institucion(idInstitucion),
    FOREIGN KEY (rol) REFERENCES Rol(idRol)
);

CREATE TABLE Apoderado (
	dni INT PRIMARY KEY,
    telefono VARCHAR(20) NOT NULL
);

CREATE TABLE Alumno (
	codigoAlumno INT PRIMARY KEY,
	certificadoDeEstudios BOOLEAN NOT NULL,
    certificadoDeSalud BOOLEAN NOT NULL,
    deuda BOOLEAN NOT NULL,
    dni INT NOT NULL UNIQUE,
    apoderado INT NOT NULL,
    seccionAcademica INT NOT NULL,
    FOREIGN KEY (seccionAcademica) REFERENCES SeccionAcademica(idSeccionAcademica),
    FOREIGN KEY (apoderado) REFERENCES Apoderado(dni),
    FOREIGN KEY (dni) REFERENCES Usuario(dni)
);

CREATE TABLE Profesor (
	codigoProfesor INT PRIMARY KEY,
    certificadoHistorialEducativo BOOLEAN NOT NULL,
    especialidad VARCHAR(100) NOT NULL,
    dni INT NOT NULL UNIQUE, 
    FOREIGN KEY (dni) REFERENCES Usuario(dni)
);

CREATE TABLE Administrador (
	codigoAdministrador INT PRIMARY KEY,
    dni INT NOT NULL UNIQUE,
    FOREIGN KEY (dni) REFERENCES Usuario(dni)
);

CREATE TABLE EquipoAdministrativo (
	idEquipoAdministrativo INT PRIMARY KEY,
    codigoAdministrador INT UNIQUE,
    FOREIGN KEY (codigoAdministrador) REFERENCES Administrador(codigoAdministrador)
);

CREATE TABLE AlumnoCurso (
	codigoAlumno INT NOT NULL,
    idCurso INT NOT NULL,
    PRIMARY KEY (codigoAlumno, idCurso),
    FOREIGN KEY (codigoAlumno) REFERENCES Alumno(codigoAlumno),
    FOREIGN KEY (idCurso) REFERENCES Curso(idCurso)
);

CREATE TABLE AlumnoGrado (
	codigoAlumno INT NOT NULL,
    idGradoAcademico INT NOT NULL,
    PRIMARY KEY (codigoAlumno, idGradoAcademico),
    FOREIGN KEY (codigoAlumno) REFERENCES Alumno(codigoAlumno),
    FOREIGN KEY (idGradoAcademico) REFERENCES GradoAcademico(idGradoAcademico)
);

CREATE TABLE ProfesorGrado (
	codigoProfesor INT NOT NULL,
    idGradoAcademico INT NOT NULL,
	PRIMARY KEY (codigoProfesor, idGradoAcademico),
    FOREIGN KEY (codigoProfesor) REFERENCES Profesor(codigoProfesor),
    FOREIGN KEY (idGradoAcademico) REFERENCES GradoAcademico(idGradoAcademico)
);


