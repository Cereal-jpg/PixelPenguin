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

            // Ejemplo simple de validación.
            if (validarCredenciales(Email,Password))
            {
                Response.Redirect("Index.aspx");
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