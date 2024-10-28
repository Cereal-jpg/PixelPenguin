<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="Matricularce.aspx.cs" Inherits="SoftPixelPenguinsWA.Matricularce" %>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Inicio - Pixel Penguins</title>
    <link rel="stylesheet" href="Content/Estilos.css" />
    <style>
        /* Estilos para el formulario en un contenedor cuadrado alineado a la derecha */
        .form-container {
            width: 400px;
            height: 400px;
            padding: 50px;
            position: absolute; /* Posición fija en la página */
            top: 100px; /* Ajusta la distancia desde el borde superior */
            background-color: #a1d7f7; /* Color de fondo original */
            border-radius: 10px;
            display: flex;
            overflow: hidden; 
            align-content: flex-end;
            margin-left: 20px;
        }

        .form-title {
            text-align: center; /* Centra el título */
            margin-bottom: 20px; /* Espacio debajo del título */
        }

        .login-button {
            display: block; /* Asegúrate de que cada botón sea un bloque */
            width: 100%; /* Ancho completo (opcional) */
            margin-bottom: 25px; /* Espacio entre botones */
        }

        /* Estilos para la imagen */
        .image-placeholder img {
            float: left; /* Permite que las imágenes floten a la izquierda */
            margin-right: 20px; /* Espacio a la derecha de la imagen */
            margin-left: 200px; /* Espacio a la izquierda de la imagen */
        }
    </style>
</head>
<body>
    <div class="container">
        <div class="header">
            <img src="Images/PIXEL.png" alt="Logo" />
            <h1>Pixel Penguins</h1>
            <div class="nav">
                <a href="Login.aspx">Intranet</a>
                <a href="Matricularce.aspx">Matrícula</a>
            </div>
        </div>
        <img src="Images/Matricula.jpg" alt="" width="500" height="400">
    </div>
    <div class="form-container">
        <form id="form1" runat="server">
            <h2 class="form-title">¡Matrícula 2025!</h2>
            <p>Conoce de nuestros planes académicos y comienza una nueva aventura con Pixel Penguins.</p>
            <br>

            <div class="button-container">
                <asp:Button ID="IniciarProceso" runat="server" Text="Iniciar Proceso de matrícula" CssClass="login-button" OnClick="IniciarProceso_Click"/>
                <asp:Button ID="PlanEstudios" runat="server" Text="Plan de estudios" CssClass="login-button" OnClick="PlanEstudios_Click"/>
            </div>
        </form>
    </div>
</body>
</html>
