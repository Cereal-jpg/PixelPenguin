<%@ Page Title="" Language="C#" MasterPageFile="~/SoftPixelPenguins.Master" AutoEventWireup="true" CodeBehind="MisPagos.aspx.cs" Inherits="SoftPixelPenguinsWA.MisPagos" %>

<asp:Content ID="Content1" ContentPlaceHolderID="cphScripts" runat="server">
    Reporte
    <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
    <style>
        /* Add any specific styles here */
    </style>
</asp:Content>

<asp:Content ContentPlaceHolderID="menuItem1" runat="server">
    <a href="IndexAlumno.aspx"><i class="fa-solid fa-home"></i>Inicio</a>
</asp:Content>
<asp:Content ContentPlaceHolderID="menuItem2" runat="server">
    <a href="ListarCursos.aspx"><i class="fa-solid fa-book"></i>Mis cursos</a>
</asp:Content>
<asp:Content ContentPlaceHolderID="menuItem3" runat="server">
    <a href="ReporteNotasAlumno.aspx"><i class="fa-solid fa-bar-chart"></i>Reporte de Notas</a>
</asp:Content>
<asp:Content ContentPlaceHolderID="menuItem4" runat="server">
    <a href="MatriculaAlumno-0.aspx"><i class="fa-solid fa-archive"></i>Matrícula Online</a>
</asp:Content>
<asp:Content ContentPlaceHolderID="menuItem5" runat="server">
    <a href="PerfilAlumno.aspx"><i class="fa-solid fa-user"></i>Mi Perfil</a>
</asp:Content>

<asp:Content ID="Content2" ContentPlaceHolderID="cphContenido" runat="server">
    <h2 style="color: black;">Reporte de Matriculados por Grado</h2>
    <asp:GridView ID="gridReporte" runat="server" AutoGenerateColumns="true" CssClass="table table-bordered border-black" HeaderStyle-CssClass="table-secondary text-center border-black"></asp:GridView>
    
    <div class="d-flex align-items-center justify-content-between" style="padding: 5px; border-bottom: 2px solid #000;">
        <h2 class="mb-0" style="color: black; border-bottom: none; padding-bottom: 0px;">Gráfico de Barras</h2>
        <asp:Button ID="btnDownloadPDF" runat="server" Text="Descargar PDF" OnClick="btnDownloadPDF_Click" CssClass="btn btn-primary"/>
    </div>
    
    <canvas id="barChart" width="400" height="200" style="background-color: white;"></canvas>
    <asp:HiddenField ID="hdnChartImage" runat="server" />
    <asp:HiddenField ID="hdnLabels" runat="server" />
    <asp:HiddenField ID="hdnData" runat="server" />
    
    <script>
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
                            data: data.alumnos || [],
                            backgroundColor: 'rgba(54, 162, 235, 0.6)',
                            borderColor: 'rgba(54, 162, 235, 1)',
                            borderWidth: 1
                        },
                        {
                            label: 'Vacantes',
                            data: data.vacantes || [],
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
                            max: Math.max(...(data.alumnos || [0]), ...(data.vacantes || [0])) * 1.2
                        }
                    }
                }
            });
        }

        document.addEventListener('DOMContentLoaded', function () {
            createChart();
            document.getElementById('<%= btnDownloadPDF.ClientID %>').addEventListener('click', function () {
                const canvas = document.getElementById('barChart');
                const chartImageBase64 = canvas.toDataURL("image/png");
                document.getElementById('<%= hdnChartImage.ClientID %>').value = chartImageBase64;
            });
        });
    </script>
</asp:Content>
