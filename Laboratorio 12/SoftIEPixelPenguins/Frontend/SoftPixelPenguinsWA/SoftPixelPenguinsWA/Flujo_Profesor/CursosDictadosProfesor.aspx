<%@ Page Title="" Language="C#" MasterPageFile="~/SoftPixelPenguins.Master" AutoEventWireup="true" CodeBehind="CursosDictadosProfesor.aspx.cs" Inherits="SoftPixelPenguinsWA.CursosDictadosProfesor" %>
<asp:Content ID="Content1" ContentPlaceHolderID="cphTitulo" runat="server">
    Cursos Dictados - Profesor
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="cphScripts" runat="server">
</asp:Content>

<asp:Content ContentPlaceHolderID="menuItem1" runat="server">
    <a href="IndexProfesor.aspx"><i class="fa-solid fa-home"></i> Inicio</a>
</asp:Content>
<asp:Content ContentPlaceHolderID="menuItem2" runat="server">
    <a href="CursosDictadosProfesor.aspx"><i class="fa-solid fa-book"></i> Cursos Dictados</a>
</asp:Content>
<asp:Content ContentPlaceHolderID="menuItem3" runat="server">
    <a href="RegistroNotasProfesor.aspx"><i class="fa-solid fa-bar-chart"></i> Registro de notas</a>
</asp:Content>
<asp:Content ContentPlaceHolderID="menuItem4" runat="server">
    <a href="MiPerfilProfesor.aspx"><i class="fa-solid fa-user"></i> Mi perfil</a>
    </asp:Content>

<asp:Content ID="Content3" ContentPlaceHolderID="cphContenido" runat="server">

    <style>
    .my-label {
        margin-bottom: 20px; /* Ajusta este valor para el espacio que necesites */
    }
</style>

    <h2 style="text-align: left; color: #000f;">Profesor - Cursos Dictados</h2>
    <link rel="stylesheet" href="../Content/Estilos-Alumno.css" />
    <div class="container-matricula" style="display:block;">

        <asp:Label ID="myLabel" runat="server" Text="" Font-Size="X-Large" Font-Bold="True" CssClass="my-label"></asp:Label>
        <br><br>
        <asp:GridView ID="gvCursosDictados" runat="server" AllowPaging="true" PageSize="12" AutoGenerateColumns="false" CssClass="table table-hover table-responsive table-striped" ShowHeaderWhenEmpty="true">
            <Columns>
                <asp:BoundField HeaderText="Codigo" DataField="codigoCurso"/>
                <asp:BoundField HeaderText="Nombre" DataField="nombre"/>
                <asp:BoundField HeaderText="Horas Semanales" DataField="horasPorSemana"/>
                <asp:TemplateField>
                    <ItemTemplate>
                        <asp:LinkButton ID="btnVerGrado" runat="server" CommandName="Seleccionar" Text="Ver Grado" class="btn btn-primary" OnClick="btnVerGrado_Click" CommandArgument='<%# Eval("idCurso") %>' />
                    </ItemTemplate>
                </asp:TemplateField>

            </columns>
        </asp:GridView>


    </div>
</asp:Content>
