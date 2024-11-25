<%@ Page Title="" Language="C#" MasterPageFile="~/SoftPixelPenguins.Master" AutoEventWireup="true" CodeBehind="NotasParcialesAlumno.aspx.cs" Inherits="SoftPixelPenguinsWA.NotasParcialesAlumno" %>
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
    <h2 id="hTitulo" style="color: black;" runat="server"></h2>
    <div class="container-matricula" style="display:block;">
        <div class="d-flex justify-content-between align-items-center mb-3" style="padding: 5px; border-bottom: 2px solid #000;">
            <asp:DropDownList ID="ddlCursos" runat="server" CssClass="form-select w-auto" AutoPostBack="true" OnSelectedIndexChanged="ddlCurso_SelectedIndexChanged">
            </asp:DropDownList>
            <asp:DropDownList ID="ddlBimestre" runat="server" CssClass="form-select w-auto" AutoPostBack="true" OnSelectedIndexChanged="ddlBimestre_SelectedIndexChanged">
                <asp:ListItem Text="Bimestre 1" Value="1"></asp:ListItem>
                <asp:ListItem Text="Bimestre 2" Value="2"></asp:ListItem>
                <asp:ListItem Text="Bimestre 3" Value="3"></asp:ListItem>
                <asp:ListItem Text="Bimestre 4" Value="4"></asp:ListItem>
            </asp:DropDownList>
        </div>
        <asp:GridView ID="gvNotas" runat="server" AutoGenerateColumns="False" CssClass="table table-hover table-responsive table-striped table-bordered" DataKeyNames="idNota">
            <Columns>
                <asp:BoundField DataField="competencia.descripcion" HeaderText="Competencia" />
                <asp:BoundField DataField="nota1" HeaderText="Nota Asignada" />
            </Columns>
        </asp:GridView>
        <div class="d-flex justify-content-between">
            <asp:Button ID="btnRegresar" runat="server" Text="Regresar" OnClick="btnRegresar_Click" CssClass="btn btn-primary" />
        </div>
    </div>
</asp:Content>
