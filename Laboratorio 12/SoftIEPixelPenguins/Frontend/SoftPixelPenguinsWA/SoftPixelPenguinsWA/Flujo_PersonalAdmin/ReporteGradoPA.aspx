<%@ Page Title="" Language="C#" MasterPageFile="~/SoftPixelPenguins.Master" AutoEventWireup="true" CodeBehind="ReporteGradoPA.aspx.cs" Inherits="SoftPixelPenguinsWA.ReporteGradoPA" %>
<asp:Content ID="Content1" ContentPlaceHolderID="cphScripts" runat="server">
    <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
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

<asp:Content ID="Content2" ContentPlaceHolderID="cphContenido" runat="server">
    <div class="d-flex align-items-center justify-content-between" style="padding: 5px; border-bottom: 2px solid #000;">
        <h2 class="mb-0" style="color: black; border-bottom: none; padding-bottom: 0px;">Reporte de Matriculados por Grado</h2>
        <asp:Button ID="btnDownloadPDF" runat="server" Text="Visualizar PDF" OnClick="btnDownloadPDF_Click" OnClientClick="openInNewTab();" CssClass="btn btn-primary"/>
    </div>
    <canvas id="barChart" width="400" height="200" style="background-color: white;"></canvas>
    <h2 style="color: black; padding-top: 5px;">Detalle</h2>
    <asp:GridView ID="gridReporte" runat="server" AutoGenerateColumns="true" CssClass="table table-bordered border-black" HeaderStyle-CssClass="table-secondary text-center border-black"  ></asp:GridView>
    <asp:HiddenField ID="hdnChartImage" runat="server" />
    <asp:HiddenField ID="hdnLabels" runat="server" />
    <asp:HiddenField ID="hdnData" runat="server" />
    <script>
        function openInNewTab() {
            window.document.forms[1].target = '_blank';
            setTimeout(function () { window.document.forms[0].target = ''; }, 0);
        }

        function createChart() {
            const labels = JSON.parse(document.getElementById('<%= hdnLabels.ClientID %>').value || '[]');
            const data = JSON.parse(document.getElementById('<%= hdnData.ClientID %>').value || '{}');

            const barCtx = document.getElementById('barChart').getContext('2d');
            new Chart(barCtx, {
                type: 'bar',
                data: {
                    labels: labels,
                    datasets: [
                        {
                            label: 'Cantidad de Alumnos',
                            data: data.alumnos,
                            backgroundColor: 'rgba(54, 162, 235, 0.6)',
                            borderColor: 'rgba(54, 162, 235, 1)',
                            borderWidth: 1
                        },
                        {
                            label: 'Vacantes',
                            data: data.vacantes,
                            backgroundColor: 'rgba(255, 99, 132, 0.6)',
                            borderColor: 'rgba(255, 99, 132, 1)',
                            borderWidth: 1
                        }
                    ]
                },
                options: {
                    scales: {
                        y: {
                            beginAtZero: true,
                            max: Math.max(...data.alumnos, ...data.vacantes) * 1.2 
                        }
                    }
                }
            });
        }

        document.getElementById('<%= btnDownloadPDF.ClientID %>').addEventListener('click', function () {
            const canvas = document.getElementById('barChart');
            const chartImageBase64 = canvas.toDataURL("image/png");
            document.getElementById('<%= hdnChartImage.ClientID %>').value = chartImageBase64;
        });

        window.onload = createChart;
    </script>
</asp:Content>
