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
import pe.edu.pucp.pixelpenguins.curricula.model.Curso;
import pe.edu.pucp.pixelpenguins.rmi.interfaces.CursoBO;
import pe.edu.pucp.pixelpenguins.rmi.servidor.SoftPixelPenguinsRMI_Servidor;

@WebService(serviceName = "CursoWS", targetNamespace
        = "http://services.pixelpenguins.pucp.edu.pe")
public class CursoWS {

    private String IP;
    private Integer puerto;
    CursoBO cursoBO;
    
    public CursoWS() {
        SoftPixelPenguinsRMI_Servidor.cargarConfiguracionServidorRMI();
        try {
            String nombreServicio = SoftPixelPenguinsRMI_Servidor.retornarNombreDelServicio("cursoBO");
            this.cursoBO = (CursoBO) Naming.lookup(nombreServicio);

        } catch (NotBoundException | MalformedURLException | RemoteException ex) {
            Logger.getLogger(CursoWS.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @WebMethod(operationName = "insertarCurso")
    public Integer insertarCurso(@WebParam(name = "curso") Curso curso) {
        Integer resultado = 0;
        try {
            resultado = cursoBO.insertar(curso);
        } catch (RemoteException ex) {
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    
    @WebMethod(operationName = "modificarCurso")
    public Integer modificarCurso(@WebParam(name = "curso") Curso curso) {
        Integer resultado = 0;
        try {
            resultado = cursoBO.modificar(curso);
        } catch (RemoteException ex) {
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    
    @WebMethod(operationName = "eliminarCurso")
    public Integer eliminarCurso(@WebParam(name = "curso") Curso curso) {
        Integer resultado = 0;
        try {
            resultado = cursoBO.eliminar(curso);
        } catch (RemoteException ex) {
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    
    @WebMethod(operationName = "listarTodosCursos")
    public ArrayList<Curso> listarTodosCursos() {
        ArrayList<Curso> cursos = null;
        try {
            cursos = cursoBO.listarTodos();
        } catch (RemoteException ex) {
            System.out.println(ex.getMessage());
        }
        return cursos;
    }
    
    @WebMethod(operationName = "obtenerCursoPorId")
    public Curso obtenerCursoPorId(@WebParam(name = "idCurso") Integer idCurso) {
        Curso curso = null;
        try {
            curso = cursoBO.obtenerPorId(idCurso);
        } catch (RemoteException ex) {
            System.out.println(ex.getMessage());
        }
        return curso;
    }
    
    @WebMethod(operationName = "listarCursosPorGrado")
    public ArrayList<Curso> listarCursosPorGrado(@WebParam(name = "idGrado") Integer idGrado) {
        ArrayList<Curso> cursos = null;
        try {
            cursos = cursoBO.listarCursosPorGrado(idGrado);
        } catch (RemoteException ex) {
            System.out.println(ex.getMessage());
        }
        return cursos;
    }
    
    @WebMethod(operationName = "listarCursosPorProfesor")
    public ArrayList<Curso> listarCursosPorProfesor(@WebParam(name = "idProfesor") Integer idProfesor) {
        ArrayList<Curso> cursos = null;
        try {
            cursos = cursoBO.listarCursosPorProfesor(idProfesor);
        } catch (RemoteException ex) {
            System.out.println(ex.getMessage());
        }
        return cursos;
    }
    
}
