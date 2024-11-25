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
import pe.edu.pucp.pixelpenguins.curricula.model.Curso;
import pe.edu.pucp.pixelpenguins.curricula.model.HoraAcademica;
import pe.edu.pucp.pixelpenguins.rmi.interfaces.HoraAcademicaBO;
import pe.edu.pucp.pixelpenguins.rmi.servidor.SoftPixelPenguinsRMI_Servidor;

@WebService(serviceName = "HoraAcademicaWS", targetNamespace
        = "http://services.pixelpenguins.pucp.edu.pe")
public class HoraAcademicaWS {

    private String IP;
    private Integer puerto;
    HoraAcademicaBO horaAcademicaBO;
    
    public HoraAcademicaWS() {
        SoftPixelPenguinsRMI_Servidor.cargarConfiguracionServidorRMI();
        try {
            String nombreServicio = SoftPixelPenguinsRMI_Servidor.retornarNombreDelServicio("horaAcademicaBO");
            this.horaAcademicaBO = (HoraAcademicaBO) Naming.lookup(nombreServicio);

        } catch (NotBoundException | MalformedURLException | RemoteException ex) {
            Logger.getLogger(HoraAcademicaWS.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @WebMethod(operationName = "insertarHoraAcademica")
    public Integer insertarHoraAcademica(@WebParam(name = "horaAcademica") HoraAcademica horaAcademica) {
        Integer resultado = 0;
        try {
            resultado = horaAcademicaBO.insertar(horaAcademica);
        } catch (RemoteException ex) {
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    
    @WebMethod(operationName = "modificarHoraAcademica")
    public Integer modificarHoraAcademica(@WebParam(name = "horaAcademica") HoraAcademica horaAcademica) {
        Integer resultado = 0;
        try {
            resultado = horaAcademicaBO.modificar(horaAcademica);
        } catch (RemoteException ex) {
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    
    @WebMethod(operationName = "eliminarHoraAcademica")
    public Integer eliminarHoraAcademica(@WebParam(name = "horaAcademica") HoraAcademica horaAcademica) {
        Integer resultado = 0;
        try {
            resultado = horaAcademicaBO.eliminar(horaAcademica);
        } catch (RemoteException ex) {
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    
    @WebMethod(operationName = "listarTodosHorasAcademicas")
    public ArrayList<HoraAcademica> listarTodosHorasAcademicas() {
        ArrayList<HoraAcademica> horasAcademicas = null;
        try {
            horasAcademicas = horaAcademicaBO.listarTodos();
        } catch (RemoteException ex) {
            System.out.println(ex.getMessage());
        }
        return horasAcademicas;
    }
    
    @WebMethod(operationName = "obtenerHoraAcademicaPorId")
    public HoraAcademica obtenerHoraAcademicaPorId(@WebParam(name = "idHoraAcademica") Integer idHoraAcademica) {
        HoraAcademica horaAcademica = null;
        try {
            horaAcademica = horaAcademicaBO.obtenerPorId(idHoraAcademica);
        } catch (RemoteException ex) {
            System.out.println(ex.getMessage());
        }
        return horaAcademica;
    }
    
    @WebMethod(operationName = "listarHorasAcademicasPorCurso")
    public ArrayList<HoraAcademica> listarHorasAcademicasPorCurso(@WebParam(name = "curso") Curso curso) {
        ArrayList<HoraAcademica> horasAcademicas = null;
        try {
            horasAcademicas = horaAcademicaBO.listarHorasAcademicasPorCurso(curso);
        } catch (RemoteException ex) {
            System.out.println(ex.getMessage());
        }
        return horasAcademicas;
    }
    
}
