<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="PlanEstudioGenerico.aspx.cs" Inherits="SoftPixelPenguinsWA.PlanEstudioGenerico" %>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Inicio de Sesión - Pixel Penguins</title>
    <link rel="stylesheet" href="Content/Estilos.css" />
    <link rel="stylesheet" href="Content/Estilos-Plan.css" />
</head>
<body>
    <form id="form1" runat="server">
        <div class="container">
            <div class="header">
                <img src="Images/PIXEL.png" alt="Logo" />
                <h1>Pixel Penguins</h1>
                <div class="nav">
                    <a href="Login.aspx">Intranet</a>
                    <a href="Matricularse.aspx">Matrícula</a>
                </div>
            </div>
            <div class="form-containerDentro">
                <h2 class="titulo">Plan de Estudios</h2>
                <hr>
                <p>
                    En Pixel Penguins contamos con un plan académico pensado en que nuestros alumnos
                    obtengan las mejores competencias y habilidades. Si quieres ver detalle de las 
                    competencias de cada curso, haga click en "Ver competencias".
                </p>
                <!-- Contenedor para alinear la imagen a un lado y apilar droplist + botón verticalmente -->
                <div class="content-row">
                    <!-- Contenedor para el droplist y el botón apilados verticalmente -->
                    <div class="controls-column">
                        <asp:DropDownList ID="ddlDepartamento" CssClass="form-select" runat="server" AutoPostBack="true" OnSelectedIndexChanged="ddlDepartamento_SelectedIndexChanged">
                            <asp:ListItem Text="Primaria" Value="1"></asp:ListItem>
                            <asp:ListItem Text="Secundaria" Value="2"></asp:ListItem>
                        </asp:DropDownList>
                        <asp:Button ID="VerCompetencias" runat="server" Text="Ver competencias" CssClass="login-button" OnClick="VerCompetencias_Click"/>
                    </div>
                    <!-- Contenedor de la imagen a la derecha -->
                    <div class="image-containerP">
                        <asp:Image ID="imgHorario" runat="server" CssClass="img-fluid" />
                    </div>
                </div>
            </div>
        </div>
    </form>
</body>

</html>
