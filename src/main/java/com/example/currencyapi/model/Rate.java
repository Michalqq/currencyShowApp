package com.example.currencyapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.time.LocalDate;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class Rate {
    private Double bid;

    private LocalDate effectiveDate;
}
