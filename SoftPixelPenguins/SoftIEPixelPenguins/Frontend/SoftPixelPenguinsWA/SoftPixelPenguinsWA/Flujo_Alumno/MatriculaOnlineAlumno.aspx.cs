using SoftPixelPenguinsWA.ServicioWeb;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace SoftPixelPenguinsWA
{
    public partial class MatriculaOnlineAlumno : System.Web.UI.Page
    {
        AlumnoWSClient alumnoBO = new AlumnoWSClient();
        alumno alumnoLogueado = null;
        protected void Page_Load(object sender, EventArgs e)
        {
            if (Session["idAlumnoLogueado"] != null)
            {
                alumnoLogueado = alumnoBO.obtenerAlumnoPorId((int)Session["idAlumnoLogueado"]);
                if (alumnoLogueado.estado.Equals(estadoAlumno.Por_Pagar))
                {
                    btnIniciarMatricula.Enabled = false;
                }
            }
        }

        protected void btnIniciarMatricula_Click(object sender, EventArgs e)
        {
            Response.Redirect("Matricula Online.aspx");
        }
    }
}