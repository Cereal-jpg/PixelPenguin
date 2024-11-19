<%@ Page Title="" Language="C#" MasterPageFile="~/SoftPixelPenguins.Master" AutoEventWireup="true" CodeBehind="MisPagosAlumno.aspx.cs" Inherits="SoftPixelPenguinsWA.MisPagos" %>

<asp:Content ID="Content1" ContentPlaceHolderID="cphTitulo" runat="server">
    Home - Alumno
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="cphScripts" runat="server">
</asp:Content>

<asp:Content ContentPlaceHolderID="menuItem1" runat="server">
    <a href="IndexAlumno.aspx"><i class="fa-solid fa-home"></i>Inicio</a>
</asp:Content>
<asp:Content ContentPlaceHolderID="menuItem2" runat="server">
    <a href="MisCursosAlumno.aspx"><i class="fa-solid fa-book"></i>Mis cursos</a>
</asp:Content>
<asp:Content ContentPlaceHolderID="menuItem3" runat="server">
    <a href="ReporteNotasAlumno.aspx"><i class="fa-solid fa-bar-chart"></i>Reporte de Notas</a>
</asp:Content>
<asp:Content ContentPlaceHolderID="menuItem4" runat="server">
    <a href="MatriculaOnlineAlumno.aspx"><i class="fa-solid fa-archive"></i>Matrícula Online</a>
</asp:Content>
<asp:Content ContentPlaceHolderID="menuItem5" runat="server">
    <a href="MisPagosAlumno.aspx"><i class="fa-solid fa-book"></i>Mis Pagos</a>
</asp:Content>
<asp:Content ContentPlaceHolderID="menuItem6" runat="server">
    <a href="MiPerfilAlumno.aspx"><i class="fa-solid fa-user"></i>Mi Perfil</a>
</asp:Content>


<asp:Content ID="Content3" ContentPlaceHolderID="cphContenido" runat="server">

    <h2 style="text-align: left; color: #000f;">Visualizar Pagos</h2>
    <link rel="stylesheet" href="../Content/Estilos-Alumno.css" />
    <div class="container-al">

        <div class="container-matricula" style="display: block;">
            <h2 style="color: black; padding-top: 10px;">Listado de Pago</h2>
            <div class="row">
               <asp:GridView ID="gvPagos" runat="server" AllowPaging="true" PageSize="10" AutoGenerateColumns="false"
    CssClass="table table-hover table-responsive table-striped text-center" ShowHeaderWhenEmpty="true">
    <Columns>
        <asp:BoundField HeaderText="ID_Pago" DataField="idPago">
            <ItemStyle HorizontalAlign="Center" />
            <HeaderStyle HorizontalAlign="Center" />
        </asp:BoundField>
        <asp:BoundField HeaderText="Fecha de Creacion" DataField="fechaCreacion" DataFormatString="{0:yyyy-MM-dd}" HtmlEncode="false">
            <ItemStyle HorizontalAlign="Center" />
            <HeaderStyle HorizontalAlign="Center" />
        </asp:BoundField>
        <asp:BoundField HeaderText="Fecha de Pago" DataField="fechaPago" DataFormatString="{0:yyyy-MM-dd}" HtmlEncode="false">
            <ItemStyle HorizontalAlign="Center" />
            <HeaderStyle HorizontalAlign="Center" />
        </asp:BoundField>
        <asp:TemplateField HeaderText="Estado">
            <HeaderStyle HorizontalAlign="Center" />
            <ItemStyle HorizontalAlign="Center" />
            <ItemTemplate>
                <%# Eval("estado").ToString() %>
            </ItemTemplate>
        </asp:TemplateField>
        <asp:TemplateField HeaderText="Acciones">
            <HeaderStyle HorizontalAlign="Center" />
            <ItemStyle HorizontalAlign="Center" />
            <ItemTemplate>
                <div class="text-center">
                    <asp:LinkButton runat="server" CssClass="btn btn-sm btn-info me-1" Text="<i class='fa-solid fa-eye'></i> Ver"
                        OnClick="lbVisualizar_Click" CommandArgument='<%# Eval("idPago") %>'></asp:LinkButton>
                    <asp:LinkButton ID="lnkEdit" runat="server"
                        CommandArgument='<%# Eval("idPago") %>'
                        CssClass="btn btn-warning btn-sm me-1"
                        OnClick="lbEditar_Click"
                        Enabled='<%# Eval("estado").ToString() == "PENDIENTE" %>'>
                        <i class="fa-solid fa-pen-to-square"></i> Subir Baucher
                    </asp:LinkButton>
                </div>
            </ItemTemplate>
        </asp:TemplateField>
    </Columns>
               </asp:GridView>


            </div>
        </div>

    </div>

</asp:Content>



