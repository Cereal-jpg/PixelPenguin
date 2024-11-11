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
    public partial class GestionarPlanesPA : System.Web.UI.Page
    {
        GradoAcademicoWSClient gradoBO = new GradoAcademicoWSClient();
        CursoWSClient cursoBO = new CursoWSClient();
        CompetenciaWSClient competenciaBO = new CompetenciaWSClient();
        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {
                cargarGrados();
            }
            cargarCursos();
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
        private void cargarCursos()
        {
            if (!string.IsNullOrEmpty(ddlGrados.SelectedValue))
            {
                int idGrado = int.Parse(ddlGrados.SelectedValue);
                gvCursos.DataSource = cursoBO.listarCursosPorGrado(idGrado);
                gvCursos.DataBind();
            }
        }
        protected void lnkAgregarCurso_Click(object sender, EventArgs e)
        {
            string idGradoAcademico = ddlGrados.SelectedValue;
            if (!string.IsNullOrEmpty(idGradoAcademico))
            {
                Response.Redirect("GestionarCursosPlanPA.aspx?idGradoAcademico=" + idGradoAcademico);
            }
        }
        protected void lbEditar_Click(object sender, EventArgs e)
        {
            LinkButton lnk = (LinkButton)sender;
            int idCurso = int.Parse(lnk.CommandArgument);
            Response.Redirect("GestionarCursosPlanPA.aspx?idCurso=" + idCurso + "&accion=modificar");
        }
        protected void lbEliminar_Click(object sender, EventArgs e)
        {
            LinkButton lnk = (LinkButton)sender;
            int idCurso = int.Parse(lnk.CommandArgument);
            curso curso = new curso { idCurso = idCurso, idCursoSpecified = true };
            List<competencia> competencias = (competenciaBO.listarCompetenciasPorCurso(idCurso) ?? Array.Empty<competencia>()).ToList();
            if (competencias.Count > 0)
            {
                foreach (competencia competencia in competencias) competenciaBO.eliminarCompetencia(competencia);
            }
            cursoBO.eliminarCurso(curso);
            Response.Redirect("GestionarPlanesPA.aspx");
        }
    }
}