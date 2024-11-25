using SoftPixelPenguinsWA.ServicioWeb;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace SoftPixelPenguinsWA
{
    public partial class SoftPixelPenguins : System.Web.UI.MasterPage
    {
        UsuarioWSClient usuarioBO = new UsuarioWSClient();
        usuario usuario = null;
        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {
                if (Session["idUsuario"] != null)
                {
                    int idUsuario = (int)Session["idUsuario"];
                    usuario = usuarioBO.obtenerUsuarioPorId(idUsuario);
                    if(usuario != null)
                    {
                        string[] nombreUsuario = usuario.nombreCompleto.Trim().Split(' ');
                        litUsername.Text = nombreUsuario[0];
                    }
                    else
                    {
                        Response.Redirect("Login.aspx");
                    }
                }
            }
        }
    }
}