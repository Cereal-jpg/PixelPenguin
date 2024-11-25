<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="VerCompetenciasGenerica.aspx.cs" Inherits="SoftPixelPenguinsWA.VerCompetenciasGenerica" %>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Inicio de Sesión - Pixel Penguins</title>
    <link rel="stylesheet" href="Content/Estilos.css" />
    <link rel="stylesheet" href="Content/Estilos-VerCompetenciasG.css" />    
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
                <h2 class="titulo">Plan de Estudios - Competencias</h2>
                <hr>
                <p>
                    En Pixel Penguins contamos con un plan académico pensado en que nuestros alumnos
                    obtengan las mejores competencias y habilidades. Si quieres ver detalle de las 
                    competencias de cada curso, haga click en "Ver competencias".
                </p>
                <!-- Contenedor para alinear la imagen a un lado y apilar droplist + botón verticalmente -->
                <div class="content-row">
                    <!-- Contenedor para el droplist y el botón apilados verticalmente -->
                    
                    <div class="image-containerP">
                        <asp:Image ID="imgHorario" runat="server" CssClass="img-fluid" />
                    </div>
                </div>
            </div>
        </div>
    </form>
</body>

</html>
