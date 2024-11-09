using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace SoftPixelPenguinsWA
{
    public partial class IndexPersonalAdministrativo : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {
                // Verifica si la página actual es el index
                if (Request.Url.AbsolutePath.EndsWith("IndexPersonalAdministrativo.aspx", StringComparison.OrdinalIgnoreCase))
                {
                    // Ocultar el menú que no corresponde al usuario
                    ContentPlaceHolder menuItem6 = (ContentPlaceHolder)Master.FindControl("menuItem6");
                    if (menuItem6 != null)
                    {
                        menuItem6.Visible = false;
                    }
                }
            }
        }
    }
}