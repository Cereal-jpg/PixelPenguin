using SoftPixelPenguinsWA.ServicioWeb;
using System;
using System.Collections.Generic;
using System.EnterpriseServices;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace SoftPixelPenguinsWA
{
    public partial class VisualizarPago : System.Web.UI.Page
    {
        PagoWSClient pagoBO = new PagoWSClient();
        pago pago = null;
        protected void Page_Load(object sender, EventArgs e)
        {
            string idPago = Request.QueryString["idPago"];
            if(idPago != null)
            {
                pago = pagoBO.obtenerPagoPorId(Int32.Parse(idPago));
                txtFechaCreacion.Text = pago.fechaCreacion.ToString();
                txtFechaPago.Text = pago.fechaPago.ToString();
                txtTipoComprobante.Text = pago.tipoDeComprobante.ToString();
                txtEstadoPago.Text = pago.estado.ToString();
                txtTipodePago.Text = pago.tipoPago.ToString();
            }
        }
        protected void lnkDescargarComprobante_Click(object sender, EventArgs e)
        {
            if(pago != null)
            {
                byte[] archivoBytes = pago.comprobanteDePago;
                if (archivoBytes != null && archivoBytes.Length > 0)
                {
                    Response.Clear();
                    Response.ContentType = "application/pdf";
                    Response.AddHeader("Content-Disposition", "attachment; filename=boucherDePago.pdf");
                    Response.BinaryWrite(archivoBytes);
                    Response.End();
                }
            }
        }

    }
}