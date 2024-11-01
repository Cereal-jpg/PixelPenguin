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
    public partial class MatriculaGenerica_1 : System.Web.UI.Page
    {
        AlumnoWSClient alumnoBO = new AlumnoWSClient();
        RolWSClient rolBo = new RolWSClient();
        private int idUsuarioActivo = 0;
        ApoderadoWSClient apoderadoBO =  new ApoderadoWSClient();
        protected void Page_Load(object sender, EventArgs e)
        {
            if(section3.Style["display"] != "block")Timer1.Enabled = false;
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
            idUsuarioActivo = alumnoBO.insertarAlumno(alumno);
            nextSection(sender,e);
        }

        protected void nextSection(object sender, EventArgs e)
        {
            if (section1.Style["display"] == "block")
            {
                section1.Style["display"] = "none";
                section2.Style["display"] = "block";
            }
            else if (section2.Style["display"] == "block")
            {
                section2.Style["display"] = "none";
                section3.Style["display"] = "block";
                Timer1.Enabled = true;
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

        protected void Timer1_Tick(object sender, EventArgs e)
        {
            alumno alumno = null;
            if(idUsuarioActivo != 0) alumno = alumnoBO.obtenerAlumnoPorId(idUsuarioActivo);
            if (alumno!=null && alumno.estado.Equals(estadoAlumno.Por_Pagar)){
                Timer1.Enabled = false;
                Response.Redirect("Login.aspx");
            }
        }
    }
}