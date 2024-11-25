package pe.edu.pucp.pixelpenguins.rmi.interfacesImpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import pe.edu.pucp.pixelpenguins.curricula.model.GradoAcademico;
import pe.edu.pucp.pixelpenguins.curricula.model.SeccionAcademica;
import pe.edu.pucp.pixelpenguins.rmi.interfaces.SeccionAcademicaBO;

public class SeccionAcademicaBOImpl extends UnicastRemoteObject implements SeccionAcademicaBO {

    private pe.edu.pucp.pixelpenguins.curricula.bo.SeccionAcademicaBO seccionAcademicaBO;
    
    public SeccionAcademicaBOImpl(Integer puerto) throws RemoteException {
        super(puerto);
        this.seccionAcademicaBO = new pe.edu.pucp.pixelpenguins.curricula.bo.SeccionAcademicaBO();
    }

    @Override
    public Integer insertar(SeccionAcademica seccionAcademica) throws RemoteException {
        return this.seccionAcademicaBO.insertar(seccionAcademica);
    }

    @Override
    public Integer modificar(SeccionAcademica seccionAcademica) throws RemoteException {
        return this.seccionAcademicaBO.modificar(seccionAcademica);
    }

    @Override
    public Integer eliminar(SeccionAcademica seccionAcademica) throws RemoteException {
        return this.seccionAcademicaBO.eliminar(seccionAcademica);
    }

    @Override
    public ArrayList<SeccionAcademica> listarTodos() throws RemoteException {
        return this.seccionAcademicaBO.listarTodos();
    }

    @Override
    public SeccionAcademica obtenerPorId(Integer idSeccionAcademica) throws RemoteException {
        return this.seccionAcademicaBO.obtenerPorId(idSeccionAcademica);
    }

    @Override
    public ArrayList<SeccionAcademica> listarSeccionesPorGrado(GradoAcademico gradoAcademico) throws RemoteException {
        return this.seccionAcademicaBO.listarSeccionesPorGrado(gradoAcademico);
    }
    
}
