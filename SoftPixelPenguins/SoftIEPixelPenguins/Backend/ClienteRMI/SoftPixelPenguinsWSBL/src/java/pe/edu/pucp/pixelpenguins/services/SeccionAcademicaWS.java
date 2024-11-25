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
import pe.edu.pucp.pixelpenguins.curricula.model.GradoAcademico;
import pe.edu.pucp.pixelpenguins.curricula.model.SeccionAcademica;
import pe.edu.pucp.pixelpenguins.rmi.interfaces.SeccionAcademicaBO;
import pe.edu.pucp.pixelpenguins.rmi.servidor.SoftPixelPenguinsRMI_Servidor;

@WebService(serviceName = "SeccionAcademicaWS", targetNamespace
        = "http://services.pixelpenguins.pucp.edu.pe")
public class SeccionAcademicaWS {

    private String IP = "localhost";
    private Integer puerto = 1234;
    SeccionAcademicaBO seccionAcademicaBO;
    
    public SeccionAcademicaWS() {
        try {
            String nombreServicio = SoftPixelPenguinsRMI_Servidor.retornarNombreDelServicio("seccionAcademicaBO");
            this.seccionAcademicaBO = (SeccionAcademicaBO) Naming.lookup(nombreServicio);

        } catch (NotBoundException | MalformedURLException | RemoteException ex) {
            Logger.getLogger(SeccionAcademicaWS.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @WebMethod(operationName = "insertarSeccionAcademica")
    public Integer insertarSeccionAcademica(@WebParam(name = "seccionAcademica") SeccionAcademica seccionAcademica) {
        Integer resultado = 0;
        try {
            resultado = seccionAcademicaBO.insertar(seccionAcademica);
        } catch (RemoteException ex) {
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    
    @WebMethod(operationName = "modificarSeccionAcademica")
    public Integer modificarSeccionAcademica(@WebParam(name = "seccionAcademica") SeccionAcademica seccionAcademica) {
        Integer resultado = 0;
        try {
            resultado = seccionAcademicaBO.modificar(seccionAcademica);
        } catch (RemoteException ex) {
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    
    @WebMethod(operationName = "eliminarSeccionAcademica")
    public Integer eliminarSeccionAcademica(@WebParam(name = "seccionAcademica") SeccionAcademica seccionAcademica) {
        Integer resultado = 0;
        try {
            resultado = seccionAcademicaBO.eliminar(seccionAcademica);
        } catch (RemoteException ex) {
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    
    @WebMethod(operationName = "listarTodosSeccionesAcademicas")
    public ArrayList<SeccionAcademica> listarTodosSeccionesAcademicas() {
        ArrayList<SeccionAcademica> seccionesAcademicas = null;
        try {
            seccionesAcademicas = seccionAcademicaBO.listarTodos();
        } catch (RemoteException ex) {
            System.out.println(ex.getMessage());
        }
        return seccionesAcademicas;
    }
    
    @WebMethod(operationName = "obtenerSeccionAcademicaPorId")
    public SeccionAcademica obtenerSeccionAcademicaPorId(@WebParam(name = "idSeccionAcademica") Integer idSeccionAcademica) {
        SeccionAcademica seccionAcademica = null;
        try {
            seccionAcademica = seccionAcademicaBO.obtenerPorId(idSeccionAcademica);
        } catch (RemoteException ex) {
            System.out.println(ex.getMessage());
        }
        return seccionAcademica;
    }
    
    @WebMethod(operationName = "listarSeccionesPorGrado")
    public ArrayList<SeccionAcademica> listarSeccionesPorGrado(@WebParam(name = "gradoAcademico") GradoAcademico gradoAcademico) {
        ArrayList<SeccionAcademica> seccionesAcademicas = null;
        try {
            seccionesAcademicas = seccionAcademicaBO.listarSeccionesPorGrado(gradoAcademico);
        } catch (RemoteException ex) {
            System.out.println(ex.getMessage());
        }
        return seccionesAcademicas;
    }
    
}
