using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace SoftPixelPenguinsWA
{
    public partial class MisCursosAlumno : System.Web.UI.Page
    {
        private AlumnoWSClient alumnoBO = new AlumnoWSClient();
        private GradoAcademicoWSClient gradoBO = new GradoAcademicoWSClient();
        alumno alumno = null;
        gradoAcademico gradoAcademico = null;
        private CursoWSClient cursoBO = new CursoWSClient();

        //int idUsuario = 30;
        int idGradoAcademico;

        protected void Page_Load(object sender, EventArgs e)
        {
            // Cargar los datos en el init
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


                        cargarMisCursos();

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

        private void cargarMisCursos()
        {
            if (Session["idGradoAcademico"] != null)
            {
                int idGrado = (int)Session["idGradoAcademico"];
                gvMisCursos.DataSource = cursoBO.listarCursosPorGrado(idGrado);
                gvMisCursos.DataBind();
            }
        }
    }
}