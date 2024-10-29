package pe.edu.pucp.pixelpenguins.services;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import java.util.ArrayList;
import pe.edu.pucp.pixelpenguins.config.DBManager;
import pe.edu.pucp.pixelpenguins.usuario.bo.RolBO;
import pe.edu.pucp.pixelpenguins.usuario.model.Rol;

@WebService(serviceName = "RolWS", targetNamespace
        = "http://services.pixelpenguins.pucp.edu.pe")
public class RolWS {

    private RolBO rolBO;

    public RolWS() {
        this.rolBO = new RolBO();
    }
    
    @WebMethod(operationName = "insertarRol")
    public Integer insertarRol(@WebParam(name = "rol") Rol rol) {
        Integer resultado = 0;
        try {
            resultado = rolBO.insertar(rol);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    
    @WebMethod(operationName = "modificarRol")
    public Integer modificarRol(@WebParam(name = "rol") Rol rol) {
        Integer resultado = 0;
        try {
            resultado = rolBO.modificar(rol);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    
    @WebMethod(operationName = "eliminarRol")
    public Integer eliminarRol(@WebParam(name = "rol") Rol rol) {
        Integer resultado = 0;
        try {
            resultado = rolBO.eliminar(rol);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    
    @WebMethod(operationName = "listarTodosRoles")
    public ArrayList<Rol> listarTodosRoles() {
        ArrayList<Rol> roles = null;
        try {
            roles = rolBO.listarTodos();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return roles;
    }
    
    @WebMethod(operationName = "obtenerRolPorId")
    public Rol obtenerRolPorId(@WebParam(name = "idRol") Integer idRol) {
        Rol rol = null;
        try {
            rol = rolBO.obtenerPorId(idRol);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return rol;
    }

    // metodos estándar
    @WebMethod(operationName="rol_listarTodos")
    public ArrayList<Rol> rol_listarTodos(){
        return rolBO.listarTodos();
    }
    
    @WebMethod(operationName = "rol_obtenerPorId")
    public Rol rol_obtenerPorId(@WebParam(name="idRol") Integer idRol){
        return rolBO.obtenerPorId(idRol);
    }
    
    @WebMethod(operationName = "rol_insertar")
    public Integer rol_insertar(@WebParam(name="nombre") String nombre){
        return rolBO.insertar(nombre);
    }
    
    @WebMethod(operationName = "rol_eliminar")
    public Integer rol_eliminar(@WebParam(name="idRol") Integer idRol){
        return rolBO.eliminar(idRol);
    }   
}
