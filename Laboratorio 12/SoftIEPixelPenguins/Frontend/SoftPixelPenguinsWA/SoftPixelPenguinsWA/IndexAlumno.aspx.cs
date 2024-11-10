using SoftPixelPenguinsWA.ServicioWeb;
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
                // Verifica si la página actual es el index
                if (Request.Url.AbsolutePath.EndsWith("IndexAlumno.aspx", StringComparison.OrdinalIgnoreCase))
                {
                    // Oculta el menú deseado
                    ContentPlaceHolder menuItem6 = (ContentPlaceHolder)Master.FindControl("menuItem6");
                    ContentPlaceHolder menuItem7 = (ContentPlaceHolder)Master.FindControl("menuItem7");
                    if (menuItem6 != null && menuItem7 != null)
                    {
                        menuItem6.Visible = false;
                        menuItem7.Visible = false;
                    }
                }

                // Define la fecha de pago
                int idMatricula = matriculaBO.obtenerMatriculaPorIdAlumno(idUsuario);
                pago pago = pagoBO.PagoXIdMatricula(idMatricula);

                Session["idMatriculaAlumnoLogueado"] = idMatricula;

                // Valida si cuenta con pagos 
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
                    // Asigna el texto al Literal
                    fechaPagoLiteral.Text = "--/--/--";
                    Estado.Text = "No hay pagos por pagar";
                }

                
            }
        }
    }
}