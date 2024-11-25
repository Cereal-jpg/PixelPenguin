package pe.edu.pucp.pixelpenguins.rmi.interfacesImpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import pe.edu.pucp.pixelpenguins.usuario.model.Usuario;
import pe.edu.pucp.pixelpenguins.rmi.interfaces.UsuarioBO;

public class UsuarioBOImpl extends UnicastRemoteObject implements UsuarioBO {

    private pe.edu.pucp.pixelpenguins.usuario.bo.UsuarioBO usuarioBO;
    
    public UsuarioBOImpl(Integer puerto) throws RemoteException {
        super(puerto);
        this.usuarioBO = new pe.edu.pucp.pixelpenguins.usuario.bo.UsuarioBO();
    }

    @Override
    public Integer insertar(Usuario usuario) throws RemoteException {
        return this.usuarioBO.insertar(usuario);
    }

    @Override
    public Integer modificar(Usuario usuario) throws RemoteException {
        return this.usuarioBO.modificar(usuario);
    }

    @Override
    public Integer eliminar(Usuario usuario) throws RemoteException {
        return this.usuarioBO.eliminar(usuario);
    }

    @Override
    public ArrayList<Usuario> listarTodos() throws RemoteException {
        return this.usuarioBO.listarTodos();
    }

    @Override
    public Usuario obtenerPorId(Integer idUsuario) throws RemoteException {
        return this.usuarioBO.obtenerPorId(idUsuario);
    }

    @Override
    public Boolean existeUsuario(Usuario usuario) throws RemoteException {
        return this.usuarioBO.existeUsuario(usuario);
    }

    @Override
    public ArrayList<Usuario> listarUsuariosPorNombre(String nombre) throws RemoteException {
        return this.usuarioBO.listarUsuariosPorNombre(nombre);
    }

    @Override
    public Integer ValidarDatos(String email, String password) throws RemoteException {
        return this.usuarioBO.ValidarDatos(email, password);
    }

    @Override
    public Integer ValidarCorreoElectronico(String email) throws RemoteException {
        return this.usuarioBO.ValidarCorreoElectronico(email);
    }

    @Override
    public Integer ActualizarContrasena(String email, String newPassword) throws RemoteException {
        return this.usuarioBO.ActualizarContrasena(email, newPassword);
    }

}
