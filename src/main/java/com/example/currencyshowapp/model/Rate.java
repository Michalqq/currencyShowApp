package com.example.currencyshowapp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class Rate {
    private Double bid;

    private LocalDate effectiveDate;

    private List<Currency> currencies = new ArrayList<>();
}
