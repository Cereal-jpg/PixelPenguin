package pe.edu.pucp.pixelpenguins.usuario.services;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import java.util.ArrayList;
import pe.edu.pucp.pixelpenguins.usuario.bo.ApoderadoBO;
import pe.edu.pucp.pixelpenguins.usuario.model.Apoderado;

@WebService(serviceName = "ApoderadoWS", targetNamespace
        = "http://services.usuario.pixelpenguins.pucp.edu.pe")
public class ApoderadoWS {

    private ApoderadoBO apoderadoBO = new ApoderadoBO();
    
    @WebMethod(operationName = "insertarApoderado")
    public Integer insertarApoderado(@WebParam(name = "apoderado") Apoderado apoderado) {
        Integer resultado = 0;
        try {
            resultado = apoderadoBO.insertar(apoderado);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    
    @WebMethod(operationName = "modificarApoderado")
    public Integer modificarApoderado(@WebParam(name = "apoderado") Apoderado apoderado) {
        Integer resultado = 0;
        try {
            resultado = apoderadoBO.modificar(apoderado);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    
    @WebMethod(operationName = "eliminarApoderado")
    public Integer eliminarApoderado(@WebParam(name = "apoderado") Apoderado apoderado) {
        Integer resultado = 0;
        try {
            resultado = apoderadoBO.eliminar(apoderado);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    
    @WebMethod(operationName = "listarTodosApoderados")
    public ArrayList<Apoderado> listarTodosApoderados() {
        ArrayList<Apoderado> apoderados = null;
        try {
            apoderados = apoderadoBO.listarTodos();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return apoderados;
    }
    
    @WebMethod(operationName = "obtenerApoderadoPorId")
    public Apoderado obtenerUsuarioPorId(@WebParam(name = "idApoderado") Integer idApoderado) {
        Apoderado apoderado = null;
        try {
            apoderado = apoderadoBO.obtenerPorId(idApoderado);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return apoderado;
    }
    
}
