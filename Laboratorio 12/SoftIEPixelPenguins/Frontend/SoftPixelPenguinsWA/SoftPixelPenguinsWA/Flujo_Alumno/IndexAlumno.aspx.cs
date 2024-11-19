using SoftPixelPenguinsWA.ServicioWeb;
using System;
using System.Collections;
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
                if (Session["idAlumnoLogueado"] != null)
                {
                    // Verifica si la página actual es el index
                    if (Request.Url.AbsolutePath.EndsWith("MiPerfilAlumno.aspx", StringComparison.OrdinalIgnoreCase))
                    {
                        // Oculta el menú deseado
                        ContentPlaceHolder menuItem7 = (ContentPlaceHolder)Master.FindControl("menuItem7");
                        if (menuItem7 != null)
                        {
                            menuItem7.Visible = false;
                        }
                    }
                }

                // Define la fecha de pago
                int idMatricula = matriculaBO.obtenerMatriculaPorIdAlumno(idUsuario);

                List<pago> listaPagos = pagoBO.PagoXIdMatricula(idMatricula).ToList();

                Session["idMatriculaAlumnoLogueado"] = idMatricula;
                string textoFechaPago = "";
                string textoDiasRestantes = "";

                if (listaPagos != null && listaPagos.Count > 0)
                {
                    foreach (pago pago in listaPagos)
                    {
                        int diasRestantes = (pago.fechaPago - DateTime.Now).Days;
                        textoFechaPago = pago.fechaPago.ToString("dd/MM/yyyy");
                        textoDiasRestantes = diasRestantes > 0
                            ? $" (faltan {diasRestantes} días)"
                            : " (El pago es hoy o ha pasado)";
                        fechaPagoLiteral.Text += $"{textoFechaPago}{textoDiasRestantes}\n" ;

                    }
                }
                else
                {
                    textoFechaPago = "Usted no tiene pagos cercanos.";
                    fechaPagoLiteral.Text = $"{textoFechaPago}";
                    Estado.Text = "";
                }

                // Valida si cuenta con pagos 
                    /*if (pago != null)
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
                        string textoFechaPago = "Usted no tiene pagos cercanos.";
                        fechaPagoLiteral.Text = $"{textoFechaPago}";
                        Estado.Text = "";
                    }

                    */
            }
        }
    }
}