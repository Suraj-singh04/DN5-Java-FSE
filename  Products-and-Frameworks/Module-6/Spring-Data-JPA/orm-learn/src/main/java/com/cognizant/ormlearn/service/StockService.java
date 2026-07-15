package com.cognizant.ormlearn.service;

import com.cognizant.ormlearn.entity.Stock;
import com.cognizant.ormlearn.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
public class StockService {

    @Autowired
    private StockRepository repository;

    public List<Stock> getFacebookStocks() {
        return repository.findByCode("FB");
    }

    public List<Stock> getStocksOnDate(LocalDate date) {
        return repository.findByTradeDate(date);
    }

    public List<Stock> getHighClosingStocks() {
        return repository.findByClosePriceGreaterThan(new BigDecimal("300"));
    }

    public List<Stock> getTopVolumes() {
        return repository.findTop3ByOrderByVolumeDesc();
    }
}