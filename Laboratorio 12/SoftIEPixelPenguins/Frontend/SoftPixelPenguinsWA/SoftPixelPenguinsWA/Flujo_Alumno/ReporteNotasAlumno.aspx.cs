using SoftPixelPenguinsWA.ServicioWeb;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data.SqlTypes;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace SoftPixelPenguinsWA
{
    public partial class ReporteNotasAlumno : System.Web.UI.Page
    {
        CursoXMatriculaWSClient cursoXMatriculaBO = new CursoXMatriculaWSClient();
        AlumnoWSClient alumnoBO = new AlumnoWSClient();
        InstitucionEducativaWSClient institucionBO = new InstitucionEducativaWSClient();
        NotaWSClient notaBO = new NotaWSClient();
        institucionEducativa institucion = null;
        alumno alumno = null;
        int idAlumno;
        protected void Page_Load(object sender, EventArgs e)
        {
            if (Session["idAlumnoLogueado"] != null)
            {
                idAlumno = (int)Session["idAlumnoLogueado"];
                institucion = institucionBO.obtenerInstitucionEducativaPorId(1);
                txtInstitucion.Text = institucion.nombre;
                txtRUC.Text = institucion.ruc;
                txtDireccion.Text = institucion.direccion;
                alumno = alumnoBO.obtenerAlumnoPorId(idAlumno);
                txtAlumno.Text = alumno.nombreCompleto;
                deshabilitarComponentes();
            }
            BindingList<cursoXMatricula> notasFinales = new BindingList<cursoXMatricula>(cursoXMatriculaBO.listarNotasFinalesCursosXAlumno(idAlumno));
            actualizarNotasFinales(notasFinales);
            gvNotas.DataSource = notasFinales;
            gvNotas.DataBind();
        }

        protected void btnVerNotasParciales_Click(object sender, EventArgs e)
        {
            Response.Redirect("NotasParcialesAlumno.aspx");
        }

        private void actualizarNotasFinales(BindingList<cursoXMatricula> notasFinales)
        {
            foreach (cursoXMatricula cursoXMatricula in notasFinales)
            {
                BindingList<nota> notasBim1 = new BindingList<nota>(notaBO.listarPorAlumnoCursoYBimestre(idAlumno, cursoXMatricula.curso.idCurso, 1));
                actualizarNotasBimestre(cursoXMatricula, notasBim1, 1);
                BindingList<nota> notasBim2 = new BindingList<nota>(notaBO.listarPorAlumnoCursoYBimestre(idAlumno, cursoXMatricula.curso.idCurso, 2));
                actualizarNotasBimestre(cursoXMatricula, notasBim2, 2);
                BindingList<nota> notasBim3 = new BindingList<nota>(notaBO.listarPorAlumnoCursoYBimestre(idAlumno, cursoXMatricula.curso.idCurso, 3));
                actualizarNotasBimestre(cursoXMatricula, notasBim3, 3);
                BindingList<nota> notasBim4 = new BindingList<nota>(notaBO.listarPorAlumnoCursoYBimestre(idAlumno, cursoXMatricula.curso.idCurso, 4));
                actualizarNotasBimestre(cursoXMatricula, notasBim4, 4);
                BindingList<string> notasAux = new BindingList<string>();
                notasAux.Add(cursoXMatricula.notaBimestre1);
                notasAux.Add(cursoXMatricula.notaBimestre2);
                notasAux.Add(cursoXMatricula.notaBimestre3);
                notasAux.Add(cursoXMatricula.notaBimestre4);
                actualizarNotaFinal(cursoXMatricula, notasAux);
            }
        }

        private void actualizarNotasBimestre(cursoXMatricula cursoXMatricula, BindingList<nota> notas, int bimestre)
        {
            double suma = 0.0;
            int cant = notas.Count;
            foreach (nota nota in notas)
            {
                switch (nota.nota1)
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
            string notaProm = obtenerNotaPromedio(suma / cant);
            switch (bimestre)
            {
                case 1:
                    cursoXMatricula.notaBimestre1 = notaProm;
                    break;
                case 2:
                    cursoXMatricula.notaBimestre2 = notaProm;
                    break;
                case 3:
                    cursoXMatricula.notaBimestre3 = notaProm;
                    break;
                case 4:
                    cursoXMatricula.notaBimestre4 = notaProm;
                    break;
            }
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

        private void actualizarNotaFinal(cursoXMatricula cursoXMatricula, BindingList<string> notasAux)
        {
            double promedioFinal = obtenerPromNotas(notasAux);
            cursoXMatricula.notaFinal = obtenerNotaPromedio(promedioFinal);
            //cursoXMatriculaBO.modificarCursoXMatricula(cursoXMatricula);
        }
        private double obtenerPromNotas(BindingList<string> notas)
        {
            double suma = 0.0;
            foreach (string nota in notas)
            {
                if (nota == "AD") suma += 20;
                else if (nota == "A") suma += 16;
                else if (nota == "B") suma += 12;
                else if (nota == "C") suma += 8;
            }
            return suma / 4;
        }
        private void deshabilitarComponentes()
        {
            txtInstitucion.Enabled = false;
            txtDireccion.Enabled = false;
            txtAlumno.Enabled = false;
            txtRUC.Enabled = false;
        }
    }
}