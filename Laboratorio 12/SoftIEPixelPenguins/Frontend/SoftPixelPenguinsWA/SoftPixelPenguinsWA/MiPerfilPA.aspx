<%@ Page Title="" Language="C#" MasterPageFile="~/SoftPixelPenguins.Master" AutoEventWireup="true" CodeBehind="MiPerfilPA.aspx.cs" Inherits="SoftPixelPenguinsWA.MiPerfilPA" %>
<asp:Content ID="Content1" ContentPlaceHolderID="cphTitulo" runat="server">
    Mi Perfil - Personal Admin
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="cphScripts" runat="server">
</asp:Content>

<asp:Content ContentPlaceHolderID="menuItem1" runat="server">
    <a href="IndexPersonalAdministrativo.aspx"><i class="fa-solid fa-home"></i>Inicio</a>
</asp:Content>
<asp:Content ContentPlaceHolderID="menuItem2" runat="server">
    <a href="ReportesPA.aspx"><i class="fa-solid fa-book"></i>Reportes</a>
</asp:Content>
<asp:Content ContentPlaceHolderID="menuItem3" runat="server">
    <a href="BusquedaPA.aspx"><i class="fa-solid fa-search"></i>Busqueda</a>
</asp:Content>
<asp:Content ContentPlaceHolderID="menuItem4" runat="server">
    <a href="CursosYHorariosPA.aspx"><i class="fa-solid fa-calendar-days"></i>Cursos y Horarios</a>
</asp:Content>
<asp:Content ContentPlaceHolderID="menuItem5" runat="server">
    <a href="GestionarSolicitudesPA.aspx"><i class="fa-solid fa-user-plus"></i>Gestionar Solicitudes</a>
</asp:Content>
<asp:Content ContentPlaceHolderID="menuItem6" runat="server">
    <a href="GestionarPlanesPA.aspx"><i class="fa-solid fa-list-check"></i>Gestionar Planes</a>
</asp:Content>
<asp:Content ContentPlaceHolderID="menuItem7" runat="server">
    <a href="MiPerfilPA.aspx"><i class="fa-solid fa-user"></i>Mi Perfil</a>
</asp:Content>

<asp:Content ID="Content3" ContentPlaceHolderID="cphContenido" runat="server">
    <head> 

        <style>

            * {
                box-sizing: border-box;
                font-family: Arial, sans-serif;
            }

            .header {
                background-color: #000072; /* Color de fondo azul */
                display: flex; /* Flexbox para alineación */
                left: 0;
                padding: 15px; /* Espaciado interno */
                color: white; /* Color de texto blanco */
                position: fixed; /* Fija el div en la parte superior */
                top: 0; /* Ubica el header en la parte superior */
                width: 100%; /* Ancho completo */
                z-index: 1000; /* Asegura que esté por encima de otros elementos */
                align-items: center; /* Centra verticalmente el contenido */
                justify-content: flex-start; /* Espacia el contenido de izquierda a derecha */
                margin-right: 10px;
            }

            /* Estilo para la imagen en el header */
            .header img {
                height: 40px; /* Altura de la imagen del logo */
                margin-right: 10px; /* Espacio a la derecha del logo */

            }

            /* Estilo para el título del header */
            .header h1 {
                font-size: 24px; /* Tamaño de fuente */
                margin: 0; /* Sin margen por defecto */
            }

            /* Navegación en el header */
            .nav {
                margin-left: auto;
                margin-right: 30px;
                display: flex; /* Flexbox para navegación */
                gap: 20px; /* Espacio entre los enlaces */
            }

            /* Estilos para los enlaces de navegación */
            .nav a {
                text-decoration: none; /* Sin subrayado */
                color: white; /* Color de texto blanco */
                font-weight: bold; /* Texto en negrita */
            }

            .container {
                width: 80%;
                margin: auto;
                margin-top: 100px;
                background-color: #e8f0ff;
                padding: 15px;
                border-radius: 8px;
            }

            h2 {
                text-align: left;
                color: #333;
            }

            h3 {
                margin-top: 10px;
                text-align: left;
                color: #333;
            }

            .progress-bar {
                display: flex;
                justify-content: center;
                margin: 20px 0;
            }

            .step {
                width: 30px;
                height: 30px;
                margin: 0 10px;
                border-radius: 50%;
                background-color: #ccc;
            }

            .step.active {
                background-color: #4caf50;
            }

            .section {
                display: none;
            }

            .section.active {
                display: block;
            }

            .form-section {
                background-color: #cfe2f3;
                padding: 15px;
                padding-top: 5px;
                margin: 15px;
                border-radius: 8px;
            }

            .form-group{
                display: flex;
                width: 100%;
                gap: 10px;
                margin-bottom: 15px;
            }

            .form-row{
                flex: 1;
                min-width: 15%;
            }

            label {
                display: block;
                margin: 10px 0;
                color: black;
            }

            input[type="text"], input[type="date"], input[type="email"], input[type="file"] {
                width: 100%;
                padding: 8px;
                border: none;
                border-radius: 4px;
            }

            .button-group {
                text-align: center;
                margin-top: 20px;
            }

            button, .button-style {
                padding: 10px 20px;
                margin: 0 5px;
                background-color: #666;
                background-color: #007bff;
                color: #fff;
                border: none;
                border-radius: 4px;
                cursor: pointer;
            }

            button:hover {
                background-color: #0056b3;
            }

            .file-upload {
                display: inline-block;
                width: 100%;
                padding: 10px;
                font-size: 14px;
                color: #555;
                background-color: #f5f5f5;
                border: 1px solid #ccc;
                border-radius: 5px;
                cursor: pointer;
                transition: background-color 0.3s ease;
            }

            #section3, #section5, #section6 {
                text-align: center;
                padding: 20px;
            }

            .form-info{
                background-color: midnightblue;
                border-radius: 10px;
                text-align: center;
                width: 35%;
                margin: auto;
                padding: 5px;
            }

            .dll{
                border-radius: 5px;
                margin: auto;
                padding: 5px;
                width: 50%;
            }

            .input-group {
                position: relative;
                display: flex;
                align-items: center;
                height: 40px; /* Ajusta según sea necesario */
            }

            .password-field {
                width: 100%; /* Ajusta según el diseño deseado */
                padding-right: 2.5rem; /* Espacio para el ícono */
                box-sizing: border-box; /* Asegura que el padding no afecte el tamaño total */
                height: 100%; /* Hace que el TextBox tenga el mismo alto que el contenedor */
                font-size: 16px; /* Asegura que el tamaño de la fuente sea consistente */
            }

            .input-icon {
                position: absolute;
                right: 10px; /* Ajusta según sea necesario */
                cursor: pointer;
                height: 100%; /* Hace que el ícono tenga el mismo alto que el TextBox */
                display: flex;
                align-items: center;
            }



        </style>

        <script>
            document.addEventListener("DOMContentLoaded", function () {
                const togglePassword = document.querySelector('#togglePassword');
                const passwordField = document.querySelector('#<%= txtContrasena.ClientID %>');

                togglePassword.addEventListener('click', function (e) {
                    // Cambia el atributo type
                    const type = passwordField.getAttribute('type') === 'password' ? 'text' : 'password';
                    passwordField.setAttribute('type', type);
                    // Cambia el ícono
                    this.classList.toggle('fa-eye-slash');
                });
            });
        </script>


    </head>
    

    <h2 style="text-align: left; color: #000f;">Personal Administrativo - Mi Perfil</h2>
        <link rel="stylesheet" href="Content/Estilos-Alumno.css" />

        <div class="schedule">
            <div id="section1" class="section" runat="server" style="display: block;">

                <div class="form-section">
                    <h3>Datos del Profesor</h3>
                    <div class="form-group">
                        <div class="form-row">
                            <label>Nombres:</label>
                            <asp:TextBox ID="txtNombreAlumno" runat="server" placeholder="Nombres"></asp:TextBox>
                        </div>
                        <div class="form-row">
                            <label>Apellido Paterno:</label>
                            <asp:TextBox ID="txtApellidoPaterno" runat="server" placeholder="Apellido Paterno"></asp:TextBox>
                        </div>
                        <div class="form-row">
                            <label>Apellido Materno:</label>
                            <asp:TextBox ID="txtApellidoMaterno" runat="server" placeholder="Apellido Materno"></asp:TextBox>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="form-row">
                            <label>DNI:</label>
                            <asp:TextBox ID="txtDNIAlumno" runat="server" placeholder="DNI"></asp:TextBox>
                        </div>
                        <div class="form-row">
                            <label>Fecha de Nacimiento:</label>
                            <asp:TextBox ID="dtpFechaNacimiento" runat="server" placeholder="Fecha de Nacimiento" CssClass="date-picker" TextMode="Date"></asp:TextBox>
                        </div>
                        <div class="form-row">
                            <label>Sexo:</label>
                            <asp:TextBox ID="txtSexo" runat="server" placeholder="Sexo"></asp:TextBox>
                        </div>
                        <div class="form-row">
                            <label>Email:</label>
                            <asp:TextBox ID="txtEmail" runat="server" placeholder="Email"></asp:TextBox>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="form-row">
                            <label>Direccion:</label>
                            <asp:TextBox ID="txtDireccion" runat="server" placeholder="Direccion"></asp:TextBox>
                        </div>
                        <div class="form-row">
                            <label>Usuario:</label>
                            <asp:TextBox ID="txtUsuario" runat="server" placeholder="Usuario"></asp:TextBox>
                        </div>
                        <div class="form-row">
                            <label>Contraseña:</label>
                            <div class="input-group">
                                <asp:TextBox ID="txtContrasena" runat="server" placeholder="Contraseña" TextMode="Password" CssClass="form-control password-field"></asp:TextBox>
                                <span class="input-icon">
                                    <i class="fa fa-eye" id="togglePassword" style="cursor: pointer;"></i>
                                </span>
                            </div>
                        </div>
                    </div>
                </div>

            </div>
    
        </div>

</asp:Content>

