package pe.edu.pucp.pixelpenguins.rmi.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import pe.edu.pucp.pixelpenguins.anioacademico.model.CursoXMatricula;

public interface CursoXMatriculaBO extends Remote {
    
    public Integer insertar(CursoXMatricula cursoXMatricula) throws RemoteException;
    
    public Integer modificar(CursoXMatricula cursoXMatricula) throws RemoteException;
    
    public Integer eliminar(CursoXMatricula cursoXMatricula) throws RemoteException;
    
    public ArrayList<CursoXMatricula> listarTodos() throws RemoteException;
    
    public CursoXMatricula obtenerPorCursoYMatricula(Integer idCurso, Integer idMatricula) throws RemoteException;
    
    public ArrayList<CursoXMatricula> listarNotasFinalesCursosXMatricula (Integer idMatricula) throws RemoteException;
    
    public ArrayList<CursoXMatricula> listarNotasFinalesCursosXAlumno (Integer idAlumno) throws RemoteException;
    
    public ArrayList<CursoXMatricula> listarNotasFinalesXCurso (Integer idCurso) throws RemoteException;
    
}
