package pe.edu.pucp.pixelpenguins.services;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import java.util.ArrayList;
import pe.edu.pucp.pixelpenguins.curricula.bo.SeccionAcademicaBO;
import pe.edu.pucp.pixelpenguins.curricula.model.GradoAcademico;
import pe.edu.pucp.pixelpenguins.curricula.model.SeccionAcademica;

@WebService(serviceName = "SeccionAcademicaWS", targetNamespace
        = "http://services.pixelpenguins.pucp.edu.pe")
public class SeccionAcademicaWS {

    SeccionAcademicaBO seccionAcademicaBO = new SeccionAcademicaBO();
    
    @WebMethod(operationName = "insertarSeccionAcademica")
    public Integer insertarSeccionAcademica(@WebParam(name = "seccionAcademica") SeccionAcademica seccionAcademica) {
        Integer resultado = 0;
        try {
            resultado = seccionAcademicaBO.insertar(seccionAcademica);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    
    @WebMethod(operationName = "modificarSeccionAcademica")
    public Integer modificarSeccionAcademica(@WebParam(name = "seccionAcademica") SeccionAcademica seccionAcademica) {
        Integer resultado = 0;
        try {
            resultado = seccionAcademicaBO.modificar(seccionAcademica);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    
    @WebMethod(operationName = "eliminarSeccionAcademica")
    public Integer eliminarSeccionAcademica(@WebParam(name = "seccionAcademica") SeccionAcademica seccionAcademica) {
        Integer resultado = 0;
        try {
            resultado = seccionAcademicaBO.eliminar(seccionAcademica);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    
    @WebMethod(operationName = "listarTodosSeccionesAcademicas")
    public ArrayList<SeccionAcademica> listarTodosSeccionesAcademicas() {
        ArrayList<SeccionAcademica> seccionesAcademicas = null;
        try {
            seccionesAcademicas = seccionAcademicaBO.listarTodos();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return seccionesAcademicas;
    }
    
    @WebMethod(operationName = "obtenerSeccionAcademicaPorId")
    public SeccionAcademica obtenerSeccionAcademicaPorId(@WebParam(name = "idSeccionAcademica") Integer idSeccionAcademica) {
        SeccionAcademica seccionAcademica = null;
        try {
            seccionAcademica = seccionAcademicaBO.obtenerPorId(idSeccionAcademica);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return seccionAcademica;
    }
    
    @WebMethod(operationName = "listarSeccionesPorGrado")
    public ArrayList<SeccionAcademica> listarSeccionesPorGrado(@WebParam(name = "gradoAcademico") GradoAcademico gradoAcademico) {
        ArrayList<SeccionAcademica> seccionesAcademicas = null;
        try {
            seccionesAcademicas = seccionAcademicaBO.listarSeccionesPorGrado(gradoAcademico);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return seccionesAcademicas;
    }
    
}
