using SoftPixelPenguinsWA.ServicioWeb;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace SoftPixelPenguinsWA
{
    public partial class GestionarSolicitudesDetallePA : System.Web.UI.Page
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
                // Verifica si la página actual es el index
                if (Request.Url.AbsolutePath.EndsWith("GestionarSolicitudesDetallePA.aspx", StringComparison.OrdinalIgnoreCase))
                {
                    // Oculta el menú deseado
                    ContentPlaceHolder menuItem7 = (ContentPlaceHolder)Master.FindControl("menuItem7");
                    if (menuItem7 != null)
                    {
                        menuItem7.Visible = false;
                    }
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
                txtGradoAcademico.Text = alumno.gradoAcademico.nivel.ToString() + " " + alumno.gradoAcademico.numeroGrado.ToString();
                if (alumno.estado.Equals(estadoAlumno.Por_Pagar) || alumno.estado.Equals(estadoAlumno.Matriculado))
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
            txtGradoAcademico.Enabled = false;
            if (alumno.estado.Equals(estadoAlumno.Por_Pagar))
            {
                txtUsuario.Enabled = false;
                txtContraseña.Enabled = false;
                txtCodigo.Enabled = false;
            }
        }

        protected void lnkDescargarEstudios_Click(object sender, EventArgs e)
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
            Response.Redirect("GestionarSolicitudesPA.aspx");
        }

        protected void btnRechazar_Click(object sender, EventArgs e)
        {
            apoderadoBO.eliminarApoderado(alumno.apoderado);
            alumnoBO.eliminarAlumno(alumno);
            Response.Redirect("GestionarSolicitudesPA.aspx");
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
                matricularAlumno();
            }
            Session[alumno.nombreCompleto] = alumno;
            alumnoBO.modificarAlumno(alumno);
            Response.Redirect("GestionarSolicitudesPA.aspx");
        }

        private void matricularAlumno()
        {
            gradoAcademico grado = gradoAcademicoBO.obtenerGradoAcademicoPorId(alumno.gradoAcademico.idGradoAcademico);
            if (grado != null && grado.cantidadAlumnos < grado.vacantes)
            {
                BindingList<seccionAcademica> secciones = new BindingList<seccionAcademica>(seccionAcademicaBO.listarSeccionesPorGrado(grado));
                grado.cantidadAlumnos++;
                gradoAcademicoBO.modificarGradoAcademico(grado);
                seccionAcademica seccionMatricula = null;
                foreach (seccionAcademica seccion in secciones)
                {
                    if (seccion.cantidadAlumnos < seccion.vacantes)
                    {
                        seccionMatricula = seccion;
                        seccion.cantidadAlumnos++;
                        seccionAcademicaBO.modificarSeccionAcademica(seccion);
                        break;
                    }
                }

                if (seccionMatricula != null)
                {
                    matricula matricula = new matricula
                    {
                        fidAlumno = alumno.idUsuario,
                        // Suponiendo el anio académico 2025 por ahora
                        anioAcademico = anioAcademicoBO.obtenerAnioAcademicoPorId(1),
                        gradoAcademico = grado,
                        seccionAcademica = seccionMatricula

                    };
                    matriculaBO.insertarMatricula(matricula);
                }
                Session["gradoSeleccionado"] = null;
            }
            else
            {
                throw new Exception();
            }
        }
    }
}

















































