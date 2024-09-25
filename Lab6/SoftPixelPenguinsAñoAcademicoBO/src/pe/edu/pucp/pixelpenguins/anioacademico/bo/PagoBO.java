package pe.edu.pucp.pixelpenguins.anioacademico.bo;


import java.util.ArrayList;
import java.util.Date;
import pe.edu.pucp.pixelpenguins.anioacademico.dao.PagoDAO;
import pe.edu.pucp.pixelpenguins.anioacademico.daoimpl.PagoDAOImpl;
import pe.edu.pucp.pixelpenguins.anioacademico.model.EstadoDePago;
import pe.edu.pucp.pixelpenguins.anioacademico.model.Pago;
import pe.edu.pucp.pixelpenguins.anioacademico.model.TipoDeComprobante;
import pe.edu.pucp.pixelpenguins.anioacademico.model.TipoDePago;

public class PagoBO {
    private PagoDAO pagoDAO;
    
    public PagoBO(){
        this.pagoDAO = new PagoDAOImpl();
    }
    
    public int insertar(int idPago, Date fechaCreacion, Date fechaPago, double monto,
            TipoDePago tipoPago, EstadoDePago estado, TipoDeComprobante tipoDeComprobante,
            int idMatricula){
        
        Pago pago = new Pago(idPago, fechaCreacion, fechaPago, monto,
            tipoPago, estado, tipoDeComprobante, idMatricula);
        return pagoDAO.insertar(pago);
    }
    public int modificar(int idPago, Date fechaCreacion, Date fechaPago, double monto,
            TipoDePago tipoPago, EstadoDePago estado, TipoDeComprobante tipoDeComprobante,
            int idMatricula){
        Pago pago = new Pago(idPago, fechaCreacion, fechaPago, monto,
            tipoPago, estado, tipoDeComprobante, idMatricula);
        return pagoDAO.modificar(pago);
    }
    
    public int eliminar(int idPago, Date fechaCreacion, Date fechaPago, double monto,
            TipoDePago tipoPago, EstadoDePago estado, TipoDeComprobante tipoDeComprobante,
            int idMatricula){
        Pago pago = new Pago(idPago, fechaCreacion, fechaPago, monto,
            tipoPago, estado, tipoDeComprobante, idMatricula);
        return pagoDAO.eliminar(pago);
    }
    
    public ArrayList<Pago> listarTodos(){
        return pagoDAO.listarTodos();
    }
    
    public Pago obtenerPorId(int idPago){
        return pagoDAO.obtenerPorId(idPago);
    }
}
