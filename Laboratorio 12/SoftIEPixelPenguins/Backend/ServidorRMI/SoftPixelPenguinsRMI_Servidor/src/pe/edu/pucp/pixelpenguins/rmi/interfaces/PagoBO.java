package pe.edu.pucp.pixelpenguins.rmi.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;
import pe.edu.pucp.pixelpenguins.anioacademico.model.Pago;

public interface PagoBO extends Remote {
    
    public Integer insertar(Pago pago) throws RemoteException;
    
    public Integer modificar(Pago pago) throws RemoteException;
    
    public Integer eliminar(Pago pago) throws RemoteException;
    
    public ArrayList<Pago> listarTodos() throws RemoteException;
    
    public Pago obtenerPorId(Integer idPago) throws RemoteException;
    
    public ArrayList<Pago>  PagoXAlumnos(int idMatricula) throws RemoteException;
    
    public ArrayList<Pago> listarTodosPorIdMatricula(int idMatricula) throws RemoteException;
    
    public ArrayList<Pago> listarTodosPorGrado(int idGrado) throws RemoteException;
    
    public ArrayList<Pago> listarPagosXFechaLimite(Date desde, Date hasta) throws RemoteException;
    
}
