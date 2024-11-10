<%@ Page Title="" Language="C#" MasterPageFile="~/SoftPixelPenguins.Master" AutoEventWireup="true" CodeBehind="IndexAdmin.aspx.cs" Inherits="SoftPixelPenguinsWA.IndexAdmin" %>
<asp:Content ID="Content1" ContentPlaceHolderID="cphTitulo" runat="server">
    Home - Administrador
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="cphScripts" runat="server">
</asp:Content>
<asp:Content ContentPlaceHolderID="menuItem1" runat="server">
    <a href="IndexAdmin.aspx"><i class="fa-solid fa-home"></i>Inicio</a>
</asp:Content>
<asp:Content ContentPlaceHolderID="menuItem2" runat="server">
    <a href="ReportesAdmin.aspx"><i class="fa-solid fa-book"></i>Reportes</a>
</asp:Content>
<asp:Content ContentPlaceHolderID="menuItem3" runat="server">
    <a href="BusquedaAdmin.aspx"><i class="fa-solid fa-search"></i>Busqueda</a>
</asp:Content>
<asp:Content ContentPlaceHolderID="menuItem4" runat="server">
    <a href="AgregarPlanAdmin.aspx"><i class="fa-solid fa-folder-plus"></i>Agregar Plan</a>
</asp:Content>
<asp:Content ContentPlaceHolderID="menuItem5" runat="server">
    <a href="GestionarUsuariosAdmin.aspx"><i class="fa-solid fa-users"></i>Gestionar Usuarios</a>
</asp:Content>
<asp:Content ContentPlaceHolderID="menuItem6" runat="server">
    <a href="GestionarSolicitudesAdmin.aspx"><i class="fa-solid fa-user-plus"></i>Gestionar Solicitudes</a>
</asp:Content>
<asp:Content ContentPlaceHolderID="menuItem7" runat="server">
    <a href="MiPerfilAdmin.aspx"><i class="fa-solid fa-user"></i>Mi Perfil</a>
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
