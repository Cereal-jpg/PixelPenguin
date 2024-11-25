<%@ Page Title="" Language="C#" MasterPageFile="~/SoftPixelPenguins.Master" AutoEventWireup="true" CodeBehind="CursosYHorariosPA.aspx.cs" Inherits="SoftPixelPenguinsWA.CursosYHorariosPA" %>
<asp:Content ID="Content1" ContentPlaceHolderID="cphTitulo" runat="server">
    Cursos y Horarios - Personal Administrativo
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
    <h2 style="color: black;">Cursos y Horarios</h2>
    <div class="container-matricula" style="display:block;">
        <h2 style="color: black;">Listado de Profesores</h2>
        <div class="row">
            <div class="col-12 d-flex justify-content-between align-items-center mb-4">
                <div class="input-group w-50">
                    <asp:TextBox ID="txtBuscarProfesor" runat="server" CssClass="form-control" placeholder="Buscar profesor..." aria-label="Buscar Profesor"></asp:TextBox>
                    <asp:LinkButton ID="lbBuscar" runat="server" CssClass="btn btn-outline-primary" OnClick="lbBuscar_Click">
                    <i class="fa-solid fa-search"></i> Buscar
                    </asp:LinkButton>
                </div>
            </div>
        </div>
        <div class="row">
            <asp:GridView ID="gvProfesores" runat="server" AllowPaging="true" PageSize="10" OnPageIndexChanging="gvProfesores_PageIndexChanging" AutoGenerateColumns="False" CssClass="table table-hover table-responsive table-striped table-bordered" >
                <Columns>
                    <asp:BoundField DataField="codigoProfesor" HeaderText="Código" />
                    <asp:BoundField DataField="nombreCompleto" HeaderText="Nombre" />
                    <asp:BoundField DataField="especialidad" HeaderText="Especialidad" />
                    <asp:TemplateField>
                        <ItemTemplate>
                            <asp:LinkButton ID="btnAgregarCursos" runat="server" Text="Agregar Cursos" class="btn btn-primary" OnClick="btnAgregarCursos_Click" CommandArgument='<%# Eval("idUsuario") %>' />
                        </ItemTemplate>
                    </asp:TemplateField>
                </Columns>
            </asp:GridView>
        </div>
    </div>
</asp:Content>





