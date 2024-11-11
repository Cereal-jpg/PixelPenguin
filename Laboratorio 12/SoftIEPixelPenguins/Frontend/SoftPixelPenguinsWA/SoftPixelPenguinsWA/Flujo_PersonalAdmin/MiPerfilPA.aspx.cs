using SoftPixelPenguinsWA.ServicioWeb;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace SoftPixelPenguinsWA
{
    public partial class MiPerfilPA : System.Web.UI.Page
    {
        PersonalAdministrativoWSClient personalAdminBO = new PersonalAdministrativoWSClient();
        personalAdministrativo personalAdmin = null;
        int idPA = 0;

        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {
                if (Session["idPersonalAdmin"] != null)
                {
                    idPA = (int)Session["idPersonalAdmin"];
                    cargarValores();

                }
            }

        }

        private void cargarValores()
        {
            personalAdmin = personalAdminBO.obtenerPersonalAdministrativoPorId(idPA);
            txtDNIAlumno.Text = personalAdmin.dni;
            string[] palabras = personalAdmin.nombreCompleto.Trim().Split(' ');

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

            dtpFechaNacimiento.Text = personalAdmin.fechaNacimiento.ToString("yyyy-MM-dd");
            txtSexo.Text = personalAdmin.sexo;
            txtEmail.Text = personalAdmin.email;
            txtDireccion.Text = personalAdmin.direccion;
            txtUsuario.Text = personalAdmin.username;
            txtContrasena.Attributes["value"] = personalAdmin.password;

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