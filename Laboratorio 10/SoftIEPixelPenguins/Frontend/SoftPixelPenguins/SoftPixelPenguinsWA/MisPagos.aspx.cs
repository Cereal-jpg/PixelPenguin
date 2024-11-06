using SoftPixelPenguinsWA.SoftPixelPenguinsWS;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace SoftPixelPenguinsWA
{
    public partial class MisPagos : System.Web.UI.Page
    {
        private MatriculaWSClient matriculaBO;
        private PagoWSClient pagosBO;
        protected void Page_Load(object sender, EventArgs e)
        {
            matriculaBO = new MatriculaWSClient();
            pagosBO = new PagoWSClient();

            int idUsuario = (int)Session["idAlumnoLogueado"];
            if (!IsPostBack)
            {
                int IdMatricula = matriculaBO.obtenerMatriculaPorIdAlumno(idUsuario);
                //List<pago> pagos = pagosBO.PagoXIdMatricula(IdMatricula);

            }
        }
        protected void btnDownloadPDF_Click(object sender, EventArgs e)
        {
            // Placeholder for PDF generation logic
            Response.Write("PDF generation not yet implemented.");
        }
    }
}