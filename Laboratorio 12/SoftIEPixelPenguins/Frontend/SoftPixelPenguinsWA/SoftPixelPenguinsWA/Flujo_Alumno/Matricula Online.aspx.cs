using SoftPixelPenguinsWA.ServicioWeb;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace SoftPixelPenguinsWA
{
    public partial class Online : System.Web.UI.Page
    {
        AlumnoWSClient alumnoBO = new AlumnoWSClient();
        ApoderadoWSClient apoderadoBO = new ApoderadoWSClient();
        alumno alumnoLogueado = null;

        protected void Page_Load(object sender, EventArgs e)
        {
            btnGuardar.Enabled = false;
            if (!IsPostBack)
            {
                if (Session["idAlumnoLogueado"] != null)
                {
                    alumnoLogueado = alumnoBO.obtenerAlumnoPorId((int)Session["idAlumnoLogueado"]);
                    cargarValores();
                    deshabilitarComponentes();
                }
            }
        }

        protected void lnkDescargarEstudios_Click(object sender, EventArgs e)
        {
            alumnoLogueado = alumnoBO.obtenerAlumnoPorId((int)Session["idAlumnoLogueado"]);
            if (alumnoLogueado != null)
            {
                byte[] archivoBytes = alumnoLogueado.certificadoDeEstudios;
                if (archivoBytes != null && archivoBytes.Length > 0)
                {
                    Response.Clear();
                    Response.ContentType = "application/pdf";
                    Response.AddHeader("Content-Disposition", "attachment; filename=certificadoDeEstudios.pdf");
                    Response.BinaryWrite(archivoBytes);
                    Response.End();
                }
            }
        }

        protected void lnkDescargarSalud_Click(object sender, EventArgs e)
        {
            alumnoLogueado = alumnoBO.obtenerAlumnoPorId((int)Session["idAlumnoLogueado"]);
            if (alumnoLogueado != null)
            {
                byte[] archivoBytes = alumnoLogueado.certificadoDeSalud;
                if (archivoBytes != null && archivoBytes.Length > 0)
                {
                    Response.Clear();
                    Response.ContentType = "application/pdf";
                    Response.AddHeader("Content-Disposition", "attachment; filename=certificadoDeSalud.pdf");
                    Response.BinaryWrite(archivoBytes);
                    Response.End();
                }
            }
        }

        private void cargarValores()
        {
            alumnoLogueado = alumnoBO.obtenerAlumnoPorId((int)Session["idAlumnoLogueado"]);
            txtDNIAlumno.Text = alumnoLogueado.dni;
            string[] palabras = alumnoLogueado.nombreCompleto.Trim().Split(' ');
            if (palabras.Length == 3)
            {
                txtNombreAlumno.Text = palabras[0];
                txtApellidoPaterno.Text = palabras[1];
                txtApellidoMaterno.Text = palabras[2];
            }
            else
            {
                txtNombreAlumno.Text = string.Join(" ", palabras.Take(palabras.Length - 2));
                txtApellidoPaterno.Text = palabras[palabras.Length - 2];
                txtApellidoMaterno.Text = palabras[palabras.Length - 1];
            }
            dtpFechaNacimiento.Text = alumnoLogueado.fechaNacimiento.ToString("yyyy-MM-dd");
            ddlSexo.SelectedValue = alumnoLogueado.sexo;
            txtEmail.Text = alumnoLogueado.email;
            txtDireccion.Text = alumnoLogueado.direccion;
            alumnoLogueado.apoderado = apoderadoBO.obtenerApoderadoPorId(alumnoLogueado.apoderado.idApoderado);
            txtDNIApoderado.Text = alumnoLogueado.apoderado.dni.ToString();
            txtNombreApoderado.Text = alumnoLogueado.apoderado.nombreCompleto;
            txtTelefonoApoderado.Text = alumnoLogueado.apoderado.telefono.ToString();
            ddlRelacionApoderado.SelectedValue = alumnoLogueado.apoderado.relacion;
            lnkDescargarEstudios.Visible = true;
            lnkDescargarSalud.Visible = true;
        }

        private void deshabilitarComponentes()
        {
            txtNombreAlumno.Enabled = false;
            txtApellidoMaterno.Enabled = false;
            txtApellidoPaterno.Enabled = false;
            txtDNIAlumno.Enabled = false;
            dtpFechaNacimiento.Enabled = false;
            ddlSexo.Enabled = false;
            txtEmail.Enabled = false;
        }

        protected void btnRegresar_Click(object sender, EventArgs e)
        {
            Response.Redirect("MatriculaOnlineAlumno.aspx");
        }

        protected void btnGuardar_Click(object sender, EventArgs e)
        {

        }

    }
}