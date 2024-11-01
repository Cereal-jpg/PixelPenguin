﻿using SoftPixelPenguinsWA.SoftPixelPenguinsWS;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace SoftPixelPenguinsWA
{
    public partial class GestionarSolicitudes : System.Web.UI.Page
    {
        AlumnoWSClient alumnoBO = new AlumnoWSClient();

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
                gvAlumnos.DataSource = alumnoBO.listarAlumnosPorEstado(estadoSeleccionado);
                gvAlumnos.DataBind();
            }
            else
            {
                gvAlumnos.DataSource = alumnoBO.listarTodosAlumnos();
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

        }

        protected void lbVisualizar_Click(object sender, EventArgs e)
        {
            LinkButton lnk = (LinkButton)sender;
            int idUsuario = int.Parse(lnk.CommandArgument);
            Response.Redirect("GestionarSolicitudes_VerDetalle.aspx?idUsuario=" + idUsuario);
        }

        protected void lbEliminar_Click(object sender, EventArgs e)
        {
            LinkButton lnk = (LinkButton)sender;
            int idUsuario = int.Parse(lnk.CommandArgument);
            alumno alumno = new alumno { idUsuario = idUsuario };
            alumnoBO.eliminarAlumno(alumno);
            Response.Redirect("GestionarSolicitudes.aspx");
        }
    }
}
