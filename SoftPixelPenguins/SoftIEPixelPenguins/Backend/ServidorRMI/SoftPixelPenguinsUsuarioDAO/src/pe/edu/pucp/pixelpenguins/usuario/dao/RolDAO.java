package pe.edu.pucp.pixelpenguins.usuario.dao;

import java.util.ArrayList;
import pe.edu.pucp.pixelpenguins.usuario.model.Rol;

public interface RolDAO {
    public Integer insertar(Rol rol);
    public Integer modificar(Rol rol);
    public Integer eliminar(Rol rol);
    public ArrayList<Rol> listarTodos();
    public Rol obtenerPorId (Integer idRol);
}
