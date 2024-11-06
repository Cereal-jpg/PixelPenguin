using SoftPixelPenguinsWA.SoftPixelPenguinsWS;
using System;
using System.Collections.Generic;
using System.Data;
using System.Linq;
using System.Web;
using System.Web.Script.Serialization;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace SoftPixelPenguinsWA
{

    public partial class ReporteNotasAlumno : System.Web.UI.Page
    {
        private AlumnoWSClient alumnoBO = new AlumnoWSClient();
        private GradoAcademicoWSClient gradoBO = new GradoAcademicoWSClient();
        alumno alumno = null;
        gradoAcademico gradoAcademico = null;
        private CursoWSClient cursoBO = new CursoWSClient();
        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {
                //cargarMisCursos();
            }

            // Cargar el encabezado del grado académico
            if (Session["idAlumnoLogueado"] != null)
            {
                int idUsuario = (int)Session["idAlumnoLogueado"];
                alumno = alumnoBO.obtenerAlumnoPorId(idUsuario);
                if (alumno != null && alumno.gradoAcademico != null)
                {
                    gradoAcademico = gradoBO.obtenerGradoAcademicoPorId(alumno.gradoAcademico.idGradoAcademico);
                    int idGrado = gradoAcademico.idGradoAcademico;
                    Session["idGradoAcademico"] = idGrado;
                    if (gradoAcademico != null)
                    {
                        String numero = gradoAcademico.numeroGrado.ToString();
                        String anio = gradoAcademico.nivel.ToString();

                        String result = anio + " - " + numero;
                        myLabel.Text = result;


                        CargarNotas();

                    }
                    else
                    {
                        myLabel.Text = "Información de grado no disponible.";
                    }
                }
            }
            else
            {
                myLabel.Text = "Sesión de usuario no iniciada.";
            }
        }

        //private void CargarNotas()
        //{
            // Suponiendo que `ObtenerNotasAlumno` está en una clase de servicio llamada `AlumnoService`.
            //int alumnoId = (int)Session["idUsuario"]; // ID del alumno (puedes obtenerlo dinámicamente).
            //List<nota> notas = new List<nota>(/*Función*/ );

            //gvNotas.DataSource = notas;
            //gvNotas.DataBind();
        //}

        private void CargarNotas()
        {
            if (Session["idGradoAcademico"] != null)
            {
                int idGrado = (int)Session["idGradoAcademico"];
                gvNotas.DataSource = cursoBO.listarCursosPorGrado(idGrado);
                gvNotas.DataBind();
            }
        }

        protected void Competencias_Click(object sender, EventArgs e)
        {
            Response.Redirect("CompetenciasCursos.aspx");
        }

    }
}