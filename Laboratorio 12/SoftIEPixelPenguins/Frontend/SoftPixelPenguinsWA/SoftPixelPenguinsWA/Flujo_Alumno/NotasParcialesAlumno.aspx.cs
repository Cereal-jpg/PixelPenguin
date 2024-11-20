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
    public partial class NotasParcialesAlumno : System.Web.UI.Page
    {
        AlumnoWSClient alumnoBO = new AlumnoWSClient();
        CursoWSClient cursoBO = new CursoWSClient();
        NotaWSClient notaBO = new NotaWSClient();
        CompetenciaWSClient competenciaBO = new CompetenciaWSClient();
        MatriculaWSClient matriculaBO = new MatriculaWSClient();
        gradoAcademico grado = null;
        alumno alumno = null;
        int idAlumno;
        BindingList<nota> notas = new BindingList<nota>();
        BindingList<curso> cursos = null;
        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {
                if (Session["idAlumnoLogueado"] != null)
                {
                    idAlumno = (int)Session["idAlumnoLogueado"];
                    alumno = alumnoBO.obtenerAlumnoPorId(idAlumno);
                    grado = alumno.gradoAcademico;
                    hTitulo.InnerHtml = "Notas parciales";
                    if (alumno != null && grado != null)
                    {
                        cursos = new BindingList<curso>(cursoBO.listarCursosPorGrado(grado.idGradoAcademico));
                        foreach (curso curso in cursos)
                        {
                            string textoItem = curso.nombre;
                            string valorItem = curso.idCurso.ToString();
                            ddlCursos.Items.Add(new ListItem(textoItem, valorItem));
                        }
                    }
                    cargarNotas();
                }
            }
            idAlumno = (int)Session["idAlumnoLogueado"];
            alumno = alumnoBO.obtenerAlumnoPorId(idAlumno);
            grado = alumno.gradoAcademico;
            hTitulo.InnerHtml = "Notas parciales";
            cargarNotas();
        }
        protected void cargarNotas()
        {
            int idCurso = int.Parse(ddlCursos.SelectedValue);
            int bimestre = int.Parse(ddlBimestre.SelectedValue);
            if (notaBO.listarPorAlumnoCursoYBimestre(idAlumno, idCurso, bimestre) == null)
            {
                BindingList<competencia> competencias = new BindingList<competencia>(competenciaBO.listarCompetenciasPorCurso(idCurso));
                foreach(competencia aux in competencias)
                {
                    nota nota = new nota
                    {
                        fid_Matricula = matriculaBO.obtenerMatriculaPorIdAlumno(idAlumno),
                        fid_Alumno = idAlumno,
                        nota1 = "-",
                        bimestre = bimestre,
                        curso=aux.curso,
                        competencia=aux
                    };
                    notaBO.insertarNota(nota);
                }
            }
            gvNotas.DataSource = notaBO.listarPorAlumnoCursoYBimestre(idAlumno,idCurso,bimestre);
            gvNotas.DataBind();
        }

        protected void ddlCurso_SelectedIndexChanged(object sender, EventArgs e)
        {
            cargarNotas();
        }

        protected void ddlBimestre_SelectedIndexChanged(object sender, EventArgs e)
        {
            cargarNotas();
        }

        protected void btnRegresar_Click(object sender, EventArgs e)
        {
            Response.Redirect("ReporteNotasAlumno.aspx");
        }
    }
}