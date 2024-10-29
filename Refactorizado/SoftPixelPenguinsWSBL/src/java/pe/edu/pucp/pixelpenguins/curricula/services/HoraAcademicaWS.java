package pe.edu.pucp.pixelpenguins.curricula.services;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import java.util.ArrayList;
import pe.edu.pucp.pixelpenguins.curricula.bo.HoraAcademicaBO;
import pe.edu.pucp.pixelpenguins.curricula.model.HoraAcademica;

@WebService(serviceName = "HoraAcademicaWS", targetNamespace
        = "http://services.curricula.pixelpenguins.pucp.edu.pe")
public class HoraAcademicaWS {

    HoraAcademicaBO horaAcademicaBO = new HoraAcademicaBO();
    
    @WebMethod(operationName = "insertarHoraAcademica")
    public Integer insertarHoraAcademica(@WebParam(name = "horaAcademica") HoraAcademica horaAcademica) {
        Integer resultado = 0;
        try {
            resultado = horaAcademicaBO.insertar(horaAcademica);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    
    @WebMethod(operationName = "modificarHoraAcademica")
    public Integer modificarHoraAcademica(@WebParam(name = "horaAcademica") HoraAcademica horaAcademica) {
        Integer resultado = 0;
        try {
            resultado = horaAcademicaBO.modificar(horaAcademica);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    
    @WebMethod(operationName = "eliminarHoraAcademica")
    public Integer eliminarHoraAcademica(@WebParam(name = "horaAcademica") HoraAcademica horaAcademica) {
        Integer resultado = 0;
        try {
            resultado = horaAcademicaBO.eliminar(horaAcademica);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    
    @WebMethod(operationName = "listarTodosHorasAcademicas")
    public ArrayList<HoraAcademica> listarTodosHorasAcademicas() {
        ArrayList<HoraAcademica> horasAcademicas = null;
        try {
            horasAcademicas = horaAcademicaBO.listarTodos();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return horasAcademicas;
    }
    
    @WebMethod(operationName = "obtenerHoraAcademicaPorId")
    public HoraAcademica obtenerHoraAcademicaPorId(@WebParam(name = "idHoraAcademica") Integer idHoraAcademica) {
        HoraAcademica horaAcademica = null;
        try {
            horaAcademica = horaAcademicaBO.obtenerPorId(idHoraAcademica);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return horaAcademica;
    }
    
}
