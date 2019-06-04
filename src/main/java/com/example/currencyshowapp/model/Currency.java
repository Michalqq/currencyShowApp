package com.example.currencyshowapp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class Currency {

    private String currency;

    private String code;

    private List<Rate> rates = new ArrayList<>();

    public Currency getNewCurrency(String currency, String code) {
        Currency currencyNew = new Currency();
        currencyNew.setCurrency(currency);
        currencyNew.setCode(code);
        return currencyNew;
    }

}
