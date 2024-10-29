package pe.edu.pucp.pixelpenguins.usuario.services;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import java.util.ArrayList;
import pe.edu.pucp.pixelpenguins.config.DBManager;
import pe.edu.pucp.pixelpenguins.usuario.bo.RolBO;
import pe.edu.pucp.pixelpenguins.usuario.model.Rol;

@WebService(serviceName = "RolWS", targetNamespace
        = "http://services.usuario.pixelpenguins.pucp.edu.pe")
public class RolWS {

    private RolBO rolBO;
    
    public RolWS(){
        rolBO=new RolBO();
    }
    
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
//    
//    @WebMethod(operationName = "pruebaConexion")
//    public String pruebaConexion(@WebParam(name = "aux") Integer idRol) {
//        DBManager.getInstance().getConnection();
//        return "conectado";
//    }
    
}
