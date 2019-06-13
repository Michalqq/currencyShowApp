package com.example.currencyshowapp.service;

import com.example.currencyshowapp.model.Currency;
import com.example.currencyshowapp.model.Rate;
import com.example.currencyshowapp.repository.CurrencyRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class NbpService implements CurrencyService {

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
    public List<Currency> getAllCurrencies() {
        String apiPath = "http://api.nbp.pl/api/exchangerates/tables/A/?format=json";
        return (List<Currency>) new RestTemplate().getForObject(apiPath, Rate.class);
    }


}
