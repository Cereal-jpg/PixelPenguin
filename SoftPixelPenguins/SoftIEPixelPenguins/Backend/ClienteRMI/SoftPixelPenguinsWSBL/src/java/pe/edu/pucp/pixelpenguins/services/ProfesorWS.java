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
import pe.edu.pucp.pixelpenguins.rmi.interfaces.ProfesorBO;
import pe.edu.pucp.pixelpenguins.rmi.servidor.SoftPixelPenguinsRMI_Servidor;
import pe.edu.pucp.pixelpenguins.usuario.model.Profesor;

@WebService(serviceName = "ProfesorWS", targetNamespace
        = "http://services.pixelpenguins.pucp.edu.pe")
public class ProfesorWS {

    private String IP;
    private Integer puerto;
    private ProfesorBO profesorBO;
    
    public ProfesorWS() {
        SoftPixelPenguinsRMI_Servidor.cargarConfiguracionServidorRMI();
        try {
            String nombreServicio = SoftPixelPenguinsRMI_Servidor.retornarNombreDelServicio("profesorBO");
            this.profesorBO = (ProfesorBO) Naming.lookup(nombreServicio);

        } catch (NotBoundException | MalformedURLException | RemoteException ex) {
            Logger.getLogger(ProfesorWS.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @WebMethod(operationName = "insertarProfesor")
    public Integer insertarProfesor(@WebParam(name = "profesor") Profesor profesor) {
        Integer resultado = 0;
        try {
            resultado = profesorBO.insertar(profesor);
        } catch (RemoteException ex) {
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    
    @WebMethod(operationName = "modificarProfesor")
    public Integer modificarProfesor(@WebParam(name = "profesor") Profesor profesor) {
        Integer resultado = 0;
        try {
            resultado = profesorBO.modificar(profesor);
        } catch (RemoteException ex) {
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    
    @WebMethod(operationName = "eliminarProfesor")
    public Integer eliminarProfesor(@WebParam(name = "profesor") Profesor profesor) {
        Integer resultado = 0;
        try {
            resultado = profesorBO.eliminar(profesor);
        } catch (RemoteException ex) {
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    
    @WebMethod(operationName = "listarTodosProfesores")
    public ArrayList<Profesor> listarTodosProfesores() {
        ArrayList<Profesor> profesores = null;
        try {
            profesores = profesorBO.listarTodos();
        } catch (RemoteException ex) {
            System.out.println(ex.getMessage());
        }
        return profesores;
    }
    
    @WebMethod(operationName = "obtenerProfesorPorId")
    public Profesor obtenerprofesorPorId(@WebParam(name = "idUsuario") Integer idUsuario) {
        Profesor profesor = null;
        try {
            profesor = profesorBO.obtenerPorId(idUsuario);
        } catch (RemoteException ex) {
            System.out.println(ex.getMessage());
        }
        return profesor;
    }
    
    @WebMethod(operationName = "existeprofesor")
    public Boolean existeprofesor(@WebParam(name = "idUsuario") Integer idUsuario) {
        Boolean resultado = null;
        try {
            resultado = profesorBO.existeProfesor(idUsuario);
        } catch (RemoteException ex) {
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    
    @WebMethod(operationName = "listarProfesoresPorNombre")
    public ArrayList<Profesor>listarProfesoresPorNombre(@WebParam(name = "nombre") String nombre) {
        ArrayList<Profesor> profesores = null;
        try {
            profesores = profesorBO.listarProfesoresPorNombre(nombre);
        } catch (RemoteException ex) {
            System.out.println(ex.getMessage());
        }
        return profesores;
    }
    
}
