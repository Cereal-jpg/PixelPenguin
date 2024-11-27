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
import pe.edu.pucp.pixelpenguins.curricula.model.Nota;
import pe.edu.pucp.pixelpenguins.rmi.interfaces.NotaBO;
import pe.edu.pucp.pixelpenguins.rmi.servidor.SoftPixelPenguinsRMI_Servidor;

@WebService(serviceName = "NotaWS", targetNamespace
        = "http://services.pixelpenguins.pucp.edu.pe")
public class NotaWS {

    private String IP;
    private Integer puerto;
    NotaBO notaBO;
    
    public NotaWS() {
        SoftPixelPenguinsRMI_Servidor.cargarConfiguracionServidorRMI();
        try {
            String nombreServicio = SoftPixelPenguinsRMI_Servidor.retornarNombreDelServicio("notaBO");
            this.notaBO = (NotaBO) Naming.lookup(nombreServicio);

        } catch (NotBoundException | MalformedURLException | RemoteException ex) {
            Logger.getLogger(NotaWS.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @WebMethod(operationName = "insertarNota")
    public Integer insertarNota(@WebParam(name = "nota") Nota nota) {
        Integer resultado = 0;
        try {
            resultado = notaBO.insertar(nota);
        } catch (RemoteException ex) {
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    
    @WebMethod(operationName = "modificarNota")
    public Integer modificarNota(@WebParam(name = "nota") Nota nota) {
        Integer resultado = 0;
        try {
            resultado = notaBO.modificar(nota);
        } catch (RemoteException ex) {
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    
    @WebMethod(operationName = "eliminarNota")
    public Integer eliminarNota(@WebParam(name = "nota") Nota nota) {
        Integer resultado = 0;
        try {
            resultado = notaBO.eliminar(nota);
        } catch (RemoteException ex) {
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    
    @WebMethod(operationName = "listarTodosNotas")
    public ArrayList<Nota> listarTodosNotas() {
        ArrayList<Nota> notas = null;
        try {
            notas = notaBO.listarTodos();
        } catch (RemoteException ex) {
            System.out.println(ex.getMessage());
        }
        return notas;
    }
    
    @WebMethod(operationName = "obtenerNotaPorId")
    public Nota obtenerNotaPorId(@WebParam(name = "idNota") Integer idNota) {
        Nota nota = null;
        try {
            nota = notaBO.obtenerPorId(idNota);
        } catch (RemoteException ex) {
            System.out.println(ex.getMessage());
        }
        return nota;
    }
    
    @WebMethod(operationName = "listarPorAlumnoYCurso")
    public ArrayList<Nota> listarPorAlumnoYCurso(@WebParam(name = "idAlumno") Integer idAlumno,
            @WebParam(name = "idCurso") Integer idCurso) {
        ArrayList<Nota> notas = null;
        try {
            notas = notaBO.listarPorAlumnoYCurso(idAlumno, idCurso);
        } catch (RemoteException ex) {
            System.out.println(ex.getMessage());
        }
        return notas;
    }
    
    @WebMethod(operationName = "listarPorAlumnoCursoYBimestre")
    public ArrayList<Nota> listarPorAlumnoCursoYBimestre(@WebParam(name = "idAlumno") Integer idAlumno,
            @WebParam(name = "idCurso") Integer idCurso, @WebParam(name = "bimestre") Integer bimestre) {
        ArrayList<Nota> notas = null;
        try {
            notas = notaBO.listarPorAlumnoCursoYBimestre(idAlumno, idCurso, bimestre);
        } catch (RemoteException ex) {
            System.out.println(ex.getMessage());
        }
        return notas;
    }
    
    @WebMethod(operationName = "obtenerNotaPorParametros")
    public Nota obtenerNotaPorParametros(@WebParam(name = "idMatricula") Integer idMatricula,@WebParam(name = "idAlumno") Integer idAlumno,
            @WebParam(name = "idCurso") Integer idCurso, @WebParam(name = "bimestre") Integer bimestre,
            @WebParam(name = "idCompetencia") Integer idCompetencia) {
        Nota nota = null;
        try {
            nota = notaBO.obtenerNotaPorParametros(idMatricula, idAlumno, idCurso, bimestre,
                    idCompetencia);
        } catch (RemoteException ex) {
            System.out.println(ex.getMessage());
        }
        return nota;
    }
}
