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
    public partial class GestionarCursosPlanPA : System.Web.UI.Page
    {
        GradoAcademicoWSClient gradoBO = new GradoAcademicoWSClient();
        CursoWSClient cursoBO = new CursoWSClient();
        CompetenciaWSClient competenciaBO = new CompetenciaWSClient();
        int idCurso;
        int idGradoAcademico;

        protected void Page_Load(object sender, EventArgs e)
        {
            string idCursoQuery = Request.QueryString["idCurso"];
            string accionQuery = Request.QueryString["accion"];
            string idGrado = Request.QueryString["idGradoAcademico"];
            if (!string.IsNullOrEmpty(idGrado))
            {
                if (Session["idCursoInsertado"] != null) idCurso = (int)Session["idCursoInsertado"];
                else idCurso = 0;
                idGradoAcademico = int.Parse(idGrado);
                lblError.Visible = false;
            }
            else if(!string.IsNullOrEmpty(idCursoQuery) && accionQuery.Equals("modificar"))
            {
                hTitulo.InnerText = "Modificar Curso";
                btnAgregarCurso.Text = "Modificar Curso";
                idCurso = int.Parse(idCursoQuery);
                cargarDatos();
            }
            cargarCompetencias();
        }

        private void cargarDatos()
        {
            curso curso = cursoBO.obtenerCursoPorId(idCurso);
            if (!IsPostBack)
            {
                txtCodigoCurso.Text = curso.codigoCurso;
                txtNombreCurso.Text = curso.nombre;
                txtHorasPorSemana.Text = curso.horasPorSemana.ToString();
            }
            idGradoAcademico = curso.gradoAcademico.idGradoAcademico;
        }

        private void cargarCompetencias()
        {
            List<competencia> competencias = new List<competencia>();
            if (idCurso != 0)
            {
                competencias = (competenciaBO.listarCompetenciasPorCurso(idCurso) ?? Array.Empty<competencia>()).ToList();
            }
            gvCompetencias.DataSource = competencias;
            gvCompetencias.DataBind();
        }

        protected void btnAgregarCurso_Click(object sender, EventArgs e)
        {
            curso curso = new curso
            {
                codigoCurso = txtCodigoCurso.Text,
                nombre = txtNombreCurso.Text,
                gradoAcademico = new gradoAcademico { idGradoAcademico = idGradoAcademico, idGradoAcademicoSpecified = true},
                horasPorSemana = int.Parse(txtHorasPorSemana.Text),
                horasTotales = int.Parse(txtHorasPorSemana.Text) * 9,
                
            };
            if(idCurso != 0)
            {
                curso.idCurso = idCurso;
                curso.idCursoSpecified = true;
                cursoBO.modificarCurso(curso);
            } else
            {
                Session["idCursoInsertado"] = cursoBO.insertarCurso(curso);
            }
        }

        protected void btnAgregarCompetencia_Click(object sender, EventArgs e)
        {
            if(idCurso == 0)
            {
                lblError.Visible = true;
            }
            else
            {
                competencia competencia = new competencia
                {
                    curso = new curso { idCurso = idCurso, idCursoSpecified = true},
                    descripcion = txtDescripcionCompetencia.Text
                };
                competenciaBO.insertarCompetencia(competencia);
            }
            cargarCompetencias();
        }

        protected void lbEliminar_Click(object sender, EventArgs e)
        {
            LinkButton btn = (LinkButton)sender;
            int idCompetencia = int.Parse(btn.CommandArgument);
            competencia competencia = new competencia { idCompetencia = idCompetencia, idCompetenciaSpecified = true};
            competenciaBO.eliminarCompetencia(competencia);
            cargarCompetencias();
        }

        protected void btnRegresar_Click(object sender, EventArgs e)
        {
            Session["idCursoInsertado"] = null;
            Response.Redirect("GestionarPlanesPA.aspx");
        }

    }
}