package pe.edu.pucp.pixelpenguins.services;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import java.util.ArrayList;
import pe.edu.pucp.pixelpenguins.anioacademico.bo.MatriculaBO;
import pe.edu.pucp.pixelpenguins.anioacademico.model.Matricula;
import pe.edu.pucp.pixelpenguins.curricula.model.GradoAcademico;

@WebService(serviceName = "MatriculaWS", targetNamespace
        = "http://services.pixelpenguins.pucp.edu.pe")
public class MatriculaWS {

    MatriculaBO matriculaBO = new MatriculaBO();
    
    @WebMethod(operationName = "insertarMatricula")
    public Integer insertarMatricula(@WebParam(name = "matricula") Matricula matricula) {
        Integer resultado = 0;
        try {
            resultado = matriculaBO.insertar(matricula);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    
    @WebMethod(operationName = "modificarMatricula")
    public Integer modificarMatricula(@WebParam(name = "matricula") Matricula matricula) {
        Integer resultado = 0;
        try {
            resultado = matriculaBO.modificar(matricula);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    
    @WebMethod(operationName = "eliminarMatricula")
    public Integer eliminarMatricula(@WebParam(name = "matricula") Matricula matricula) {
        Integer resultado = 0;
        try {
            resultado = matriculaBO.eliminar(matricula);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    
    @WebMethod(operationName = "listarTodosMatriculas")
    public ArrayList<Matricula> listarTodosMatriculas() {
        ArrayList<Matricula> matriculas = null;
        try {
            matriculas = matriculaBO.listarTodos();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return matriculas;
    }
    
    @WebMethod(operationName = "obtenerMatriculaPorId")
    public Matricula obtenerMatriculaPorId(@WebParam(name = "idMatricula") Integer idMatricula) {
        Matricula matricula = null;
        try {
            matricula = matriculaBO.obtenerPorId(idMatricula);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return matricula;
    }
    
    @WebMethod(operationName = "obtenerMatriculaPorIdAlumno")
    public Integer obtenerMatriculaPorIdAlumno(@WebParam(name = "idAlumno") Integer idALumno){
        int id = 0;
        try {
            id = matriculaBO.obtenerPorIdAlumno(idALumno);
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        return id;
    }
    
    @WebMethod(operationName = "listarMatriculasPorGradoAcademico")
    public ArrayList<Matricula>listarMatriculasPorGradoAcademico(GradoAcademico gradoAcademico){
        ArrayList<Matricula> matriculas = null;
        try {
            matriculas = matriculaBO.listarTodos();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return matriculas;
    }
}
