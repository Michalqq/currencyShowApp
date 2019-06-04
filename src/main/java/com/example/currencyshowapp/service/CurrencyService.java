package com.example.currencyshowapp.service;

import com.example.currencyshowapp.model.Currency;

public interface CurrencyService {
    Currency getCurrency(String currency);

    Currency getLastExchanges(String currency, int days);
}
