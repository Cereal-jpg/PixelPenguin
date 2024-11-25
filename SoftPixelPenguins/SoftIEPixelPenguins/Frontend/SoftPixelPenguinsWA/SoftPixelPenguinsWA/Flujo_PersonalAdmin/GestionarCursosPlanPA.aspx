<%@ Page Title="" Language="C#" MasterPageFile="~/SoftPixelPenguins.Master" AutoEventWireup="true" CodeBehind="GestionarCursosPlanPA.aspx.cs" Inherits="SoftPixelPenguinsWA.GestionarCursosPlanPA" %>
<asp:Content ID="Content1" ContentPlaceHolderID="cphTitulo" runat="server">
    Gestionar Cursos - Personal Administrativo
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="cphScripts" runat="server">
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
    <a href="GestionarPagosPA.aspx"><i class="fa-solid fa-money-bill"></i>Gestionar Pagos</a>
</asp:Content>
<asp:Content ContentPlaceHolderID="menuItem6" runat="server">
    <a href="GestionarPlanesPA.aspx"><i class="fa-solid fa-list-check"></i>Gestionar Planes</a>
</asp:Content>
<asp:Content ContentPlaceHolderID="menuItem7" runat="server">
    <a href="MiPerfilPA.aspx"><i class="fa-solid fa-user"></i>Mi Perfil</a>
</asp:Content>
<asp:Content ContentPlaceHolderID="menuItem8" runat="server">
    <asp:Panel ID="panelGestionarUsuarios" runat="server" Visible="false" CssClass="ocularItem">
        <a href="GestionarUsuariosAdmin.aspx"><i class="fa-solid fa-plus-circle"></i>Gestionar Usuarios</a>
    </asp:Panel>
</asp:Content>


<asp:Content ID="Content3" ContentPlaceHolderID="cphContenido" runat="server">
    <h2 style="color: black;">Gestionar Cursos</h2>
    <div class="container-matricula" style="display:block;">
        <h2 id="hTitulo" runat="server" style="color: black"> Agregar Curso</h2>
        <div class="d-flex flex-wrap mb-3" style="gap: 15px;">
            <div class="col-md-4" style="flex: 1; max-width: 32%;">
                <label for="txtCodigoCurso">Código del Curso:</label>
                <asp:TextBox ID="txtCodigoCurso" runat="server" CssClass="form-control" placeholder="Ingrese el código del curso" required="required" />
            </div>
            <div class="col-md-4" style="flex: 1; max-width: 32%;">
                <label for="txtNombreCurso">Nombre del Curso:</label>
                <asp:TextBox ID="txtNombreCurso" runat="server" CssClass="form-control" placeholder="Ingrese el nombre del curso" required="required" />
            </div>
            <div class="col-md-4" style="flex: 1; max-width: 32%;">
                <label for="txtHorasPorSemana">Horas por Semana:</label>
                <asp:TextBox ID="txtHorasPorSemana" runat="server" CssClass="form-control" placeholder="Ingrese las horas por semana" required="required" />
            </div>
        </div>
        <div class="form-row">
            <div class="col-md-5 mb-3">
                <asp:Button ID="btnAgregarCurso" runat="server" Text="Agregar Curso" CssClass="btn btn-primary btn-block" OnClick="btnAgregarCurso_Click" />
            </div>
        </div>
        <div class="container-matricula mb-3" style="display:block; background-color: #cfe2f3; border-radius: 8px">
            <h2 style="color: black;">Gestionar Competencias</h2>
            <div class="d-flex flex-wrap mb-3" style="gap: 15px;">
                <div class="col-md-8" style="flex: 1; max-width: 85%; display: flex; flex-direction: column;">
                    <label for="txtDescripcionCompetencia">Descripción de la Competencia:</label>
                    <asp:TextBox ID="txtDescripcionCompetencia" runat="server" CssClass="form-control" placeholder="Ingrese la descripción de la competencia" style="width: 100%;" />
                </div>
                <div class="col-md-4 mt-4" style="flex: 1; max-width: 15%;">
                    <asp:Button ID="btnAgregarCompetencia" runat="server" Text="Agregar Competencia" CssClass="btn btn-primary" OnClick="btnAgregarCompetencia_Click" />
                    <div>
                        <asp:Label ID="lblError" runat="server" CssClass="text-danger" Visible="false" Text="Debe agregar el curso primero." />
                    </div>
                </div>
            </div>
            <asp:GridView ID="gvCompetencias" runat="server" ShowHeader="True" AutoGenerateColumns="False" CssClass="table table-hover table-responsive table-striped table-bordered" >
                <Columns>
                    <asp:BoundField DataField="descripcion" HeaderText="Descripción" />
                    <asp:TemplateField HeaderText="Acciones">
                        <ItemTemplate>
                            <asp:LinkButton ID="lnkDelete" runat="server" 
                                CommandArgument='<%# Eval("idCompetencia") %>' 
                                CssClass="btn btn-danger btn-sm" 
                                OnClick="lbEliminar_Click">
                                <i class="fa-solid fa-trash"></i> Eliminar
                            </asp:LinkButton>
                        </ItemTemplate>
                    </asp:TemplateField>
                </Columns>
            </asp:GridView>
        </div>
        <div class="d-flex justify-content-between">
            <asp:Button ID="btnRegresar" runat="server" Text="Regresar" OnClick="btnRegresar_Click" CssClass="btn btn-primary" />
        </div>
    </div>
</asp:Content>
