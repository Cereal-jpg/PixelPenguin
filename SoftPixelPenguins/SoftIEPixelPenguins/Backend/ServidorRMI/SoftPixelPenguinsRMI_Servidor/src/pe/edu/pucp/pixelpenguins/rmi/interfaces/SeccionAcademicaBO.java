package pe.edu.pucp.pixelpenguins.rmi.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import pe.edu.pucp.pixelpenguins.curricula.model.GradoAcademico;
import pe.edu.pucp.pixelpenguins.curricula.model.SeccionAcademica;

public interface SeccionAcademicaBO extends Remote {
    
    public Integer insertar(SeccionAcademica seccionAcademica) throws RemoteException;

    public Integer modificar(SeccionAcademica seccionAcademica) throws RemoteException;
    
    public Integer eliminar(SeccionAcademica seccionAcademica) throws RemoteException;

    public ArrayList<SeccionAcademica> listarTodos() throws RemoteException;

    public SeccionAcademica obtenerPorId(Integer idSeccionAcademica) throws RemoteException;
    
    public ArrayList<SeccionAcademica> listarSeccionesPorGrado(GradoAcademico gradoAcademico) throws RemoteException;
    
}
