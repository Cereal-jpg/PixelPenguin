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
    public partial class ReporteGrado : System.Web.UI.Page
    {
        GradoAcademicoWSClient gradoAcademicoBO = new GradoAcademicoWSClient();
        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {
                List<gradoAcademico> grados = new List<gradoAcademico>(gradoAcademicoBO.listarTodosGradosAcademicos());

                DataTable dt = GenerarDataTableConPorcentajes(grados);
                gridReporte.DataSource = dt;
                gridReporte.DataBind();

                JavaScriptSerializer serializer = new JavaScriptSerializer();
                List<string> labels = new List<string>();
                List<double> data = new List<double>();

                foreach (DataRow row in dt.Rows)
                {
                    labels.Add($"{row["nivel"]} {row["numeroGrado"]}");
                    data.Add(Convert.ToDouble(row["porcentajeMatriculados"]));
                }

                hdnLabels.Value = serializer.Serialize(labels);
                hdnData.Value = serializer.Serialize(data);
            }
        }

        private DataTable GenerarDataTableConPorcentajes(List<gradoAcademico> grados)
        {
            DataTable dt = new DataTable();
            dt.Columns.Add("numeroGrado", typeof(int));
            dt.Columns.Add("nivel", typeof(string));
            dt.Columns.Add("cantidadAlumnos", typeof(int));
            dt.Columns.Add("vacantes", typeof(int));
            dt.Columns.Add("porcentajeMatriculados", typeof(double));

            foreach (var grado in grados)
            {
                double porcentajeMatriculados = grado.vacantes > 0 ? (grado.cantidadAlumnos * 100.0 / grado.vacantes) : 0;
                dt.Rows.Add(grado.numeroGrado, grado.nivel, grado.cantidadAlumnos, grado.vacantes, porcentajeMatriculados);
            }

            return dt;
        }

        protected void btnDownloadPDF_Click(object sender, EventArgs e)
        {
            Document pdfDoc = new Document();
            MemoryStream ms = new MemoryStream();
            PdfWriter writer = PdfWriter.GetInstance(pdfDoc, ms);
            pdfDoc.Open();

            PdfPTable headerTable = new PdfPTable(2);
            headerTable.WidthPercentage = 100;

            string logoPath = Server.MapPath("~/Images/LogoB&W.jpg"); 
            iTextSharp.text.Image logo = iTextSharp.text.Image.GetInstance(logoPath);
            logo.ScaleToFit(80f, 80f); 
            logo.Alignment = Element.ALIGN_LEFT; 

            PdfPCell logoCell = new PdfPCell(logo);
            logoCell.Border = Rectangle.NO_BORDER; 
            logoCell.HorizontalAlignment = Element.ALIGN_LEFT; 
            headerTable.AddCell(logoCell); 


            Font institutionFont = FontFactory.GetFont("Arial", 14, Font.BOLD); 
            Paragraph institutionTitle = new Paragraph("Institución Educativa Pixel Penguins", institutionFont)
            {
                Alignment = Element.ALIGN_CENTER
            };

            PdfPCell titleCell = new PdfPCell(institutionTitle);
            titleCell.Border = Rectangle.NO_BORDER;
            titleCell.HorizontalAlignment = Element.ALIGN_CENTER;
            titleCell.VerticalAlignment = Element.ALIGN_MIDDLE;
            headerTable.AddCell(titleCell);

            pdfDoc.Add(headerTable);

            Font titleFont = FontFactory.GetFont("Arial", 16, Font.BOLD);
            Paragraph title = new Paragraph("Reporte de Matriculados por Grado", titleFont)
            {
                Alignment = Element.ALIGN_CENTER
            };
            title.SpacingBefore = 20f; 
            pdfDoc.Add(title);

            Paragraph subtitle = new Paragraph("Matrícula 2025", institutionFont)
            {
                Alignment = Element.ALIGN_CENTER
            };
            subtitle.SpacingAfter = 10f;
            pdfDoc.Add(subtitle);
            pdfDoc.Add(new Paragraph(" "));

            PdfPTable pdfTable = new PdfPTable(gridReporte.HeaderRow.Cells.Count);
            foreach (TableCell headerCell in gridReporte.HeaderRow.Cells)
            {
                PdfPCell pdfCell = new PdfPCell(new Phrase(headerCell.Text));
                pdfTable.AddCell(pdfCell);
            }
            foreach (GridViewRow gridViewRow in gridReporte.Rows)
            {
                foreach (TableCell tableCell in gridViewRow.Cells)
                {
                    PdfPCell pdfCell = new PdfPCell(new Phrase(tableCell.Text));
                    pdfTable.AddCell(pdfCell);
                }
            }
            pdfTable.TotalWidth = 500f;
            pdfTable.LockedWidth = true;
            pdfDoc.Add(pdfTable);


            Paragraph subtitle2 = new Paragraph("Grafico de Barras", institutionFont)
            {
                Alignment = Element.ALIGN_LEFT
            };
            subtitle2.SpacingBefore = 10f;
            pdfDoc.Add(subtitle2);

            string base64Image = hdnChartImage.Value;
            if (!string.IsNullOrEmpty(base64Image))
            {
                byte[] imageBytes = Convert.FromBase64String(base64Image.Split(',')[1]);
                iTextSharp.text.Image chartImage = iTextSharp.text.Image.GetInstance(imageBytes);
                chartImage.ScaleToFit(500f, 300f); 
                pdfDoc.Add(chartImage);
            }

            pdfDoc.Close();
            byte[] bytes = ms.ToArray();
            ms.Close();

            Response.Clear();
            Response.ContentType = "application/pdf";
            Response.AddHeader("Content-Disposition", "attachment; filename=ReporteMatriculados.pdf");
            Response.BinaryWrite(bytes);
            Response.End();
        }

    }
}