using SoftPixelPenguinsWA.ServicioWeb;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace SoftPixelPenguinsWA
{
    public partial class GestionarSolicitudesAdmin : System.Web.UI.Page
    {
        AlumnoWSClient alumnoBO = new AlumnoWSClient();
        ApoderadoWSClient apoderadoBO = new ApoderadoWSClient();

        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {
                cargarEstados();
                cargarAlumnos();
            }
        }

        private void cargarAlumnos()
        {
            if (Enum.TryParse<estadoAlumno>(ddlEstado.SelectedValue, out estadoAlumno estadoSeleccionado))
            {
                gvAlumnos.DataSource = alumnoBO.listarAlumnosPorNombreYEstado(txtBuscarAlumno.Text, estadoSeleccionado);
                gvAlumnos.DataBind();
            }
            else
            {
                gvAlumnos.DataSource = alumnoBO.listarAlumnosPorNombre(txtBuscarAlumno.Text);
                gvAlumnos.DataBind();
            }
        }

        private void cargarEstados()
        {
            ddlEstado.DataSource = Enum.GetValues(typeof(estadoAlumno));
            ddlEstado.DataBind();
            ddlEstado.Items.Insert(0, new ListItem("Seleccionar estado", ""));
        }

        protected void ddlEstado_SelectedIndexChanged(object sender, EventArgs e)
        {
            cargarAlumnos();
        }

        protected void lbBuscar_Click(object sender, EventArgs e)
        {
            cargarAlumnos();
        }

        protected void lbVisualizar_Click(object sender, EventArgs e)
        {
            LinkButton lnk = (LinkButton)sender;
            int idUsuario = int.Parse(lnk.CommandArgument);
            Response.Redirect("GestionarSolicitudesDetalleAdmin.aspx?idUsuario=" + idUsuario);
        }

        protected void lbEliminar_Click(object sender, EventArgs e)
        {
            LinkButton lnk = (LinkButton)sender;
            int idUsuario = int.Parse(lnk.CommandArgument);
            alumno alumno = new alumno { idUsuario = idUsuario, idUsuarioSpecified = true };
            alumnoBO.eliminarAlumno(alumno);
            Response.Redirect("GestionarSolicitudesPA.aspx");
        }

        protected void gvAlumnos_PageIndexChanging(object sender, GridViewPageEventArgs e)
        {
            gvAlumnos.PageIndex = e.NewPageIndex;
            cargarAlumnos();
        }

    }
}