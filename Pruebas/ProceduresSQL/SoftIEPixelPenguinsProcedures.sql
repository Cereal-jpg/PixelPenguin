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
    
    -- Obtener los valores actuales
    SELECT nombre, direccion, cantidadAlumnos, ruc
    INTO v_nombre, v_direccion, v_cantidadalumnos, v_ruc
    FROM InstitucionEducativa
    WHERE idInstitucion = p_id_institucion;

    -- Actualizar solo los campos que no son nulos o -1 en caso de los INT
    UPDATE InstitucionEducativa
    SET nombre = IFNULL(p_nombre, v_nombre),
        direccion = IFNULL(p_direccion, v_direccion),
        cantidadAlumnos = IF(p_cantidadalumnos != -1, p_cantidadalumnos, cantidadAlumnos),
        ruc = IF(p_ruc != -1, p_ruc, v_ruc)
    WHERE idInstitucion = p_id_institucion;
END $$
DELIMITER ;
