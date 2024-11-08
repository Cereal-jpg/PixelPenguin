
package pe.edu.pucp.pixelpenguins.anioacademico.model;

import java.util.Date;

public class Pago {
    private Integer idPago;
    private Date fechaCreacion;
    private Date fechaPago;
    private double monto;
    private TipoDePago tipoPago;
    private EstadoDePago estado;
    private TipoDeComprobante tipoDeComprobante;
    private Matricula matricula; // tendrá un FK fid_matricula en la BD
    private byte[] comprobanteDePago;

    public Pago(){}
    
    public Pago(Integer idPago,Date fechaCreacion, Date fechaPago, double monto,
            TipoDePago tipoPago, EstadoDePago estado, TipoDeComprobante tipoDeComprobante,
            Matricula matricula,byte[] comprobanteDePago) {
        this.idPago = idPago;
        this.fechaCreacion = fechaCreacion;
        this.fechaPago = fechaPago;
        this.monto = monto;
        this.tipoPago = tipoPago;
        this.estado = estado;
        this.tipoDeComprobante = tipoDeComprobante;
        this.matricula = matricula;
        this.comprobanteDePago=comprobanteDePago;
    }

    public Integer getIdPago() {
        return idPago;
    }

    public void setIdPago(Integer idPago) {
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

    public Matricula getMatricula() {
        return matricula;
    }

    public void setMatricula(Matricula matricula) {
        this.matricula = matricula;
    }

    public byte[] getComprobanteDePago() {
        return comprobanteDePago;
    }

    public void setComprobanteDePago(byte[] comprobanteDePago) {
        this.comprobanteDePago = comprobanteDePago;
    }
    
}
