-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema pixelpenguins
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema pixelpenguins
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `pixelpenguins` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `pixelpenguins` ;

-- -----------------------------------------------------
-- Table `pixelpenguins`.`Rol`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pixelpenguins`.`Rol` (
  `idRol` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`idRol`))
ENGINE = InnoDB
AUTO_INCREMENT = 6
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `pixelpenguins`.`Usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pixelpenguins`.`Usuario` (
  `idUsuario` INT NOT NULL AUTO_INCREMENT,
  `fid_rol` INT NULL DEFAULT NULL,
  `dni` VARCHAR(10) NOT NULL,
  `nombreCompleto` VARCHAR(100) NOT NULL,
  `fechaNacimiento` DATE NOT NULL,
  `direccion` VARCHAR(255) NOT NULL,
  `email` VARCHAR(100) NOT NULL,
  `sexo` VARCHAR(10) NOT NULL,
  `username` VARCHAR(20) NULL DEFAULT NULL,
  `password` VARCHAR(10) NULL DEFAULT NULL,
  PRIMARY KEY (`idUsuario`),
  INDEX `fid_rol` (`fid_rol` ASC) VISIBLE,
  CONSTRAINT `Usuario_ibfk_1`
    FOREIGN KEY (`fid_rol`)
    REFERENCES `pixelpenguins`.`Rol` (`idRol`))
ENGINE = InnoDB
AUTO_INCREMENT = 85
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `pixelpenguins`.`Administrador`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pixelpenguins`.`Administrador` (
  `idAdministrador` INT NOT NULL,
  `codigoAdministrador` INT NOT NULL,
  PRIMARY KEY (`idAdministrador`),
  CONSTRAINT `Administrador_ibfk_1`
    FOREIGN KEY (`idAdministrador`)
    REFERENCES `pixelpenguins`.`Usuario` (`idUsuario`)
    ON DELETE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `pixelpenguins`.`Apoderado`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pixelpenguins`.`Apoderado` (
  `idApoderado` INT NOT NULL AUTO_INCREMENT,
  `dni` VARCHAR(8) NOT NULL,
  `nombreCompleto` VARCHAR(100) NOT NULL,
  `telefono` VARCHAR(20) NOT NULL,
  `relacion` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`idApoderado`))
ENGINE = InnoDB
AUTO_INCREMENT = 59
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `pixelpenguins`.`AnioAcademico`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pixelpenguins`.`AnioAcademico` (
  `idAnioAcademico` INT NOT NULL AUTO_INCREMENT,
  `anio` INT NOT NULL,
  `fechaInicio` DATE NOT NULL,
  `fechaFin` DATE NOT NULL,
  PRIMARY KEY (`idAnioAcademico`))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `pixelpenguins`.`GradoAcademico`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pixelpenguins`.`GradoAcademico` (
  `idGradoAcademico` INT NOT NULL AUTO_INCREMENT,
  `fid_AnioAcademico` INT NOT NULL,
  `numeroGrado` INT NOT NULL,
  `nivel` ENUM('PRIMARIA', 'SECUNDARIA') NOT NULL,
  `cantidadAlumnos` INT NOT NULL,
  `vacantes` INT NOT NULL,
  PRIMARY KEY (`idGradoAcademico`),
  INDEX `fid_AnioAcademico` (`fid_AnioAcademico` ASC) VISIBLE,
  CONSTRAINT `GradoAcademico_ibfk_1`
    FOREIGN KEY (`fid_AnioAcademico`)
    REFERENCES `pixelpenguins`.`AnioAcademico` (`idAnioAcademico`))
ENGINE = InnoDB
AUTO_INCREMENT = 12
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `pixelpenguins`.`Alumno`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pixelpenguins`.`Alumno` (
  `idAlumno` INT NOT NULL,
  `fid_Apoderado` INT NOT NULL,
  `fid_GradoAcademico` INT NOT NULL,
  `codigoAlumno` INT NULL DEFAULT NULL,
  `certificadoDeEstudios` LONGBLOB NULL DEFAULT NULL,
  `certificadoDeSalud` LONGBLOB NULL DEFAULT NULL,
  `conDeuda` TINYINT NOT NULL,
  `estado` ENUM('Pendiente', 'Por_Pagar', 'Matriculado') NULL DEFAULT NULL,
  PRIMARY KEY (`idAlumno`),
  INDEX `fid_Apoderado` (`fid_Apoderado` ASC) VISIBLE,
  INDEX `fid_GradoAcademico` (`fid_GradoAcademico` ASC) VISIBLE,
  CONSTRAINT `Alumno_ibfk_1`
    FOREIGN KEY (`idAlumno`)
    REFERENCES `pixelpenguins`.`Usuario` (`idUsuario`)
    ON DELETE CASCADE,
  CONSTRAINT `Alumno_ibfk_2`
    FOREIGN KEY (`fid_Apoderado`)
    REFERENCES `pixelpenguins`.`Apoderado` (`idApoderado`)
    ON DELETE CASCADE,
  CONSTRAINT `Alumno_ibfk_3`
    FOREIGN KEY (`fid_GradoAcademico`)
    REFERENCES `pixelpenguins`.`GradoAcademico` (`idGradoAcademico`)
    ON DELETE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `pixelpenguins`.`Profesor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pixelpenguins`.`Profesor` (
  `idProfesor` INT NOT NULL,
  `codigoProfesor` INT NOT NULL,
  `certificadoHistorialEducativo` LONGBLOB NULL DEFAULT NULL,
  `especialidad` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`idProfesor`),
  CONSTRAINT `Profesor_ibfk_1`
    FOREIGN KEY (`idProfesor`)
    REFERENCES `pixelpenguins`.`Usuario` (`idUsuario`)
    ON DELETE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `pixelpenguins`.`Curso`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pixelpenguins`.`Curso` (
  `idCurso` INT NOT NULL AUTO_INCREMENT,
  `fid_GradoAcademico` INT NOT NULL,
  `fid_Profesor` INT NULL DEFAULT NULL,
  `codigoCurso` VARCHAR(20) NOT NULL,
  `nombre` VARCHAR(100) NOT NULL,
  `horasPorSemana` INT NOT NULL,
  `horasTotales` INT NOT NULL,
  PRIMARY KEY (`idCurso`),
  INDEX `fid_Profesor` (`fid_Profesor` ASC) VISIBLE,
  INDEX `fid_GradoAcademico` (`fid_GradoAcademico` ASC) VISIBLE,
  CONSTRAINT `Curso_ibfk_1`
    FOREIGN KEY (`fid_Profesor`)
    REFERENCES `pixelpenguins`.`Profesor` (`idProfesor`),
  CONSTRAINT `Curso_ibfk_2`
    FOREIGN KEY (`fid_GradoAcademico`)
    REFERENCES `pixelpenguins`.`GradoAcademico` (`idGradoAcademico`))
ENGINE = InnoDB
AUTO_INCREMENT = 126
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `pixelpenguins`.`Competencia`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pixelpenguins`.`Competencia` (
  `idCompetencia` INT NOT NULL AUTO_INCREMENT,
  `fid_Curso` INT NOT NULL,
  `descripcion` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`idCompetencia`),
  INDEX `fid_Curso` (`fid_Curso` ASC) VISIBLE,
  CONSTRAINT `Competencia_ibfk_1`
    FOREIGN KEY (`fid_Curso`)
    REFERENCES `pixelpenguins`.`Curso` (`idCurso`))
ENGINE = InnoDB
AUTO_INCREMENT = 237
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `pixelpenguins`.`SeccionAcademica`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pixelpenguins`.`SeccionAcademica` (
  `idSeccionAcademica` INT NOT NULL AUTO_INCREMENT,
  `fid_GradoAcademico` INT NOT NULL,
  `seccion` CHAR(1) NOT NULL,
  `aula` VARCHAR(50) NOT NULL,
  `cantidadAlumnos` INT NOT NULL,
  `vacantes` INT NOT NULL,
  PRIMARY KEY (`idSeccionAcademica`),
  INDEX `fid_GradoAcademico` (`fid_GradoAcademico` ASC) VISIBLE,
  CONSTRAINT `SeccionAcademica_ibfk_1`
    FOREIGN KEY (`fid_GradoAcademico`)
    REFERENCES `pixelpenguins`.`GradoAcademico` (`idGradoAcademico`))
ENGINE = InnoDB
AUTO_INCREMENT = 46
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `pixelpenguins`.`Matricula`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pixelpenguins`.`Matricula` (
  `idMatricula` INT NOT NULL AUTO_INCREMENT,
  `fid_Alumno` INT NOT NULL,
  `fid_AnioAcademico` INT NOT NULL,
  `fid_GradoAcademico` INT NOT NULL,
  `fid_SeccionAcademica` INT NOT NULL,
  `NotaFinal` VARCHAR(10) NULL DEFAULT '-',
  PRIMARY KEY (`idMatricula`),
  INDEX `fid_Alumno` (`fid_Alumno` ASC) VISIBLE,
  INDEX `fid_AnioAcademico` (`fid_AnioAcademico` ASC) VISIBLE,
  INDEX `fid_GradoAcademico` (`fid_GradoAcademico` ASC) VISIBLE,
  INDEX `fid_SeccionAcademica` (`fid_SeccionAcademica` ASC) VISIBLE,
  CONSTRAINT `Matricula_ibfk_1`
    FOREIGN KEY (`fid_Alumno`)
    REFERENCES `pixelpenguins`.`Alumno` (`idAlumno`),
  CONSTRAINT `Matricula_ibfk_2`
    FOREIGN KEY (`fid_AnioAcademico`)
    REFERENCES `pixelpenguins`.`AnioAcademico` (`idAnioAcademico`),
  CONSTRAINT `Matricula_ibfk_3`
    FOREIGN KEY (`fid_GradoAcademico`)
    REFERENCES `pixelpenguins`.`GradoAcademico` (`idGradoAcademico`),
  CONSTRAINT `Matricula_ibfk_4`
    FOREIGN KEY (`fid_SeccionAcademica`)
    REFERENCES `pixelpenguins`.`SeccionAcademica` (`idSeccionAcademica`))
ENGINE = InnoDB
AUTO_INCREMENT = 22
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `pixelpenguins`.`CursoXMatricula`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pixelpenguins`.`CursoXMatricula` (
  `idCurso` INT NOT NULL,
  `idMatricula` INT NOT NULL,
  `fid_Alumno` INT NOT NULL,
  `notaBimestre1` VARCHAR(10) NULL DEFAULT NULL,
  `notaBimestre2` VARCHAR(10) NULL DEFAULT NULL,
  `notaBimestre3` VARCHAR(10) NULL DEFAULT NULL,
  `notaBimestre4` VARCHAR(10) NULL DEFAULT NULL,
  `notaFinal` VARCHAR(10) NULL DEFAULT NULL,
  INDEX `fk_Curso` (`idCurso` ASC) VISIBLE,
  INDEX `fk_Matricula` (`idMatricula` ASC) VISIBLE,
  INDEX `fid_Alumno` (`fid_Alumno` ASC) VISIBLE,
  CONSTRAINT `CursoXMatricula_ibfk_1`
    FOREIGN KEY (`fid_Alumno`)
    REFERENCES `pixelpenguins`.`Alumno` (`idAlumno`),
  CONSTRAINT `fk_Curso`
    FOREIGN KEY (`idCurso`)
    REFERENCES `pixelpenguins`.`Curso` (`idCurso`)
    ON DELETE CASCADE,
  CONSTRAINT `fk_Matricula`
    FOREIGN KEY (`idMatricula`)
    REFERENCES `pixelpenguins`.`Matricula` (`idMatricula`)
    ON DELETE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `pixelpenguins`.`HoraAcademica`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pixelpenguins`.`HoraAcademica` (
  `idHoraAcademica` INT NOT NULL AUTO_INCREMENT,
  `fid_Curso` INT NOT NULL,
  `fid_seccionAcademica` INT NOT NULL,
  `horaInicio` TIME NOT NULL,
  `horaFin` TIME NOT NULL,
  `dia` ENUM('LUNES', 'MARTES', 'MIERCOLES', 'JUEVES', 'VIERNES') NOT NULL,
  PRIMARY KEY (`idHoraAcademica`),
  INDEX `fid_Curso` (`fid_Curso` ASC) VISIBLE,
  INDEX `fid_seccionAcademica` (`fid_seccionAcademica` ASC) VISIBLE,
  CONSTRAINT `HoraAcademica_ibfk_1`
    FOREIGN KEY (`fid_Curso`)
    REFERENCES `pixelpenguins`.`Curso` (`idCurso`)
    ON DELETE CASCADE,
  CONSTRAINT `HoraAcademica_ibfk_2`
    FOREIGN KEY (`fid_seccionAcademica`)
    REFERENCES `pixelpenguins`.`SeccionAcademica` (`idSeccionAcademica`)
    ON DELETE CASCADE)
ENGINE = InnoDB
AUTO_INCREMENT = 7
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `pixelpenguins`.`Nota`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pixelpenguins`.`Nota` (
  `idNota` INT NOT NULL AUTO_INCREMENT,
  `fid_Matricula` INT NOT NULL,
  `fid_Alumno` INT NOT NULL,
  `fid_Curso` INT NOT NULL,
  `fid_Competencia` INT NOT NULL,
  `nota` VARCHAR(10) NOT NULL,
  `bimestre` INT NOT NULL,
  PRIMARY KEY (`idNota`),
  INDEX `fid_Curso` (`fid_Curso` ASC) VISIBLE,
  INDEX `fid_Competencia` (`fid_Competencia` ASC) VISIBLE,
  CONSTRAINT `Nota_ibfk_1`
    FOREIGN KEY (`fid_Curso`)
    REFERENCES `pixelpenguins`.`Curso` (`idCurso`),
  CONSTRAINT `Nota_ibfk_2`
    FOREIGN KEY (`fid_Competencia`)
    REFERENCES `pixelpenguins`.`Competencia` (`idCompetencia`))
ENGINE = InnoDB
AUTO_INCREMENT = 1047
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `pixelpenguins`.`Pago`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pixelpenguins`.`Pago` (
  `idPago` INT NOT NULL AUTO_INCREMENT,
  `fid_Matricula` INT NOT NULL,
  `fechaCreacion` DATE NOT NULL,
  `fechaPago` DATE NOT NULL,
  `monto` DECIMAL(10,2) NULL DEFAULT NULL,
  `tipoPago` ENUM('BANCOS_ASOCIADOS', 'TRANSFERENCIA_BANCARIA') NULL DEFAULT NULL,
  `estado` ENUM('PENDIENTE', 'CANCELADO', 'ATRASADO', 'PAGO_PARCIAL', 'RECHAZADO') NULL DEFAULT NULL,
  `tipoDeComprobante` ENUM('BOLETA', 'FACTURA') NULL DEFAULT NULL,
  `comprobanteDePago` LONGBLOB NULL DEFAULT NULL,
  PRIMARY KEY (`idPago`),
  INDEX `fid_Matricula` (`fid_Matricula` ASC) VISIBLE,
  CONSTRAINT `Pago_ibfk_1`
    FOREIGN KEY (`fid_Matricula`)
    REFERENCES `pixelpenguins`.`Matricula` (`idMatricula`)
    ON DELETE CASCADE)
ENGINE = InnoDB
AUTO_INCREMENT = 28
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `pixelpenguins`.`PersonalAdministrativo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pixelpenguins`.`PersonalAdministrativo` (
  `idPersonalAdministrativo` INT NOT NULL,
  `codigoPersonalAdministrativo` INT NOT NULL,
  PRIMARY KEY (`idPersonalAdministrativo`),
  CONSTRAINT `PersonalAdministrativo_ibfk_1`
    FOREIGN KEY (`idPersonalAdministrativo`)
    REFERENCES `pixelpenguins`.`Usuario` (`idUsuario`)
    ON DELETE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
