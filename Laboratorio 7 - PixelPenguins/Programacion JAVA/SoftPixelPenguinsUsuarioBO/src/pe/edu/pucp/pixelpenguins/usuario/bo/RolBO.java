
package pe.edu.pucp.pixelpenguins.usuario.bo;

import pe.edu.pucp.pixelpenguins.usuario.dao.RolDAO;
import pe.edu.pucp.pixelpenguins.usuario.daoImp.RolDAOImp;
import pe.edu.pucp.pixelpenguins.usuario.model.Rol;

public class RolBO {
    private RolDAO rolDAO;
    
    public RolBO(){
        this.rolDAO=new RolDAOImp();
    }
    
    public int insertar(String nombre){
        Rol rol = new Rol(nombre);
        return rolDAO.insertar(rol);
    }
}