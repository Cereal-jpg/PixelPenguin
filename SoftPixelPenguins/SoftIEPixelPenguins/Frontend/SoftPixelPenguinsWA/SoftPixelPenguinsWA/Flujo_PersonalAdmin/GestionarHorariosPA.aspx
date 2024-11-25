<%@ Page Title="" Language="C#" MasterPageFile="~/SoftPixelPenguins.Master" AutoEventWireup="true" CodeBehind="GestionarHorariosPA.aspx.cs" Inherits="SoftPixelPenguinsWA.GestionarHorariosPA" %>
<asp:Content ID="Content1" ContentPlaceHolderID="cphTitulo" runat="server">
    Gestionar Horarios - Personal Administrativo
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
    <h2 style="color: black;">Gestionar Horarios</h2>
    <div class="container-matricula" style="display:block;">
        <div class="d-flex align-items-center justify-content-between mb-3" style="padding: 5px; border-bottom: 2px solid #000;">
            <h2 class="mb-0" style="color: black; border-bottom: none; padding-bottom: 0px;">Listado de Horarios</h2>
            <asp:Button ID="btnAgregarCurso" runat="server" Text="Agregar Horario" CssClass="btn btn-primary" data-bs-toggle="modal" data-bs-target="#horarioModal" OnClientClick="return false;"/>
        </div>
        <asp:GridView ID="gvHorarios" runat="server" AutoGenerateColumns="False" CssClass="table table-hover table-responsive table-striped table-bordered">
            <Columns>
                <asp:BoundField DataField="dia" HeaderText="Día" />
                <asp:BoundField DataField="horaInicio" HeaderText="Hora de Inicio" />
                <asp:BoundField DataField="horaFin" HeaderText="Hora de Fin" />
                <asp:TemplateField HeaderText="Sección">
                    <ItemTemplate>
                        <%# Convert.ToChar(Eval("seccionAcademica.seccion")).ToString() %>
                    </ItemTemplate>
                </asp:TemplateField>
                <asp:TemplateField HeaderText="Acciones">
                <ItemTemplate>
                    <asp:LinkButton ID="lnkDelete" runat="server" 
                        CommandArgument='<%# Eval("idHoraAcademica") %>' 
                        CssClass="btn btn-danger btn-sm" 
                        OnClick="lbEliminar_Click">
                        <i class="fa-solid fa-trash"></i> Eliminar
                    </asp:LinkButton>
                </ItemTemplate>
            </asp:TemplateField>
                </Columns>
        </asp:GridView>
        <div class="d-flex justify-content-between">
            <asp:Button ID="btnRegresar" runat="server" Text="Regresar" OnClick="btnRegresar_Click" CssClass="btn btn-primary" />
        </div>
    </div>

    <div class="modal fade" id="horarioModal" tabindex="-1" aria-labelledby="horarioModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="horarioModalLabel">Agregar Horario</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <label for="ddlDia" class="form-label">Día</label>
                    <asp:DropDownList ID="ddlDia" runat="server" CssClass="form-select"></asp:DropDownList>
                
                    <label for="txtHoraInicio" class="form-label mt-2">Hora de Inicio</label>
                    <asp:TextBox ID="txtHoraInicio" runat="server" CssClass="form-control" TextMode="Time" />

                    <label for="txtHoraFin" class="form-label mt-2">Hora de Fin</label>
                    <asp:TextBox ID="txtHoraFin" runat="server" CssClass="form-control" TextMode="Time" />

                    <label for="ddlSeccion" class="form-label mt-2">Sección</label>
                    <asp:DropDownList ID="ddlSeccion" runat="server" CssClass="form-select"></asp:DropDownList>
                </div>
                <div class="modal-footer">
                    <asp:Button ID="btnGuardarHorario" runat="server" Text="Guardar" CssClass="btn btn-primary" OnClick="btnGuardarHorario_Click" />
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cerrar</button>
                </div>
            </div>
        </div>
    </div>
</asp:Content>





