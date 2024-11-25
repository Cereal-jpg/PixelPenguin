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
import pe.edu.pucp.pixelpenguins.anioacademico.model.Matricula;
import pe.edu.pucp.pixelpenguins.curricula.model.GradoAcademico;
import pe.edu.pucp.pixelpenguins.rmi.interfaces.MatriculaBO;
import pe.edu.pucp.pixelpenguins.rmi.servidor.SoftPixelPenguinsRMI_Servidor;

@WebService(serviceName = "MatriculaWS", targetNamespace
        = "http://services.pixelpenguins.pucp.edu.pe")
public class MatriculaWS {

    private String IP;
    private Integer puerto;
    MatriculaBO matriculaBO;
    
    public MatriculaWS() {
        SoftPixelPenguinsRMI_Servidor.cargarConfiguracionServidorRMI();
        try {
            String nombreServicio = SoftPixelPenguinsRMI_Servidor.retornarNombreDelServicio("matriculaBO");
            this.matriculaBO = (MatriculaBO) Naming.lookup(nombreServicio);

        } catch (NotBoundException | MalformedURLException | RemoteException ex) {
            Logger.getLogger(MatriculaWS.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @WebMethod(operationName = "insertarMatricula")
    public Integer insertarMatricula(@WebParam(name = "matricula") Matricula matricula) {
        Integer resultado = 0;
        try {
            resultado = matriculaBO.insertar(matricula);
        } catch (RemoteException ex) {
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    
    @WebMethod(operationName = "modificarMatricula")
    public Integer modificarMatricula(@WebParam(name = "matricula") Matricula matricula) {
        Integer resultado = 0;
        try {
            resultado = matriculaBO.modificar(matricula);
        } catch (RemoteException ex) {
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    
    @WebMethod(operationName = "eliminarMatricula")
    public Integer eliminarMatricula(@WebParam(name = "matricula") Matricula matricula) {
        Integer resultado = 0;
        try {
            resultado = matriculaBO.eliminar(matricula);
        } catch (RemoteException ex) {
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    
    @WebMethod(operationName = "listarTodosMatriculas")
    public ArrayList<Matricula> listarTodosMatriculas() {
        ArrayList<Matricula> matriculas = null;
        try {
            matriculas = matriculaBO.listarTodos();
        } catch (RemoteException ex) {
            System.out.println(ex.getMessage());
        }
        return matriculas;
    }
    
    @WebMethod(operationName = "obtenerMatriculaPorId")
    public Matricula obtenerMatriculaPorId(@WebParam(name = "idMatricula") Integer idMatricula) {
        Matricula matricula = null;
        try {
            matricula = matriculaBO.obtenerPorId(idMatricula);
        } catch (RemoteException ex) {
            System.out.println(ex.getMessage());
        }
        return matricula;
    }
    
    @WebMethod(operationName = "obtenerMatriculaPorIdAlumno")
    public Integer obtenerMatriculaPorIdAlumno(@WebParam(name = "idAlumno") Integer idALumno){
        int id = 0;
        try {
            id = matriculaBO.obtenerPorIdAlumno(idALumno);
        }
        catch (RemoteException ex){
            System.out.println(ex.getMessage());
        }
        return id;
    }
    
    @WebMethod(operationName = "listarMatriculasPorGradoAcademico")
    public ArrayList<Matricula>listarMatriculasPorGradoAcademico(GradoAcademico gradoAcademico){
        ArrayList<Matricula> matriculas = null;
        try {
            matriculas = matriculaBO.listarTodos();
        } catch (RemoteException ex) {
            System.out.println(ex.getMessage());
        }
        return matriculas;
    }
}
