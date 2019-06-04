package com.example.currencyshowapp.repository;

import com.example.currencyshowapp.model.Currency;

import java.util.LinkedList;
import java.util.List;

public class CurrencyRepository {
    private static List<Currency> currencies;

    private CurrencyRepository() {
        currencies = new LinkedList<>();
        currencies.add(new Currency("dolar amerykański", "USD"));
        currencies.add(new Currency("euro", "EUR"));
        currencies.add(new Currency("funt szterling", "GBP"));
        currencies.add(new Currency("frank szwajcarski", "CHF"));
        currencies.add(new Currency("hrywna (Ukraina)", "UAH"));
    }

    public static synchronized List<Currency> getCurrenciesList() {
        if (currencies == null) {
            new CurrencyRepository();
        }
        return currencies;
    }

}
