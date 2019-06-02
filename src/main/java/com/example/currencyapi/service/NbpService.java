package com.example.currencyapi.service;

import com.example.currencyapi.model.Currency;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class NbpService implements CurrencyService {


    @Override
    public Currency getCurrency(String code) {
        String apiPath = "http://api.nbp.pl/api/exchangerates/rates/C/" + code + "/?format=json";
        return new RestTemplate().getForObject(apiPath,Currency.class);
    }
}
