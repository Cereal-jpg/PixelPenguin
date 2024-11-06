using SoftPixelPenguinsWA.SoftPixelPenguinsWS;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;


namespace SoftPixelPenguinsWA
{

    public partial class IndexAlumno : System.Web.UI.Page
    {
        private MatriculaWSClient matriculaBO;
        private PagoWSClient pagoBO;
        protected void Page_Load(object sender, EventArgs e)
        {
            matriculaBO = new MatriculaWSClient();
            pagoBO = new PagoWSClient();

            int idUsuario = (int)Session["idAlumnoLogueado"];


            if (!IsPostBack)
            {
                // Define la fecha de pago
                int idMatricula = matriculaBO.obtenerMatriculaPorIdAlumno(idUsuario);
                pago pago = pagoBO.PagoXIdMatricula(idMatricula);



                // Calcula la cantidad de días restantes para el pago
                if (pago != null)
                {
                    int diasRestantes = (pago.fechaPago - DateTime.Now).Days;

                    // Construye el texto para mostrar la fecha y los días restantes
                    string textoFechaPago = pago.fechaPago.ToString("dd/MM/yyyy");
                    string textoDiasRestantes = diasRestantes > 0
                        ? $" (faltan {diasRestantes} días)"
                        : " (El pago es hoy o ha pasado)";

                    // Asigna el texto al Literal
                    fechaPagoLiteral.Text = $"{textoFechaPago}{textoDiasRestantes}";
                    Estado.Text = pago.estado.ToString();
                }
                else
                {
                    Estado.Text = "No tiene pagos pendientes";
                    fechaPagoLiteral.Text = "--/--/--";
                }
            }
        }
    }
}
