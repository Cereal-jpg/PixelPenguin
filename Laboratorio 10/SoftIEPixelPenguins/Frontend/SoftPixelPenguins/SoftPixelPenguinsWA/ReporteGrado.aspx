<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="ReporteGrado.aspx.cs" Inherits="SoftPixelPenguinsWA.ReporteGrado" %>

<!DOCTYPE html>
<html>
<head runat="server">
    <title>Reporte de Matriculados por Grado</title>
    <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
    <link rel="stylesheet" href="Content/bootstrap.min.css">
</head>
<body>
    <form id="form1" runat="server">
        <h2>Reporte de Matriculados por Grado</h2><hr>
        <asp:GridView ID="gridReporte" runat="server" AutoGenerateColumns="true" CssClass="table table-bordered border-black" HeaderStyle-CssClass="table-secondary text-center border-black"  ></asp:GridView>
        <h2>Gráfico de Barras</h2><hr>            
        <canvas id="barChart" width="400" height="200"></canvas>
        <div class="d-grid gap-2 d-md-flex justify-content-md-end" style="padding: 5px;">
          <asp:Button ID="btnDownloadPDF" runat="server" Text="Descargar PDF" OnClick="btnDownloadPDF_Click" CssClass="btn btn-primary"/>
        </div>
        <asp:HiddenField ID="hdnChartImage" runat="server" />
        <asp:HiddenField ID="hdnLabels" runat="server" />
        <asp:HiddenField ID="hdnData" runat="server" />

        <script>
            function createChart() {
                const labels = JSON.parse(document.getElementById('<%= hdnLabels.ClientID %>').value || '[]');
                const data = JSON.parse(document.getElementById('<%= hdnData.ClientID %>').value || '[]');

                const barCtx = document.getElementById('barChart').getContext('2d');
                new Chart(barCtx, {
                    type: 'bar',
                    data: {
                        labels: labels,
                        datasets: [{
                            label: '% Matriculados',
                            data: data,
                            backgroundColor: 'rgba(54, 162, 235, 0.6)',
                            borderColor: 'rgba(54, 162, 235, 1)',
                            borderWidth: 1
                        }]
                    },
                    options: {
                        scales: {
                            y: {
                                beginAtZero: true,
                                max: 140
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
    </form>
</body>
</html>