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
        private ProfesorWSClient profesorBO=new ProfesorWSClient();
        profesor profesor = null;
        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {
                string id = Request.QueryString["idProfesor"];
                if (id != null)
                {
                    int idProfesor= Int32.Parse(id);
                    profesor = profesorBO.obtenerProfesorPorId(idProfesor);
                    hTitulo.InnerHtml = profesor.nombreCompleto;
                    txtCodigoProfesor.Text = profesor.codigoProfesor.ToString();
                    txtEspecialidad.Text = profesor.especialidad.ToString();
                    txtFecha.Text=profesor.fechaNacimiento.ToString("dd/MM/yyyy"); ;
                    txtEmail.Text = profesor.email;
                    txtSexo.Text = profesor.sexo.ToString();
                    deshabilitarComponentes();
                }
            }
        }

        private void deshabilitarComponentes()
        {
            txtCodigoProfesor.Enabled = false;
            txtEspecialidad.Enabled = false;
            txtFecha.Enabled = false;
            txtEmail.Enabled = false;
            txtSexo.Enabled = false;
        }

        protected void btnRegresar_Click(object sender, EventArgs e)
        {
            Response.Redirect("MisCursosAlumno.aspx");
        }
    }
}