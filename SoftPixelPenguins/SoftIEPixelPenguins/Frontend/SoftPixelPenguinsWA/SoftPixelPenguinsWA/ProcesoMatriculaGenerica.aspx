<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="ProcesoMatriculaGenerica.aspx.cs" Inherits="SoftPixelPenguinsWA.ProcesoMatriculaGenerica" %>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Pixel Penguins - Matrícula</title>
    <link rel="icon" type="image/png" href="Images/PIXEL2.png" />
    <link rel="stylesheet" href="Content/Estilos.css" />
    <link rel="stylesheet" href="Content/Estilos-ProcesoMatriculaG.css" />
</head>
<body>
    <form id="form1" runat="server">
        <div class="container-Matricula">
            <div class="header">
                <img src="Images/PIXEL.png" alt="Logo" />
                <h1>Pixel Penguins</h1>
                <div class="nav">
                    <a href="Login.aspx">Intranet</a>
                    <a href="Matricularse.aspx">Matrícula</a>
                </div>
            </div>
            <div class="form-containerDentro">
                <h2 class="titulo">Proceso de matrícula</h2>
                <hr>
                <p>Inicia tu proceso de matrícula 2025 y descubre con nosotros lo increíble que es aprender. Te esperamos en esta nueva aventura.</p>
                <br>
                <div class="container-P">
                    <br>
                    <h3 class="form-title">¿Desea iniciar con su proceso de matrícula?</h3>
                    <br>
                    <div class="button-container">
                        <asp:Button ID="IniciarMatricula" runat="server" Text="Iniciar Proceso de matrícula" CssClass="button-container" OnClick="IniciarMatricula_Click"/>
                    </div>
                </div>
            </div>
        </div>
    </form>
</body>
</html>







































































