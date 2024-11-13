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

            alumnoBO.insertarAlumno(alumno);
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
                Response.Redirect("Matricularse.aspx");
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