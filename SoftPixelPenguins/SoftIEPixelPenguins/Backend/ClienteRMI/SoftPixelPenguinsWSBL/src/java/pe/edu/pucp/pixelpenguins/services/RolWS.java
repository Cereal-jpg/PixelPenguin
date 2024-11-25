package pe.edu.pucp.pixelpenguins.services;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import java.net.MalformedURLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import pe.edu.pucp.pixelpenguins.rmi.interfaces.RolBO;
import pe.edu.pucp.pixelpenguins.rmi.servidor.SoftPixelPenguinsRMI_Servidor;
import pe.edu.pucp.pixelpenguins.usuario.model.Rol;

@WebService(serviceName = "RolWS", targetNamespace
        = "http://services.pixelpenguins.pucp.edu.pe")
public class RolWS {

    private static String IP;
    private static Integer puerto;
    private RolBO rolBO;

    public RolWS() {
        SoftPixelPenguinsRMI_Servidor.cargarConfiguracionServidorRMI();
        try {
            String nombreServicio = SoftPixelPenguinsRMI_Servidor.retornarNombreDelServicio("rolBO");
            this.rolBO = (RolBO) Naming.lookup(nombreServicio);

        } catch (NotBoundException | MalformedURLException | RemoteException ex) {
            Logger.getLogger(RolWS.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @WebMethod(operationName = "insertarRol")
    public Integer insertarRol(@WebParam(name = "rol") Rol rol) {
        Integer resultado = 0;
        try {
            resultado = rolBO.insertar(rol);
        } catch (RemoteException ex) {
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    
    @WebMethod(operationName = "modificarRol")
    public Integer modificarRol(@WebParam(name = "rol") Rol rol) {
        Integer resultado = 0;
        try {
            resultado = rolBO.modificar(rol);
        } catch (RemoteException ex) {
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    
    @WebMethod(operationName = "eliminarRol")
    public Integer eliminarRol(@WebParam(name = "rol") Rol rol) {
        Integer resultado = 0;
        try {
            resultado = rolBO.eliminar(rol);
        } catch (RemoteException ex) {
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    
    @WebMethod(operationName = "listarTodosRoles")
    public ArrayList<Rol> listarTodosRoles() {
        ArrayList<Rol> roles = null;
        try {
            roles = rolBO.listarTodos();
        } catch (RemoteException ex) {
            System.out.println(ex.getMessage());
        }
        return roles;
    }
    
    @WebMethod(operationName = "obtenerRolPorId")
    public Rol obtenerRolPorId(@WebParam(name = "idRol") Integer idRol) {
        Rol rol = null;
        try {
            rol = rolBO.obtenerPorId(idRol);
        } catch (RemoteException ex) {
            System.out.println(ex.getMessage());
        }
        return rol;
    }
 
}
