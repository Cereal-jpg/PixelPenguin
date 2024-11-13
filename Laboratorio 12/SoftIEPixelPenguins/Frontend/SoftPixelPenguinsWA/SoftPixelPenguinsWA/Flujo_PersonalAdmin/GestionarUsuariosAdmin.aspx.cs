using SoftPixelPenguinsWA.ServicioWeb;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.IO;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace SoftPixelPenguinsWA
{
    public partial class GestionarUsuariosAdmin : System.Web.UI.Page
    {
        private RolWSClient rolBO = new RolWSClient();
        private UsuarioWSClient usuarioBO = new UsuarioWSClient();
        private AlumnoWSClient alumnoBO = new AlumnoWSClient();
        private ProfesorWSClient profesorBO = new ProfesorWSClient();
        private PersonalAdministrativoWSClient personalBO = new PersonalAdministrativoWSClient();

        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {
                if (Session["idAdmin"] != null) panelGestionarUsuarios.Visible = true;
                CargarRoles();
                CargarUsuarios();
            }
        }

        private void CargarUsuarios()
        {
            var usuariosList = usuarioBO.listarUsuariosPorNombre(txtBuscarUsuario.Text);
            if (usuariosList != null)
            {
                BindingList<usuario> usuarios = new BindingList<usuario>(usuariosList);
                foreach (usuario usu in usuarios) usu.rol = rolBO.obtenerRolPorId(usu.rol.idRol);
                gvUsuarios.DataSource = usuarios;
            }
            else
            {
                gvUsuarios.DataSource = null;
            }
            gvUsuarios.DataBind();
        }

        private void CargarRoles()
        {
            ddlRoles.DataSource = new BindingList<rol>(rolBO.listarTodosRoles());
            ddlRoles.DataTextField = "nombre";
            ddlRoles.DataValueField = "idRol";
            ddlRoles.DataBind();
            ddlRoles.Items.Insert(0, new ListItem("Seleccione un rol", ""));
        }

        protected void lbRegresar_Click(object sender, EventArgs e)
        {
            Session["idUsuarioSeleccionado"] = null;
            ClientScript.RegisterStartupScript(this.GetType(), "ClearAndCloseModal", "clearAndCloseModal()", true);
        }

        protected void lbGuardar_Click(object sender, EventArgs e)
        {
            int? idUsuarioSeleccionado = (int?)Session["idUsuarioSeleccionado"];
            int rolSeleccionado = ddlRoles.SelectedIndex;

            switch (rolSeleccionado)
            {
                case 1: // Alumno
                    alumno alumno = new alumno
                    {
                        dni = dni.Value,
                        nombreCompleto = nombreCompleto.Value,
                        fechaNacimiento = DateTime.Parse(dtpFechaNacimiento.Value),
                        fechaNacimientoSpecified = true,
                        direccion = direccion.Value,
                        email = userEmail.Value,
                        sexo = sexo.Value,
                        username = username.Value,
                        password = password.Value,
                        codigoAlumno = int.Parse(codigoAlumno.Text),
                        conDeuda = conDeuda.Checked,
                        apoderado = new apoderado { idApoderado = int.Parse(apoderado.Text) },
                        gradoAcademico = new gradoAcademico { idGradoAcademico = int.Parse(gradoAcademico.Text) },
                        rol = rolBO.obtenerRolPorId(1)
                    };
                    if (!idUsuarioSeleccionado.HasValue)
                    {
                        alumnoBO.insertarAlumno(alumno);
                    }
                    else
                    {
                        alumno.idUsuario = idUsuarioSeleccionado.Value;
                        alumnoBO.modificarAlumno(alumno);
                    }
                    break;

                case 2: // Profesor
                    profesor profesor = new profesor
                    {
                        dni = dni.Value,
                        nombreCompleto = nombreCompleto.Value,
                        fechaNacimiento = DateTime.Parse(dtpFechaNacimiento.Value),
                        fechaNacimientoSpecified = true,
                        direccion = direccion.Value,
                        email = userEmail.Value,
                        sexo = sexo.Value,
                        username = username.Value,
                        password = password.Value,
                        codigoProfesor = int.Parse(codigoProfesor.Text),
                        especialidad = especialidad.Text,
                        rol = rolBO.obtenerRolPorId(2)
                    };

                    if (fileCertificadoEducativo.HasFile)
                    {
                        profesor.certificadoHistorialEducativo = fileCertificadoEducativo.FileBytes;
                    }
                    else
                    {
                        throw new Exception("Debe seleccionar un archivo para el certificado educativo.");
                    }

                    if (!idUsuarioSeleccionado.HasValue)
                    {
                        profesorBO.insertarProfesor(profesor);
                    }
                    else
                    {
                        profesor.idUsuario = idUsuarioSeleccionado.Value;
                        profesorBO.modificarProfesor(profesor);
                    }
                    break;

                case 3: // Personal Administrativo
                    personalAdministrativo personal = new personalAdministrativo
                    {
                        dni = dni.Value,
                        nombreCompleto = nombreCompleto.Value,
                        fechaNacimiento = DateTime.Parse(dtpFechaNacimiento.Value),
                        fechaNacimientoSpecified = true,
                        direccion = direccion.Value,
                        email = userEmail.Value,
                        sexo = sexo.Value,
                        username = username.Value,
                        password = password.Value,
                        codigoPersonalAdministrativo = int.Parse(codigoPersonalAdministrativo.Text),
                        rol = rolBO.obtenerRolPorId(3)
                    };
                    if (!idUsuarioSeleccionado.HasValue)
                    {
                        personalBO.insertarPersonalAdministrativo(personal);
                    }
                    else
                    {
                        personal.idUsuario = idUsuarioSeleccionado.Value;
                        personalBO.modificarPersonalAdministrativo(personal);
                    }
                    break;
            }
            Session["idUsuarioSeleccionado"] = null;
            Response.Redirect("GestionarUsuariosAdmin.aspx");
        }

        protected void lbEditar_Click(object sender, EventArgs e)
        {
            lblTitulo.Text = "Editar Usuario";
            LinkButton lnk = (LinkButton)sender;
            int idUsuario = int.Parse(lnk.CommandArgument);
            Session["idUsuarioSeleccionado"] = idUsuario;
            usuario usuario = usuarioBO.obtenerUsuarioPorId(idUsuario);

            if (usuario != null)
            {
                dni.Value = usuario.dni;
                nombreCompleto.Value = usuario.nombreCompleto;
                dtpFechaNacimiento.Value = usuario.fechaNacimiento.ToString("yyyy-MM-dd");
                direccion.Value = usuario.direccion;
                userEmail.Value = usuario.email;
                sexo.Value = usuario.sexo;
                username.Value = usuario.username;
                password.Value = usuario.password;
                if (usuario.rol.idRol == 1)
                {
                    ddlRoles.SelectedIndex = 1;
                    ddlRoles.Enabled = false;
                    alumno alumno = alumnoBO.obtenerAlumnoPorId(idUsuario);
                    codigoAlumno.Text = alumno.codigoAlumno.ToString();
                    conDeuda.Checked = alumno.conDeuda;
                    apoderado.Text = alumno.apoderado.idApoderado.ToString();
                    gradoAcademico.Text = alumno.gradoAcademico.idGradoAcademico.ToString();

                }
                else if (usuario.rol.idRol == 2)
                {
                    ddlRoles.SelectedIndex = 2;
                    ddlRoles.Enabled = false;
                    profesor profesor = profesorBO.obtenerProfesorPorId(idUsuario);
                    codigoProfesor.Text = profesor.codigoProfesor.ToString();
                    // Asumiendo que 'profesor' es el objeto que contiene el certificado actual
                    if (fileCertificadoEducativo.HasFile) // Si el usuario subió un nuevo archivo
                    {
                        // Leer el nuevo archivo como byte[]
                        using (BinaryReader reader = new BinaryReader(fileCertificadoEducativo.PostedFile.InputStream))
                        {
                            profesor.certificadoHistorialEducativo = reader.ReadBytes(fileCertificadoEducativo.PostedFile.ContentLength);
                        }
                    }
                    else
                    {
                        // Mantener el certificado actual si no se sube uno nuevo
                        profesor.certificadoHistorialEducativo = profesor.certificadoHistorialEducativo;
                    }

                    // Continuar con el proceso de edición o actualización del objeto `profesor`

                    especialidad.Text = profesor.especialidad.ToString();
                }
                else
                {
                    ddlRoles.SelectedIndex = 3;
                    ddlRoles.Enabled = false;
                    personalAdministrativo personalAdministrativo = personalBO.obtenerPersonalAdministrativoPorId(idUsuario);
                    codigoPersonalAdministrativo.Text = personalAdministrativo.codigoPersonalAdministrativo.ToString();
                }
                ScriptManager.RegisterStartupScript(this, GetType(), "MostrarCampos", "mostrarCampos();", true);
                ScriptManager.RegisterStartupScript(this, GetType(), "ShowModal", "openModal();", true);
            }
        }

        protected void gvUsuarios_PageIndexChanging(object sender, GridViewPageEventArgs e)
        {
            gvUsuarios.PageIndex = e.NewPageIndex;
            CargarUsuarios();
        }


        protected void lbEliminar_Click(object sender, EventArgs e)
        {
            LinkButton lnk = (LinkButton)sender;
            int idUsuario = int.Parse(lnk.CommandArgument);
            usuario usuario = new usuario { idUsuario = idUsuario, idUsuarioSpecified = true };
            usuarioBO.eliminarUsuario(usuario);
            Response.Redirect("GestionarUsuariosAdmin.aspx");
        }

        protected void lbBuscar_Click(object sender, EventArgs e)
        {
            CargarUsuarios();
        }


    }
}