package pe.edu.pucp.pixelpenguins.services;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import pe.edu.pucp.pixelpenguins.anioacademico.model.Pago;
import pe.edu.pucp.pixelpenguins.rmi.interfaces.PagoBO;
import pe.edu.pucp.pixelpenguins.rmi.servidor.SoftPixelPenguinsRMI_Servidor;

@WebService(serviceName = "PagoWS", targetNamespace
        = "http://services.pixelpenguins.pucp.edu.pe")
public class PagoWS {

    private String IP = "localhost";
    private Integer puerto = 1234;
    PagoBO pagoBO;
    
    public PagoWS() {
        try {
            String nombreServicio = SoftPixelPenguinsRMI_Servidor.retornarNombreDelServicio("pagoBO");
            this.pagoBO = (PagoBO) Naming.lookup(nombreServicio);

        } catch (NotBoundException | MalformedURLException | RemoteException ex) {
            Logger.getLogger(PagoWS.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @WebMethod(operationName = "insertarPago")
    public Integer insertarPago(@WebParam(name = "pago") Pago pago) {
        Integer resultado = 0;
        try {
            resultado = pagoBO.insertar(pago);
        } catch (RemoteException ex) {
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    
    @WebMethod(operationName = "modificarPago")
    public Integer modificarPago(@WebParam(name = "pago") Pago pago) {
        Integer resultado = 0;
        try {
            resultado = pagoBO.modificar(pago);
        } catch (RemoteException ex) {
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    
    @WebMethod(operationName = "eliminarPago")
    public Integer eliminarPago(@WebParam(name = "pago") Pago pago) {
        Integer resultado = 0;
        try {
            resultado = pagoBO.eliminar(pago);
        } catch (RemoteException ex) {
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    
    @WebMethod(operationName = "listarTodosPagos")
    public ArrayList<Pago> listarTodosPagos() {
        ArrayList<Pago> pagos = null;
        try {
            pagos = pagoBO.listarTodos();
        } catch (RemoteException ex) {
            System.out.println(ex.getMessage());
        }
        return pagos;
    }
    
    @WebMethod(operationName = "obtenerPagoPorId")
    public Pago obtenerPagoPorId(@WebParam(name = "idPago") Integer idPago) {
        Pago pago = null;
        try {
            pago = pagoBO.obtenerPorId(idPago);
        } catch (RemoteException ex) {
            System.out.println(ex.getMessage());
        }
        return pago;
    }
    
    @WebMethod(operationName = "PagoXIdMatricula")
    public ArrayList<Pago>PagoXAlumnos(@WebParam(name = "fid_Matricula") int idMatricula){
        ArrayList<Pago> pagos = null;
        try{
            pagos = pagoBO.PagoXAlumnos(idMatricula);
        }
        catch (RemoteException ex){
            System.err.println(ex.getMessage());
        }
        return pagos;
    }
    
    @WebMethod(operationName = "listarPagosXIdMatricula")
    public ArrayList<Pago>  listarTodosPorIdMatricula(int idMatricula){
        ArrayList<Pago> pagos = null;
        try{
            pagos = pagoBO.listarTodosPorIdMatricula(idMatricula);
        }
        catch (RemoteException ex){
            System.err.println(ex.getMessage());
        }
        return pagos;
    }
    
    @WebMethod(operationName = "listarPagosPoridGrado")
     public ArrayList<Pago> listarTodosPorGrado(int idGrado){
         ArrayList<Pago> pagos = null;
         try{
             pagos = pagoBO.listarTodosPorGrado(idGrado);
         }
         catch (RemoteException ex){
             System.out.println(ex.getMessage());
         }
         return pagos;
     }
     
     @WebMethod(operationName = "listarPagosXFechaLimite")
     public ArrayList<Pago> listarPagosXFechaLimite(@WebParam(name = "desde") Date desde, @WebParam(name = "hasta") Date hasta){
         ArrayList<Pago> pagos = null;
         try{
             pagos = pagoBO.listarPagosXFechaLimite(desde,hasta);
         }
         catch (RemoteException ex){
             System.out.println(ex.getMessage());
         }
         return pagos;
     }
}
