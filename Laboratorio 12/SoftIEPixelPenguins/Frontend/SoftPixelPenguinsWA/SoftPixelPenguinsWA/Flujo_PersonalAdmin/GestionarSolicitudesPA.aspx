<%@ Page Title="" Language="C#" MasterPageFile="~/SoftPixelPenguins.Master" AutoEventWireup="true" CodeBehind="GestionarSolicitudesPA.aspx.cs" Inherits="SoftPixelPenguinsWA.GestionarSolicitudesPA" %>
<asp:Content ID="Content1" ContentPlaceHolderID="cphTitulo" runat="server">
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
    <a href="GestionarPlanesPA.aspx"><i class="fa-solid fa-list-check"></i>Gestionar Planes</a>
</asp:Content>
<asp:Content ContentPlaceHolderID="menuItem6" runat="server">
    <a href="MiPerfilPA.aspx"><i class="fa-solid fa-user"></i>Mi Perfil</a>
</asp:Content>
<asp:Content ContentPlaceHolderID="menuItem7" runat="server">
    <asp:Panel ID="panelGestionarUsuarios" runat="server" Visible="false" CssClass="ocularItem">
        <a href="GestionarUsuariosAdmin.aspx"><i class="fa-solid fa-plus-circle"></i>Gestionar Usuarios</a>
    </asp:Panel>
</asp:Content>

<asp:Content ID="Content3" ContentPlaceHolderID="cphContenido" runat="server">
    <h2 style="color: black;">Gestionar Solicitudes</h2>
    <div class="container-matricula" style="display: block;">
        <h2 style="color: black; padding-top:10px;">Listado de Alumnos</h2>
        <div class="row">
            <div class="col-12 d-flex justify-content-between align-items-center mb-4">
                <div class="input-group w-50">
                    <asp:TextBox ID="txtBuscarAlumno" runat="server" CssClass="form-control" placeholder="Buscar alumno..." aria-label="Buscar Alumno"></asp:TextBox>
                    <asp:LinkButton ID="lbBuscar" runat="server" CssClass="btn btn-outline-primary" OnClick="lbBuscar_Click">
                    <i class="fa-solid fa-search"></i> Buscar
                    </asp:LinkButton>
                </div>
                <div class="input-group w-25 ms-3">
                    <asp:DropDownList ID="ddlEstado" runat="server" CssClass="form-select" AutoPostBack="true" OnSelectedIndexChanged="ddlEstado_SelectedIndexChanged">
                    </asp:DropDownList>
                </div>
            </div>
        </div>
        <div class="row">
            <asp:GridView ID="gvAlumnos" runat="server" AllowPaging="true" PageSize="10" AutoGenerateColumns="false" CssClass="table table-hover table-responsive table-striped" ShowHeaderWhenEmpty="true" OnPageIndexChanging="gvAlumnos_PageIndexChanging">
                <Columns>
                    <asp:BoundField HeaderText="DNI" DataField="dni" />
                    <asp:BoundField HeaderText="Nombre" DataField="nombreCompleto" />
                    <asp:BoundField HeaderText="Email" DataField="email" />
                    <asp:TemplateField HeaderText="Estado">
                        <ItemTemplate>
                            <%# Eval("estado").ToString() %>
                        </ItemTemplate>
                    </asp:TemplateField>
                    <asp:TemplateField>
                        <ItemTemplate>
                            <div class="text-center">
                                <asp:LinkButton runat="server" CssClass="btn btn-sm btn-info me-1" Text="<i class='fa-solid fa-eye'></i> Ver" 
                                                OnClick="lbVisualizar_Click" CommandArgument='<%# Eval("idUsuario") %>' />
                                <asp:LinkButton runat="server" CssClass="btn btn-sm btn-danger" Text="<i class='fa-solid fa-trash'></i> Eliminar" 
                                                OnClick="lbEliminar_Click" CommandArgument='<%# Eval("idUsuario") %>' />
                            </div>
                        </ItemTemplate>
                    </asp:TemplateField>
                </columns>
            </asp:GridView>
        </div>
    </div>
 </asp:Content>




