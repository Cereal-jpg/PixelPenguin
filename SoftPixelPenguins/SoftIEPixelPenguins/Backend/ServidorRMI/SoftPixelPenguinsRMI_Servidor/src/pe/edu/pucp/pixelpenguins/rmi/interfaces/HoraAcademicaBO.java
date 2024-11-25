package pe.edu.pucp.pixelpenguins.rmi.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import pe.edu.pucp.pixelpenguins.curricula.model.Curso;
import pe.edu.pucp.pixelpenguins.curricula.model.HoraAcademica;

public interface HoraAcademicaBO extends Remote {
    
    public Integer insertar(HoraAcademica horaAcademica) throws RemoteException;
    
    public Integer modificar(HoraAcademica horaAcademica) throws RemoteException;
    
    public Integer eliminar(HoraAcademica horaAcademica) throws RemoteException;
    
    public ArrayList<HoraAcademica> listarTodos() throws RemoteException;

    public HoraAcademica obtenerPorId(Integer idHoraAcademica) throws RemoteException;
    
    public ArrayList<HoraAcademica>listarHorasAcademicasPorCurso(Curso curso) throws RemoteException;
    
}
