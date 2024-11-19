using SoftPixelPenguinsWA.ServicioWeb;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Linq.Expressions;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace SoftPixelPenguinsWA.Flujo_PersonalAdmin
{
    public partial class EditarPago : System.Web.UI.Page
    {
        PagoWSClient pagoBO = new PagoWSClient();
        MatriculaWSClient matriculaBO = new MatriculaWSClient();
        UsuarioWSClient usuarioBO = new UsuarioWSClient();
        pago pago = null;
        protected void Page_Load(object sender, EventArgs e)
        {
         
                string idPago = Request.QueryString["idPago"];
                if (!string.IsNullOrEmpty(idPago))
                {
                    CargarDatosPago(int.Parse(idPago));
                }
                else
                {
                    lblMensaje.Text = "No se proporcionó un ID de pago válido.";
                    lblMensaje.CssClass = "alert alert-danger";
                    lblMensaje.Visible = true;
                }
            
        }

        private void CargarDatosPago(int idPago)
        {
            // Simula la obtención de datos desde la base de datos.

             pago = pagoBO.obtenerPagoPorId(idPago); // Implementa este método.

            if (pago != null)
            {
                matricula matricula = matriculaBO.obtenerMatriculaPorId(pago.matricula.idMatricula);
                usuario usuario = usuarioBO.obtenerUsuarioPorId(matricula.fidAlumno);

                txtIdPago.Text = pago.idPago.ToString();
                txtNombreAlumno.Text = usuario.nombreCompleto;
                txtMonto.Text = pago.monto.ToString("C");
                txtFecha.Text = pago.fechaPago.ToString("dd/MM/yyyy");
                
            }
            else
            {
                lblMensaje.Text = "No se encontró el pago con el ID proporcionado.";
                lblMensaje.CssClass = "alert alert-warning";
                lblMensaje.Visible = true;
            }
        }

        protected void btnGuardar_Click(object sender, EventArgs e)
        {
            int idPago = int.Parse(txtIdPago.Text);
            string nuevoEstado = ddlEstado.SelectedItem.Value;
           

            Console.WriteLine("Estado seleccionado: " + nuevoEstado);

            switch (nuevoEstado)
            {
                case "PENDIENTE":
                    pago.estado = estadoDePago.PENDIENTE;
                    break;

                case "CANCELADO":
                    pago.estado = estadoDePago.CANCELADO;
                    break;

                case "ATRASADO":
                    pago.estado = estadoDePago.ATRASADO;
                    break;
            }


            pagoBO.modificarPago(pago);
            Response.Redirect("GestionarPagosPA.aspx");
            // Actualiza el estado del pago en la base de datos.
            /* bool actualizado = ActualizarEstadoPago(idPago, nuevoEstado); // Implementa este método.

             if (actualizado)
             {
                 lblMensaje.Text = "El estado del pago se actualizó correctamente.";
                 lblMensaje.CssClass = "alert alert-success";
             }
             else
             {
                 lblMensaje.Text = "Hubo un problema al actualizar el estado del pago.";
                 lblMensaje.CssClass = "alert alert-danger";
             }

             lblMensaje.Visible = true;
            */
        }

        protected void lnkDescargarComprobante_Click(object sender, EventArgs e)
        {
            if (pago != null)
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

        protected void btnCancelar_Click(object sender, EventArgs e)
        {
            Response.Redirect("GestionarPagosPA.aspx");
        }

    }
}