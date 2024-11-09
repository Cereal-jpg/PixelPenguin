using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace SoftPixelPenguinsWA
{
    public partial class RecuperarContrasenia : System.Web.UI.Page
    {
        private UsuarioWSClient usuarioWSClient = new UsuarioWSClient();
        protected void Page_Load(object sender, EventArgs e)
        {
            confirmationMessage.Visible = false;
        }

        protected void confirmar_Click(object sender, EventArgs e)
        {
            // Obtener los valores ingresados en los TextBox.
            string Email = email.Text.Trim();
            string Password = password1.Text.Trim();
            string Password2 = password2.Text.Trim();
            int id;
            id = usuarioWSClient.ValidarCorreoElectronico(Email);
            if (id != 0)
            {
                if (Password.Equals(Password2))
                {
                    int val = usuarioWSClient.ActualizarContrasena(Email, Password);
                    if (val != 0)
                    {
                        formContainer.Visible = false;
                        confirmationMessage.Visible = true;
                    }
                }
                else
                {
                    errorMessage.Text = "<span class='error-icon'>⚠️</span><span class='error-text'>Introduzca la contraseña correctamente.</span>";
                    errorMessage.Visible = true;
                }
            }
            else
            {
                errorMessage.Text = "<span class='error-icon'>⚠️</span><span class='error-text'>Ocurrió un error al procesar su solicitud. Por favor, inténtelo de nuevo más tarde.</span>";
                errorMessage.Visible = true;
            }
        }

        protected void Volver_Click(object sender, EventArgs e)
        {
            Response.Redirect("Login.aspx");
        }
    }
}