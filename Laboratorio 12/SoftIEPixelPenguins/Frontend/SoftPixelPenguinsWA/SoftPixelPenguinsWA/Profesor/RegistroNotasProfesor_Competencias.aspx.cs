using SoftPixelPenguinsWA.ServicioWeb;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace SoftPixelPenguinsWA
{
    public partial class RegistroNotasProfesor_Competencias : System.Web.UI.Page
    {
        private CursoWSClient cursoBO = new CursoWSClient();
        private CompetenciaWSClient competenciaBO = new CompetenciaWSClient();
        curso curso = null;

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

                string id = Request.QueryString["idCurso"];
                if (id != null)
                {
                    int idCurso = Int32.Parse(id);
                    curso = cursoBO.obtenerCursoPorId(idCurso);
                    hTitulo.InnerHtml = "Registro de Notas - " + curso.codigoCurso + " - " + curso.nombre;
                    gvCompetencias.DataSource = competenciaBO.listarCompetenciasPorCurso(idCurso);
                    gvCompetencias.DataBind();
                }
            }
        }

        protected void btnRegistrarNota_Click(object sender, EventArgs e)
        {
            LinkButton lnk = (LinkButton)sender;
            int idCompetencia = int.Parse(lnk.CommandArgument);
            Response.Redirect("RegistroNotasProfesor_Alumnos.aspx?idCompetencia=" + idCompetencia);
        }

        protected void btnRegresar_Click(object sender, EventArgs e)
        {
            Response.Redirect("RegistroNotasProfesor.aspx");
        }

    }
}