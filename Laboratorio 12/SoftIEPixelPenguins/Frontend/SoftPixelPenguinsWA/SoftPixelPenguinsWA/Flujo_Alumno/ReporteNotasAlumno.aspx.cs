using iTextSharp.text.pdf;
using iTextSharp.text;
using SoftPixelPenguinsWA.ServicioWeb;
using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Globalization;

namespace SoftPixelPenguinsWA
{
    public partial class ReporteNotasAlumno : System.Web.UI.Page
    {
        CursoXMatriculaWSClient cursoXMatriculaBO = new CursoXMatriculaWSClient();
        AlumnoWSClient alumnoBO = new AlumnoWSClient();
        InstitucionEducativaWSClient institucionBO = new InstitucionEducativaWSClient();
        institucionEducativa institucion = null;
        alumno alumno = null;
        AnioAcademicoWSClient anioBO = new AnioAcademicoWSClient();
        anioAcademico anio = null;
        int idAlumno;
        protected void Page_Load(object sender, EventArgs e)
        {
            // Verifica si la página actual es el index
            if (Session["idAlumnoLogueado"] != null)
            {
                idAlumno = (int)Session["idAlumnoLogueado"];
                institucion = institucionBO.obtenerInstitucionEducativaPorId(1);
                txtInstitucion.Text = institucion.nombre;
                txtDireccion.Text = institucion.direccion;
                alumno = alumnoBO.obtenerAlumnoPorId(idAlumno);
                txtAlumno.Text = alumno.nombreCompleto;
                deshabilitarComponentes();
            }
            gvNotas.DataSource = cursoXMatriculaBO.listarNotasFinalesCursosXAlumno(idAlumno);
            gvNotas.DataBind();
        }

        protected void btnVerNotasParciales_Click(object sender, EventArgs e)
        {
            Response.Redirect("NotasParcialesAlumno.aspx");
        }

        private void deshabilitarComponentes()
        {
            txtInstitucion.Enabled = false;
            txtDireccion.Enabled = false;
            txtAlumno.Enabled = false;
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
            Font bodyFont = FontFactory.GetFont("Arial", 12);
            anio = anioBO.obtenerAnioAcademicoPorId(1);
            string palabras = "Reporte de Notas Finales ";
            if (anio != null)
            {
                palabras += anio.anio.ToString();
            }
            else
            {
                palabras += " - ";
            }

            Paragraph title = new Paragraph(palabras, titleFont)
            {
                Alignment = Element.ALIGN_CENTER
            };
            title.SpacingBefore = 10f;
            
            // Datos del alumno
            string[] nombreCompleto = alumno.nombreCompleto.Trim().Split(' ');
            string datosEstudiante = "    IIEE: " + institucion.nombre + "\n";
            datosEstudiante += "    Dirección: " + institucion.direccion + "\n";
            datosEstudiante += "    Apellidos y Nombres: " + nombreCompleto[nombreCompleto.Length - 2];
            datosEstudiante += " " + nombreCompleto[nombreCompleto.Length - 1] + " ";
            for (int i = 0; i < nombreCompleto.Length-2; i++)
            {
                datosEstudiante += nombreCompleto[i];
            }
            datosEstudiante += "\n";

            Paragraph dataEstudiante = new Paragraph(datosEstudiante, bodyFont)
            {
                Alignment = Element.ALIGN_LEFT
            };
            dataEstudiante.SpacingBefore = 15f;
            dataEstudiante.SpacingAfter = 10f;

            pdfDoc.Add(title);
            pdfDoc.Add(new Paragraph(" "));
            pdfDoc.Add(dataEstudiante);
            pdfDoc.Add(new Paragraph(" "));

            // Número de columnas según las gridview
            PdfPTable pdfTable = new PdfPTable(gvNotas.HeaderRow.Cells.Count);

            Font tableFont = FontFactory.GetFont("Arial", 11);
            float tableHeight = 15f;
            float headerHeight = 20f;
            float[] columnWidths = { 2f, 1f, 1f, 1f, 1f, 1f};
            pdfTable.SetWidths(columnWidths);

            int columnIndex = 0;
            foreach (TableCell headerCell in gvNotas.HeaderRow.Cells)
            {
                PdfPCell pdfCell = new PdfPCell(new Phrase(headerCell.Text, tableFont));
                pdfCell.BackgroundColor = new iTextSharp.text.BaseColor(211, 211, 211); // Gris claro
                pdfCell.HorizontalAlignment = Element.ALIGN_CENTER; // Centrar horizontalmente
                pdfCell.VerticalAlignment = Element.ALIGN_MIDDLE; // Centrar verticalmente
                pdfCell.FixedHeight = headerHeight; // Altura fija
                pdfTable.AddCell(pdfCell);
                columnIndex++;
            }

            foreach (GridViewRow gridViewRow in gvNotas.Rows)
            {
                columnIndex = 0;
                foreach (TableCell tableCell in gridViewRow.Cells)
                {
                    PdfPCell pdfCell = new PdfPCell(new Phrase(tableCell.Text,tableFont));
                    if (columnIndex == 0)
                    {
                        pdfCell.HorizontalAlignment = Element.ALIGN_LEFT; // Alinear a la derecha
                    }
                    else
                    {
                        pdfCell.HorizontalAlignment = Element.ALIGN_CENTER; // Centrar horizontalmente
                    }
                    pdfCell.VerticalAlignment = Element.ALIGN_MIDDLE;   // Centrar verticalmente
                    pdfCell.FixedHeight = tableHeight; // Altura fija
                    pdfTable.AddCell(pdfCell);
                    columnIndex++;
                }
            }
            pdfTable.TotalWidth = 500f;
            pdfTable.LockedWidth = true;
            pdfTable.SpacingBefore = 10f;
            pdfTable.SetExtendLastRow(true, false);
            pdfDoc.Add(pdfTable);


            DateTime fecha = DateTime.Now;
            string diaDeLaSemana = fecha.ToString("dddd", new CultureInfo("es-ES")); // Para obtener el día de la semana en español
            string formato = $"{diaDeLaSemana} {fecha:dd 'de' MMMM 'del' yyyy, 'hora:' HH:mm:ss tt}";

            formato = formato.Replace("AM", "am").Replace("PM", "pm");

            Paragraph dataEmitida = new Paragraph(formato, bodyFont)
            {
                Alignment = Element.ALIGN_RIGHT
            };
            dataEmitida.SpacingBefore = 40f;

            // Colocarlo al último 
            for(int i = 0; i < 17; i++)
            {
                pdfDoc.Add(new Paragraph(" "));
            }
            pdfDoc.Add(dataEmitida);

            pdfDoc.Close();
            byte[] bytes = ms.ToArray();
            ms.Close();

            Response.Clear();
            Response.ContentType = "application/pdf";
            Response.AddHeader("Content-Disposition", "attachment; filename=ReporteNotasAlumno.pdf");
            Response.BinaryWrite(bytes);
            Response.End();
        }

    }
}