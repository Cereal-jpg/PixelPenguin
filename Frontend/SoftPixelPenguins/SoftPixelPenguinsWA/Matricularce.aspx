<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="Matricularce.aspx.cs" Inherits="SoftPixelPenguinsWA.Matricularce" %>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Inicio - Pixel Penguins</title>
    <link rel="stylesheet" href="Content/Estilos.css" />
    <style>
        /* Contenedor principal para la imagen y el formulario */
        .main-container {
            display: flex;
            justify-content: flex-start; /* Coloca el formulario a la izquierda */
            align-items: center;
            gap: 10px; /* Espacio entre el formulario y la imagen */
            margin: 0;
            max-width: 800px;
            padding: 0;
            background-color: transparent; /* Totalmente transparente */
            border-color: transparent;
        }

        .containerM {
            width: 100%; /* Ancho completo */
            max-width: 1200px; /* Ancho máximo */
            background-color: transparent; /* Fondo blanco */
            border-radius: 8px; /* Bordes redondeados */
            overflow: hidden; /* Oculta cualquier contenido desbordado */
        }

        /* Contenedor del formulario */
        .form-containerM {
            max-width: 400px;
            display: flex;
            flex-direction: column;
            background-color: white;
            padding: 20px;
            border-radius: 6px;
        }

        /* Contenedor de la imagen */
        .image-container {
            display: flex;
            justify-content: center;
            align-items: center;
            background-color: transparent;
            max-width: 300px;
        }

        /* Estilo para la imagen */
        .image-container img {
            width: 100%;
            height: auto;
            border-radius: 6px;
        }

        .form-title {
            text-align: center;
            margin-bottom: 20px;
        }

        .button-container {
            display: flex;
            flex-direction: column;
            gap: 15px;
        }

        .login-button {
            width: 100%;
            background-color: #000072;
        }

        /* Fondo de pantalla completo */
        body {
            background-image: url("Images/Matricula.jpg");
            background-size: cover;
            background-repeat: no-repeat;
        }
    </style>
</head>
<body>
    <div class="containerM">
        <div class="header">
            <img src="Images/PIXEL.png" alt="Logo" />
            <h1>Pixel Penguins</h1>
            <div class="nav">
                <a href="Login.aspx">Intranet</a>
                <a href="Matricularce.aspx">Matrícula</a>
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
