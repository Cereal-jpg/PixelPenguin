package pe.edu.pucp.pixelpenguins.anioacademico.dao;

import java.util.ArrayList;
import pe.edu.pucp.pixelpenguins.anioacademico.model.CursoXMatricula;

public interface CursoXMatriculaDAO {
    public Integer insertar(CursoXMatricula cursoXMatricula);
    public Integer modificar(CursoXMatricula cursoXMatricula);
    public Integer eliminar(CursoXMatricula cursoXMatricula);
    public ArrayList<CursoXMatricula> listarTodos();
    public CursoXMatricula obtenerPorCursoYMatricula(Integer idCurso,Integer idMatricula);
    public ArrayList<CursoXMatricula> listarNotasFinalesCursosXMatricula (Integer idMatricula);
    public ArrayList<CursoXMatricula> listarNotasFinalesCursosXAlumno (Integer idAlumno);
    public ArrayList<CursoXMatricula> listarNotasFinalesXCurso (Integer idCurso);
}
