package pe.edu.pucp.pixelpenguins.curricula.dao;

import java.util.ArrayList;
import pe.edu.pucp.pixelpenguins.curricula.model.Curso;

public interface CursoDAO {
    public Integer insertar(Curso curso);
    public Integer modificar(Curso curso);
    public Integer eliminar(Curso curso);
    public ArrayList<Curso> listarTodos();
    public Curso obtenerPorId(Integer idCurso);
    public ArrayList<Curso> listarCursosPorGrado(Integer idGradoAcademico);
}
