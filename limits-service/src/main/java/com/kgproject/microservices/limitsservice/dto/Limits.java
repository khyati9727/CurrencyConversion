package com.kgproject.microservices.limitsservice.dto;

public class Limits {

    private Integer minimum;
    private Integer maximum;

    public Integer getMinimum() {
        return minimum;
    }

    public Limits() {
    }

    public Limits(Integer minimum, Integer maximum) {
        this.minimum = minimum;
        this.maximum = maximum;
    }

    public Integer getMaximum() {
        return maximum;
    }
}
