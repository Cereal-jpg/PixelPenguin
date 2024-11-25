package pe.edu.pucp.pixelpenguins.rmi.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import pe.edu.pucp.pixelpenguins.usuario.model.Usuario;

public interface UsuarioBO extends Remote {
    
    public Integer insertar(Usuario usuario) throws RemoteException;
    
    public Integer modificar(Usuario usuario) throws RemoteException;
    
    public Integer eliminar(Usuario usuario) throws RemoteException;

    public ArrayList<Usuario> listarTodos() throws RemoteException;

    public Usuario obtenerPorId(Integer idUsuario) throws RemoteException;

    public Boolean existeUsuario(Usuario usuario) throws RemoteException;
    
    public ArrayList<Usuario> listarUsuariosPorNombre(String nombre) throws RemoteException;
    
    public Integer ValidarDatos(String email,String password) throws RemoteException;
    
    public Integer ValidarCorreoElectronico(String email) throws RemoteException;
    
    public Integer ActualizarContrasena(String email,String newPassword) throws RemoteException;
    
}
