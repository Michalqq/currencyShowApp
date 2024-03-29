package com.example.currencyshowapp.service;

import com.example.currencyshowapp.model.Currency;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class NbpService implements CurrencyService  {

    @Override
    public Currency getCurrency(String code) {
        String apiPath = "http://api.nbp.pl/api/exchangerates/rates/C/" + code + "/?format=json";
        return new RestTemplate().getForObject(apiPath, Currency.class);
    }

    @Override
    public Currency getLastExchanges(String currency, int days) {
        String apiPath = "http://api.nbp.pl/api/exchangerates/rates/C/" + currency + "/last/" + days + "/?format=json";
        return new RestTemplate().getForObject(apiPath, Currency.class);
    }

    @Override
    public Currency getAllCurrencies() {
        return null;
    }


//    @Override
//    public List<Currency> getAllCurrencies() {
//        String apiPath = "http://api.nbp.pl/api/exchangerates/tables/A/?format=json";
//        return new RestTemplate().getForObject(apiPath, Currency.class);
//    }

}
