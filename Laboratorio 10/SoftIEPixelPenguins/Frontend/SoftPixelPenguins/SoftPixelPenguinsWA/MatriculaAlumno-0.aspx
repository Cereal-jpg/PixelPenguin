﻿<%@ Page Language="C#" MasterPageFile="~/SoftPixelPenguins.Master" AutoEventWireup="true" CodeBehind="MatriculaAlumno-0.aspx.cs" Inherits="SoftPixelPenguinsWA.MatriculaAlumno_0" %>
<asp:Content ID="Content1" ContentPlaceHolderID="cphTitulo" runat="server">
    Matrícula - Alumno
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="cphScripts" runat="server">
</asp:Content>
<asp:Content ContentPlaceHolderID="menuItem1" runat="server">
    <a href="IndexAlumno.aspx"><i class="fa-solid fa-home"></i>Inicio</a>
</asp:Content>
<asp:Content ContentPlaceHolderID="menuItem2" runat="server">
    <a href="ListarCursosAlumno.aspx"><i class="fa-solid fa-book"></i>Mis cursos</a>
</asp:Content>
<asp:Content ContentPlaceHolderID="menuItem3" runat="server">
    <a href="ListarCursosAlumno.aspx"><i class="fa-solid fa-bar-chart"></i>Reporte de Notas</a>
</asp:Content>
<asp:Content ContentPlaceHolderID="menuItem4" runat="server">
    <a href="ListarCursosAlumno.aspx"><i class="fa-solid fa-archive"></i>Matrícula Online</a>
</asp:Content>
<asp:Content ID="Content3" ContentPlaceHolderID="cphContenido" runat="server">
    <h2 style="text-align: left; color: #000f;">Matrícula Online</h2>
    <link rel="stylesheet" href="Content/Estilos-Alumno.css" />
    <div class="container-matricula">
        <div class="matricula-section">
            <h3><i class="fas fa-lightbulb icon-color"></i>¡Hola!</h3>    
            <p>Bienvenido a la Matrícula online</p>
            <p>En este espacio podrás iniciar o consultar el estado de matrícula para el siguiente año</p>
            <p>¿Quieres iniciar con tu proceso? El proceso consta de 3 pasos</p>
            <div class="button-container"> <!-- Contenedor adicional para centrar el botón -->
                <asp:Button ID="btnIniciarMatricula" runat="server" Text="Iniciar Proceso" CssClass="btn-matricula" OnClick="btnIniciarMatricula_Click" />
            </div>
        </div>
        <div class="image-section">
            <img src="Images/Horario.jpg" alt="Horario Académico" />
        </div>
    </div>
</asp:Content>
