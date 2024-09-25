
package pe.edu.pucp.pixelpenguins.usuario.dao;

import java.util.ArrayList;
import pe.edu.pucp.pixelpenguins.usuario.model.Profesor;

public interface ProfesorDAO {
    public int insertar(Profesor profesor);
    public int modificar(Profesor profesor);
    public int eliminar(Profesor profesor);
    public ArrayList<Profesor> listarTodos();
    public Profesor obtenerPorId(int id);
}
