using SoftPixelPenguinsWA.ServicioWeb;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace SoftPixelPenguinsWA
{
    public partial class GestionarHorariosPA : System.Web.UI.Page
    {
        private CursoWSClient cursoBO = new CursoWSClient();
        private HoraAcademicaWSClient horaAcademicaBO = new HoraAcademicaWSClient();
        private GradoAcademicoWSClient gradoAcademicoBO = new GradoAcademicoWSClient();
        private SeccionAcademicaWSClient seccionAcademicaBO = new SeccionAcademicaWSClient();
        private int idCurso;
        private curso curso;
        private BindingList<seccionAcademica> secciones;

        protected void Page_Load(object sender, EventArgs e)
        {
            string id = Request.QueryString["idCurso"];
            idCurso = int.Parse(id);
            curso = cursoBO.obtenerCursoPorId(idCurso);
            curso.gradoAcademico = gradoAcademicoBO.obtenerGradoAcademicoPorId(curso.gradoAcademico.idGradoAcademico);
            if (!IsPostBack)
            {
                cargarHorarios();
                cargarSecciones();
                cargarDias();
            }
        }

        private void cargarSecciones()
        {
            secciones = new BindingList<seccionAcademica>(seccionAcademicaBO.listarSeccionesPorGrado(curso.gradoAcademico));
            foreach (seccionAcademica seccion in secciones)
            {
                ddlSeccion.Items.Add(new ListItem(Convert.ToChar(seccion.seccion).ToString(), seccion.idSeccionAcademica.ToString()));
            }

            ddlSeccion.Items.Insert(0, new ListItem("Seleccione una sección", ""));
        }

        private void cargarDias()
        {
            foreach (diaSemana dia in Enum.GetValues(typeof(diaSemana)))
            {
                ddlDia.Items.Add(new ListItem(dia.ToString(), ((int)dia).ToString()));
            }
            ddlDia.Items.Insert(0, new ListItem("Seleccione un día", ""));
        }

        private void cargarHorarios()
        {
            List<horaAcademica> horas = (horaAcademicaBO.listarHorasAcademicasPorCurso(curso) ?? Array.Empty<horaAcademica>()).ToList();
            if (horas.Count > 0)
            {
                foreach (horaAcademica hora in horas) hora.seccionAcademica = seccionAcademicaBO.obtenerSeccionAcademicaPorId(hora.seccionAcademica.idSeccionAcademica);
                gvHorarios.DataSource = horas;
                gvHorarios.DataBind();
            }
        }

        protected void btnGuardarHorario_Click(object sender, EventArgs e)
        {
            seccionAcademica seccion = seccionAcademicaBO.obtenerSeccionAcademicaPorId(int.Parse(ddlSeccion.SelectedValue));

            horaAcademica hora = new horaAcademica
            {
                curso = curso,
                dia = (diaSemana)Enum.Parse(typeof(diaSemana), ddlDia.SelectedValue),
                diaSpecified = true,
                seccionAcademica = seccion,
                horaInicio = txtHoraInicio.Text,
                horaFin = txtHoraFin.Text
            };
            horaAcademicaBO.insertarHoraAcademica(hora);
            Response.Redirect("GestionarHorariosPA.aspx?idCurso=" + idCurso);
        }

        protected void lbEliminar_Click(object sender, EventArgs e)
        {
            LinkButton lnk = (LinkButton)sender;
            int idHoraAcademica = int.Parse(lnk.CommandArgument);
            horaAcademica hora = new horaAcademica {idHoraAcademica = idHoraAcademica, idHoraAcademicaSpecified=true };
            horaAcademicaBO.eliminarHoraAcademica(hora);
            Response.Redirect("GestionarHorariosPA.aspx?idCurso=" + idCurso);
        }

        protected void btnRegresar_Click(object sender, EventArgs e)
        {
            Response.Redirect("CursosYHorariosPA.aspx");
        }

    }
}