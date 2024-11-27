using SoftPixelPenguinsWA.ServicioWeb;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace SoftPixelPenguinsWA
{
    public partial class ReportesPA : System.Web.UI.Page
    {
        GradoAcademicoWSClient gradoBO = new GradoAcademicoWSClient();
        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {
                if (Session["idAdmin"] != null) panelGestionarUsuarios.Visible = true;
                cargarGrados();
            }
        }

        private void cargarGrados()
        {
            BindingList<gradoAcademico> grados = new BindingList<gradoAcademico>(gradoBO.listarTodosGradosAcademicos());
            foreach (gradoAcademico grado in grados)
            {
                string textoItem = $"{grado.numeroGrado}° {grado.nivel}";
                string valorItem = grado.idGradoAcademico.ToString();
                ddlGrados.Items.Add(new ListItem(textoItem, valorItem));
            }
            if (ddlGrados.Items.Count > 0)
            {
                ddlGrados.SelectedIndex = 0;
            }
        }

         protected void btnEmitirReporte_Click(object sender, EventArgs e)
         {
            if (rbMatriculas.Checked)
            {
                Response.Redirect("ReporteGradoPA.aspx");
            }
            else if (rbPensiones.Checked)
            {
                Response.Redirect("ReportePagosRA.aspx?idGradoAcademico=" + ddlGrados.SelectedValue);
            } 
            else if (rbNotas.Checked)
            {
                Response.Redirect("ReporteNotasPA.aspx?idGradoAcademico=" + ddlGrados.SelectedValue);
            }
         }

    }
}