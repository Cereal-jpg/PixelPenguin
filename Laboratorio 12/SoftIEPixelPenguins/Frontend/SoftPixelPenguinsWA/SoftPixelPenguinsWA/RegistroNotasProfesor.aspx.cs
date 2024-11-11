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

                // Verifica si la página actual es el index
                if (Request.Url.AbsolutePath.EndsWith("IndexProfesor.aspx", StringComparison.OrdinalIgnoreCase))
                {
                    // Oculta el menú deseado
                    ContentPlaceHolder menuItem6 = (ContentPlaceHolder)Master.FindControl("menuItem6");
                    ContentPlaceHolder menuItem5 = (ContentPlaceHolder)Master.FindControl("menuItem5");
                    ContentPlaceHolder menuItem7 = (ContentPlaceHolder)Master.FindControl("menuItem7");
                    if (menuItem6 != null && menuItem5 != null)
                    {
                        menuItem6.Visible = false;
                        menuItem5.Visible = false;
                        menuItem7.Visible = false;
                    }
                }

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