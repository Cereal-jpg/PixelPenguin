using SoftPixelPenguinsWA.ServicioWeb;
using System;
using System.Collections.Generic;
using System.Data; // Para trabajar con DataTable
using System.Diagnostics;
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
            DataTable pagos = ObtenerPagos(int.Parse(ddlFiltros.SelectedValue));

            gvPagos.DataSource = pagos;
            gvPagos.DataBind();
        }

        /// <summary>
        /// Simula la obtención de datos de pagos desde una base de datos.
        /// </summary>
        /// <returns>Un DataTable con los pagos.</returns>
        private DataTable ObtenerPagos(int meses)
        {
            DataTable dt = new DataTable();
            dt.Columns.Add("IdPago", typeof(int));
            dt.Columns.Add("NombreAlumno", typeof(string));
            dt.Columns.Add("Monto", typeof(decimal));
            dt.Columns.Add("Fecha", typeof(DateTime));
            dt.Columns.Add("Estado", typeof(string));

            List<pago> pagos = new List<pago>();
            if (meses == -1)
            {
                pagos = pagoBO.listarTodosPagos().ToList();
            }
            else
            {
                DateTime fechaHasta = DateTime.Now;
                DateTime fechaDesde = fechaHasta.AddMonths(-meses);
                pagos = pagoBO.listarPagosXFechaLimite(fechaDesde, fechaHasta).ToList();
            }

            foreach (pago p in pagos)
            {
                int idMatricula = p.matricula.idMatricula;
                matricula matricula = matriculaBO.obtenerMatriculaPorId(idMatricula);
                int idAlumno = matricula.fidAlumno;
                usuario usuario = usuarioBO.obtenerUsuarioPorId(idAlumno);

                dt.Rows.Add(p.idPago, usuario.nombreCompleto, p.monto, p.fechaPago, p.estado.ToString());
            }

            return dt;
        }
        protected void AgregarPago(object sender, EventArgs e)
        {
            List<matricula> matriculas = new List<matricula>();
            matriculas = matriculaBO.listarTodosMatriculas().ToList();

            foreach (matricula mat in matriculas)
            {
                pago nuevoPago = new pago();
                nuevoPago.idPagoSpecified = true;
                nuevoPago.matricula = new matricula();
                nuevoPago.matricula = mat;
                nuevoPago.monto = 500;
                nuevoPago.fechaCreacion = DateTime.Today;
                nuevoPago.fechaPago = DateTime.Today.AddDays(30);
                nuevoPago.estado = estadoDePago.PENDIENTE;
                nuevoPago.comprobanteDePago = null;
                nuevoPago.tipoDeComprobante = tipoDeComprobante.BOLETA;
                nuevoPago.tipoPago = tipoDePago.TRANSFERENCIA_BANCARIA;

                int resultado = pagoBO.insertarPago(nuevoPago);  // Asegúrate de que esto devuelve el ID o el resultado esperado.
                nuevoPago.idPagoSpecified = true;
                //Console.WriteLine($"Pago insertado con resultado: {resultado}");  // Muestra el resultado en la consola.
                Debug.WriteLine($"Pago insertado con éxito. ID: {resultado}");  // Muestra el resultado en el panel de salida de depuración.
                Debug.WriteLine($"Monto: {nuevoPago.monto}, FechaCreacion: {nuevoPago.fechaCreacion}, FechaPago: {nuevoPago.fechaPago}");


            }

            Response.Redirect("GestionarPagosPA.aspx", false);
            Context.ApplicationInstance.CompleteRequest();

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

        protected string MostrarEstado(string estado)
        {
            switch (estado.ToLower())
            {
                case "atrasado":
                    return "<span style='color: red;'>⚠️ Atrasado</span>";
                case "pendiente":
                    return "<span style='color: orange;'>🕒 Pendiente</span>";
                case "cancelado":
                    return "<span style='color: green;'>✅ Cancelado</span>";
                default:
                    return "<span style='color: gray;'>🔘 Desconocido</span>";
            }
        }

        protected void ddlFiltro_SelectedIndexChanged(object sender, EventArgs e)
        {
            CargarPagos();
        }

    }
}
