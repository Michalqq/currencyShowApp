package com.example.currencyshowapp.controller;

import com.example.currencyshowapp.model.Currency;
import com.example.currencyshowapp.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


/*
    RestController adnostacja daje to, że:
    @Controller
    oraz do każdej metody = akcji kontrollera dorzuca @ResponseBody
 */

@RestController
public class ApiController {

    @Autowired
    private CurrencyService currencyService;

    @GetMapping("/exchangerates/{code}")
    public Currency index(@PathVariable String code) {
        return currencyService.getCurrency(code);
    }

    @GetMapping("/lastexchangerates/{days}/{code}")
    public Currency index(@PathVariable String code, @PathVariable int days) {
        return currencyService.getLastExchanges(code, days);
    }
}
