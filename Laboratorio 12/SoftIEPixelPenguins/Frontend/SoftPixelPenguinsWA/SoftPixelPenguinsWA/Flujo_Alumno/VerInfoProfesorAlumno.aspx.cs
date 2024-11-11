using SoftPixelPenguinsWA.ServicioWeb;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace SoftPixelPenguinsWA
{
    public partial class VerInfoProfesorAlumno : System.Web.UI.Page
    {
        private ProfesorWSClient profesorBO=new ProfesorWSClient();
        profesor profesor = null;
        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {

                // Verifica si la página actual es el index
                if (Request.Url.AbsolutePath.EndsWith("VerInfoProfesor.aspx", StringComparison.OrdinalIgnoreCase))
                {
                    // Oculta el menú deseado
                    ContentPlaceHolder menuItem6 = (ContentPlaceHolder)Master.FindControl("menuItem6");
                    ContentPlaceHolder menuItem5 = (ContentPlaceHolder)Master.FindControl("menuItem5");
                    ContentPlaceHolder menuItem7 = (ContentPlaceHolder)Master.FindControl("menuItem7");
                    if (menuItem6 != null && menuItem5 != null)
                    {
                        menuItem6.Visible = false;
                        menuItem5.Visible = false;
                        menuItem7.Visible = false;
                    }
                }

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