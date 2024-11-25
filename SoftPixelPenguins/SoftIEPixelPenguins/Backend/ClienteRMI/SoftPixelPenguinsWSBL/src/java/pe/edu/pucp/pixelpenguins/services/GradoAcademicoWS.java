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
import pe.edu.pucp.pixelpenguins.curricula.model.GradoAcademico;
import pe.edu.pucp.pixelpenguins.rmi.interfaces.GradoAcademicoBO;
import pe.edu.pucp.pixelpenguins.rmi.servidor.SoftPixelPenguinsRMI_Servidor;

@WebService(serviceName = "GradoAcademicoWS", targetNamespace
        = "http://services.pixelpenguins.pucp.edu.pe")
public class GradoAcademicoWS {

    private String IP = "localhost";
    private Integer puerto = 1234;
    GradoAcademicoBO gradoAcademicoBO;
    
    public GradoAcademicoWS() {
        try {
            String nombreServicio = SoftPixelPenguinsRMI_Servidor.retornarNombreDelServicio("gradoAcademicoBO");
            this.gradoAcademicoBO = (GradoAcademicoBO) Naming.lookup(nombreServicio);

        } catch (NotBoundException | MalformedURLException | RemoteException ex) {
            Logger.getLogger(GradoAcademicoWS.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @WebMethod(operationName = "insertarGradoAcademico")
    public Integer insertarGradoAcademico(@WebParam(name = "gradoAcademico") GradoAcademico gradoAcademico) {
        Integer resultado = 0;
        try {
            resultado = gradoAcademicoBO.insertar(gradoAcademico);
        } catch (RemoteException ex) {
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    
    @WebMethod(operationName = "modificarGradoAcademico")
    public Integer modificarGradoAcademico(@WebParam(name = "gradoAcademico") GradoAcademico gradoAcademico) {
        Integer resultado = 0;
        try {
            resultado = gradoAcademicoBO.modificar(gradoAcademico);
        } catch (RemoteException ex) {
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    
    @WebMethod(operationName = "eliminarGradoAcademico")
    public Integer eliminarGradoAcademico(@WebParam(name = "gradoAcademico") GradoAcademico gradoAcademico) {
        Integer resultado = 0;
        try {
            resultado = gradoAcademicoBO.eliminar(gradoAcademico);
        } catch (RemoteException ex) {
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    
    @WebMethod(operationName = "listarTodosGradosAcademicos")
    public ArrayList<GradoAcademico> listarTodosGradosAcademicos() {
        ArrayList<GradoAcademico> gradosAcademicos = null;
        try {
            gradosAcademicos = gradoAcademicoBO.listarTodos();
        } catch (RemoteException ex) {
            System.out.println(ex.getMessage());
        }
        return gradosAcademicos;
    }
    
    @WebMethod(operationName = "obtenerGradoAcademicoPorId")
    public GradoAcademico obtenerGradoAcademicoPorId(@WebParam(name = "idGradoAcademico") Integer idGradoAcademico) {
        GradoAcademico gradoAcademico = null;
        try {
            gradoAcademico = gradoAcademicoBO.obtenerPorId(idGradoAcademico);
        } catch (RemoteException ex) {
            System.out.println(ex.getMessage());
        }
        return gradoAcademico;
    }
    
    
}
