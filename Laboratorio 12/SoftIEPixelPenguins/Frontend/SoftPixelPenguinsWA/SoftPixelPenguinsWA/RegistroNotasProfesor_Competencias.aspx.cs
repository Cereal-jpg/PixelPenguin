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