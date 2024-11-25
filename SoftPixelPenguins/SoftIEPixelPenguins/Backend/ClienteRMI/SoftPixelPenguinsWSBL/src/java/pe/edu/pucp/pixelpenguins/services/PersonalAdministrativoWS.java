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
import pe.edu.pucp.pixelpenguins.rmi.interfaces.PersonalAdministrativoBO;
import pe.edu.pucp.pixelpenguins.rmi.servidor.SoftPixelPenguinsRMI_Servidor;
import pe.edu.pucp.pixelpenguins.usuario.model.PersonalAdministrativo;

@WebService(serviceName = "PersonalAdministrativoWS", targetNamespace
        = "http://services.pixelpenguins.pucp.edu.pe")
public class PersonalAdministrativoWS {
    
    private String IP = "localhost";
    private Integer puerto = 1234;
    private PersonalAdministrativoBO personalAdministrativoBO;
    
    public PersonalAdministrativoWS() {
        try {
            String nombreServicio = SoftPixelPenguinsRMI_Servidor.retornarNombreDelServicio("personalAdministrativoBO");
            this.personalAdministrativoBO = (PersonalAdministrativoBO) Naming.lookup(nombreServicio);

        } catch (NotBoundException | MalformedURLException | RemoteException ex) {
            Logger.getLogger(PersonalAdministrativoWS.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @WebMethod(operationName = "insertarPersonalAdministrativo")
    public Integer insertarPersonalAdministrativo(@WebParam(name = "personalAdministrativo") PersonalAdministrativo personalAdministrativo) {
        Integer resultado = 0;
        try {
            resultado = personalAdministrativoBO.insertar(personalAdministrativo);
        } catch (RemoteException ex) {
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    
    @WebMethod(operationName = "modificarPersonalAdministrativo")
    public Integer modificarPersonalAdministrativo(@WebParam(name = "personalAdministrativo") PersonalAdministrativo personalAdministrativo) {
        Integer resultado = 0;
        try {
            resultado = personalAdministrativoBO.modificar(personalAdministrativo);
        } catch (RemoteException ex) {
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    
    @WebMethod(operationName = "eliminarPersonalAdministrativo")
    public Integer eliminarPersonalAdministrativo(@WebParam(name = "personalAdministrativo") PersonalAdministrativo personalAdministrativo) {
        Integer resultado = 0;
        try {
            resultado = personalAdministrativoBO.eliminar(personalAdministrativo);
        } catch (RemoteException ex) {
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    
    @WebMethod(operationName = "listarTodosPersonalAdministrativo")
    public ArrayList<PersonalAdministrativo> listarTodosPersonalAdministrativo() {
        ArrayList<PersonalAdministrativo> personalAdministrativo = null;
        try {
            personalAdministrativo = personalAdministrativoBO.listarTodos();
        } catch (RemoteException ex) {
            System.out.println(ex.getMessage());
        }
        return personalAdministrativo;
    }
    
    @WebMethod(operationName = "obtenerPersonalAdministrativoPorId")
    public PersonalAdministrativo obtenerPersonalAdministrativoPorId(@WebParam(name = "idUsuario") Integer idUsuario) {
        PersonalAdministrativo personalAdministrativo = null;
        try {
            personalAdministrativo = personalAdministrativoBO.obtenerPorId(idUsuario);
        } catch (RemoteException ex) {
            System.out.println(ex.getMessage());
        }
        return personalAdministrativo;
    }
    
    @WebMethod(operationName = "existePersonalAdministrativo")
    public Boolean existePersonalAdministrativo(@WebParam(name = "idUsuario") Integer idUsuario) {
        Boolean resultado = null;
        try {
            resultado = personalAdministrativoBO.existePersonalAdministrativo(idUsuario);
        } catch (RemoteException ex) {
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    
}
