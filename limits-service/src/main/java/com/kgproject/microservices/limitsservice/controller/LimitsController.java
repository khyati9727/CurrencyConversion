package com.kgproject.microservices.limitsservice.controller;

import com.kgproject.microservices.limitsservice.configuration.Configuration;
import com.kgproject.microservices.limitsservice.dto.Limits;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitsController {

    @Autowired
    Configuration configuration;

    @GetMapping("/limits")
    public Limits getLimits(){
        return new Limits(configuration.getMinimum(),configuration.getMaximum());
    }
}
