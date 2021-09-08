package com.kgproject.microsrvices.currencyconversionservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class CurrencyExchangeController {

    @Autowired
    CurrencyExchangeDAO currencyExchangeDAO;

    @Autowired
    private Environment environment;

    @GetMapping("currency-exchange/from/{from}/to/{to}")
    public CurrencyExchange currencyExchange(@PathVariable String from,@PathVariable String to) throws Exception {
        String port=environment.getProperty("local.server.port");
        CurrencyExchange currencyExchange= currencyExchangeDAO.findByToAndFrom(to,from);
        if (currencyExchange==null)
            throw new Exception();
        currencyExchange.setEnvironment(port);
        return currencyExchange;
    }
}
