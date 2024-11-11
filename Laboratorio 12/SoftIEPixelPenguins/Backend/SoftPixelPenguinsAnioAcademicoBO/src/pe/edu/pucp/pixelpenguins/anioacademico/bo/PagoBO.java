package pe.edu.pucp.pixelpenguins.anioacademico.bo;

import java.util.ArrayList;
import pe.edu.pucp.pixelpenguins.anioacademico.dao.PagoDAO;
import pe.edu.pucp.pixelpenguins.anioacademico.daoImp.PagoDAOImpl;
import pe.edu.pucp.pixelpenguins.anioacademico.model.Pago;

public class PagoBO {
    
    private PagoDAO pagoDAO;
    
    public PagoBO(){
        this.pagoDAO = new PagoDAOImpl();
    }
    
    public Integer insertar(Pago pago) {
        return this.pagoDAO.insertar(pago);
    }
    
    public Integer modificar(Pago pago) {
        return this.pagoDAO.modificar(pago);
    }
    
    public Integer eliminar(Pago pago) {
        return this.pagoDAO.eliminar(pago);
    }
    
    public ArrayList<Pago> listarTodos(){
        return this.pagoDAO.listarTodos();
    }
    
    public Pago obtenerPorId(Integer idPago){
        return this.pagoDAO.obtenerPorId(idPago);
    }
    
    public Pago  PagoXAlumnos(int idMatricula){
        return this.pagoDAO.PagoXAlumnos(idMatricula);
    }
    public ArrayList<Pago> listarTodosPorIdMatricula(int idMatricula){
        return this.pagoDAO.listarTodosXIdMatricula(idMatricula);
    }
    public ArrayList<Pago> listarTodosPorGrado(int idGrado){
        return this.pagoDAO.listarTodosPorGrado(idGrado);
    }
}
