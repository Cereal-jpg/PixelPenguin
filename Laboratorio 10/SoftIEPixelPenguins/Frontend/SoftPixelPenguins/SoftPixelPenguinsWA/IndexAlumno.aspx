<%@ Page Title="" Language="C#" MasterPageFile="~/SoftPixelPenguins.Master" AutoEventWireup="true" CodeBehind="IndexAlumno.aspx.cs" Inherits="SoftPixelPenguinsWA.IndexAlumno" %>
<asp:Content ID="Content1" ContentPlaceHolderID="cphTitulo" runat="server">
    Home - Alumno
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
    <a href="ReporteNotasAlumno.aspx"><i class="fa-solid fa-bar-chart"></i>Reporte de Notas</a>
</asp:Content>
<asp:Content ContentPlaceHolderID="menuItem4" runat="server">
    <a href="MatriculaAlumno-0.aspx"><i class="fa-solid fa-archive"></i>Matrícula Online</a>
</asp:Content>
<asp:Content ContentPlaceHolderID="menuItem5" runat="server">
    <a href="PerfilAlumno.aspx"><i class="fa-solid fa-user"></i>Mi Perfil</a>
</asp:Content>
<asp:Content ID="Content3" ContentPlaceHolderID="cphContenido" runat="server">
    <h2 style="text-align: left; color: #000f;">Alumno - Inicio</h2>
    <link rel="stylesheet" href="Content/Estilos-Alumno.css" />
    <div class="container-al">
        <div class="schedule">
            <h3>Horario Académico</h3>
            <img src="Images/HORARIO1.png" alt="Horario Académico" class="centered-image"/>
        </div>
        <div class="notifications">
            <h3>Notificaciones</h3>
            <ul id="notificationList" class="notification-list" runat="server">
                <li>Próxima fecha de pago: <asp:Literal ID="fechaPagoLiteral" runat="server"></asp:Literal></li>
                <li>Estado de pagos: <asp:Literal ID="Estado" runat="server"></asp:Literal></li>
                <li>Entrega de trabajos hasta el jueves.</li>
                <li>Examen de matemáticas programado para el lunes.</li>
            </ul>
        </div>
    </div>
</asp:Content>
