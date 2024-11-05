<%@ Page Language="C#" MasterPageFile="~/SoftPixelPenguins.Master" AutoEventWireup="true" CodeBehind="Reportes.aspx.cs" Inherits="SoftPixelPenguinsWA.Reportes" %>

<asp:Content ID="Content1" ContentPlaceHolderID="cphScripts" runat="server">
    <link rel="stylesheet" href="Content/customStyles.css">
    <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
</asp:Content>
<asp:Content ContentPlaceHolderID="menuItem1" runat="server">
    <a href="IndexAdmin.aspx"><i class="fa-solid fa-home"></i>Pagina principal</a>
</asp:Content>
<asp:Content ContentPlaceHolderID="menuItem2" runat="server">
    <a href="ReporteGrado.aspx"><i class="fa-solid fa-book"></i>Reportes</a>
</asp:Content>
<asp:Content ContentPlaceHolderID="menuItem3" runat="server">
    <a href="ListarCursosAlumno.aspx"><i class="fa-solid fa-search"></i>Busquedas</a>
</asp:Content>
<asp:Content ContentPlaceHolderID="menuItem4" runat="server">
    <a href="GestionarUsuarios.aspx"><i class="fa-solid fa-plus-circle"></i>Gestionar Usuario</a>
</asp:Content>

<asp:Content ID="Content2" ContentPlaceHolderID="cphContenido" runat="server">
    <h2 style="color: black;">Reportes</h2>
    <div class="container-matricula">
        <div class="form-container">
            <h2 style="color: black; font-size:20px">Consultar Reportes</h2>
            <label for="cblReportes">Tipo de Reporte:</label>
            <div class="container" style="padding: 5px; margin-top: 5px;">
                <asp:RadioButtonList ID="cblReportes" runat="server" RepeatDirection="Horizontal">
                <asp:ListItem Text="Reporte de Matrículas por Grado" Value="Grado" />
                <asp:ListItem Text="Valor de prueba" Value="prueba1" />
                <asp:ListItem Text="Valor de prueba" Value="prueba1" />
            </asp:RadioButtonList>
            </div>
        <asp:Button ID="btnEmitirReporte" runat="server" Text="Emitir Reporte" OnClick="btnEmitirReporte_Click" CssClass="btn btn-primary"/>
        </div>
    </div>
</asp:Content>
