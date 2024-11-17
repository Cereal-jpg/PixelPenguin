<%@ Page Title="" Language="C#" MasterPageFile="~/SoftPixelPenguins.Master" AutoEventWireup="true" CodeBehind="SubirBaucher.aspx.cs" Inherits="SoftPixelPenguinsWA.Flujo_Alumno.SubirBaucher" %>

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

   <h3 style="text-align: left; color: #000f;">Subir Pago</h3>
<link rel="stylesheet" href="../Content/Estilos-Alumno.css" />
<div id="section1" class="section" runat="server" style="display: block;">
    <div class="container-matricula" style="display: flex; justify-content: center; align-items: center; height: 100vh;">
        <!-- Sección de subir archivos -->
        <div class="form-section" style="width: 50%; background-color: #f9f9f9; padding: 20px; border-radius: 8px; box-shadow: 0px 4px 6px rgba(0, 0, 0, 0.1);">
            <h2 style="text-align: center; color: #000f;">Adjuntar Baucher de Pago</h2>
            <hr>
            <div class="form-group">
                <div class="form-row" style="margin-bottom: 15px;">
                    <label for="fileBaucher" style="display: block; font-weight: bold; margin-bottom: 5px;">Baucher de Pago:</label>
                    <asp:FileUpload ID="fileBaucher" runat="server" CssClass="file-upload" style="width: 100%;" />
                </div>
            </div>
        </div>
    </div>

    <!-- Sección de botones -->
    <div style="display: flex; justify-content: center; align-items: center; margin-top: 20px;">
        <asp:Button ID="btnRegresar2" runat="server" Text="Regresar" OnClick="prevSection" CssClass="button-style" style="margin-right: 10px;" />
        <asp:Button ID="btnGuardar" runat="server" Text="Grabar y Continuar" OnClick="btnGuardar_Click" CssClass="button-style" />
    </div>
</div>

</asp:Content>

