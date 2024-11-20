<%@ Page Title="" Language="C#" MasterPageFile="~/SoftPixelPenguins.Master" AutoEventWireup="true" CodeBehind="EditarPago.aspx.cs" Inherits="SoftPixelPenguinsWA.Flujo_PersonalAdmin.EditarPago" %>

<asp:Content ID="Content1" ContentPlaceHolderID="cphTitulo" runat="server">
    Gestionar Pagos - Personal Admin
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="cphScripts" runat="server">
    <link rel="stylesheet" href="../Content/Estilos-Pagos.css" />
</asp:Content>

<asp:Content ContentPlaceHolderID="menuItem1" runat="server">
    <a href="IndexPersonalAdministrativo.aspx"><i class="fa-solid fa-home"></i>Inicio</a>
</asp:Content>
<asp:Content ContentPlaceHolderID="menuItem2" runat="server">
    <a href="ReportesPA.aspx"><i class="fa-solid fa-book"></i>Reportes</a>
</asp:Content>
<asp:Content ContentPlaceHolderID="menuItem3" runat="server">
    <a href="CursosYHorariosPA.aspx"><i class="fa-solid fa-calendar-days"></i>Cursos y Horarios</a>
</asp:Content>
<asp:Content ContentPlaceHolderID="menuItem4" runat="server">
    <a href="GestionarSolicitudesPA.aspx"><i class="fa-solid fa-user-plus"></i>Gestionar Solicitudes</a>
</asp:Content>
<asp:Content ContentPlaceHolderID="menuItem5" runat="server">
    <a href="GestionarPagosPA.aspx"><i class="fa-solid fa-money-bill"></i>Gestionar Pagos</a>
</asp:Content>
<asp:Content ContentPlaceHolderID="menuItem6" runat="server">
    <a href="GestionarPlanesPA.aspx"><i class="fa-solid fa-list-check"></i>Gestionar Planes</a>
</asp:Content>
<asp:Content ContentPlaceHolderID="menuItem7" runat="server">
    <a href="MiPerfilPA.aspx"><i class="fa-solid fa-user"></i>Mi Perfil</a>
</asp:Content>
<asp:Content ContentPlaceHolderID="menuItem8" runat="server">
    <asp:Panel ID="panelGestionarUsuarios" runat="server" Visible="false" CssClass="ocularItem">
        <a href="GestionarUsuariosAdmin.aspx"><i class="fa-solid fa-plus-circle"></i>Gestionar Usuarios</a>
    </asp:Panel>
</asp:Content>
<asp:Content ID="Content3" ContentPlaceHolderID="cphContenido" runat="server">
    <h2 style="text-align: left; color: #000f;">Editar Estado del Pago</h2>
    <div class="form-container">
        <asp:Label ID="lblMensaje" runat="server" Text="" CssClass="alert" Visible="false"></asp:Label>
        
        <div>
            <asp:Label ID="lblIdPago" runat="server" Text="ID Pago:" AssociatedControlID="txtIdPago"></asp:Label>
            <asp:TextBox ID="txtIdPago" runat="server" ReadOnly="true" CssClass="form-control"></asp:TextBox>
        </div>
        
        <div>
            <asp:Label ID="lblNombreAlumno" runat="server" Text="Nombre Alumno:" AssociatedControlID="txtNombreAlumno"></asp:Label>
            <asp:TextBox ID="txtNombreAlumno" runat="server" ReadOnly="true" CssClass="form-control"></asp:TextBox>
        </div>
        
        <div>
            <asp:Label ID="lblMonto" runat="server" Text="Monto:" AssociatedControlID="txtMonto"></asp:Label>
            <asp:TextBox ID="txtMonto" runat="server" ReadOnly="true" CssClass="form-control"></asp:TextBox>
        </div>
        
        <div>
            <asp:Label ID="lblFecha" runat="server" Text="Fecha:" AssociatedControlID="txtFecha"></asp:Label>
            <asp:TextBox ID="txtFecha" runat="server" ReadOnly="true" CssClass="form-control"></asp:TextBox>
        </div>
        
        <div>
            <asp:Label ID="lblEstado" runat="server" Text="Estado de Pago:" AssociatedControlID="ddlEstado"></asp:Label>
            <asp:DropDownList ID="ddlEstado" runat="server" CssClass="form-control">
                <asp:ListItem Text="Pendiente" Value="PENDIENTE"></asp:ListItem>
                <asp:ListItem Text="Cancelado" Value="CANCELADO"></asp:ListItem>
                <asp:ListItem Text="Atrasado" Value="ATRASADO"></asp:ListItem>
            </asp:DropDownList>
        </div>
        
        <div>
            <label>Comprobante del pago: </label>
            <asp:LinkButton ID="lnkDescargarComprobante" runat="server" CssClass="btn btn-info me-2" OnClick="lnkDescargarComprobante_Click">
                Descargar Comprobante del pago
            </asp:LinkButton>
        </div>
        
        <div class="btn-container">
            <asp:Button ID="btnGuardar" runat="server" Text="Guardar" CssClass="btn btn-primary" OnClick="btnGuardar_Click" />
            <asp:Button ID="btnCancelar" runat="server" Text="Cancelar" CssClass="btn btn-secondary" OnClick="btnCancelar_Click" />
        </div>
    </div>
</asp:Content>

