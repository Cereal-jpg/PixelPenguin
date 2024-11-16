<%@ Page Title="" Language="C#" MasterPageFile="~/SoftPixelPenguins.Master" AutoEventWireup="true" CodeBehind="IndexUserGenerico.aspx.cs" Inherits="SoftPixelPenguinsWA.Flujo_Generico.IndexUserGenerico" %>

<asp:Content ID="Content1" ContentPlaceHolderID="cphTitulo" runat="server">
    Inicio
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="cphScripts" runat="server">
</asp:Content>

<asp:Content ContentPlaceHolderID="menuItem1" runat="server">
    <a href="IndexUserGenerico.aspx"><i class="fa-solid fa-home"></i> Inicio</a>
</asp:Content>
<asp:Content ContentPlaceHolderID="menuItem2" runat="server">
    <a href="MatriculaOnlineUserGenerico.aspx"><i class="fa-solid fa-archive"></i> Matrícula Online</a>
</asp:Content>
<asp:Content ContentPlaceHolderID="menuItem3" runat="server">
    <a href="MiPerfilAlumno.aspx"><i class="fa-solid fa-user"></i> Mi Perfil</a>
</asp:Content>

<asp:Content ID="Content3" ContentPlaceHolderID="cphContenido" runat="server">
    <h2 style="text-align: left; color: #000f;">Inicio</h2>
    <link rel="stylesheet" href="../Content/Estilos-Alumno.css" />
    <div class="container-al">
        <div class="schedule">
            <h2 id="hTitulo" style="color: black;" runat="server"></h2>
            <img src="../Images/Colegio.png" alt="Horario Académico" class="centered-image"/>
        </div>

        <div class="notifications">
            <h3>Notificaciones</h3>
            <ul id="notificationList" class="notification-list" runat="server">
                <li>Próxima fecha de pago: <asp:Literal ID="fechaPagoLiteral" runat="server"></asp:Literal></li>
                <li>Estado de pagos: <asp:Literal ID="Estado" runat="server"></asp:Literal></li>
            </ul>
        </div>
    </div>
</asp:Content>