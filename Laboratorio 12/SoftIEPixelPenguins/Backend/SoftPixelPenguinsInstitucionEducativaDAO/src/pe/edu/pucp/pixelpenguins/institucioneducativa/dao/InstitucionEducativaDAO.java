
package pe.edu.pucp.pixelpenguins.institucioneducativa.dao;

import java.util.ArrayList;
import pe.edu.pucp.pixelpenguins.institucioneducativa.model.InstitucionEducativa;

public interface InstitucionEducativaDAO {
    public Integer insertar(InstitucionEducativa ie);
    public Integer modificar(InstitucionEducativa ie);
    public Integer eliminar(InstitucionEducativa ie);
    public ArrayList<InstitucionEducativa> listarTodos();
    public InstitucionEducativa obtenerPorId (Integer idInstitucionEducativa);
}
