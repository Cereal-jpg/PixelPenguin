using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace SoftPixelPenguinsWA
{
    public partial class ReportesPA : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            
        }

        protected void btnEmitirReporte_Click(object sender, EventArgs e)
        {
            if (rbMatriculas.Checked)
            {
                Response.Redirect("ReporteGradoPA.aspx");
            }
            else if (rbPensiones.Checked)
            {
                Response.Redirect("~/Flujo_Admin/ReportePagosXGrado.aspx");
            }
        }
    }
}