using SoftPixelPenguinsWA.ServicioWeb;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace SoftPixelPenguinsWA
{
    public partial class MiPerfilAdmin : System.Web.UI.Page
    {
        AdministradorWSClient adminBO = new AdministradorWSClient();
        administrador admin = null;
        int idAdmin = 0;

        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {
                if (Session["idAdmin"] != null)
                {

                    idAdmin = (int)Session["idAdmin"];
                    cargarValores();

                }
            }

        }

        private void cargarValores()
        {
            admin = adminBO.obtenerAdministradorPorId(idAdmin);
            txtDNIAlumno.Text = admin.dni;
            string[] palabras = admin.nombreCompleto.Trim().Split(' ');

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

            dtpFechaNacimiento.Text = admin.fechaNacimiento.ToString("yyyy-MM-dd");
            txtSexo.Text = admin.sexo;
            txtEmail.Text = admin.email;
            txtDireccion.Text = admin.direccion;
            txtUsuario.Text = admin.username;
            txtContrasena.Attributes["value"] = admin.password;

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
    }
}