package pe.edu.pucp.pixelpenguins.anioacademico.services;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import java.util.ArrayList;
import pe.edu.pucp.pixelpenguins.anioacademico.bo.PagoBO;
import pe.edu.pucp.pixelpenguins.anioacademico.model.Pago;

@WebService(serviceName = "PagoWS", targetNamespace
        = "http://services.anioacademico.pixelpenguins.pucp.edu.pe")
public class PagoWS {

    PagoBO pagoBO = new PagoBO();
    
    @WebMethod(operationName = "insertarPago")
    public Integer insertarPago(@WebParam(name = "pago") Pago pago) {
        Integer resultado = 0;
        try {
            resultado = pagoBO.insertar(pago);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    
    @WebMethod(operationName = "modificarPago")
    public Integer modificarPago(@WebParam(name = "pago") Pago pago) {
        Integer resultado = 0;
        try {
            resultado = pagoBO.modificar(pago);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    
    @WebMethod(operationName = "eliminarPago")
    public Integer eliminarPago(@WebParam(name = "pago") Pago pago) {
        Integer resultado = 0;
        try {
            resultado = pagoBO.eliminar(pago);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    
    @WebMethod(operationName = "listarTodosPagos")
    public ArrayList<Pago> listarTodosPagos() {
        ArrayList<Pago> pagos = null;
        try {
            pagos = pagoBO.listarTodos();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return pagos;
    }
    
    @WebMethod(operationName = "obtenerPagoPorId")
    public Pago obtenerPagoPorId(@WebParam(name = "idPago") Integer idPago) {
        Pago pago = null;
        try {
            pago = pagoBO.obtenerPorId(idPago);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return pago;
    }
    
}
