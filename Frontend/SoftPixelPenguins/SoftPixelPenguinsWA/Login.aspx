﻿<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="Login.aspx.cs" Inherits="SoftPixelPenguinsWA.Login" %>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Inicio de Sesión - Pixel Penguins</title>
    <link rel="stylesheet" href="Content/Estilos.css" />
</head>
<body>
    <form id="form1" runat="server">
        <div class="container">
            <div class="header" >
                <img src="Images/PIXEL.png" alt="Logo" />
                <h1>Pixel Penguins</h1>
                <div class="nav">
                    <a href="#">Intranet</a>
                    <a href="#">Matrícula</a>
                </div>
            </div>
            <div class="content">
                <div class="form-container">
                    <h2>Inicio de Sesión</h2>
                    <asp:Label ID="errorMessage" runat="server" CssClass="error-message" Visible="false"></asp:Label>
                    <div class="form-group">
                        <label for="email">Correo Electrónico</label>
                        <asp:TextBox ID="email" runat="server" placeholder="Ingrese su correo electrónico" CssClass="input" TextMode="Email"></asp:TextBox>
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
                    <img src="Images/Colegio.png" style="width: 100%; height: 100%; object-fit: cover; border-radius: 8px;"/>
                </div>
            </div>
        </div>
    </form>
</body>
</html>