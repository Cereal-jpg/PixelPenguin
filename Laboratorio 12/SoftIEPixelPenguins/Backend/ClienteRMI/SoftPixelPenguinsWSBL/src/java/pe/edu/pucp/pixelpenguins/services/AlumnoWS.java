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
import pe.edu.pucp.pixelpenguins.rmi.interfaces.AlumnoBO;
import pe.edu.pucp.pixelpenguins.rmi.servidor.SoftPixelPenguinsRMI_Servidor;
import pe.edu.pucp.pixelpenguins.usuario.model.Alumno;
import pe.edu.pucp.pixelpenguins.usuario.model.EstadoAlumno;

@WebService(serviceName = "AlumnoWS", targetNamespace
        = "http://services.pixelpenguins.pucp.edu.pe")
public class AlumnoWS {

    private String IP = "localhost";
    private Integer puerto = 1234;
    private AlumnoBO alumnoBO;
    
    public AlumnoWS() {
        try {
            String nombreServicio = SoftPixelPenguinsRMI_Servidor.retornarNombreDelServicio("alumnoBO");
            this.alumnoBO = (AlumnoBO) Naming.lookup(nombreServicio);

        } catch (NotBoundException | MalformedURLException | RemoteException ex) {
            Logger.getLogger(AlumnoWS.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @WebMethod(operationName = "insertarAlumno")
    public Integer insertarAlumno(@WebParam(name = "alumno") Alumno alumno) {
        Integer resultado = 0;
        try {
            resultado = alumnoBO.insertar(alumno);
        } catch (RemoteException ex) {
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    
    @WebMethod(operationName = "modificarAlumno")
    public Integer modificarAlumno(@WebParam(name = "alumno") Alumno alumno) {
        Integer resultado = 0;
        try {
            resultado = alumnoBO.modificar(alumno);
        } catch (RemoteException ex) {
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    
    @WebMethod(operationName = "eliminarAlumno")
    public Integer eliminarAlumno(@WebParam(name = "alumno") Alumno alumno) {
        Integer resultado = 0;
        try {
            resultado = alumnoBO.eliminar(alumno);
        } catch (RemoteException ex) {
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    
    @WebMethod(operationName = "listarTodosAlumnos")
    public ArrayList<Alumno> listarTodosAlumnos() {
        ArrayList<Alumno> alumnos = null;
        try {
            alumnos = alumnoBO.listarTodos();
        } catch (RemoteException ex) {
            System.out.println(ex.getMessage());
        }
        return alumnos;
    }
    
    @WebMethod(operationName = "obtenerAlumnoPorId")
    public Alumno obtenerAlumnoPorId(@WebParam(name = "idUsuario") Integer idUsuario) {
        Alumno alumno = null;
        try {
            alumno = alumnoBO.obtenerPorId(idUsuario);
        } catch (RemoteException ex) {
            System.out.println(ex.getMessage());
        }
        return alumno;
    }
    
    @WebMethod(operationName = "listarAlumnosPorNombreYEstado")
    public ArrayList<Alumno> listarAlumnosPorNombreYEstado(@WebParam(name = "nombre") String nombre,@WebParam(name = "estado") EstadoAlumno estado) {
        ArrayList<Alumno> alumnos = null;
        try {
            alumnos = alumnoBO.listarAlumnosPorNombreYEstado(nombre,estado);
        } catch (RemoteException ex) {
            System.out.println(ex.getMessage());
        }
        return alumnos;
    }
    
    @WebMethod(operationName = "listarAlumnosPorNombre")
    public ArrayList<Alumno> listarAlumnosPorNombre(@WebParam(name = "nombre") String nombre) {
        ArrayList<Alumno> alumnos = null;
        try {
            alumnos = alumnoBO.listarAlumnosPorNombre(nombre);
        } catch (RemoteException ex) {
            System.out.println(ex.getMessage());
        }
        return alumnos;
    }
    
    @WebMethod(operationName = "existeAlumno")
    public Boolean existeAlumno(@WebParam(name = "idUsuario") Integer idUsuario) {
        Boolean resultado = null;
        try {
            resultado = alumnoBO.existeAlumno(idUsuario);
        } catch (RemoteException ex) {
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    
}
