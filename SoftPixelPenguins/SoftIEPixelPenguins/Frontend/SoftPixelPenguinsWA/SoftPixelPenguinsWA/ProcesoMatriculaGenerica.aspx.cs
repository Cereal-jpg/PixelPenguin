using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace SoftPixelPenguinsWA
{
    public partial class ProcesoMatriculaGenerica : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {

        }
        protected void IniciarMatricula_Click(object sender, EventArgs e)
        {
            Response.Redirect("MatriculaGenerica.aspx");
        }

    }
}





