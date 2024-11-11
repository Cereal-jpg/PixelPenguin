using SoftPixelPenguinsWA.ServicioWeb;
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
        private UsuarioWSClient usuarioBO = new UsuarioWSClient();

        private usuario usuario = null;
        protected void Page_Load(object sender, EventArgs e)
        {

        }

        protected void loginButton_Click(object sender, EventArgs e)
        {
            string Email = email.Text.Trim();
            string Password = password.Text.Trim();

            int id;
            id = usuarioBO.ValidarDatos(Email, Password);
            if (id != 0)
            {
                usuario=usuarioBO.obtenerUsuarioPorId(id);
                char tipo = Email[0];
                switch (usuario.rol.idRol)
                {
                    case 1:
                        Session["idAlumnoLogueado"] = id;
                        Response.Redirect("Flujo_Alumno/IndexAlumno.aspx");
                        break;
                    case 2:
                        Session["idProfesorLogueado"] = id;
                        Response.Redirect("Flujo_Profesor/IndexProfesor.aspx");
                        break;
                    case 3:
                        Session["idPersonalAdmin"] = id;
                        Response.Redirect("Flujo_PersonalAdmin/IndexPersonalAdministrativo.aspx");
                        break;
                    case 4:
                        Session["idAdmin"] = id;
                        Response.Redirect("Flujo_Admin/IndexAdmin.aspx");
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
            Response.Redirect("RecuperarContrasena.aspx");
        }
    }
}