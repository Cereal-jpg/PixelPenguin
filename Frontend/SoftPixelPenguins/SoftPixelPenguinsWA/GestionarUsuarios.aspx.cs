using SoftPixelPenguinsWA.SoftPixelPenguinsWS;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Xml.Linq;

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
            gvUsuarios.DataSource = new BindingList<usuario>(usuarioBO.listarTodosUsuarios());
            gvUsuarios.DataBind();
        }

        private void CargarRoles()
        {
            ddlRoles.DataSource = new BindingList<rol>(rolBO.listarTodosRoles());
            ddlRoles.DataTextField = "nombre"; 
            ddlRoles.DataValueField = "IdRol";
            ddlRoles.DataBind();
            ddlRoles.Items.Insert(0, new ListItem("Seleccione un rol", ""));
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