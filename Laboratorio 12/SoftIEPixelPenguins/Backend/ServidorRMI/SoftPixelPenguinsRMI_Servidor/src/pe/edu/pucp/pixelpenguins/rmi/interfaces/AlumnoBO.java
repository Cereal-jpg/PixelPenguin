package pe.edu.pucp.pixelpenguins.rmi.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import pe.edu.pucp.pixelpenguins.usuario.model.Alumno;
import pe.edu.pucp.pixelpenguins.usuario.model.EstadoAlumno;

public interface AlumnoBO extends Remote {
    
    public Integer insertar(Alumno alumno) throws RemoteException;
    
    public Integer modificar(Alumno alumno) throws RemoteException;
    
    public Integer eliminar(Alumno alumno) throws RemoteException;

    public ArrayList<Alumno> listarTodos() throws RemoteException;
    
    public Alumno obtenerPorId(Integer idUsuario) throws RemoteException;
    
    public ArrayList<Alumno>listarAlumnosPorNombreYEstado(String nombre, EstadoAlumno estado) throws RemoteException;
    
    public ArrayList<Alumno>listarAlumnosPorNombre(String nombre) throws RemoteException;

    public Boolean existeAlumno(Integer idUsuario) throws RemoteException;
    
}
