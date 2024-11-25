package pe.edu.pucp.pixelpenguins.rmi.interfacesImpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import pe.edu.pucp.pixelpenguins.usuario.model.Rol;
import pe.edu.pucp.pixelpenguins.rmi.interfaces.RolBO;

public class RolBOImpl extends UnicastRemoteObject implements RolBO {

    private pe.edu.pucp.pixelpenguins.usuario.bo.RolBO rolBO;
    
    public RolBOImpl(Integer puerto) throws RemoteException {
        super(puerto);
        this.rolBO = new pe.edu.pucp.pixelpenguins.usuario.bo.RolBO();
    }

    @Override
    public Integer insertar(Rol rol) throws RemoteException {
        return this.rolBO.insertar(rol);
    }

    @Override
    public Integer modificar(Rol rol) throws RemoteException {
        return this.rolBO.modificar(rol);
    }

    @Override
    public Integer eliminar(Rol rol) throws RemoteException {
        return this.rolBO.eliminar(rol);
    }

    @Override
    public ArrayList<Rol> listarTodos() throws RemoteException {
        return this.rolBO.listarTodos();
    }

    @Override
    public Rol obtenerPorId(Integer idRol) throws RemoteException {
        return this.rolBO.obtenerPorId(idRol);
    }

}
