<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="SecundariaIM.aspx.cs" Inherits="SoftPixelPenguinsWA.SecundariaIM" %>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Inicio de Sesión - Pixel Penguins</title>
    <link rel="stylesheet" href="Content/Estilos.css" />
    <style>
        .container-Matricula {
            width: 100%;
            max-width: 1200px;
            background-color: white;
            border-radius: 8px;
            box-shadow: 0 0 15px rgba(0, 0, 0, 0.1);
            overflow: hidden;
            padding: 0;
        }
        .titulo {
         margin-top: 40px; /* Ajusta este valor según tus necesidades */
        }
        .form-containerDentro {
            max-width: 800px;
            display: flex;
            flex-direction: column;
            background-color: white;
            padding: 20px;
            border-radius: 6px;
            gap: 20px;
        }

        .form-select {
            color: white;
            background-color: #000072;
            border: 2px solid #000072;
            border-radius: 20px;
            padding: 10px 25px 10px 10px;
            font-size: 16px;
            width: 100%;
            text-align: center;
            text-align-last: center;
            position: relative;

        }

        .form-select option {
            color: black;
            background-color: white;
        }

        .login-button {
            background-color: #000072;
            color: white;
            height: 45px;
            border-radius: 20px;
            cursor: pointer;
            width: 100%;
        }

        /* Contenedor para alinear la imagen y el grupo de droplist y botón */
        .content-row {
            display: flex;
            align-items: center;
            gap: 40px;
        }

        /* Contenedor para apilar el droplist y el botón verticalmente */

        .image-containerP {
            width: 60%;
        }

        .image-containerP img {
            width: 100%;
            border-radius: 8px;
            max-height: 400px;
            object-fit: cover;
        }
        .controls-column {
            display: flex;
            flex-direction: column;
            gap: 50px; /* Aumentado el gap para más separación */
            width: 30%; /* Ancho del contenedor para el droplist y el botón */
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
                        <asp:DropDownList ID="ddlDepartamento" CssClass="form-select" runat="server"  AutoPostBack="true">
                            <asp:ListItem Text="Primaria" Value="1"></asp:ListItem>
                            <asp:ListItem Text="Secundaria" Value="2"></asp:ListItem>
                        </asp:DropDownList>
                        <asp:Button ID="VerCompetencias" runat="server" Text="Ver competencias" CssClass="login-button" />
                    </div>
                    <!-- Contenedor de la imagen a la derecha -->
                    <div class="image-containerP">
                        <img src="Images/Secundaria.png" alt="Horario primaria" />
                    </div>
                </div>
            </div>
    </form>
</body>
</html>
