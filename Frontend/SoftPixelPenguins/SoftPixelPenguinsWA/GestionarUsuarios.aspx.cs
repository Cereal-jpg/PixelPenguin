using SoftPixelPenguinsWA.SoftPixelPenguinsWS;
using System;
using System.Collections.Generic;
using System.ComponentModel;
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
            
        }

        private void CargarRoles()
        {
            ddlRoles.DataSource = new BindingList<rol>(rolBO.listarTodosRoles());
            ddlRoles.DataTextField = "nombre"; 
            ddlRoles.DataValueField = "IdRol";
            ddlRoles.DataBind();
        }

        protected void ddlRoles_SelectedIndexChanged(object sender, EventArgs e)
        {
            // Aquí puedes manejar la lógica que deseas ejecutar al cambiar el rol seleccionado
            int selectedId = int.Parse(ddlRoles.SelectedValue);
            // Por ejemplo, podrías filtrar usuarios según el rol seleccionado
            if (selectedId > 0) // Asegúrate de que se ha seleccionado un rol válido
            {
                // Lógica para manejar el rol seleccionado
                // Podrías, por ejemplo, cargar usuarios que tienen ese rol
                // gvUsuarios.DataSource = usuarioBO.ListarUsuariosPorRol(selectedId);
                // gvUsuarios.DataBind();
            }
            else
            {
                // Maneja el caso en que no se seleccionó un rol válido
                // gvUsuarios.DataSource = usuarioBO.ListarTodosUsuarios();
                // gvUsuarios.DataBind();
            }
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