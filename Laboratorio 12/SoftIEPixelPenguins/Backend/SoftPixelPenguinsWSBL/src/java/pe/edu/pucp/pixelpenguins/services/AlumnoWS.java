package pe.edu.pucp.pixelpenguins.services;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import java.util.ArrayList;
import pe.edu.pucp.pixelpenguins.usuario.bo.AlumnoBO;
import pe.edu.pucp.pixelpenguins.usuario.model.Alumno;
import pe.edu.pucp.pixelpenguins.usuario.model.EstadoAlumno;

@WebService(serviceName = "AlumnoWS", targetNamespace
        = "http://services.pixelpenguins.pucp.edu.pe")
public class AlumnoWS {

    private AlumnoBO alumnoBO = new AlumnoBO();
    
    @WebMethod(operationName = "insertarAlumno")
    public Integer insertarAlumno(@WebParam(name = "alumno") Alumno alumno) {
        Integer resultado = 0;
        try {
            resultado = alumnoBO.insertar(alumno);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    
    @WebMethod(operationName = "modificarAlumno")
    public Integer modificarAlumno(@WebParam(name = "alumno") Alumno alumno) {
        Integer resultado = 0;
        try {
            resultado = alumnoBO.modificar(alumno);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    
    @WebMethod(operationName = "eliminarAlumno")
    public Integer eliminarAlumno(@WebParam(name = "alumno") Alumno alumno) {
        Integer resultado = 0;
        try {
            resultado = alumnoBO.eliminar(alumno);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    
    @WebMethod(operationName = "listarTodosAlumnos")
    public ArrayList<Alumno> listarTodosAlumnos() {
        ArrayList<Alumno> alumnos = null;
        try {
            alumnos = alumnoBO.listarTodos();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return alumnos;
    }
    
    @WebMethod(operationName = "obtenerAlumnoPorId")
    public Alumno obtenerAlumnoPorId(@WebParam(name = "idUsuario") Integer idUsuario) {
        Alumno alumno = null;
        try {
            alumno = alumnoBO.obtenerPorId(idUsuario);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return alumno;
    }
    
    @WebMethod(operationName = "listarAlumnosPorEstado")
    public ArrayList<Alumno> listarAlumnosPorEstado(@WebParam(name = "estado") EstadoAlumno estado) {
        ArrayList<Alumno> alumnos = null;
        try {
            alumnos = alumnoBO.listarAlumnosPorEstado(estado);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return alumnos;
    }
    
    @WebMethod(operationName = "existeAlumno")
    public Boolean existeAlumno(@WebParam(name = "idUsuario") Integer idUsuario) {
        Boolean resultado = null;
        try {
            resultado = alumnoBO.existeAlumno(idUsuario);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    
}
