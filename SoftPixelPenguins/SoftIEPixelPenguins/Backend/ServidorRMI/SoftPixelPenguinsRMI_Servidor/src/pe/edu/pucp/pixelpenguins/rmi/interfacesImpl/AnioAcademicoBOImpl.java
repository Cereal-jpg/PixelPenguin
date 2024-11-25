package pe.edu.pucp.pixelpenguins.rmi.interfacesImpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import pe.edu.pucp.pixelpenguins.anioacademico.model.AnioAcademico;
import pe.edu.pucp.pixelpenguins.rmi.interfaces.AnioAcademicoBO;

public class AnioAcademicoBOImpl extends UnicastRemoteObject implements AnioAcademicoBO {

    private pe.edu.pucp.pixelpenguins.anioacademico.bo.AnioAcademicoBO anioAcademicoBO;
    
    public AnioAcademicoBOImpl(Integer puerto) throws RemoteException {
        super(puerto);
        this.anioAcademicoBO = new pe.edu.pucp.pixelpenguins.anioacademico.bo.AnioAcademicoBO();
    }
    
    @Override
    public Integer insertar(AnioAcademico anioAcademico) throws RemoteException {
        return anioAcademicoBO.insertar(anioAcademico);
    }

    @Override
    public Integer modificar(AnioAcademico anioAcademico) throws RemoteException {
        return anioAcademicoBO.modificar(anioAcademico);
    }

    @Override
    public Integer eliminar(AnioAcademico anioAcademico) throws RemoteException {
        return anioAcademicoBO.eliminar(anioAcademico);
    }

    @Override
    public ArrayList<AnioAcademico> listarTodos() throws RemoteException {
        return anioAcademicoBO.listarTodos();
    }

    @Override
    public AnioAcademico obtenerPorId(Integer idAnioAcademico) throws RemoteException {
        return anioAcademicoBO.obtenerPorId(idAnioAcademico);
    }
    
}
