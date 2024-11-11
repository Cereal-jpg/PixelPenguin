
DROP TABLE IF EXISTS InstitucionEducativa;
CREATE TABLE InstitucionEducativa(
	idInstitucion INT AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL,
    cantidadAlumnos INT NOT NULL,
    direccion VARCHAR(100) NOT NULL,
    ruc VARCHAR(11) NOT NULL,
    PRIMARY KEY (idInstitucion)
);

DROP TABLE IF EXISTS AnioAcademico;
CREATE TABLE AnioAcademico(
	idAnioAcademico INT AUTO_INCREMENT,
    anio INT NOT NULL,
    fechaInicio DATE NOT NULL,
    fechaFin DATE NOT NULL,
    PRIMARY KEY (idAnioAcademico)
);

DROP TABLE IF EXISTS Rol;
CREATE TABLE Rol(
	idRol INT AUTO_INCREMENT,
    nombre VARCHAR(10) NOT NULL,
	PRIMARY KEY (idRol)
);

DROP TABLE IF EXISTS Usuario;
CREATE TABLE Usuario(
	idUsuario INT AUTO_INCREMENT, 
    fid_rol INT, -- FK a idRol (es buena práctica colocarlos al principio)
    dni VARCHAR(8) NOT NULL,
    nombreCompleto VARCHAR(100) NOT NULL,
    fechaNacimiento DATE NOT NULL,
    direccion VARCHAR(255) NOT NULL,
    email VARCHAR(100) NOT NULL,
    sexo VARCHAR(10) NOT NULL,
    username VARCHAR(20) NULL,
    password VARCHAR(20) NULL,
    PRIMARY KEY (idUsuario),
    FOREIGN KEY (fid_rol) REFERENCES Rol (idRol)
);

DROP TABLE IF EXISTS Administrador;
CREATE TABLE Administrador(
	idAdministrador INT, -- el autoincrement lo tiene de Usuario
    codigoAdministrador INT NOT NULL,
    PRIMARY KEY (idAdministrador),
    FOREIGN KEY (idAdministrador) REFERENCES Usuario (idUsuario)
    ON DELETE CASCADE
);


DROP TABLE IF EXISTS PersonalAdministrativo;
CREATE TABLE PersonalAdministrativo(
	idPersonalAdministrativo INT, 
    codigoPersonalAdministrativo INT NOT NULL,
    PRIMARY KEY (idPersonalAdministrativo),
    FOREIGN KEY (idPersonalAdministrativo) REFERENCES Usuario (idUsuario)
    ON DELETE CASCADE
);

DROP TABLE IF EXISTS Profesor;
CREATE TABLE Profesor(
	idProfesor INT,
    codigoProfesor INT NOT NULL,
    certificadoHistorialEducativo LONGBLOB,
    especialidad VARCHAR(20) NOT NULL,
    PRIMARY KEY (idProfesor),
    FOREIGN KEY (idProfesor) REFERENCES Usuario (idUsuario)
    ON DELETE CASCADE
);

DROP TABLE IF EXISTS Apoderado;
CREATE TABLE Apoderado(
	idApoderado INT AUTO_INCREMENT,
    dni VARCHAR(8) NOT NULL,
    nombreCompleto VARCHAR(100) NOT NULL,
    telefono VARCHAR(20) NOT NULL,
    relacion VARCHAR(20) NOT NULL,
    PRIMARY KEY (idApoderado)
);

DROP TABLE IF EXISTS GradoAcademico;
CREATE TABLE GradoAcademico(
	idGradoAcademico INT AUTO_INCREMENT,
    fid_AnioAcademico INT NOT NULL,
    numeroGrado INT NOT NULL,
    nivel ENUM ('PRIMARIA','SECUNDARIA') NOT NULL,
    cantidadAlumnos INT NOT NULL,
    vacantes INT NOT NULL,
    PRIMARY KEY (idGradoAcademico),
    FOREIGN KEY (fid_AnioAcademico) REFERENCES AnioAcademico (idAnioAcademico)
);

DROP TABLE IF EXISTS JornadaEscolar;
CREATE TABLE JornadaEscolar(
	idJornadaEscolar INT AUTO_INCREMENT,
    fid_GradoAcademico INT NOT NULL,
    horasDeEstudio INT NOT NULL,
    horaInicio TIME NOT NULL,
    horaFin TIME NOT NULL,
    dia ENUM ('LUNES','MARTES','MIERCOLES','JUEVES','VIERNES') NOT NULL,
    PRIMARY KEY (idJornadaEscolar),
    FOREIGN KEY (fid_GradoAcademico) REFERENCES GradoAcademico (idGradoAcademico)
);

DROP TABLE IF EXISTS Alumno;
CREATE TABLE Alumno(
	idAlumno INT,
    fid_Apoderado INT NOT NULL, -- FK  a idApoderado
    fid_GradoAcademico INT NOT NULL,
    codigoAlumno INT NULL,
    certificadoDeEstudios LONGBLOB,
    certificadoDeSalud LONGBLOB,
    conDeuda TINYINT NOT NULL,
    estado ENUM ('Pendiente','Por_Pagar','Matriculado'),
    PRIMARY KEY (idAlumno),
    FOREIGN KEY (idAlumno) 
		REFERENCES Usuario (idUsuario) 
		ON DELETE CASCADE,
    FOREIGN KEY (fid_Apoderado) 
		REFERENCES Apoderado (idApoderado) 
        ON DELETE CASCADE,
	FOREIGN KEY (fid_GradoAcademico)
		REFERENCES GradoAcademico (idGradoAcademico)
        ON DELETE CASCADE
);

DROP TABLE IF EXISTS SeccionAcademica;
CREATE TABLE SeccionAcademica(
	idSeccionAcademica INT AUTO_INCREMENT,
    fid_GradoAcademico INT NOT NULL,
    seccion CHAR NOT NULL,
    aula VARCHAR(50) NOT NULL,
    cantidadAlumnos INT NOT NULL,
    vacantes INT NOT NULL,
    PRIMARY KEY (idSeccionAcademica),
    FOREIGN KEY (fid_GradoAcademico) REFERENCES GradoAcademico(idGradoAcademico)
);

DROP TABLE IF EXISTS Matricula;
CREATE TABLE Matricula(
	idMatricula INT AUTO_INCREMENT,
    fid_Alumno INT NOT NULL,
    fid_AnioAcademico INT NOT NULL,
    fid_GradoAcademico INT NOT NULL,
    fid_SeccionAcademica INT NOT NULL,
    notaFinal VARCHAR(20) NOT NULL,
    PRIMARY KEY (idMatricula),
    FOREIGN KEY (fid_Alumno) REFERENCES Alumno(idAlumno),
    FOREIGN KEY (fid_AnioAcademico) REFERENCES AnioAcademico(idAnioAcademico),
    FOREIGN KEY (fid_GradoAcademico) REFERENCES GradoAcademico(idGradoAcademico),
    FOREIGN KEY (fid_SeccionAcademica) REFERENCES SeccionAcademica(idSeccionAcademica)
);

DROP TABLE IF EXISTS Curso;
CREATE TABLE Curso(
	idCurso INT AUTO_INCREMENT,
    fid_GradoAcademico INT NOT NULL,
    fid_Profesor INT NULL,
    codigoCurso VARCHAR(20) NOT NULL,
    nombre VARCHAR(100) NOT NULL,
    horasPorSemana INT NOT NULL,
    horasTotales INT NOT NULL,
    PRIMARY KEY (idCurso),
    FOREIGN KEY (fid_Profesor) REFERENCES Profesor (idProfesor),
    FOREIGN KEY (fid_GradoAcademico) REFERENCES GradoAcademico (idGradoAcademico)
);

DROP TABLE IF EXISTS Competencia;
CREATE TABLE Competencia(
	idCompetencia INT AUTO_INCREMENT,
    fid_Curso INT NOT NULL,
    descripcion VARCHAR(255) NOT NULL,
    PRIMARY KEY (idCompetencia),
    FOREIGN KEY (fid_Curso) REFERENCES Curso (idCurso)
);

DROP TABLE IF EXISTS Nota;
CREATE TABLE Nota(
	idNota INT AUTO_INCREMENT,
    fid_Matricula INT NOT NULL,
    fid_Alumno INT NOT NULL,
    fid_Curso INT NOT NULL,
    fid_Competencia INT NOT NULL,
    nota VARCHAR(10) NOT NULL,
    bimestre INT NOT NULL,
    PRIMARY KEY (idNota),
    FOREIGN KEY (fid_Curso) REFERENCES Curso (idCurso),
    FOREIGN KEY (fid_Competencia) REFERENCES Competencia (idCompetencia)
);

DROP TABLE IF EXISTS HoraAcademica;
CREATE TABLE HoraAcademica(
	idHoraAcademica INT AUTO_INCREMENT,
    fid_Curso INT NOT NULL,
    idProfesorRelacionado INT NULL,
    horaInicio TIME NOT NULL,
    horaFin TIME NOT NULL,
    PRIMARY KEY (idHoraAcademica),
    FOREIGN KEY (fid_Curso) REFERENCES Curso (idCurso) ON DELETE CASCADE,
    FOREIGN KEY (idProfesorRelacionado) REFERENCES Profesor (idProfesor) ON DELETE CASCADE
);

DROP TABLE IF EXISTS Pago;
CREATE TABLE Pago(
	idPago INT AUTO_INCREMENT,
    fid_Matricula INT NOT NULL,
    fechaCreacion DATE NOT NULL,
    fechaPago DATE NOT NULL,
    monto DECIMAL(10,2),
    tipoPago ENUM('BANCOS_ASOCIADOS','TRANSFERENCIA_BANCARIA'),
    estado ENUM('PENDIENTE','CANCELADO','ATRASADO','PAGO_PARCIAL','RECHAZADO'),
    tipoDeComprobante ENUM('BOLETA','FACTURA'),
    comprobanteDePago LONGBLOB,
    PRIMARY KEY (idPago),
    FOREIGN KEY (fid_Matricula) REFERENCES Matricula (idMatricula) ON DELETE CASCADE
);

DROP TABLE IF EXISTS AlumnoXCurso;
CREATE TABLE AlumnoXCurso(
	idAlumno INT NOT NULL,
    idCurso INT NOT NULL,
    fid_Matricula INT NOT NULL,
    notaFinal VARCHAR(10) NOT NULL,
    PRIMARY KEY (idAlumno,idCurso),
    CONSTRAINT fk_AlumnoC
		FOREIGN KEY (idAlumno) REFERENCES Alumno(idAlumno)
		ON DELETE CASCADE,
	CONSTRAINT fk_CursoA
		FOREIGN KEY (idCurso) REFERENCES Curso(idCurso)
        ON DELETE CASCADE,
	FOREIGN KEY (fid_Matricula) REFERENCES Matricula(idMatricula)
);

DROP TABLE IF EXISTS CursoXMatricula;
CREATE TABLE CursoXMatricula(
	idCurso INT NOT NULL,
	idMatricula INT NOT NULL,
	fid_Alumno INT NOT NULL,
	notaFinal VARCHAR(10) NOT NULL,
	CONSTRAINT fk_Curso
		FOREIGN KEY (idCurso) REFERENCES Curso(idCurso)
        ON DELETE CASCADE,
	CONSTRAINT fk_Matricula
		FOREIGN KEY (idMatricula) REFERENCES Matricula(idMatricula)
        ON DELETE CASCADE,
	FOREIGN KEY (fid_Alumno) REFERENCES Alumno (idAlumno) ON DELETE CASCADE
);

-- Por verse si servirán

DROP TABLE IF EXISTS AlumnoXGradoAcademico;
CREATE TABLE AlumnoXGradoAcademico(
	idAlumno INT NOT NULL,
    idGradoAcademico INT NOT NULL,
    PRIMARY KEY (idAlumno,idGradoAcademico),
    CONSTRAINT fk_AlumnoG
		FOREIGN KEY (idAlumno) REFERENCES Alumno(idAlumno)
		ON DELETE CASCADE,
	CONSTRAINT fk_GradoAcademicoA
		FOREIGN KEY (idGradoAcademico) REFERENCES GradoAcademico(idGradoAcademico)
        ON DELETE CASCADE
);

DROP TABLE IF EXISTS ProfesorXGradoAcademico;
CREATE TABLE ProfesorXGradoAcademico(
	idProfesor INT NOT NULL,
    idGradoAcademico INT NOT NULL,
    PRIMARY KEY (idProfesor,idGradoAcademico),
    CONSTRAINT fk_Profesor
		FOREIGN KEY (idProfesor) REFERENCES Profesor(idProfesor)
		ON DELETE CASCADE,
	CONSTRAINT fk_GradoAcademicoP
		FOREIGN KEY (idGradoAcademico) REFERENCES GradoAcademico(idGradoAcademico)
        ON DELETE CASCADE
);

DROP TABLE IF EXISTS CursoXAnioAcademico;
CREATE TABLE CursoXAnioAcademico (
    idCurso INT NOT NULL,
    idAnioAcademico INT NOT NULL,
    PRIMARY KEY (idCurso,idAnioAcademico),
    CONSTRAINT fk_CursoA
		FOREIGN KEY (idCurso) REFERENCES Curso(idCurso)
        ON DELETE CASCADE,
	CONSTRAINT fk_AnioAcademico
		FOREIGN KEY (idAnioAcademico) REFERENCES AnioAcademico(idAnioAcademico)
        ON DELETE CASCADE
);

