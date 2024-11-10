<%@ Page Title="" Language="C#" MasterPageFile="~/SoftPixelPenguins.Master" AutoEventWireup="true" CodeBehind="MisPagos.aspx.cs" Inherits="SoftPixelPenguinsWA.MisPagos" %>

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
    <a href="MiPerfilAlumno.aspx"><i class="fa-solid fa-user"></i>Mi Perfil</a>
</asp:Content>
<asp:Content ContentPlaceHolderID="menuItem6" runat="server">
    <a href="MiPerfilAlumno.aspx"><i class="fa-solid fa-book"></i>Mis Pagos</a>
</asp:Content>

<asp:Content ID="Content3" ContentPlaceHolderID="cphContenido" runat="server">
    <div class="d-flex justify-content-between align-items-center mt-3 mx-3">
        <h1>Visualizar Pagos</h1>
    </div>
    <hr class="mx-3" />
    <div class="container mt-5">
        <h2 style="color: black; padding-top: 10px;">Listado de Pago</h2>
        <div class="row">
            <asp:GridView ID="gvPagos" runat="server" AllowPaging="true" PageSize="10" AutoGenerateColumns="false"
                CssClass="table table-hover table-responsive table-striped text-center" ShowHeaderWhenEmpty="true">
                <columns>
                    <asp:BoundField HeaderText="ID_Pago" DataField="idPago">
                        <itemstyle horizontalalign="Center" />
                        <headerstyle horizontalalign="Center" />
                    </asp:BoundField>
                    <asp:BoundField HeaderText="Fecha de Creacion" DataField="fechaCreacion" DataFormatString="{0:yyyy-MM-dd}" HtmlEncode="false">
                        <itemstyle horizontalalign="Center" />
                        <headerstyle horizontalalign="Center" />
                    </asp:BoundField>
                    <asp:BoundField HeaderText="Fecha de Pago" DataField="fechaPago" DataFormatString="{0:yyyy-MM-dd}" HtmlEncode="false">
                        <itemstyle horizontalalign="Center" />
                        <headerstyle horizontalalign="Center" />
                    </asp:BoundField>
                    <asp:TemplateField HeaderText="Tipo de Comprobante">
                        <headerstyle horizontalalign="Center" />
                        <itemstyle horizontalalign="Center" />
                        <itemtemplate>
                            <%# Eval("tipoDeComprobante").ToString() %>
                        </itemtemplate>
                    </asp:TemplateField>
                    <asp:TemplateField HeaderText="Estado">
                        <headerstyle horizontalalign="Center" />
                        <itemstyle horizontalalign="Center" />
                        <itemtemplate>
                            <%# Eval("estado").ToString() %>
                        </itemtemplate>
                    </asp:TemplateField>
                    <asp:TemplateField>
                        <itemstyle horizontalalign="Center" />
                        <headerstyle horizontalalign="Center" />
                        <itemtemplate>
                            <div class="text-center">
                                <asp:LinkButton runat="server" CssClass="btn btn-sm btn-info me-1" Text="<i class='fa-solid fa-eye'></i> Ver"
                                    OnClick="lbVisualizar_Click" CommandArgument='<%# Eval("idPago") %>' />
                            </div>
                        </itemtemplate>
                    </asp:TemplateField>
                </columns>
            </asp:GridView>

        </div>
    </div>
</asp:Content>



