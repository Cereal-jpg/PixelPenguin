<%@ Page Title="" Language="C#" MasterPageFile="~/SoftPixelPenguins.Master" AutoEventWireup="true" CodeBehind="ReportesAdmin.aspx.cs" Inherits="SoftPixelPenguinsWA.ReportesAdmin" %>
<asp:Content ID="Content1" ContentPlaceHolderID="cphTitulo" runat="server">
    Reporte - Administrador
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="cphScripts" runat="server">
</asp:Content>
<asp:Content ContentPlaceHolderID="menuItem1" runat="server">
    <a href="IndexAdmin.aspx"><i class="fa-solid fa-home"></i>Inicio</a>
</asp:Content>
<asp:Content ContentPlaceHolderID="menuItem2" runat="server">
    <a href="ReportesAdmin.aspx"><i class="fa-solid fa-book"></i>Reportes</a>
</asp:Content>
<asp:Content ContentPlaceHolderID="menuItem3" runat="server">
    <a href="BusquedaAdmin.aspx"><i class="fa-solid fa-search"></i>Busqueda</a>
</asp:Content>
<asp:Content ContentPlaceHolderID="menuItem4" runat="server">
    <a href="AgregarPlanAdmin.aspx"><i class="fa-solid fa-folder-plus"></i>Agregar Plan</a>
</asp:Content>
<asp:Content ContentPlaceHolderID="menuItem5" runat="server">
    <a href="GestionarUsuariosAdmin.aspx"><i class="fa-solid fa-users"></i>Gestionar Usuarios</a>
</asp:Content>
<asp:Content ContentPlaceHolderID="menuItem6" runat="server">
    <a href="GestionarSolicitudesAdmin.aspx"><i class="fa-solid fa-user-plus"></i>Gestionar Solicitudes</a>
</asp:Content>
<asp:Content ContentPlaceHolderID="menuItem7" runat="server">
    <a href="MiPerfilAdmin.aspx"><i class="fa-solid fa-user"></i>Mi Perfil</a>
</asp:Content>

<asp:Content ID="Content3" ContentPlaceHolderID="cphContenido" runat="server">
    <h2 style="color: black;">Reportes</h2>
    <div class="container-matricula">
        <div class="form-container">
            <h2 style="color: black; font-size:20px">Consultar Reportes</h2>
            <div class="row">
                <div class="col-md-12">
                    <asp:Label ID="lblReportes" runat="server" Text="Tipo de Reporte:" CssClass="col-form-label" ></asp:Label>
                    <div class="form-control d-flex justify-content-center">
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
             </div>
            <div class="button-container">
                <asp:Button ID="btnEmitirReporte" runat="server" Text="Emitir Reporte" OnClick="btnEmitirReporte_Click" CssClass="btn btn-primary"/>
            </div>
        </div>
    </div>
</asp:Content>
