using SoftPixelPenguinsWA.ServicioWeb;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace SoftPixelPenguinsWA
{
    public partial class CursosYHorariosPA : System.Web.UI.Page
    {
        private ProfesorWSClient profesorBO = new ProfesorWSClient();
        List<profesor> profesores = null;

        protected void Page_Load(object sender, EventArgs e)
        {
            cargarProfesores();
        }

        private void cargarProfesores()
        {
            profesores = (profesorBO.listarProfesoresPorNombre(txtBuscarProfesor.Text) ?? Array.Empty<profesor>()).ToList();
            gvProfesores.DataSource = profesores;
            gvProfesores.DataBind();
        }
        protected void lbBuscar_Click(object sender, EventArgs e)
        {
            cargarProfesores();
        }

        protected void btnAgregarCursos_Click(object sender, EventArgs e)
        {
            LinkButton lnk = (LinkButton)sender;
            int idProfesor = int.Parse(lnk.CommandArgument);
            Response.Redirect("CursosPorProfesorPA.aspx?idProfesor=" + idProfesor);
        }

        protected void gvProfesores_PageIndexChanging(object sender, GridViewPageEventArgs e)
        {
            gvProfesores.PageIndex = e.NewPageIndex;
            gvProfesores.DataSource = profesores;
            gvProfesores.DataBind();
        }

    }
}