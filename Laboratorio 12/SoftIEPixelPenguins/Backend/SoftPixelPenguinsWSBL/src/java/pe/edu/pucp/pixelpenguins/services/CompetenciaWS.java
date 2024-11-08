package pe.edu.pucp.pixelpenguins.services;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import java.util.ArrayList;
import pe.edu.pucp.pixelpenguins.curricula.bo.CompetenciaBO;
import pe.edu.pucp.pixelpenguins.curricula.model.Competencia;

@WebService(serviceName = "CompetenciaWS", targetNamespace
        = "http://services.pixelpenguins.pucp.edu.pe")
public class CompetenciaWS {

    CompetenciaBO competenciaBO = new CompetenciaBO();
    
    @WebMethod(operationName = "insertarCompetencia")
    public Integer insertarCompetencia(@WebParam(name = "competencia") Competencia competencia) {
        Integer resultado = 0;
        try {
            resultado = competenciaBO.insertar(competencia);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    
    @WebMethod(operationName = "modificarCompetencia")
    public Integer modificarCompetencia(@WebParam(name = "competencia") Competencia competencia) {
        Integer resultado = 0;
        try {
            resultado = competenciaBO.modificar(competencia);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    
    @WebMethod(operationName = "eliminarCompetencia")
    public Integer eliminarCompetencia(@WebParam(name = "competencia") Competencia competencia) {
        Integer resultado = 0;
        try {
            resultado = competenciaBO.eliminar(competencia);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    
    @WebMethod(operationName = "listarTodosCompetencias")
    public ArrayList<Competencia> listarTodosCompetencias() {
        ArrayList<Competencia> competencias = null;
        try {
            competencias = competenciaBO.listarTodos();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return competencias;
    }
    
    @WebMethod(operationName = "obtenerCompetenciaPorId")
    public Competencia obtenerCompetenciaPorId(@WebParam(name = "idCompetencia") Integer idCompetencia) {
        Competencia competencia = null;
        try {
            competencia = competenciaBO.obtenerPorId(idCompetencia);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return competencia;
    }
    
    @WebMethod(operationName = "listarCompetenciasPorCurso")
    public ArrayList<Competencia> listarCompetenciasPorCurso(@WebParam(name = "idCurso") Integer idCurso) {
        ArrayList<Competencia> competencias = null;
        try {
            competencias = competenciaBO.listarCompetenciasPorCurso(idCurso);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return competencias;
    }
}
