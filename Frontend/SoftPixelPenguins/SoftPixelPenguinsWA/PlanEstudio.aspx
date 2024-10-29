 <%@ Page Language="C#" AutoEventWireup="true" CodeBehind="PlanEstudio.aspx.cs" Inherits="SoftPixelPenguinsWA.PlanEstudio" %>


<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Inicio de Sesión - Pixel Penguins</title>
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
        .form-select {
             color: white;                   /* Color del texto */
             background-color: #000072;      /* Color de fondo */
             border: 2px solid #000072;      /* Color y grosor del borde */
             border-radius: 20px;            /* Bordes redondeados */
             padding: 10px 20px;             /* Tamaño interno más grande */
             font-size: 16px;                /* Tamaño de fuente */
             width: 30%; 
             text-align: center;             /* Centrar texto */
            text-align-last: center; 
         }
        .form-select option {
            color: black;             /* Color de texto de las opciones */
            background-color: white;  /* Fondo de las opciones */
        }
        .button-container {
            display: flex;
            flex-direction: column;
            gap: 20px;
        }

        .login-button {
            width: 100%;
            background-color: #000072;
            width: 31%; 
            height: 45px;
            border-radius: 20px; 
            margin-top: 20px;     
        }
        .image-container {
            display: flex;
            align-items: center;
            width: 35%;
        }

        .image-container img {
            width: 100%;
            border-radius: 8px;
            max-height: 250px;
            object-fit: cover;
        }
    </style>
</head>
<body>
    <form id="form1" runat="server">
        <div class="container">
            <div class="header" >
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
                <p>En Pixel Penguins contamos con un plan académico pensado en que nuestros alumnos
                    obtengan las mejores competencias y habilidades. Si quieres ver detalle de las 
                    competencias de cada curso, haga click en”Ver competencias </p>
                <br>
                <div class="col-md-12 mb-3">
                <asp:Label ID="lblDepartamento" runat="server"  CssClass="col-form-label" />
                <asp:DropDownList ID="ddlDepartamento" CssClass="form-select" runat="server">
                     <asp:ListItem Text="Primaria" Value="1"></asp:ListItem>
                     <asp:ListItem Text="Secundaria" Value="2"></asp:ListItem>
                </asp:DropDownList>
                </div>
                <div class="button-container">
               <asp:Button ID="VerCompetencias" runat="server" Text="Ver competencias" CssClass="login-button"  />
            </div>
                <div class="image-container">
                    <img src="Images/Primaria.png" alt="Horario primaria" />
                </div>
            </div>
            </form>

</body>
</html>
