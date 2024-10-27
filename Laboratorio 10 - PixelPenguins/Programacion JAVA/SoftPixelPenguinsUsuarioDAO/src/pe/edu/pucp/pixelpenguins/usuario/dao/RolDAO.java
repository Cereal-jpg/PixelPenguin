
package pe.edu.pucp.pixelpenguins.usuario.dao;

import java.util.ArrayList;
import pe.edu.pucp.pixelpenguins.usuario.model.Rol;

public interface RolDAO {
    public int insertar(Rol rol);
    public int modificar(Rol rol);
    public int eliminar(Rol rol);
    public ArrayList<Rol> listarTodos();
    public Rol obtenerPorId (int idRol);
}
