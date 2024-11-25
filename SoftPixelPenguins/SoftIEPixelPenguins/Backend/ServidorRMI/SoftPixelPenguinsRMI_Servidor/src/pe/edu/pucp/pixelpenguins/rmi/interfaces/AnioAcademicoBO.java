package pe.edu.pucp.pixelpenguins.rmi.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import pe.edu.pucp.pixelpenguins.anioacademico.model.AnioAcademico;

public interface AnioAcademicoBO extends Remote {
    
    public Integer insertar(AnioAcademico anioAcademico) throws RemoteException;
    
    public Integer modificar(AnioAcademico anioAcademico) throws RemoteException;
    
    public Integer eliminar(AnioAcademico anioAcademico) throws RemoteException;
    
    public ArrayList<AnioAcademico> listarTodos() throws RemoteException;
    
    public AnioAcademico obtenerPorId(Integer idAnioAcademico) throws RemoteException;
    
}
