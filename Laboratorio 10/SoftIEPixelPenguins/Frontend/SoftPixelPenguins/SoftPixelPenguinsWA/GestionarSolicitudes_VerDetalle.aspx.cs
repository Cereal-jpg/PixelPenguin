using SoftPixelPenguinsWA.SoftPixelPenguinsWS;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using static System.Collections.Specialized.BitVector32;

namespace SoftPixelPenguinsWA
{
    public partial class GestionarSolicitudes_VerDetalle : System.Web.UI.Page
    {

        AlumnoWSClient alumnoBO = new AlumnoWSClient();
        alumno alumno = null;
        protected void Page_Load(object sender, EventArgs e)
        {
            string idUsuario = Request.QueryString["idUsuario"];
            if(idUsuario != null)
            {
                alumno = alumnoBO.obtenerAlumnoPorId(Int32.Parse(idUsuario));
                txtDNIAlumno.Text = alumno.dni;
                string[] palabras = alumno.nombreCompleto.Trim().Split(' ');
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
                dtpFechaNacimiento.Text = alumno.fechaNacimiento.ToString("yyyy-MM-dd");
                txtSexo.Text = alumno.sexo;
                txtEmail.Text = alumno.email;
                txtDireccion.Text = alumno.direccion;
                if (alumno.estado.Equals(estadoAlumno.Por_Pagar))
                {
                    btnConfirmarSolicitud.Text = "Matricular Usuario";
                    lbBoucherPago.Style["display"] = "block";
                    txtUsuario.Text = alumno.username;
                    txtContraseña.Text = alumno.password;
                    txtCodigo.Text = alumno.codigoAlumno.ToString();
                }
                deshabilitarComponentes();
            }
        }

        private void deshabilitarComponentes()
        {
            txtDNIAlumno.Enabled = false;
            txtNombreAlumno.Enabled = false;
            txtApellidoPaterno.Enabled = false;
            txtApellidoMaterno.Enabled = false;
            dtpFechaNacimiento.Enabled = false;
            txtSexo.Enabled = false;
            txtEmail.Enabled = false;
            txtDireccion.Enabled = false;
            if (alumno.estado.Equals(estadoAlumno.Por_Pagar))
            {
                txtUsuario.Enabled = false;
                txtContraseña.Enabled = false;
                txtCodigo.Enabled = false;
            }
        }

        protected void lnkDescargarEstudios_Click(object sender, EventArgs e)
        {
            if(alumno != null)
            {
                byte[] archivoBytes = alumno.certificadoDeEstudios;
                if(archivoBytes != null && archivoBytes.Length > 0)
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
            if (alumno != null)
            {
                byte[] archivoBytes = alumno.certificadoDeSalud;
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

        protected void lnkDescargarBoucher_Click(object sender, EventArgs e)
        {
            if (alumno != null)
            {
                byte[] archivoBytes = (byte[])Session["comprobantePago"];
                if (archivoBytes != null && archivoBytes.Length > 0)
                {
                    Response.Clear();
                    Response.ContentType = "application/pdf";
                    Response.AddHeader("Content-Disposition", "attachment; filename=boucherDePago.pdf");
                    Response.BinaryWrite(archivoBytes);
                    Response.End();
                }
            }
        }

        protected void btnRegresar_Click(object sender, EventArgs e)
        {
            Response.Redirect("GestionarSolicitudes.aspx");
        }

        protected void btnRechazar_Click(object sender, EventArgs e)
        {
            alumnoBO.eliminarAlumno(alumno);
            Response.Redirect("GestionarSolicitudes.aspx");
        }

        protected void btnConfirmar_Click(object sender, EventArgs e)
        {
            if (alumno.estado.Equals(estadoAlumno.Pendiente))
            {
                alumno.username = txtUsuario.Text;
                alumno.password = txtContraseña.Text;
                alumno.codigoAlumno = Int32.Parse(txtCodigo.Text);
                alumno.estado = estadoAlumno.Por_Pagar;
            }
            else if (alumno.estado.Equals(estadoAlumno.Por_Pagar))
            {
                alumno.estado = estadoAlumno.Matriculado;
                // Falta lógica para matricular al alumno en todos los cursos de su grado
            }
            Session[alumno.nombreCompleto] = alumno;
            alumnoBO.modificarAlumno(alumno);
            Response.Redirect("GestionarSolicitudes.aspx");
        }

    }
}
