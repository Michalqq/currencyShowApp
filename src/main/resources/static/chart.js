function chart(days, currency){
var dataExchange = new Array();
var labelExchange = new Array();
var ctx = document.getElementById('myChart').getContext('2d');
var myChart = new Chart(ctx, {
    type: 'line',
    data: {
        labels: [],
        datasets: [{
            label: 'last ' + days + ' days : ' + currency,
            data:[],
            backgroundColor: [
                'rgba(0, 134, 255, 0.3)'
            ],
            borderColor: [
                'rgba(0, 134, 255, 0.3)'
            ],
            borderWidth: 1
        }]
    },
    options: {
        scales: {
            yAxes: [{
                ticks: {
                    beginAtZero: false
                }
            }]
        }
    }
});
$.ajax({
            url: "http://localhost:8082//lastexchangerates/" + days + "/" + currency
        }).then(function (data) {
            for (let i=0; i < days; i++) {
                dataExchange[i] = parseFloat(JSON.stringify(data.rates[i].bid));
                labelExchange[i] = JSON.stringify(data.rates[i].effectiveDate);
            }
                myChart.data.datasets[0].data = dataExchange;
                myChart.data.labels = labelExchange;
                myChart.update();
        });
}