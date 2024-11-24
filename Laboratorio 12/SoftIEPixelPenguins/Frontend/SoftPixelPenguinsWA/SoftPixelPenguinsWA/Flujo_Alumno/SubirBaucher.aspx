<%@ Page Title="" Language="C#" MasterPageFile="~/SoftPixelPenguins.Master" AutoEventWireup="true" CodeBehind="SubirBaucher.aspx.cs" Inherits="SoftPixelPenguinsWA.Flujo_Alumno.SubirBaucher" %>

<asp:Content ID="Content1" ContentPlaceHolderID="cphTitulo" runat="server">
    Subir Documento de Pago - Alumno
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
    <h3 style="text-align: left; color: #2c3e50;">Subir Pago</h3>
    <link rel="stylesheet" href="../Content/Estilos-SubirDocumento.css" />

    <div id="section1" class="section" runat="server" style="display: block;">
        <div class="container-matricula">
            <!-- Sección de subir archivos -->
            <div class="form-section">
                <h2>Adjuntar Documento de Pago</h2>
                <hr>
                <div class="form-group">
                    <label for="fileBaucher">Documento de Pago:</label>
                    <asp:FileUpload ID="fileBaucher" runat="server" CssClass="file-upload" />
                </div>
                <div class="form-group">
                    <label for="ddlCategorias">Tipo de Pago:</label>
                    <asp:DropDownList ID="ddlCategorias" runat="server" CssClass="dropdownPago">
                        <asp:ListItem Text="Seleccione un tipo de pago" Value="" />
                        <asp:ListItem Text="BANCOS_ASOCIADOS" Value="BANCOS_ASOCIADOS" />
                        <asp:ListItem Text="TRANSFERENCIA_BANCARIA" Value="TRANSFERENCIA_BANCARIA" />
                    </asp:DropDownList>
                </div>
                <div class="form-group">
                    <label for="ddlPagos">Tipo de Documento:</label>
                    <asp:DropDownList ID="ddlPagos" runat="server" CssClass="dropdownPago">
                        <asp:ListItem Text="Seleccione un tipo de comprobante de pago" Value="" />
                        <asp:ListItem Text="BOLETA" Value="BOLETA" />
                        <asp:ListItem Text="FACTURA" Value="FACTURA" />
                    </asp:DropDownList>
                </div>
            </div>
        </div>

        <!-- Sección de botones -->
        <div class="buttons-container">
            <asp:Button ID="btnRegresar2" runat="server" Text="Regresar" OnClick="prevSection" CssClass="buttonPago-style" />
            <asp:Button ID="btnGuardar" runat="server" Text="Grabar y Continuar" OnClick="btnGuardar_Click" CssClass="buttonPago-style" />
        </div>
    </div>
</asp:Content>


