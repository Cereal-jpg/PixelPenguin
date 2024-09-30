
package pe.edu.pucp.pixelpenguins.anioacademico.dao;

import java.util.ArrayList;
import pe.edu.pucp.pixelpenguins.anioacademico.model.Matricula;

public interface MatriculaDAO {
    public int insertar(Matricula matricula);
    public int modificar(Matricula matricula);
    public int eliminar(Matricula matricula);
    public ArrayList<Matricula> listarTodos();
    public Matricula obtenerPorId(int idMatricula);
}
