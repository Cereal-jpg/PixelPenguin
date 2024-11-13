<%@ Page Title="" Language="C#" MasterPageFile="~/SoftPixelPenguins.Master" AutoEventWireup="true" CodeBehind="CursosPorProfesorPA.aspx.cs" Inherits="SoftPixelPenguinsWA.CursosPorProfesorPA" %>
<asp:Content ID="Content1" ContentPlaceHolderID="cphTitulo" runat="server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="cphScripts" runat="server">
    <script type="text/javascript">
        function openModal() {
            const modal = new bootstrap.Modal(document.getElementById('cursoModal'));
            modal.show()
        }
    </script>
</asp:Content>

<asp:Content ContentPlaceHolderID="menuItem1" runat="server">
    <a href="IndexPersonalAdministrativo.aspx"><i class="fa-solid fa-home"></i>Inicio</a>
</asp:Content>
<asp:Content ContentPlaceHolderID="menuItem2" runat="server">
    <a href="ReportesPA.aspx"><i class="fa-solid fa-book"></i>Reportes</a>
</asp:Content>
<asp:Content ContentPlaceHolderID="menuItem3" runat="server">
    <a href="CursosYHorariosPA.aspx"><i class="fa-solid fa-calendar-days"></i>Cursos y Horarios</a>
</asp:Content>
<asp:Content ContentPlaceHolderID="menuItem4" runat="server">
    <a href="GestionarSolicitudesPA.aspx"><i class="fa-solid fa-user-plus"></i>Gestionar Solicitudes</a>
</asp:Content>
<asp:Content ContentPlaceHolderID="menuItem5" runat="server">
    <a href="GestionarPlanesPA.aspx"><i class="fa-solid fa-list-check"></i>Gestionar Planes</a>
</asp:Content>
<asp:Content ContentPlaceHolderID="menuItem6" runat="server">
    <a href="MiPerfilPA.aspx"><i class="fa-solid fa-user"></i>Mi Perfil</a>
</asp:Content>
<asp:Content ContentPlaceHolderID="menuItem7" runat="server">
    <asp:Panel ID="panelGestionarUsuarios" runat="server" Visible="false" CssClass="ocularItem">
        <a href="GestionarUsuariosAdmin.aspx"><i class="fa-solid fa-plus-circle"></i>Gestionar Usuarios</a>
    </asp:Panel>
</asp:Content>


<asp:Content ID="Content3" ContentPlaceHolderID="cphContenido" runat="server">
    <asp:ScriptManager ID="ScriptManager1" runat="server"></asp:ScriptManager>
    <h2 style="color: black;">Cursos y Horarios</h2>
    <div class="container-matricula" style="display:block;">
        <div class="d-flex align-items-center justify-content-between mb-3" style="padding: 5px; border-bottom: 2px solid #000;">
            <h2 class="mb-0" style="color: black; border-bottom: none; padding-bottom: 0px;">Listado de Cursos</h2>
            <asp:Button ID="btnAgregarCurso" runat="server" Text="Agregar Curso" CssClass="btn btn-primary" data-bs-toggle="modal" data-bs-target="#cursoModal" OnClientClick="return false;"/>
        </div>
        <asp:GridView ID="gvCursos" runat="server" AutoGenerateColumns="False" CssClass="table table-hover table-responsive table-striped table-bordered">
            <Columns>
                <asp:BoundField DataField="codigoCurso" HeaderText="Código" />
                <asp:BoundField DataField="nombre" HeaderText="Nombre" />
                <asp:TemplateField HeaderText="Grado">
                    <ItemTemplate>
                        <%# Eval("gradoAcademico.numeroGrado") + "° " + Eval("gradoAcademico.nivel") %>
                    </ItemTemplate>
                </asp:TemplateField>
                <asp:TemplateField>
                    <ItemTemplate>
                        <asp:LinkButton ID="btnGestionarHorarios" runat="server" Text="Gestionar Horarios" class="btn btn-primary" OnClick="btnGestionarHorarios_Click" CommandArgument='<%# Eval("idCurso") %>' />
                    </ItemTemplate>
                </asp:TemplateField>
            </Columns>
        </asp:GridView>
        <div class="d-flex justify-content-between">
            <asp:Button ID="btnRegresar" runat="server" Text="Regresar" OnClick="btnRegresar_Click" CssClass="btn btn-primary" />
        </div>
    </div>

    <div class="modal fade" id="cursoModal" tabindex="-1" aria-labelledby="cursoModalLabel" aria-hidden="true">
        <div class="modal-dialog modal-lg">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="cursoModalLabel">Seleccionar Curso</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <div class="col-12 d-flex justify-content-between align-items-center mb-4 pt-3">
                        <div class="input-group w-50">
                            <asp:DropDownList ID="ddlGrados" runat="server" CssClass="form-select">
                            </asp:DropDownList>
                             <asp:LinkButton ID="lbBuscar" runat="server" CssClass="btn btn-outline-primary" OnClick="lbBuscar_Click">
                             <i class="fa-solid fa-search"></i> Buscar
                             </asp:LinkButton>
                        </div>
                        <br />
                    </div>
                    <asp:GridView ID="gvCursosDisponibles" runat="server" AutoGenerateColumns="False" CssClass="table table-hover table-responsive table-striped table-bordered">
                        <Columns>
                            <asp:BoundField DataField="codigoCurso" HeaderText="Código" />
                            <asp:BoundField DataField="nombre" HeaderText="Nombre" />
                            <asp:TemplateField>
                                <ItemTemplate>
                                    <asp:LinkButton ID="btnSeleccionarCurso" CssClass="btn btn-primary" runat="server" OnClick="btnSeleccionarCurso_Click" CommandArgument='<%# Eval("idCurso") %>' >
                                        <i class="fa-solid fa-plus"></i> Seleccionar
                                    </asp:LinkButton>
                                </ItemTemplate>
                            </asp:TemplateField>
                        </Columns>
                    </asp:GridView>
                </div>
            </div>
        </div>
    </div>
</asp:Content>





