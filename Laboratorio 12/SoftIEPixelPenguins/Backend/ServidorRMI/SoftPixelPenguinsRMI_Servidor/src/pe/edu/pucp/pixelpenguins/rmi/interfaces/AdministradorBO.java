package pe.edu.pucp.pixelpenguins.rmi.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import pe.edu.pucp.pixelpenguins.usuario.model.Administrador;

public interface AdministradorBO extends Remote {
    
    public Integer insertar(Administrador administrador) throws RemoteException;
    
    public Integer modificar(Administrador administrador) throws RemoteException;
    
    public Integer eliminar(Administrador administrador) throws RemoteException;
    
    public ArrayList<Administrador> listarTodos() throws RemoteException;

    public Administrador obtenerPorId(Integer idUsuario) throws RemoteException;

    public Boolean existeAdministrador(Integer idUsuario) throws RemoteException;
    
}
