<%@ Page Title="" Language="C#" MasterPageFile="~/SoftPixelPenguins.Master" AutoEventWireup="true" CodeBehind="PerfilAlumno.aspx.cs" Inherits="SoftPixelPenguinsWA.PerfilAlumno" %>

<asp:Content ID="Content1" ContentPlaceHolderID="cphTitulo" runat="server">
    Alumno - Perfil
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="cphScripts" runat="server">
</asp:Content>
<asp:Content ContentPlaceHolderID="menuItem1" runat="server">
    <a href="IndexAlumno.aspx"><i class="fa-solid fa-home"></i>Inicio</a>
</asp:Content>
<asp:Content ContentPlaceHolderID="menuItem2" runat="server">
    <a href="ListarCursos.aspx"><i class="fa-solid fa-book"></i>Mis cursos</a>
</asp:Content>
<asp:Content ContentPlaceHolderID="menuItem3" runat="server">
    <a href="IndexAlumno.aspx"><i class="fa-solid fa-bar-chart"></i>Reporte de Notas</a>
</asp:Content>
<asp:Content ContentPlaceHolderID="menuItem4" runat="server">
    <a href="MatriculaAlumno-0.aspx"><i class="fa-solid fa-archive"></i>Matrícula Online</a>
</asp:Content>
<asp:Content ContentPlaceHolderID="menuItem5" runat="server">
    <a href="PerfilAlumno.aspx"><i class="fa-solid fa-user"></i>Mi Perfil</a>
</asp:Content>

<asp:Content ID="Content3" ContentPlaceHolderID="cphContenido" runat="server">
    <h2 style="text-align: left; color: #000f;">Alumno - Mi Perfil</h2>
    <link rel="stylesheet" href="Content/Estilos.css" />

    <style>/**/
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f0f0;
            margin: 0;
            padding: 0;
        }
        .container {
            width: 80%;
            margin: 20px auto;
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        .flex-container {
            display: flex;
            flex-wrap: wrap;
        }
        .photo-section {
            flex: 1;
            text-align: center;
            margin-bottom: 20px;
            margin-right: 20px;
        }
        .photo-section img {
            border-radius: 50%;
            width: 150px;
            height: 150px;
            object-fit: cover;
        }
        .section {
            flex: 2;
            margin-bottom: 20px;
            background-color: #ccc; /* Gris más claro */
            padding: 20px;
            border-radius: 8px;
            color: black; /* Mejor contraste */
        }
        .section-header {
            background-color: #ddd; /* Gris más claro */
            padding: 10px;
            border-radius: 4px;
            font-weight: bold;
        }
        .section-content {
            padding: 10px;
        }
        .input-group, .input-group-inline {
            margin-bottom: 15px; /* Mayor separación entre grupos */
            border-radius: 2px;
        }
        .input-group label, .input-group asp:TextBox, .input-group-inline label, .input-group-inline asp:TextBox {
            display: block; /* Asegura que los elementos sean bloques */
            margin-bottom: 5px; /* Separación entre el label y el TextBox */
            border-radius: 2px;
        }
        .input-group asp:TextBox, .input-group-inline asp:TextBox {
            width: 100%; /* Ocupa todo el ancho disponible */
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }
        .input-group-inline {
            display: flex;
            justify-content: space-between;
            border-radius: 2px;
        }

        .input-group-inline input {
            width: 90%; /* Ancho del campo de entrada */
            padding: 10px; /* Espaciado interno */
            border: 1px solid #ccc; /* Borde gris claro */
            border-radius: 4px; /* Bordes redondeados */
            font-size: 14px; /* Tamaño de fuente */
        }
        .input-group input {
            width: 90%; /* Ancho del campo de entrada */
            padding: 10px; /* Espaciado interno */
            border: 1px solid #ccc; /* Borde gris claro */
            border-radius: 4px; /* Bordes redondeados */
            font-size: 14px; /* Tamaño de fuente */
        }

        .input-half {
            flex: 0 0 48%; /* Ajusta el ancho de los campos al 48% para que quepan dos en línea */
            border-radius: 2px;
        }
        .input-group button {
            padding: 10px 20px;
            background-color: #007bff;
            color: #fff;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }
        .input-group button:hover {
            background-color: #0056b3;
        }
        .download-button {
            display: flex;
            align-items: center;
            padding: 10px;
            background-color: #eee; /* Gris más claro */
            border: 1px solid #ddd; /* Gris más claro */
            border-radius: 4px;
            text-decoration: none;
            color: #000;
            margin-bottom: 10px;
        }
        .download-button:hover {
            background-color: #ddd; /* Gris más claro */
        }
        .download-button img {
            margin-right: 10px;
        }

        .responsive-image {
            width: 4%; /* Ajusta este valor según el tamaño deseado */
            height: auto;
        }

        .responsive-image2 {
            width: 150%; /* Ajusta este valor según el tamaño deseado */
        }

        h3 {
            color: #333;
            margin-bottom: 15px;
            text-align: left; /* Alineación a la izquierda */
            font-size: 20px; /* Tamaño del texto */
            border-bottom: 2px solid #000000; /* Línea debajo del título */
            padding-bottom: 10px; /* Espacio interno debajo del título */
        }

    </style>

    <div class="container">
        <div class="flex-container">
            <div class="photo-section">
                <img src="Images/SINFOTO.png" alt="Foto del Alumno" class="responsive-image2">
            </div>
            <div class="section">
                <h3>Datos del Alumno</h3>
                <div class="section-content">
                    <div class="input-group">
                        <label for="nombre">Nombre:</label>
                        <asp:TextBox ID="nombre" runat="server" CssClass="input"></asp:TextBox>
                    </div>
                    <div class="input-group">
                        <label for="apellido-paterno">Apellido Paterno:</label>
                        <asp:TextBox ID="TextBox1" runat="server" CssClass="input"></asp:TextBox>
                    </div>
                    <div class="input-group-inline">
                        <div class="input-group">
                            <label for="apellido-materno">Apellido Materno:</label>
                            <asp:TextBox ID="TextBox2" runat="server" CssClass="input"></asp:TextBox>
                        </div>
                        <div class="input-half">
                            <label for="dni">DNI:</label>
                            <asp:TextBox ID="dni" runat="server"></asp:TextBox>
                        </div>
                    </div>
                    <div class="input-group">
                        <label for="fecha-nacimiento">Fecha de Nacimiento:</label>
                        <asp:TextBox ID="TextBox3" runat="server" TextMode="Date" CssClass="input"></asp:TextBox>
                    </div>
                    <div class="input-group">
                        <label for="sexo">Sexo:</label>
                        <asp:TextBox ID="sexo" CssClass="input" runat="server"></asp:TextBox>
                    </div>
                    <div class="input-group">
                        <label for="email">Email:</label>
                        <asp:TextBox ID="email" runat="server" CssClass="input" TextMode="Email"></asp:TextBox>
                    </div>
                    <div class="input-group">
                        <button type="button">Editar</button>
                    </div>
                </div>
            </div>
        </div>
        <div class="section">
            <h3>Datos del Apoderado</h3>
            <div class="section-content">
                <div class="input-group">
                    <label for="dni-apoderado">DNI:</label>
                    <asp:TextBox ID="TextBox4" runat="server"></asp:TextBox>
                </div>
                <div class="input-group">
                    <label for="telefono-apoderado">Teléfono:</label>
                    <asp:TextBox ID="TextBox5" runat="server"></asp:TextBox>
                </div>
                <div class="input-group">
                    <button type="button">Editar</button>
                </div>
            </div>
        </div>
        <div class="section">
            <h3>Certificados</h3>
            <div class="section-content">
                <a href="#" class="download-button">
                    <img src="Images/download-icon.png" alt="Download Icon" class="responsive-image">
                    Descargar Certificado de Estudios
                </a>
                <a href="#" class="download-button">
                    <img src="Images/download-icon.png" alt="Download Icon" class="responsive-image">
                    Descargar Certificado de Salud
                </a>
            </div>
        </div>
    </div>
</asp:Content>


