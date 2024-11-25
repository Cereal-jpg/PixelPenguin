package pe.edu.pucp.pixelpenguins.rmi.interfacesImpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import pe.edu.pucp.pixelpenguins.anioacademico.model.Matricula;
import pe.edu.pucp.pixelpenguins.curricula.model.GradoAcademico;
import pe.edu.pucp.pixelpenguins.rmi.interfaces.MatriculaBO;

public class MatriculaBOImpl extends UnicastRemoteObject implements MatriculaBO {

    private pe.edu.pucp.pixelpenguins.anioacademico.bo.MatriculaBO matriculaBO;

    public MatriculaBOImpl(Integer puerto) throws RemoteException{
        super(puerto);
        this.matriculaBO = new pe.edu.pucp.pixelpenguins.anioacademico.bo.MatriculaBO();
    }
    
    @Override
    public Integer insertar(Matricula matricula) throws RemoteException {
        return this.matriculaBO.insertar(matricula);
    }

    @Override
    public Integer modificar(Matricula matricula) throws RemoteException {
        return this.matriculaBO.modificar(matricula);
    }

    @Override
    public Integer eliminar(Matricula matricula) throws RemoteException {
        return this.matriculaBO.eliminar(matricula);
    }

    @Override
    public ArrayList<Matricula> listarTodos() throws RemoteException {
        return this.matriculaBO.listarTodos();
    }

    @Override
    public Matricula obtenerPorId(Integer idMatricula) throws RemoteException {
        return this.matriculaBO.obtenerPorId(idMatricula);
    }

    @Override
    public Integer obtenerPorIdAlumno(Integer idAlumno) throws RemoteException {
        return this.matriculaBO.obtenerPorIdAlumno(idAlumno);
    }

    @Override
    public ArrayList<Matricula> listarMatriculasPorGradoAcademico(GradoAcademico gradoAcademico) throws RemoteException {
        return this.matriculaBO.listarMatriculasPorGradoAcademico(gradoAcademico);
    }
    
}
