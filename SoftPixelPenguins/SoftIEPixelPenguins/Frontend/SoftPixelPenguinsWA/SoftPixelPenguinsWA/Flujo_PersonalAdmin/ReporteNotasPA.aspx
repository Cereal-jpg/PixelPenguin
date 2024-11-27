<%@ Page Title="" Language="C#" MasterPageFile="~/SoftPixelPenguins.Master" AutoEventWireup="true" CodeBehind="ReporteNotasPA.aspx.cs" Inherits="SoftPixelPenguinsWA.ReporteNotasPA" %>
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
    <h2 style="font-family: Arial, sans-serif; color: #333;">Notas Finales por Grado Académico</h2>
    <div style="max-width: 600px; margin: 0 auto; text-align: center;">
        <canvas id="graficoNotas" width="400" height="400"></canvas>
    </div>
    <h2 style="font-family: Arial, sans-serif; color: #333;">Detalle</h2>
    <asp:GridView ID="gvAlumnos" runat="server" AutoGenerateColumns="False" CssClass="table table-hover table-responsive table-striped table-bordered" >
        <Columns>
            <asp:BoundField DataField="codigoAlumno" HeaderText="Código" SortExpression="codigoAlumno" />
        <asp:BoundField DataField="nombreCompleto" HeaderText="Nombre Completo" SortExpression="nombreCompleto" />
        <asp:BoundField DataField="notaFinal" HeaderText="Nota Final" SortExpression="notaFinal" />
        </Columns>
    </asp:GridView>
    <script>
        function generarGrafico(labels, data) {
            const ctx = document.getElementById('graficoNotas').getContext('2d');
            new Chart(ctx, {
                type: 'pie',
                data: {
                    labels: labels,
                    datasets: [{
                        data: data,
                        backgroundColor: ['#A8DADC', '#B7E4C7', '#FFED8A', '#F7A8A8'], 
                        hoverBackgroundColor: ['#76C7C0', '#94D3AC', '#FFE34E', '#F28482'], 
                        borderWidth: 0
                    }]
                },
                options: {
                    responsive: true,
                    plugins: {
                        legend: {
                            position: 'bottom',
                            labels: {
                                font: {
                                    size: 14,
                                    family: 'Arial, sans-serif'
                                },
                                color: '#333' // Color de texto de la leyenda
                            }
                        },
                        tooltip: {
                            callbacks: {
                                label: function (context) {
                                    return `${context.label}: ${context.raw}`;
                                }
                            },
                            backgroundColor: '#FFFFFF',
                            titleColor: '#333',
                            bodyColor: '#333',
                            borderColor: '#ccc',
                            borderWidth: 1,
                            padding: 10
                        }
                    }
                }
            });
        }
    </script>
</asp:Content>

