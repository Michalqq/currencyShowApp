package com.example.currencyshowapp.controller;

import com.example.currencyshowapp.model.Currency;
import com.example.currencyshowapp.repository.CurrencyRepository;
import com.example.currencyshowapp.service.NbpService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.List;

@Controller
public class HomeController {

    @GetMapping("/")
    public  String home (ModelMap modelMap){
       // List<Currency> currenciesAll= (List<Currency>) new NbpService().getAllCurrencies();
        modelMap.put("currencies", CurrencyRepository.getCurrenciesList());
        return "home";
    }
    @GetMapping("/nbp")
    public String getNbp(ModelMap modelMap){
        modelMap.put("currencies", Arrays.asList("eur", "usd"));
        return "nbp";
    }
}
