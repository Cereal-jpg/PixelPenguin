using SoftPixelPenguinsWA.SoftPixelPenguinsWS;
using System;
using System.Web.UI.HtmlControls;

namespace SoftPixelPenguinsWA
{
    public partial class MatriculaGenerica_1 : System.Web.UI.Page
    {
        AlumnoWSClient alumnoBO = new AlumnoWSClient();
        RolWSClient rolBo = new RolWSClient();
        ApoderadoWSClient apoderadoBO =  new ApoderadoWSClient();
        protected void Page_Load(object sender, EventArgs e)
        {
            if (section3.Style["display"] != "block") Timer1.Enabled = false;
            if (section5.Style["display"] != "block") Timer2.Enabled = false;
            if (!IsPostBack)
            {
                SetActiveStep(0);
                UpdateSectionTitle(0);
            }
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
            apoderado.idApoderado = apoderadoBO.insertarApoderado(apoderado);
            alumno alumno = new alumno
            {
                rol = rolBo.obtenerRolPorId(1),
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
                gradoAcademico = new gradoAcademico {idGradoAcademico=1 },
                codigoAlumno = 0,
                certificadoDeEstudios = fileCertificadoEstudios.FileBytes,
                certificadoDeSalud = fileCertificadoSalud.FileBytes,
                conDeuda = false,
                estado = estadoAlumno.Pendiente,
                estadoSpecified = true
            };
            Session["nombreSesion"] = alumno.nombreCompleto;
            // No está devolviendo el id
            /*idUsuarioActivo =*/ alumnoBO.insertarAlumno(alumno);
            nextSection(sender,e);
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
                Timer1.Enabled = true;
                SetActiveStep(2);
            }
            else if (section3.Style["display"] == "block")
            {
                section3.Style["display"] = "none";
                section4.Style["display"] = "block";
                SetActiveStep(3);
                UpdateSectionTitle(2);
            }
            else if (section4.Style["display"] == "block")
            {
                section4.Style["display"] = "none";
                section5.Style["display"] = "block";
                SetActiveStep(4);
                Timer2.Enabled = true;
            }
            else if (section5.Style["display"] == "block")
            {
                section5.Style["display"] = "none";
                section6.Style["display"] = "block";
                SetActiveStep(5);
                UpdateSectionTitle(3);
            }

        }

        protected void prevSection(object sender, EventArgs e)
        {
            if (section3.Style["display"] == "block")
            {
                section3.Style["display"] = "none";
                section2.Style["display"] = "block";
            }
            else if (section2.Style["display"] == "block")
            {
                section2.Style["display"] = "none";
                section1.Style["display"] = "block";
            } 
            else if (section1.Style["display"] == "block")
            {
                Response.Redirect("Matricularce.aspx");
            }
        }

        private void SetActiveStep(int stepIndex)
        {
            HtmlGenericControl[] steps = { step1, step2, step3, step4, step5, step6 };

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
            string[] sectionTitles = { "Datos Personales", "Cetificados", "Boucher de Pago", "Terminar Proceso" };

            if (sectionIndex >= 0 && sectionIndex < sectionTitles.Length)
            {
                sectionTitle.InnerText = sectionTitles[sectionIndex];
            }
        }

        protected void Timer_Tick(object sender, EventArgs e)
        {
            alumno alumno = null;
            string nombre = null;
            if ((nombre = (string)Session["nombreSesion"]) != null)
            {
                alumno = (alumno)Session[nombre];
                if (alumno != null && alumno.estado.Equals(estadoAlumno.Por_Pagar) && section3.Style["display"] == "block")
                {
                    Session[nombre] = null;
                    Timer1.Enabled = false;
                    nextSection(sender,e);
                }
                else if(alumno != null && alumno.estado.Equals(estadoAlumno.Matriculado) && section5.Style["display"] == "block")
                {
                    Session[nombre] = null;
                    Session["nombreSesion"] = null;
                    Timer2.Enabled = false;
                    nextSection(sender, e);
                }
            }
        }

        protected void btnVolver_Click(object sender, EventArgs e)
        {
            Response.Redirect("Matricularce.aspx");
        }

        protected void btnGuardarBoucher_Click(object sender, EventArgs e)
        {
            Session["comprobantePago"] = fileBoucherPago.FileBytes;
            nextSection(sender, e);
        }

    }
}