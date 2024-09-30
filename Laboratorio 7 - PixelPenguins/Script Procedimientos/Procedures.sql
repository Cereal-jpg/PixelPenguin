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

DELIMITER $ 
CREATE PROCEDURE INSERTAR_INSTITUCIONEDUCATIVA(
    OUT p_idInstitucionEducativa INT,
	IN p_nombre VARCHAR(100),
    IN p_cantidadAlumnos INT,
    IN p_direccion VARCHAR(100),
    IN p_ruc VARCHAR(11)
)
BEGIN
	INSERT INTO InstitucionEducativa (nombre,cantidadAlumnos,direccion,ruc,activo)
    VALUES (p_nombre,p_cantidadAlumnos,p_direccion,p_ruc,1);
    SET p_idInstitucionEducativa = @@last_insert_id;
END $
CREATE PROCEDURE MODIFICAR_INSTITUCIONEDUCATIVA(
	IN p_idInstitucionEducativa INT,
	IN p_nombre VARCHAR(100),
    IN p_cantidadAlumnos INT,
    IN p_direccion VARCHAR(100),
    IN p_ruc VARCHAR(11)
)
BEGIN
	UPDATE InstitucionEducativa SET 
    nombre = p_nombre, cantidadAlumnos=p_cantidadAlumnos, direccion=p_direccion, ruc=p_ruc 
    WHERE idInstitucionEducativa=p_idInstitucionEducativa;
END $
CREATE PROCEDURE ELIMINAR_INSTITUCIONEDUCATIVA(
	IN p_idInstitucionEducativa INT
)
BEGIN
	UPDATE InstitucionEducativa SET activo = 0 
    WHERE idInstitucionEducativa=p_idInstitucionEducativa;
END $
CREATE PROCEDURE LISTAR_TODOS_INSTITUCIONEDUCATIVA()
BEGIN
	SELECT idInstitucionEducativa, nombre, cantidadAlumnos, direccion, ruc
    FROM InstitucionEducativa WHERE activo=1;
END $
CREATE PROCEDURE OBTENER_POR_ID_INSTITUCIONEDUCATIVA(
	IN p_idInstitucionEducativa INT
)
BEGIN
	SELECT idInstitucionEducativa, nombre, cantidadAlumnos, direccion, ruc
    FROM InstitucionEducativa WHERE idInstitucionEducativa=p_idInstitucionEducativa;
END $
DELIMITER ;

DELIMITER $ 
CREATE PROCEDURE INSERTAR_ANIOACADEMICO(
    OUT p_id INT,
	IN p_anio INT,
    IN p_fechaInicio DATE,
    IN p_fechaFin DATE
)
BEGIN
	INSERT INTO AnioAcademico (anio,fechaInicio,fechaFin,activo)
    VALUES (p_anio,p_fechaInicio,p_fechFin,1);
    SET p_id = @@last_insert_id;
END $
CREATE PROCEDURE MODIFICAR_ANIOACADEMICO(
	IN p_id INT,
	IN p_anio INT,
    IN p_fechaInicio DATE,
    IN p_fechaFin DATE
)
BEGIN
	UPDATE AnioAcademico SET 
    anio = p_anio, fechaInicio=p_fechaInicio, fechaFin=p_fechaFin 
    WHERE idAnioAcademico=p_id;
END $
CREATE PROCEDURE ELIMINAR_ANIOACADEMICO(
	IN p_id INT
)
BEGIN
	UPDATE AnioAcademico SET activo = 0 
    WHERE idAnioAcademico=p_id;
END $
CREATE PROCEDURE LISTAR_TODOS_ANIOACADEMICO()
BEGIN
	SELECT idAnioAcademico, anio, fechaInicio, fechaFin
    FROM AnioAcademico WHERE activo=1;
END $
CREATE PROCEDURE OBTENER_POR_ID_ANIOACADEMICO(
	IN p_id INT
)
BEGIN
	SELECT idAnioAcademico, anio, fechaInicio, fechaFin
    FROM AnioAcademico WHERE idAnioAcademico=p_id;
END $
DELIMITER ;

DELIMITER $ 
CREATE PROCEDURE INSERTAR_USUARIO(
    OUT p_id INT,
	IN p_fid_rol INT,
    IN p_dni VARCHAR(8),
    IN p_nombreCompleto VARCHAR(100),
    IN p_fechaNacimiento DATE ,
    IN p_direccion VARCHAR(255) ,
    IN p_email VARCHAR(100) ,
    IN p_sexo VARCHAR(10) ,
    IN p_username VARCHAR(10) ,
    IN p_password VARCHAR(10) 
)
BEGIN
	-- el idUsuario se genera automáticamente por ser autoincremental, se guarda en p_id
	INSERT INTO Usuario
    (fid_rol,dni,nombreCompleto,fechaNacimiento,direccion,email,sexo,username,password,activo)
    VALUES 
    (p_fid_rol,p_dni,p_nombreCompleto,p_fechaNacimiento,p_direccion,p_email,p_sexo,p_username,p_password,1);
    SET p_id = @@last_insert_id;
END $
CREATE PROCEDURE MODIFICAR_USUARIO(
	IN p_id INT,
	IN p_fid_rol INT,
    IN p_dni VARCHAR(8),
    IN p_nombreCompleto VARCHAR(100),
    IN p_fechaNacimiento DATE ,
    IN p_direccion VARCHAR(255) ,
    IN p_email VARCHAR(100) ,
    IN p_sexo VARCHAR(10) ,
    IN p_username VARCHAR(10) ,
    IN p_password VARCHAR(10) 
)
BEGIN
	UPDATE Usuario SET 
    fid_rol=p_fid_rol, dni=p_dni, nombreCompleto=p_nombreCompleto, fechaNacimiento=p_fechaNacimiento,
    direccion=p_direccion, email=p_email, sexo=p_sexo, username=p_username, password=p_password
    WHERE idUsuario=p_id; 
END $
CREATE PROCEDURE ELIMINAR_USUARIO(
	IN p_id INT
)
BEGIN
	UPDATE Usuario SET activo = 0 
    WHERE idUsuario=p_id;
END $
CREATE PROCEDURE LISTAR_TODOS_USUARIO()
-- forma de hacer select a una tabla que depende de otra
BEGIN
	SELECT 
    u.idUsuario, u.dni, u.nombreCompleto, u.fechaNacimiento, 
    u.direccion, u.email, u.sexo, u.username, u.password,
    r.nombre as nombreRol -- se le da un nombre personalizado a la columna nombre de Rol
    FROM Usuario u 
    INNER JOIN Rol r ON u.fid_rol=r.idRol -- incorporando datos de otra tabla
    WHERE u.activo=1;
END $
CREATE PROCEDURE OBTENER_POR_ID_USUARIO(
	IN p_id INT
)
BEGIN
	SELECT 
    u.idUsuario, u.dni, u.nombreCompleto, u.fechaNacimiento, 
    u.direccion, u.email, u.sexo, u.username, u.password,
    r.nombre as nombreRol -- se le da un nombre personalizado a la columna nombre de Rol
    FROM Usuario u 
    INNER JOIN Rol r ON u.fid_rol=r.idRol
    WHERE u.idUsuario=p_id;
END $
DELIMITER ;

DELIMITER $ 
CREATE PROCEDURE INSERTAR_ADMINISTRADOR(
    OUT p_id INT,
    -- primero irían FK del hijo si hubieran
	-- parámetros de la clase padre
    IN p_fid_rol INT,
    IN p_dni VARCHAR(8),
    IN p_nombreCompleto VARCHAR(100),
    IN p_fechaNacimiento DATE ,
    IN p_direccion VARCHAR(255) ,
    IN p_email VARCHAR(100) ,
    IN p_sexo VARCHAR(10) ,
    IN p_username VARCHAR(10) ,
    IN p_password VARCHAR(10) ,
    -- parámetros propios
    IN p_codigoAdministrador INT
)
BEGIN
	INSERT INTO Usuario
    (fid_rol,dni,nombreCompleto,fechaNacimiento,direccion,email,sexo,username,password,activo)
    VALUES 
    (p_fid_rol,p_dni,p_nombreCompleto,p_fechaNacimiento,p_direccion,p_email,p_sexo,p_username,p_password,1);
    SET p_id = @@last_insert_id; -- se genera un id para el usuario
    INSERT INTO Administrador
    (idAdministrador,codigoAdministrador,activo)
    VALUES
    (p_id,p_codigoAdministrador,1);
END $
CREATE PROCEDURE MODIFICAR_ADMINISTRADOR(
	IN p_id INT,
    -- primero irían FK del hijo si hubieran
	-- parámetros de la clase padre
    IN p_fid_rol INT,
    IN p_dni VARCHAR(8),
    IN p_nombreCompleto VARCHAR(100),
    IN p_fechaNacimiento DATE ,
    IN p_direccion VARCHAR(255) ,
    IN p_email VARCHAR(100) ,
    IN p_sexo VARCHAR(10) ,
    IN p_username VARCHAR(10) ,
    IN p_password VARCHAR(10) ,
    -- parámetros propios
    IN p_codigoAdministrador INT
)
BEGIN
	-- seteando valores clase padre
	UPDATE Usuario SET 
    fid_rol=p_fid_rol, dni=p_dni, nombreCompleto=p_nombreCompleto, fechaNacimiento=p_fechaNacimiento,
    direccion=p_direccion, email=p_email, sexo=p_sexo, username=p_username, password=p_password
    WHERE idUsuario=p_id; 
	-- seteando valores propios
    UPDATE Administrador SET
    codigoAdministrador=p_codigoAdministrador
    WHERE idAdministrador=p_id;
END $
CREATE PROCEDURE ELIMINAR_ADMINISTRADOR(
	IN p_id INT
)
BEGIN
	UPDATE Administrador SET activo = 0 
    WHERE idAdministrador=p_id;
END $
CREATE PROCEDURE LISTAR_TODOS_ADMINISTRADOR()
-- forma de hacer select a una tabla que depende de otra
BEGIN
	SELECT 
    u.idUsuario, u.dni, u.nombreCompleto, u.fechaNacimiento, 
    u.direccion, u.email, u.sexo, u.username, u.password,
    a.codigoAdministrador,
    r.nombre as nombreRol -- se le da un nombre personalizado a la columna nombre de Rol
    FROM Usuario u 
    INNER JOIN Administrador a ON u.idUsuario=a.idAdministrador
    INNER JOIN Rol r ON u.fid_rol=r.idRol -- incorporando datos de otra tabla
    WHERE u.activo=1;
END $
CREATE PROCEDURE OBTENER_POR_ID_ADMINISTRADOR(
	IN p_id INT
)
BEGIN
	SELECT 
    u.idUsuario, u.dni, u.nombreCompleto, u.fechaNacimiento, 
    u.direccion, u.email, u.sexo, u.username, u.password,
    a.codigoAdministrador,
    r.nombre as nombreRol -- se le da un nombre personalizado a la columna nombre de Rol
    FROM Usuario u 
    INNER JOIN Administrador a ON u.idUsuario=a.idAdministrador
    INNER JOIN Rol r ON u.fid_rol=r.idRol -- incorporando datos de otra tabla
    WHERE u.idUsuario=p_id;
END $
DELIMITER ;


