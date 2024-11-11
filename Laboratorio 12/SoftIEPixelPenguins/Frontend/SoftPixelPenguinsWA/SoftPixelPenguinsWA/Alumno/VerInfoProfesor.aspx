<%@ Page Title="" Language="C#" MasterPageFile="~/SoftPixelPenguins.Master" AutoEventWireup="true" CodeBehind="VerInfoProfesor.aspx.cs" Inherits="SoftPixelPenguinsWA.VerInfoProfesor" %>
<asp:Content ID="Content1" ContentPlaceHolderID="cphTitulo" runat="server">
    Detalle del profesor asignado
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="cphScripts" runat="server">
</asp:Content>

<asp:Content ContentPlaceHolderID="menuItem1" runat="server">
    <a href="IndexAlumno.aspx"><i class="fa-solid fa-home"></i> Inicio</a>
</asp:Content>
<asp:Content ContentPlaceHolderID="menuItem2" runat="server">
    <a href="MisCursosAlumno.aspx"><i class="fa-solid fa-book"></i> Mis cursos</a>
</asp:Content>
<asp:Content ContentPlaceHolderID="menuItem3" runat="server">
    <a href="ReporteNotasAlumno.aspx"><i class="fa-solid fa-bar-chart"></i> Reporte de Notas</a>
</asp:Content>
<asp:Content ContentPlaceHolderID="menuItem4" runat="server">
    <a href="MatriculaOnlineAlumno.aspx"><i class="fa-solid fa-archive"></i> Matrícula Online</a>
</asp:Content>
<asp:Content ContentPlaceHolderID="menuItem5" runat="server">
    <a href="MisPagos.aspx"><i class="fa-solid fa-book"></i>Mis Pagos</a>
</asp:Content>
<asp:Content ContentPlaceHolderID="menuItem6" runat="server">
    <a href="MiPerfilAlumno.aspx"><i class="fa-solid fa-user"></i> Mi Perfil</a>
</asp:Content>

<asp:Content ID="Content3" ContentPlaceHolderID="cphContenido" runat="server">
    <h2 id="hTitulo" style="color: black;" runat="server"></h2>
    <div>
        <asp:Button ID="btnRegresar" runat="server" Text="Regresar" OnClick="btnRegresar_Click" CssClass="btn btn-primary" />
    </div>
</asp:Content>
