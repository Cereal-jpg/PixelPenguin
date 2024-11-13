﻿using SoftPixelPenguinsWA.ServicioWeb;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Net.Mail;
using System.Net;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Configuration;
using System.Collections;

namespace SoftPixelPenguinsWA
{
    public partial class GestionarSolicitudesDetalleAdmin : System.Web.UI.Page
    {
        AlumnoWSClient alumnoBO = new AlumnoWSClient();
        GradoAcademicoWSClient gradoAcademicoBO = new GradoAcademicoWSClient();
        SeccionAcademicaWSClient seccionAcademicaBO = new SeccionAcademicaWSClient();
        AnioAcademicoWSClient anioAcademicoBO = new AnioAcademicoWSClient();
        MatriculaWSClient matriculaBO = new MatriculaWSClient();
        ApoderadoWSClient apoderadoBO = new ApoderadoWSClient();
        NotaWSClient notaBO = new NotaWSClient();
        CursoWSClient cursoBO = new CursoWSClient();
        CompetenciaWSClient competenciaBO = new CompetenciaWSClient();
        alumno alumno = null;

        protected void Page_Load(object sender, EventArgs e)
        {
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
                alumno.gradoAcademico = gradoAcademicoBO.obtenerGradoAcademicoPorId(alumno.gradoAcademico.idGradoAcademico);
                txtGradoAcademico.Text = alumno.gradoAcademico.numeroGrado.ToString() + "° " + alumno.gradoAcademico.nivel.ToString();
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
            if (alumno.estado.Equals(estadoAlumno.Por_Pagar) || alumno.estado.Equals(estadoAlumno.Matriculado))
            {
                txtUsuario.Enabled = false;
                txtContraseña.Enabled = false;
                txtCodigo.Enabled = false;
                if (alumno.estado.Equals(estadoAlumno.Matriculado))
                {
                    txtCodigo.Enabled = false;
                    txtUsuario.Enabled = false;
                    txtContraseña.Enabled = false;
                    btnConfirmarSolicitud.Visible = false;
                    btnRechazarSolicitud.Visible = false;
                }
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
            try
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
                string cuerpo = $"Hola {alumno.nombreCompleto},\n\nFelicidades, has sido matriculado en nuestra institución.\n" +
                            $"Tu nuevo usuario es: {alumno.username}\n" +
                            $"Tu nueva contraseña es: {alumno.password}\n" +
                            $"Tu nuevo codigo es: {alumno.codigoAlumno}\n" +
                            "Gracias por elegir nuestra institución\n" +
                            "Atentamente, \nEquipoAdministrativo PixelPenguins";
                enviarCorreo(/*"a20220749@pucp.edu.pe"*/alumno.email.ToString(), "Confirmación de Matrícula", cuerpo);

                // Redirigir después de enviar el correo
                Response.Redirect("GestionarSolicitudesAdmin.aspx");
            }
            catch (Exception ex)
            {
                // Manejar errores
                Console.WriteLine("Ocurrió un error: " + ex.Message);
            }
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
                    // ya no se va a usar acá
                    // insercionNotasNuevoAlumno(matricula);
                }
                Session["gradoSeleccionado"] = null;
            }
            else
            {
                throw new Exception();
            }
        }

        //private void insercionNotasNuevoAlumno(matricula matricula)
        //{
        //    BindingList<curso> cursos = new BindingList<curso>(cursoBO.listarCursosPorGrado(matricula.gradoAcademico.idGradoAcademico));
        //    foreach (curso aux in cursos)
        //    {
        //        BindingList<competencia> competencias = new BindingList<competencia>(competenciaBO.listarCompetenciasPorCurso(aux.idCurso));
        //        foreach (competencia auxComp in competencias)
        //        {
        //            for (int i = 1; i <= 4; i++)
        //            {
        //                nota nota = new nota
        //                {
        //                    fid_Matricula = matricula.idMatricula,
        //                    fid_Alumno = alumno.idUsuario,
        //                    // los alumnos comienzan con nota default 
        //                    nota1 = "-",
        //                    bimestre = i,
        //                    curso = aux,
        //                    competencia = auxComp,
        //                };
        //                notaBO.insertarNota(nota);
        //            }
        //        }
        //    }
        //}

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
                Response.Write("Correo enviado exitosamente.");
            }
            catch (Exception ex)
            {
                // Mostrar el error completo para depuración
                Response.Write("Error al enviar el correo: " + ex.ToString());
            }
        }
    }
}