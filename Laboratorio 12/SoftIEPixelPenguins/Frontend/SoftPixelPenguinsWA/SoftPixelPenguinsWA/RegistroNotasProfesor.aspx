<%@ Page Title="" Language="C#" MasterPageFile="~/SoftPixelPenguins.Master" AutoEventWireup="true" CodeBehind="RegistroNotasProfesor.aspx.cs" Inherits="SoftPixelPenguinsWA.RegistroNotasProfesor" %>
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
    <h2 style="color: black;">Registro de Notas</h2>
    <div class="container-matricula" style="display:block;">
            <h2 style="color: black;">Listado de Cursos</h2>
            <asp:GridView ID="gvCursos" runat="server" AutoGenerateColumns="False" CssClass="table table-hover table-responsive table-striped table-bordered" >
                <Columns>
                    <asp:BoundField DataField="codigoCurso" HeaderText="Código" />
                    <asp:BoundField DataField="nombre" HeaderText="Nombre" />
                    <asp:TemplateField HeaderText="Grado">
                        <ItemTemplate>
                            <%# Eval("gradoAcademico.nivel") + " " + Eval("gradoAcademico.numeroGrado") %>
                        </ItemTemplate>
                    </asp:TemplateField>
                    <asp:TemplateField>
                        <ItemTemplate>
                            <asp:LinkButton ID="btnVerDetalle" runat="server" Text="Ver Detalle" class="btn btn-primary" OnClick="btnVerDetalle_Click" CommandArgument='<%# Eval("idCurso") %>' />
                        </ItemTemplate>
                    </asp:TemplateField>
                </Columns>
            </asp:GridView>
    </div>
</asp:Content>





