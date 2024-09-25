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
