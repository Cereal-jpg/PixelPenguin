using SoftPixelPenguinsWA.ServicioWeb;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.HtmlControls;
using System.Web.UI.WebControls;

namespace SoftPixelPenguinsWA.Flujo_Generico
{
    public partial class ConsultarMatriculaUserGenerico : System.Web.UI.Page
    {
        AlumnoWSClient alumnoBO = new AlumnoWSClient();
        RolWSClient rolBo = new RolWSClient();
        ApoderadoWSClient apoderadoBO = new ApoderadoWSClient();
        GradoAcademicoWSClient gradoBO = new GradoAcademicoWSClient();
        alumno alumnoLogueado = null;
        usuario usuario = null;
        UsuarioWSClient usuarioBO = new UsuarioWSClient();
        int idUser = 0;
        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {
                // Verifica si la página actual es el index
                if (Session["idUserGenerico"] != null)
                {
                    // Verifica si la página actual es el index
                    if (Request.Url.AbsolutePath.EndsWith("ConsultarMatriculaUserGenerico.aspx", StringComparison.OrdinalIgnoreCase))
                    {
                        // Oculta el menú deseado
                        ContentPlaceHolder menuItem4 = (ContentPlaceHolder)Master.FindControl("menuItem4");
                        ContentPlaceHolder menuItem5 = (ContentPlaceHolder)Master.FindControl("menuItem5");
                        ContentPlaceHolder menuItem6 = (ContentPlaceHolder)Master.FindControl("menuItem6");
                        ContentPlaceHolder menuItem7 = (ContentPlaceHolder)Master.FindControl("menuItem7");
                        if (menuItem7 != null && menuItem6 != null && menuItem5 != null && menuItem4 != null)
                        {
                            menuItem4.Visible = false;
                            menuItem5.Visible = false;
                            menuItem6.Visible = false;
                            menuItem7.Visible = false;
                        }
                    }
                }
                
                BindingList<gradoAcademico> grados = new BindingList<gradoAcademico>(gradoBO.listarTodosGradosAcademicos());
                foreach (gradoAcademico grado in grados)
                {
                    string textoItem = $"{grado.nivel}  {grado.numeroGrado} ({grado.vacantes - grado.cantidadAlumnos} vacantes restantes)";
                    string valorItem = grado.idGradoAcademico.ToString();
                    ddlGrados.Items.Add(new ListItem(textoItem, valorItem));
                }
                ddlGrados.Items.Insert(0, new ListItem("Seleccione un Grado Academico", ""));

                idUser = (int)Session["idUserGenerico"];
                alumnoLogueado = alumnoBO.obtenerAlumnoPorId(idUser);
                SetActiveStep(0);
                UpdateSectionTitle(0);
                if (alumnoLogueado.estado.ToString() == "Por_Pagar")
                {
                    nextSection(sender, e);
                    nextSection(sender, e);
                    nextSection(sender, e);
                }
                else
                {
                    if(alumnoLogueado.estado.ToString() == "Matriculado")
                    {
                        nextSection(sender, e);
                    }
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

            if(Session["idUserGenerico"] != null)
            {
                idUser = (int)Session["idUserGenerico"];
                usuario = usuarioBO.obtenerUsuarioPorId(idUser);
                alumno alumno = new alumno
                {
                    rol = rolBo.obtenerRolPorId(1),
                    dni = usuario.dni,
                    nombreCompleto = usuario.nombreCompleto,
                    fechaNacimiento = usuario.fechaNacimiento,
                    fechaNacimientoSpecified = true,
                    direccion = usuario.direccion,
                    email = usuario.email,
                    sexo = usuario.sexo,
                    username = usuario.username,
                    password = usuario.password,
                    apoderado = apoderado,
                    gradoAcademico = gradoBO.obtenerGradoAcademicoPorId(int.Parse(ddlGrados.SelectedValue)),
                    codigoAlumno = DateTime.Now.Year * 1000 + int.Parse(usuario.dni.Substring(4, 3)),
                    certificadoDeEstudios = fileCertificadoEstudios.FileBytes,
                    certificadoDeSalud = fileCertificadoSalud.FileBytes,
                    conDeuda = false,
                    estado = estadoAlumno.Pendiente,
                    estadoSpecified = true
                };

                alumnoBO.insertarAlumno(alumno);
                nextSection(sender, e);
            }
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
                    Response.Redirect("Matricularce.aspx");
                }
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
            string[] sectionTitles = { "Datos Personales", "Grado y Cetificados", "Boucher de Pago", "Terminar Proceso" };

            if (sectionIndex >= 0 && sectionIndex < sectionTitles.Length)
            {
                sectionTitle.InnerText = sectionTitles[sectionIndex];
            }
        }


        protected void btnGuardarBoucher_Click(object sender, EventArgs e)
        {
            Session["comprobantePago"] = fileBoucherPago.FileBytes;
            nextSection(sender, e);
        }

        protected void btnVolver_Click(object sender, EventArgs e)
        {
            Response.Redirect("Matricularse.aspx");
        }

    }
}