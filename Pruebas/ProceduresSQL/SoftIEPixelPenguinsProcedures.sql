DELIMITER $$

CREATE PROCEDURE INSERTAR_INSTITUCION(
    IN p_id_institucion INT,
    IN p_nombre VARCHAR(100),
    IN p_direccion VARCHAR(200),
    IN p_cantidadalumnos INT,
    IN p_ruc VARCHAR(20)
)
BEGIN
    INSERT INTO InstitucionEducativa (idInstitucion, nombre, direccion, cantidadAlumnos, ruc)
    VALUES (p_id_institucion, p_nombre, p_direccion, p_cantidadalumnos, p_ruc);
END $$

DELIMITER ;

DELIMITER $$
CREATE PROCEDURE MODIFICAR_INSTITUCION(
    IN p_id_institucion INT,
    IN p_nombre VARCHAR(100),
    IN p_direccion VARCHAR(200),
    IN p_cantidadalumnos INT,
    IN p_ruc VARCHAR(20)
)
BEGIN
    DECLARE v_nombre VARCHAR(100);
    DECLARE v_direccion VARCHAR(200);
    DECLARE v_cantidadalumnos INT;
    DECLARE v_ruc VARCHAR(20);
    
    SELECT nombre, direccion, cantidadAlumnos, ruc
    INTO v_nombre, v_direccion, v_cantidadalumnos, v_ruc
    FROM InstitucionEducativa
    WHERE idInstitucion = p_id_institucion;

    UPDATE InstitucionEducativa
    SET nombre = IFNULL(p_nombre, v_nombre),
        direccion = IFNULL(p_direccion, v_direccion),
        cantidadAlumnos = IF(p_cantidadalumnos != -1, p_cantidadalumnos, cantidadAlumnos),
        ruc = IF(p_ruc != -1, p_ruc, v_ruc)
    WHERE idInstitucion = p_id_institucion;
END $$
DELIMITER ;

DELIMITER $$

CREATE PROCEDURE ELIMINAR_INSTITUCION(
	IN p_id_institucion INT
)
BEGIN 
	DELETE FROM InstitucionEducativa
    WHERE idInstitucion =p_id_institucion;
END $$

DELIMITER ;

DELIMITER $$

CREATE PROCEDURE LISTAR_TODOS_INSTITUCION()
BEGIN
	SELECT idInstitucion, nombre, direccion, cantidadAlumnos, ruc
    FROM InstitucionEducativa;
END$$

DELIMITER ;

DELIMITER $$

CREATE PROCEDURE LISTAR_INSTITUCION_POR_ID(
    IN p_idInstitucion INT
)
BEGIN
    SELECT 
        idInstitucion, 
        nombre, 
        direccion, 
        cantidadAlumnos, 
        ruc
    FROM 
        InstitucionEducativa
    WHERE 
        idInstitucion = p_idInstitucion;
END $$

DELIMITER ;

DELIMITER $$

CREATE PROCEDURE INSERTAR_MATRICULA(
    IN _idMatricula INT,
    IN _cumpleRequisitos DATE,
    IN _fechaInicio DATE,
    IN _fechaFin INT,
    IN _estado VARCHAR(20),
    IN _idGradoAcademico INT,
    IN _codigoAlumno INT,
    IN _idPlanAcademico INT
)
BEGIN
    INSERT INTO Matricula (idMatricula, cumpleRequisitos, fechaInicio, fechaFin, estado, idGradoAcademico, codigoAlumno, idPlanAcademico)
    VALUES (_idMatricula, _cumpleRequisitos, _fechaInicio, _fechaFin, _estado, _idGradoAcademico, _codigoAlumno, _idPlanAcademico);
END$$

DELIMITER ;

DELIMITER $$
CREATE PROCEDURE MODIFICAR_MATRICULA(
    IN p_id_matricula INT,
    IN p_cumpleRequisitos BOOLEAN,
    IN p_fecha_inicio DATE,
    IN p_fecha_fin DATE,
    IN p_estado VARCHAR(20),
    IN p_id_grado_academico INT,
    IN p_codigo_alumno INT,
    IN p_id_plan_academico INT
)
BEGIN
    DECLARE v_cumpleRequisitos BOOLEAN;
    DECLARE v_fecha_inicio DATE;
    DECLARE v_fecha_fin DATE;
    DECLARE v_estado VARCHAR(20);
    DECLARE v_id_grado_academico INT;
    DECLARE v_codigo_alumno INT;
    DECLARE v_id_plan_academico INT;

    SELECT cumpleRequisitos, fechaInicio, fechaFin, estado, idGradoAcademico, codigoAlumno, idPlanAcademico
    INTO v_cumpleRequisitos, v_fecha_inicio, v_fecha_fin, v_estado, v_id_grado_academico, v_codigo_alumno, v_id_plan_academico
    FROM Matricula
    WHERE idMatricula = p_id_matricula;

    UPDATE Matricula
    SET cumpleRequisitos = IF(p_cumpleRequisitos IS NOT NULL, p_cumpleRequisitos, v_cumpleRequisitos),
        fechaInicio = IF(p_fecha_inicio IS NOT NULL, p_fecha_inicio, v_fecha_inicio),
        fechaFin = IF(p_fecha_fin IS NOT NULL, p_fecha_fin, v_fecha_fin),
        estado = IF(p_estado IS NOT NULL, p_estado, v_estado),
        idGradoAcademico = IF(p_id_grado_academico != -1, p_id_grado_academico, v_id_grado_academico),
        codigoAlumno = IF(p_codigo_alumno != -1, p_codigo_alumno, v_codigo_alumno),
        idPlanAcademico = IF(p_id_plan_academico != -1, p_id_plan_academico, v_id_plan_academico)
    WHERE idMatricula = p_id_matricula;
END $$

DELIMITER ;

DELIMITER $$

CREATE PROCEDURE ELIMINAR_MATRICULA(
	IN p_id_matricula INT
)
BEGIN 
	DELETE FROM Matricula
    WHERE idMatricula = p_id_matricula;
END $$

DELIMITER ;

DELIMITER $$

CREATE PROCEDURE LISTAR_TODOS_MATRICULA()
BEGIN
	SELECT idMatricula, cumpleRequisitos, fechaInicio, fechaFin, estado, idGradoAcademico, codigoAlumno, idPlanAcademico
    FROM Matricula;
END$$

DELIMITER ;

DELIMITER $$
CREATE PROCEDURE LISTAR_MATRICULA_POR_ID(
    IN p_id_matricula INT
)
BEGIN
    SELECT idMatricula, cumpleRequisitos, fechaInicio, fechaFin, estado, idGradoAcademico, codigoAlumno, idPlanAcademico
    FROM Matricula
    WHERE idMatricula = p_id_matricula;
END $$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE INSERTAR_PAGO(
	IN p_idPago INT,
    IN p_fechaCreacion DATE,
    IN p_fechaPago DATE,
    IN p_monto DOUBLE,
    IN p_tipoPago VARCHAR(30),
    IN p_estado VARCHAR(30),
    IN p_tipoDeComprobante VARCHAR(30),
    IN p_idMatricula INT
)
BEGIN
    INSERT INTO Pago (idPago, fechaCreacion, fechaPago, monto, tipoPago, estado, tipoDeComprobante, idMatricula)
    VALUES (p_idPago, p_fechaCreacion, p_fechaPago, p_monto, p_tipoPago, p_estado, p_tipoDeComprobante, p_idMatricula);
END $$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE MODIFICAR_PAGO(
    IN p_id_pago INT,
    IN p_fechaCreacion DATE,
    IN p_fechaPago DATE,
    IN p_monto DOUBLE,
    IN p_tipoPago VARCHAR(30),
    IN p_estado VARCHAR(30),
    IN p_tipoDeComprobante VARCHAR(30),
    IN p_idMatricula INT
)
BEGIN
    UPDATE Pago
    SET fechaCreacion = IFNULL(p_fechaCreacion, fechaCreacion),
        fechaPago = IFNULL(p_fechaPago, fechaPago),
        monto = IF(p_monto != -1, p_monto, monto),
        tipoPago = IFNULL(p_tipoPago, tipoPago),
        estado = IFNULL(p_estado, estado),
        tipoDeComprobante = IFNULL(p_tipoDeComprobante, tipoDeComprobante),
        idMatricula = IF(p_idMatricula != -1, p_idMatricula, idMatricula)
    WHERE idPago = p_id_pago;
END $$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE ELIMINAR_PAGO(
    IN p_id_pago INT
)
BEGIN
    DELETE FROM Pago
    WHERE idPago = p_id_pago;
END $$
DELIMITER ;

DELIMITER $$

CREATE PROCEDURE LISTAR_TODOS_PAGO()
BEGIN
	SELECT idPago, fechaCreacion, fechaPago, monto, tipoPago, estado, tipoDeComprobante, idMatricula
    FROM Pago;
END$$

DELIMITER ;

DELIMITER $$
CREATE PROCEDURE LISTAR_PAGO_POR_ID(
    IN p_idPago INT
)
BEGIN
    SELECT idPago, fechaCreacion, fechaPago, monto, tipoPago, estado, tipoDeComprobante, idMatricula
    FROM Pago
    WHERE idPago = p_idPago;
END $$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE INSERTAR_PLAN_ACADEMICO(
    IN p_id_plan_academico INT,
    IN p_año INT,
    IN p_fecha_inicio DATE,
    IN p_fecha_fin DATE,
    IN p_id_institucion INT
)
BEGIN
    INSERT INTO PlanAcademico (idPlanAcademico, año, fechaInicio, fechaFin, idInstitucion)
    VALUES (p_id_plan_academico, p_año, p_fecha_inicio, p_fecha_fin, p_id_institucion);
END $$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE MODIFICAR_PLAN_ACADEMICO(
    IN p_id_plan_academico INT,
    IN p_año INT,
    IN p_fecha_inicio DATE,
    IN p_fecha_fin DATE,
    IN p_id_institucion INT
)
BEGIN
    DECLARE v_año INT;
    DECLARE v_fecha_inicio DATE;
    DECLARE v_fecha_fin DATE;
    DECLARE v_id_institucion INT;

    SELECT año, fechaInicio, fechaFin, idInstitucion
    INTO v_año, v_fecha_inicio, v_fecha_fin, v_id_institucion
    FROM PlanAcademico
    WHERE idPlanAcademico = p_id_plan_academico;

    UPDATE PlanAcademico
    SET año = IF(p_año != -1, p_año, v_año),
        fechaInicio = IFNULL(p_fecha_inicio, v_fecha_inicio),
        fechaFin = IFNULL(p_fecha_fin, v_fecha_fin),
        idInstitucion = IF(p_id_institucion != -1, p_id_institucion, v_id_institucion)
    WHERE idPlanAcademico = p_id_plan_academico;
END $$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE ELIMINAR_PLAN_ACADEMICO(
    IN p_id_plan_academico INT
)
BEGIN
    DELETE FROM PlanAcademico
    WHERE idPlanAcademico = p_id_plan_academico;
END $$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE LISTAR_TODOS_PLANES_ACADEMICOS()
BEGIN
    SELECT idPlanAcademico, año, fechaInicio, fechaFin, idInstitucion 
    FROM PlanAcademico;
END $$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE LISTAR_PLAN_POR_ID(
    IN p_idPlanAcademico INT
)
BEGIN
    SELECT idPlanAcademico, año, fechaInicio, fechaFin, idInstitucion 
    FROM PlanAcademico
    WHERE idPlanAcademico = p_idPlanAcademico;
END $$
DELIMITER ;

DELIMITER $$

CREATE PROCEDURE INSERTAR_NOTA(
    IN p_id_nota INT,
    IN p_nota VARCHAR(10),
    IN p_bimestre INT,
    IN p_id_curso VARCHAR(20),
    IN p_id_competencia INT
)
BEGIN
    INSERT INTO Nota (idNota, nota, bimestre, idCurso, idCompetencia)
    VALUES (p_id_nota, p_nota, p_bimestre, p_id_curso, p_id_competencia);
END $$

DELIMITER ;

DELIMITER $$
CREATE PROCEDURE MODIFICAR_NOTA(
    IN p_id_nota INT,
    IN p_nota VARCHAR(10),
    IN p_bimestre INT,
    IN p_id_curso VARCHAR(20),
    IN p_id_competencia INT
)
BEGIN
	UPDATE Nota 
    SET nota = p_nota,
		bimestre = p_bimestre,
        idCurso = p_id_curso,
        idCompetencia = p_id_competencia
	WHERE idNota = p_id_nota;
END;

CREATE PROCEDURE ELIMINAR_NOTA(
	IN p_id_nota INT
)
BEGIN 
	DELETE FROM Nota
    WHERE idNota =p_id_nota;
END;

CREATE PROCEDURE LISTAR_TODOS_NOTA()
BEGIN
	SELECT idNota, nota, bimestre, idCurso, idCompetencia
    FROM Nota;
END;

DELIMITER //

CREATE PROCEDURE LISTAR_NOTA_POR_ID(
    IN p_idNota INT
)
BEGIN
    SELECT 
        idNota, 
        nota, 
        bimestre, 
        idCurso, 
        idCompetencia
    FROM 
        Nota
    WHERE 
        idNota = p_idNota;
END //

DELIMITER ;

DELIMITER $$
CREATE PROCEDURE MODIFICAR_SECCION_ACADEMICA(
    IN p_id_seccion_academica INT,
    IN p_seccion VARCHAR(1),
    IN p_aula VARCHAR(50),
    IN p_grado INT,
)
BEGIN
	UPDATE SeccionAcademica 
    SET seccion = p_seccion,
		aula = p_aula,
        idGradoAcademico = p_grado,
	WHERE idSeccionAcademica = p_id_seccion_academica;
END;

CREATE PROCEDURE ELIMINAR_SECCION_ACADEMICA(
	IN p_id_seccion_academica INT
)
BEGIN 
	DELETE FROM SeccionAcademica
    WHERE idSeccionAcademica =p_id_seccion_academica;
END;

CREATE PROCEDURE LISTAR_TODOS_SECCION_ACADEMICA()
BEGIN
	SELECT idSeccionAcademica, seccion, aula, idGradoAcademico
        FROM SeccionAcademica;
END;

DELIMITER //

CREATE PROCEDURE LISTAR_SECCION_ACADEMICA_POR_ID(
    IN p_id_seccion_academica INT
)
BEGIN
    SELECT 
        idSeccionAcademica, 
        seccion, 
        aula, 
        idGradoAcademico
    FROM 
        SeccionAcademica
    WHERE 
        idSeccionAcademica = p_id_seccion_academica;
END //



DELIMITER $$

CREATE PROCEDURE INSERTAR_COMPETENCIA(
    IN p_id_competencia INT,
    IN p_descruocuib VARCHAR(100),
    IN p_idcurso VARCHAR(200)
)
BEGIN
    INSERT INTO Competencias (idCompetencia, descripcion, idCurso)
    VALUES (p_id_competencia, p_descruocuib, p_idcurso);
END $$

DELIMITER ;

DELIMITER $$
CREATE PROCEDURE MODIFICAR_COMPETENCIA(
    IN p_id_competencia INT,
    IN p_descruocuib VARCHAR(100),
    IN p_idcurso VARCHAR(200)
)
BEGIN
    DECLARE v_descruocuib VARCHAR(200);
    DECLARE v_idcurso INT;
    
    SELECT  descripcion, idCurso
    INTO  p_descruocuib, p_idcurso
    FROM Competencias
    WHERE idCompetencia = p_id_competencia;

    UPDATE Competencias
    SET descripcion = IFNULL(p_descruocuib, v_descruocuib),
        idCurso = IF(p_idcurso != -1, p_idcurso, idCurso)
    WHERE idInstitucion = p_id_institucion;
END $$
DELIMITER ;

DELIMITER $$

CREATE PROCEDURE ELIMINAR_COMPETENCIA(
	IN p_id_competencia INT
)
BEGIN 
	DELETE FROM Competencias
    WHERE idCompetencia =p_id_competencia;
END $$

DELIMITER ;

DELIMITER $$

CREATE PROCEDURE LISTAR_TODOS_COMPETENCIA()
BEGIN
	SELECT idCompetencia, descripcion, idCurso
    FROM Competencias;
END$$

DELIMITER ;

DELIMITER $$

CREATE PROCEDURE LISTAR_COMPETENCIA_POR_ID(
    IN p_idCompetencia INT
)
BEGIN
    SELECT 
        idCompetencia, 
        descripcion, 
        idCurso
    FROM 
        Competencias
    WHERE 
        idCompetencia = p_idCompetencia;
END $$

DELIMITER ;

DELIMITER //

CREATE PROCEDURE INSERTAR_JORNADAESCOLAR(
    IN p_idJornadaEscolar INT,
    IN p_horaInicio TIME,
    IN p_horaFin TIME,
    IN p_horasDeEstudio INT,
    IN p_dia VARCHAR(20) 
)
BEGIN
    INSERT INTO JornadaEscolar (idJornadaEscolar, horaInicio, horaFin, horasDeEstudio, dia)
    VALUES (p_idJornadaEscolar, p_horaInicio, p_horaFin, p_horasDeEstudio, p_dia);
END //

DELIMITER ;
drop procedure INSERTAR_JORNADAESCOLAR;

DELIMITER //

DELIMITER $$
CREATE PROCEDURE MODIFICAR_JORNADAESCOLAR(
    IN p_id_jornada_escolar INT,
    IN p_hora_inicio TIME,
    IN p_hora_fin TIME,
    IN p_horas_de_estudio INT,
    IN p_dia VARCHAR(20)
)
BEGIN
    DECLARE v_hora_inicio TIME;
    DECLARE v_hora_fin TIME;
    DECLARE v_horas_de_estudio INT;
    DECLARE v_dia VARCHAR(20);

    SELECT horaInicio, horaFin, horasDeEstudio, dia
    INTO v_hora_inicio, v_hora_fin, v_horas_de_estudio, v_dia
    FROM JornadaEscolar
    WHERE idJornadaEscolar = p_id_jornada_escolar;

    UPDATE JornadaEscolar
    SET horaInicio = IF(p_hora_inicio IS NOT NULL, p_hora_inicio, v_hora_inicio),
        horaFin = IF(p_hora_fin IS NOT NULL, p_hora_fin, v_hora_fin),
        horasDeEstudio = IF(p_horas_de_estudio != -1, p_horas_de_estudio, v_horas_de_estudio),
        dia = IF(p_dia IS NOT NULL, p_dia, v_dia)
    WHERE idJornadaEscolar = p_id_jornada_escolar;
END$$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE LISTAR_TODOS_JORNADAESCOLAR()
BEGIN
    SELECT 
        idJornadaEscolar,
        horaInicio,
        horaFin,
        horasDeEstudio,
        dia
    FROM JornadaEscolar;
END$$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE LISTAR_JORNADAESCOLAR_POR_ID(IN p_idJornadaEscolar INT)
BEGIN
    SELECT 
        idJornadaEscolar,
        horaInicio,
        horaFin,
        horasDeEstudio,
        dia
    FROM JornadaEscolar
    WHERE idJornadaEscolar = p_idJornadaEscolar;
END$$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE ELIMINAR_JORNADAESCOLAR(IN p_idJornadaEscolar INT)
BEGIN
    DELETE FROM JornadaEscolar
    WHERE idJornadaEscolar = p_idJornadaEscolar;
END$$
DELIMITER ;
