-- para cambiar el delimitador de ";" a "$"
DELIMITER $ 
CREATE PROCEDURE INSERTAR_EMPLEADO(
	-- Parámetro de salida (envía a programación una vez terminada las instrucciones)
    OUT p_id_empleado INT,
    -- Procedimiento recibe todos estos parámetros de entrada
	-- FK recomendable colocarlos al inicio
    IN p_fid_area INT,
    IN p_nombre_completo VARCHAR(150),
    IN p_DNI VARCHAR(8),
    IN p_fecha_nacimiento DATE,
    IN p_edad INT,
    IN p_genero CHAR,
    IN p_cargo VARCHAR(100),
    IN p_sueldo DECIMAL(10,2)
)

BEGIN
	-- al insertar una persona, se va a generar un ID
	INSERT INTO persona(nombre_completo,DNI,fecha_nacimiento,edad,genero)
    VALUES (p_nombre_completo,p_DNI,p_fecha_nacimiento,p_edad,p_genero);
    -- el ID generado se setea en esta variable
    SET p_id_empleado = @@last_insert_id; 
    INSERT INTO empleado(id_empleado,fid_area,cargo,sueldo,activo)
    VALUES (p_id_empleado,p_fid_area,p_cargo,p_sueldo,1);
END $

-- al llegar a delimiter de la línea 26, vuelve al ";" por default