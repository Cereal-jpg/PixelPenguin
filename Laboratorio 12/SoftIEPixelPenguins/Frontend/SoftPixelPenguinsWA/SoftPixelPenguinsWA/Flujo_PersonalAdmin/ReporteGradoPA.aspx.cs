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
                if (Session["idAdmin"] != null) panelGestionarUsuarios.Visible = true;

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
            Byte[] FileBuffer = gradoAcademicoBO.reporteMatriculasPorGrado();
            if (FileBuffer != null)
            {
                Response.ContentType = "application/pdf";
                Response.AddHeader("content-length", FileBuffer.Length.ToString());
                Response.BinaryWrite(FileBuffer);
            }
        }
    }
}