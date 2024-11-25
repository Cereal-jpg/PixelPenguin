<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="Matricularse.aspx.cs" Inherits="SoftPixelPenguinsWA.Matricularse" %>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Inicio - Pixel Penguins</title>
    <link rel="stylesheet" href="Content/Estilos.css" />
    <link rel="stylesheet" href="Content/Estilos-Matricularse.css" />
</head>
<body>
    <div class="containerM">
        <div class="header">
            <img src="Images/PIXEL.png" alt="Logo" />
            <h1>Pixel Penguins</h1>
            <div class="nav">
                <a href="Login.aspx">Intranet</a>
                <a href="Matricularse.aspx">Matrícula</a>
            </div>
        </div>

        <!-- Contenedor principal que agrupa el formulario a la izquierda y la imagen a la derecha -->
        <div class="main-container">
            <!-- Contenedor del formulario -->
            <div class="form-containerM">
                <form id="form1" runat="server">
                    <h2 class="form-title">¡Matrícula 2025!</h2>
                    <p>Conoce de nuestros planes académicos y comienza una nueva aventura con Pixel Penguins.</p>
                    <div class="button-container">
                        <asp:Button ID="IniciarProceso" runat="server" Text="Iniciar Proceso de matrícula" CssClass="login-button" OnClick="IniciarProceso_Click" />
                        <asp:Button ID="PlanEstudios" runat="server" Text="Plan de estudios" CssClass="login-button" OnClick="PlanEstudios_Click" />
                    </div>
                </form>
            </div>
        </div>
    </div>
</body>
</html>
