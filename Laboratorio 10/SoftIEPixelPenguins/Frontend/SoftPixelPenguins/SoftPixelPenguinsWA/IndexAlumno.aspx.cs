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
        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {
                // Define la fecha de pago
                DateTime fechaPago = new DateTime(2024, 11, 15); // Ejemplo de fecha

                // Calcula la cantidad de días restantes para el pago
                int diasRestantes = (fechaPago - DateTime.Now).Days;

                // Construye el texto para mostrar la fecha y los días restantes
                string textoFechaPago = fechaPago.ToString("dd/MM/yyyy");
                string textoDiasRestantes = diasRestantes > 0
                    ? $" (faltan {diasRestantes} días)"
                    : " (El pago es hoy o ha pasado)";

                // Asigna el texto al Literal
                fechaPagoLiteral.Text = $"{textoFechaPago}{textoDiasRestantes}";
            }
        }
    }
}
