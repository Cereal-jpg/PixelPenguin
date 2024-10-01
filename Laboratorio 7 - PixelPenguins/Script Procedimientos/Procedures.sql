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
    IN p_idAnioAcademicoRelacionado INT ,
    IN p_numeroGrado INT ,
    IN p_nivel ENUM ('PRIMARIO','SECUNDARIO') ,
    IN p_cantidadAlumnos INT ,
    IN p_vacantes INT
)
BEGIN
	INSERT INTO GradoAcademico
    (idAnioAcademicoRelacionado,numeroGrado,nivel,cantidadAlumnos,vacantes,activo)
    VALUES 
    (p_idAnioAcademicoRelacionado,p_numeroGrado,p_nivel,p_cantidadAlumnos,p_vacantes,1);
    SET p_id = @@last_insert_id;
END $
CREATE PROCEDURE MODIFICAR_GRADOACADEMICO(
	OUT p_id INT,
    IN p_idAnioAcademicoRelacionado INT ,
    IN p_numeroGrado INT ,
    IN p_nivel ENUM ('PRIMARIO','SECUNDARIO') ,
    IN p_cantidadAlumnos INT ,
    IN p_vacantes INT
)
BEGIN
	UPDATE GradoAcademico SET 
    idAnioAcademicoRelacionado=p_idAnioAcademicoRelacionado,numeroGrado=p_numeroGrado,
    nivel=p_nivel,cantidadAlumnos=p_cantidadAlumnos,vacantes=p_vacantes
    WHERE idUsuario=p_id; 
END $
CREATE PROCEDURE ELIMINAR_GRADOACADEMICO(
	IN p_id INT
)
BEGIN
	UPDATE GradoAcademico SET activo = 0 
    WHERE idGradoAcademico=p_id;
END $
CREATE PROCEDURE LISTAR_TODOS_GRADOACADEMICO()
-- forma de hacer select a una tabla que depende de otra
BEGIN
	SELECT 
    g.idGradoAcademico,g.numeroGrado,g.nivel,g.cantidadAlumnos,g.vacantes,
    a.anio as anioAcademico  -- columna que mostrará el año
    FROM GradoAcademico g
    INNER JOIN AnioAcademico a ON g.idAnioAcademicoRelacionado=a.idAnioAcademico -- incorporando datos de otra tabla
    WHERE g.activo=1;
END $
CREATE PROCEDURE OBTENER_POR_ID_GRADOACADEMICO(
	IN p_id INT
)
BEGIN
	SELECT 
    g.idGradoAcademico,g.numeroGrado,g.nivel,g.cantidadAlumnos,g.vacantes,
    a.anio as anioAcademico
    FROM GradoAcademico g
    INNER JOIN AnioAcademico a ON g.idAnioAcademicoRelacionado=a.idAnioAcademico -- incorporando datos de otra tabla
    WHERE g.idGradoAcademico=p_id;
END $
DELIMITER ;


DELIMITER $ 
CREATE PROCEDURE INSERTAR_JORNADAESCOLAR(
    OUT p_id INT,
    IN p_fid_GradoAcademico INT,
    IN p_horasDeEstudio INT ,
    IN p_horaInicio TIME,
    IN p_horaFin TIME,
    IN p_dia ENUM ('LUNES','MARTES','MIERCOLES','JUEVES','VIERNES')
)
BEGIN
	INSERT INTO JornadaEscolar
    (fid_GradoAcademico,horasDeEstudio,horaInicio,horaFin,dia,activo)
    VALUES 
    (p_fid_GradoAcademico,p_horasDeEstudio,p_horaInicio,p_horaFin,p_dia,1);
    SET p_id = @@last_insert_id; -- se genera un id para la salida
END $
CREATE PROCEDURE MODIFICAR_JORNADAESCOLAR(
	IN p_id INT,
    IN p_fid_GradoAcademico INT,
    IN p_horasDeEstudio INT ,
    IN p_horaInicio TIME,
    IN p_horaFin TIME,
    IN p_dia ENUM ('LUNES','MARTES','MIERCOLES','JUEVES','VIERNES')
)
BEGIN
	UPDATE JornadaEscolar SET 
    p_fid_GradoAcademico=fid_GradoAcademico,horasDeEstudio=p_horasDeEstudio,
    horaInicio=p_horaInicio,horaFin=p_horaFin,dia=p_dia
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
	SELECT 
    j.idJornadaEscolar,j.horasDeEstudio,j.horaInicio,j.horaFin,j.dia,g.numeroGrado
    FROM JornadaEscolar j 
    INNER JOIN GradoAcademico g ON j.fid_GradoAcademico=g.idGradoAcademico
    WHERE j.activo=1;
END $
CREATE PROCEDURE OBTENER_POR_ID_JORNADAESCOLAR(
	IN p_id INT
)
BEGIN
	SELECT 
    j.idJornadaEscolar,j.horasDeEstudio,j.horaInicio,j.horaFin,j.dia,g.numeroGrado
    FROM JornadaEscolar j 
    INNER JOIN GradoAcademico g ON j.fid_GradoAcademico=g.idGradoAcademico
    WHERE j.idJornadaEscolar=p_id;
END $
DELIMITER ;


DELIMITER $ 
CREATE PROCEDURE INSERTAR_ALUMNO(
    OUT p_id INT,
    -- primero irían FK del hijo si hubieran
    IN p_fid_Apoderado INT , 
    IN p_fid_GradoAcademico INT ,
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
    IN p_codigoAlumno INT ,
    IN p_conCertificadoDeEstudios TINYINT ,
    IN p_conCertificadoDeSalud TINYINT ,
    IN p_conDeuda TINYINT 
)
BEGIN
	INSERT INTO Usuario
    (fid_rol,dni,nombreCompleto,fechaNacimiento,direccion,email,sexo,username,password,activo)
    VALUES 
    (p_fid_rol,p_dni,p_nombreCompleto,p_fechaNacimiento,p_direccion,p_email,p_sexo,p_username,p_password,1);
    SET p_id = @@last_insert_id; -- se genera un id para el usuario
    INSERT INTO Alumno(
    idAlumno,fid_Apoderado,fid_GradoAcademico,codigoAlumno,
	conCertificadoDeEstudios, conCertificadoDeSalud, conDeuda, activo)
    VALUES(
    p_id,p_fid_Apoderado,p_fid_GradoAcademico,p_codigoAlumno,
    p_conCertificadoDeEstudios,p_conCertificadoDeSalud,p_conDeuda,1);
END $
CREATE PROCEDURE MODIFICAR_ALUMNO(
	IN p_id INT,
    -- primero irían FK del hijo si hubieran
    IN p_fid_Apoderado INT , 
    IN p_fid_GradoAcademico INT ,
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
    IN p_codigoAlumno INT ,
    IN p_conCertificadoDeEstudios TINYINT ,
    IN p_conCertificadoDeSalud TINYINT ,
    IN p_conDeuda TINYINT 
)
BEGIN
	-- seteando valores clase padre
	UPDATE Usuario SET 
    fid_rol=p_fid_rol, dni=p_dni, nombreCompleto=p_nombreCompleto, fechaNacimiento=p_fechaNacimiento,
    direccion=p_direccion, email=p_email, sexo=p_sexo, username=p_username, password=p_password
    WHERE idUsuario=p_id; 
	-- seteando valores propios
    UPDATE Alumno SET
    fid_Apoderado=p_fid_Apoderado, fid_GradoAcademico=p_fid_GradoAcademico,
    codigoAlumno=p_codigoAlumno, conCertificadoDeEstudios=p_conCertificadoDeEstudios,
    conCertificadoDeSalud=p_conCertificadoDeSalud,conDeuda=p_conDeuda
    WHERE idAlumno=p_id;
END $
CREATE PROCEDURE ELIMINAR_ALUMNO(
	IN p_id INT
)
BEGIN
	UPDATE Alumno SET activo = 0 
    WHERE idAlumno=p_id;
END $
CREATE PROCEDURE LISTAR_TODOS_ALUMNO()
-- forma de hacer select a una tabla que depende de otra
BEGIN
	SELECT 
    u.idUsuario, u.dni, u.nombreCompleto, u.fechaNacimiento, 
    u.direccion, u.email, u.sexo, u.username, u.password,
    a.codigoAlumno, a.conDeuda, -- solo vamos a mostrar si tiene deuda o no esta vez
    r.nombre as nombreRol, -- se le da un nombre personalizado a la columna nombre de Rol
    apo.nombreCompleto as apoderado, apo.telefono as telefono_ap, g.numeroGrado
    FROM Usuario u 
    INNER JOIN Alumno a ON u.idUsuario=a.idAlumno
    INNER JOIN Rol r ON u.fid_rol=r.idRol -- incorporando datos de otra tabla
    INNER JOIN Apoderado apo ON a.fid_Apoderado=apo.idApoderado
    INNER JOIN GradoAcademico g ON a.fid_GradoAcademico=g.idGradoAcademico
    WHERE a.activo=1;
END $
CREATE PROCEDURE OBTENER_POR_ID_ALUMNO(
	IN p_id INT
)
BEGIN
	SELECT 
    u.idUsuario, u.dni, u.nombreCompleto, u.fechaNacimiento, 
    u.direccion, u.email, u.sexo, u.username, u.password,
    a.codigoAlumno, a.conDeuda, -- solo vamos a mostrar si tiene deuda o no esta vez
    r.nombre as nombreRol, -- se le da un nombre personalizado a la columna nombre de Rol
    apo.nombreCompleto as apoderado, apo.telefono as telefono_ap, g.numeroGrado
    FROM Usuario u 
    INNER JOIN Alumno a ON u.idUsuario=a.idAlumno
    INNER JOIN Rol r ON u.fid_rol=r.idRol -- incorporando datos de otra tabla
    INNER JOIN Apoderado apo ON a.fid_Apoderado=apo.idApoderado
    INNER JOIN GradoAcademico g ON a.fid_GradoAcademico=g.idGradoAcademico
    WHERE a.idAlumno=p_id;
END $
DELIMITER ;


DELIMITER $ 
CREATE PROCEDURE INSERTAR_MATRICULA(
    OUT p_id INT,
	IN p_fid_AnioAcademico INT ,
    IN p_fid_GradoAcademico INT ,
    IN p_cumpleRequisitos TINYINT ,
    IN p_fechaInicio DATE ,
    IN p_fechaFin DATE ,
    IN p_estado ENUM('PENDIENTE','CANCELADA','RECHAZADA')
)
BEGIN
	INSERT INTO Matricula
    (fid_AnioAcademico,fid_GradoAcademico,cumpleRequisitos,fechaInicio,fechaFin,estado,activo)
    VALUES 
    (p_fid_AnioAcademico,p_fid_GradoAcademico,p_cumpleRequisitos,p_fechaInicio,p_fechaFin,p_estado,1);
    SET p_id = @@last_insert_id;
END $
CREATE PROCEDURE MODIFICAR_MATRICULA(
	IN p_id INT,
	IN p_fid_AnioAcademico INT ,
    IN p_fid_GradoAcademico INT ,
    IN p_cumpleRequisitos TINYINT ,
    IN p_fechaInicio DATE ,
    IN p_fechaFin DATE ,
    IN p_estado ENUM('PENDIENTE','CANCELADA','RECHAZADA')
)
BEGIN
	UPDATE Matricula SET 
    fid_AnioAcademico=p_fid_AnioAcademico, fid_GradoAcademico=p_fid_GradoAcademico, 
    cumpleRequisitos=p_cumpleRequisitos, fechaInicio=p_fechaInicio, fechaFin=p_fechaFin, estado=p_estado
    WHERE idMatricula=p_id; 
END $
CREATE PROCEDURE ELIMINAR_MATRICULA(
	IN p_id INT
)
BEGIN
	UPDATE Matricula SET activo = 0 
    WHERE idMatricula=p_id;
END $
CREATE PROCEDURE LISTAR_TODOS_MATRICULA()
-- forma de hacer select a una tabla que depende de otra
BEGIN
	SELECT 
    m.idMatricula,a.anio,g.numeroGrado,m.cumpleRequisitos,m.fechaInicio,m.fechaFin,m.estado
    FROM Matricula m 
    INNER JOIN AnioAcademico a ON m.fid_AnioAcademico=a.idAnioAcademico -- incorporando datos de otra tabla
    INNER JOIN GradoAcademico g ON m.fid_GradoAcademico=g.idGradoAcademico
    WHERE m.activo=1;
END $
CREATE PROCEDURE OBTENER_POR_ID_MATRICULA(
	IN p_id INT
)
BEGIN
	SELECT 
    m.idMatricula,a.anio,g.numeroGrado,m.cumpleRequisitos,m.fechaInicio,m.fechaFin,m.estado
    FROM Matricula m 
    INNER JOIN AnioAcademico a ON m.fid_AnioAcademico=a.idAnioAcademico -- incorporando datos de otra tabla
    INNER JOIN GradoAcademico g ON m.fid_GradoAcademico=g.idGradoAcademico
    WHERE m.activo=p_id;
END $
DELIMITER ;


DELIMITER $ 
CREATE PROCEDURE INSERTAR_SECCIONACADEMICA(
    OUT p_id INT,
	IN p_fid_GradoAcademico INT ,
    IN p_seccion CHAR ,
    IN p_aula VARCHAR(50) 
)
BEGIN
	INSERT INTO SeccionAcademica
    (fid_GradoAcademico,seccion,aula,activo)
    VALUES 
    (p_fid_GradoAcademico,p_seccion,p_aula,1);
    SET p_id = @@last_insert_id;
END $
CREATE PROCEDURE MODIFICAR_SECCIONACADEMICA(
	OUT p_id INT,
	IN p_fid_GradoAcademico INT ,
    IN p_seccion CHAR ,
    IN p_aula VARCHAR(50) 
)
BEGIN
	UPDATE SeccionAcademica SET 
    fid_GradoAcademico=p_fid_GradoAcademico, seccion=p_seccion, aula=p_aula 
    WHERE idSeccionAcademica=p_id; 
END $
CREATE PROCEDURE ELIMINAR_SECCIONACADEMICA(
	IN p_id INT
)
BEGIN
	UPDATE SeccionAcademica SET activo = 0 
    WHERE idSeccionAcademica=p_id;
END $
CREATE PROCEDURE LISTAR_TODOS_SECCIONACADEMICA()
-- forma de hacer select a una tabla que depende de otra
BEGIN
	SELECT 
    s.idSeccionAcademica,s.seccion,s.aula,g.numeroGrado
    FROM SeccionAcademica s 
    INNER JOIN GradoAcademico g ON s.fid_GradoAcademico=g.idGradoAcademico
    WHERE s.activo=1;
END $
CREATE PROCEDURE OBTENER_POR_ID_SECCIONACADEMICA(
	IN p_id INT
)
BEGIN
	SELECT 
    s.idSeccionAcademica,s.seccion,s.aula,g.numeroGrado
    FROM SeccionAcademica s 
    INNER JOIN GradoAcademico g ON s.fid_GradoAcademico=g.idGradoAcademico
    WHERE s.idSeccionAcademica=p_id;
END $
DELIMITER ;


DELIMITER $ 
CREATE PROCEDURE INSERTAR_CURSO(
    OUT p_id INT,
	IN p_codigoCurso VARCHAR(20) ,
    IN p_nombre VARCHAR(100) ,
    IN p_horasPorSemana INT ,
    IN p_horasTotales INT 
)
BEGIN
	INSERT INTO Curso
    (codigoCurso,nombre,horasPorSemana,horasTotales,activo)
    VALUES 
    (p_codigoCurso,p_nombre,p_horasPorSemana,p_horasTotales,1);
    SET p_id = @@last_insert_id;
END $
CREATE PROCEDURE MODIFICAR_CURSO(
	IN p_id INT,
	IN p_codigoCurso VARCHAR(20) ,
    IN p_nombre VARCHAR(100) ,
    IN p_horasPorSemana INT ,
    IN p_horasTotales INT  
)
BEGIN
	UPDATE Curso SET 
    codigoCurso=p_codigoCurso, nombre=p_nombre, horasPorSemana=p_horasPorSemana,
    horasTotales=p_horasTotales
    WHERE idCurso=p_id; 
END $
CREATE PROCEDURE ELIMINAR_CURSO(
	IN p_id INT
)
BEGIN
	UPDATE Curso SET activo = 0 
    WHERE idCurso=p_id;
END $
CREATE PROCEDURE LISTAR_TODOS_CURSO()
BEGIN
	SELECT idCurso,codigoCurso,nombre,
    horasPorSemana,horasTotales FROM Curso
    WHERE activo=1;
END $
CREATE PROCEDURE OBTENER_POR_ID_CURSO(
	IN p_id INT
)
BEGIN
	SELECT idCurso,codigoCurso,nombre,
    horasPorSemana,horasTotales FROM Curso
    WHERE idCurso=p_id;
END $
DELIMITER ;


DELIMITER $ 
CREATE PROCEDURE INSERTAR_COMPETENCIA(
    OUT p_id INT,
	IN p_fid_Curso INT ,
    IN p_descripcion VARCHAR(255) 
)
BEGIN
	INSERT INTO Competencia (fid_Curso,descripcion,activo)
    VALUES (p_fid_Curso,p_descripcion,1);
    SET p_id = @@last_insert_id;
END $
CREATE PROCEDURE MODIFICAR_COMPETENCIA(
	IN p_id INT,
	IN p_fid_Curso INT ,
    IN p_descripcion VARCHAR(255) 
)
BEGIN
	UPDATE Competencia SET 
    fid_Curso=p_fid_Curso,descripcion=p_descripcion
    WHERE idCompetencia=p_id; 
END $
CREATE PROCEDURE ELIMINAR_COMPETENCIA(
	IN p_id INT
)
BEGIN
	UPDATE Competencia SET activo = 0 
    WHERE idCompetencia=p_id;
END $
CREATE PROCEDURE LISTAR_TODOS_COMPETENCIA()
-- forma de hacer select a una tabla que depende de otra
BEGIN
	SELECT 
    c.idCompetencia, c.descripcion, cur.nombre
    FROM Competencia c
    INNER JOIN Curso cur ON c.fid_Curso=cur.idCurso
    WHERE c.activo=1;
END $
CREATE PROCEDURE OBTENER_POR_ID_COMPETENCIA(
	IN p_id INT
)
BEGIN
	SELECT 
    c.idCompetencia, c.descripcion, cur.nombre
    FROM Competencia c
    INNER JOIN Curso cur ON c.fid_Curso=cur.idCurso
    WHERE c.idCompetencia=p_id;
END $
DELIMITER ;


DELIMITER $ 
CREATE PROCEDURE INSERTAR_NOTA(
    OUT p_id INT,
	IN p_fid_Curso INT ,
    IN p_fid_Competencia INT,
    IN p_nota VARCHAR(10),
    IN p_bimestre INT
)
BEGIN
	INSERT INTO Nota 
    (fid_Curso,fid_Competencia,nota,bimestre,activo)
    VALUES 
    (p_fid_Curso,p_fid_Competencia,p_nota,p_bimestre,1);
    SET p_id = @@last_insert_id;
END $
CREATE PROCEDURE MODIFICAR_NOTA(
	IN p_id INT,
	IN p_fid_Curso INT ,
    IN p_fid_Competencia INT,
    IN p_nota VARCHAR(10),
    IN p_bimestre INT
)
BEGIN
	UPDATE Nota SET 
    fid_Curso=p_fid_Curso,fid_Competencia=p_fid_Competencia,
    nota=p_nota,bimestre=p_bimestre
    WHERE idNota=p_id; 
END $
CREATE PROCEDURE ELIMINAR_NOTA(
	IN p_id INT
)
BEGIN
	UPDATE Nota SET activo = 0 
    WHERE idNota=p_id;
END $
CREATE PROCEDURE LISTAR_TODOS_NOTA()
-- forma de hacer select a una tabla que depende de otra
BEGIN
	SELECT 
    n.idNota,n.nota,n.bimestre,cur.nombre,com.descripcion
    FROM Nota n
    INNER JOIN Curso cur ON n.fid_Curso=cur.idCurso
    INNER JOIN Competencia com ON n.fid_Competencia=com.idCompetencia
    WHERE n.activo=1;
END $
CREATE PROCEDURE OBTENER_POR_ID_NOTA(
	IN p_id INT
)
BEGIN
	SELECT 
    n.idNota,n.nota,n.bimestre,cur.nombre,com.descripcion
    FROM Nota n
    INNER JOIN Curso cur ON n.fid_Curso=cur.idCurso
    INNER JOIN Competencia com ON n.fid_Competencia=com.idCompetencia
    WHERE n.idNota=p_id;
END $
DELIMITER ;


DELIMITER $ 
CREATE PROCEDURE INSERTAR_HORAACADEMICA(
    OUT p_id INT,
	IN p_fid_Curso INT ,
    IN p_idProfesorRelacionado INT ,
    IN p_horaInicio TIME ,
    IN p_horaFin TIME 
)
BEGIN
	INSERT INTO HoraAcademica 
    (fid_Curso,idProfesorRelacionado,horaInicio,horaFin,activo)
    VALUES 
    (p_fid_Curso,p_idProfesorRelacionado,p_horaInicio,p_horaFin,1);
    SET p_id = @@last_insert_id;
END $
CREATE PROCEDURE MODIFICAR_HORAACADEMICA(
	IN p_id INT,
	IN p_fid_Curso INT ,
    IN p_idProfesorRelacionado INT ,
    IN p_horaInicio TIME ,
    IN p_horaFin TIME 
)
BEGIN
	UPDATE HoraAcademica SET 
    fid_Curso=p_fid_Curso,idProfesorRelacionado=p_idProfesorRelacionado,
    horaInicio=p_horaInicio,horaFin=p_horaFin
    WHERE idHoraAcademica=p_id; 
END $
CREATE PROCEDURE ELIMINAR_HORAACADEMICA(
	IN p_id INT
)
BEGIN
	UPDATE HoraAcademica SET activo = 0 
    WHERE idHoraAcademica=p_id;
END $
CREATE PROCEDURE LISTAR_TODOS_HORAACADEMICA()
-- forma de hacer select a una tabla que depende de otra
BEGIN
	SELECT 
    h.idHoraAcademica,h.horaInicio,h.horaFin,cur.nombre,
    p.codigoProfesor,u.nombreCompleto
    FROM HoraAcademica h
    INNER JOIN Curso cur ON h.fid_Curso=cur.idCurso
    INNER JOIN Profesor p ON h.idProfesorRelacionado=p.idProfesor
    INNER JOIN Usuario u ON p.idProfesor=u.idUsuario
    WHERE h.activo=1;
END $
CREATE PROCEDURE OBTENER_POR_ID_HORAACADEMICA(
	IN p_id INT
)
BEGIN
	SELECT 
    h.idHoraAcademica,h.horaInicio,h.horaFin,cur.nombre,
    p.codigoProfesor,u.nombreCompleto
    FROM HoraAcademica h
    INNER JOIN Curso cur ON h.fid_Curso=cur.idCurso
    INNER JOIN Profesor p ON h.idProfesorRelacionado=p.idProfesor
    INNER JOIN Usuario u ON p.idProfesor=u.idUsuario
    WHERE h.idHoraAcademica=p_id;
END $
DELIMITER ;


DELIMITER $ 
CREATE PROCEDURE INSERTAR_PAGO(
    OUT p_id INT,
	IN p_fid_Matricula INT ,
    IN p_fechaCreacion DATE ,
    IN p_fechaPago DATE ,
    IN p_monto DECIMAL(10,2),
    IN p_tipoPago ENUM('BANCOS_ASOCIADOS','TRANSFERENCIA_BANCARIA'),
    IN p_estado ENUM('PENDIENTE','CANCELADO','ATRASADO','PAGO_PARCIAL','RECHAZADO'),
    IN p_tipoDeComprobante ENUM('BOLETA','FACTURA')
)
BEGIN
	INSERT INTO Pago
    (fid_Matricula,fechaCreacion,fechaPago,monto,tipoPago,estado,tipoDeComprobante,activo)
    VALUES 
    (p_fid_Matricula,p_fechaCreacion,p_fechaPago,p_monto,
		p_tipoPago,p_estado,p_tipoDeComprobante,1);
    SET p_id = @@last_insert_id;
END $
CREATE PROCEDURE MODIFICAR_PAGO(
	IN p_id INT,
	IN p_fid_Matricula INT ,
    IN p_fechaCreacion DATE ,
    IN p_fechaPago DATE ,
    IN p_monto DECIMAL(10,2),
    IN p_tipoPago ENUM('BANCOS_ASOCIADOS','TRANSFERENCIA_BANCARIA'),
    IN p_estado ENUM('PENDIENTE','CANCELADO','ATRASADO','PAGO_PARCIAL','RECHAZADO'),
    IN p_tipoDeComprobante ENUM('BOLETA','FACTURA')
)
BEGIN
	UPDATE Pago SET 
    fid_Matricula=p_fid_Matricula, fechaCreacion=p_fechaCreacion, fechaPago=p_fechaPago,
    monto=p_monto, tipoPago=p_tipoPago, estado=p_estado,tipoDeComprobante=p_tipoDeComprobante
    WHERE idPago=p_id; 
END $
CREATE PROCEDURE ELIMINAR_PAGO(
	IN p_id INT
)
BEGIN
	UPDATE Pago SET activo = 0 
    WHERE idPago = p_id;
END $
CREATE PROCEDURE LISTAR_TODOS_PAGO()
-- forma de hacer select a una tabla que depende de otra
BEGIN
	SELECT 
    p.idPago,p.fechaCreacion,p.fechaPago,p.monto,p.tipoPago,
    p.estado,p.tipoDeComprobante,m.idMatricula
    FROM Pago p
    INNER JOIN Matricula m ON p.fid_Matricula=m.idMatricula
    WHERE p.activo=1;
END $
CREATE PROCEDURE OBTENER_POR_ID_PAGO(
	IN p_id INT
)
BEGIN
	SELECT 
    p.idPago,p.fechaCreacion,p.fechaPago,p.monto,p.tipoPago,
    p.estado,p.tipoDeComprobante,m.idMatricula
    FROM Pago p
    INNER JOIN Matricula m ON p.fid_Matricula=m.idMatricula
    WHERE p.idPago=p_id;
END $
DELIMITER ;



