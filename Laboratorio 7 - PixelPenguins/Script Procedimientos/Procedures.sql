-- para cambiar el delimitador de ";" a "$"
DELIMITER $ 

CREATE PROCEDURE INSERTAR_ROL(
    OUT p_idRol INT,
	IN p_nombre VARCHAR(10)
)
BEGIN
	INSERT INTO Rol (nombre,activo) VALUES (p_nombre,1);
    SET p_idRol = @@last_insert_id;
END $

CREATE PROCEDURE MODIFICAR_ROL(
	IN p_idRol INT,
    IN p_nombre VARCHAR(10)
)
BEGIN
	UPDATE Rol SET nombre = p_nombre WHERE idRol=p_idRol;
END $

CREATE PROCEDURE ELIMINAR_ROL(
	IN p_idRol INT
)
BEGIN
	UPDATE Rol SET activo = 0 WHERE idRol=p_idRol;
END $

CREATE PROCEDURE LISTAR_TODOS_ROL()
BEGIN
	SELECT idRol, nombre FROM Rol WHERE activo=1;
END $

CREATE PROCEDURE OBTENER_POR_ID_ROL(
	IN p_idRol INT
)
BEGIN
	SELECT idRol, nombre FROM Rol WHERE idRol=p_idRol;
END $

DELIMITER ;


