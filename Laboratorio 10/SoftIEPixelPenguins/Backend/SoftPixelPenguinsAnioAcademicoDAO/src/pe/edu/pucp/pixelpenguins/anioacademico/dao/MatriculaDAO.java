package pe.edu.pucp.pixelpenguins.anioacademico.dao;

import java.util.ArrayList;
import pe.edu.pucp.pixelpenguins.anioacademico.model.Matricula;

public interface MatriculaDAO {
    public Integer insertar(Matricula matricula);
    public Integer modificar(Matricula matricula);
    public Integer eliminar(Matricula matricula);
    public ArrayList<Matricula> listarTodos();
    public Matricula obtenerPorId(Integer idMatricula);
    public Integer obtenerPorIdAlumno(Integer idAlumno);
}
