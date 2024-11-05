<%@ Page Title="Gestión de Solicitudes" Language="C#" MasterPageFile="~/SoftPixelPenguins.Master" AutoEventWireup="true" CodeBehind="GestionarSolicitudes.aspx.cs" Inherits="SoftPixelPenguinsWA.GestionarSolicitudes" %>

<asp:Content ID="Content1" ContentPlaceHolderID="cphTitulo" runat="server">
    Gestión de Usuarios
</asp:Content>
<asp:Content ID="Content4" ContentPlaceHolderID="cphScripts" runat="server">
</asp:Content>
<asp:Content ContentPlaceHolderID="menuItem1" runat="server">
    <a href="Index.aspx"><i class="fa-solid fa-home"></i>Pagina principal</a>
</asp:Content>
<asp:Content ContentPlaceHolderID="menuItem2" runat="server">
    <a href="Reportes.aspx"><i class="fa-solid fa-book"></i>Reportes</a>
</asp:Content>
<asp:Content ContentPlaceHolderID="menuItem3" runat="server">
    <a href="ListarCursosAlumno.aspx"><i class="fa-solid fa-search"></i>Busquedas</a>
</asp:Content>
<asp:Content ContentPlaceHolderID="menuItem4" runat="server">
    <a href="GestionarSolicitudes.aspx"><i class="fa-solid fa-plus-circle"></i>Gestionar Solicitudes</a>
</asp:Content>

<asp:Content ID="Content2" ContentPlaceHolderID="cphContenido" runat="server">
    <div class="d-flex justify-content-between align-items-center mt-3 mx-3">
        <h1>Gestionar Solicitudes</h1>
    </div>
    <hr class="mx-3" />
    <div class="container mt-5">
        <h2 style="color: black; padding-top:10px;">Listado de Alumnos</h2>
        <div class="row">
            <div class="col-12 d-flex justify-content-between align-items-center mb-4 pt-3">
                <div class="input-group w-50">
                    <asp:TextBox ID="txtBuscarUsuario" runat="server" CssClass="form-control" placeholder="Buscar alumno..." aria-label="Buscar Alumno"></asp:TextBox>
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
            <asp:GridView ID="gvAlumnos" runat="server" AllowPaging="true" PageSize="10" AutoGenerateColumns="false" CssClass="table table-hover table-responsive table-striped" ShowHeaderWhenEmpty="true">
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