using SoftPixelPenguinsWA.SoftPixelPenguinsWS;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace SoftPixelPenguinsWA
{
    public partial class MatriculaGenerica_1 : System.Web.UI.Page
    {
        AlumnoWSClient alumnoBO = new AlumnoWSClient();
        RolWSClient rolBo = new RolWSClient();
        ApoderadoWSClient apoderadoBO =  new ApoderadoWSClient();
        protected void Page_Load(object sender, EventArgs e)
        {
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
            alumnoBO.insertarAlumno(alumno);
        }
    }
}