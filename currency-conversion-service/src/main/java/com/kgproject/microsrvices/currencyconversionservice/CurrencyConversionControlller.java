package com.kgproject.microsrvices.currencyconversionservice;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;

@RestController
@RequestMapping("currency-conversion")
public class CurrencyConversionControlller {

    @GetMapping("from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversion calculateCurrencyConversion(@PathVariable  String to,@PathVariable String from,@PathVariable Integer quantity){
        HashMap<String,String> uriVariables=new HashMap<>();
        uriVariables.put("from",from);
        uriVariables.put("to",to);

        ResponseEntity<CurrencyConversion> response=new RestTemplate().getForEntity("http://localhost:8000/currency-exchange/from/{from}/to/{to}",
                CurrencyConversion.class,uriVariables);

        CurrencyConversion currencyConversion=response.getBody();
        currencyConversion.setQuantity(new BigDecimal(quantity));
        currencyConversion.setTotalCalculatedAmount(currencyConversion.getQuantity().multiply(currencyConversion.getConversionMultiple()));

        return currencyConversion;
    }

}
