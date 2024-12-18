﻿using Newtonsoft.Json;
using SoftPixelPenguinsWA.ServicioWeb;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace SoftPixelPenguinsWA.Flujo_PersonalAdmin
{
    public partial class ReportePagosRA : System.Web.UI.Page
    {
        PagoWSClient pagoBO = new PagoWSClient();
        ReportesClient Reportes = new ReportesClient();
        string id;
        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {
                if (Session["idAdmin"] != null) panelGestionarUsuarios.Visible = true;
            }

            string idGrado = Request.QueryString["idGradoAcademico"];
            id = idGrado;
            if (idGrado != null)
            {
                gvPagos.DataSource = pagoBO.listarPagosPoridGrado(int.Parse(idGrado));
                gvPagos.DataBind();


                var pagosArray = pagoBO.listarPagosPoridGrado(int.Parse(idGrado));
                if (pagosArray != null)
                {
                    List<pago> pagos = new List<pago>(pagosArray.ToList());
                    int contPendiente = 0, contCancelado = 0, contAtrasado = 0;
                    foreach (pago pago in pagos)
                    {
                        if (pago.estado.ToString() == "PENDIENTE")
                        {
                            contPendiente++;
                        }
                        else if (pago.estado.ToString() == "CANCELADO")
                        {
                            contCancelado++;
                        }
                        else if (pago.estado.ToString() == "ATRASADO")
                        {
                            contAtrasado++;
                        }
                    }
                    var datos = new List<int> { contAtrasado, contCancelado, contPendiente };
                    string jsonData = JsonConvert.SerializeObject(datos);
                    ClientScript.RegisterStartupScript(this.GetType(), "jsonDataScript", $"var chartData = {jsonData};", true);
                }
                else
                {
                    var datos = new List<int> { 0, 0, 0 };
                    string jsonData = JsonConvert.SerializeObject(datos);
                    ClientScript.RegisterStartupScript(this.GetType(), "jsonDataScript", $"var chartData = {jsonData};", true);
                }
            }
        }
        protected void gvPagos_PageIndexChanging(object sender, GridViewPageEventArgs e)
        {
            // Actualizar el índice de la página
            gvPagos.PageIndex = e.NewPageIndex;
            gvPagos.DataSource = pagoBO.listarPagosPoridGrado(int.Parse(id));
            gvPagos.DataBind();
        }
        protected void btnDownloadPDF_Click(object sender, EventArgs e)
        {
            Byte[] FileBuffer = Reportes.reportePagos(int.Parse(id));
            if (FileBuffer != null)
            {
                Response.ContentType = "application/pdf";
                Response.AddHeader("content-length", FileBuffer.Length.ToString());
                Response.BinaryWrite(FileBuffer);
            }
        }



    }
}