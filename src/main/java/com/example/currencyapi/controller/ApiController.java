package com.example.currencyapi.controller;

import com.example.currencyapi.model.Currency;
import com.example.currencyapi.service.CurrencyService;
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
    public Currency index(@PathVariable String code){
    return currencyService.getCurrency(code);
    }

}
