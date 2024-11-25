package pe.edu.pucp.pixelpenguins.rmi.interfacesImpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import pe.edu.pucp.pixelpenguins.curricula.model.GradoAcademico;
import pe.edu.pucp.pixelpenguins.rmi.interfaces.GradoAcademicoBO;

public class GradoAcademicoBOImpl extends UnicastRemoteObject implements GradoAcademicoBO {

    private pe.edu.pucp.pixelpenguins.curricula.bo.GradoAcademicoBO gradoAcademicoBO;
    
    public GradoAcademicoBOImpl(Integer puerto) throws RemoteException {
        super(puerto);
        this.gradoAcademicoBO = new pe.edu.pucp.pixelpenguins.curricula.bo.GradoAcademicoBO();
    }

    @Override
    public Integer insertar(GradoAcademico gradoAcademico) throws RemoteException {
        return this.gradoAcademicoBO.insertar(gradoAcademico);
    }

    @Override
    public Integer modificar(GradoAcademico gradoAcademico) throws RemoteException {
        return this.gradoAcademicoBO.modificar(gradoAcademico);
    }

    @Override
    public Integer eliminar(GradoAcademico gradoAcademico) throws RemoteException {
        return this.gradoAcademicoBO.eliminar(gradoAcademico);
    }

    @Override
    public ArrayList<GradoAcademico> listarTodos() throws RemoteException {
        return this.gradoAcademicoBO.listarTodos();
    }

    @Override
    public GradoAcademico obtenerPorId(Integer idGradoAcademico) throws RemoteException {
        return this.gradoAcademicoBO.obtenerPorId(idGradoAcademico);
    }
    
}
