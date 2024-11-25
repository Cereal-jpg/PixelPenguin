package pe.edu.pucp.pixelpenguins.rmi.interfacesImpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import pe.edu.pucp.pixelpenguins.usuario.model.Apoderado;
import pe.edu.pucp.pixelpenguins.rmi.interfaces.ApoderadoBO;

public class ApoderadoBOImpl extends UnicastRemoteObject implements ApoderadoBO {

    private pe.edu.pucp.pixelpenguins.usuario.bo.ApoderadoBO apoderadoBO;
    
    public ApoderadoBOImpl(Integer puerto) throws RemoteException {
        super(puerto);
        this.apoderadoBO = new pe.edu.pucp.pixelpenguins.usuario.bo.ApoderadoBO();
    }

    @Override
    public Integer insertar(Apoderado apoderado) throws RemoteException {
        return this.apoderadoBO.insertar(apoderado);
    }

    @Override
    public Integer modificar(Apoderado apoderado) throws RemoteException {
        return this.apoderadoBO.modificar(apoderado);
    }

    @Override
    public Integer eliminar(Apoderado apoderado) throws RemoteException {
        return this.apoderadoBO.eliminar(apoderado);
    }

    @Override
    public Apoderado obtenerPorId(int idApoderado) throws RemoteException {
        return this.apoderadoBO.obtenerPorId(idApoderado);
    }

    @Override
    public ArrayList<Apoderado> listarTodos() throws RemoteException {
        return this.apoderadoBO.listarTodos();
    }

}
