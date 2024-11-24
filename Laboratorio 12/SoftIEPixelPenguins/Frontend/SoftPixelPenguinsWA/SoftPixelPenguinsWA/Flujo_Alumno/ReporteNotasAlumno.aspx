<%@ Page Title="" Language="C#" MasterPageFile="~/SoftPixelPenguins.Master" AutoEventWireup="true" CodeBehind="ReporteNotasAlumno.aspx.cs" Inherits="SoftPixelPenguinsWA.ReporteNotasAlumno" %>

<asp:Content ID="Content1" ContentPlaceHolderID="cphTitulo" runat="server">
    Mis Notas - Alumno
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
    <a href="MisPagosAlumno.aspx"><i class="fa-solid fa-book"></i> Mis Pagos</a>
</asp:Content>
<asp:Content ContentPlaceHolderID="menuItem6" runat="server">
    <a href="MiPerfilAlumno.aspx"><i class="fa-solid fa-user"></i> Mi Perfil</a>
</asp:Content>

<asp:Content ID="Content3" ContentPlaceHolderID="cphContenido" runat="server">
    <h2 style="text-align: left; color: #000f;">Alumno - Reporte de Notas</h2>
    <link rel="stylesheet" href="../Content/EstiloCurso.css" />
    
    <div id="section1" class="section" runat="server" style="display: block;">
       <!-- Sección: Datos del alumno -->
        <div class="container-matricula" style="display:block;">
            <asp:Label ID="myLabel" runat="server" Text="" Font-Size="Large" Font-Bold="True" CssClass="my-label"></asp:Label>
            <h2 style="color: black;">Notas Finales - Periodo 2024</h2>
            <div class="form-group">
                <div class="form-row">
                    <label>Institución Educativa:</label>
                    <asp:TextBox ID="txtInstitucion" runat="server" placeholder="Intitucion"></asp:TextBox>
                </div>
                <div class="form-row">
                    <label>RUC:</label>
                    <asp:TextBox ID="txtRUC" runat="server" placeholder="RUC"></asp:TextBox>
                </div>
            </div>
            <div class="form-group">
                <div class="form-row">
                    <label>Dirección:</label>
                    <asp:TextBox ID="txtDireccion" runat="server" placeholder="Direccion"></asp:TextBox>
                </div>
            </div>
            <div class="form-group">
                <div class="form-row">
                    <label>Alumno:</label>
                    <asp:TextBox ID="txtAlumno" runat="server" placeholder="Alumno"></asp:TextBox>
                </div>
            </div>
            <br><br>
            <asp:GridView ID="gvNotas" runat="server" AllowPaging="true" PageSize="12" AutoGenerateColumns="false" CssClass="table table-hover table-responsive table-striped" ShowHeaderWhenEmpty="true">
                <Columns>
                    <asp:BoundField HeaderText="Curso" DataField="curso.nombre"/>
                    <asp:BoundField HeaderText="Bimestre 1" DataField="notaBimestre1"/>
                    <asp:BoundField HeaderText="Bimestre 2" DataField="notaBimestre2"/>
                    <asp:BoundField HeaderText="Bimestre 3" DataField="notaBimestre3"/>
                    <asp:BoundField HeaderText="Bimestre 4" DataField="notaBimestre4"/>
                    <asp:BoundField HeaderText="Nota Final" DataField="notaFinal"/>
                </columns>
            </asp:GridView>
            <div style="display: flex; justify-content: flex-end; gap: 10px;">
                <asp:Button ID="btnReporte" runat="server" Text="Ver Reporte" CssClass="login-button" OnClick="btnReporte_Click" OnClientClick="openInNewTab();"/>
                <asp:Button ID="btnDownloadPDF" runat="server" Text="Descargar Reporte Notas" OnClick="btnDownloadPDF_Click" CssClass="login-button"/>
                <asp:Button ID="Notas" runat="server" Text="Ver Notas Parciales" CssClass="login-button" OnClick="btnVerNotasParciales_Click"/>
            </div>
        </div>
    </div>

    <script>

        function openInNewTab() {
            window.document.forms[1].target = '_blank';
            setTimeout(function () { window.document.forms[0].target = ''; }, 0);
        }

        window.onload = createChart;
    </script>

</asp:Content>