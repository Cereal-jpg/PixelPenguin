<%@ Page Title="" Language="C#" MasterPageFile="~/SoftPixelPenguins.Master" AutoEventWireup="true" CodeBehind="CopiaReporteXPagos.aspx.cs" Inherits="SoftPixelPenguinsWA.Flujo_PersonalAdmin.WebForm1" %>
<asp:Content ID="Content1" ContentPlaceHolderID="cphTitulo" runat="server">
    Inicio - Personal Admin
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
    <a href="BusquedaPA.aspx"><i class="fa-solid fa-search"></i>Busqueda</a>
</asp:Content>
<asp:Content ContentPlaceHolderID="menuItem4" runat="server">
    <a href="CursosYHorariosPA.aspx"><i class="fa-solid fa-calendar-days"></i>Cursos y Horarios</a>
</asp:Content>
<asp:Content ContentPlaceHolderID="menuItem5" runat="server">
    <a href="GestionarSolicitudesPA.aspx"><i class="fa-solid fa-user-plus"></i>Gestionar Solicitudes</a>
</asp:Content>
<asp:Content ContentPlaceHolderID="menuItem6" runat="server">
    <a href="GestionarPlanesPA.aspx"><i class="fa-solid fa-list-check"></i>Gestionar Planes</a>
</asp:Content>
<asp:Content ContentPlaceHolderID="menuItem7" runat="server">
    <a href="MiPerfilPA.aspx"><i class="fa-solid fa-user"></i>Mi Perfil</a>
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
