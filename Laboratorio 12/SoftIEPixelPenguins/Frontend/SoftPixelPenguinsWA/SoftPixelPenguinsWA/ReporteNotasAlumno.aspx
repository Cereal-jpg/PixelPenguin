﻿<%@ Page Title="" Language="C#" MasterPageFile="~/SoftPixelPenguins.Master" AutoEventWireup="true" CodeBehind="ReporteNotasAlumno.aspx.cs" Inherits="SoftPixelPenguinsWA.ReporteNotasAlumno" %>

<asp:Content ID="Content1" ContentPlaceHolderID="cphTitulo" runat="server">
    Alumno - Notas
<asp:Content ContentPlaceHolderID="menuItem1" runat="server">
    <a href="IndexAlumno.aspx"><i class="fa-solid fa-home"></i>Inicio</a>
</asp:Content>
<asp:Content ContentPlaceHolderID="menuItem2" runat="server">
    <a href="MisCursosAlumno.aspx"><i class="fa-solid fa-book"></i>Mis cursos</a>
</asp:Content>
<asp:Content ContentPlaceHolderID="menuItem3" runat="server">
    <a href="ReporteNotasAlumno.aspx"><i class="fa-solid fa-bar-chart"></i>Reporte de Notas</a>
</asp:Content>
<asp:Content ContentPlaceHolderID="menuItem4" runat="server">
    <a href="MatriculaOnlineAlumno.aspx"><i class="fa-solid fa-archive"></i>Matrícula Online</a>
</asp:Content>
<asp:Content ContentPlaceHolderID="menuItem5" runat="server">
    <a href="MiPerfilAlumno.aspx"><i class="fa-solid fa-user"></i>Mi Perfil</a>
</asp:Content>
<asp:Content ContentPlaceHolderID="menuItem6" runat="server">
    <a href="MiPerfilAlumno.aspx"><i class="fa-solid fa-user"></i>Mi Perfil</a>
</asp:Content>

<asp:Content ID="Content3" ContentPlaceHolderID="cphContenido" runat="server">
    <h2 style="text-align: left; color: #000f;">Alumno - Reporte de Notas</h2>
    <link rel="stylesheet" href="Content/Fonts/EstiloCurso.css" />

    <div class="container-al">
        <div class="schedule">
            <asp:Label ID="myLabel" runat="server" Text="" Font-Size="Large" Font-Bold="True" CssClass="my-label"></asp:Label>
            <br><br>
            <asp:GridView ID="gvNotas" runat="server" AllowPaging="true" PageSize="12" AutoGenerateColumns="false" CssClass="table table-hover table-responsive table-striped" ShowHeaderWhenEmpty="true">
                <Columns>
                    <asp:BoundField HeaderText="Codigo" DataField="codigoCurso"/>
                    <asp:BoundField HeaderText="Curso" DataField="nombre"/>
                    <asp:BoundField HeaderText="Horas Semanales" DataField="horasPorSemana"/>
                </columns>
            </asp:GridView>
            <div style="display: flex; justify-content: flex-end;">
                <asp:Button ID="Competencias" runat="server" Text="Ver Competencias" CssClass="login-button" OnClick="Competencias_Click"/>
            </div>
        </div>
    </div>

</asp:Content>