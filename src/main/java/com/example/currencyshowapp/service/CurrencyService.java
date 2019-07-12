package com.example.currencyshowapp.service;

import com.example.currencyshowapp.model.Currency;
import com.example.currencyshowapp.model.Rate;
import com.example.currencyshowapp.repository.CurrencyRepository;

import java.util.List;

public interface CurrencyService {
    Currency getCurrency(String currency);

    Currency getLastExchanges(String currency, int days);

    List<Currency> getAllCurrencies();
}
