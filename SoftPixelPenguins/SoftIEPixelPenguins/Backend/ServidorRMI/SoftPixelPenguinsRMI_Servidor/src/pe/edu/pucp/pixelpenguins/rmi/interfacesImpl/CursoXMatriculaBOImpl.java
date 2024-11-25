package pe.edu.pucp.pixelpenguins.rmi.interfacesImpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import pe.edu.pucp.pixelpenguins.anioacademico.model.CursoXMatricula;
import pe.edu.pucp.pixelpenguins.rmi.interfaces.CursoXMatriculaBO;

public class CursoXMatriculaBOImpl extends UnicastRemoteObject implements CursoXMatriculaBO {

    private pe.edu.pucp.pixelpenguins.anioacademico.bo.CursoXMatriculaBO cursoXMatriculaBO;
    
    public CursoXMatriculaBOImpl(Integer puerto) throws RemoteException {
        super(puerto);
        this.cursoXMatriculaBO = new pe.edu.pucp.pixelpenguins.anioacademico.bo.CursoXMatriculaBO();
    }
    
    @Override
    public Integer insertar(CursoXMatricula cursoXMatricula) throws RemoteException {
        return this.cursoXMatriculaBO.insertar(cursoXMatricula);
    }

    @Override
    public Integer modificar(CursoXMatricula cursoXMatricula) throws RemoteException {
        return this.cursoXMatriculaBO.modificar(cursoXMatricula);
    }

    @Override
    public Integer eliminar(CursoXMatricula cursoXMatricula) throws RemoteException {
        return this.cursoXMatriculaBO.eliminar(cursoXMatricula);
    }

    @Override
    public ArrayList<CursoXMatricula> listarTodos() throws RemoteException {
        return this.cursoXMatriculaBO.listarTodos();
    }

    @Override
    public CursoXMatricula obtenerPorCursoYMatricula(Integer idCurso, Integer idMatricula) throws RemoteException {
        return this.cursoXMatriculaBO.obtenerPorCursoYMatricula(idCurso,idMatricula);
    }

    @Override
    public ArrayList<CursoXMatricula> listarNotasFinalesCursosXMatricula(Integer idMatricula) throws RemoteException {
        return this.cursoXMatriculaBO.listarNotasFinalesCursosXMatricula(idMatricula);
    }

    @Override
    public ArrayList<CursoXMatricula> listarNotasFinalesCursosXAlumno(Integer idAlumno) throws RemoteException {
        return this.cursoXMatriculaBO.listarNotasFinalesCursosXAlumno(idAlumno);
    }

    @Override
    public ArrayList<CursoXMatricula> listarNotasFinalesXCurso(Integer idCurso) throws RemoteException {
        return this.cursoXMatriculaBO.listarNotasFinalesXCurso(idCurso);
    }

    
    
}
