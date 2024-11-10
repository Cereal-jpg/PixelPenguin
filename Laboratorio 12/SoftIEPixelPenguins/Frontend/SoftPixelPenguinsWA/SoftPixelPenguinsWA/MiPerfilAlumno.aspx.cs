using SoftPixelPenguinsWA.ServicioWeb;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.ServiceModel.Channels;
using System.Web;
using System.Web.UI;
using System.Web.UI.HtmlControls;
using System.Web.UI.WebControls;

namespace SoftPixelPenguinsWA
{
    public partial class MiPerfilAlumno : System.Web.UI.Page
    {
        AlumnoWSClient alumnoBO = new AlumnoWSClient();
        GradoAcademicoWSClient gradoAcademicoBO = new GradoAcademicoWSClient();
        SeccionAcademicaWSClient seccionAcademicaBO = new SeccionAcademicaWSClient();
        AnioAcademicoWSClient anioAcademicoBO = new AnioAcademicoWSClient();
        MatriculaWSClient matriculaBO = new MatriculaWSClient();
        ApoderadoWSClient apoderadoBO = new ApoderadoWSClient();
        alumno alumno = null;
        RolWSClient rolBO = new RolWSClient();
        GradoAcademicoWSClient gradoBO = new GradoAcademicoWSClient();

        protected void Page_Load(object sender, EventArgs e)
        {

            if (!IsPostBack)
            {
                // Inicializar Datos
                if (Session["idAlumnoLogueado"] != null)
                {
                    // Verifica si la página actual es el index
                    if (Request.Url.AbsolutePath.EndsWith("MiPerfilAlumno.aspx", StringComparison.OrdinalIgnoreCase))
                    {
                        // Oculta el menú deseado
                        ContentPlaceHolder menuItem6 = (ContentPlaceHolder)Master.FindControl("menuItem6");
                        ContentPlaceHolder menuItem7 = (ContentPlaceHolder)Master.FindControl("menuItem7");
                        if (menuItem6 != null && menuItem7 != null)
                        {
                           
                            menuItem7.Visible = false;
                        }
                    }

                    cargarValores();

                }
            }
            
            if (Session["idAlumnoLogueado"] != null)
            {
                int idAlumno = (int)Session["idAlumnoLogueado"];

                alumno = alumnoBO.obtenerAlumnoPorId(idAlumno);
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
                deshabilitarComponentes();
            }
        }

        private void cargarValores()
        {
            alumno = alumnoBO.obtenerAlumnoPorId((int)Session["idAlumnoLogueado"]);
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

            dtpFechaNacimiento.Text = alumno.fechaNacimiento.ToString("yyyy-MM-dd");
            txtSexo.Text = alumno.sexo;
            txtEmail.Text = alumno.email;
            txtDireccion.Text = alumno.direccion;
            txtUsuario.Text = alumno.username;
            txtContrasena.Attributes["value"] = alumno.password;

            // Datos del apoderado
            alumno.apoderado = apoderadoBO.obtenerApoderadoPorId(alumno.apoderado.idApoderado);
            txtDNIApoderado.Text = alumno.apoderado.dni.ToString();
            txtNombreApoderado.Text = alumno.apoderado.nombreCompleto;
            txtTelefonoApoderado.Text = alumno.apoderado.telefono.ToString();
            txtRelacionApoderado.Text = alumno.apoderado.relacion;
            linkDescargarEstudios.Visible = true;
            linkDescargarSalud.Visible = true;
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
        protected void linkDescargarEstudios_Click(object sender, EventArgs e)
        {
            if (alumno != null)
            {
                byte[] archivoBytes = alumno.certificadoDeEstudios;
                if (archivoBytes != null && archivoBytes.Length > 0)
                {
                    Response.Clear();
                    Response.ContentType = "application/pdf";
                    Response.AddHeader("Content-Disposition", "attachment; filename=certificadoDeEstudios.pdf");
                    Response.BinaryWrite(archivoBytes);
                    Response.End();
                }
            }
        }

        protected void linkDescargarSalud_Click(object sender, EventArgs e)
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

        protected void btnGuardar_Click1(object sender, EventArgs e)
        {
            apoderado nuevoApoderado = new apoderado
            {
                idApoderado = alumno.apoderado.idApoderado,
                dni = txtDNIApoderado.Text,
                nombreCompleto = txtNombreApoderado.Text,
                telefono = txtTelefonoApoderado.Text,
                relacion = txtRelacionApoderado.Text,
            };
            if (Session["idAlumnoLogueado"] != null && nuevoApoderado != null)
            {
                apoderadoBO.modificarApoderado(nuevoApoderado);
                
            }
        }
    }
}