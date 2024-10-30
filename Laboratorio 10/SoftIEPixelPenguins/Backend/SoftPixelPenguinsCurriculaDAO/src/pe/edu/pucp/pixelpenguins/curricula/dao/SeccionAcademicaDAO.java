package pe.edu.pucp.pixelpenguins.curricula.dao;

import java.util.ArrayList;
import pe.edu.pucp.pixelpenguins.curricula.model.SeccionAcademica;

public interface SeccionAcademicaDAO {
    public Integer insertar(SeccionAcademica seccionAcademica);
    public Integer modificar(SeccionAcademica seccionAcademica);
    public Integer eliminar(SeccionAcademica seccionAcademica);
    public ArrayList<SeccionAcademica> listarTodos();
    public SeccionAcademica obtenerPorId(Integer idSeccionAcademica);
}
