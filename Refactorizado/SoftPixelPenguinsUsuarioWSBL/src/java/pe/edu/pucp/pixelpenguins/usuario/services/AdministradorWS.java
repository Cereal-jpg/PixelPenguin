package pe.edu.pucp.pixelpenguins.usuario.services;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import java.util.ArrayList;
import pe.edu.pucp.pixelpenguins.usuario.bo.AdministradorBO;
import pe.edu.pucp.pixelpenguins.usuario.model.Administrador;

@WebService(serviceName = "AdministradorWS", targetNamespace
        = "http://services.usuario.pixelpenguins.pucp.edu.pe")
public class AdministradorWS {

    private AdministradorBO administradorBO = new AdministradorBO();
    
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
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    
    @WebMethod(operationName = "eliminarAdministrador")
    public Integer eliminarAdministrador(@WebParam(name = "administrador") Administrador administrador) {
        Integer resultado = 0;
        try {
            resultado = administradorBO.eliminar(administrador);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    
    @WebMethod(operationName = "listarTodosAdministradores")
    public ArrayList<Administrador> listarTodosAdministradores() {
        ArrayList<Administrador> administradores = null;
        try {
            administradores = administradorBO.listarTodos();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return administradores;
    }
    
    @WebMethod(operationName = "obtenerAdministradorPorId")
    public Administrador obtenerAdministradorPorId(@WebParam(name = "idUsuario") Integer idUsuario) {
        Administrador administrador = null;
        try {
            administrador = administradorBO.obtenerPorId(idUsuario);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return administrador;
    }
    
    @WebMethod(operationName = "existeAdministrador")
    public Boolean existeAdministrador(@WebParam(name = "idUsuario") Integer idUsuario) {
        Boolean resultado = null;
        try {
            resultado = administradorBO.existeAdministrador(idUsuario);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    
}
