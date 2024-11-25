package pe.edu.pucp.pixelpenguins.rmi.interfacesImpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import pe.edu.pucp.pixelpenguins.usuario.model.Profesor;
import pe.edu.pucp.pixelpenguins.rmi.interfaces.ProfesorBO;

public class ProfesorBOImpl extends UnicastRemoteObject implements ProfesorBO {

    private pe.edu.pucp.pixelpenguins.usuario.bo.ProfesorBO profesorBO;
    
    public ProfesorBOImpl(Integer puerto) throws RemoteException {
        super(puerto);
        this.profesorBO = new pe.edu.pucp.pixelpenguins.usuario.bo.ProfesorBO();
    }

    @Override
    public Integer insertar(Profesor profesor) throws RemoteException {
        return this.profesorBO.insertar(profesor);
    }

    @Override
    public Integer modificar(Profesor profesor) throws RemoteException {
        return this.profesorBO.modificar(profesor);
    }

    @Override
    public Integer eliminar(Profesor profesor) throws RemoteException {
        return this.profesorBO.eliminar(profesor);
    }

    @Override
    public ArrayList<Profesor> listarTodos() throws RemoteException {
        return this.profesorBO.listarTodos();
    }

    @Override
    public Profesor obtenerPorId(Integer idUsuario) throws RemoteException {
        return this.profesorBO.obtenerPorId(idUsuario);
    }

    @Override
    public Boolean existeProfesor(Integer idUsuario) throws RemoteException {
        return this.profesorBO.existeProfesor(idUsuario);
    }

    @Override
    public ArrayList<Profesor> listarProfesoresPorNombre(String nombre) throws RemoteException {
        return this.profesorBO.listarProfesoresPorNombre(nombre);
    }

}
