package pe.edu.pucp.pixelpenguins.curricula.services;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import java.util.ArrayList;
import pe.edu.pucp.pixelpenguins.curricula.bo.CursoBO;
import pe.edu.pucp.pixelpenguins.curricula.model.Curso;

@WebService(serviceName = "CursoWS", targetNamespace
        = "http://services.curricula.pixelpenguins.pucp.edu.pe")
public class CursoWS {

    CursoBO cursoBO = new CursoBO();
    
    @WebMethod(operationName = "insertarCurso")
    public Integer insertarCurso(@WebParam(name = "curso") Curso curso) {
        Integer resultado = 0;
        try {
            resultado = cursoBO.insertar(curso);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    
    @WebMethod(operationName = "modificarCurso")
    public Integer modificarCurso(@WebParam(name = "curso") Curso curso) {
        Integer resultado = 0;
        try {
            resultado = cursoBO.modificar(curso);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    
    @WebMethod(operationName = "eliminarCurso")
    public Integer eliminarCurso(@WebParam(name = "curso") Curso curso) {
        Integer resultado = 0;
        try {
            resultado = cursoBO.eliminar(curso);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    
    @WebMethod(operationName = "listarTodosCursos")
    public ArrayList<Curso> listarTodosCursos() {
        ArrayList<Curso> cursos = null;
        try {
            cursos = cursoBO.listarTodos();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return cursos;
    }
    
    @WebMethod(operationName = "obtenerCursoPorId")
    public Curso obtenerCursoPorId(@WebParam(name = "idCurso") Integer idCurso) {
        Curso curso = null;
        try {
            curso = cursoBO.obtenerPorId(idCurso);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return curso;
    }
    
}
