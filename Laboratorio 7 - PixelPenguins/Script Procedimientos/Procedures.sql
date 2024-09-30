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
    WHERE a.activo=1;
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
    WHERE a.idAdministrador=p_id;
END $
DELIMITER ;

DELIMITER $ 
CREATE PROCEDURE INSERTAR_PERSONALADMINISTRATIVO(
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
    IN p_codigoPersonalAdministrativo INT
)
BEGIN
	INSERT INTO Usuario
    (fid_rol,dni,nombreCompleto,fechaNacimiento,direccion,email,sexo,username,password,activo)
    VALUES 
    (p_fid_rol,p_dni,p_nombreCompleto,p_fechaNacimiento,p_direccion,p_email,p_sexo,p_username,p_password,1);
    SET p_id = @@last_insert_id; -- se genera un id para el usuario
    INSERT INTO PersonalAdministrativo
    (idPersonalAdministrativo, codigoPersonalAdministrativo, activo)
    VALUES
    (p_id,p_codigoPersonalAdministrativo,1);
END $
CREATE PROCEDURE MODIFICAR_PERSONALADMINISTRATIVO(
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
    IN p_codigoPersonalAdministrativo INT
)
BEGIN
	-- seteando valores clase padre
	UPDATE Usuario SET 
    fid_rol=p_fid_rol, dni=p_dni, nombreCompleto=p_nombreCompleto, fechaNacimiento=p_fechaNacimiento,
    direccion=p_direccion, email=p_email, sexo=p_sexo, username=p_username, password=p_password
    WHERE idUsuario=p_id; 
	-- seteando valores propios
    UPDATE PersonalAdministrativo SET
    codigoPersonalAdministrativo=p_codigoPersonalAdministrativo
    WHERE idPersonalAdministrativo=p_id;
END $
CREATE PROCEDURE ELIMINAR_PERSONALADMINISTRATIVO(
	IN p_id INT
)
BEGIN
	UPDATE PersonalAdministrativo SET activo = 0 
    WHERE idPersonalAdministrativo=p_id;
END $
CREATE PROCEDURE LISTAR_TODOS_PERSONALADMINISTRATIVO()
-- forma de hacer select a una tabla que depende de otra
BEGIN
	SELECT 
    u.idUsuario, u.dni, u.nombreCompleto, u.fechaNacimiento, 
    u.direccion, u.email, u.sexo, u.username, u.password,
    p.codigoPersonalAdministrativo,
    r.nombre as nombreRol -- se le da un nombre personalizado a la columna nombre de Rol
    FROM Usuario u 
    INNER JOIN PersonalAdministrativo p ON u.idUsuario=p.idPersonalAdministrativo
    INNER JOIN Rol r ON u.fid_rol=r.idRol -- incorporando datos de otra tabla
    WHERE p.activo=1;
END $
CREATE PROCEDURE OBTENER_POR_ID_PERSONALADMINISTRATIVO(
	IN p_id INT
)
BEGIN
	SELECT 
    u.idUsuario, u.dni, u.nombreCompleto, u.fechaNacimiento, 
    u.direccion, u.email, u.sexo, u.username, u.password,
    p.codigoPersonalAdministrativo,
    r.nombre as nombreRol -- se le da un nombre personalizado a la columna nombre de Rol
    FROM Usuario u 
    INNER JOIN PersonalAdministrativo p ON u.idUsuario=p.idPersonalAdministrativo
    INNER JOIN Rol r ON u.fid_rol=r.idRol -- incorporando datos de otra tabla
    WHERE p.idPersonalAdministrativo=p_id;
END $
DELIMITER ;

DELIMITER $ 
CREATE PROCEDURE INSERTAR_PROFESOR(
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
    IN p_codigoProfesor INT ,
    IN p_certificadoHistorialEducativo TINYINT,
    IN p_especialidad VARCHAR(20) 
)
BEGIN
	INSERT INTO Usuario
    (fid_rol,dni,nombreCompleto,fechaNacimiento,direccion,email,sexo,username,password,activo)
    VALUES 
    (p_fid_rol,p_dni,p_nombreCompleto,p_fechaNacimiento,p_direccion,p_email,p_sexo,p_username,p_password,1);
    SET p_id = @@last_insert_id; -- se genera un id para el usuario
    INSERT INTO Profesor
    (idProfesor, codigoProfesor, certificadoHistorialEducativo, especialidad, activo)
    VALUES
    (p_id,p_codigoProfesor,p_certificadoHistorialEducativo,p_especialidad,1);
END $
CREATE PROCEDURE MODIFICAR_PROFESOR(
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
    IN p_codigoProfesor INT ,
    IN p_certificadoHistorialEducativo TINYINT,
    IN p_especialidad VARCHAR(20) 
)
BEGIN
	-- seteando valores clase padre
	UPDATE Usuario SET 
    fid_rol=p_fid_rol, dni=p_dni, nombreCompleto=p_nombreCompleto, fechaNacimiento=p_fechaNacimiento,
    direccion=p_direccion, email=p_email, sexo=p_sexo, username=p_username, password=p_password
    WHERE idUsuario=p_id; 
	-- seteando valores propios
    UPDATE Profesor SET
    codigoProfesor=p_codigoProfesor,certificadoHistorialEducativo=p_certificadoHistorialEducativo,
    especialidad=p_especialidad
    WHERE idProfesor=p_id;
END $
CREATE PROCEDURE ELIMINAR_PROFESOR(
	IN p_id INT
)
BEGIN
	UPDATE Profesor SET activo = 0 
    WHERE idProfesor=p_id;
END $
CREATE PROCEDURE LISTAR_TODOS_PROFESOR()
-- forma de hacer select a una tabla que depende de otra
BEGIN
	SELECT 
    u.idUsuario, u.dni, u.nombreCompleto, u.fechaNacimiento, 
    u.direccion, u.email, u.sexo, u.username, u.password,
    p.codigoProfesor,
    r.nombre as nombreRol -- se le da un nombre personalizado a la columna nombre de Rol
    FROM Usuario u 
    INNER JOIN Profesor p ON u.idUsuario=p.idProfesor
    INNER JOIN Rol r ON u.fid_rol=r.idRol -- incorporando datos de otra tabla
    WHERE p.activo=1;
END $
CREATE PROCEDURE OBTENER_POR_ID_PROFESOR(
	IN p_id INT
)
BEGIN
	SELECT 
    u.idUsuario, u.dni, u.nombreCompleto, u.fechaNacimiento, 
    u.direccion, u.email, u.sexo, u.username, u.password,
    p.codigoProfesor, p.certificadoHistorialEducativo, p.especialidad,
    r.nombre as nombreRol -- se le da un nombre personalizado a la columna nombre de Rol
    FROM Usuario u 
    INNER JOIN Profesor p ON u.idUsuario=p.idPersonalAdministrativo
    INNER JOIN Rol r ON u.fid_rol=r.idRol -- incorporando datos de otra tabla
    WHERE p.idProfesor=p_id;
END $
DELIMITER ;

DELIMITER $ 
CREATE PROCEDURE INSERTAR_APODERADO(
    OUT p_id INT,
    IN p_dni VARCHAR(8) ,
    IN p_nombreCompleto VARCHAR(100) ,
    IN p_telefono VARCHAR(20) ,
    IN p_relacion VARCHAR(20) 
)
BEGIN
	INSERT INTO Apoderado
    (dni,nombreCompleto,telefono,relacion,activo)
    VALUES 
    (p_dni,p_nombreCompleto,p_telefono,p_relacion,1);
    SET p_id = @@last_insert_id; -- se genera un id para el apoderado
END $
CREATE PROCEDURE MODIFICAR_APODERADO(
	IN p_id INT,
    IN p_dni VARCHAR(8) ,
    IN p_nombreCompleto VARCHAR(100) ,
    IN p_telefono VARCHAR(20) ,
    IN p_relacion VARCHAR(20) 
)
BEGIN
	UPDATE Apoderado SET 
    dni=p_dni,nombreCompleto=p_nombreCompleto,telefono=p_telefono,relacion=p_relacion
    WHERE idApoderado=p_id; 
END $
CREATE PROCEDURE ELIMINAR_APODERADO(
	IN p_id INT
)
BEGIN
	UPDATE Apoderado SET activo = 0 
    WHERE idApoderado=p_id;
END $
CREATE PROCEDURE LISTAR_TODOS_APODERADO()
BEGIN
	SELECT idApoderado,dni,nombreCompleto,telefono,relacion FROM Apoderado WHERE activo=1;
END $
CREATE PROCEDURE OBTENER_POR_ID_APODERADO(
	IN p_id INT
)
BEGIN
	SELECT idApoderado,dni,nombreCompleto,telefono,relacion FROM Apoderado WHERE idApoderado=p_id;
END $
DELIMITER ;


DELIMITER $ 
CREATE PROCEDURE INSERTAR_GRADOACADEMICO(
    OUT p_id INT,
	IN p_fid_JornadaEscolar INT,
    IN p_idAnioAcademicoRelacionado INT ,
    IN p_numeroGrado INT ,
    IN p_nivel ENUM ('PRIMARIO','SECUNDARIO') ,
    IN p_cantidadAlumnos INT ,
    IN p_vacantes INT
)
BEGIN
	INSERT INTO GradoAcademico
    (fid_JornadaEscolar,idAnioAcademicoRelacionado,numeroGrado,nivel,cantidadAlumnos,vacantes,activo)
    VALUES 
    (p_fid_JornadaEscolar,p_idAnioAcademicoRelacionado,p_numeroGrado,p_nivel,p_cantidadAlumnos,p_vacantes,1);
    SET p_id = @@last_insert_id;
END $
CREATE PROCEDURE MODIFICAR_GRADOACADEMICO(
	OUT p_id INT,
	IN p_fid_JornadaEscolar INT,
    IN p_idAnioAcademicoRelacionado INT ,
    IN p_numeroGrado INT ,
    IN p_nivel ENUM ('PRIMARIO','SECUNDARIO') ,
    IN p_cantidadAlumnos INT ,
    IN p_vacantes INT
)
BEGIN
	UPDATE GradoAcademico SET 
    fid_JornadaEscolar=p_fid_JornadaEscolar, dni=p_dni, nombreCompleto=p_nombreCompleto, fechaNacimiento=p_fechaNacimiento,
    direccion=p_direccion, email=p_email, sexo=p_sexo, username=p_username, password=p_password
    WHERE idUsuario=p_id; 
END $
CREATE PROCEDURE ELIMINAR_GRADOACADEMICO(
	IN p_id INT
)
BEGIN
	UPDATE Usuario SET activo = 0 
    WHERE idUsuario=p_id;
END $
CREATE PROCEDURE LISTAR_TODOS_GRADOACADEMICO()
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
CREATE PROCEDURE OBTENER_POR_ID_GRADOACADEMICO(
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
CREATE PROCEDURE INSERTAR_JORNADAESCOLAR(
    OUT p_id INT,
    IN p_horasDeEstudio INT ,
    IN p_horaInicio TIME,
    IN p_horaFin TIME,
    IN p_dia ENUM ('LUNES','MARTES','MIERCOLES','JUEVES','VIERNES')
)
BEGIN
	INSERT INTO JornadaEscolar
    (horasDeEstudio,horaInicio,horaFin,dia,activo)
    VALUES 
    (p_horasDeEstudio,p_horaInicio,p_horaFin,p_dia,1);
    SET p_id = @@last_insert_id; -- se genera un id para la salida
END $
CREATE PROCEDURE MODIFICAR_JORNADAESCOLAR(
	IN p_id INT,
    IN p_horasDeEstudio INT ,
    IN p_horaInicio TIME,
    IN p_horaFin TIME,
    IN p_dia ENUM ('LUNES','MARTES','MIERCOLES','JUEVES','VIERNES')
)
BEGIN
	UPDATE JornadaEscolar SET 
    horasDeEstudio=p_horasDeEstudio,horaInicio=p_horaInicio,horaFin=p_horaFin,dia=p_dia
    WHERE idJornadaEscolar=p_id; 
END $
CREATE PROCEDURE ELIMINAR_JORNADAESCOLAR(
	IN p_id INT
)
BEGIN
	UPDATE JornadaEscolar SET activo = 0 
    WHERE idJornadaEscolar=p_id;
END $
CREATE PROCEDURE LISTAR_TODOS_JORNADAESCOLAR()
BEGIN
	SELECT idJornadaEscolar,horasDeEstudio,horaInicio,horaFin,dia FROM JornadaEscolar WHERE activo=1;
END $
CREATE PROCEDURE OBTENER_POR_ID_JORNADAESCOLAR(
	IN p_id INT
)
BEGIN
	SELECT idJornadaEscolar,horasDeEstudio,horaInicio,horaFin,dia FROM JornadaEscolar WHERE idJornadaEscolar=p_id;
END $
DELIMITER ;


