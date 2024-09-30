
package pe.edu.pucp.pixelpenguins.anioacademico.dao;

import java.util.ArrayList;
import pe.edu.pucp.pixelpenguins.anioacademico.model.AnioAcademico;

public interface AnioAcademicoDAO {
    public int insertar(AnioAcademico anioAcademico);
    public int modificar(AnioAcademico anioAcademico);
    public int eliminar(AnioAcademico anioAcademico);
    public ArrayList<AnioAcademico> listarTodos();
    public AnioAcademico obtenerPorId(int idAnioAcademico);
}
