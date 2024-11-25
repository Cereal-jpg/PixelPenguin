package pe.edu.pucp.pixelpenguins.rmi.interfacesImpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import pe.edu.pucp.pixelpenguins.curricula.model.Curso;
import pe.edu.pucp.pixelpenguins.curricula.model.HoraAcademica;
import pe.edu.pucp.pixelpenguins.rmi.interfaces.HoraAcademicaBO;

public class HoraAcademicaBOImpl extends UnicastRemoteObject implements HoraAcademicaBO {

    private pe.edu.pucp.pixelpenguins.curricula.bo.HoraAcademicaBO horaAcademicaBO;
    
    public HoraAcademicaBOImpl(Integer puerto) throws RemoteException {
        super(puerto);
        this.horaAcademicaBO = new pe.edu.pucp.pixelpenguins.curricula.bo.HoraAcademicaBO();
    }

    @Override
    public Integer insertar(HoraAcademica horaAcademica) throws RemoteException {
        return this.horaAcademicaBO.insertar(horaAcademica);
    }

    @Override
    public Integer modificar(HoraAcademica horaAcademica) throws RemoteException {
        return this.horaAcademicaBO.modificar(horaAcademica);
    }

    @Override
    public Integer eliminar(HoraAcademica horaAcademica) throws RemoteException {
        return this.horaAcademicaBO.eliminar(horaAcademica);
    }

    @Override
    public ArrayList<HoraAcademica> listarTodos() throws RemoteException {
        return this.horaAcademicaBO.listarTodos();
    }

    @Override
    public HoraAcademica obtenerPorId(Integer idHoraAcademica) throws RemoteException {
        return this.horaAcademicaBO.obtenerPorId(idHoraAcademica);
    }

    @Override
    public ArrayList<HoraAcademica> listarHorasAcademicasPorCurso(Curso curso) throws RemoteException {
        return this.horaAcademicaBO.listarHorasAcademicasPorCurso(curso);
    }

}
