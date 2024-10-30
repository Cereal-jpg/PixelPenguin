using SoftPixelPenguinsWA.SoftPixelPenguinsWS;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace SoftPixelPenguinsWA
{
    public partial class Login : System.Web.UI.Page
    {
        private UsuarioWSClient usuarioWSClient = new UsuarioWSClient();
        protected void Page_Load(object sender, EventArgs e)
        {

        }

        protected bool validarCredenciales(string Email, string Password)
        {
            return true;
        }

        protected void loginButton_Click(object sender, EventArgs e)
        {
            // Obtener los valores ingresados en los TextBox.
            string Email = email.Text.Trim();
            string Password = password.Text.Trim();

            int id;
            id = usuarioWSClient.ValidarDatos(Email, Password);
            if (id != 0)
            {
                char tipo = Email[0];
                switch (tipo)
                {
                    case 'a':
                        Response.Redirect("IndexAlumno.aspx");
                        break;
                    case 'm':
                        Response.Redirect("IndexAdmin.aspx");
                        break;
                    case 'p':
                        Response.Redirect("IndexProfesor.aspx");
                        break;
                }
            }

            


            // Ejemplo simple de validación.
            if (validarCredenciales(Email,Password))
            {
                Response.Redirect("IndexAdmin.aspx");
            }
            else
            {
                // Mostrar un mensaje de error si las credenciales son incorrectas.
                errorMessage.Text = "Correo electrónico o contraseña incorrectos.";
                errorMessage.Visible = true;
            }
        }

        protected void forgotPasswordButton_Click(object sender, EventArgs e)
        {

        }
    }
}