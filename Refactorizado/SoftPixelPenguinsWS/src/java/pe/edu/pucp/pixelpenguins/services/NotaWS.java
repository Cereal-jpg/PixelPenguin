package pe.edu.pucp.pixelpenguins.services;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import java.util.ArrayList;
import pe.edu.pucp.pixelpenguins.curricula.bo.NotaBO;
import pe.edu.pucp.pixelpenguins.curricula.model.Nota;

@WebService(serviceName = "NotaWS", targetNamespace
        = "http://services.pixelpenguins.pucp.edu.pe")
public class NotaWS {

    NotaBO notaBO = new NotaBO();
    
    @WebMethod(operationName = "insertarNota")
    public Integer insertarNota(@WebParam(name = "nota") Nota nota) {
        Integer resultado = 0;
        try {
            resultado = notaBO.insertar(nota);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    
    @WebMethod(operationName = "modificarNota")
    public Integer modificarNota(@WebParam(name = "nota") Nota nota) {
        Integer resultado = 0;
        try {
            resultado = notaBO.modificar(nota);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    
    @WebMethod(operationName = "eliminarNota")
    public Integer eliminarNota(@WebParam(name = "nota") Nota nota) {
        Integer resultado = 0;
        try {
            resultado = notaBO.eliminar(nota);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    
    @WebMethod(operationName = "listarTodosNotas")
    public ArrayList<Nota> listarTodosNotas() {
        ArrayList<Nota> notas = null;
        try {
            notas = notaBO.listarTodos();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return notas;
    }
    
    @WebMethod(operationName = "obtenerNotaPorId")
    public Nota obtenerNotaPorId(@WebParam(name = "idNota") Integer idNota) {
        Nota nota = null;
        try {
            nota = notaBO.obtenerPorId(idNota);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return nota;
    }
    
}
