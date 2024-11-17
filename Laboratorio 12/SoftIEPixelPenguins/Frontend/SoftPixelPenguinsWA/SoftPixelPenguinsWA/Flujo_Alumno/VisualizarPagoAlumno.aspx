<%@ Page Title="" Language="C#" MasterPageFile="~/SoftPixelPenguins.Master" AutoEventWireup="true" CodeBehind="VisualizarPagoAlumno.aspx.cs" Inherits="SoftPixelPenguinsWA.VisualizarPagoAlumno" %>

<asp:Content ID="Content1" ContentPlaceHolderID="cphTitulo" runat="server">
    Visualizar - Pago
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="cphScripts" runat="server">
    <link rel="stylesheet" href="../Content/Estilo-VisualizarPagoAlumno.css" />
</asp:Content>

<asp:Content ContentPlaceHolderID="menuItem1" runat="server">
    <a href="IndexAlumno.aspx"><i class="fa-solid fa-home"></i> Inicio</a>
</asp:Content>
<asp:Content ContentPlaceHolderID="menuItem2" runat="server">
    <a href="MisCursosAlumno.aspx"><i class="fa-solid fa-book"></i> Mis cursos</a>
</asp:Content>
<asp:Content ContentPlaceHolderID="menuItem3" runat="server">
    <a href="ReporteNotasAlumno.aspx"><i class="fa-solid fa-bar-chart"></i> Reporte de Notas</a>
</asp:Content>
<asp:Content ContentPlaceHolderID="menuItem4" runat="server">
    <a href="MatriculaOnlineAlumno.aspx"><i class="fa-solid fa-archive"></i> Matrícula Online</a>
</asp:Content>
<asp:Content ContentPlaceHolderID="menuItem5" runat="server">
    <a href="MisPagosAlumno.aspx"><i class="fa-solid fa-book"></i> Mis Pagos</a>
</asp:Content>
<asp:Content ContentPlaceHolderID="menuItem6" runat="server">
    <a href="MiPerfilAlumno.aspx"><i class="fa-solid fa-user"></i> Mi Perfil</a>
</asp:Content>

<asp:Content ID="Content3" ContentPlaceHolderID="cphContenido" runat="server">

    <h2 style="text-align: left; color: #000f;">Inicio</h2>

     <div id="section1" class="section" runat="server" style="display: block;">
        <!-- Sección: Datos del alumno -->
         <div class="container-matricula" style="display:block;">
            <h2 style="color: black;">Datos del Alumno</h2>
            <div class="form-group">
                <div class="form-row">
                    <label>Fecha Creación:</label>
                    <asp:TextBox ID="txtFechaCreacion" runat="server" placeholder="Fecha de creación"></asp:TextBox>
                </div>
                <div class="form-row">
                    <label>Fecha Pago:</label>
                    <asp:TextBox ID="txtFechaPago" runat="server" placeholder="Fecha de cancelación"></asp:TextBox>
                </div>
            </div>
            <div class="form-group">
                <div class="form-row">
                    <label>Tipo de comprobante:</label>
                    <asp:TextBox ID="txtTipoComprobante" runat="server" placeholder="Tipo de comprobante"></asp:TextBox>
                </div>
                <div class="form-row">
                    <label>Estado del pago:</label>
                    <asp:TextBox ID="txtEstadoPago" runat="server" placeholder="Estado del pago"></asp:TextBox>
                </div>
                <div class="form-row">
                    <label>Tipo de pago:</label>
                    <asp:TextBox ID="txtTipodePago" runat="server" placeholder="Tipo de pago"></asp:TextBox>
                </div>
            </div>
        </div>

        <!-- Sección: Comprobante de Pago -->
         <div class="container-matricula" style="display:block; ">
            <h2 style="color: black;">Comprobante de Pago</h2>
            <div class="form-row">
                <label>Comprobante del pago: </label>
                <asp:LinkButton ID="lnkDescargarComprobante" runat="server" CssClass="btn btn-info me-2" OnClick="lnkDescargarComprobante_Click">
                    Descargar Comprobante del pago
                </asp:LinkButton>
            </div>
        </div>

        <!-- Botón: Regresar -->
         <div style="display: flex; justify-content: center; align-items: center;">
            <br>
            <asp:Button ID="btnRegresar" runat="server" Text="Regresar" OnClick="btnRegresar_Click" CssClass="button-style" />
        </div>

    </div>

</asp:Content>






