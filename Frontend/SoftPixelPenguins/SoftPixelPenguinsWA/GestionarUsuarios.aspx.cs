using SoftPixelPenguinsWA.ServiceReference1;
using SoftPixelPenguinsWA.ServiceReference2;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace SoftPixelPenguinsWA
{
    public partial class GestionarUsuarios : System.Web.UI.Page
    {
        private RolWSClient rolBO = new RolWSClient();
        private UsuarioWSClient usuarioBO = new UsuarioWSClient();

        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {
                CargarRoles();
                CargarUsuarios();
            }
        }

        private void CargarUsuarios()
        {
            gvUsuarios.DataSource = usuarioBO.listarTodosUsuarios();
            gvUsuarios.DataBind();
        }

        private void CargarRoles()
        {
            
        }

        protected void gvUsuarios_RowCommand(object sender, GridViewCommandEventArgs e)
        {
            if (e.CommandName == "Edit")
            {
                // Lógica para editar el usuario usando e.CommandArgument
                // Puedes cargar la información en los campos del modal y luego actualizar
            }
            else if (e.CommandName == "Delete")
            {
                // Lógica para eliminar el usuario usando e.CommandArgument
                // Elimina el usuario de la base de datos
                CargarUsuarios();
            }

        }
    }
}