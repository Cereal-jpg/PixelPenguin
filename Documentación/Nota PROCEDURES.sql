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