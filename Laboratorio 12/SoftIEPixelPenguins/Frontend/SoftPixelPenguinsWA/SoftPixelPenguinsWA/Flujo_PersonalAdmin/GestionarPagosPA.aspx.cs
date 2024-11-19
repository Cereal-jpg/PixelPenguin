using System;
using System.Data; // Para trabajar con DataTable
using System.Web.UI.WebControls;

namespace SoftPixelPenguinsWA.Flujo_PersonalAdmin
{
    public partial class GestionarPagosPA : System.Web.UI.Page
    {
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
            dt.Rows.Add(1, "Juan Pérez", 500.00m, DateTime.Now,"Pagado");
            dt.Rows.Add(2, "María López", 300.00m, DateTime.Now.AddDays(-1),"Pendiente");
            dt.Rows.Add(3, "Carlos García", 700.00m, DateTime.Now.AddDays(-5),"Pendiente");

            return dt;
        }

        /// <summary>
        /// Filtra los pagos según el texto ingresado en el cuadro de texto.
        /// </summary>
        protected void AgregarPago(object sender, EventArgs e)
        {
            // Lógica para agregar un nuevo pago.
            // Podrías redirigir a una página de "AgregarPago" o mostrar un modal.
            Response.Redirect("AgregarPago.aspx");
        }

        /// <summary>
        /// Maneja los eventos de comando en el GridView, como editar un pago.
        /// </summary>
        protected void gvPagos_RowCommand(object sender, GridViewCommandEventArgs e)
        {
            if (e.CommandName == "Editar")
            {
                int idPago = Convert.ToInt32(e.CommandArgument);
                // Redirige a una página de edición de pagos.
                Response.Redirect($"EditarPago.aspx?IdPago={idPago}");
            }
        }
    }
}
