using System;
using System.Data;
using System.Collections.Generic;
using System.Web.Script.Serialization;
using iTextSharp.text;
using iTextSharp.text.pdf;
using System.IO;
using SoftPixelPenguinsWA.SoftPixelPenguinsWS;
using System.Web.UI.WebControls;

namespace SoftPixelPenguinsWA
{
    public partial class Reportes : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            
        }

        protected void btnEmitirReporte_Click(object sender, EventArgs e)
        {
            if (rbMatriculas.Checked)
            {
                Response.Redirect("ReporteGrado.aspx");
            }
        }

    }
}