
package pe.edu.pucp.pixelpenguins.usuario.dao;

import java.util.ArrayList;
import pe.edu.pucp.pixelpenguins.usuario.model.EquipoAdministrativo;

public interface EquipoAdministrativoDAO {
    public int insertar(EquipoAdministrativo equipoAdministrativo);
    public int modificar(EquipoAdministrativo equipoAdministrativo);
    public int eliminar(EquipoAdministrativo equipoAdministrativo);
    public ArrayList<EquipoAdministrativo> listarTodos();
    public EquipoAdministrativo obtenerPorId(String a);
    
}
