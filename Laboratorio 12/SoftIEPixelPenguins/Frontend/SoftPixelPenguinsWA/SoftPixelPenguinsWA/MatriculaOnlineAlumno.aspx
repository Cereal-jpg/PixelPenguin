<%@ Page Title="" Language="C#" MasterPageFile="~/SoftPixelPenguins.Master" AutoEventWireup="true" CodeBehind="MatriculaOnlineAlumno.aspx.cs" Inherits="SoftPixelPenguinsWA.MatriculaOnlineAlumno" %>
<asp:Content ID="Content1" ContentPlaceHolderID="cphTitulo" runat="server">
    MatrículaOnline - Alumno
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
    <a href="ReporteAlumno.aspx"><i class="fa-solid fa-bar-chart"></i>Reporte de Notas</a>
</asp:Content>
<asp:Content ContentPlaceHolderID="menuItem4" runat="server">
    <a href="MatriculaAlumno-0.aspx"><i class="fa-solid fa-archive"></i>Matrícula Online</a>
</asp:Content>
<asp:Content ContentPlaceHolderID="menuItem5" runat="server">
    <a href="PerfilAlumno.aspx"><i class="fa-solid fa-user"></i>Mi Perfil</a>
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
            <div class="button-container">
                <asp:Button ID="btnIniciarMatricula" runat="server" Text="Iniciar Proceso" CssClass="btn-matricula" OnClick="btnIniciarMatricula_Click" />
            </div>
        </div>
        <div class="image-section">
            <img src="Images/CHICOMAT.png" alt="Horario Académico" class="responsive-image"/>
        </div>
    </div>
</asp:Content>
