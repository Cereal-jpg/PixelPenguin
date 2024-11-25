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
import pe.edu.pucp.pixelpenguins.anioacademico.model.AnioAcademico;
import pe.edu.pucp.pixelpenguins.rmi.interfaces.AnioAcademicoBO;
import pe.edu.pucp.pixelpenguins.rmi.servidor.SoftPixelPenguinsRMI_Servidor;

@WebService(serviceName = "AnioAcademicoWS", targetNamespace
        = "http://services.pixelpenguins.pucp.edu.pe")
public class AnioAcademicoWS {

    private String IP = "localhost";
    private Integer puerto = 1234;
    AnioAcademicoBO anioAcademicoBO;
    
    public AnioAcademicoWS() {
        try {
            String nombreServicio = SoftPixelPenguinsRMI_Servidor.retornarNombreDelServicio("anioAcademicoBO");
            this.anioAcademicoBO = (AnioAcademicoBO) Naming.lookup(nombreServicio);

        } catch (NotBoundException | MalformedURLException | RemoteException ex) {
            Logger.getLogger(AnioAcademicoWS.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @WebMethod(operationName = "insertarAnioAcademico")
    public Integer insertarAnioAcademico(@WebParam(name = "anioAcademico") AnioAcademico anioAcademico) {
        Integer resultado = 0;
        try {
            resultado = anioAcademicoBO.insertar(anioAcademico);
        } catch (RemoteException ex) {
            System.out.println(ex.getMessage());
        }
        return resultado;
    }

    @WebMethod(operationName = "modificarAnioAcademico")
    public Integer modificarAnioAcademico(@WebParam(name = "anioAcademico") AnioAcademico anioAcademico) {
        Integer resultado = 0;
        try {
            resultado = anioAcademicoBO.modificar(anioAcademico);
        } catch (RemoteException ex) {
            System.out.println(ex.getMessage());
        }
        return resultado;
    }

    @WebMethod(operationName = "eliminarAnioAcademico")
    public Integer eliminarAnioAcademico(@WebParam(name = "anioAcademico") AnioAcademico anioAcademico) {
        Integer resultado = 0;
        try {
            resultado = anioAcademicoBO.eliminar(anioAcademico);
        } catch (RemoteException ex) {
            System.out.println(ex.getMessage());
        }
        return resultado;
    }

    @WebMethod(operationName = "listarTodosAniosAcademicos")
    public ArrayList<AnioAcademico> listarTodosAniosAcademicos() {
        ArrayList<AnioAcademico> aniosAcademicos = null;
        try {
            aniosAcademicos = anioAcademicoBO.listarTodos();
        } catch (RemoteException ex) {
            System.out.println(ex.getMessage());
        }
        return aniosAcademicos;
    }

    @WebMethod(operationName = "obtenerAnioAcademicoPorId")
    public AnioAcademico obtenerAnioAcademicoPorId(@WebParam(name = "idAnioAcademico") Integer idAnioAcademico) {
        AnioAcademico anioAcademico = null;
        try {
            anioAcademico = anioAcademicoBO.obtenerPorId(idAnioAcademico);
        } catch (RemoteException ex) {
            System.out.println(ex.getMessage());
        }
        return anioAcademico;
    }

}
