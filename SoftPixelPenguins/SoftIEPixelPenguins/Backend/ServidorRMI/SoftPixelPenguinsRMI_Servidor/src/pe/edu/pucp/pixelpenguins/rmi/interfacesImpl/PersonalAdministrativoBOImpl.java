package pe.edu.pucp.pixelpenguins.rmi.interfacesImpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import pe.edu.pucp.pixelpenguins.usuario.model.PersonalAdministrativo;
import pe.edu.pucp.pixelpenguins.rmi.interfaces.PersonalAdministrativoBO;

public class PersonalAdministrativoBOImpl extends UnicastRemoteObject implements PersonalAdministrativoBO {

    private pe.edu.pucp.pixelpenguins.usuario.bo.PersonalAdministrativoBO personalAdministrativoBO;
    
    public PersonalAdministrativoBOImpl(Integer puerto) throws RemoteException {
        super(puerto);
        this.personalAdministrativoBO = new pe.edu.pucp.pixelpenguins.usuario.bo.PersonalAdministrativoBO();
    }

    @Override
    public Integer insertar(PersonalAdministrativo personalAdministrativo) throws RemoteException {
        return this.personalAdministrativoBO.insertar(personalAdministrativo);
    }

    @Override
    public Integer modificar(PersonalAdministrativo personalAdministrativo) throws RemoteException {
        return this.personalAdministrativoBO.modificar(personalAdministrativo);
    }

    @Override
    public Integer eliminar(PersonalAdministrativo personalAdministrativo) throws RemoteException {
        return this.personalAdministrativoBO.eliminar(personalAdministrativo);
    }

    @Override
    public ArrayList<PersonalAdministrativo> listarTodos() throws RemoteException {
        return this.personalAdministrativoBO.listarTodos();
    }

    @Override
    public PersonalAdministrativo obtenerPorId(Integer idUsuario) throws RemoteException {
        return this.personalAdministrativoBO.obtenerPorId(idUsuario);
    }

    @Override
    public Boolean existePersonalAdministrativo(Integer idUsuario) throws RemoteException {
        return this.personalAdministrativoBO.existePersonalAdministrativo(idUsuario);
    }

}
