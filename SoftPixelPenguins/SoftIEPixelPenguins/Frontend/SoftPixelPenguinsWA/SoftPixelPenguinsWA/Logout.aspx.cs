using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace SoftPixelPenguinsWA
{
    public partial class Logout : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            // Limpia todas las variables de sesión
            Session.Clear();

            // Opcional: Abandona la sesión actual
            Session.Abandon();

            // Redirige al usuario a la página de inicio de sesión
            Response.Redirect("~/Login.aspx");
        }

    }
}