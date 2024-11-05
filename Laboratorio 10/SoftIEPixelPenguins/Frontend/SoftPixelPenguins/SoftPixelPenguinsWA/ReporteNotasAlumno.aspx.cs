using SoftPixelPenguinsWA.SoftPixelPenguinsWS;
using System;
using System.Collections.Generic;
using System.Data;
using System.Linq;
using System.Web;
using System.Web.Script.Serialization;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace SoftPixelPenguinsWA
{

    public partial class ReporteNotasAlumno : System.Web.UI.Page
    {
        AlumnoWSClient alumnoBO = new AlumnoWSClient();
        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {
                CargarNotas();
            }
        }

        private void CargarNotas()
        {
            // Suponiendo que `ObtenerNotasAlumno` está en una clase de servicio llamada `AlumnoService`.
            int alumnoId = (int)Session["idUsuario"]; // ID del alumno (puedes obtenerlo dinámicamente).
            List<nota> notas = new List<nota>(/*Función*/ );

            gvNotas.DataSource = notas;
            gvNotas.DataBind();
        }

    }
}