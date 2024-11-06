<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="ProcesoMatricula.aspx.cs" Inherits="SoftPixelPenguinsWA.ProcesoMatricula" %>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Pixel Penguins - Matrícula</title>
    <link rel="icon" type="image/png" href="Images/PIXEL2.png" />
    <link rel="stylesheet" href="Content/Estilos.css" />
    <style>
       
        .container-Matricula {
            width: 100%; /* Ancho completo */
            max-width: 1200px; /* Ancho máximo */
            background-color: white; /* Fondo blanco */
            border-radius: 8px; /* Bordes redondeados */
            box-shadow: 0 0 15px rgba(0, 0, 0, 0.1); /* Sombra suave */
            overflow: hidden; /* Oculta cualquier contenido desbordado */
            padding: 0;
        }

        .container-P {
            width: 90%; /* Ancho completo */
            max-width: 1200px; /* Ancho máximo */
            min-height: 170px;
            background-color: #e6e6e6; /* Fondo blanco */
            border-radius: 8px; /* Bordes redondeados */
            margin: 0 auto;
            gap: 10px;
            padding: 10px;
            overflow: hidden;
        }

        .form-title {
            text-align: center;
            margin-bottom: 5px;
            margin-right: 5px;
            margin-left: 5px;
        }

        .form-containerDentro {
            max-width: 600px;
            max-height: 800px;
            display: flex;
            flex-direction: column;
            background-color: white;
            padding: 20px;
            border-radius: 6px;
            margin-bottom: 6px;
            gap: 2px;
        }

        .button-container {
            display: flex; /* Flexbox para centrar texto */
            justify-content: center; /* Centrado */
            background-color: #000072; /* Color azul */
            color: white; /* Texto blanco */
            cursor: pointer; /* Cambia el cursor al pasar */
            border: 1px solid #000072; /* Borde azul */
            border-radius: 5px; /* Bordes redondeados */
            padding: 10px 15px 10px; /* Espaciado interno */
            transition: background-color 0.3s, color 0.3s;
            width: auto;
            max-width: 70%;
            height: 100%;
            margin: 0 auto; /* Centra el botón dentro del contenedor */
            text-align: center;
            font-size: 17px;
        }

        .titulo{
            margin: 0 0 auto 0;
        }

        .login-button {
            width: 100%;
            background-color: #000072;
        }

         
    </style>
</head>
<body>
    <form id="form1" runat="server">
        <div class="container-Matricula">
            <div class="header">
                <img src="Images/PIXEL.png" alt="Logo" />
                <h1>Pixel Penguins</h1>
                <div class="nav">
                    <a href="Login.aspx">Intranet</a>
                    <a href="Matricularce.aspx">Matrícula</a>
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

