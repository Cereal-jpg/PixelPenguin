
package pe.edu.pucp.pixelpenguins.services;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import java.util.ArrayList;
import pe.edu.pucp.pixelpenguins.anioacademico.bo.CursoXMatriculaBO;
import pe.edu.pucp.pixelpenguins.anioacademico.model.CursoXMatricula;

@WebService(serviceName = "CursoXMatriculaWS", targetNamespace
        = "http://services.pixelpenguins.pucp.edu.pe")
public class CursoXMatriculaWS {
    CursoXMatriculaBO cursoXMatriculaBO = new CursoXMatriculaBO();
    
    @WebMethod(operationName = "insertarCursoXMatricula")
    public Integer insertarCursoXMatricula(@WebParam(name = "CursoXMatricula") CursoXMatricula cursoXMatricula) {
        Integer resultado = 0;
        try {
            resultado = cursoXMatriculaBO.insertar(cursoXMatricula);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    
    @WebMethod(operationName = "modificarCursoXMatricula")
    public Integer modificarCursoXMatricula(@WebParam(name = "CursoXMatricula") CursoXMatricula cursoXMatricula) {
        Integer resultado = 0;
        try {
            resultado = cursoXMatriculaBO.modificar(cursoXMatricula);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    
    @WebMethod(operationName = "eliminarCursoXMatricula")
    public Integer eliminarCursoXMatricula(@WebParam(name = "CursoXMatricula") CursoXMatricula cursoXMatricula) {
        Integer resultado = 0;
        try {
            resultado = cursoXMatriculaBO.eliminar(cursoXMatricula);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    
    @WebMethod(operationName = "listarTodosCursoXMatricula")
    public ArrayList<CursoXMatricula> listarTodosCursoXMatricula() {
        ArrayList<CursoXMatricula> notas = null;
        try {
            notas = cursoXMatriculaBO.listarTodos();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return notas;
    }
    
    @WebMethod(operationName = "obtenerPorCursoYMatricula")
    public CursoXMatricula obtenerPorCursoYMatricula(@WebParam(name = "idCurso") Integer idCurso,
            @WebParam(name = "idMatricula") Integer idMatricula) {
        CursoXMatricula cursoXMatricula = null;
        try {
            cursoXMatricula=cursoXMatriculaBO.obtenerPorCursoYMatricula(idCurso, idMatricula);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return cursoXMatricula;
    }
    
    @WebMethod(operationName = "listarNotasFinalesCursosXMatricula")
    public ArrayList<CursoXMatricula> listarNotasFinalesCursosXMatricula(@WebParam(name = "idMatricula") Integer idMatricula) {
        ArrayList<CursoXMatricula> notas = null;
        try {
            notas = cursoXMatriculaBO.listarNotasFinalesCursosXMatricula(idMatricula);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return notas;
    }
    
    @WebMethod(operationName = "listarNotasFinalesCursosXAlumno")
    public ArrayList<CursoXMatricula> listarNotasFinalesCursosXAlumno(@WebParam(name = "idAlumno") Integer idAlumno) {
        ArrayList<CursoXMatricula> notas = null;
        try {
            notas = cursoXMatriculaBO.listarNotasFinalesCursosXAlumno(idAlumno);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return notas;
    }
    
    @WebMethod(operationName = "listarNotasFinalesXCurso")
    public ArrayList<CursoXMatricula> listarNotasFinalesXCurso(@WebParam(name = "idCurso") Integer idCurso) {
        ArrayList<CursoXMatricula> notas = null;
        try {
            notas = cursoXMatriculaBO.listarNotasFinalesXCurso(idCurso);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return notas;
    }
}
