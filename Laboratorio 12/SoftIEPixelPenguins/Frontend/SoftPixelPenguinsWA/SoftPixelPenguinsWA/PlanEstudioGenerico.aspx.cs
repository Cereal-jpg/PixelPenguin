using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace SoftPixelPenguinsWA
{
    public partial class PlanEstudioGenerico : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {
                // Inicializar la pagina con la iamgen de primaria
                imgHorario.ImageUrl = "Images/Primaria.png";
            }
        }

        protected void ddlDepartamento_SelectedIndexChanged(object sender, EventArgs e)
        {
            if (ddlDepartamento.SelectedValue == "1")
            {
                imgHorario.ImageUrl = "Images/Primaria.png";
            }
            else if (ddlDepartamento.SelectedValue == "2")
            {
                imgHorario.ImageUrl = "Images/Secundaria.png";
            }
        }

        protected void VerCompetencias_Click(object sender, EventArgs e)
        {
            Response.Redirect("VerCompetenciasGenerica.aspx");
        }
    }
}