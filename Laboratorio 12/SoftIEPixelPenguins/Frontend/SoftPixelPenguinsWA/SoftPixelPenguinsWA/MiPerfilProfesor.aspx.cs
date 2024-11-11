using SoftPixelPenguinsWA.ServicioWeb;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.ComponentModel;
using System.ServiceModel.Channels;
using System.Web.UI.HtmlControls;

namespace SoftPixelPenguinsWA
{
    public partial class MiPerfilProfesor : System.Web.UI.Page
    {
        ProfesorWSClient profesorBO = new ProfesorWSClient();
        profesor profesor = null;
        int idProfesor = 0;

        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {
                if (Session["idProfesorLogueado"] != null)
                {
                    idProfesor = (int)Session["idProfesorLogueado"];
                    // Verifica si la página actual es el index
                    if (Request.Url.AbsolutePath.EndsWith("MiPerfilProfesor.aspx", StringComparison.OrdinalIgnoreCase))
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

                    cargarValores();

                } 
            }

        }

        private void cargarValores()
        {
            profesor = profesorBO.obtenerProfesorPorId(idProfesor);
            txtDNIAlumno.Text = profesor.dni;
            string[] palabras = profesor.nombreCompleto.Trim().Split(' ');

            if (palabras.Length == 3)
            {
                txtNombreAlumno.Text = palabras[0];
                txtApellidoPaterno.Text = palabras[1];
                txtApellidoMaterno.Text = palabras[2];
            }
            else
            {
                txtNombreAlumno.Text = palabras[0];
                txtApellidoMaterno.Text = palabras[palabras.Length - 1];

                // Unir las palabras intermedias como Apellido Paterno
                if (palabras.Length > 2)
                {
                    txtApellidoPaterno.Text = string.Join(" ", palabras, 1, palabras.Length - 2);
                }
                else
                {
                    txtApellidoPaterno.Text = palabras[palabras.Length - 1];
                    txtApellidoMaterno.Text = ""; // Si no hay apellido materno, dejar en blanco
                }
            }

            // Datos personales del alumno

            dtpFechaNacimiento.Text = profesor.fechaNacimiento.ToString("yyyy-MM-dd");
            txtSexo.Text = profesor.sexo;
            txtEmail.Text = profesor.email;
            txtDireccion.Text = profesor.direccion;
            txtUsuario.Text = profesor.username;
            txtContrasena.Attributes["value"] = profesor.password;

            deshabilitarComponentes();
        }

        private void deshabilitarComponentes()
        {
            txtDNIAlumno.Enabled = false;
            txtNombreAlumno.Enabled = false;
            txtApellidoPaterno.Enabled = false;
            txtApellidoMaterno.Enabled = false;
            txtDireccion.Enabled = false;
            txtUsuario.Enabled = false;
            txtContrasena.Enabled = false;
            dtpFechaNacimiento.Enabled = false;
            txtSexo.Enabled = false;
            txtEmail.Enabled = false;
        }

        protected void lnkCertificadoEducativo_Click(object sender, EventArgs e)
        {
            if (profesor != null)
            {
                byte[] archivoBytes = profesor.certificadoHistorialEducativo;
                if (archivoBytes != null && archivoBytes.Length > 0)
                {
                    Response.Clear();
                    Response.ContentType = "application/pdf";
                    Response.AddHeader("Content-Disposition", "attachment; filename=certificadoHistorialEducativo.pdf");
                    Response.BinaryWrite(archivoBytes);
                    Response.End();
                }
            }
        }
    }
}