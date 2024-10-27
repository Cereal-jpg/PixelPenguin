-- Insertando área auxiliar
INSERT INTO area (nombre) VALUES ('Area prueba');
INSERT INTO area (nombre) VALUES ('Area prueba 2');
INSERT INTO area (nombre) VALUES ('Area prueba 3');


-- Por si no se declararon el valor de activos
UPDATE area SET activo = 1 WHERE id_area>0;
-- Verificar con: 
SELECT * FROM area; 

-- probando procedimiento:
CALL INSERTAR_EMPLEADO
-- primero el parámetro de salida, luego el FK de area, luego todos los
-- demás parámetros que señalamos en el procedimiento en orden
(@id,1,'Fiorella Falconi','87864380','2021-01-18',30,'F','Disenadora',1500.00);
SELECT @id; -- mostrando el id que se debería generar

SELECT * FROM persona;
SELECT * FROM empleado;

DELETE FROM empleado WHERE id_empleado>0;
DELETE FROM area WHERE id_area>0;
DELETE FROM persona WHERE id_persona>0;

SELECT * FROM persona INNER JOIN empleado ON persona.id_persona=empleado.id_empleado;

