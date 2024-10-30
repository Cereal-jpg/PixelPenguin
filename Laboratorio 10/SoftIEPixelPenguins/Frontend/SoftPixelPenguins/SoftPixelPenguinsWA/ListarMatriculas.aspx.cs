using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace SoftPixelPenguinsWA
{
    public partial class ListarMatriculas : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {

        }

        protected void lbRegistrar_Click(object sender, EventArgs e)
        {
            //Response.Redirect("RegistrarMatricula.aspx");
        }
        protected void lbVisualizar_Click(object sender, EventArgs e)
        {
            //int idMatricula = Int32.Parse(((LinkButton)sender).CommandArgument);
            //Response.Redirect("RegistrarEvento.aspx?accion=ver&idMatricula=" + idMatricula);
        }
    }
}