using iTextSharp.text.pdf;
using iTextSharp.text;
using SoftPixelPenguinsWA.ServicioWeb;
using System;
using System.Collections.Generic;
using System.Data;
using System.IO;
using System.Linq;
using System.Web;
using System.Web.Script.Serialization;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace SoftPixelPenguinsWA
{
    public partial class ReporteGradoPA : System.Web.UI.Page
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
                List<int> cantidadAlumnosData = new List<int>();
                List<int> vacantesData = new List<int>();

                foreach (DataRow row in dt.Rows)
                {
                    labels.Add($"{row["Nivel"]} {row["Grado"]}");
                    cantidadAlumnosData.Add(Convert.ToInt32(row["Cantidad de Alumnos"]));
                    vacantesData.Add(Convert.ToInt32(row["Vacantes"]));
                }

                hdnLabels.Value = serializer.Serialize(labels);
                hdnData.Value = serializer.Serialize(new { alumnos = cantidadAlumnosData, vacantes = vacantesData });
            }
        }

        private DataTable GenerarDataTableConPorcentajes(List<gradoAcademico> grados)
        {
            DataTable dt = new DataTable();
            dt.Columns.Add("Nivel", typeof(string));
            dt.Columns.Add("Grado", typeof(int));
            dt.Columns.Add("Cantidad de Alumnos", typeof(int));
            dt.Columns.Add("Vacantes", typeof(int));
            dt.Columns.Add("Porc. de Matriculados", typeof(string));

            foreach (var grado in grados)
            {
                double porcentajeMatriculados = grado.vacantes > 0 ? (grado.cantidadAlumnos * 100.0 / grado.vacantes) : 0;
                string porcentajeFormateado = Math.Round(porcentajeMatriculados, 2).ToString("F2") + "%";
                dt.Rows.Add(grado.nivel, grado.numeroGrado, grado.cantidadAlumnos, grado.vacantes, porcentajeFormateado);
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

            string logoPath = Server.MapPath("../Images/PIXEL.png");
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


            // Primera Tabla de Porcentaje de Matriculados por Grado
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


            // Primera Tabla de Porcentaje de Matriculados por Grado
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