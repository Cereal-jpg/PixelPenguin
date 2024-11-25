<%@ Page Title="" Language="C#" MasterPageFile="~/SoftPixelPenguins.Master" AutoEventWireup="true" CodeBehind="AgregarPagoPA.aspx.cs" Inherits="SoftPixelPenguinsWA.Flujo_PersonalAdmin.AgregarPagoPA" %>

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
    <h2 style="text-align: left; color: #000f;">Agregar Pago</h2>
    

    <div id="section1" class="section" runat="server" style="display: block;">

        <div class="container-matricula" style="display:block;">
        
            <h2 style="color: black;">Agregar Pago</h2>

            <div class="form-group">

                <div class="form-row">
                    <label>ID Matricula del Pago: </label>
                    <asp:TextBox ID="txtMatri" runat="server" placeholder="Matricula" required="required" CssClass="form-control dni-field"></asp:TextBox>
                </div>

                <div class="form-row">
                    <label>Monto del Pago:</label>
                    <asp:TextBox ID="txtMonto" runat="server" placeholder="Monto" required="required" CssClass="form-control dni-field"></asp:TextBox>
                </div>
                <div class="form-row">
                    <label for="ddlTipo">Tipo de Pago:</label>
                        <asp:DropDownList ID="ddlTipo" runat="server" CssClass="form-control custom-dropdown" required="required">
                            <asp:ListItem Text="Seleccionar" Value="" />
                            <asp:ListItem Text="Transferencia Bancaria" Value="Transferencia Bancaria" />
                        </asp:DropDownList>
                </div>
                <div class="form-row">
                    <label>Fecha de Creación:</label>
                    <asp:TextBox ID="dtpFechaCreacion" runat="server" placeholder="Fecha de Creacion" CssClass="date-picker form-control" TextMode="Date" required="required"></asp:TextBox>
                </div>
            </div>

            <div class="button-group">
                <asp:Button ID="btnRegresar" runat="server" Text="Regresar" OnClick="btnRegresar_Click" CssClass="button-style" />
                <asp:Button ID="btnGuardar" runat="server" Text="Grabar y Continuar" OnClick="btnGuardar_Click" CssClass="button-style" />
            </div>

        </div>
    </div>

</asp:Content>
