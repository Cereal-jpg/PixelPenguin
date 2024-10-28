package pe.edu.pucp.pixelpenguins.institucioneducativa.services;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import java.util.ArrayList;
import pe.edu.pucp.pixelpenguins.institucioneducativa.bo.InstitucionEducativaBO;
import pe.edu.pucp.pixelpenguins.institucioneducativa.model.InstitucionEducativa;

@WebService(serviceName = "InstitucionEducativaWS")
public class InstitucionEducativaWS {

    InstitucionEducativaBO institucionEducativaBO = new InstitucionEducativaBO();
    
    @WebMethod(operationName = "insertarInstitucionEducativa")
    public Integer insertarInstitucionEducativa(@WebParam(name = "institucionEducativa") InstitucionEducativa institucionEducativa) {
        Integer resultado = 0;
        try {
            resultado = institucionEducativaBO.insertar(institucionEducativa);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    
    @WebMethod(operationName = "modificarInstitucionEducativa")
    public Integer modificarInstitucionEducativa(@WebParam(name = "institucionEducativa") InstitucionEducativa institucionEducativa) {
        Integer resultado = 0;
        try {
            resultado = institucionEducativaBO.modificar(institucionEducativa);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    
    @WebMethod(operationName = "eliminarInstitucionEducativa")
    public Integer eliminarInstitucionEducativa(@WebParam(name = "institucionEducativa") InstitucionEducativa institucionEducativa) {
        Integer resultado = 0;
        try {
            resultado = institucionEducativaBO.eliminar(institucionEducativa);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    
    @WebMethod(operationName = "listarTodosInstitucionesEducativas")
    public ArrayList<InstitucionEducativa> listarTodosInstitucionesEducativas() {
        ArrayList<InstitucionEducativa> institucionesEducativas = null;
        try {
            institucionesEducativas = institucionEducativaBO.listarTodos();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return institucionesEducativas;
    }
    
    @WebMethod(operationName = "obtenerInstitucionEducativaPorId")
    public InstitucionEducativa obtenerInstitucionEducativaPorId(@WebParam(name = "idInstitucionEducativa") Integer idInstitucionEducativa) {
        InstitucionEducativa institucionEducativa = null;
        try {
            institucionEducativa = institucionEducativaBO.obtenerPorId(idInstitucionEducativa);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return institucionEducativa;
    }
    
}
