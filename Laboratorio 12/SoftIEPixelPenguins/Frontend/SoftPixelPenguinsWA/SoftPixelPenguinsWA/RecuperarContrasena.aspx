<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="RecuperarContrasena.aspx.cs" Inherits="SoftPixelPenguinsWA.RecuperarContrasena" %>

<!DOCTYPE html>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Pixel Penguins - Contraseña</title>
    <link rel="icon" type="image/png" href="Images/PIXEL2.png" />
    <link rel="stylesheet" href="Content/Estilos.css" />
    <link rel="stylesheet" href="Content/Estilos-RecuperarContraseña.css" />

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
