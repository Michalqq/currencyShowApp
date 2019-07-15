package com.example.currencyshowapp.service;

import com.example.currencyshowapp.model.Currency;
import com.example.currencyshowapp.model.Rate;
import com.example.currencyshowapp.repository.CurrencyRepository;
import org.json.JSONException;

import java.util.List;

public interface CurrencyService {
    Currency getCurrency(String currency);

    Currency getLastExchanges(String currency, int days);

    Currency getAllCurrencies();

    void onSuccess();

    void parseJson(StringBuffer sb) throws JSONException;
}
