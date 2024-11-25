package pe.edu.pucp.pixelpenguins.rmi.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import pe.edu.pucp.pixelpenguins.curricula.model.Curso;

public interface CursoBO extends Remote {
    
    public Integer insertar(Curso curso) throws RemoteException;
    
    public Integer modificar(Curso curso) throws RemoteException;
    
    public Integer eliminar(Curso curso) throws RemoteException;
    
    public ArrayList<Curso> listarTodos() throws RemoteException;
    
    public Curso obtenerPorId(Integer idCurso) throws RemoteException;
    
   public ArrayList<Curso> listarCursosPorGrado(Integer idGradoAcademico) throws RemoteException;
   
   public ArrayList<Curso> listarCursosPorProfesor(Integer idProfesor) throws RemoteException;
    
}
