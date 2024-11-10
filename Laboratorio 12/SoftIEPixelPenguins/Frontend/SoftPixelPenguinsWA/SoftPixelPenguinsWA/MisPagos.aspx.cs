using SoftPixelPenguinsWA.ServicioWeb;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace SoftPixelPenguinsWA
{
    public partial class MisPagos : System.Web.UI.Page
    {
        PagoWSClient pagoBO = new PagoWSClient();
        protected void Page_Load(object sender, EventArgs e)
        {
            int idMatricula = (int)Session["idMatriculaAlumnoLogueado"];
            if (!IsPostBack)
            {
                gvPagos.DataSource = pagoBO.listarPagosXIdMatricula(idMatricula);
                gvPagos.DataBind();
            }
        }

        protected void lbVisualizar_Click(object sender, EventArgs e)
        {
            LinkButton btn = (LinkButton)sender;
            int idPago = int.Parse(btn.CommandArgument);
            Response.Redirect("VisualizarPago.aspx?idPago=" + idPago);
        }

        
    }
    
    
}