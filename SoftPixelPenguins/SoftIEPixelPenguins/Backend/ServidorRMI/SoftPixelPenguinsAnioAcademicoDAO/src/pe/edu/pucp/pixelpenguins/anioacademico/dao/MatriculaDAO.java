package pe.edu.pucp.pixelpenguins.anioacademico.dao;

import java.util.ArrayList;
import pe.edu.pucp.pixelpenguins.anioacademico.model.Matricula;
import pe.edu.pucp.pixelpenguins.curricula.model.GradoAcademico;

public interface MatriculaDAO {
    public Integer insertar(Matricula matricula);
    public Integer modificar(Matricula matricula);
    public Integer eliminar(Matricula matricula);
    public ArrayList<Matricula> listarTodos();
    public Matricula obtenerPorId(Integer idMatricula);
    public Integer obtenerPorIdAlumno(Integer idAlumno);
    public ArrayList<Matricula>listarMatriculasPorGradoAcademico(GradoAcademico gradoAcademico);
    public ArrayList<String>listarNotasFinalesPorGradoAcademico(GradoAcademico gradoAcademico);
    public Integer actualizarNotaFinal(Integer idMatricula, String notaFinal);
}
