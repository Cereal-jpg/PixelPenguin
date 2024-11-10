using SoftPixelPenguinsWA.ServicioWeb;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace SoftPixelPenguinsWA
{
    public partial class RegistroNotasProfesor : System.Web.UI.Page
    {
        private CursoWSClient cursoBO = new CursoWSClient();
        private GradoAcademicoWSClient gradoBO = new GradoAcademicoWSClient();

        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {
                cargarCursos();
            }
        }

        private void cargarCursos()
        {
            if(Session["idProfesorLogueado"] != null)
            {
                int idProfesor = (int)Session["idProfesorLogueado"];
                List<curso> cursos = (cursoBO.listarCursosPorProfesor(idProfesor) ?? Array.Empty<curso>()).ToList();
                if (cursos.Count > 0)
                {
                    foreach (curso curso in cursos) curso.gradoAcademico = gradoBO.obtenerGradoAcademicoPorId(curso.gradoAcademico.idGradoAcademico);
                    gvCursos.DataSource = cursos;
                    gvCursos.DataBind();
                }
            }
        }

        protected void btnVerDetalle_Click(object sender, EventArgs e)
        {
            LinkButton lnk = (LinkButton)sender;
            int idCurso = int.Parse(lnk.CommandArgument);
            Response.Redirect("RegistroNotasProfesor_Competencias.aspx?idCurso=" + idCurso);
        }
    }
}