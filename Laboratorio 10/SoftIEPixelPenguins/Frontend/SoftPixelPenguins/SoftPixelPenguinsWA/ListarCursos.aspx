<%@ Page Title="" Language="C#" MasterPageFile="~/SoftPixelPenguins.Master" AutoEventWireup="true" CodeBehind="ListarCursos.aspx.cs" Inherits="SoftPixelPenguinsWA.ListarCursos" %>
<asp:Content ID="Content1" ContentPlaceHolderID="cphTitulo" runat="server">
    Cursos - Alumno
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="cphScripts" runat="server">
</asp:Content>
<asp:Content ContentPlaceHolderID="menuItem1" runat="server">
    <a href="IndexAlumno.aspx"><i class="fa-solid fa-home"></i>Inicio</a>
</asp:Content>
<asp:Content ContentPlaceHolderID="menuItem2" runat="server">
    <a href="ListarCursos.aspx"><i class="fa-solid fa-book"></i>Mis cursos</a>
</asp:Content>
<asp:Content ContentPlaceHolderID="menuItem3" runat="server">
    <a href="IndexAlumno.aspx"><i class="fa-solid fa-bar-chart"></i>Reporte de Notas</a>
</asp:Content>
<asp:Content ContentPlaceHolderID="menuItem4" runat="server">
    <a href="MatriculaAlumno-0.aspx"><i class="fa-solid fa-archive"></i>Matrícula Online</a>
</asp:Content>
<asp:Content ContentPlaceHolderID="menuItem5" runat="server">
    <a href="PerfilAlumno.aspx"><i class="fa-solid fa-user"></i>Mi Perfil</a>
</asp:Content>

<asp:Content ID="Content3" ContentPlaceHolderID="cphContenido" runat="server">
    <h2 style="text-align: left; color: #000f;">Alumno - Mis Cursos</h2>
    <link rel="stylesheet" href="Content/Fonts/EstiloCurso.css" />

    <style>
        .my-label {
            margin-bottom: 20px; /* Ajusta este valor para el espacio que necesites */
        }
    </style>
    
    <div class="container-al">
        <div class="schedule">

            <asp:Label ID="myLabel" runat="server" Text="" Font-Size="Large" Font-Bold="True" CssClass="my-label"></asp:Label>
            <br><br>
            <asp:GridView ID="gvMisCursos" runat="server" AllowPaging="true" PageSize="12" AutoGenerateColumns="false" CssClass="table table-hover table-responsive table-striped" ShowHeaderWhenEmpty="true">
                <Columns>
                    <asp:BoundField HeaderText="Codigo" DataField="codigoCurso"/>
                    <asp:BoundField HeaderText="Nombre" DataField="nombre"/>
                    <asp:BoundField HeaderText="Horas Semanales" DataField="horasPorSemana"/>
                </columns>
            </asp:GridView>

        </div>
    </div>
</asp:Content>
