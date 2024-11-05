<%@ Page Language="C#" MasterPageFile="~/SoftPixelPenguins.Master" AutoEventWireup="true" CodeBehind="Reportes.aspx.cs" Inherits="SoftPixelPenguinsWA.Reportes" %>

<asp:Content ID="Content1" ContentPlaceHolderID="cphScripts" runat="server">
    <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
</asp:Content>
<asp:Content ContentPlaceHolderID="menuItem1" runat="server">
    <a href="IndexAdmin.aspx"><i class="fa-solid fa-home"></i>Pagina principal</a>
</asp:Content>
<asp:Content ContentPlaceHolderID="menuItem2" runat="server">
    <a href="Reportes.aspx"><i class="fa-solid fa-book"></i>Reportes</a>
</asp:Content>
<asp:Content ContentPlaceHolderID="menuItem3" runat="server">
    <a href="ListarCursosAlumno.aspx"><i class="fa-solid fa-search"></i>Busquedas</a>
</asp:Content>
<asp:Content ContentPlaceHolderID="menuItem4" runat="server">
    <a href="GestionarSolicitudes.aspx"><i class="fa-solid fa-plus-circle"></i>Gestionar Solicitudes</a>
</asp:Content>

<asp:Content ID="Content2" ContentPlaceHolderID="cphContenido" runat="server">
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
