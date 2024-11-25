package pe.edu.pucp.pixelpenguins.rmi.interfacesImpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Date;
import pe.edu.pucp.pixelpenguins.anioacademico.model.Pago;
import pe.edu.pucp.pixelpenguins.rmi.interfaces.PagoBO;

public class PagoBOImpl extends UnicastRemoteObject implements PagoBO {

    private pe.edu.pucp.pixelpenguins.anioacademico.bo.PagoBO pagoBO;

    public PagoBOImpl(Integer puerto) throws RemoteException {
        super(puerto);
        this.pagoBO = new pe.edu.pucp.pixelpenguins.anioacademico.bo.PagoBO();
    }

    @Override
    public Integer insertar(Pago pago) throws RemoteException {
        return this.pagoBO.insertar(pago);
    }

    @Override
    public Integer modificar(Pago pago) throws RemoteException {
        return this.pagoBO.modificar(pago);
    }

    @Override
    public Integer eliminar(Pago pago) throws RemoteException {
        return this.pagoBO.eliminar(pago);
    }

    @Override
    public ArrayList<Pago> listarTodos() throws RemoteException {
        return this.pagoBO.listarTodos();
    }

    @Override
    public Pago obtenerPorId(Integer idPago) throws RemoteException {
        return this.pagoBO.obtenerPorId(idPago);
    }

    @Override
    public ArrayList<Pago> PagoXAlumnos(int idMatricula) throws RemoteException {
        return this.pagoBO.PagoXAlumnos(idMatricula);
    }

    @Override
    public ArrayList<Pago> listarTodosPorIdMatricula(int idMatricula) throws RemoteException {
        return this.pagoBO.listarTodosPorIdMatricula(idMatricula);
    }

    @Override
    public ArrayList<Pago> listarTodosPorGrado(int idGrado) throws RemoteException {
        return this.pagoBO.listarTodosPorGrado(idGrado);
    }

    @Override
    public ArrayList<Pago> listarPagosXFechaLimite(Date desde, Date hasta) throws RemoteException {
        return this.pagoBO.listarPagosXFechaLimite(desde, hasta);
    }

}
