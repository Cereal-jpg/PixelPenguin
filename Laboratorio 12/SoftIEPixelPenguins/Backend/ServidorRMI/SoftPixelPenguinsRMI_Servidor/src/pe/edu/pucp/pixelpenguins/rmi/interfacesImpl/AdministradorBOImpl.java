package pe.edu.pucp.pixelpenguins.rmi.interfacesImpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import pe.edu.pucp.pixelpenguins.usuario.model.Administrador;
import pe.edu.pucp.pixelpenguins.rmi.interfaces.AdministradorBO;

public class AdministradorBOImpl extends UnicastRemoteObject implements AdministradorBO {

    private pe.edu.pucp.pixelpenguins.usuario.bo.AdministradorBO administradorBO;
    
    public AdministradorBOImpl(Integer puerto) throws RemoteException {
        super(puerto);
        this.administradorBO = new pe.edu.pucp.pixelpenguins.usuario.bo.AdministradorBO();
    }

    @Override
    public Integer insertar(Administrador administrador) throws RemoteException {
        return this.administradorBO.insertar(administrador);
    }

    @Override
    public Integer modificar(Administrador administrador) throws RemoteException {
        return this.administradorBO.modificar(administrador);
    }

    @Override
    public Integer eliminar(Administrador administrador) throws RemoteException {
        return this.administradorBO.eliminar(administrador);
    }

    @Override
    public ArrayList<Administrador> listarTodos() throws RemoteException {
        return this.administradorBO.listarTodos();
    }

    @Override
    public Administrador obtenerPorId(Integer idUsuario) throws RemoteException {
        return this.administradorBO.obtenerPorId(idUsuario);
    }

    @Override
    public Boolean existeAdministrador(Integer idUsuario) throws RemoteException {
        return this.administradorBO.existeAdministrador(idUsuario);
    }

}
