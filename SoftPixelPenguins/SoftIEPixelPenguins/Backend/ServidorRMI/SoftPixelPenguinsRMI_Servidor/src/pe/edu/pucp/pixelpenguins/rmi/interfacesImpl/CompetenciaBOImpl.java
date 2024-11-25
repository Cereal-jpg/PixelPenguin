package pe.edu.pucp.pixelpenguins.rmi.interfacesImpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import pe.edu.pucp.pixelpenguins.curricula.model.Competencia;
import pe.edu.pucp.pixelpenguins.rmi.interfaces.CompetenciaBO;

public class CompetenciaBOImpl extends UnicastRemoteObject implements CompetenciaBO {

    private pe.edu.pucp.pixelpenguins.curricula.bo.CompetenciaBO competenciaBO;
    
    public CompetenciaBOImpl(Integer puerto) throws RemoteException {
        super(puerto);
        this.competenciaBO = new pe.edu.pucp.pixelpenguins.curricula.bo.CompetenciaBO();
    }

    @Override
    public Integer insertar(Competencia competencia) throws RemoteException {
        return this.competenciaBO.insertar(competencia);
    }

    @Override
    public Integer modificar(Competencia competencia) throws RemoteException {
        return this.competenciaBO.modificar(competencia);
    }

    @Override
    public Integer eliminar(Competencia competencia) throws RemoteException {
        return this.competenciaBO.eliminar(competencia);
    }

    @Override
    public ArrayList<Competencia> listarTodos() throws RemoteException {
        return this.competenciaBO.listarTodos();
    }

    @Override
    public Competencia obtenerPorId(Integer idCompetencia) throws RemoteException {
        return this.competenciaBO.obtenerPorId(idCompetencia);
    }

    @Override
    public ArrayList<Competencia> listarCompetenciasPorCurso(Integer idCurso) throws RemoteException {
        return this.competenciaBO.listarCompetenciasPorCurso(idCurso);
    }
    
}
