package pe.edu.pucp.pixelpenguins.curricula.dao;

import java.util.ArrayList;
import pe.edu.pucp.pixelpenguins.curricula.model.Nota;

public interface NotaDAO {
    public Integer insertar(Nota nota);
    public Integer modificar(Nota nota);
    public Integer eliminar(Nota nota);
    public ArrayList<Nota> listarTodos();
    public Nota obtenerPorId(Integer idNota);
    public ArrayList<Nota> listarPorAlumnoYCurso(Integer idAlumno,Integer idCurso);
    public ArrayList<Nota> listarPorAlumnoCursoYBimestre(Integer idAlumno,Integer idCurso,Integer bimestre);
    public Nota obtenerNotaPorParametros(Integer idMatricula, Integer idAlumno,Integer idCurso,Integer bimestre,Integer idCompetencia);
}
