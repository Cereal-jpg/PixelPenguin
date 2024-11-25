package pe.edu.pucp.pixelpenguins.rmi.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import pe.edu.pucp.pixelpenguins.curricula.model.Nota;

public interface NotaBO extends Remote {
    
    public Integer insertar(Nota nota) throws RemoteException;
    
    public Integer modificar(Nota nota) throws RemoteException;

    public Integer eliminar(Nota nota) throws RemoteException;

    public ArrayList<Nota> listarTodos() throws RemoteException;

    public Nota obtenerPorId(Integer idNota) throws RemoteException;
    
    public ArrayList<Nota> listarPorAlumnoYCurso(Integer idAlumno,Integer idCurso) throws RemoteException;
    
    public ArrayList<Nota> listarPorAlumnoCursoYBimestre(Integer idAlumno,
            Integer idCurso, Integer bimestre) throws RemoteException;
    
    public Nota obtenerNotaPorParametros(Integer idAlumno,Integer idCurso,
            Integer bimestre,Integer idCompetencia) throws RemoteException;
    
}
