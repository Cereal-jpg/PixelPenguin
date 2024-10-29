using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace SoftPixelPenguinsWA
{
    public partial class PlanEstudio : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            if (IsPostBack)
            {
                // Obtiene el valor seleccionado del DropDownList
                string selectedValue = ddlDepartamento.SelectedValue;

                // Verifica si la opción seleccionada es "Secundaria"
                if (selectedValue == "2") // El valor "2" corresponde a "Secundaria"
                {
                    // Redirige a la página deseada
                    Response.Redirect("SecundariaIM.aspx"); // Cambia "NombreDeLaPaginaSecundaria.aspx" al nombre de la página real.
                }
                else if (selectedValue == "1")
                {
                    Response.Redirect("PlanEstudio.aspx");
                }
            }

        }
    }
}