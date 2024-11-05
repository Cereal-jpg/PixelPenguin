<%@ Page Title="" Language="C#" MasterPageFile="~/SoftPixelPenguins.Master" AutoEventWireup="true" CodeBehind="CompetenciasCursos.aspx.cs" Inherits="SoftPixelPenguinsWA.CompetenciasCursos" %>
<asp:Content ID="Content1" ContentPlaceHolderID="cphTitulo" runat="server">
    Mis Cursos
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

<asp:Content ID="Content3" ContentPlaceHolderID="cphContenido" runat="server">
    <h2 style="text-align: left; color: #000f;">Alumno - Mis Cursos - Mis Competencias</h2>
    <link rel="stylesheet" href="Content/Fonts/EstiloCurso.css" />

    <div class="container-al">
        <div class="schedule">


        </div>
    </div>
</asp:Content>

