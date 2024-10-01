
package pe.edu.pucp.pixelpenguins.institucioneducativa.dao;

import java.util.ArrayList;
import pe.edu.pucp.pixelpenguins.institucioneducativa.model.InstitucionEducativa;

public interface InstitucionEducativaDAO {
    public int insertar(InstitucionEducativa ie);
    public int modificar(InstitucionEducativa ie);
    public int eliminar(InstitucionEducativa ie);
    public ArrayList<InstitucionEducativa> listarTodos();
    public InstitucionEducativa obtenerPorId (int idInstitucionEducativa);
}
