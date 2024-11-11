<%@ Page Title="" Language="C#" MasterPageFile="~/SoftPixelPenguins.Master" AutoEventWireup="true" CodeBehind="RegistroNotasProfesor_Competencias.aspx.cs" Inherits="SoftPixelPenguinsWA.RegistroNotasProfesor_Competencias" %>
<asp:Content ID="Content1" ContentPlaceHolderID="cphTitulo" runat="server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="cphScripts" runat="server">
</asp:Content>

<asp:Content ContentPlaceHolderID="menuItem1" runat="server">
    <a href="IndexProfesor.aspx"><i class="fa-solid fa-home"></i>Inicio</a>
</asp:Content>
<asp:Content ContentPlaceHolderID="menuItem2" runat="server">
    <a href="CursosDictadosProfesor.aspx"><i class="fa-solid fa-book"></i>Cursos Dictados</a>
</asp:Content>
<asp:Content ContentPlaceHolderID="menuItem3" runat="server">
    <a href="RegistroNotasProfesor.aspx"><i class="fa-solid fa-bar-chart"></i>Registro de notas</a>
</asp:Content>
<asp:Content ContentPlaceHolderID="menuItem4" runat="server">
    <a href="MiPerfilProfesor.aspx"><i class="fa-solid fa-user"></i>Mi perfil</a>
</asp:Content>


<asp:Content ID="Content3" ContentPlaceHolderID="cphContenido" runat="server">
    <h2 id="hTitulo" style="color: black;" runat="server"></h2>
    <div class="container-matricula" style="display:block;">
        <h2 style="color: black;">Listado de Competencias</h2>
        <asp:GridView ID="gvCompetencias" runat="server" AutoGenerateColumns="False" CssClass="table table-hover table-responsive table-striped table-bordered" >
            <Columns>
                <asp:BoundField DataField="descripcion" HeaderText="Descripcion" />
                <asp:TemplateField>
                    <ItemTemplate>
                        <asp:LinkButton ID="btnRegistrarNota" runat="server" Text="Registrar Nota" class="btn btn-primary" OnClick="btnRegistrarNota_Click" CommandArgument='<%# Eval("idCompetencia") %>' />
                    </ItemTemplate>
                </asp:TemplateField>
            </Columns>
        </asp:GridView>
        <div>
        <asp:Button ID="btnRegresar" runat="server" Text="Regresar" OnClick="btnRegresar_Click" CssClass="btn btn-primary" />
        </div>
    </div>
</asp:Content>





