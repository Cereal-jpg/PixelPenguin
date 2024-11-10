<%@ Page Title="" Language="C#" MasterPageFile="~/SoftPixelPenguins.Master" AutoEventWireup="true" CodeBehind="RegistroNotasProfesor_Alumnos.aspx.cs" Inherits="SoftPixelPenguinsWA.RegistroNotasProfesor_Alumnos" %>
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
        <div class="d-flex justify-content-between align-items-center mb-3" style="padding: 5px; border-bottom: 2px solid #000;">
            <h2 class="text-dark" style="padding-top:10px; border-bottom: none; padding-bottom: 0px;"">Listado de Alumnos</h2>
            <asp:DropDownList ID="ddlBimestre" runat="server" CssClass="form-select w-auto">
                <asp:ListItem Text="Bimestre 1" Value="1"></asp:ListItem>
                <asp:ListItem Text="Bimestre 2" Value="2"></asp:ListItem>
                <asp:ListItem Text="Bimestre 3" Value="3"></asp:ListItem>
                <asp:ListItem Text="Bimestre 4" Value="4"></asp:ListItem>
            </asp:DropDownList>
        </div>
        <asp:GridView ID="gvAlumnos" runat="server" AutoGenerateColumns="False" CssClass="table table-hover table-responsive table-striped table-bordered" DataKeyNames="idUsuario">
            <Columns>
                <asp:BoundField DataField="codigoAlumno" HeaderText="Código" />
                <asp:BoundField DataField="nombreCompleto" HeaderText="Nombre" />
                <asp:TemplateField HeaderText="Nota">
                    <ItemTemplate>
                        <asp:DropDownList ID="ddlNotas" runat="server" CssClass="form-select">
                            <asp:ListItem Text="AD" Value="AD" />
                            <asp:ListItem Text="A" Value="A" />
                            <asp:ListItem Text="B" Value="B" />
                            <asp:ListItem Text="C" Value="C" />
                        </asp:DropDownList>
                    </ItemTemplate>
                </asp:TemplateField>
            </Columns>
        </asp:GridView>
        <div class="d-flex justify-content-between">
            <asp:Label ID="lblError" runat="server" ForeColor="Red" Visible="False"></asp:Label>
            <asp:Button ID="btnRegresar" runat="server" Text="Regresar" OnClick="btnRegresar_Click" CssClass="btn btn-primary" />
            <asp:Button ID="btnGrabar" runat="server" Text="Registrar Notas" OnClick="btnGrabar_Click" CssClass="btn btn-primary" />
        </div>
    </div>
</asp:Content>





