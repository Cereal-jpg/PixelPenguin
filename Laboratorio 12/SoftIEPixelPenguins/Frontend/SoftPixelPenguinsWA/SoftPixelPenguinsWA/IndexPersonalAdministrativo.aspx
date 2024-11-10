<%@ Page Title="" Language="C#" MasterPageFile="~/SoftPixelPenguins.Master" AutoEventWireup="true" CodeBehind="IndexPersonalAdministrativo.aspx.cs" Inherits="SoftPixelPenguinsWA.IndexPersonalAdministrativo" %>
<asp:Content ID="Content1" ContentPlaceHolderID="cphTitulo" runat="server">
    Home - Personal Administrador
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
    <a href="AgregarPlanPA.aspx"><i class="fa-solid fa-plus-circle"></i>Agregar Plan</a>
</asp:Content>
<asp:Content ContentPlaceHolderID="menuItem5" runat="server">
    <a href="GestionarSolicitudesPA.aspx"><i class="fa-solid fa-user-plus"></i>Gestionar Solicitudes</a>
</asp:Content>
<asp:Content ContentPlaceHolderID="menuItem6" runat="server">
    <a href="MiPerfilPA.aspx"><i class="fa-solid fa-user"></i>Mi Perfil</a>
</asp:Content>

<asp:Content ID="Content3" ContentPlaceHolderID="cphContenido" runat="server">
    <h2 style="text-align: left; color: #000f;">Página principal Equipo Administrativo</h2>
    <link rel="stylesheet" href="Content/Estilos-Alumno.css" />
    <div class="container-al">
        <div class="schedule">
            <h3>Estadísticas</h3>
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
