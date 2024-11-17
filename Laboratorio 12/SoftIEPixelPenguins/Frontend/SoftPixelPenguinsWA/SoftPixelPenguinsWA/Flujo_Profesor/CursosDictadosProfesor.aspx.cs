using SoftPixelPenguinsWA.ServicioWeb;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.ServiceModel.Channels;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace SoftPixelPenguinsWA
{
    public partial class CursosDictadosProfesor : System.Web.UI.Page
    {
        private ProfesorWSClient profesorBO = new ProfesorWSClient();
        profesor profesor = null;
        List<curso> cursos = null;
        curso curso = null;
        CursoWSClient cursoBO = new CursoWSClient();
        GradoAcademicoWSClient gradoBO = new GradoAcademicoWSClient();
        anioAcademico anio = null;
        gradoAcademico grado = null;
        int idGrado = 0;

        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {
                // Verifica si la página actual es el index
                if (Request.Url.AbsolutePath.EndsWith("CursosDictadosProfesor.aspx", StringComparison.OrdinalIgnoreCase))
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
            }
            // Cargar el encabezado del grado académico
            if (Session["idProfesorLogueado"] != null)
            {

                String txt = "Año Académico ";

                String result = txt + DateTime.Now.Year.ToString(); 
                myLabel.Text = result;

                int idUsuario = (int)Session["idProfesorLogueado"];
                profesor = profesorBO.obtenerProfesorPorId(idUsuario);

                if (profesor != null)
                {
                    cursos = (cursoBO.listarCursosPorProfesor(idUsuario) ?? Array.Empty<curso>()).ToList();
                    if (cursos.Count > 0 && cursos != null)
                    {
                        foreach (curso curso in cursos) curso.gradoAcademico = gradoBO.obtenerGradoAcademicoPorId(curso.gradoAcademico.idGradoAcademico);
                        gvCursosDictados.DataSource = cursos;
                        gvCursosDictados.DataBind();
                    }
                }
            }
            else
            {
                myLabel.Text = "Sesión de usuario no iniciada.";
            }
        }

        protected void btnVerGrado_Click(object sender, EventArgs e)
        {
            LinkButton btn = (LinkButton)sender;
            int idCurso = int.Parse(btn.CommandArgument);

            curso = cursoBO.obtenerCursoPorId(idCurso);
            if (curso != null)
            {
                grado = curso.gradoAcademico;
                if (grado != null)
                {
                    int idGrado = grado.idGradoAcademico;

                    Response.Redirect("VerInfoGradoProfesor.aspx?idGrado=" + idGrado);
                }
                else
                {
                    Response.Redirect("CursosDictadosProfesor.aspx");
                }

            }
            else
            {
                Response.Redirect("CursosDictadosProfesor.aspx");
            }
        }
    }
}