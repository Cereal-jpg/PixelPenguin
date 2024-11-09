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

        protected void loginButton_Click(object sender, EventArgs e)
        {
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
                        Session["idAlumnoLogueado"] = id;
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
            else
            {
                errorMessage.Text = "<span class='error-icon'>⚠️</span><span class='error-text'>Ocurrió un error al procesar su solicitud. Por favor, inténtelo de nuevo más tarde.</span>";
                errorMessage.Visible = true;
            }
        }

        protected void forgotPasswordButton_Click(object sender, EventArgs e)
        {
            Response.Redirect("RecuperarContrasenia.aspx");
        }
    }
}