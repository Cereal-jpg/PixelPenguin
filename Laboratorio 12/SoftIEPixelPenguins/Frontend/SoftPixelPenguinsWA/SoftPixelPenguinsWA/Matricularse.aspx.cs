using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace SoftPixelPenguinsWA
{
    public partial class Matricularse : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {

        }

        protected void IniciarProceso_Click(object sender, EventArgs e)
        {
            Response.Redirect("ProcesoMatricula.aspx");
        }

        protected void PlanEstudios_Click(object sender, EventArgs e)
        {
            Response.Redirect("PlanEstudio.aspx");
        }
    }
}