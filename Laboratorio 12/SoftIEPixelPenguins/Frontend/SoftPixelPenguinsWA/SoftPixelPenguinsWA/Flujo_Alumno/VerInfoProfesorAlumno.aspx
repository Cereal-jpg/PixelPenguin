<%@ Page Title="" Language="C#" MasterPageFile="~/SoftPixelPenguins.Master" AutoEventWireup="true" CodeBehind="VerInfoProfesorAlumno.aspx.cs" Inherits="SoftPixelPenguinsWA.VerInfoProfesorAlumno" %>
<asp:Content ID="Content1" ContentPlaceHolderID="cphTitulo" runat="server">
    Detalle del profesor asignado
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="cphScripts" runat="server">
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
    <a href="MisPagos.aspx"><i class="fa-solid fa-book"></i>Mis Pagos</a>
</asp:Content>
<asp:Content ContentPlaceHolderID="menuItem6" runat="server">
    <a href="MiPerfilAlumno.aspx"><i class="fa-solid fa-user"></i> Mi Perfil</a>
</asp:Content>

<asp:Content ID="Content3" ContentPlaceHolderID="cphContenido" runat="server">
    <h2 id="hTitulo" style="color: black;" runat="server"></h2>
    <link rel="stylesheet" href="../Content/Estilos-Perfil.css" />
    <link rel="stylesheet" href="../Content/EstilosGenerico.css" />
    <div class="container-al">
        <div class="schedule">
            <!-- Sección: Datos del profesor-->
            <div class="form-section">
                <h3>Datos del docente</h3>
                <div class="form-group">
                    <div class="form-row">
                        <label>Código:</label>
                        <asp:TextBox ID="txtCodigoProfesor" runat="server" placeholder="Código del docente"></asp:TextBox>
                    </div>
                    <div class="form-row">
                        <label>Especialidad:</label>
                        <asp:TextBox ID="txtEspecialidad" runat="server" placeholder="Especialidad"></asp:TextBox>
                    </div>
                    <div class="form-row">
                        <label>Fecha de cumpleaños:</label>
                        <asp:TextBox ID="txtFecha" runat="server" placeholder="Fecha de cumpleaños"></asp:TextBox>
                    </div>
                </div>
                <div class="form-group">
                    <div class="form-row">
                        <label>Email de contacto:</label>
                        <asp:TextBox ID="txtEmail" runat="server" placeholder="Email del docente"></asp:TextBox>
                    </div>
                    <div class="form-row">
                        <label>Sexo:</label>
                        <asp:TextBox ID="txtSexo" runat="server" placeholder="Sexo"></asp:TextBox>
                    </div>
                </div>
            </div>
            <div>
                <br>
                <asp:Button ID="btnRegresar" runat="server" Text="Regresar" OnClick="btnRegresar_Click" CssClass="btn btn-primary" />
            </div>
        </div>
    </div>
</asp:Content>
