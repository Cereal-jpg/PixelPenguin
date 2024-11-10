<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="Login.aspx.cs" Inherits="SoftPixelPenguinsWA.Login" %>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Pixel Penguins - Intranet</title>

    <link rel="icon" type="image/png" href="Images/PIXEL2.png" />

    <link rel="stylesheet" href="Content/Estilos.css" />
    <style>
        body {
            background-image: url("Images/Escuela.png");
            background-size: cover;
            background-repeat: no-repeat;
        }
    </style>
</head>
<body>
    <form id="form1" runat="server">
        <div class="container">
            <div class="header" >
                <img src="Images/PIXEL2.png" alt="Logo" />
                <h1>Pixel Penguins</h1>
                <div class="nav">
                    <a href="Login.aspx">Intranet</a>
                    <a href="Matricularse.aspx">Matrícula</a>
                </div>
            </div>
            <div class="content">
                <div class="form-container">
                    <h2>Inicio de Sesión</h2>
                    <asp:Label ID="errorMessage" runat="server" CssClass="error-message" Visible="false"></asp:Label>
                    <div class="form-group">
                        <label for="email">Usuario</label>
                        <asp:TextBox ID="user" runat="server" placeholder="Ingrese su usuario" CssClass="input" TextMode="Email"></asp:TextBox>
                    </div>
                    <div class="form-group">
                        <label for="password">Contraseña</label>
                        <asp:TextBox ID="password" runat="server" placeholder="Ingrese su contraseña" CssClass="input" TextMode="Password"></asp:TextBox>
                    </div>
                    <div class="actions">
                        <asp:Button ID="forgotPasswordButton" runat="server" Text="¿Olvidaste tu contraseña?" CssClass="forgot-password" OnClick="forgotPasswordButton_Click" />
                        <asp:Button ID="loginButton" runat="server" Text="Iniciar Sesión" CssClass="login-button" OnClick="loginButton_Click" />
                    </div>
                </div>
                <div class="image-placeholder">
                    <img src="Images/PIXEL.png" style="width: 90%; height: auto; object-fit: cover; border-radius: 8px;"/>
                </div>
            </div>
        </div>
    </form>
</body>
</html>
