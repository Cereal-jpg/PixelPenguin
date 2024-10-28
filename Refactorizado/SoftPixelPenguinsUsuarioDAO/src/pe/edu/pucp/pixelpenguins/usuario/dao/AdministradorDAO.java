package pe.edu.pucp.pixelpenguins.usuario.dao;

import java.util.ArrayList;
import pe.edu.pucp.pixelpenguins.usuario.model.Administrador;

public interface AdministradorDAO {
    public Integer insertar(Administrador administrador);
    public Integer modificar(Administrador administrador);
    public Integer eliminar(Administrador administrador);
    public ArrayList<Administrador> listarTodos();
    public Administrador obtenerPorId (Integer idAdministrador);
    public Boolean existeAdministrador(Administrador administrador);
    public Boolean existeAdministrador(Administrador administrador, Boolean abreConexion);
}
