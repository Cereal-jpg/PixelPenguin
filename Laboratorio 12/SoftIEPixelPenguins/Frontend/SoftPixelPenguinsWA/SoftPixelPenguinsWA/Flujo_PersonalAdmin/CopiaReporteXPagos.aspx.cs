using SoftPixelPenguinsWA.ServicioWeb;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace SoftPixelPenguinsWA.Flujo_PersonalAdmin
{
    public partial class WebForm1 : System.Web.UI.Page
    {
        GradoAcademicoWSClient gradoBO = new GradoAcademicoWSClient();
        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {
                if (Session["idAdmin"] != null) panelGestionarUsuarios.Visible = true;
                gvGrados.DataSource = gradoBO.listarTodosGradosAcademicos();
                gvGrados.DataBind();
            }
        }
        protected void gvGrados_PageIndexChanging(object sender, GridViewPageEventArgs e)
        {
            // Establece el nuevo índice de página
            gvGrados.PageIndex = e.NewPageIndex;

            // Vuelve a enlazar los datos
            BindGrid(); // Asegúrate de que este método exista y cargue los datos en el GridView
        }
        private void BindGrid()
        {
            gvGrados.DataSource = gradoBO.listarTodosGradosAcademicos(); ;
            gvGrados.DataBind();
            gradoAcademico a;

        }
        protected void lbGenerar_Click(object sender, EventArgs e)
        {
            LinkButton btn = (LinkButton)sender;
            int idGrado = int.Parse(btn.CommandArgument);
            Response.Redirect("CopiaReportPagosRA.aspx?idGradoAcademico=" + idGrado);
        }
    }
}