using SoftPixelPenguinsWA.ServicioWeb;
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

        //int idGradoAcademico;
        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {
                // Verifica si la página actual es el index
                if (Session["idAlumnoLogueado"] != null)
                {
                    // Verifica si la página actual es el index
                    if (Request.Url.AbsolutePath.EndsWith("MiPerfilAlumno.aspx", StringComparison.OrdinalIgnoreCase))
                    {
                        // Oculta el menú deseado
                        ContentPlaceHolder menuItem7 = (ContentPlaceHolder)Master.FindControl("menuItem7");
                        if (menuItem7 != null)
                        {
                            menuItem7.Visible = false;
                        }
                    }
                }

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

                        String result = numero + "° " + anio;
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
        protected void cargarMisCursos()
        {
            if (Session["idGradoAcademico"] != null)
            {
                int idGrado = (int)Session["idGradoAcademico"];
                gvMisCursos.DataSource = cursoBO.listarCursosPorGrado(idGrado);
                gvMisCursos.DataBind();
            }
        }

        protected void btnVerInfoProfesor_Click(object sender, EventArgs e)
        {
            LinkButton btn = (LinkButton)sender;
            int idProfesor = int.Parse(btn.CommandArgument);
            Response.Redirect("VerInfoProfesorAlumno.aspx?idProfesor="+idProfesor);
        }
    }
}