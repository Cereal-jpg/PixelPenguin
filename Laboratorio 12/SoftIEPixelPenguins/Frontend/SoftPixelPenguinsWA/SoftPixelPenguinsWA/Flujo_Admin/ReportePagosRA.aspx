﻿<%@ Page Title="" Language="C#" MasterPageFile="~/SoftPixelPenguins.Master" AutoEventWireup="true" CodeBehind="ReportePagosRA.aspx.cs" Inherits="SoftPixelPenguinsWA.ReportePagosRA" %>

<asp:Content ID="Content1" ContentPlaceHolderID="cphTitulo" runat="server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="cphScripts" runat="server">
    <link rel="stylesheet" href="../Content/grafico_style.css" />
    <script src="https://cdn.jsdelivr.net/npm/chart.js@3.8.0/dist/chart.min.js"></script>
    <script src="../Scripts/chart2.js"></script>
    <script src="../Scripts/chart1.js"></script>

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
        <h1>Visualizar Pagos</h1>
    </div>
    <hr class="mx-3" />
    <h2 style="color: black; padding-top: 10px;">Listado de Pago</h2>
    <div class="row">
        <asp:GridView ID="gvPagos" runat="server" AllowPaging="true" PageSize="10" AutoGenerateColumns="false"
            CssClass="table table-hover table-responsive table-striped text-center" ShowHeaderWhenEmpty="true">
            <Columns>
                <asp:BoundField HeaderText="ID_Pago" DataField="idPago">
                    <ItemStyle HorizontalAlign="Center" />
                    <HeaderStyle HorizontalAlign="Center" />
                </asp:BoundField>
                <asp:BoundField HeaderText="ID_Matricula" DataField="matricula.IdMatricula" SortExpression="matricula.IdMatricula">
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
                <asp:BoundField HeaderText="Fecha de Creacion" DataField="fechaCreacion" DataFormatString="{0:yyyy-MM-dd}" HtmlEncode="false">
                    <ItemStyle HorizontalAlign="Center" />
                    <HeaderStyle HorizontalAlign="Center" />
                </asp:BoundField>
                <asp:BoundField HeaderText="Fecha de Pago" DataField="fechaPago" DataFormatString="{0:yyyy-MM-dd}" HtmlEncode="false">
                    <ItemStyle HorizontalAlign="Center" />
                    <HeaderStyle HorizontalAlign="Center" />
                </asp:BoundField>
            </Columns>
        </asp:GridView>
        <h2 style="color: black; padding-top: 10px;">Grafico Estadistico</h2>
        <div class="container">
            <div class="chart">
                <canvas id="barchart" width="50" height="50"></canvas>
            </div>
            <div class="chart">
                <canvas id="doughnut" width="50" height="50"></canvas>
            </div>
        </div>
    </div>
</asp:Content>
