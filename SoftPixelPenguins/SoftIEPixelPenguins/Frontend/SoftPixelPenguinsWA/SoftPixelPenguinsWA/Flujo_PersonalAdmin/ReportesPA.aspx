<%@ Page Title="" Language="C#" MasterPageFile="~/SoftPixelPenguins.Master" AutoEventWireup="true" CodeBehind="ReportesPA.aspx.cs" Inherits="SoftPixelPenguinsWA.ReportesPA" %>
<asp:Content ID="Content1" ContentPlaceHolderID="cphTitulo" runat="server">
    Reportes - Personal Administrativo
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
    <h2 style="color: black;">Reportes</h2>
    <div class="container-matricula">
        <div class="form-container">
            <h2 style="color: black; font-size:20px">Consultar Reportes</h2>
            <div class="row d-flex align-items-center">
                 <asp:Label ID="lblReportes" runat="server" Text="Tipo de Reporte:" CssClass="col-form-label" ></asp:Label>
                <div class="col-md-10">
                    <div class="form-control d-flex justify-content-start w-100">
                        <div class="form-check form-check-inline m-auto">
                            <input id="rbNotas" class="form-check-input" type="radio" runat="server" name="reporte"/>
                            <label id="lblNotas" class="form-check-label" for="cphContenido_rbNotas">Notas por Grado Académico</label>
                        </div>
                        <div class="form-check form-check-inline m-auto">
                            <input id="rbMatriculas" class="form-check-input" type="radio" runat="server" name="reporte"/>
                            <label id="lblMatriculas" class="form-check-label" for="cphContenido_rbMatriculas">Matrículas por Grado</label>
                        </div>
                        <div class="form-check form-check-inline m-auto">
                            <input id="rbPensiones" class="form-check-input" type="radio" runat="server" name="reporte"/>
                            <label id="lblPensiones" class="form-check-label" for="cphContenido_rbPensiones">Pensiones por Grado</label>
                        </div>
                    </div>
                </div>
                <div class="col-md-2 d-flex justify-content-end">
                    <asp:DropDownList ID="ddlGrados" runat="server" CssClass="form-select me-2" style="width: 200px;" AutoPostBack="true">
                    </asp:DropDownList>
                </div>
             </div>
            <div class="button-container">
                <asp:Button ID="btnEmitirReporte" runat="server" Text="Emitir Reporte" OnClick="btnEmitirReporte_Click" CssClass="btn btn-primary"/>
            </div>
        </div>
    </div>
</asp:Content>



























