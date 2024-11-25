package pe.edu.pucp.pixelpenguins.rmi.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import pe.edu.pucp.pixelpenguins.curricula.model.GradoAcademico;

public interface GradoAcademicoBO extends Remote {
    
    public Integer insertar(GradoAcademico gradoAcademico) throws RemoteException;
    
    public Integer modificar(GradoAcademico gradoAcademico) throws RemoteException;
    
    public Integer eliminar(GradoAcademico gradoAcademico) throws RemoteException;

    public ArrayList<GradoAcademico> listarTodos() throws RemoteException;

    public GradoAcademico obtenerPorId(Integer idGradoAcademico) throws RemoteException;
    
}
