<%@ Page Title="" Language="C#" MasterPageFile="~/SoftPixelPenguins.Master" AutoEventWireup="true" CodeBehind="IndexProfesor.aspx.cs" Inherits="SoftPixelPenguinsWA.IndexProfesor" %>
<asp:Content ID="Content1" ContentPlaceHolderID="cphTitulo" runat="server">
    Home - Profesor
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="cphScripts" runat="server">
</asp:Content>
<asp:Content ContentPlaceHolderID="menuItem1" runat="server">
    <a href="Index.aspx"><i class="fa-solid fa-home"></i>Pagina principal</a>
</asp:Content>
<asp:Content ContentPlaceHolderID="menuItem2" runat="server">
    <a href="ListarCursosAlumno.aspx"><i class="fa-solid fa-book"></i>Cursos</a>
</asp:Content>
<asp:Content ContentPlaceHolderID="menuItem3" runat="server">
    <a href="ListarCursosAlumno.aspx"><i class="fa-solid fa-bar-chart"></i>Registros</a>
</asp:Content>
<asp:Content ContentPlaceHolderID="menuItem4" runat="server">
    <a href="ListarCursosAlumno.aspx"><i class="fa-solid fa-archive"></i>Personal</a>
<asp:Content ID="Content3" ContentPlaceHolderID="cphContenido" runat="server">
    <h2 style="text-align: left; color: #000f;">Página principal profesor</h2>
    <link rel="stylesheet" href="Content/Estilos-Alumno.css" />
    <div class="container-al">
        <div class="schedule">
            <h3>Horario del Profesor</h3>
            <img src="Images/Horario.jpg" alt="Horario Académico" />
        </div>
        <div class="notifications">
            <h3>Notificaciones</h3>
            <ul class="notification-list">
                <li>Próxima fecha de pago: </li>
                <li>Estado de pagos: </li>
                <li>Entrega de trabajos hasta el jueves.</li>
                <li>Examen de matemáticas programado para el lunes.</li>
            </ul>
        </div>
    </div>
</asp:Content>