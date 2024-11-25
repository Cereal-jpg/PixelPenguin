package pe.edu.pucp.pixelpenguins.services;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import pe.edu.pucp.pixelpenguins.rmi.interfaces.ApoderadoBO;
import pe.edu.pucp.pixelpenguins.rmi.servidor.SoftPixelPenguinsRMI_Servidor;
import pe.edu.pucp.pixelpenguins.usuario.model.Apoderado;

@WebService(serviceName = "ApoderadoWS", targetNamespace
        = "http://services.pixelpenguins.pucp.edu.pe")
public class ApoderadoWS {

    private String IP = "localhost";
    private Integer puerto = 1234;
    private ApoderadoBO apoderadoBO;
    
    public ApoderadoWS() {
        try {
            String nombreServicio = SoftPixelPenguinsRMI_Servidor.retornarNombreDelServicio("apoderadoBO");
            this.apoderadoBO = (ApoderadoBO) Naming.lookup(nombreServicio);

        } catch (NotBoundException | MalformedURLException | RemoteException ex) {
            Logger.getLogger(ApoderadoWS.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @WebMethod(operationName = "insertarApoderado")
    public Integer insertarApoderado(@WebParam(name = "apoderado") Apoderado apoderado) {
        Integer resultado = 0;
        try {
            resultado = apoderadoBO.insertar(apoderado);
        } catch (RemoteException ex) {
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    
    @WebMethod(operationName = "modificarApoderado")
    public Integer modificarApoderado(@WebParam(name = "apoderado") Apoderado apoderado) {
        Integer resultado = 0;
        try {
            resultado = apoderadoBO.modificar(apoderado);
        } catch (RemoteException ex) {
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    
    @WebMethod(operationName = "eliminarApoderado")
    public Integer eliminarApoderado(@WebParam(name = "apoderado") Apoderado apoderado) {
        Integer resultado = 0;
        try {
            resultado = apoderadoBO.eliminar(apoderado);
        } catch (RemoteException ex) {
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    
    @WebMethod(operationName = "listarTodosApoderados")
    public ArrayList<Apoderado> listarTodosApoderados() {
        ArrayList<Apoderado> apoderados = null;
        try {
            apoderados = apoderadoBO.listarTodos();
        } catch (RemoteException ex) {
            System.out.println(ex.getMessage());
        }
        return apoderados;
    }
    
    @WebMethod(operationName = "obtenerApoderadoPorId")
    public Apoderado obtenerApoderadoPorId(@WebParam(name = "idApoderado") Integer idApoderado) {
        Apoderado apoderado = null;
        try {
            apoderado = apoderadoBO.obtenerPorId(idApoderado);
        } catch (RemoteException ex) {
            System.out.println(ex.getMessage());
        }
        return apoderado;
    }
    
}