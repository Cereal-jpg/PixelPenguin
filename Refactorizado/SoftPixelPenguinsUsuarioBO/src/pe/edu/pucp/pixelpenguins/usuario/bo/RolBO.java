
package pe.edu.pucp.pixelpenguins.usuario.bo;

import java.util.ArrayList;
import pe.edu.pucp.pixelpenguins.usuario.dao.RolDAO;
import pe.edu.pucp.pixelpenguins.usuario.daoImp.RolDAOImp;
import pe.edu.pucp.pixelpenguins.usuario.model.Rol;

public class RolBO {
    private RolDAO rolDAO;
    
    public RolBO(){
        this.rolDAO=new RolDAOImp();
    }
    
    public Integer insertar(String nombre){
        Rol rol = new Rol(nombre);
        return rolDAO.insertar(rol);
    }
    
    public Integer modificar(int id, String nombre,boolean activo){
        Rol rol = new Rol(id,nombre);
        rol.setActivo(false);
        return rolDAO.modificar(rol);
    }
    
    public Integer eliminar(int id, String nombre){
        Rol rol = new Rol(id,nombre);
        return rolDAO.eliminar(rol);
    }
    
    public ArrayList<Rol> listarTodos(){
        return rolDAO.listarTodos();
    }
    
    public Rol obtenerPorId(int id){
        return rolDAO.obtenerPorId(id);
    }
}
