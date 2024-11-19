using SoftPixelPenguinsWA.ServicioWeb;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace SoftPixelPenguinsWA
{
    public partial class ReporteNotasAlumno : System.Web.UI.Page
    {
        CursoXMatriculaWSClient cursoXMatriculaBO = new CursoXMatriculaWSClient();
        AlumnoWSClient alumnoBO = new AlumnoWSClient();
        InstitucionEducativaWSClient institucionBO = new InstitucionEducativaWSClient();
        institucionEducativa institucion = null;
        alumno alumno = null;
        int idAlumno;
        protected void Page_Load(object sender, EventArgs e)
        {
            // Verifica si la página actual es el index
            if (Session["idAlumnoLogueado"] != null)
            {
                idAlumno = (int)Session["idAlumnoLogueado"];
                institucion = institucionBO.obtenerInstitucionEducativaPorId(1);
                txtInstitucion.Text = institucion.nombre;
                txtDireccion.Text = institucion.direccion;
                alumno = alumnoBO.obtenerAlumnoPorId(idAlumno);
                txtAlumno.Text = alumno.nombreCompleto;
                deshabilitarComponentes();
            }
            gvNotas.DataSource = cursoXMatriculaBO.listarNotasFinalesCursosXAlumno(idAlumno);
            gvNotas.DataBind();
        }

        protected void btnVerNotasParciales_Click(object sender, EventArgs e)
        {
            Response.Redirect("NotasParcialesAlumno.aspx");
        }

        private void deshabilitarComponentes()
        {
            txtInstitucion.Enabled = false;
            txtDireccion.Enabled = false;
            txtAlumno.Enabled = false;
        }
    }
}