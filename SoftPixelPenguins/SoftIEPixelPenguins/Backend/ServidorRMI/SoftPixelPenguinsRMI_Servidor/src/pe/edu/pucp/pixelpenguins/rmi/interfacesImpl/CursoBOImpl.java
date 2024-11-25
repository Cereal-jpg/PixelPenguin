package pe.edu.pucp.pixelpenguins.rmi.interfacesImpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import pe.edu.pucp.pixelpenguins.curricula.model.Curso;
import pe.edu.pucp.pixelpenguins.rmi.interfaces.CursoBO;

public class CursoBOImpl extends UnicastRemoteObject implements CursoBO {

    private pe.edu.pucp.pixelpenguins.curricula.bo.CursoBO cursoBO;
    
    public CursoBOImpl(Integer puerto) throws RemoteException {
        super(puerto);
        this.cursoBO = new pe.edu.pucp.pixelpenguins.curricula.bo.CursoBO();
    }

    @Override
    public Integer insertar(Curso curso) throws RemoteException {
        return this.cursoBO.insertar(curso);
    }

    @Override
    public Integer modificar(Curso curso) throws RemoteException {
        return this.cursoBO.modificar(curso);
    }

    @Override
    public Integer eliminar(Curso curso) throws RemoteException {
        return this.cursoBO.eliminar(curso);
    }

    @Override
    public ArrayList<Curso> listarTodos() throws RemoteException {
        return this.cursoBO.listarTodos();
    }

    @Override
    public Curso obtenerPorId(Integer idCurso) throws RemoteException {
        return this.cursoBO.obtenerPorId(idCurso);
    }

    @Override
    public ArrayList<Curso> listarCursosPorGrado(Integer idGradoAcademico) throws RemoteException {
        return this.cursoBO.listarCursosPorGrado(idGradoAcademico);
    }

    @Override
    public ArrayList<Curso> listarCursosPorProfesor(Integer idProfesor) throws RemoteException {
        return this.cursoBO.listarCursosPorProfesor(idProfesor);
    }

}
