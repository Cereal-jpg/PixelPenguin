package pe.edu.pucp.pixelpenguins.rmi.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import pe.edu.pucp.pixelpenguins.usuario.model.Rol;

public interface RolBO extends Remote {
    
    public Integer insertar(Rol rol) throws RemoteException;
    
    public Integer modificar(Rol rol) throws RemoteException;
    
    public Integer eliminar(Rol rol) throws RemoteException;

    public ArrayList<Rol> listarTodos() throws RemoteException;

    public Rol obtenerPorId(Integer idRol) throws RemoteException;
    
}
