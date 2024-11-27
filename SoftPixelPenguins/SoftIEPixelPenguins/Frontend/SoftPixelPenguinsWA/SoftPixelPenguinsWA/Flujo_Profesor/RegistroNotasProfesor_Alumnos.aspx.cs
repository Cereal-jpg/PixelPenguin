using SoftPixelPenguinsWA.ServicioWeb;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data.SqlClient;
using System.Linq;
using System.ServiceModel.Channels;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace SoftPixelPenguinsWA
{
    public partial class RegistroNotasProfesor_Alumnos : System.Web.UI.Page
    {
        private CursoWSClient cursoBO = new CursoWSClient();
        private CompetenciaWSClient competenciaBO = new CompetenciaWSClient();
        private GradoAcademicoWSClient gradoAcademicoBO = new GradoAcademicoWSClient();
        private MatriculaWSClient matriculaBO = new MatriculaWSClient();
        private AlumnoWSClient alumnoBO = new AlumnoWSClient();
        private NotaWSClient notaBO = new NotaWSClient();
        competencia competencia = null;
        curso curso = null;
        nota nota = null;
        gradoAcademico grado = null;
        BindingList<matricula> matriculas = null;
        BindingList<alumno> alumnos = null;

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

                string id = Request.QueryString["idCompetencia"];
                if (id != null)
                {
                    int idCompetencia = Int32.Parse(id);
                    competencia = competenciaBO.obtenerCompetenciaPorId(idCompetencia);
                    curso = cursoBO.obtenerCursoPorId(competencia.curso.idCurso);
                    hTitulo.InnerHtml = "Registro de Notas - " + curso.codigoCurso + " - " + curso.nombre + " - " + competencia.descripcion;
                    grado = gradoAcademicoBO.obtenerGradoAcademicoPorId(curso.gradoAcademico.idGradoAcademico);
                    matriculas = new BindingList<matricula>(matriculaBO.listarMatriculasPorGradoAcademico(grado));
                    Session["matriculas"] = matriculas;
                    Session["curso"] = curso;
                    Session["competencia"] = competencia;
                    cargarAlumnos();
                }
            }
        }

        private void cargarAlumnos()
        {
            if (matriculas != null)
            {
                foreach (matricula matricula in matriculas)
                {
                    if (alumnos == null) alumnos = new BindingList<alumno>();
                    alumno alumno = alumnoBO.obtenerAlumnoPorId(matricula.fidAlumno);
                    alumnos.Add(alumno);
                }
            }

            if (alumnos != null)
            {
                gvAlumnos.DataSource = alumnos;
                gvAlumnos.DataBind();
            }
        }

        protected void btnGrabar_Click(object sender, EventArgs e)
        {
            matriculas = Session["matriculas"] as BindingList<matricula>;
            BindingList<nota> notas = new BindingList<nota>();

            foreach (GridViewRow row in gvAlumnos.Rows)
            {
                if (row.RowType == DataControlRowType.DataRow)
                {
                    int idAlumno = (int)gvAlumnos.DataKeys[row.RowIndex].Value;

                    DropDownList ddlNotas = (DropDownList)row.FindControl("ddlNotas");
                    string notaSeleccionada = ddlNotas.SelectedValue;
                    matricula matriculaAlumno = matriculas.FirstOrDefault(m => m.fidAlumno == idAlumno);

                    if (string.IsNullOrEmpty(notaSeleccionada))
                    {
                        lblError.Text = "Todos los alumnos deben tener una nota seleccionada.";
                        lblError.Visible = true;
                        return;
                    }

                    competencia = (competencia)Session["competencia"];

                    nota nota = notaBO.obtenerNotaPorParametros(matriculaAlumno.idMatricula, idAlumno,
                        competencia.curso.idCurso, Int32.Parse(ddlBimestre.SelectedValue),competencia.idCompetencia);
                    nota newNota = new nota
                    {
                        bimestre = Int32.Parse(ddlBimestre.SelectedValue),
                        competencia = (competencia)Session["competencia"],
                        curso = (curso)Session["curso"],
                        fid_Alumno = idAlumno,
                        fid_Matricula = matriculaAlumno.idMatricula,
                        nota1 = notaSeleccionada,
                    };
                    if (nota != null)    // Hay nota
                    {
                        newNota.idNota = nota.idNota;
                        newNota.idNotaSpecified = true;
                        notaBO.modificarNota(newNota);
                    }
                    else
                    {
                        notaBO.insertarNota(newNota);
                    }
                }
            }
            //registrarNotasEnBD(notas);
        }

        private void registrarNotasEnBD(BindingList<nota> notas)
        {
            foreach (nota n in notas)
            {

                if(n.idNota > 0)
                {
                    notaBO.modificarNota(n);
                }
                else
                {
                    notaBO.insertarNota(n);
                }
            }
        }

        protected void btnRegresar_Click(object sender, EventArgs e)
        {
            Session["matriculas"] = null;
            Session["curso"] = null;
            Session["competencia"] = null;
            Response.Redirect("RegistroNotasProfesor.aspx");
        }

    }
}
