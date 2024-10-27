CREATE TABLE InstitucionEducativa (
	idInstitucion INT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    cantidadAlumnos INT NOT NULL,
    direccion VARCHAR(255) NOT NULL,
    ruc INT NOT NULL UNIQUE
);

CREATE TABLE JornadaEscolar (
    idJornadaEscolar INT PRIMARY KEY,
    horaInicio TIME NOT NULL,
    horaFin TIME NOT NULL,
    horasDeEstudio INT NOT NULL,
    dia VARCHAR(10)
);

CREATE TABLE PlanAcademico (
    idPlanAcademico INT PRIMARY KEY,
    año INT NOT NULL,
    fechaInicio DATE NOT NULL,
    fechaFin DATE NOT NULL,
    idInstitucion INT NULL,
    FOREIGN KEY (idInstitucion) REFERENCES InstitucionEducativa(idInstitucion)
);

CREATE TABLE GradoAcademico (
	idGradoAcademico INT PRIMARY KEY,
    numeroGrado INT NOT NULL,
    nivel VARCHAR(20) NOT NULL,
    cantidadAlumnos INT NOT NULL,
    vacantes INT NOT NULL,
    idInstitucion INT NULL,
    idPlanAcademico INT NOT NULL,
    idJornadaEscolar INT NOT NULL,
    FOREIGN KEY (idJornadaEscolar) REFERENCES JornadaEscolar(idJornadaEscolar),
    FOREIGN KEY (idPlanAcademico) REFERENCES PlanAcademico(idPlanAcademico),
    FOREIGN KEY (idInstitucion) REFERENCES InstitucionEducativa(idInstitucion)
);

CREATE TABLE SeccionAcademica (
    idSeccionAcademica INT PRIMARY KEY,
    seccion CHAR (1),
    aula VARCHAR(50),
    idGradoAcademico INT NOT NULL,
    FOREIGN KEY (idGradoAcademico) REFERENCES GradoAcademico(idGradoAcademico)
);

CREATE TABLE Curso (
    idCurso VARCHAR(20) PRIMARY KEY,
    nombre VARCHAR(100),
    horasPorSemana INT NOT NULL,
    horasTotales INT NOT NULL 
);

CREATE TABLE Competencias (
    idCompetencia INT PRIMARY KEY,
    descripcion VARCHAR(255),
    idCurso VARCHAR(20) NOT NULL,
    FOREIGN KEY (idCurso) REFERENCES Curso(idCurso)
);

CREATE TABLE Nota (
    idNota INT NOT NULL,
    nota VARCHAR(10) NOT NULL,
    bimestre INT NOT NULL,
    idCurso VARCHAR(20) NOT NULL,
    idCompetencia INT NOT NULL,
    FOREIGN KEY (idCurso) REFERENCES Curso(idCurso),
    FOREIGN KEY (idCompetencia) REFERENCES Competencias(idCompetencia)
);

CREATE TABLE Rol (
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
    idRol INT NOT NULL,
    idInstitucion INT NOT NULL,
    FOREIGN KEY (idInstitucion) REFERENCES InstitucionEducativa(idInstitucion),
    FOREIGN KEY (idRol) REFERENCES Rol(idRol)
);

CREATE TABLE Profesor (
	codigoProfesor INT PRIMARY KEY,
    certificadoHistorialEducativo BOOLEAN NOT NULL,
    especialidad VARCHAR(100) NOT NULL,
    dni INT NOT NULL UNIQUE, 
    FOREIGN KEY (dni) REFERENCES Usuario(dni)
);

CREATE TABLE HoraAcademica (
    idHoraAcademica INT PRIMARY KEY,
    horaInicio TIME NOT NULL,
    horaFin TIME NOT NULL,
    idCurso VARCHAR(20) NOT NULL,
    codigoProfesor INT NOT NULL,
    FOREIGN KEY (idCurso) REFERENCES Curso(idCurso),
    FOREIGN KEY (codigoProfesor) REFERENCES Profesor(codigoProfesor)
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
    apoderado INT NULL,
    idSeccionAcademica INT NULL,
    FOREIGN KEY (idSeccionAcademica) REFERENCES SeccionAcademica(idSeccionAcademica),
    FOREIGN KEY (apoderado) REFERENCES Apoderado(dni),
    FOREIGN KEY (dni) REFERENCES Usuario(dni)
);

CREATE TABLE Matricula (
	idMatricula INT PRIMARY KEY,
    cumpleRequisitos BOOLEAN NOT NULL,
    fechaInicio DATE NOT NULL,
    fechaFin DATE NOT NULL,
    estado VARCHAR(20),
    idGradoAcademico INT NOT NULL,
    codigoAlumno INT NOT NULL,
    idPlanAcademico INT NOT NULL,
    FOREIGN KEY (idPlanAcademico) REFERENCES PlanAcademico(idPlanAcademico),
    FOREIGN KEY (codigoAlumno) REFERENCES Alumno(codigoAlumno),
    FOREIGN KEY (idGradoAcademico) REFERENCES GradoAcademico(idGradoAcademico)
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

CREATE TABLE Pago (
    idPago INT PRIMARY KEY,
    fechaCreacion DATE NOT NULL,
    fechaPago DATE NOT NULL,
    monto DOUBLE NOT NULL,
    tipoPago VARCHAR(30) NOT NULL,
    estado VARCHAR(30) NOT NULL,
    tipoDeComprobante VARCHAR(30) NOT NULL,
    idMatricula INT NOT NULL,
    FOREIGN KEY (idMatricula) REFERENCES Matricula(idMatricula)
);

CREATE TABLE AlumnoXCurso (
	codigoAlumno INT NOT NULL,
    idCurso VARCHAR(20) NOT NULL,
    PRIMARY KEY (codigoAlumno, idCurso),
    FOREIGN KEY (codigoAlumno) REFERENCES Alumno(codigoAlumno),
    FOREIGN KEY (idCurso) REFERENCES Curso(idCurso)
);

CREATE TABLE AlumnoXGrado (
	codigoAlumno INT NOT NULL,
    idGradoAcademico INT NOT NULL,
    PRIMARY KEY (codigoAlumno, idGradoAcademico),
    FOREIGN KEY (codigoAlumno) REFERENCES Alumno(codigoAlumno),
    FOREIGN KEY (idGradoAcademico) REFERENCES GradoAcademico(idGradoAcademico)
);

CREATE TABLE ProfesorXGrado (
	codigoProfesor INT NOT NULL,
    idGradoAcademico INT NOT NULL,
	PRIMARY KEY (codigoProfesor, idGradoAcademico),
    FOREIGN KEY (codigoProfesor) REFERENCES Profesor(codigoProfesor),
    FOREIGN KEY (idGradoAcademico) REFERENCES GradoAcademico(idGradoAcademico)
);

CREATE TABLE CursoXPlanAcademico (
    idCurso VARCHAR(20) NOT NULL,
    idPlanAcademico INT NOT NULL,
    PRIMARY KEY (idCurso,idPlanAcademico),
    FOREIGN KEY (idCurso) REFERENCES Curso(idCurso),
    FOREIGN KEY (idPlanAcademico) REFERENCES PlanAcademico(idPlanAcademico)
);

CREATE TABLE JornadaEscolarXHoraAcademica (
    idJornadaEscolar INT NOT NULL,
    idHoraAcademica INT NOT NULL,
    PRIMARY KEY (idJornadaEscolar,idHoraAcademica),
    FOREIGN KEY (idJornadaEscolar) REFERENCES JornadaEscolar(idJornadaEscolar),
    FOREIGN KEY (idHoraAcademica) REFERENCES HoraAcademica(idHoraAcademica) 
); 