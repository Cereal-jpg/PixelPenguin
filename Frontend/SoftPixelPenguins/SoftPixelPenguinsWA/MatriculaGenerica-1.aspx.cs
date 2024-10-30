using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace SoftPixelPenguinsWA
{
    public partial class MatriculaGenerica_1 : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {

        }
        protected void btnTerminarProceso_Click(object sender, EventArgs e)
        {
            // Redirigir a IndexAlumno.aspx
            Response.Redirect("Login.aspx");
        }
    }
}