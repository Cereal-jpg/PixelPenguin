<%@ Page Title="" Language="C#" MasterPageFile="~/SoftPixelPenguins.Master" AutoEventWireup="true" CodeBehind="GestionarPlanesPA.aspx.cs" Inherits="SoftPixelPenguinsWA.GestionarPlanesPA" %>
<asp:Content ID="Content1" ContentPlaceHolderID="cphTitulo" runat="server">
    Gestionar Planes - Personal Administrativo
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
    <h2 style="color: black;">Gestionar Planes Académicos</h2>
    <div class="container-matricula" style="display:block;">
        <div class="d-flex align-items-center justify-content-between mb-3" style="padding: 5px; border-bottom: 2px solid #000;">
            <h2 class="mb-0" style="color: black; border-bottom: none; padding-bottom: 0px;">Listado de Cursos</h2>
            <div class="d-flex align-items-center" style="flex-grow: 1; justify-content: flex-end;">
                <div style="flex-shrink: 0;">
                    <asp:DropDownList ID="ddlGrados" runat="server" CssClass="form-select me-2" style="width: 200px;" AutoPostBack="true">
                    </asp:DropDownList>
                </div>
                <div style="flex-shrink: 0;">
                    <asp:LinkButton ID="lnkAgregarCurso" runat="server" CssClass="btn btn-primary" OnClick="lnkAgregarCurso_Click">
                        <i class="fa-solid fa-plus"></i> Agregar Curso
                    </asp:LinkButton>
                </div>
            </div>
        </div>
        <asp:GridView ID="gvCursos" runat="server" AutoGenerateColumns="False" CssClass="table table-hover table-responsive table-striped table-bordered">
            <Columns>
                <asp:BoundField DataField="codigoCurso" HeaderText="Código" />
                <asp:BoundField DataField="nombre" HeaderText="Nombre" />
                <asp:BoundField DataField="horasPorSemana" HeaderText="Horas Semanales" />
                <asp:BoundField DataField="horasTotales" HeaderText="Horas Totales" />
                <asp:TemplateField HeaderText="Acciones">
                    <ItemTemplate>
                        <asp:LinkButton ID="lnkEdit" runat="server" 
                            CommandArgument='<%# Eval("idCurso") %>' 
                            CssClass="btn btn-warning btn-sm me-1" 
                            OnClick="lbEditar_Click">
                            <i class="fa-solid fa-pen-to-square"></i> Editar
                        </asp:LinkButton>
                        <asp:LinkButton ID="lnkDelete" runat="server" 
                            CommandArgument='<%# Eval("idCurso") %>' 
                            CssClass="btn btn-danger btn-sm" 
                            OnClick="lbEliminar_Click">
                            <i class="fa-solid fa-trash"></i> Eliminar
                        </asp:LinkButton>
                    </ItemTemplate>
                </asp:TemplateField>
            </Columns>
        </asp:GridView>
    </div>
</asp:Content>