document.addEventListener("DOMContentLoaded", function () {
    const ctx = document.getElementById('barchart').getContext('2d');
    const doughnutChart = new Chart(ctx, {
        type: 'doughnut',  // Cambiamos el tipo a 'doughnut'
        data: {
            labels: ['Atrasado', 'Cancelado', 'Pendiente'],
            datasets: [{
                label: '# of Votes',
                data: chartData,
                backgroundColor: [
                    '#FF6384', '#36A2EB', '#FFCE56'
                ],
                hoverBackgroundColor: [
                    '#FF6384', '#36A2EB', '#FFCE56'
                ]
            }]
        },
        options: {
            responsive: true,
            plugins: {
                legend: {
                    position: 'top',
                },
                title: {
                    display: true,
                    text: 'Distribución de Colores'
                }
            }
        }
    });
});

