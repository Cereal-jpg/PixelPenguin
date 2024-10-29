<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="ProcesoMatricula.aspx.cs" Inherits="SoftPixelPenguinsWA.ProcesoMatricula" %>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Inicio de Sesión - Pixel Penguins</title>
    <link rel="stylesheet" href="Content/Estilos.css" />
    <style>
        hr{
            border: 1px solid black;
            width: 100%;
            margin: 20px auto;
        }


        .form-title {
            text-align: center;
            margin-bottom: 20px;
        }
        .form-containerDentro {
            max-width: 400px;
            display: flex;
            flex-direction: column;
            background-color: white;
            padding: 20px;
            border-radius: 6px;
        }
        .button-container {
             gap: 15px;
             display: flex; /* Flexbox para centrar texto */
            justify-content: center; /* Centrado */
            background-color: #000072; /* Color azul */
            color: white; /* Texto blanco */
            cursor: pointer; /* Cambia el cursor al pasar */
            border: 1px solid #000072; /* Borde azul */
            border-radius: 5px; /* Bordes redondeados */
            padding: 10px 15px; /* Espaciado interno */
            transition: background-color 0.3s, color 0.3s;
            width: 68%;
            margin: 0 auto; /* Centra el botón dentro del contenedor */
            text-align: center;
        }

        .login-button {
            width: 100%;
            background-color: #000072;
        }
    </style>
</head>
<body>
    <form id="form1" runat="server">
        <div class="container">
            <div class="header">
                <img src="Images/PIXEL.png" alt="Logo" />
                <h1>Pixel Penguins</h1>
                <div class="nav">
                    <a href="Login.aspx">Intranet</a>
                    <a href="Matricularce.aspx">Matrícula</a>
                </div>
            </div>

            <div class="form-containerDentro">
                <h2 class="title">Proceso de matrícula</h2>
                <hr>
                <p>Inicia tu proceso de matrícula 2025 y descubre con nosotros lo increíble que es aprender. Te esperamos en esta nueva aventura.</p>
                <br>
                <div class="container">
                    <br>
                    <h2 class="form-title">¿Desea iniciar con su proceso de matrícula?</h2>
                    <br>
                    <div class="button-container">
                        <asp:Button ID="IniciarMatricula" runat="server" Text="Iniciar Proceso de matrícula" CssClass="button-container" />
                    </div>
                </div>
            </div>
        </div>
    </form>
</body>
</html>

