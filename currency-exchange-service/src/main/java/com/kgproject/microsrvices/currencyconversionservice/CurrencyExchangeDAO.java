package com.kgproject.microsrvices.currencyconversionservice;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrencyExchangeDAO extends JpaRepository<CurrencyExchange,Long> {
    CurrencyExchange findByToAndFrom(String to,String from);
}
