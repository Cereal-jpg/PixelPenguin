// Datos para el gráfico circular
const dataDoughnut = {
    labels: ['Pagado', 'Pendiente', 'Atrasado'],
    datasets: [{
        data: [30, 50, 20], // Ajusta los valores según tu fuente de datos
        backgroundColor: ['#36A2EB', '#FFCE56', '#FF6384'],
        hoverBackgroundColor: ['#36A2EB', '#FFCE56', '#FF6384']
    }]
};

// Configuración del gráfico circular
const configDoughnut = {
    type: 'doughnut',
    data: dataDoughnut,
    options: {
        responsive: true,
        plugins: {
            legend: {
                position: 'top',
            },
            title: {
                display: true,
                text: 'Distribución de Pagos'
            }
        }
    },
};

// Inicializar el gráfico circular
const doughnutChart = new Chart(
    document.getElementById('doughnut'),
    configDoughnut
);
