
package pe.edu.pucp.pixelpenguins.anioacademico.model;

import java.util.Date;
import pe.edu.pucp.pixelpenguins.institucioneducativa.model.IConsultable;

public class Pago implements IConsultable{
    private int idPago;
    private Date fechaCreacion;
    private Date fechaPago;
    private double monto;
    private TipoDePago tipoPago;
    private EstadoDePago estado;
    private TipoDeComprobante tipoDeComprobante;
    private Integer idMatricula;

    public Pago(int idPago, Date fechaCreacion, Date fechaPago, double monto,
            TipoDePago tipoPago, EstadoDePago estado, TipoDeComprobante tipoDeComprobante,
            int idMatricula) {
        this.idPago = idPago;
        this.fechaCreacion = fechaCreacion;
        this.fechaPago = fechaPago;
        this.monto = monto;
        this.tipoPago = tipoPago;
        this.estado = estado;
        this.tipoDeComprobante = tipoDeComprobante;
        this.idMatricula = idMatricula;
    }

    public Pago() {}
    

    public int getIdPago() {
        return idPago;
    }

    public void setIdPago(int idPago) {
        this.idPago = idPago;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(Date fechaPago) {
        this.fechaPago = fechaPago;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public TipoDePago getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(TipoDePago tipoPago) {
        this.tipoPago = tipoPago;
    }

    public EstadoDePago getEstado() {
        return estado;
    }

    public void setEstado(EstadoDePago estado) {
        this.estado = estado;
    }

    public TipoDeComprobante getTipoDeComprobante() {
        return tipoDeComprobante;
    }

    public void setTipoDeComprobante(TipoDeComprobante tipoDeComprobante) {
        this.tipoDeComprobante = tipoDeComprobante;
    }

    public Integer getIdMatricula() {
        return idMatricula;
    }

    public void setIdMatricula(Integer idMatricula) {
        this.idMatricula = idMatricula;
    }
    
    @Override
    public String consultarInformacion() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
