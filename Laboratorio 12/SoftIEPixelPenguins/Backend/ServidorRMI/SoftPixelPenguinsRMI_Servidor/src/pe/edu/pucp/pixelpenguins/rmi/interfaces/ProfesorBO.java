package pe.edu.pucp.pixelpenguins.rmi.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import pe.edu.pucp.pixelpenguins.usuario.model.Profesor;

public interface ProfesorBO extends Remote {
    
    public Integer insertar(Profesor profesor) throws RemoteException;

    public Integer modificar(Profesor profesor) throws RemoteException;
    
    public Integer eliminar(Profesor profesor) throws RemoteException;

    public ArrayList<Profesor> listarTodos() throws RemoteException;

    public Profesor obtenerPorId(Integer idUsuario) throws RemoteException;

    public Boolean existeProfesor(Integer idUsuario) throws RemoteException;
    
    public ArrayList<Profesor>listarProfesoresPorNombre(String nombre) throws RemoteException;
    
}
