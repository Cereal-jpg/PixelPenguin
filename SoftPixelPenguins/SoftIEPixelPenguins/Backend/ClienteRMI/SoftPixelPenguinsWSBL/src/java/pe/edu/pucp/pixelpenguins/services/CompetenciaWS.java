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
import pe.edu.pucp.pixelpenguins.curricula.model.Competencia;
import pe.edu.pucp.pixelpenguins.rmi.interfaces.CompetenciaBO;
import pe.edu.pucp.pixelpenguins.rmi.servidor.SoftPixelPenguinsRMI_Servidor;

@WebService(serviceName = "CompetenciaWS", targetNamespace
        = "http://services.pixelpenguins.pucp.edu.pe")
public class CompetenciaWS {

    private String IP = "localhost";
    private Integer puerto = 1234;
    CompetenciaBO competenciaBO;
    
    public CompetenciaWS() {
        try {
            String nombreServicio = SoftPixelPenguinsRMI_Servidor.retornarNombreDelServicio("competenciaBO");
            this.competenciaBO = (CompetenciaBO) Naming.lookup(nombreServicio);

        } catch (NotBoundException | MalformedURLException | RemoteException ex) {
            Logger.getLogger(CompetenciaWS.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @WebMethod(operationName = "insertarCompetencia")
    public Integer insertarCompetencia(@WebParam(name = "competencia") Competencia competencia) {
        Integer resultado = 0;
        try {
            resultado = competenciaBO.insertar(competencia);
        } catch (RemoteException ex) {
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    
    @WebMethod(operationName = "modificarCompetencia")
    public Integer modificarCompetencia(@WebParam(name = "competencia") Competencia competencia) {
        Integer resultado = 0;
        try {
            resultado = competenciaBO.modificar(competencia);
        } catch (RemoteException ex) {
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    
    @WebMethod(operationName = "eliminarCompetencia")
    public Integer eliminarCompetencia(@WebParam(name = "competencia") Competencia competencia) {
        Integer resultado = 0;
        try {
            resultado = competenciaBO.eliminar(competencia);
        } catch (RemoteException ex) {
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    
    @WebMethod(operationName = "listarTodosCompetencias")
    public ArrayList<Competencia> listarTodosCompetencias() {
        ArrayList<Competencia> competencias = null;
        try {
            competencias = competenciaBO.listarTodos();
        } catch (RemoteException ex) {
            System.out.println(ex.getMessage());
        }
        return competencias;
    }
    
    @WebMethod(operationName = "obtenerCompetenciaPorId")
    public Competencia obtenerCompetenciaPorId(@WebParam(name = "idCompetencia") Integer idCompetencia) {
        Competencia competencia = null;
        try {
            competencia = competenciaBO.obtenerPorId(idCompetencia);
        } catch (RemoteException ex) {
            System.out.println(ex.getMessage());
        }
        return competencia;
    }
    
    @WebMethod(operationName = "listarCompetenciasPorCurso")
    public ArrayList<Competencia> listarCompetenciasPorCurso(@WebParam(name = "idCurso") Integer idCurso) {
        ArrayList<Competencia> competencias = null;
        try {
            competencias = competenciaBO.listarCompetenciasPorCurso(idCurso);
        } catch (RemoteException ex) {
            System.out.println(ex.getMessage());
        }
        return competencias;
    }
}
