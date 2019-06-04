package com.example.currencyshowapp.controller;

import com.example.currencyshowapp.repository.CurrencyRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
@Controller
public class HomeController {

    @GetMapping("/")
    public  String home (ModelMap modelMap){
        modelMap.put("currencies", CurrencyRepository.getCurrenciesList());
        return "home";
    }
    @GetMapping("/nbp")
    public String getNbp(ModelMap modelMap){
        modelMap.put("currencies", Arrays.asList("eur", "usd"));
        return "nbp";
    }
}
