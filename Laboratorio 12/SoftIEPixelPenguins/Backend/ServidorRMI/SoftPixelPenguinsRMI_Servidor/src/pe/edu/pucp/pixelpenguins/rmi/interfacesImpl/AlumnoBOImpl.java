package pe.edu.pucp.pixelpenguins.rmi.interfacesImpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import pe.edu.pucp.pixelpenguins.usuario.model.Alumno;
import pe.edu.pucp.pixelpenguins.rmi.interfaces.AlumnoBO;
import pe.edu.pucp.pixelpenguins.usuario.model.EstadoAlumno;

public class AlumnoBOImpl extends UnicastRemoteObject implements AlumnoBO {

    private pe.edu.pucp.pixelpenguins.usuario.bo.AlumnoBO alumnoBO;
    
    public AlumnoBOImpl(Integer puerto) throws RemoteException {
        super(puerto);
        this.alumnoBO = new pe.edu.pucp.pixelpenguins.usuario.bo.AlumnoBO();
    }

    @Override
    public Integer insertar(Alumno alumno) throws RemoteException {
        return this.alumnoBO.insertar(alumno);
    }

    @Override
    public Integer modificar(Alumno alumno) throws RemoteException {
        return this.alumnoBO.modificar(alumno);
    }

    @Override
    public Integer eliminar(Alumno alumno) throws RemoteException {
        return this.alumnoBO.eliminar(alumno);
    }

    @Override
    public ArrayList<Alumno> listarTodos() throws RemoteException {
        return this.alumnoBO.listarTodos();
    }

    @Override
    public Alumno obtenerPorId(Integer idUsuario) throws RemoteException {
        return this.alumnoBO.obtenerPorId(idUsuario);
    }

    @Override
    public ArrayList<Alumno> listarAlumnosPorNombreYEstado(String nombre, EstadoAlumno estado) throws RemoteException {
        return this.alumnoBO.listarAlumnosPorNombreYEstado(nombre,estado);
    }

    @Override
    public ArrayList<Alumno> listarAlumnosPorNombre(String nombre) throws RemoteException {
        return this.alumnoBO.listarAlumnosPorNombre(nombre);
    }

    @Override
    public Boolean existeAlumno(Integer idUsuario) throws RemoteException {
        return this.alumnoBO.existeAlumno(idUsuario);
    }

}
