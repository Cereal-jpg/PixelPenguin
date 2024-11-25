package pe.edu.pucp.pixelpenguins.rmi.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import pe.edu.pucp.pixelpenguins.usuario.model.PersonalAdministrativo;

public interface PersonalAdministrativoBO extends Remote {
    
    public Integer insertar(PersonalAdministrativo personalAdministrativo) throws RemoteException;
    
    public Integer modificar(PersonalAdministrativo personalAdministrativo) throws RemoteException;
    
    public Integer eliminar(PersonalAdministrativo personalAdministrativo) throws RemoteException;
    
    public ArrayList<PersonalAdministrativo> listarTodos() throws RemoteException;

    public PersonalAdministrativo obtenerPorId(Integer idUsuario) throws RemoteException;

    public Boolean existePersonalAdministrativo(Integer idUsuario) throws RemoteException;
    
}
