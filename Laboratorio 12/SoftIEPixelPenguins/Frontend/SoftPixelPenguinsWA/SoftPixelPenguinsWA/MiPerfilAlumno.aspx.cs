using SoftPixelPenguinsWA.ServicioWeb;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
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
            
            string idUsuario = Request.QueryString["idUsuario"];
            if (idUsuario != null)
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
                    txtApellidoMaterno.Text = ""; // Si no hay apellido paterno, dejar en blanco
                }
            }

            dtpFechaNacimiento.Text = alumno.fechaNacimiento.ToString("yyyy-MM-dd");
            txtSexo.Text = alumno.sexo;
            txtEmail.Text = alumno.email;
            txtDireccion.Text = alumno.direccion;
            alumno.apoderado = apoderadoBO.obtenerApoderadoPorId(alumno.apoderado.idApoderado);
            txtDNIApoderado.Text = alumno.apoderado.dni.ToString();
            txtNombreApoderado.Text = alumno.apoderado.nombreCompleto;
            txtTelefonoApoderado.Text = alumno.apoderado.telefono.ToString();
            txtRelacionApoderado.Text = alumno.apoderado.relacion;
            //ddlGrados.SelectedValue = alumno.gradoAcademico.idGradoAcademico.ToString();
            //lnkDescargarEstudios.Visible = true;
            //lnkDescargarSalud.Visible = true;
            deshabilitarComponentes();
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
        }
        protected void lnkDescargarEstudios_Click(object sender, EventArgs e)
        {
            //alumnoLogueado = alumnoBO.obtenerAlumnoPorId((int)Session["idAlumnoLogueado"]);
            //if (alumnoLogueado != null)
            //{
            //    byte[] archivoBytes = alumnoLogueado.certificadoDeEstudios;
            //    if (archivoBytes != null && archivoBytes.Length > 0)
            //    {
            //        Response.Clear();
            //        Response.ContentType = "application/pdf";
             //       Response.AddHeader("Content-Disposition", "attachment; filename=certificadoDeEstudios.pdf");
            //        Response.BinaryWrite(archivoBytes);
            //        Response.End();
            //    }
            //}
        }

        protected void lnkDescargarSalud_Click(object sender, EventArgs e)
        {
            //alumnoLogueado = alumnoBO.obtenerAlumnoPorId((int)Session["idAlumnoLogueado"]);
            //if (alumnoLogueado != null)
            //{
            //    byte[] archivoBytes = alumnoLogueado.certificadoDeSalud;
            //    if (archivoBytes != null && archivoBytes.Length > 0)
            //    {
            //        Response.Clear();
            //        Response.ContentType = "application/pdf";
            //        Response.AddHeader("Content-Disposition", "attachment; filename=certificadoDeSalud.pdf");
             //       Response.BinaryWrite(archivoBytes);
             //       Response.End();
             //   }
            //}
        }

        protected void btnGuardar_Click(object sender, EventArgs e)
        {
            apoderado apoderado = new apoderado
            {
               dni = txtDNIApoderado.Text,
                nombreCompleto = txtNombreApoderado.Text,
                telefono = txtTelefonoApoderado.Text,
                relacion = txtRelacionApoderado.Text,
            };
            if (Session["idAlumnoLogueado"] != null)
            {
                //alumnoLogueado = alumnoBO.obtenerAlumnoPorId((int)Session["idAlumnoLogueado"]);
                //apoderado.idApoderado = alumnoLogueado.apoderado.idApoderado;
            }
            else
            {
                apoderado.idApoderado = apoderadoBO.insertarApoderado(apoderado);
            }
            alumno alumno = new alumno
            {
                //rol = rolBo.obtenerRolPorId(1),
                dni = txtDNIAlumno.Text,
                nombreCompleto = String.Concat(txtNombreAlumno.Text, " ", txtApellidoPaterno.Text, " ", txtApellidoMaterno.Text),
                fechaNacimiento = DateTime.Parse(dtpFechaNacimiento.Text),
                fechaNacimientoSpecified = true,
                direccion = txtDireccion.Text,
                email = txtEmail.Text,
                sexo = txtSexo.Text,
                username = null,
                password = null,
                apoderado = apoderado,
                //gradoAcademico = gradoBO.obtenerGradoAcademicoPorId(int.Parse(ddlGrados.SelectedValue)),
                codigoAlumno = 0,
                //certificadoDeEstudios = fileCertificadoEstudios.FileBytes,
                //certificadoDeSalud = fileCertificadoSalud.FileBytes,
                conDeuda = false,
                estado = estadoAlumno.Pendiente,
                estadoSpecified = true
            };
            Session["nombreSesion"] = alumno.nombreCompleto;
            if (Session["idAlumnoLogueado"] != null)
            {
                //alumno.idUsuario = alumnoLogueado.idUsuario;
                //alumno.username = alumnoLogueado.username;
                //alumno.password = alumnoLogueado.password;
                //alumno.codigoAlumno = alumnoLogueado.codigoAlumno;
                //if (!fileCertificadoEstudios.HasFile) alumno.certificadoDeEstudios = alumnoLogueado.certificadoDeEstudios;
                //if (!fileCertificadoSalud.HasFile) alumno.certificadoDeSalud = alumnoLogueado.certificadoDeSalud;
                alumnoBO.modificarAlumno(alumno);
            }
            else
            {
                alumnoBO.insertarAlumno(alumno);
            }
            //nextSection(sender, e);
        }

    }
}