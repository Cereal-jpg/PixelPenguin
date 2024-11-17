using SoftPixelPenguinsWA.ServicioWeb;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace SoftPixelPenguinsWA
{
    public partial class VerInfoProfesorAlumno : System.Web.UI.Page
    {
        private ProfesorWSClient profesorBO = new ProfesorWSClient();
        private CursoWSClient CursoBO = new CursoWSClient();
        profesor profesor = null;
        curso curso = null;
        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {
                string id = Request.QueryString["idProfesor"];
                if (id != null)
                {
                    int idProfesor = Int32.Parse(id);
                    if (Session["idCursoSelec"] != null)
                    {
                        int idCurso = (int)Session["idCursoSelec"];
                        curso = CursoBO.obtenerCursoPorId(idCurso);
                        profesor = profesorBO.obtenerProfesorPorId(idProfesor);
                        if (curso != null && profesor != null)
                        {
                            hTitulo.InnerHtml = curso.nombre;
                            txtNombre.Text = profesor.nombreCompleto;
                            txtEspecialidad.Text = profesor.especialidad.ToString();
                            dtpFechaNacimiento.Text = profesor.fechaNacimiento.ToString("yyyy-MM-dd");
                            txtEmail.Text = profesor.email;
                            deshabilitarComponentes();
                        }
                    }
                }
            }
        }

        private void deshabilitarComponentes()
        {
            txtNombre.Enabled = false;
            txtEspecialidad.Enabled = false;
            dtpFechaNacimiento.Enabled = false;
            txtEmail.Enabled = false;
        }

        protected void btnRegresar_Click(object sender, EventArgs e)
        {
            Response.Redirect("MisCursosAlumno.aspx");
        }
    }
}