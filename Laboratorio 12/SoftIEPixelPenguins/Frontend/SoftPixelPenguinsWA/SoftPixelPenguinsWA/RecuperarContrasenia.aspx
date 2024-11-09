<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="RecuperarContrasenia.aspx.cs" Inherits="SoftPixelPenguinsWA.RecuperarContrasenia" %>

<!DOCTYPE html>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Pixel Penguins - Contraseña</title>
    <link rel="icon" type="image/png" href="Images/PIXEL2.png" />
    <link rel="stylesheet" href="Content/Estilos.css" />
    <style>
        .titulo {
         margin-top: 40px; /* Ajusta este valor según tus necesidades */
        }
        .form-containerDentro {
            max-width: 600px;
            display: flex;
            flex-direction: column;
            background-color: white;
            padding: 20px;
            border-radius: 6px;
            gap: 20px;
            margin: auto;
            margin-bottom: 10px;
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

        .error-message {
            border: 2px solid red;     /* Establece un borde de 2px de color rojo */
            padding: 10px;             /* Espacio interno alrededor del texto */
            color: red;                /* Color del texto (opcional, si quieres que sea rojo) */
            display: inline-block;      /* Permite que el borde se ajuste al contenido */
            margin-top: 10px;          /* Espacio superior (opcional) */
            background-color: #ffe6e6; /* Fondo claro (opcional, para destacar el error) */
        }


        .login-button {
            background-color: #000072;
            color: white;
            height: 45px;
            border-radius: 20px;
            cursor: pointer;
            width: 100%;
            text-align: center;
        }

        /* Contenedor para alinear la imagen y el grupo de droplist y botón */
        .content-row {
            display: flex;
            gap: 40px;
            flex-direction: column;
            align-items: center;
        }

        /* Contenedor para apilar el droplist y el botón verticalmente */


        .form-group-cont {
            width: 400px;
            margin-bottom: 30px; /* Espacio entre grupos */
            align-content: center;
        }

            /* Etiquetas dentro de los grupos de formulario */
            .form-group-cont label {
                display: block; /* Hace que la etiqueta ocupe todo el ancho */
                font-size: 14px; /* Tamaño de fuente */
                margin-top: 5px; /* Mayor espacio antes del botón */
                margin-bottom: 5px; /* Espacio debajo de la etiqueta */
            }

            /* Estilos para los campos de entrada */
            .form-group-cont input {
                width:90%; /* Ancho del campo de entrada */
                padding: 10px; /* Espaciado interno */
                border: 1px solid #ccc; /* Borde gris claro */
                border-radius: 4px; /* Bordes redondeados */
                font-size: 14px; /* Tamaño de fuente */
            }
        
        .actions {
            display: flex;             /* Habilita flexbox */
            justify-content: center;   /* Centra horizontalmente */
            align-items: center;       /* Centra verticalmente (opcional) */
            margin-top: 5px;         /* Espacio superior (opcional) */
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
        
        <!-- Contenedor del formulario de cambio de contraseña -->
        <div id="formContainer" runat="server" class="form-containerDentro">
            <h2 class="titulo">Cambiar Contraseña</h2>
            <hr>
            <p>
                Introduzca su correo institucional junto a la nueva contraseña. Recuerde que debe ser 
                una contraseña que usted pueda recordar
            </p>
            <div class="content-row">
                <asp:Label ID="errorMessage" runat="server" CssClass="error-message" Visible="false"></asp:Label>
                <asp:Label ID="confMessage" runat="server" CssClass="conf-message" Visible="false"></asp:Label>


                <div class="form-group-cont">
                    <label for="email">Correo Electrónico</label>
                    <asp:TextBox ID="email" runat="server" placeholder="Ingrese su correo electrónico" CssClass="input" TextMode="Email"></asp:TextBox>
                    <label for="password">Nueva Contraseña</label>
                    <asp:TextBox ID="password1" runat="server" placeholder="Ingrese su nueva contraseña" CssClass="input" TextMode="Password"></asp:TextBox>
                    <label for="password">Confirmar Contraseña</label>
                    <asp:TextBox ID="password2" runat="server" placeholder="Confirme su nueva contraseña" CssClass="input" TextMode="Password"></asp:TextBox>
                </div>
                <div class="actions">
                    <asp:Button ID="confirmar" runat="server" Text="Confirmar Cambios" CssClass="login-button" OnClick="confirmar_Click"/>
                </div>
            </div>
        </div>

        <!-- Contenedor para el mensaje de confirmación -->
        <div id="confirmationMessage" runat="server" class="form-containerDentro">
            <h2 class="titulo">Contraseña Cambiada</h2>
            <hr>
            <p>Su contraseña ha sido cambiada exitosamente.</p>
            <div class="actions">
                 <asp:Button ID="Volver" runat="server" Text="Iniciar Sesión" CssClass="login-button" OnClick="Volver_Click"/>
            </div>
        </div>
    </div>
</form>
</body>
</html>
