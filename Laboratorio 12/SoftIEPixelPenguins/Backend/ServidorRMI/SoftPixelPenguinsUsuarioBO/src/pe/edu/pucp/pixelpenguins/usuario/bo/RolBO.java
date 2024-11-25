
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
    
    public Integer insertar(Rol rol) {
        return this.rolDAO.insertar(rol);
    }
    
    public Integer modificar(Rol rol) {
        return this.rolDAO.modificar(rol);
    }
    
    public Integer eliminar(Rol rol) {
        return this.rolDAO.eliminar(rol);
    }

    public ArrayList<Rol> listarTodos() {
        return this.rolDAO.listarTodos();
    }

    public Rol obtenerPorId(Integer idRol) {
        return this.rolDAO.obtenerPorId(idRol);
    }
    
}
