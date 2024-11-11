using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace SoftPixelPenguinsWA
{
    public partial class ReporteNotasAlumno : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
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
        }

        protected void btnVerNotas_Click(object sender, EventArgs e)
        {

        }
    }
}