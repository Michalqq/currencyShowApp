package com.example.currencyshowapp.repository;

import com.example.currencyshowapp.model.Currency;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.LinkedList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class CurrencyRepository {
    private static List<Currency> currencies;

    private static List<Currency> currenciesFromApi;

    private CurrencyRepository() {
        currencies = new LinkedList<>();
        Currency currency = new Currency();
        currencies.add(currency.getNewCurrency("dolar amerykański", "USD"));
        currencies.add(currency.getNewCurrency("euro", "EUR"));
        currencies.add(currency.getNewCurrency("funt szterling", "GBP"));
        currencies.add(currency.getNewCurrency("frank szwajcarski", "CHF"));
    }

    public static synchronized List<Currency> getCurrenciesList() {
        if (currencies == null) {
            new CurrencyRepository();
        }
        return currencies;
    }

}
