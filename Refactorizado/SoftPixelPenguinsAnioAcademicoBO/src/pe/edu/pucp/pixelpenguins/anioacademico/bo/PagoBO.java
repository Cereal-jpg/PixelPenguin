package pe.edu.pucp.pixelpenguins.anioacademico.bo;

import java.util.ArrayList;
import java.util.Date;
import pe.edu.pucp.pixelpenguins.anioacademico.dao.PagoDAO;
import pe.edu.pucp.pixelpenguins.anioacademico.daoImp.PagoDAOImpl;
import pe.edu.pucp.pixelpenguins.anioacademico.model.EstadoDePago;
import pe.edu.pucp.pixelpenguins.anioacademico.model.Matricula;
import pe.edu.pucp.pixelpenguins.anioacademico.model.Pago;
import pe.edu.pucp.pixelpenguins.anioacademico.model.TipoDeComprobante;
import pe.edu.pucp.pixelpenguins.anioacademico.model.TipoDePago;

public class PagoBO {
    
     private PagoDAO pagoDAO;
    
    public PagoBO(){
        this.pagoDAO = new PagoDAOImpl();
    }
 
    public Integer insertar(Integer idMatricula,Date fechaCreacion, Date fechaPago, double monto,
            TipoDePago tipoPago, EstadoDePago estado, TipoDeComprobante tipoDeComprobante){
        Pago pago = this.crearPago(idMatricula,fechaCreacion, fechaPago, monto, tipoPago, estado, tipoDeComprobante);
        return this.pagoDAO.insertar(pago);
    }
    
    public Integer modificar(Integer idPago, Integer idMatricula,Date fechaCreacion,
            Date fechaPago, double monto, TipoDePago tipoPago, EstadoDePago estado,
            TipoDeComprobante tipoDeComprobante){
        Pago pago = this.crearPago(idMatricula, fechaCreacion, fechaPago, monto, tipoPago, estado, tipoDeComprobante);
        pago.setIdPago(idPago);  
        return this.pagoDAO.modificar(pago);
    }
    
    public Integer eliminar(Integer idMatricula, Integer idPago){
        Pago pago = new Pago();
        pago.setIdPago(idPago);
        return this.pagoDAO.eliminar(pago);
    }
    
    public ArrayList<Pago> listarTodos(){
        return this.pagoDAO.listarTodos();
    }
    
    public Pago obtenerPorId(Integer idPago){
        return this.pagoDAO.obtenerPorId(idPago);
    }
    
    private Pago crearPago(Integer idMatricula, Date fechaCreacion, Date fechaPago, 
            double monto, TipoDePago tipoPago, EstadoDePago estado, TipoDeComprobante tipoDeComprobante){
        Matricula matricula = new Matricula();
        matricula.setIdMatricula(idMatricula);
        
        Pago pago = new Pago();
        pago.setMatricula(matricula);
        pago.setFechaPago(fechaPago);
        pago.setMonto(monto);
        pago.setTipoPago(tipoPago);
        pago.setEstado(estado);
        pago.setTipoDeComprobante(tipoDeComprobante);
        pago.setFechaCreacion(fechaCreacion);
        return pago;
    } 
    
}
