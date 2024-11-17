using SoftPixelPenguinsWA.ServicioWeb;
using System;
using System.Collections.Generic;
using System.Configuration;
using System.Linq;
using System.Net.Mail;
using System.Net;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace SoftPixelPenguinsWA
{
    public partial class ProcesoMatriculaGenerica : System.Web.UI.Page
    {
        ApoderadoWSClient apoderadoBO = new ApoderadoWSClient();
        usuario usuario = null;
        alumno alumnoLogueado = null;
        AlumnoWSClient alumnoBO = new AlumnoWSClient();
        UsuarioWSClient usuarioBO = new UsuarioWSClient();
        RolWSClient rolBO = new RolWSClient();
        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {
                registrarLogin.Visible = false;
            }
        }

        protected void btnRegistrar_Click(object sender, EventArgs e)
        {
            // Validar que todos los campos obligatorios están llenos
            if (string.IsNullOrEmpty(txtNombreAlumno.Text) ||
                string.IsNullOrEmpty(txtApellidoPaterno.Text) ||
                string.IsNullOrEmpty(txtApellidoMaterno.Text) ||
                string.IsNullOrEmpty(txtDNIAlumno.Text) ||
                string.IsNullOrEmpty(dtpFechaNacimiento.Text) ||
                string.IsNullOrEmpty(ddlSexo.SelectedValue) ||
                string.IsNullOrEmpty(txtEmail.Text) ||
                string.IsNullOrEmpty(txtDireccion.Text))
            {
                return;
            }

            alumno alumno = new alumno
            {
                rol = rolBO.obtenerRolPorId(5),
                dni = txtDNIAlumno.Text,
                nombreCompleto = String.Concat(txtNombreAlumno.Text, " ", txtApellidoPaterno.Text, " ", txtApellidoMaterno.Text),
                fechaNacimiento = DateTime.Parse(dtpFechaNacimiento.Text),
                fechaNacimientoSpecified = true,
                direccion = txtDireccion.Text,
                email = txtEmail.Text,
                sexo = ddlSexo.SelectedValue,
                username = txtNombreAlumno.Text[0] + txtApellidoPaterno.Text[0] + txtDNIAlumno.Text.Substring(0, 4), // Usuario autogenerado
                password = txtNombreAlumno.Text[0] + txtDNIAlumno.Text,   // Contraseña autogenerada
                apoderado = null,
                gradoAcademico = null,
                codigoAlumno = DateTime.Now.Year*1000 + int.Parse(txtDNIAlumno.Text.Substring(4, 3)),
                certificadoDeEstudios = null,
                certificadoDeSalud = null,
                conDeuda = false,
                estado = estadoAlumno.Pendiente,
                estadoSpecified = true
            };
            usuario user = new usuario
            {
                rol = rolBO.obtenerRolPorId(5),
                dni = txtDNIAlumno.Text,
                nombreCompleto = String.Concat(txtNombreAlumno.Text, " ", txtApellidoPaterno.Text, " ", txtApellidoMaterno.Text),
                fechaNacimiento = DateTime.Parse(dtpFechaNacimiento.Text),
                fechaNacimientoSpecified = true,
                direccion = txtDireccion.Text,
                email = txtEmail.Text,
                sexo = ddlSexo.SelectedValue,
                username = txtNombreAlumno.Text[0] + txtApellidoPaterno.Text[0] + txtDNIAlumno.Text.Substring(0, 4), // Usuario autogenerado
                password = txtNombreAlumno.Text[0] + txtDNIAlumno.Text,   // Contraseña autogenerada
            };

            int idUuu = alumnoBO.insertarAlumno(alumno);
            int iduserrr = usuarioBO.insertarUsuario(user);

            string cuerpo = $"Hola {user.nombreCompleto},\n\nGracias por registrarte, estos son tus datos de la cuenta.\n" +
                            $"Tu nuevo usuario es: {user.username}\n" +
                            $"Tu nueva contraseña es: {user.password}\n" +
                            "Gracias por elegir nuestra institución\n" +
                            "Atentamente, \nEquipoAdministrativo PixelPenguins";
            enviarCorreo(alumno.email.ToString(), "Correo de Registro de matrícula", cuerpo);

            registrarUsuario.Visible = false;
            registrarLogin.Visible = true;
        }

        private void enviarCorreo(string destinatario, string asunto, string cuerpo)
        {
            try
            {
                string gmailUser = ConfigurationManager.AppSettings["Email"];
                string gmailPassword = ConfigurationManager.AppSettings["EmailPassword"];

                MailMessage mail = new MailMessage();
                mail.From = new MailAddress(gmailUser);
                mail.To.Add(destinatario);
                mail.Subject = asunto;
                mail.Body = cuerpo;
                mail.IsBodyHtml = false;

                SmtpClient smtp = new SmtpClient("smtp.gmail.com", 587);
                smtp.Credentials = new NetworkCredential(gmailUser, gmailPassword);
                smtp.EnableSsl = true;

                smtp.Send(mail);
                //Response.Write("Correo enviado exitosamente.");
            }
            catch (Exception ex)
            {
                // Mostrar el error completo para depuración
                //Response.Write("Error al enviar el correo: " + ex.ToString());
            }
        }

        protected void btnVolverLogin_Click(object sender, EventArgs e)
        {
            Response.Redirect("Login.aspx");
        }
    }
}





