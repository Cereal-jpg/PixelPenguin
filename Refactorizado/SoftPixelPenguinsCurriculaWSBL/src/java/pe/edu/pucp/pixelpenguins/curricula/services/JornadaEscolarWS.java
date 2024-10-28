package pe.edu.pucp.pixelpenguins.curricula.services;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import java.util.ArrayList;
import pe.edu.pucp.pixelpenguins.curricula.bo.JornadaEscolarBO;
import pe.edu.pucp.pixelpenguins.curricula.model.JornadaEscolar;

@WebService(serviceName = "JornadaEscolarWS", targetNamespace
        = "http://services.curricula.pixelpenguins.pucp.edu.pe")
public class JornadaEscolarWS {

    JornadaEscolarBO jornadaEscolarBO = new JornadaEscolarBO();
    
    @WebMethod(operationName = "insertarJornadaEscolar")
    public Integer insertarJornadaEscolar(@WebParam(name = "jornadaEscolar") JornadaEscolar jornadaEscolar) {
        Integer resultado = 0;
        try {
            resultado = jornadaEscolarBO.insertar(jornadaEscolar);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    
    @WebMethod(operationName = "modificarJornadaEscolar")
    public Integer modificarJornadaEscolar(@WebParam(name = "jornadaEscolar") JornadaEscolar jornadaEscolar) {
        Integer resultado = 0;
        try {
            resultado = jornadaEscolarBO.modificar(jornadaEscolar);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    
    @WebMethod(operationName = "eliminarJornadaEscolar")
    public Integer eliminarJornadaEscolar(@WebParam(name = "jornadaEscolar") JornadaEscolar jornadaEscolar) {
        Integer resultado = 0;
        try {
            resultado = jornadaEscolarBO.eliminar(jornadaEscolar);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    
    @WebMethod(operationName = "listarTodosJornadasEscolares")
    public ArrayList<JornadaEscolar> listarTodosJornadasEscolares() {
        ArrayList<JornadaEscolar> jornadasEscolares = null;
        try {
            jornadasEscolares = jornadaEscolarBO.listarTodos();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return jornadasEscolares;
    }
    
    @WebMethod(operationName = "obtenerJornadaEscolarPorId")
    public JornadaEscolar obtenerJornadaEscolarPorId(@WebParam(name = "idJornadaEscolar") Integer idJornadaEscolar) {
        JornadaEscolar jornadaEscolar = null;
        try {
            jornadaEscolar = jornadaEscolarBO.obtenerPorId(idJornadaEscolar);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return jornadaEscolar;
    }
    
}
