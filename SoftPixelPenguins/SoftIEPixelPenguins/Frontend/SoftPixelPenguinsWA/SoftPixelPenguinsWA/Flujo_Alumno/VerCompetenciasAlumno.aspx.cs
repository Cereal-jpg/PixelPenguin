﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace SoftPixelPenguinsWA
{
    public partial class VerCompetenciasAlumno : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {
                // Verifica si la página actual es el index
                if (Request.Url.AbsolutePath.EndsWith("VerCompetenciasAlumno.aspx", StringComparison.OrdinalIgnoreCase))
                {
                    // Oculta el menú deseado
                    ContentPlaceHolder menuItem7 = (ContentPlaceHolder)Master.FindControl("menuItem7");
                    if (menuItem7 != null)
                    {
                        menuItem7.Visible = false;
                    }
                }
            }
        }
    }
}