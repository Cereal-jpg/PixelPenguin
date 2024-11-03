
package pe.edu.pucp.pixelpenguins.curricula.dao;

import java.util.ArrayList;
import pe.edu.pucp.pixelpenguins.curricula.model.JornadaEscolar;

public interface JornadaEscolarDAO {
    public int insertar(JornadaEscolar jornada);
    public int modificar(JornadaEscolar jornada);
    public int eliminar(JornadaEscolar jornada);
    public ArrayList<JornadaEscolar> listarTodos();
    public JornadaEscolar obtenerPorId(int id);
}
