using SoftPixelPenguinsWA.ServicioWeb;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace SoftPixelPenguinsWA.Flujo_Generico
{
    public partial class IndexUserGenerico : System.Web.UI.Page
    {
        UsuarioWSClient usuarioBO = new UsuarioWSClient();
        usuario usuario = null;
        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {
                // Verifica si la página actual es el index
                if (Session["idUserGenerico"] != null)
                {
                    // Verifica si la página actual es el index
                    if (Request.Url.AbsolutePath.EndsWith("IndexUserGenerico.aspx", StringComparison.OrdinalIgnoreCase))
                    {
                        // Oculta el menú deseado
                        ContentPlaceHolder menuItem4 = (ContentPlaceHolder)Master.FindControl("menuItem4");
                        ContentPlaceHolder menuItem5 = (ContentPlaceHolder)Master.FindControl("menuItem5");
                        ContentPlaceHolder menuItem6 = (ContentPlaceHolder)Master.FindControl("menuItem6");
                        ContentPlaceHolder menuItem7 = (ContentPlaceHolder)Master.FindControl("menuItem7");
                        if (menuItem7 != null && menuItem6 != null && menuItem5 != null && menuItem4 != null)
                        {
                            menuItem4.Visible = false;
                            menuItem5.Visible = false;
                            menuItem6.Visible = false;
                            menuItem7.Visible = false;
                        }
                    }
                    int idUser = (int)Session["idUserGenerico"];
                    usuario = usuarioBO.obtenerUsuarioPorId(idUser);
                    hTitulo.InnerHtml = "¡Bienvenido " + usuario.nombreCompleto + "!";
                }
            }
        }
    }
}