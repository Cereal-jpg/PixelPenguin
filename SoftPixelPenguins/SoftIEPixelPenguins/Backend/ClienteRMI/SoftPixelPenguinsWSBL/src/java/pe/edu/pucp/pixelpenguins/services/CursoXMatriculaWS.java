
package pe.edu.pucp.pixelpenguins.services;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import java.io.File;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import pe.edu.pucp.pixelpenguins.anioacademico.model.CursoXMatricula;
import pe.edu.pucp.pixelpenguins.config.DBManager;
import pe.edu.pucp.pixelpenguins.rmi.interfaces.CursoXMatriculaBO;
import pe.edu.pucp.pixelpenguins.rmi.servidor.SoftPixelPenguinsRMI_Servidor;

@WebService(serviceName = "CursoXMatriculaWS", targetNamespace
        = "http://services.pixelpenguins.pucp.edu.pe")
public class CursoXMatriculaWS {
    
    private String IP;
    private Integer puerto;
    CursoXMatriculaBO cursoXMatriculaBO;
    
    public CursoXMatriculaWS() {
        SoftPixelPenguinsRMI_Servidor.cargarConfiguracionServidorRMI();
        try {
            String nombreServicio = SoftPixelPenguinsRMI_Servidor.retornarNombreDelServicio("cursoXMatriculaBO");
            this.cursoXMatriculaBO = (CursoXMatriculaBO) Naming.lookup(nombreServicio);

        } catch (NotBoundException | MalformedURLException | RemoteException ex) {
            Logger.getLogger(CursoXMatriculaWS.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @WebMethod(operationName = "insertarCursoXMatricula")
    public Integer insertarCursoXMatricula(@WebParam(name = "CursoXMatricula") CursoXMatricula cursoXMatricula) {
        Integer resultado = 0;
        try {
            resultado = cursoXMatriculaBO.insertar(cursoXMatricula);
        } catch (RemoteException ex) {
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    
    @WebMethod(operationName = "modificarCursoXMatricula")
    public Integer modificarCursoXMatricula(@WebParam(name = "CursoXMatricula") CursoXMatricula cursoXMatricula) {
        Integer resultado = 0;
        try {
            resultado = cursoXMatriculaBO.modificar(cursoXMatricula);
        } catch (RemoteException ex) {
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    
    @WebMethod(operationName = "eliminarCursoXMatricula")
    public Integer eliminarCursoXMatricula(@WebParam(name = "CursoXMatricula") CursoXMatricula cursoXMatricula) {
        Integer resultado = 0;
        try {
            resultado = cursoXMatriculaBO.eliminar(cursoXMatricula);
        } catch (RemoteException ex) {
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    
    @WebMethod(operationName = "listarTodosCursoXMatricula")
    public ArrayList<CursoXMatricula> listarTodosCursoXMatricula() {
        ArrayList<CursoXMatricula> notas = null;
        try {
            notas = cursoXMatriculaBO.listarTodos();
        } catch (RemoteException ex) {
            System.out.println(ex.getMessage());
        }
        return notas;
    }
    
    @WebMethod(operationName = "obtenerPorCursoYMatricula")
    public CursoXMatricula obtenerPorCursoYMatricula(@WebParam(name = "idCurso") Integer idCurso,
            @WebParam(name = "idMatricula") Integer idMatricula) {
        CursoXMatricula cursoXMatricula = null;
        try {
            cursoXMatricula=cursoXMatriculaBO.obtenerPorCursoYMatricula(idCurso, idMatricula);
        } catch (RemoteException ex) {
            System.out.println(ex.getMessage());
        }
        return cursoXMatricula;
    }
    
    @WebMethod(operationName = "listarNotasFinalesCursosXMatricula")
    public ArrayList<CursoXMatricula> listarNotasFinalesCursosXMatricula(@WebParam(name = "idMatricula") Integer idMatricula) {
        ArrayList<CursoXMatricula> notas = null;
        try {
            notas = cursoXMatriculaBO.listarNotasFinalesCursosXMatricula(idMatricula);
        } catch (RemoteException ex) {
            System.out.println(ex.getMessage());
        }
        return notas;
    }
    
    @WebMethod(operationName = "listarNotasFinalesCursosXAlumno")
    public ArrayList<CursoXMatricula> listarNotasFinalesCursosXAlumno(@WebParam(name = "idAlumno") Integer idAlumno) {
        ArrayList<CursoXMatricula> notas = null;
        try {
            notas = cursoXMatriculaBO.listarNotasFinalesCursosXAlumno(idAlumno);
        } catch (RemoteException ex) {
            System.out.println(ex.getMessage());
        }
        return notas;
    }
    
    @WebMethod(operationName = "listarNotasFinalesXCurso")
    public ArrayList<CursoXMatricula> listarNotasFinalesXCurso(@WebParam(name = "idCurso") Integer idCurso) {
        ArrayList<CursoXMatricula> notas = null;
        try {
            notas = cursoXMatriculaBO.listarNotasFinalesXCurso(idCurso);
        } catch (RemoteException ex) {
            System.out.println(ex.getMessage());
        }
        return notas;
    }
    
}
