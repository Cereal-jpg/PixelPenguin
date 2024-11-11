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
            if (!IsPostBack)
            {
                // Verifica si la página actual es el index
                if (Request.Url.AbsolutePath.EndsWith("ReportesPA.aspx", StringComparison.OrdinalIgnoreCase))
                {
                    // Oculta el menú deseado
                    ContentPlaceHolder menuItem7 = (ContentPlaceHolder)Master.FindControl("menuItem7");
                    if (menuItem7 != null)
                    {
                        menuItem7.Visible = false;
                    }
                }
            }
        }

        protected void btnEmitirReporte_Click(object sender, EventArgs e)
        {
            if (rbMatriculas.Checked)
            {
                Response.Redirect("ReporteGradoPA.aspx");
            }
            else if (rbPensiones.Checked)
            {
                Response.Redirect("ReportePagosXGrado.aspx");
            }
        }
    }
}