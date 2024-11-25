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
        SeccionAcademicaWSClient seccionBO = new SeccionAcademicaWSClient();
        seccionAcademica seccion = null;
        int idGrado = 0;
        protected void Page_Load(object sender, EventArgs e)
        {
            string id = Request.QueryString["idGrado"];
            if (!IsPostBack)
            {
                if (id != null)
                {
                    idGrado = Int32.Parse(id);
                    grado = gradoBO.obtenerGradoAcademicoPorId(idGrado);
                    if(grado != null)
                    {
                        txtGrado.Text = grado.numeroGrado.ToString();
                        txtNivel.Text = grado.nivel.ToString();
                        deshabilitarComponentes();
                    }
                }
            }
            grado = gradoBO.obtenerGradoAcademicoPorId(idGrado);
            if(grado != null)
            {
                List<seccionAcademica> listaSecciones = (seccionBO.listarSeccionesPorGrado(grado) ?? Array.Empty<seccionAcademica>()).ToList();
                gvSalones.DataSource = listaSecciones;
                gvSalones.DataBind();
            }
        }

        private void deshabilitarComponentes()
        {
            txtGrado.Enabled = false;
            txtNivel.Enabled = false;
        }

        protected void btnRegresar_Click(object sender, EventArgs e)
        {
            Response.Redirect("CursosDictadosProfesor.aspx");
        }
    }
}