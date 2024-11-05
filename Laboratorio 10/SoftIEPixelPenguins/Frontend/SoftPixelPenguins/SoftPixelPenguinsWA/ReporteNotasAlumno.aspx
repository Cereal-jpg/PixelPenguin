<%@ Page Title="" Language="C#" MasterPageFile="~/SoftPixelPenguins.Master" AutoEventWireup="true" CodeBehind="ReporteNotasAlumno.aspx.cs" Inherits="SoftPixelPenguinsWA.ReporteNotasAlumno" %>
<asp:Content ID="Content1" ContentPlaceHolderID="cphTitulo" runat="server">
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
    <a href="ReporteNotasAlumno.aspx"><i class="fa-solid fa-bar-chart"></i>Reporte de Notas</a>
</asp:Content>
<asp:Content ContentPlaceHolderID="menuItem4" runat="server">
    <a href="MatriculaAlumno-0.aspx"><i class="fa-solid fa-archive"></i>Matrícula Online</a>
</asp:Content>

<asp:Content ID="Content3" ContentPlaceHolderID="cphContenido" runat="server">
    <h2 style="text-align: left; color: #000f;">Alumno - Registro de Notas - </h2>
    <hr class="mx-3" />
    <div class="container mt-5">

        <div class="row">
            <div class="col-12">
                <asp:GridView ID="gvNotas" runat="server" AutoGenerateColumns="False" CssClass="table table-striped table-bordered" Style="background-color: transparent;">
                    <Columns>
                        <asp:BoundField HeaderText="Código" DataField="curso" />
                        <asp:BoundField HeaderText="Curso" DataField="nota" />
                        <asp:BoundField HeaderText="Nota" DataField="estado" />
                    </Columns>
                </asp:GridView>

            </div>
        </div>
    </div>
</asp:Content>
