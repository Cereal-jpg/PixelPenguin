
package pe.edu.pucp.pixelpenguins.anioacademico.dao;

import java.util.ArrayList;
import pe.edu.pucp.pixelpenguins.anioacademico.model.AnioAcademico;

public interface AnioAcademicoDAO {
    public Integer insertar(AnioAcademico anioAcademico);
    public Integer modificar(AnioAcademico anioAcademico);
    public Integer eliminar(AnioAcademico anioAcademico);
    public ArrayList<AnioAcademico> listarTodos();
    public AnioAcademico obtenerPorId(Integer idAnioAcademico);
}
