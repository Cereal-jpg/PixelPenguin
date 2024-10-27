
package pe.edu.pucp.pixelpenguins.usuario.bo;

import java.util.ArrayList;
import pe.edu.pucp.pixelpenguins.usuario.dao.RolDAO;
import pe.edu.pucp.pixelpenguins.usuario.daoImp.RolDAOImpl;
import pe.edu.pucp.pixelpenguins.usuario.model.Rol;

public class RolBO {
    
    private RolDAO rolDAO;

    public RolBO() {
        this.rolDAO = new RolDAOImpl();
    }

    public Integer insertar(String nombre) {
        Rol rol = new Rol(nombre);
        return this.rolDAO.insertar(rol);
    }

    public Integer modificar(int idRol, String nombre) {
        Rol rol = new Rol(idRol, nombre);
        return this.rolDAO.modificar(rol);
    }

    public Integer eliminar(int idRol) {
        Rol rol = new Rol(idRol);
        return this.rolDAO.eliminar(rol);
    }

    public ArrayList<Rol> listarTodos() {
        return this.rolDAO.listarTodos();
    }

    public Rol obtenerPorId(Integer idRol) {
        return this.rolDAO.obtenerPorId(idRol);
    }
    
}
