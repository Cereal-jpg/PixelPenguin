using SoftPixelPenguinsWA.ServicioWeb;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace SoftPixelPenguinsWA
{
    public partial class VerInfoProfesor : System.Web.UI.Page
    {
        private ProfesorWSClient profesorBO=new ProfesorWSClient();
        profesor profesor = null;
        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {
                string id = Request.QueryString["idProfesor"];
                if (id != null)
                {
                    int idProfesor= Int32.Parse(id);
                    profesor = profesorBO.obtenerProfesorPorId(idProfesor);
                    hTitulo.InnerHtml = profesor.nombreCompleto;   
                }
            }
        }

        protected void btnRegresar_Click(object sender, EventArgs e)
        {
            Response.Redirect("MisCursosAlumno.aspx");
        }
    }
}