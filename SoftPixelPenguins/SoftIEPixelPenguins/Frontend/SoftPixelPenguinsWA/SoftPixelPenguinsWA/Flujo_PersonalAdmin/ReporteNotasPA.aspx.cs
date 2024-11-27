using SoftPixelPenguinsWA.ServicioWeb;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;

namespace SoftPixelPenguinsWA
{
    public partial class ReporteNotasPA : System.Web.UI.Page
    {
        MatriculaWSClient matriculaBO = new MatriculaWSClient();
        CursoXMatriculaWSClient cursoXMatriculaBO = new CursoXMatriculaWSClient();
        AlumnoWSClient alumnoBO = new AlumnoWSClient();
        List<matricula> matriculas = null;
        List<alumno> alumnos = new List<alumno>();
        int idGradoAcademicoSelec;
        protected void Page_Load(object sender, EventArgs e)
        {
            string id = Request.QueryString["idGradoAcademico"];
            if (!string.IsNullOrEmpty(id))
            {
                idGradoAcademicoSelec = Int32.Parse(id);
                matriculas = (matriculaBO.listarMatriculasPorGradoAcademico(new gradoAcademico { idGradoAcademico = idGradoAcademicoSelec, idGradoAcademicoSpecified = true }) ?? Array.Empty<matricula>()).ToList();
                if (!IsPostBack)
                {
                    if (Session["idAdmin"] != null) panelGestionarUsuarios.Visible = true;
                    actualizarNotasFinales();
                    crearGrafico();
                    cargarDetalle();
                }
            }
        }

        private void cargarDetalle()
        {
            if (matriculas != null)
            {
                List<object> detalles = new List<object>();

                foreach (matricula matricula in matriculas)
                {
                    if (alumnos == null) alumnos = new List<alumno>();

                    alumno alumno = alumnoBO.obtenerAlumnoPorId(matricula.fidAlumno);

                    detalles.Add(new
                    {
                        codigoAlumno = alumno.codigoAlumno,  
                        nombreCompleto = alumno.nombreCompleto, 
                        notaFinal = matricula.notaFinal
                    });
                }

                gvAlumnos.DataSource = detalles;
                gvAlumnos.DataBind();
            }
        }


        private void crearGrafico()
        {
            List<String> notas = (matriculaBO.listarNotasFinalesPorGradoAcademico(new gradoAcademico { idGradoAcademico = idGradoAcademicoSelec, idGradoAcademicoSpecified = true }) ?? Array.Empty<String>()).ToList();
            int countAD = notas.Count(nota => nota == "AD");
            int countA = notas.Count(nota => nota == "A");
            int countB = notas.Count(nota => nota == "B");
            int countC = notas.Count(nota => nota == "C");

            string script = $@"
            <script>
                document.addEventListener('DOMContentLoaded', function() {{
                    generarGrafico(
                        ['AD', 'A', 'B', 'C'], 
                        [{countAD}, {countA}, {countB}, {countC}]
                    );
                }});
             </script>";

            ClientScript.RegisterStartupScript(this.GetType(), "graficoNotas", script, false);
        }

        private void actualizarNotasFinales()
        {
            foreach (matricula matricula in matriculas)
            {
                List<cursoXMatricula>notasFinales = (cursoXMatriculaBO.listarNotasFinalesCursosXMatricula(matricula.idMatricula) ?? Array.Empty<cursoXMatricula>()).ToList();
                if (notasFinales.Count > 0)
                {
                    string notaFinalMat = calcularPromedio(notasFinales);
                    matricula.notaFinal = notaFinalMat;
                    matriculaBO.actualizarNotaFinal(matricula.idMatricula, notaFinalMat);
                }
            }
        }

        private string calcularPromedio(List<cursoXMatricula> notasFinales)
        {
            double suma = 0.0;
            foreach (cursoXMatricula notafinal in notasFinales)
            {
                switch (notafinal.notaFinal)
                {
                    case "AD":
                        suma += 20;
                        break;
                    case "A":
                        suma += 16;
                        break;
                    case "B":
                        suma += 12;
                        break;
                    case "C":
                        suma += 8;
                        break;
                }
            }
            string notaFinalMat = obtenerNotaPromedio(Math.Round(suma/notasFinales.Count,MidpointRounding.AwayFromZero));
            return notaFinalMat;
        }

        private string obtenerNotaPromedio(double promedio)
        {
            if (promedio >= 17 && promedio <= 20)
                return "AD";
            else if (promedio >= 13 && promedio < 17)
                return "A";
            else if (promedio >= 9 && promedio < 13)
                return "B";
            else if (promedio > 0 && promedio < 9)
                return "C";
            else
                return "-";
        }

    }
}