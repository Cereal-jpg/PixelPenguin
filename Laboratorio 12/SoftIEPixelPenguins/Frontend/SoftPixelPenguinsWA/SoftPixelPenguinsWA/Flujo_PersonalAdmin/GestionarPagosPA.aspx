<%@ Page Language="C#" AutoEventWireup="true" MasterPageFile="~/SoftPixelPenguins.Master" CodeBehind="GestionarPagosPA.aspx.cs" Inherits="SoftPixelPenguinsWA.Flujo_PersonalAdmin.GestionarPagosPA" %>

<asp:Content ID="Content1" ContentPlaceHolderID="cphTitulo" runat="server">
    Gestionar Pagos - Personal Administrativo
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
    <h2 style="text-align: left; color: #000f;">Personal Administrativo - Gestionar Pagos</h2>
    <div class="container-pagos">
        <asp:GridView
            ID="gvPagos"
            runat="server"
            AutoGenerateColumns="false"
            CssClass="table table-full-width table-striped table-bordered table-center">
            <Columns>
                <asp:BoundField DataField="IdPago" HeaderText="ID Pago" Visible="false" />
                <asp:BoundField
                    DataField="NombreAlumno"
                    HeaderText="Nombre Alumno"
                    ItemStyle-CssClass="text-left"
                    HeaderStyle-CssClass="text-center" />
                <asp:BoundField
                    DataField="Monto"
                    HeaderText="Monto"
                    DataFormatString="{0:C}"
                    ItemStyle-CssClass="text-right"
                    HeaderStyle-CssClass="text-center" />
                <asp:BoundField
                    DataField="Fecha"
                    HeaderText="Fecha"
                    DataFormatString="{0:dd/MM/yyyy}"
                    ItemStyle-CssClass="text-center"
                    HeaderStyle-CssClass="text-center" />
                <asp:TemplateField HeaderText="Estado">
                    <HeaderStyle CssClass="text-center" />
                    <ItemTemplate>
                        <div class="text-center">
                            <%# MostrarEstado(Eval("Estado").ToString()) %>
                        </div>
                    </ItemTemplate>
                </asp:TemplateField>
                <asp:TemplateField HeaderText="Acciones">
                    <HeaderStyle CssClass="text-center" />
                    <ItemTemplate>
                        <div class="text-center">
                            <asp:LinkButton
                                runat="server"
                                CssClass="btn btn-sm btn-info me-1"
                                Text="<i class='fa-solid fa-pen'></i> Editar"
                                OnClick="lbEditar_Click"
                                CommandArgument='<%# Eval("IdPago") %>'>
                            </asp:LinkButton>
                        </div>
                    </ItemTemplate>
                </asp:TemplateField>
            </Columns>
        </asp:GridView>
    </div>
    <div class="btn-container">
        <asp:Button
            ID="btnAgregarPago"
            runat="server"
            Text="Agregar Nuevo Pago"
            CssClass="btn btn-success btn-small"
            OnClick="AgregarPago" />
    </div>  
</asp:Content>
