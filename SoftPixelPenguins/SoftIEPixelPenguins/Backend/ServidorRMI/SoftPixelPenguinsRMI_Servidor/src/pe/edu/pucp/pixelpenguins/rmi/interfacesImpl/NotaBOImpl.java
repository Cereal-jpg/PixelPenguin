package pe.edu.pucp.pixelpenguins.rmi.interfacesImpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import pe.edu.pucp.pixelpenguins.curricula.model.Nota;
import pe.edu.pucp.pixelpenguins.rmi.interfaces.NotaBO;

public class NotaBOImpl extends UnicastRemoteObject implements NotaBO {

    private pe.edu.pucp.pixelpenguins.curricula.bo.NotaBO notaBO;
    
    public NotaBOImpl(Integer puerto) throws RemoteException {
        super(puerto);
        this.notaBO = new pe.edu.pucp.pixelpenguins.curricula.bo.NotaBO();
    }

    @Override
    public Integer insertar(Nota nota) throws RemoteException {
        return this.notaBO.insertar(nota);
    }

    @Override
    public Integer modificar(Nota nota) throws RemoteException {
        return this.notaBO.modificar(nota);
    }

    @Override
    public Integer eliminar(Nota nota) throws RemoteException {
        return this.notaBO.eliminar(nota);
    }

    @Override
    public ArrayList<Nota> listarTodos() throws RemoteException {
        return this.notaBO.listarTodos();
    }

    @Override
    public Nota obtenerPorId(Integer idNota) throws RemoteException {
        return this.notaBO.obtenerPorId(idNota);
    }

    @Override
    public ArrayList<Nota> listarPorAlumnoYCurso(Integer idAlumno, Integer idCurso) throws RemoteException {
        return this.notaBO.listarPorAlumnoYCurso(idAlumno,idCurso);
    }

    @Override
    public ArrayList<Nota> listarPorAlumnoCursoYBimestre(Integer idAlumno, Integer idCurso, Integer bimestre) throws RemoteException {
        return this.notaBO.listarPorAlumnoCursoYBimestre(idAlumno,idCurso,bimestre);
    }

    @Override
    public Nota obtenerNotaPorParametros(Integer idMatricula, Integer idAlumno, Integer idCurso, Integer bimestre, Integer idCompetencia) throws RemoteException {
        return this.notaBO.obtenerNotaPorParametros(idMatricula, idAlumno,idCurso,bimestre,idCompetencia);
    }

}
