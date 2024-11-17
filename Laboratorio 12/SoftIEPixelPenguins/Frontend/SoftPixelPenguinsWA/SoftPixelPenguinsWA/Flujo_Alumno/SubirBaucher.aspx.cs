using SoftPixelPenguinsWA.ServicioWeb;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace SoftPixelPenguinsWA.Flujo_Alumno
{
    public partial class SubirBaucher : System.Web.UI.Page
    {
        PagoWSClient pagoBO = new PagoWSClient();
        pago pago;

        protected void Page_Load(object sender, EventArgs e)
        {
           
                string idPago = Request.QueryString["idPago"];
                if (!string.IsNullOrEmpty(idPago))
                {
                    try
                    {
                        pago = pagoBO.obtenerPagoPorId(Int32.Parse(idPago));
                        if (pago == null)
                        {
                            MostrarMensajeError("No se encontró el pago con el ID proporcionado.");
                            Response.Redirect("MisPagosAlumno.aspx");
                        }
                    }
                    catch (Exception ex)
                    {
                        MostrarMensajeError("Error al obtener el pago: " + ex.Message);
                        Response.Redirect("MisPagosAlumno.aspx");
                    }
                }
                else
                {
                    MostrarMensajeError("El ID de pago no es válido.");
                    Response.Redirect("MisPagosAlumno.aspx");
                }
            }
        

        protected void prevSection(object sender, EventArgs e)
        {
            Response.Redirect("MisPagosAlumno.aspx");
        }

        protected void btnGuardar_Click(object sender, EventArgs e)
        {
            if (pago != null)
            {
                try
                {
                    pago.comprobanteDePago = fileBaucher.FileBytes;
                    pagoBO.modificarPago(pago);
                    MostrarMensajeExito("El baucher se ha subido correctamente.");
                }
                catch (Exception ex)
                {
                    MostrarMensajeError("Error al guardar el baucher: " + ex.Message);
                }
            }
            else
            {
                MostrarMensajeError("No se pudo guardar el baucher porque el pago no está inicializado.");
            }
        }

        private void MostrarMensajeError(string mensaje)
        {
            // Implementa tu lógica para mostrar mensajes de error en la página.
            ClientScript.RegisterStartupScript(this.GetType(), "Error", $"alert('{mensaje}');", true);
        }

        private void MostrarMensajeExito(string mensaje)
        {
            // Implementa tu lógica para mostrar mensajes de éxito en la página.
            ClientScript.RegisterStartupScript(this.GetType(), "Exito", $"alert('{mensaje}');", true);
        }
    }
}