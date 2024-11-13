using SoftPixelPenguinsWA.ServicioWeb;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.ComponentModel.DataAnnotations;
using System.Data.SqlClient;
using System.Diagnostics;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.HtmlControls;
using System.Web.UI.WebControls;

namespace SoftPixelPenguinsWA
{
    public partial class MatriculaGenerica : System.Web.UI.Page
    {
        AlumnoWSClient alumnoBO = new AlumnoWSClient();
        RolWSClient rolBo = new RolWSClient();
        ApoderadoWSClient apoderadoBO = new ApoderadoWSClient();
        GradoAcademicoWSClient gradoBO = new GradoAcademicoWSClient();
        alumno alumnoLogueado = null;
        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {
                SetActiveStep(0);
                UpdateSectionTitle(0);
                BindingList<gradoAcademico> grados = new BindingList<gradoAcademico>(gradoBO.listarTodosGradosAcademicos());
                foreach (gradoAcademico grado in grados)
                {
                    string textoItem = $"{grado.nivel}  {grado.numeroGrado} ({grado.vacantes - grado.cantidadAlumnos} vacantes restantes)";
                    string valorItem = grado.idGradoAcademico.ToString();
                    ddlGrados.Items.Add(new ListItem(textoItem, valorItem));
                }
                ddlGrados.Items.Insert(0, new ListItem("Seleccione un Grado Academico", ""));
                lnkDescargarEstudios.Visible = false;
                lnkDescargarSalud.Visible = false;
                if (Session["idAlumnoLogueado"] != null)
                {
                    cargarValores();
                }
            }
        }

        private void cargarValores()
        {
            alumnoLogueado = alumnoBO.obtenerAlumnoPorId((int)Session["idAlumnoLogueado"]);
            txtDNIAlumno.Text = alumnoLogueado.dni;
            string[] palabras = alumnoLogueado.nombreCompleto.Trim().Split(' ');
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
            dtpFechaNacimiento.Text = alumnoLogueado.fechaNacimiento.ToString("yyyy-MM-dd");
            ddlSexo.SelectedValue = alumnoLogueado.sexo;
            txtEmail.Text = alumnoLogueado.email;
            txtDireccion.Text = alumnoLogueado.direccion;
            alumnoLogueado.apoderado = apoderadoBO.obtenerApoderadoPorId(alumnoLogueado.apoderado.idApoderado);
            txtDNIApoderado.Text = alumnoLogueado.apoderado.dni.ToString();
            txtNombreApoderado.Text = alumnoLogueado.apoderado.nombreCompleto;
            txtTelefonoApoderado.Text = alumnoLogueado.apoderado.telefono.ToString();
            ddlRelacionApoderado.SelectedValue = alumnoLogueado.apoderado.relacion;
            ddlGrados.SelectedValue = alumnoLogueado.gradoAcademico.idGradoAcademico.ToString();
            lnkDescargarEstudios.Visible = true;
            lnkDescargarSalud.Visible = true;
        }

        protected void lnkDescargarEstudios_Click(object sender, EventArgs e)
        {
            alumnoLogueado = alumnoBO.obtenerAlumnoPorId((int)Session["idAlumnoLogueado"]);
            if (alumnoLogueado != null)
            {
                byte[] archivoBytes = alumnoLogueado.certificadoDeEstudios;
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
            alumnoLogueado = alumnoBO.obtenerAlumnoPorId((int)Session["idAlumnoLogueado"]);
            if (alumnoLogueado != null)
            {
                byte[] archivoBytes = alumnoLogueado.certificadoDeSalud;
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

        protected void btnGuardar_Click(object sender, EventArgs e)
        {
            apoderado apoderado = new apoderado
            {
                dni = txtDNIApoderado.Text,
                nombreCompleto = txtNombreApoderado.Text,
                telefono = txtTelefonoApoderado.Text,
                relacion = ddlRelacionApoderado.SelectedValue,
            };
            if (Session["idAlumnoLogueado"] != null)
            {
                alumnoLogueado = alumnoBO.obtenerAlumnoPorId((int)Session["idAlumnoLogueado"]);
                apoderado.idApoderado = alumnoLogueado.apoderado.idApoderado;
            }
            else
            {
                apoderado.idApoderado = apoderadoBO.insertarApoderado(apoderado);
            }


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
                rol = rolBo.obtenerRolPorId(1),
                dni = txtDNIAlumno.Text,
                nombreCompleto = String.Concat(txtNombreAlumno.Text, " ", txtApellidoPaterno.Text, " ", txtApellidoMaterno.Text),
                fechaNacimiento = DateTime.Parse(dtpFechaNacimiento.Text),
                fechaNacimientoSpecified = true,
                direccion = txtDireccion.Text,
                email = txtEmail.Text,
                sexo = ddlSexo.SelectedValue,
                username = null,
                password = null,
                apoderado = apoderado,
                gradoAcademico = gradoBO.obtenerGradoAcademicoPorId(int.Parse(ddlGrados.SelectedValue)),
                codigoAlumno = 0,
                certificadoDeEstudios = fileCertificadoEstudios.FileBytes,
                certificadoDeSalud = fileCertificadoSalud.FileBytes,
                conDeuda = false,
                estado = estadoAlumno.Pendiente,
                estadoSpecified = true
            };

            Session["nombreSesion"] = alumno.nombreCompleto;
            if (Session["idAlumnoLogueado"] != null)
            {
                alumno.idUsuario = alumnoLogueado.idUsuario;
                alumno.username = alumnoLogueado.username;
                alumno.password = alumnoLogueado.password;
                alumno.codigoAlumno = alumnoLogueado.codigoAlumno;
                if (!fileCertificadoEstudios.HasFile) alumno.certificadoDeEstudios = alumnoLogueado.certificadoDeEstudios;
                if (!fileCertificadoSalud.HasFile) alumno.certificadoDeSalud = alumnoLogueado.certificadoDeSalud;
                alumnoBO.modificarAlumno(alumno);
            }
            else
            {
                int idAlumno = alumnoBO.insertarAlumno(alumno);
            }
            nextSection(sender, e);

        }

        protected void nextSection(object sender, EventArgs e)
        {

            if (section1.Style["display"] == "block")
            {
                section1.Style["display"] = "none";
                section2.Style["display"] = "block";
                SetActiveStep(1);
                UpdateSectionTitle(1);
            }
            else if (section2.Style["display"] == "block")
            {
                section2.Style["display"] = "none";
                section3.Style["display"] = "block";
                SetActiveStep(2);
            }
        }

        protected void prevSection(object sender, EventArgs e)
        {
            if (section3.Style["display"] == "block")
            {
                section3.Style["display"] = "none";
                section2.Style["display"] = "block";
                SetActiveStep(1);
            }
            else if (section2.Style["display"] == "block")
            {
                section2.Style["display"] = "none";
                section1.Style["display"] = "block";
                SetActiveStep(0);
            }
            else if (section1.Style["display"] == "block")
            {
                if (Session["idAlumnoLogueado"] != null)
                {
                    Response.Redirect("IndexAlumno.aspx");
                }
                else
                {
                    Response.Redirect("Matricularse.aspx");
                }
            }
        }

        private void SetActiveStep(int stepIndex)
        {
            HtmlGenericControl[] steps = { step1, step2, step3 };

            for (int i = 0; i < steps.Length; i++)
            {
                if (i <= stepIndex)
                {
                    steps[i].Attributes["class"] = "step active";
                }
                else
                {
                    steps[i].Attributes["class"] = "step";
                }
            }
        }

        private void UpdateSectionTitle(int sectionIndex)
        {
            string[] sectionTitles = { "Datos Personales", "Grado y Cetificados" };

            if (sectionIndex >= 0 && sectionIndex < sectionTitles.Length)
            {
                sectionTitle.InnerText = sectionTitles[sectionIndex];
            }
        }

        protected void btnVolver_Click(object sender, EventArgs e)
        {
            Response.Redirect("Matricularse.aspx");
        }

    }
}