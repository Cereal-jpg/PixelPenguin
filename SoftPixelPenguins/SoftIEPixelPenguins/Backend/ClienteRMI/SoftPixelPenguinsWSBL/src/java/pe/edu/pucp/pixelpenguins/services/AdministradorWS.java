package pe.edu.pucp.pixelpenguins.services;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import pe.edu.pucp.pixelpenguins.rmi.interfaces.AdministradorBO;
import pe.edu.pucp.pixelpenguins.rmi.servidor.SoftPixelPenguinsRMI_Servidor;
import pe.edu.pucp.pixelpenguins.usuario.model.Administrador;

@WebService(serviceName = "AdministradorWS", targetNamespace
        = "http://services.pixelpenguins.pucp.edu.pe")
public class AdministradorWS {

    private String IP;
    private Integer puerto;
    private AdministradorBO administradorBO;
    
    public AdministradorWS() {
        SoftPixelPenguinsRMI_Servidor.cargarConfiguracionServidorRMI();
        try {
            String nombreServicio = SoftPixelPenguinsRMI_Servidor.retornarNombreDelServicio("administradorBO");
            this.administradorBO = (AdministradorBO) Naming.lookup(nombreServicio);

        } catch (NotBoundException | MalformedURLException | RemoteException ex) {
            Logger.getLogger(AdministradorWS.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @WebMethod(operationName = "insertarAdministrador")
    public Integer insertarAdministrador(@WebParam(name = "administrador") Administrador administrador) {
        Integer resultado = 0;
        try {
            resultado = administradorBO.insertar(administrador);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    
    @WebMethod(operationName = "modificarAdministrador")
    public Integer modificarAdministrador(@WebParam(name = "administrador") Administrador administrador) {
        Integer resultado = 0;
        try {
            resultado = administradorBO.modificar(administrador);
        } catch (RemoteException ex) {
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    
    @WebMethod(operationName = "eliminarAdministrador")
    public Integer eliminarAdministrador(@WebParam(name = "administrador") Administrador administrador) {
        Integer resultado = 0;
        try {
            resultado = administradorBO.eliminar(administrador);
        } catch (RemoteException ex) {
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    
    @WebMethod(operationName = "listarTodosAdministradores")
    public ArrayList<Administrador> listarTodosAdministradores() {
        ArrayList<Administrador> administradores = null;
        try {
            administradores = administradorBO.listarTodos();
        } catch (RemoteException ex) {
            System.out.println(ex.getMessage());
        }
        return administradores;
    }
    
    @WebMethod(operationName = "obtenerAdministradorPorId")
    public Administrador obtenerAdministradorPorId(@WebParam(name = "idUsuario") Integer idUsuario) {
        Administrador administrador = null;
        try {
            administrador = administradorBO.obtenerPorId(idUsuario);
        } catch (RemoteException ex) {
            System.out.println(ex.getMessage());
        }
        return administrador;
    }
    
    @WebMethod(operationName = "existeAdministrador")
    public Boolean existeAdministrador(@WebParam(name = "idUsuario") Integer idUsuario) {
        Boolean resultado = null;
        try {
            resultado = administradorBO.existeAdministrador(idUsuario);
        } catch (RemoteException ex) {
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    
}
