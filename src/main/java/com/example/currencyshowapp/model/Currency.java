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

    public Currency(String currency, String code) {
        this.currency = currency;
        this.code = code;
    }

}
