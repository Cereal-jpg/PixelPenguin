package pe.edu.pucp.pixelpenguins.rmi.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import pe.edu.pucp.pixelpenguins.usuario.model.Apoderado;

public interface ApoderadoBO extends Remote {
    
    public Integer insertar(Apoderado apoderado) throws RemoteException;
    
    public Integer modificar(Apoderado apoderado) throws RemoteException;
    
    public Integer eliminar(Apoderado apoderado) throws RemoteException;

    public Apoderado obtenerPorId(int idApoderado) throws RemoteException;

    public ArrayList<Apoderado> listarTodos() throws RemoteException;
    
}
