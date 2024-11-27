package pe.edu.pucp.pixelpenguins.rmi.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import pe.edu.pucp.pixelpenguins.anioacademico.model.Matricula;
import pe.edu.pucp.pixelpenguins.curricula.model.GradoAcademico;

public interface MatriculaBO extends Remote {
    
    public Integer insertar(Matricula matricula) throws RemoteException;

    public Integer modificar(Matricula matricula) throws RemoteException;

    public Integer eliminar(Matricula matricula) throws RemoteException;
    
    public ArrayList<Matricula> listarTodos() throws RemoteException;
    
    public Matricula obtenerPorId(Integer idMatricula) throws RemoteException;

     public Integer obtenerPorIdAlumno(Integer idAlumno) throws RemoteException;
     
    public ArrayList<Matricula>listarMatriculasPorGradoAcademico(GradoAcademico gradoAcademico) throws RemoteException;
    
    public ArrayList<String>listarNotasFinalesPorGradoAcademico(GradoAcademico gradoAcademico) throws RemoteException;
    
    public Integer actualizarNotaFinal(Integer idMatricula, String notaFinal) throws RemoteException;
    
}
