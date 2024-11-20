using SoftPixelPenguinsWA.ServicioWeb;
using System;
using System.Collections.Generic;
using System.Data; // Para trabajar con DataTable
using System.Linq;
using System.Web.UI.WebControls;

namespace SoftPixelPenguinsWA.Flujo_PersonalAdmin
{
    public partial class GestionarPagosPA : System.Web.UI.Page
    {
        PagoWSClient pagoBO = new PagoWSClient();
        MatriculaWSClient matriculaBO = new MatriculaWSClient();
        UsuarioWSClient usuarioBO = new UsuarioWSClient();
        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {

                // Carga los pagos al cargar la página por primera vez

                CargarPagos();
            }
        }

        /// <summary>
        /// Carga los pagos en el GridView.
        /// </summary>
        private void CargarPagos()
        {
            // Aquí deberías llamar a tu capa de acceso a datos para obtener los pagos.
            // Por simplicidad, usamos un DataTable de ejemplo.
            DataTable pagos = ObtenerPagos();

            gvPagos.DataSource = pagos;
            gvPagos.DataBind();
        }

        /// <summary>
        /// Simula la obtención de datos de pagos desde una base de datos.
        /// </summary>
        /// <returns>Un DataTable con los pagos.</returns>
        private DataTable ObtenerPagos()
        {
            DataTable dt = new DataTable();
            dt.Columns.Add("IdPago", typeof(int));
            dt.Columns.Add("NombreAlumno", typeof(string));
            dt.Columns.Add("Monto", typeof(decimal));
            dt.Columns.Add("Fecha", typeof(DateTime));
            dt.Columns.Add("Estado", typeof(string));
            // Datos de ejemplo
            List<pago> pagos = pagoBO.listarTodosPagos().ToList();

            foreach (pago p in pagos)
            {
                int idMatricula = p.matricula.idMatricula;
                matricula matricula = matriculaBO.obtenerMatriculaPorId(idMatricula);
                int idAlumno = matricula.fidAlumno;
                usuario usuario = usuarioBO.obtenerUsuarioPorId(idAlumno);

                dt.Rows.Add(p.idPago, usuario.nombreCompleto, p.monto, p.fechaPago,p.estado.ToString());
            }

            return dt;
        }
        protected void AgregarPago(object sender, EventArgs e)
        {
            // Lógica para agregar un nuevo pago.
            // Podrías redirigir a una página de "AgregarPago" o mostrar un modal.
            Response.Redirect("AgregarPagoPA.aspx");
        }

        /// <summary>
        /// Maneja los eventos de comando en el GridView, como editar un pago.
        /// </summary>
        protected void lbEditar_Click(object sender, EventArgs e)
        {

            LinkButton btn = (LinkButton)sender;
            int idPago = int.Parse(btn.CommandArgument);
            Response.Redirect("EditarPago.aspx?IdPago=" + idPago);


        }

    }
}
