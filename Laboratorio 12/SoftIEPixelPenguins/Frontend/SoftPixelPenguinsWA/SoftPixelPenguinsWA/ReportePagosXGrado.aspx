<%@ Page Title="" Language="C#" MasterPageFile="~/SoftPixelPenguins.Master" AutoEventWireup="true" CodeBehind="ReportePagosXGrado.aspx.cs" Inherits="SoftPixelPenguinsWA.ReportePagosXGrado" %>
<asp:Content ID="Content1" ContentPlaceHolderID="cphTitulo" runat="server">
    Reporte - Administrador
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
    <div class="d-flex justify-content-between align-items-center mt-3 mx-3">
        <h1>Reportes de pagos por grado</h1>
    </div>
    <hr class="mx-3" />
    <div class="container mt-5">
        <h2 style="color: black; padding-top: 10px;">Listado de grados</h2>
        <div class="row">
            <asp:GridView ID="gvGrados" runat="server" AllowPaging="true" PageSize="10" AutoGenerateColumns="false"
                CssClass="table table-hover table-responsive table-striped text-center" ShowHeaderWhenEmpty="true"
                OnPageIndexChanging="gvGrados_PageIndexChanging">
                <Columns>
                    <asp:TemplateField HeaderText="Grado Academico">
                        <HeaderStyle HorizontalAlign="Center" />
                        <ItemStyle HorizontalAlign="Left" />
                        <ItemTemplate>
                            <%# Eval("numeroGrado") + "° de " + Eval("nivel").ToString().ToLower() %>
                        </ItemTemplate>
                    </asp:TemplateField>
                    <asp:BoundField HeaderText="Vacantes" DataField="vacantes">
                        <ItemStyle HorizontalAlign="Center" />
                        <HeaderStyle HorizontalAlign="Center" />
                    </asp:BoundField>
                    <asp:BoundField HeaderText="Cantidad de alumnos" DataField="cantidadAlumnos">
                        <ItemStyle HorizontalAlign="Center" />
                        <HeaderStyle HorizontalAlign="Center" />
                    </asp:BoundField>
                    <asp:TemplateField>
                        <ItemStyle HorizontalAlign="Center" />
                        <HeaderStyle HorizontalAlign="Center" />
                        <ItemTemplate>
                            <div class="text-center">
                                <asp:LinkButton runat="server" CssClass="btn btn-sm btn-info me-1" Text="<i class='fa-solid fa-eye'></i> Generar"
                                    OnClick="lbGenerar_Click" CommandArgument='<%# Eval("idGradoAcademico") %>' />
                            </div>
                        </ItemTemplate>
                    </asp:TemplateField>
                </Columns>

            </asp:GridView>
        </div>
    </div>

</asp:Content>
