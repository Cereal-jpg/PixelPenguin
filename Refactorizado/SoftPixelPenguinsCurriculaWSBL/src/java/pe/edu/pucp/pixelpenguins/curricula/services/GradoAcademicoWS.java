package pe.edu.pucp.pixelpenguins.curricula.services;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import java.util.ArrayList;
import pe.edu.pucp.pixelpenguins.curricula.bo.GradoAcademicoBO;
import pe.edu.pucp.pixelpenguins.curricula.model.GradoAcademico;

@WebService(serviceName = "GradoAcademicoWS", targetNamespace
        = "http://services.curricula.pixelpenguins.pucp.edu.pe")
public class GradoAcademicoWS {

    GradoAcademicoBO gradoAcademicoBO = new GradoAcademicoBO();
    
    @WebMethod(operationName = "insertarGradoAcademico")
    public Integer insertarGradoAcademico(@WebParam(name = "gradoAcademico") GradoAcademico gradoAcademico) {
        Integer resultado = 0;
        try {
            resultado = gradoAcademicoBO.insertar(gradoAcademico);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    
    @WebMethod(operationName = "modificarGradoAcademico")
    public Integer modificarGradoAcademico(@WebParam(name = "gradoAcademico") GradoAcademico gradoAcademico) {
        Integer resultado = 0;
        try {
            resultado = gradoAcademicoBO.modificar(gradoAcademico);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    
    @WebMethod(operationName = "eliminarGradoAcademico")
    public Integer eliminarGradoAcademico(@WebParam(name = "gradoAcademico") GradoAcademico gradoAcademico) {
        Integer resultado = 0;
        try {
            resultado = gradoAcademicoBO.eliminar(gradoAcademico);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    
    @WebMethod(operationName = "listarTodosGradosAcademicos")
    public ArrayList<GradoAcademico> listarTodosGradosAcademicos() {
        ArrayList<GradoAcademico> gradosAcademicos = null;
        try {
            gradosAcademicos = gradoAcademicoBO.listarTodos();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return gradosAcademicos;
    }
    
    @WebMethod(operationName = "obtenerGradoAcademicoPorId")
    public GradoAcademico obtenerGradoAcademicoPorId(@WebParam(name = "idGradoAcademico") Integer idGradoAcademico) {
        GradoAcademico gradoAcademico = null;
        try {
            gradoAcademico = gradoAcademicoBO.obtenerPorId(idGradoAcademico);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return gradoAcademico;
    }
    
}
