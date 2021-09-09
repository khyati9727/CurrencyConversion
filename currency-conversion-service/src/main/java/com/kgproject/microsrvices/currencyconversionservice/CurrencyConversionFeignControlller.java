package com.kgproject.microsrvices.currencyconversionservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;

@RestController
@RequestMapping("currency-conversion-feign")
public class CurrencyConversionFeignControlller {

    @Autowired
    CurrencyExchangeProxy currencyExchangeProxy;

    @GetMapping("from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversion calculateCurrencyConversion(@PathVariable  String to,@PathVariable String from,@PathVariable Integer quantity){
        CurrencyConversion currencyConversion=currencyExchangeProxy.currencyExchange(from,to);
        currencyConversion.setQuantity(new BigDecimal(quantity));
        currencyConversion.setTotalCalculatedAmount(currencyConversion.getQuantity().multiply(currencyConversion.getConversionMultiple()));

        return currencyConversion;
    }

}
