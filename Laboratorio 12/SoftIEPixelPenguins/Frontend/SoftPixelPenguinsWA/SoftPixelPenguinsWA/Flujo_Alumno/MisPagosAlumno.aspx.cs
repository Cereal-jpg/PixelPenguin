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

                gvPagos.DataSource = pagoBO.listarPagosXIdMatricula(idMatricula);
                gvPagos.DataBind();
            }
        }

        protected void lbVisualizar_Click(object sender, EventArgs e)
        {
            LinkButton btn = (LinkButton)sender;
            int idPago = int.Parse(btn.CommandArgument);
            Response.Redirect("VisualizarPagoAlumno.aspx?idPago=" + idPago);
        }


    }


}