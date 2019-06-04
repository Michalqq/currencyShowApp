
    function currencyApi(currency) {
        $.ajax({
            url: "http://localhost:8080/exchangerates/" + currency
        }).then(function (data) {
           // alert(JSON.stringify(data));
            $('#currency1').text(data.currency);
            $('#exchange-rate').text(data.rates[0].bid + 'zł');


        });
    }

