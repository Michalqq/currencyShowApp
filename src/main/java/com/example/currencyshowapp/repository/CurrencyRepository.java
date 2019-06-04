package com.example.currencyshowapp.repository;

import com.example.currencyshowapp.model.Currency;

import java.util.LinkedList;
import java.util.List;

public class CurrencyRepository {
    private static List<Currency> currencies;

    private CurrencyRepository() {
        currencies = new LinkedList<>();
        Currency currency = new Currency();
        currencies.add(currency.getNewCurrency("dolar amerykański", "USD"));
        currencies.add(currency.getNewCurrency("euro", "EUR"));
        currencies.add(currency.getNewCurrency("funt szterling", "GBP"));
        currencies.add(currency.getNewCurrency("frank szwajcarski", "CHF"));
        currencies.add(currency.getNewCurrency("hrywna (Ukraina)", "UAH"));
    }

    public static synchronized List<Currency> getCurrenciesList() {
        if (currencies == null) {
            new CurrencyRepository();
        }
        return currencies;
    }

}
