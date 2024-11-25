package pe.edu.pucp.pixelpenguins.rmi.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import pe.edu.pucp.pixelpenguins.curricula.model.Competencia;

public interface CompetenciaBO extends Remote {
    
    public Integer insertar(Competencia competencia) throws RemoteException;
    
    public Integer modificar(Competencia competencia) throws RemoteException;
    
    public Integer eliminar(Competencia competencia) throws RemoteException;
    
    public ArrayList<Competencia> listarTodos() throws RemoteException;
    
    public Competencia obtenerPorId(Integer idCompetencia) throws RemoteException;
    
    public ArrayList<Competencia> listarCompetenciasPorCurso(Integer idCurso) throws RemoteException;
    
}
