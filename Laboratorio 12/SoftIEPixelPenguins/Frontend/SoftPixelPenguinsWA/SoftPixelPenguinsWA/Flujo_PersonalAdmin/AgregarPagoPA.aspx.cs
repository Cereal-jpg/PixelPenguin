using SoftPixelPenguinsWA.ServicioWeb;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace SoftPixelPenguinsWA.Flujo_PersonalAdmin
{
    public partial class AgregarPagoPA : System.Web.UI.Page
    {
        PagoWSClient pagoBO = new PagoWSClient();
        pago pago = null;
        matricula matricula = null;
        MatriculaWSClient matriculaBO = new MatriculaWSClient();
        tipoDeComprobante tipoDeComprobante = new tipoDeComprobante();

        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {

            }
        }

        protected void btnRegresar_Click(object sender, EventArgs e)
        {
            Response.Redirect("GestionarPagosPA.aspx");
        }

        protected void btnGuardar_Click(object sender, EventArgs e)
        {
            matricula = matriculaBO.obtenerMatriculaPorId(int.Parse(txtMatri.Text));
            if(matricula == null)
            {
                return;
            }

            pago Newpago = new pago
            {
                fechaCreacion = DateTime.Parse(dtpFechaCreacion.Text),
                fechaCreacionSpecified = true,
                fechaPago = DateTime.Parse(dtpFechaCreacion.Text),
                fechaPagoSpecified = true,
                monto = Convert.ToDouble(txtMonto.Text),
                tipoPago = tipoDePago.TRANSFERENCIA_BANCARIA,
                estado = estadoDePago.PENDIENTE,
                tipoDeComprobante = tipoDeComprobante.FACTURA,
                matricula = matricula,
                comprobanteDePago = null
            };

            if(pago != null)
            {
                pagoBO.insertarPago(Newpago);
            }
            Response.Redirect("GestionarPagosPA.aspx");
        }
    }
}