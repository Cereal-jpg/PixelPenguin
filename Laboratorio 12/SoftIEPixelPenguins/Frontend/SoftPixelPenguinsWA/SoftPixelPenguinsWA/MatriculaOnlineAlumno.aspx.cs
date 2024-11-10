using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace SoftPixelPenguinsWA
{
    public partial class MatriculaOnlineAlumno : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {
                // Verifica si la página actual es el index
                if (Request.Url.AbsolutePath.EndsWith("MatriculaOnlineAlumno.aspx", StringComparison.OrdinalIgnoreCase))
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
            }
        }
        protected void btnIniciarMatricula_Click(object sender, EventArgs e)
        {
            Response.Redirect("MatriculaGenerica.aspx");
        }
    }
}