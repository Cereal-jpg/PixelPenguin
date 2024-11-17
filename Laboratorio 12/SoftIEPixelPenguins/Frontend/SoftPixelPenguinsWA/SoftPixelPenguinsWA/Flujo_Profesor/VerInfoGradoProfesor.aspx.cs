using SoftPixelPenguinsWA.ServicioWeb;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace SoftPixelPenguinsWA.Flujo_Profesor
{
    public partial class VerInfoGradoProfesor : System.Web.UI.Page
    {
        curso curso = null;
        gradoAcademico grado = null;
        GradoAcademicoWSClient gradoBO = new GradoAcademicoWSClient();
        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {
                string id = Request.QueryString["idGrado"];
                if (id != null)
                {
                    int idGrado = Int32.Parse(id);
                    grado = gradoBO.obtenerGradoAcademicoPorId(idGrado);
                    if(grado != null)
                    {
                        txtGrado.Text = grado.numeroGrado.ToString();
                        txtNivel.Text = grado.nivel.ToString();
                        txtCantAlumnos.Text = grado.cantidadAlumnos.ToString();
                        deshabilitarComponentes();
                    }
                }
            }
        }

        private void deshabilitarComponentes()
        {

            txtGrado.Enabled = false;
            txtNivel.Enabled = false;
            txtCantAlumnos.Enabled = false;
        }

        protected void btnRegresar_Click(object sender, EventArgs e)
        {
            Response.Redirect("CursosDictadosProfesor.aspx");
        }
    }
}