
package pe.edu.pucp.pixelpenguins.curricula.dao;

import java.util.ArrayList;
import pe.edu.pucp.pixelpenguins.curricula.model.JornadaEscolar;

public interface JornadaEscolarDAO {
    public Integer insertar(JornadaEscolar jornada);
    public Integer modificar(JornadaEscolar jornada);
    public Integer eliminar(JornadaEscolar jornada);
    public ArrayList<JornadaEscolar> listarTodos();
    public JornadaEscolar obtenerPorId(Integer id);
}
