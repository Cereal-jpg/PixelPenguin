using SoftPixelPenguinsWA.ServicioWeb;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using Newtonsoft.Json;
using System.Collections;
using System.ComponentModel;

namespace SoftPixelPenguinsWA
{
    public partial class ReportePagosRA : System.Web.UI.Page
    {
        PagoWSClient pagoBO = new PagoWSClient();
        protected void Page_Load(object sender, EventArgs e)
        {
            string idGrado = Request.QueryString["idGradoAcademico"];
            if(idGrado!=null) 
            {
                gvPagos.DataSource= pagoBO.listarPagosPoridGrado(int.Parse(idGrado));
                gvPagos.DataBind();
            }

            var pagosArray = pagoBO.listarPagosPoridGrado(int.Parse(idGrado));
            List<pago> pagos = new List<pago>(pagosArray.ToList());
            int contPendiente=0, contCancelado=0, contAtrasado = 0;
            foreach (pago pago in pagos)
            {
                if (pago.estado.ToString() == "PENDIENTE") {
                    contPendiente++;
                }
                else if(pago.estado.ToString() == "CANCELADO")
                {
                    contCancelado++;
                }
                else if(pago.estado.ToString() == "ATRASADO")
                {
                    contAtrasado++;
                }
            }
            var datos = new List<int> { contAtrasado, contCancelado, contPendiente };
            string jsonData = JsonConvert.SerializeObject(datos);
            ClientScript.RegisterStartupScript(this.GetType(), "jsonDataScript", $"var chartData = {jsonData};", true);
        }
    }
}