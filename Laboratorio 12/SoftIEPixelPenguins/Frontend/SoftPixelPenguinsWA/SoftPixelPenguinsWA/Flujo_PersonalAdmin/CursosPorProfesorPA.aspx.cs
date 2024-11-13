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
    public partial class CursosPorProfesorPA : System.Web.UI.Page
    {
        private CursoWSClient cursoBO = new CursoWSClient();
        private GradoAcademicoWSClient gradoBO = new GradoAcademicoWSClient();
        private int idProfesor;

        protected void Page_Load(object sender, EventArgs e)
        {
            string id = Request.QueryString["idProfesor"];
            idProfesor = int.Parse(id);
            if (!IsPostBack)
            {
                if (Session["idAdmin"] != null) panelGestionarUsuarios.Visible = true;
                cargarGrados();
                cargarCursos();
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
            ddlGrados.Items.Insert(0, new ListItem("Seleccionar Grado", ""));
        }

        private void cargarCursos()
        {
            List<curso> cursos = (cursoBO.listarCursosPorProfesor(idProfesor) ?? Array.Empty<curso>()).ToList();
            if (cursos.Count > 0)
            {
                foreach (curso curso in cursos) curso.gradoAcademico = gradoBO.obtenerGradoAcademicoPorId(curso.gradoAcademico.idGradoAcademico);
                gvCursos.DataSource = cursos;
                gvCursos.DataBind();
            }
        }

        protected void lbBuscar_Click(object sender, EventArgs e)
        {
            if (!string.IsNullOrEmpty(ddlGrados.SelectedValue))
            {
                int idGrado = int.Parse(ddlGrados.SelectedValue);
                gvCursosDisponibles.DataSource = cursoBO.listarCursosPorGrado(idGrado);
                gvCursosDisponibles.DataBind();
            }
            ScriptManager.RegisterStartupScript(this, this.GetType(), "OpenModalScript", "openModal();", true);
        }

        protected void btnSeleccionarCurso_Click(object sender, EventArgs e)
        {
            LinkButton btn = (LinkButton)sender;
            string id = btn.CommandArgument;

            if(id != null)
            {
                int idCurso = int.Parse(id);
                curso curso = cursoBO.obtenerCursoPorId(idCurso);
                curso.fid_Profesor = idProfesor;
                cursoBO.modificarCurso(curso);
                cargarCursos();
            }
        }

        protected void btnRegresar_Click(object sender, EventArgs e)
        {
            Response.Redirect("CursosYHorariosPA.aspx");
        }

        protected void btnGestionarHorarios_Click(object sender, EventArgs e)
        {
            LinkButton lnk = (LinkButton)sender;
            int idCurso = int.Parse(lnk.CommandArgument);
            Response.Redirect("GestionarHorariosPA.aspx?idCurso=" + idCurso);
        }

    }
}